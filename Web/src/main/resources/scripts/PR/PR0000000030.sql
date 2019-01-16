create or replace PACKAGE  PAPLUNIFORMESCOMERCIO
AS
  /*************************************************************
  Proyecto:                       Uniformes Comercio
  Descripcion:                    Paquete para la migracion de Uniformes Comercio.
  Parametros de entrada:          No aplica
  Parametros de salida:           No aplica
  Parametros de entrada-salida    No aplica
  Precondiciones:                 Tener creado el esquema
  Creador:                        
  Fecha de creacion:              
  *************************************************************/
 TYPE rcgCursor IS REF CURSOR;

 PROCEDURE SPACTSOLGENERADAS(
    paTiendas   sys.odcinumberlist,
    paNoDiasAnteriores  NUMBER);

 PROCEDURE SPACTSOLICITUDESREMISIONADAS(
    paTiendas   sys.odcinumberlist,
    paNoDiasAnteriores  NUMBER);
    
 FUNCTION FNESTATUSSOLICITUD(
    paEstatus             UNIFORMES.TADETALLEPEDIDOS.FIESTATUS%TYPE)
 RETURN NUMBER;

 FUNCTION FNTIPOSOLICITUD(
    paNoTipo    UNIFORMES.TAPEDIDOS.FITIPO%TYPE)
 RETURN NUMBER; 

 FUNCTION FNTIPONEGOCIO(
    paNoCanal   UNIFORMES.TATIENDAS.FICANAL%TYPE)
 RETURN NUMBER;
 
 FUNCTION FNPRECIOTOTALPRENDA(
    paNoTipo    UNIFORMES.TAPEDIDOS.FITIPO%TYPE,
    paCosto     UNIFORMES.TADETALLEPEDIDOS.FNCOSTO%TYPE)
 RETURN NUMBER;
 
 FUNCTION FNTIPOPRENDA(
    paNoTipoProducto    UNIFORMES.TAPRODUCTOS.FITIPO%TYPE)
 RETURN NUMBER;
 
 FUNCTION FNGENERAFOLIOSOLICITUD
 RETURN NUMBER; 
 
 FUNCTION FNGENERAIDDETALLE
 RETURN NUMBER;

