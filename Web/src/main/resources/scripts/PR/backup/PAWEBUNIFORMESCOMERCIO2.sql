create or replace PACKAGE BODY            PAWEBUNIFORMESCOMERCIO2
AS
  /*************************************************************
   Proyecto:                           Uniformes
   Descripcion:                        Paquete para sistema de uniformes Div. Comercial
   Parametros de entrada:              No aplica
   Parametros de salida:               No aplica
   Parametros de entrada-salida        No aplica
   Precondiciones:                     Tener creado el esquema
   Creador:                            
   Fecha de creacion:                  
   *************************************************************/
  	vgErrCode   NUMBER(6)          := 0;  -- Variable para el manejo de errores codigo
    vgErrMsg    VARCHAR2(500 CHAR) := ''; -- Variable para el manejo de errores mensaje
    csgCero NUMBER(1):=0;
    csgUno NUMBER(1):=1; 
  
/*MODIFICACION*/  
FUNCTION FNCONSULTAPEDIDOSANTERIORES(
      paFechaInicial VARCHAR)  
  /*************************************************************
   Proyecto:                         Sistema de Uniformes
   Descripcion:                      Consulta datos de empleado
   Parametros de entrada:            paFechaInicial    Fecha inicial
   Parametros de salida:             curDatos         Cursor de referencia
   Parametros de entrada-salida      No aplica
   Precondiciones:                   Tener creado el esquema
   Creador:                          
   Fecha de creacion:                
  *************************************************************/
  RETURN rcgCursor
  IS
  curDatos rcgCursor;
  BEGIN  
    OPEN curDatos FOR
      SELECT FINUMPEDIDO,
            (SELECT FCNOMBRE 
            FROM UNIFORMES.TABITACORASOLICITUD
            INNER JOIN UNIFORMES.TATIENDAS
            ON TABITACORASOLICITUD.FIPAIS = TATIENDAS.FIPAIS
            AND TABITACORASOLICITUD.FCCANAL = TATIENDAS.FCCANAL 
            AND TABITACORASOLICITUD.FIIDSUCURSAL = TATIENDAS.FISUCURSAL 
            WHERE ROWNUM = 1)
            AS FCNOMBRETIENDA,
            FIIDSUCURSAL,
            TO_CHAR(FDFECHAEVENTO,'dd/mm/yyyy') AS FCFECHAEVENTO,
            FISKU,
            (SELECT FCDESCRIPCION 
            FROM UNIFORMES.TABITACORASOLICITUD 
            INNER JOIN UNIFORMES.TAPRENDAS 
            ON TABITACORASOLICITUD.FISKU = TAPRENDAS.FISKU 
            WHERE ROWNUM = 1)
            AS FCDESCRIPCION,
            (SELECT FICANTIDAD
            FROM UNIFORMES.TABITACORASOLICITUD 
            INNER JOIN UNIFORMES.TAPEDIDOSCD 
            ON TABITACORASOLICITUD.FIPAIS = TAPEDIDOSCD.FIPAIS
            AND TABITACORASOLICITUD.FCCANAL = TAPEDIDOSCD.FCCANAL
            AND TABITACORASOLICITUD.FIIDSUCURSAL = TAPEDIDOSCD.FIIDSUCURSAL
            AND TABITACORASOLICITUD.FINUMPEDIDO = TAPEDIDOSCD.FIPEDIDO
            AND TABITACORASOLICITUD.FISKU = TAPEDIDOSCD.FISKU
            WHERE ROWNUM = 1)
            AS FINUMEROPRENDAS
            
        FROM UNIFORMES.TABITACORASOLICITUD
       WHERE FDFECHAEVENTO = TO_DATE(paFechaInicial, 'dd/mm/yyyy'); 
       RETURN curDatos;
       
  END FNCONSULTAPEDIDOSANTERIORES;
  
