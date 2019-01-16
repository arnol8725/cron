DECLARE 
cslCero                     CONSTANT NUMBER(1) := 0;
cslUno                      CONSTANT NUMBER(1) := 1;
cslDos                      CONSTANT NUMBER(1) := 2;
cslTres                     CONSTANT NUMBER(1) := 3;
cslCuatro                   CONSTANT NUMBER(1) := 4;
cslCinco                    CONSTANT NUMBER(1) := 5;
cslSeis                     CONSTANT NUMBER(1) := 6;
cslDiecinueve               CONSTANT NUMBER(2) := 19;
clsSolicitudVoluntaria      CONSTANT NUMBER(1) := 1;
cslSolicitudSemestral       CONSTANT NUMBER(1) := 2;
cslSolicitudNuevoIngreso    CONSTANT NUMBER(1) := 3;
cslCanceladoAbasto          CONSTANT NUMBER(2) := 50;   --CANCELADO
cslCanceladoBajaEmpleado    CONSTANT NUMBER(3) := 500;  --CANCELADO
cslRegistrado               CONSTANT NUMBER(1) := 0;    --SOLICITUD GENERADA
cslAutorizadoRH             CONSTANT NUMBER(2) := 10;   --SOLICITADO EN TIENDA
cslAutorizadoCD             CONSTANT NUMBER(2) := 20;   --SOLICITADO EN CD
cslAbastoEnviaCD            CONSTANT NUMBER(2) := 60;   --SOLICITADO EN CD
cslEnviadoAbasto            CONSTANT NUMBER(2) := 40;   --ATENDIDO EN CD
cslEnviadoTienda            CONSTANT NUMBER(2) := 30;   --EN CAMINO A TIENDA
cslAbastoEnviaTienda        CONSTANT NUMBER(2) := 70;   --EN CAMINO A TIENDA
cslRecibidoTiendaRemision   CONSTANT NUMBER(2) := 80;   --RECIBIDO EN TIENDA
cslDescargado               CONSTANT NUMBER(2) := 90;   --ENTREGADO
cslDescuentoSAP             CONSTANT NUMBER(3) := 100;  --DESCUENTO SAP
cslDescuentoSPPI            CONSTANT NUMBER(3) := 110;  --DESCUENTO SPPI
vlNoSucursal                NUMBER(5) := 191;
BEGIN
    --ESTATUS[0-20]*************************************************************
    MERGE INTO UNIFORMES.TASOLICITUDES S
    USING(  SELECT  P.FIFOLIOCENTRAL AS FIFOLIOSOLICITUD,
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
            INNER JOIN (    SELECT  DISTINCT FIFOLIOCENTRAL, 
                                    FISUCURSAL
                                FROM TADETALLEPEDIDOS
                            WHERE   FIESTATUS <= 20 AND 
                                    FIESTATUS != 50) DP
                ON  DP.FISUCURSAL = T.FISUCURSAL     
            INNER JOIN TAPEDIDOS P
                ON  P.FIFOLIOCENTRAL = DP.FIFOLIOCENTRAL
            WHERE   P.FDREGISTRO >= TRUNC(SYSDATE-180) AND
                    PASRVUNIFORMESCOMERCIO.FNEMPLEADOACTIVO(P.FIEMPLEADO) = 1 AND
                    T.FISUCURSAL IN (191,150,6248)
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

    MERGE INTO UNIFORMES.TASOLICITUDESDETALLE SD
    USING(  SELECT  DP.FIFOLIOCENTRAL AS FIFOLIOSOLICITUD,
                    ((SELECT NVL(MAX(FIIDDETALLE), 0) + 1 
                             FROM UNIFORMES.TASOLICITUDESDETALLE) + ROWNUM) AS FIIDDETALLE,
                    DP.FIPAIS,
                    DP.FICANAL,
                    DP.FISUCURSAL,
                    DP.FIPEDIDO,
                    0 AS FISKU,--DP.FISKU,
                    (CASE   PROD.FITIPO
                            WHEN 1  THEN 2
                            WHEN 2  THEN 3
                            WHEN 3  THEN 1
                            WHEN 4  THEN 4
                            WHEN 5  THEN 2
                            WHEN 6  THEN 3
                    END) AS FIIDTIPOPRENDA,
                    PROD.FITALLA,
                    DP.FICANTIDAD,
                    DP.FNCOSTO AS FNPRECIOUNITARIO,
                    (CASE P.FITIPO 
                            WHEN 1 THEN DP.FNCOSTO
                            WHEN 2 THEN 0
                            WHEN 3 THEN 0
                     END) AS FNPRECIOTOTAL,
                    PASRVUNIFORMESCOMERCIO.FNESTATUSMIGRACIONCD(DP.FIESTATUS) AS FIESTATUSSOL,
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
            WHERE   DP.FIESTATUS <= 20 AND
                    DP.FIESTATUS != 50 AND 
                    P.FDREGISTRO >= TRUNC(SYSDATE-180) AND
                    DP.FISUCURSAL IN (191,150,6248) AND
                    PASRVUNIFORMESCOMERCIO.FNEMPLEADOACTIVO(P.FIEMPLEADO) = 1
    ) TGENERAL
    ON(
        SD.FIFOLIOSOLICITUD = TGENERAL.FIFOLIOSOLICITUD
    )
    WHEN NOT MATCHED THEN
        INSERT(
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
            TGENERAL.FIFOLIOSOLICITUD,
            TGENERAL.FIIDDETALLE,
            TGENERAL.FIPAIS,
            TGENERAL.FICANAL,
            TGENERAL.FISUCURSAL,
            TGENERAL.FIPEDIDO,
            TGENERAL.FISKU,
            TGENERAL.FIIDTIPOPRENDA,
            TGENERAL.FITALLA,
            TGENERAL.FICANTIDAD,
            TGENERAL.FNPRECIOUNITARIO,
            TGENERAL.FNPRECIOTOTAL,
            TGENERAL.FIESTATUSSOL,
            TGENERAL.FIESTATUSCD,
            TGENERAL.FDFECHAACT,
            TGENERAL.FIACTIVO,
            TGENERAL.FIRUTA,
            TGENERAL.FCMENSAJECD,
            TGENERAL.FIREINYECTA
        ); 
    --**************************************************************************
    --CONSULTA SOLICITUDES (ESTATUS 20-89)
    MERGE INTO UNIFORMES.TASOLICITUDES S
    USING(  SELECT  P.FIFOLIOCENTRAL AS FIFOLIOSOLICITUD,
                    P.FIEMPLEADO AS FIIDEMPLEADO,
                    (CASE P.FITIPO 
                            WHEN 1 THEN 2
                            WHEN 2 THEN 1
                            WHEN 3 THEN 3
                     END) AS FIIDTIPOSOLICITUD,
                    P.FIFUNCION AS FIFUNCIONSAP,
                    P.FIEMPLEADOSOLICITA AS FIIDEMPCAPTURA,
                    P.FDREGISTRO AS FDFECHACAPTURA,
                    (CASE T.FICANAL
                        WHEN 1      THEN 1
                        WHEN 125    THEN 4
                        WHEN 71     THEN 5
                        WHEN 90     THEN 6
                        WHEN 2      THEN 3
                        WHEN 3      THEN 2
                     END) AS FIIDNEGOCIO,
                    T.FCNOMBRE
            FROM TATIENDAS T 
            INNER JOIN (    SELECT DISTINCT FIFOLIOCENTRAL, FISUCURSAL --SOLICITUDES ACTIVAS (0-89)
                                FROM TADETALLEPEDIDOS
                            WHERE   FIESTATUS > 20 AND 
                                    FIESTATUS < 90 AND
                                    FIESTATUS != 50) DP
                ON  DP.FISUCURSAL = T.FISUCURSAL     
            INNER JOIN TAPEDIDOS P
                ON  P.FIFOLIOCENTRAL = DP.FIFOLIOCENTRAL
            WHERE   P.FDREGISTRO >= TRUNC(SYSDATE-180) AND
                    PASRVUNIFORMESCOMERCIO.FNEMPLEADOACTIVO(P.FIEMPLEADO) = 1 AND
                    T.FISUCURSAL IN (191,150,6248)) TGENERAL
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

    --CONSULTA SOLICITUDES DETALLE (ESTATUS 0-20)
    MERGE INTO UNIFORMES.TASOLICITUDESDETALLE SD
    USING(  SELECT  DP.FIFOLIOCENTRAL AS FIFOLIOSOLICITUD,
                    ((SELECT NVL(MAX(FIIDDETALLE), 0) + 1 
                             FROM 
                    UNIFORMES.TASOLICITUDESDETALLE) + ROWNUM) AS FIIDDETALLE,
                    DP.FIPAIS,
                    DP.FICANAL,
                    DP.FISUCURSAL,
                    DP.FIPEDIDO,
                    DP.FISKU AS FISKU,
                    (CASE   PROD.FITIPO
                            WHEN 1  THEN 2
                            WHEN 2  THEN 3
                            WHEN 3  THEN 1
                            WHEN 4  THEN 4
                            WHEN 5  THEN 2
                            WHEN 6  THEN 3
                    END) AS FIIDTIPOPRENDA,
                    PROD.FITALLA,
                    DP.FICANTIDAD,
                    DP.FNCOSTO AS FNPRECIOUNITARIO,
                    (CASE P.FITIPO 
                            WHEN 1 THEN DP.FNCOSTO
                            WHEN 2 THEN 0
                            WHEN 3 THEN 0
                     END) AS FNPRECIOTOTAL,
                    PASRVUNIFORMESCOMERCIO.FNESTATUSMIGRACIONCD(DP.FIESTATUS) AS FIESTATUSSOL,
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
            WHERE   FIESTATUS > 20 AND
                    FIESTATUS < 90 AND 
                    DP.FIESTATUS != 50 AND 
                    P.FDREGISTRO >= TRUNC(SYSDATE-180) AND
                    DP.FISUCURSAL IN (191,150,6248) AND
                    PASRVUNIFORMESCOMERCIO.FNEMPLEADOACTIVO(P.FIEMPLEADO) = 1
    ) TGENERAL
    ON(
        SD.FIFOLIOSOLICITUD = TGENERAL.FIFOLIOSOLICITUD
    )
    WHEN NOT MATCHED THEN
        INSERT(
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
            TGENERAL.FIFOLIOSOLICITUD,
            TGENERAL.FIIDDETALLE,
            TGENERAL.FIPAIS,
            TGENERAL.FICANAL,
            TGENERAL.FISUCURSAL,
            TGENERAL.FIPEDIDO,
            TGENERAL.FISKU,
            TGENERAL.FIIDTIPOPRENDA,
            TGENERAL.FITALLA,
            TGENERAL.FICANTIDAD,
            TGENERAL.FNPRECIOUNITARIO,
            TGENERAL.FNPRECIOTOTAL,
            TGENERAL.FIESTATUSSOL,
            TGENERAL.FIESTATUSCD,
            TGENERAL.FDFECHAACT,
            TGENERAL.FIACTIVO,
            TGENERAL.FIRUTA,
            TGENERAL.FCMENSAJECD,
            TGENERAL.FIREINYECTA
        ); 
END;
/        
--PEDIDOS
SELECT * FROM TAPEDIDOS WHERE FDACTUALIZACION >= TRUNC(SYSDATE-180);
--EMPLEADOS
SELECT * FROM TAEMPLEADOS;
--DESCUENTOSSAP
SELECT * FROM TADESCUENTOSSAP;
--DETALLEPEDIDOS
SELECT * FROM TADETALLEPEDIDOS;
--TIPOSPRENDA
SELECT * FROM TATIPOSPRENDA;
--PRODUCTOS
SELECT * FROM TAPRODUCTOS;
--ESTATUSPEDIDOS ESQUEMA 2.0
SELECT * FROM TAESTATUSPEDIDOS;    
--TALLAS ESQUEMA 2.0
SELECT * FROM TATALLAS;
--SOLICITUDES  ESQUEMA 2.0
SELECT * FROM TASOLICITUDES;
--SOLICITUDESDETALLE  ESQUEMA 2.0  
SELECT * FROM TASOLICITUDESDETALLE;
--PRENDAS ESQUEMA  2.0
SELECT * FROM TAPRENDAS WHERE FISKU = 1002771;
--TIPOPRENDA ESQUEMA 2.0 
SELECT * FROM TATIPOPRENDA WHERE FISKU = 1002771;
--BITACORA ESQUEMA 1.0
SELECT *  FROM TAMOVTODETALLEPEDIDOS;
--REMISIONES ESQUEMA 1.0
SELECT * FROM TAREMISIONES;
--REMISIONESXPEDIDO ESQUEMA 2.0
SELECT * FROM TAREMISIONESXPEDIDO;
--DETALLEPEDIDOS  ESQUEMA 1.0
SELECT * FROM TADETALLEPEDIDOS WHERE FIPEDIDO =  1402 AND FISUCURSAL =9056;
--NEGOCIOS ESQUEMA 2.0
SELECT * FROM TANEGOCIOS;
--FUNCIONESXNEGOCIO ESQUEMA 2.0
SELECT * FROM TAFUNCIONESXNEGOCIO;
--TIENDAS ESQUEMA 2.0
SELECT * FROM TATIENDAS;
--PRENDAS ESQUEMA 2.0
SELECT * FROM TAPRENDAS;
--TAPRODUCTOSXKIT (SKUS ACTIVOS) WITH TAPRENDAS 
SELECT * FROM TAPRODUCTOSXKIT PROD 
    LEFT JOIN TAPRENDAS PREN
ON PREN.FISKU = PROD.FISKU
    WHERE PREN.FISKU IS NULL;
--TAPRODUCTOSXKIT FALTANTES EN TAPRENDAS 
SELECT * FROM TAPRODUCTOSXKIT PROD 
    INNER JOIN TAPRENDAS PREN
ON PREN.FISKU = PROD.FISKU;
--CRUCE ENTRE LA TABLA TAPRODUCTOS X TATIPOSPRODUCTO
SELECT TP.FCDESCRIPCION 
    FROM TAPRODUCTOS P 
INNER JOIN TATIPOSPRODUCTO TP 
    ON P.FITIPO = TP.FITIPO
WHERE FISKU = 1002771;    
--CONSULTA LOS PEDIDOS QUE SE ENCUENTRAN INCORRECTOS EN BASE A SU ESTATUS    
SELECT  P.*, 
        DP.FIPEDIDO, 
        DP.FIESTATUS, 
        R.FIREMISION
FROM TAPEDIDOS P
INNER JOIN TADETALLEPEDIDOS DP
    ON DP.FIFOLIOCENTRAL = P.FIFOLIOCENTRAL
INNER JOIN TAREMISIONES R
    ON  R.FICANAL = DP.FICANAL AND
        R.FIPAIS = DP.FICANAL AND
        R.FISUCURSAL = DP.FISUCURSAL AND
        R.FISKU = DP.FISKU AND
        R.FIPEDIDO = DP.FIPEDIDO AND
        R.FIFOLIOCENTRAL = DP.FIFOLIOCENTRAL
WHERE   P.FDREGISTRO >= TRUNC(SYSDATE-180) AND 
        DP.FIESTATUS < 80 AND 
        PASRVUNIFORMESCOMERCIO.FNEMPLEADOACTIVO(P.FIEMPLEADO) = 1;
--CONSULTA LAS SOLICITUDES QUE NO ESTAN REMISIONADAS Y ACTUALES
SELECT DISTINCT B.FIFOLIOCENTRAL
    FROM TAREMISIONES A --TABLA A
RIGHT JOIN TADETALLEPEDIDOS B --TABLA B
    ON  A.FICANAL = B.FICANAL AND
        A.FIPAIS = B.FIPAIS AND
        A.FISUCURSAL = B.FISUCURSAL AND
        A.FISKU = B.FISKU AND
        A.FIPEDIDO = B.FIPEDIDO AND
        A.FIFOLIOCENTRAL = B.FIFOLIOCENTRAL
WHERE   A.FIREMISION IS NULL AND
        B.FDACTUALIZACION >= TRUNC(SYSDATE-180);