END PAPLUNIFORMESCOMERCIO;
/
create or replace PACKAGE BODY PAPLUNIFORMESCOMERCIO
AS
  /*************************************************************
  Proyecto:                       Uniformes Comercio
  Descripcion:                    Paquete para la migracion de Uniformes Comercio.
  Parametros de entrada:          No aplica
  Parametros de salida:           No aplica
  Parametros de entrada-salida    No aplica
  Precondiciones:                 Tener creado el esquema
  Creador:                        
  Fecha de creacion:              
  *************************************************************/
    csgCancelado                CONSTANT NUMBER(1):=0;  -- Cancelado
    csgSolicitudGenerada        CONSTANT NUMBER(1):=1;  -- Solicitud Generada
    csgSolicitadoTienda         CONSTANT NUMBER(1):=2;  -- Solicitado en Tienda
    csgSolicitadoCD             CONSTANT NUMBER(1):=3;  -- Solicitado en CD
    csgAtendidoCD               CONSTANT NUMBER(1):=4;  -- Atendido en CD
    csgCaminoTienda             CONSTANT NUMBER(1):=5;  -- En camino a Tienda
    csgRecibidoTienda           CONSTANT NUMBER(1):=6;  -- Recibido en Tienda
    csgEntregado                CONSTANT NUMBER(1):=7;  -- Entregado
    csgDescuentoSAP             CONSTANT NUMBER(1):=8;  -- Descuento SAP
    csgDescuentoSPPI            CONSTANT NUMBER(1):=9;  -- Descuento SPPI

 PROCEDURE SPACTSOLGENERADAS(
    paTiendas   sys.odcinumberlist,
    paNoDiasAnteriores  NUMBER)
 IS
 /*************************************************************
    Proyecto:                         Uniformes Comercio
    Descripcion:                      Actualiza la tabla TASOLICITUDES Y TAPEDIDOS [0,10,15,20]
    Parametros de entrada:            Tiendas y Numero de dias de la migracion
    Parametros de salida:             No aplica
    Parametros de entrada-salida      No aplica
    Precondiciones:                   Tener creado el esquema
    Creador:                          Luis Daniel Rodriguez Garcia
    Fecha de creacion:                13 de Abril del 2017
 *************************************************************/   
 vlFolioSolicitud   UNIFORMES.TASOLICITUDES.FIFOLIOSOLICITUD%TYPE;
 vlIDDetalle        UNIFORMES.TASOLICITUDESDETALLE.FIIDDETALLE%TYPE;
 CURSOR curSolicitudes IS  (SELECT  P.FIFOLIOCENTRAL,
                                    P.FIEMPLEADO AS FIIDEMPLEADO,
                                    UNIFORMES.PAPLUNIFORMESCOMERCIO.FNTIPOSOLICITUD(P.FITIPO) AS FIIDTIPOSOLICITUD,
                                    UNIFORMES.PAPLUNIFORMESCOMERCIO.FNTIPONEGOCIO(T.FICANAL) AS FIIDNEGOCIO,
                                    P.FIFUNCION AS FIFUNCIONSAP,
                                    P.FIEMPLEADOSOLICITA AS FIIDEMPCAPTURA,
                                    P.FDREGISTRO AS FDFECHACAPTURA
                            FROM TATIENDAS T
                            INNER JOIN (    SELECT DISTINCT B.FIFOLIOCENTRAL, --CONSULTA LAS SOLICITUDES QUE NO ESTAN REMISIONADAS Y ACTUALES
                                                    B.FISUCURSAL,
                                                    B.FIESTATUS
                                            FROM TAREMISIONES A --TABLA A
                                            RIGHT JOIN TADETALLEPEDIDOS B --TABLA B
                                                ON  A.FICANAL = B.FICANAL AND
                                                    A.FIPAIS = B.FIPAIS AND
                                                    A.FISUCURSAL = B.FISUCURSAL AND
                                                    A.FISKU = B.FISKU AND
                                                    A.FIPEDIDO = B.FIPEDIDO AND
                                                    A.FIFOLIOCENTRAL = B.FIFOLIOCENTRAL
                                            WHERE   A.FIREMISION IS NULL) DP
                                ON  DP.FISUCURSAL = T.FISUCURSAL     
                            INNER JOIN TAPEDIDOS P
                                ON  P.FIFOLIOCENTRAL = DP.FIFOLIOCENTRAL
                            INNER JOIN TAEMPLEADOS E
                                ON  E.FIEMPLEADO = P.FIEMPLEADO
                            WHERE   P.FDREGISTRO >= TRUNC(SYSDATE - paNoDiasAnteriores) AND --DIAS ANTERIORES
                                    PASRVUNIFORMESCOMERCIO.FNEMPLEADOACTIVO(P.FIEMPLEADO) = 1 AND --EMPLEADO ACTIVO
                                    T.FISUCURSAL IN (SELECT * FROM TABLE(paTiendas))  AND --SUCURSALES
                                    P.FDREGISTRO >= E.FDANTERIOR AND --VALIDACION DE USUARIO 
                                    DP.FIESTATUS IN (0,10,15,20)); --ESTATUS
                                    
 CURSOR curSolicitudesDetalle IS         (   SELECT     DP.FIFOLIOCENTRAL,
                                                        DP.FIPAIS,
                                                        DP.FICANAL,
                                                        DP.FISUCURSAL,
                                                        DP.FIPEDIDO,
                                                        0 AS FISKU,--DP.FISKU,
                                                        UNIFORMES.PAPLUNIFORMESCOMERCIO.FNTIPOPRENDA(PROD.FITIPO) AS FIIDTIPOPRENDA,
                                                        PROD.FITALLA,
                                                        DP.FICANTIDAD,
                                                        DP.FNCOSTO AS FNPRECIOUNITARIO,
                                                        UNIFORMES.PAPLUNIFORMESCOMERCIO.FNPRECIOTOTALPRENDA(P.FITIPO,DP.FNCOSTO) AS FNPRECIOTOTAL,
                                                        UNIFORMES.PAPLUNIFORMESCOMERCIO.FNESTATUSSOLICITUD(DP.FIESTATUS) AS FIESTATUSSOL,
                                                        DP.FIESTATUS AS FIESTATUSCD,
                                                        DP.FDACTUALIZACION AS FDFECHAACT,
                                                        1 AS FIACTIVO,
                                                        -1 AS FIRUTA,
                                                        'MIGRACION' AS FCMENSAJECD,
                                                        0 AS FIREINYECTA
                                                FROM TAPEDIDOS P
                                                INNER JOIN TADETALLEPEDIDOS DP 
                                                    ON P.FIFOLIOCENTRAL = DP.FIFOLIOCENTRAL
                                                INNER JOIN TAPRODUCTOS PROD
                                                    ON PROD.FISKU = DP.FISKU
                                                WHERE   P.FDREGISTRO >= TRUNC(SYSDATE-paNoDiasAnteriores) AND --DIAS ANTERIORES
                                                        PASRVUNIFORMESCOMERCIO.FNEMPLEADOACTIVO(P.FIEMPLEADO) = 1 AND --EMPLEADO ACTIVO
                                                        DP.FISUCURSAL IN (SELECT * FROM TABLE(paTiendas)) AND --SUCURSALES
                                                        DP.FIESTATUS IN (0,10,15,20)); --ESTATUS          
 BEGIN
    FOR solicitud IN curSolicitudes LOOP
        vlFolioSolicitud := UNIFORMES.PAPLUNIFORMESCOMERCIO.FNGENERAFOLIOSOLICITUD;
        INSERT INTO UNIFORMES.TASOLICITUDES(
            FIFOLIOSOLICITUD,
            FIIDEMPLEADO,
            FIIDTIPOSOLICITUD,
            FIIDNEGOCIO,
            FIFUNCIONSAP,
            FIIDEMPCAPTURA,
            FDFECHACAPTURA
        )VALUES(
            vlFolioSolicitud,
            solicitud.FIIDEMPLEADO,
            solicitud.FIIDTIPOSOLICITUD,
            solicitud.FIIDNEGOCIO,
            solicitud.FIFUNCIONSAP,
            solicitud.FIIDEMPCAPTURA,
            solicitud.FDFECHACAPTURA
        );
        UPDATE UNIFORMES.TAPEDIDOS
            SET FIESTADOGENERAL = 4
        WHERE FIFOLIOCENTRAL = solicitud.FIFOLIOCENTRAL;
        
        FOR solicitudDetalle IN curSolicitudesDetalle LOOP
            IF solicitud.FIFOLIOCENTRAL = solicitudDetalle.FIFOLIOCENTRAL THEN
            vlIDDetalle := UNIFORMES.PAPLUNIFORMESCOMERCIO.FNGENERAIDDETALLE;
                INSERT INTO UNIFORMES.TASOLICITUDESDETALLE(
                    FIFOLIOSOLICITUD,
                    FIIDDETALLE,
                    FIPAIS,
                    FICANAL,
                    FISUCURSAL,
                    FIPEDIDO,
                    FISKU,
                    FIIDTIPOPRENDA,
                    FITALLA,
                    FICANTIDAD,
                    FNPRECIOUNITARIO,
                    FNPRECIOTOTAL,
                    FIESTATUSSOL,
                    FIESTATUSCD,
                    FDFECHAACT,
                    FIACTIVO,
                    FIRUTA,
                    FCMENSAJECD,
                    FIREINYECTA
                )VALUES(
                    vlFolioSolicitud,
                    vlIDDetalle,
                    solicitudDetalle.FIPAIS,
                    solicitudDetalle.FICANAL,
                    solicitudDetalle.FISUCURSAL,
                    solicitudDetalle.FIPEDIDO,
                    solicitudDetalle.FISKU,
                    solicitudDetalle.FIIDTIPOPRENDA,
                    solicitudDetalle.FITALLA,
                    solicitudDetalle.FICANTIDAD,
                    solicitudDetalle.FNPRECIOUNITARIO,
                    solicitudDetalle.FNPRECIOTOTAL,
                    solicitudDetalle.FIESTATUSSOL,
                    solicitudDetalle.FIESTATUSCD,
                    solicitudDetalle.FDFECHAACT,
                    solicitudDetalle.FIACTIVO,
                    solicitudDetalle.FIRUTA,
                    solicitudDetalle.FCMENSAJECD,
                    solicitudDetalle.FIREINYECTA
                );
                UPDATE UNIFORMES.TADETALLEPEDIDOS
                    SET FIESTATUS = 999
                WHERE FIFOLIOCENTRAL = solicitudDetalle.FIFOLIOCENTRAL;    
                UNIFORMES.PAWEBUNIFORMESCOMERCIO.SPGUARDABITACORA(
                    vlFolioSolicitud,
                    vlIDDetalle,
                    solicitudDetalle.FIPEDIDO,
                    'ESTATUSCD:'||
                );
            END IF;
        END LOOP;
    END LOOP;
    COMMIT;
 END SPACTSOLGENERADAS;
  /*PROCEDURE SPGUARDABITACORA(
  	paSolicitud UNIFORMES.TABITACORASOLICITUD.FIFOLIOSOLICITUD%TYPE,
  	paDetalle   UNIFORMES.TABITACORASOLICITUD.FIIDDETALLE%TYPE,
  	paPedido    UNIFORMES.TABITACORASOLICITUD.FIPEDIDO%TYPE,
  	paDatosProc UNIFORMES.TABITACORASOLICITUD.FCDATOSPROCESO%TYPE,
  	paEstAnt    UNIFORMES.TABITACORASOLICITUD.FIESTATUSANT%TYPE,
  	paEstAct    UNIFORMES.TABITACORASOLICITUD.FIESTATUSNVO%TYPE,
  	paComent    UNIFORMES.TABITACORASOLICITUD.FCCOMENTARIOS%TYPE,
  	paTipoErr   UNIFORMES.TABITACORASOLICITUD.FIIDERROR%TYPE);*/
 PROCEDURE SPACTSOLICITUDESREMISIONADAS(
    paTiendas   sys.odcinumberlist,
    paNoDiasAnteriores  NUMBER)
 IS
  /*************************************************************
    Proyecto:                         Uniformes Comercio
    Descripcion:                      Actualiza la tabla TASOLICITUDES Y TADETALLEPEDIDOS [80]
    Parametros de entrada:            Tiendas y Numero de dias de la migracion
    Parametros de salida:             No aplica
    Parametros de entrada-salida      No aplica
    Precondiciones:                   Tener creado el esquema
    Creador:                          Luis Daniel Rodriguez Garcia
    Fecha de creacion:                13 de Abril del 2017
 *************************************************************/   
 BEGIN
    MERGE INTO UNIFORMES.TASOLICITUDES S
    USING(  
            SELECT  DISTINCT (DP.FIFOLIOCENTRAL) AS FIFOLIOSOLICITUD,
                    P.FIEMPLEADO AS FIIDEMPLEADO,
                    (CASE   P.FITIPO 
                            WHEN 1 THEN 2
                            WHEN 2 THEN 1
                            WHEN 3 THEN 3
                     END) AS FIIDTIPOSOLICITUD,
                    P.FIFUNCION AS FIFUNCIONSAP,
                    P.FIEMPLEADOSOLICITA AS FIIDEMPCAPTURA,
                    P.FDREGISTRO AS FDFECHACAPTURA,
                    (CASE   T.FICANAL
                        WHEN 1      THEN 1
                        WHEN 125    THEN 4
                        WHEN 71     THEN 5
                        WHEN 90     THEN 6
                        WHEN 2      THEN 3
                        WHEN 3      THEN 2
                     END) AS FIIDNEGOCIO,
                    T.FCNOMBRE
            FROM TATIENDAS T 
            INNER JOIN TADETALLEPEDIDOS DP
                ON  DP.FISUCURSAL = T.FISUCURSAL     
            INNER JOIN TAPEDIDOS P
                ON  P.FIFOLIOCENTRAL = DP.FIFOLIOCENTRAL
            INNER JOIN TAEMPLEADOS E
                ON  E.FIEMPLEADO = P.FIEMPLEADO
            WHERE   P.FDREGISTRO >= TRUNC(SYSDATE - paNoDiasAnteriores) AND --DIAS ANTERIORES
                    PASRVUNIFORMESCOMERCIO.FNEMPLEADOACTIVO(P.FIEMPLEADO) = 1 AND --EMPLEADO ACTIVO
                    T.FISUCURSAL IN (SELECT * FROM TABLE(paTiendas))  AND --SUCURSALES
                    P.FDREGISTRO >= E.FDANTERIOR AND --VALIDACION DE USUARIO
                    DP.FIESTATUS IN (80) --ESTATUS
    ) TGENERAL
    ON(
        S.FIFOLIOSOLICITUD = TGENERAL.FIFOLIOSOLICITUD
    )
    WHEN NOT MATCHED THEN
        INSERT(
            FIFOLIOSOLICITUD,
            FIIDEMPLEADO,
            FIIDTIPOSOLICITUD,
            FIIDNEGOCIO,
            FIFUNCIONSAP,
            FIIDEMPCAPTURA,
            FDFECHACAPTURA
        )VALUES(
            TGENERAL.FIFOLIOSOLICITUD,
            TGENERAL.FIIDEMPLEADO,
            TGENERAL.FIIDTIPOSOLICITUD,
            TGENERAL.FIIDNEGOCIO,
            TGENERAL.FIFUNCIONSAP,
            TGENERAL.FIIDEMPCAPTURA,
            TGENERAL.FDFECHACAPTURA
        );     

 END SPACTSOLICITUDESREMISIONADAS;

 FUNCTION FNESTATUSSOLICITUD(
    paEstatus             UNIFORMES.TADETALLEPEDIDOS.FIESTATUS%TYPE)
 RETURN NUMBER
 IS
 vlNoEstatusSolicitud       UNIFORMES.TASOLICITUDESDETALLE.FIESTATUSSOL%TYPE;
 BEGIN
    IF paEstatus IN (50,500) THEN
        vlNoEstatusSolicitud := csgCancelado;
    ELSIF paEstatus IN (0,10,15,20) THEN
        vlNoEstatusSolicitud := csgSolicitudGenerada;
    ELSIF paEstatus IN (30) THEN
        vlNoEstatusSolicitud := csgSolicitadoTienda; 
    ELSIF paEstatus IN (40) THEN
        vlNoEstatusSolicitud := csgSolicitadoCD; 
    ELSIF paEstatus IN (60) THEN
        vlNoEstatusSolicitud := csgAtendidoCD;
    ELSIF paEstatus IN (70) THEN
        vlNoEstatusSolicitud := csgCaminoTienda;
    ELSIF paEstatus IN (80) THEN
        vlNoEstatusSolicitud := csgRecibidoTienda;         
    END IF;
    RETURN vlNoEstatusSolicitud;
 END FNESTATUSSOLICITUD;

 FUNCTION FNTIPOSOLICITUD(
    paNoTipo    UNIFORMES.TAPEDIDOS.FITIPO%TYPE)
 RETURN NUMBER
 IS
 vlNoEstatusSolicitud       UNIFORMES.TASOLICITUDES.FIIDTIPOSOLICITUD%TYPE;
 BEGIN
 vlNoEstatusSolicitud := (CASE  paNoTipo
                                WHEN 1 THEN 2
                                WHEN 2 THEN 1
                                WHEN 3 THEN 3
                            END);
 RETURN vlNoEstatusSolicitud;
 END FNTIPOSOLICITUD;

 FUNCTION FNTIPONEGOCIO(
    paNoCanal   UNIFORMES.TATIENDAS.FICANAL%TYPE)
 RETURN NUMBER
 IS
 vlTipoNegocio  UNIFORMES.TANEGOCIOS.FIIDNEGOCIO%TYPE;
 BEGIN
 vlTipoNegocio :=   (CASE  paNoCanal
                        WHEN 1      THEN 1
                        WHEN 125    THEN 4
                        WHEN 71     THEN 5
                        WHEN 90     THEN 6
                        WHEN 2      THEN 3
                        WHEN 3      THEN 2
                     END);
 RETURN vlTipoNegocio;
 END FNTIPONEGOCIO;
 
 FUNCTION FNPRECIOTOTALPRENDA(
    paNoTipo    UNIFORMES.TAPEDIDOS.FITIPO%TYPE,
    paCosto     UNIFORMES.TADETALLEPEDIDOS.FNCOSTO%TYPE)
 RETURN NUMBER
 IS
 vlPrecioTotal  UNIFORMES.TASOLICITUDESDETALLE.FNPRECIOTOTAL%TYPE;
 BEGIN
 vlPrecioTotal :=   (CASE paNoTipo
                            WHEN 1 THEN paCosto
                            WHEN 2 THEN 0
                            WHEN 3 THEN 0
                     END);
 RETURN vlPrecioTotal;
 END FNPRECIOTOTALPRENDA;
 
 FUNCTION FNTIPOPRENDA(
    paNoTipoProducto    UNIFORMES.TAPRODUCTOS.FITIPO%TYPE)
 RETURN NUMBER
 IS
 vlTipoPrenda  UNIFORMES.TASOLICITUDESDETALLE.FIIDTIPOPRENDA%TYPE;
 BEGIN
 vlTipoPrenda :=   (CASE paNoTipoProducto
                            WHEN 1  THEN 2
                            WHEN 2  THEN 3
                            WHEN 3  THEN 1
                            WHEN 4  THEN 4
                            WHEN 5  THEN 2
                            WHEN 6  THEN 3
                     END);
 RETURN vlTipoPrenda;
 END FNTIPOPRENDA;
 
 FUNCTION FNGENERAFOLIOSOLICITUD
 RETURN NUMBER
 IS
 vlFolioSolicitud    UNIFORMES.TASOLICITUDES.FIFOLIOSOLICITUD%TYPE;
 BEGIN 
    SELECT (NVL(MAX(FIFOLIOSOLICITUD), 0) + 1)
        INTO vlFolioSolicitud
    FROM UNIFORMES.TASOLICITUDES;
 RETURN vlFolioSolicitud;
 END FNGENERAFOLIOSOLICITUD;
 
 FUNCTION FNGENERAIDDETALLE
 RETURN NUMBER
 IS
 vlIDDetalle    UNIFORMES.TASOLICITUDESDETALLE.FIIDDETALLE%TYPE;
 BEGIN 
    SELECT (NVL(MAX(FIIDDETALLE), 0) + 1)
        INTO vlIDDetalle
    FROM UNIFORMES.TASOLICITUDESDETALLE;
 RETURN vlIDDetalle;
 END FNGENERAIDDETALLE;

END PAPLUNIFORMESCOMERCIO;
/