FUNCTION FNCONSULTASOLICITUDES(
      paNumeroEmpleado UNIFORMES.TASOLICITUDES.FIIDEMPLEADO%TYPE, 
      paNumeroSolicitudes NUMBER)
  RETURN rcgCursor
  IS
  /*************************************************************
   Proyecto:                         Sistema de Uniformes
   Descripcion:                      Consulta de solicitudes
   Parametros de entrada:            Numero del empleado
   Parametros de salida:             Retorna las solicitudes del empleado
   Parametros de entrada-salida      No aplica
   Precondiciones:                   Tener creado el esquema
   Creador:                          Luis Rodriguez    
   Fecha de creacion:                16 de Septiembre del 2017
  *************************************************************/
  curDatos rcgCursor;
  BEGIN  
    OPEN curDatos FOR
    SELECT 
        TS.FIFOLIOSOLICITUD AS FIFOLIOSOLICITUD, --INT
        TO_CHAR(TS.FDFECHACAPTURA,'dd/mm/yyyy') AS FDFECHACAPTURA, --STRING 
        (SELECT TASOLICITUDESDETALLE.FISUCURSAL
         FROM UNIFORMES.TASOLICITUDESDETALLE 
         WHERE TASOLICITUDESDETALLE.FIFOLIOSOLICITUD = TS.FIFOLIOSOLICITUD 
         AND ROWNUM = 1) AS FISUCURSAL, --INT
        FNCONSULTANOMBRETIENDA(TS.FIFOLIOSOLICITUD) AS FCNOMBRE --STRING
        FROM (SELECT FIFOLIOSOLICITUD, FDFECHACAPTURA
        FROM TASOLICITUDES WHERE FIIDEMPLEADO = paNumeroEmpleado
        ORDER BY FDFECHACAPTURA DESC) TS 
        where rownum <= paNumeroSolicitudes;
    RETURN curDatos;
       
  END FNCONSULTASOLICITUDES;

FUNCTION FNCONSULTANOMBRETIENDA(
    paFolioSolicitud UNIFORMES.TASOLICITUDES.FIFOLIOSOLICITUD%TYPE)
    RETURN VARCHAR
    IS
    /*************************************************************
    Proyecto:                         Sistema de Uniformes
    Descripcion:                      Consulta el nombre de la tienda
    Parametros de entrada:            Folio de solicitud
    Parametros de salida:             Nombre de la tienda
    Parametros de entrada-salida      No aplica
    Precondiciones:                   Tener creado el esquema
    Creador:                          Luis Rodriguez    
    Fecha de creacion:                16 de Septiembre del 2017
    *************************************************************/
    nombreTienda VARCHAR(50);
    BEGIN
    SELECT TT.FCNOMBRE
     INTO nombreTienda
     FROM UNIFORMES.TATIENDAS TT
     INNER JOIN 
        (SELECT FISUCURSAL
         FROM UNIFORMES.TASOLICITUDESDETALLE 
         WHERE FIFOLIOSOLICITUD = paFolioSolicitud
         AND ROWNUM = 1) TSD 
         ON TT.FISUCURSAL = TSD.FISUCURSAL;
      RETURN nombreTienda;
    END FNCONSULTANOMBRETIENDA;

FUNCTION FNCONSULTASOLICITUD(
      paFolioSolicitud UNIFORMES.TASOLICITUDES.FIFOLIOSOLICITUD%TYPE)  
  RETURN rcgCursor
  IS
    /*************************************************************
    Proyecto:                         Sistema de Uniformes
    Descripcion:                      Consulta la solicitud
    Parametros de entrada:            Folio de solicitud
    Parametros de salida:             Datos de la tienda (Cursor)
    Parametros de entrada-salida      No aplica
    Precondiciones:                   Tener creado el esquema
    Creador:                          Luis Rodriguez
    Fecha de creacion:                16 de Septiembre del 2017
    *************************************************************/
  curDatos rcgCursor;
  BEGIN  
    OPEN curDatos FOR
    SELECT TBS.FINUMPEDIDO AS FINUMPEDIDO,
       TO_CHAR(TBS.FISKU) AS FISKU, 
       FNDEFINEDESCRIPCIONPRENDA(TBS.FISKU,TSD.FIIDTIPOPRENDA) AS FCDESCRIPCION,
       (SELECT FIREMISION FROM UNIFORMES.TAREMISIONESXPEDIDO WHERE FIPEDIDO=TBS.FINUMPEDIDO AND FISKU = TBS.FISKU) AS FIREMISION,
       TSD.FICANTIDAD AS FICANTIDAD,
       (CASE TBS.FIIDESTATUSNVO
         WHEN 0 THEN 'CANCELADO'
         WHEN 1 THEN 'PENDIENTE DE SOLICITAR A CD'
         WHEN 2 THEN 'SOLICITADO A CD'
         WHEN 3 THEN 'ATENDIDO EN CD'
         WHEN 4 THEN 'EN CAMINO A TIENDA'
         WHEN 5 THEN 'RECIBIDO EN TIENDA'
         WHEN 6 THEN 'ENTREGADO'
         END
       )as FIIDESTATUSNVO,
       TBS.FIIDDETALLE as FIIDDETALLE,
       TO_CHAR(TBS.FDFECHAEVENTO, 'dd/mm/yyyy HH24:MI:SS') as FDFECHAEVENTO -- FECHA DE EVENTO
       FROM UNIFORMES.TABITACORASOLICITUD TBS
       INNER JOIN (SELECT FIIDDETALLE, MAX(FDFECHAEVENTO) AS FDFECHAEVENTO FROM UNIFORMES.TABITACORASOLICITUD WHERE FIFOLIOSOLICITUD = paFolioSolicitud GROUP BY FIIDDETALLE) TBSM
       ON TBS.FIIDDETALLE = TBSM.FIIDDETALLE AND TBS.FDFECHAEVENTO = TBSM.FDFECHAEVENTO
       INNER JOIN (SELECT FICANTIDAD,FIFOLIOSOLICITUD,FIIDDETALLE,FIIDTIPOPRENDA FROM UNIFORMES.TASOLICITUDESDETALLE WHERE FIFOLIOSOLICITUD = paFolioSolicitud) TSD
       ON TBS.FIFOLIOSOLICITUD = TSD.FIFOLIOSOLICITUD AND TBS.FIIDDETALLE = TSD.FIIDDETALLE;
    RETURN curDatos;      
  END FNCONSULTASOLICITUD;

FUNCTION FNDEFINEDESCRIPCIONPRENDA(
    paSKU UNIFORMES.TABITACORASOLICITUD.FISKU%TYPE,
    paIDTipoPrenda UNIFORMES.TASOLICITUDESDETALLE.FIIDTIPOPRENDA%TYPE
)
    RETURN VARCHAR2
    IS
    /*************************************************************
    Proyecto:                         Sistema de Uniformes
    Descripcion:                      Retorna la descripcion de la prenda
    Parametros de entrada:            SKU de la tienda, Tipo de prenda
    Parametros de salida:             Retorna la descripcion en una cadena
    Parametros de entrada-salida      No aplica
    Precondiciones:                   Tener creado el esquema
    Creador:                          Luis Rodriguez
    Fecha de creacion:                16 de Septiembre del 2017
    *************************************************************/    
    descripcion VARCHAR2(50);
    BEGIN
        IF paSKU is NULL THEN
            SELECT FCDESCRIPCION 
            INTO descripcion
            FROM UNIFORMES.TATIPOSPRENDA
            WHERE FIIDTIPOPRENDA = paIDTipoPrenda;
        ELSE
            SELECT FCDESCRIPCION 
            INTO descripcion
            FROM UNIFORMES.TAPRENDAS 
            WHERE TAPRENDAS.FISKU = paSKU;
        END IF;
        RETURN descripcion;
    END FNDEFINEDESCRIPCIONPRENDA;

FUNCTION FNCONSULTASOLICITUDAVANCE(
    paFolioSolicitud UNIFORMES.TASOLICITUDES.FIFOLIOSOLICITUD%TYPE
)
  RETURN rcgCursor
  IS
  /*************************************************************
    Proyecto:                         Sistema de Uniformes
    Descripcion:                      Muestra el estatus de la solicitud
    Parametros de entrada:            Folio de la solicitud
    Parametros de salida:             Retorna los datos de la solicitud del avance
    Parametros de entrada-salida      No aplica
    Precondiciones:                   Tener creado el esquema
    Creador:                          Luis Rodriguez
    Fecha de creacion:                16 de Septiembre del 2017
  *************************************************************/   
  curDatos rcgCursor;
  calculoPorcentaje NUMBER(4,2);
  BEGIN  
    calculoPorcentaje := FNCALCULOPORCENTAJE(paFolioSolicitud);
    OPEN curDatos FOR
    SELECT TO_CHAR(CANCELADO * calculoPorcentaje,'990') || '%' AS FCPORCCANCELADO,
    TO_CHAR((CASE PENDIENTE
        WHEN 0 THEN 0
        ELSE PENDIENTE/2
     END) * calculoPorcentaje,'990') || '%' AS FCPORCPENDIENTE,
    TO_CHAR((CASE (PENDIENTE + SOLICITADO)
        WHEN 0 THEN 0
        ELSE (PENDIENTE + SOLICITADO)/3
     END) * calculoPorcentaje,'990') || '%' AS FCPORCSOLICITADO,
    TO_CHAR(ATENDIDO * calculoPorcentaje, '990') || '%' AS FCPORCATENDIDO,
    TO_CHAR(RECIBIDO * calculoPorcentaje,'990') || '%' AS FCPORCRECIBIDO,
    TO_CHAR(CAMINO * calculoPorcentaje,'990') || '%' AS FCPORCCAMINO, 
    TO_CHAR(ENTREGADO * calculoPorcentaje,'990') || '%' AS FCPORCENTREGADO
       FROM (SELECT FIIDESTATUSNVO FROM UNIFORMES.TABITACORASOLICITUD WHERE FIFOLIOSOLICITUD = paFolioSolicitud) PIVOT (count(FIIDESTATUSNVO) for FIIDESTATUSNVO in 
    (0 AS CANCELADO,
    1 AS PENDIENTE,
    2 AS SOLICITADO,
    3 AS ATENDIDO,
    4 AS RECIBIDO,
    5 AS CAMINO,
    6 AS ENTREGADO));
    RETURN curDatos;
END FNCONSULTASOLICITUDAVANCE;

FUNCTION FNCALCULOPORCENTAJE(
    paFolioSolicitud UNIFORMES.TASOLICITUDES.FIFOLIOSOLICITUD%TYPE
)
  RETURN NUMBER
  IS
  /*************************************************************
    Proyecto:                         Sistema de Uniformes
    Descripcion:                      Realiza la operacion del calculo del porcentaje
    Parametros de entrada:            Folio de la solicitud
    Parametros de salida:             Retorna los datos de la solicitud del avance
    Parametros de entrada-salida      No aplica
    Precondiciones:                   Tener creado el esquema
    Creador:                          Luis Rodriguez
    Fecha de creacion:                16 de Septiembre del 2017
  *************************************************************/   
  contador NUMBER(3);
  division NUMBER(4,2);
  BEGIN  
    SELECT count(FIFOLIOSOLICITUD) INTO contador FROM UNIFORMES.TASOLICITUDESDETALLE WHERE FIFOLIOSOLICITUD = paFolioSolicitud;
    division := 
    (CASE contador
        WHEN 0 THEN 0
        ELSE 100/contador
     END);
  RETURN division;
END FNCALCULOPORCENTAJE;

FUNCTION FNCONSULTASOLICITUDESV(
  paNumeroEmpleado UNIFORMES.TASOLICITUDES.FIIDEMPLEADO%TYPE,
  paNumeroSolicitudes NUMBER
)
 RETURN rcgCursor
 IS
  /*************************************************************
    Proyecto:                         Sistema de Uniformes
    Descripcion:                      Consulta las solicitudes voluntarias
    Parametros de entrada:            Numero de empleado, Folio de la solicitud
    Parametros de salida:             Retorna los datos de la solicitud voluntaria
    Parametros de entrada-salida      No aplica
    Precondiciones:                   Tener creado el esquema
    Creador:                          Luis Rodriguez
    Fecha de creacion:                16 de Septiembre del 2017
  *************************************************************/   
 curDatos rcgCursor;
 BEGIN
 OPEN curDatos FOR
 SELECT * FROM
 (SELECT 
 FIFOLIOSOLICITUD,
 TO_CHAR(FDFECHACAPTURA) AS FCFECHACAPTURA
 FROM UNIFORMES.TASOLICITUDES
 WHERE FIIDEMPLEADO = paNumeroEmpleado 
 AND FIIDTIPOSOLICITUD = 2
  ORDER BY FDFECHACAPTURA) 
  WHERE ROWNUM <= paNumeroSolicitudes;
 RETURN curDatos;
END FNCONSULTASOLICITUDESV;

FUNCTION FNPEDIDOSPORPRECIO(
  paFolioSolicitud UNIFORMES.TAPEDIDOSCD.FIFOLIOSOLICITUD%TYPE
)
 RETURN rcgCursor
 IS
  /*************************************************************
    Proyecto:                         Sistema de Uniformes
    Descripcion:                      Muestra los pedidos con su precio
    Parametros de entrada:            Folio de la solicitud
    Parametros de salida:             Retorna todos los pedidos
    Parametros de entrada-salida      No aplica
    Precondiciones:                   Tener creado el esquema
    Creador:                          Luis Rodriguez
    Fecha de creacion:                16 de Septiembre del 2017
  *************************************************************/   
 curDatos rcgCursor;
 anoActual Number(4);
 BEGIN
 SELECT (TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY'))) INTO anoActual FROM DUAL;
 OPEN curDatos FOR
        SELECT
        TPCD.FIPEDIDO AS FIPEDIDO,
        TPCD.FIFOLIOSOLICITUD AS FIFOLIOSOLICITUD,
        TO_CHAR(TPCD.FISKU) AS FCSKU,
        TP.FCDESCRIPCION,
        TO_CHAR((FNTOTDESCUENTO - FNSALDO),'FM$99990.00') AS FCPAGADO,
        TPCD.FICANTIDAD AS FICANTIDAD,
        TO_CHAR(TDS.FNTOTDESCUENTO,'FM$99990.00') AS FCCOSTOPRENDA,
        TDS.FISEMADESCUENTO AS FISEMANA,
        TO_CHAR((TDS.FNSALDO),'FM$99990.00') AS FCSALDOPORPAGAR,
        TO_CHAR(TDS.FNPAGO) AS FCPAGOSEMANAL,
        TO_CHAR(TDS.FDPAGO) AS FCFECHAPAGO,
        TTP.FCIMAGEN AS FCNOMBREIMAGEN
        FROM UNIFORMES.TADESCUENTOSSAP TDS
        INNER JOIN
        (SELECT FIFOLIOCENTRAL,FIPEDIDO, MAX(FDPAGO) AS FDPAGO FROM UNIFORMES.TADESCUENTOSSAP WHERE FIFOLIOCENTRAL = paFolioSolicitud 
                            AND (
                            CASE 
                                WHEN (TO_NUMBER(TO_CHAR(FDPAGO, 'YYYY'))) < anoActual THEN 1   
                                WHEN (TO_NUMBER(TO_CHAR(FDPAGO, 'YYYY'))) = anoActual THEN   
                                    CASE 
                                        WHEN ((FISEMADESCUENTO) <= (SELECT (TO_NUMBER(TO_CHAR(SYSDATE, 'WW'))) FROM DUAL)) THEN 1
                                        ELSE 0
                                    END
                                ELSE 0
                            END
                            ) = 1
        GROUP BY FIFOLIOCENTRAL,FIPEDIDO) TDSGROUPBY
        ON TDS.FIFOLIOCENTRAL = TDSGROUPBY.FIFOLIOCENTRAL AND TDS.FIPEDIDO = TDSGROUPBY.FIPEDIDO AND TDS.FDPAGO = TDSGROUPBY.FDPAGO
        INNER JOIN (SELECT FIPEDIDO,FIFOLIOSOLICITUD,FISKU,FICANTIDAD FROM UNIFORMES.TAPEDIDOSCD WHERE FIFOLIOSOLICITUD = paFolioSolicitud) TPCD
        ON TDSGROUPBY.FIFOLIOCENTRAL = TPCD.FIFOLIOSOLICITUD AND TDSGROUPBY.FIPEDIDO = TPCD.FIPEDIDO
        INNER JOIN (SELECT FISKU,FCDESCRIPCION,FIIDTIPOPRENDA FROM UNIFORMES.TAPRENDAS) TP
        ON TP.FISKU = TPCD.FISKU
        INNER JOIN (SELECT FIIDTIPOPRENDA,FCIMAGEN FROM UNIFORMES.TATIPOSPRENDA) TTP
        ON TTP.FIIDTIPOPRENDA = TP.FIIDTIPOPRENDA
        ORDER BY TPCD.FIPEDIDO;
 RETURN curDatos;
END FNPEDIDOSPORPRECIO;

FUNCTION FNINFORMACIONDESCUENTO(
  paFolioSolicitud UNIFORMES.TAPEDIDOSCD.FIFOLIOSOLICITUD%TYPE,
  paNumeroPedido UNIFORMES.TAPEDIDOSCD.FIPEDIDO%TYPE
)
 RETURN rcgCursor
 IS
  /*************************************************************
    Proyecto:                         Sistema de Uniformes
    Descripcion:                      Muestra a mayor detalle el descuento
    Parametros de entrada:            Folio de la solicitud
    Parametros de salida:             Retorna todos los pedidos
    Parametros de entrada-salida      No aplica
    Precondiciones:                   Tener creado el esquema
    Creador:                          Luis Rodriguez
    Fecha de creacion:                16 de Septiembre del 2017
  *************************************************************/   
 curDatos rcgCursor;
 BEGIN
 OPEN curDatos FOR
 SELECT 
        TO_CHAR(TDSAP.FDPAGO, 'YYYY') AS FCANO,
        TDSAP.FISEMADESCUENTO,
        TO_CHAR(TDSAP.FDPAGO) AS FCFECHAPAGO,
        TO_CHAR(TDSAP.FNTOTDESCUENTO,'FM$99990.00') AS FCCOSTOPRENDA,
        TO_CHAR(TDSAP.FNSALDO,'FM$99990.00') AS FCSALDOPORPAGAR,
        TO_CHAR(TDSAP.FNPAGO,'FM$99990.00') AS FCPAGOSEMANAL
        FROM (SELECT FIPEDIDO,FIFOLIOSOLICITUD,FISKU,FICANTIDAD FROM UNIFORMES.TAPEDIDOSCD WHERE FIFOLIOSOLICITUD = paFolioSolicitud AND FIPEDIDO = paNumeroPedido) TPCD
        INNER JOIN (SELECT FIFOLIOCENTRAL,FIPEDIDO,FNTOTDESCUENTO,FISEMADESCUENTO,FNSALDO,FNPAGO,FDPAGO FROM UNIFORMES.TADESCUENTOSSAP WHERE FIFOLIOCENTRAL = paFolioSolicitud AND FIPEDIDO = paNumeroPedido ORDER BY FDPAGO) TDSAP
        ON TPCD.FIFOLIOSOLICITUD = TDSAP.FIFOLIOCENTRAL;
 RETURN curDatos;
END FNINFORMACIONDESCUENTO;
  
END PAWEBUNIFORMESCOMERCIO2;