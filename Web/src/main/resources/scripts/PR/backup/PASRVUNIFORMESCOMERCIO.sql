CREATE OR REPLACE PACKAGE           PASRVUNIFORMESCOMERCIO
AS
  /*************************************************************
  Proyecto:                       Uniformes Comercio
  Descripcion:                    Paquete para sistema de uniformes Div. Comercial
  Parametros de entrada:          No aplica
  Parametros de salida:           No aplica
  Parametros de entrada-salida    No aplica
  Precondiciones:                 Tener creado el esquema
  Creador:                        
  Fecha de creacion:              
  *************************************************************/
  TYPE rcgCursor IS REF CURSOR;
  
  FUNCTION FNCONSSOLPENDGRABARTIENDA
  RETURN rcgCursor;
  
  PROCEDURE SPACTPEDIDOSOLBITACORA
  			(paSolicitud UNIFORMES.TABITACORASOLICITUD.FIFOLIOSOLICITUD%TYPE,
  			 paDetalle   UNIFORMES.TABITACORASOLICITUD.FIIDDETALLE%TYPE,
  			 paSku       UNIFORMES.TABITACORASOLICITUD.FISKU%TYPE,
  			 paCantidad  UNIFORMES.TASOLICITUDESDETALLE.FICANTIDAD%TYPE,
  			 paPedido    UNIFORMES.TABITACORASOLICITUD.FINUMPEDIDO%TYPE,
  			 paEvento    UNIFORMES.TABITACORASOLICITUD.FIIDTIPOEVENTO%TYPE,
  			 paEstAnt    UNIFORMES.TABITACORASOLICITUD.FIIDESTATUSANT%TYPE,
  			 paEstNvo    UNIFORMES.TABITACORASOLICITUD.FIIDESTATUSNVO%TYPE,
  			 paEstatusCD UNIFORMES.TAPEDIDOSCD.FIESTATUSCD%TYPE,
  			 paDescEstCD VARCHAR2,
  			 paDatos     VARCHAR2,
  			 paError     NUMBER,
  			 paResultado OUT NUMBER);
  
  FUNCTION FNCONSSOLPENDGRABARCD
  RETURN rcgCursor;

  FUNCTION FNCONSULTAPEDIDOSENCD
  RETURN rcgCursor;
  
END PASRVUNIFORMESCOMERCIO;

CREATE OR REPLACE PACKAGE BODY            PASRVUNIFORMESCOMERCIO
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
  	vgErrCode   NUMBER(6)          := 0;                   -- Variable para el manejo de errores codigo
    vgErrMsg    VARCHAR2(500 CHAR) := '';                  -- Variable para el manejo de errores mensaje
    csgCero 	NUMBER(1):=0;
    csgUno 		NUMBER(1):=1;
    
   FUNCTION FNCONSSOLPENDGRABARTIENDA
   RETURN rcgCursor
   IS 
  /*************************************************************
   Proyecto:                         Sistema de Uniformes
   Descripcion:                      Consulta datos de empleado
   Parametros de entrada:            paNumEmpleado    Numero de empleado
   Parametros de salida:             curDatos         Cursor de referencia
   Parametros de entrada-salida      No aplica
   Precondiciones:                   Tener creado el esquema
   Creador:                          
   Fecha de creacion:                
  *************************************************************/
  curCursorSalida rcgCursor;
  vlSolSemestral  NUMBER(1):= 1;
  vlSolNuevoIng   NUMBER(1):= 2;
  vlSolVoluntaria NUMBER(1):= 3;
  vlGeneroH		  NUMBER(1):= 1; 
  vlGeneroM		  NUMBER(2):= 2;
  vlGeneroUni	  NUMBER(2):= 3;
  vlSolenTienda   NUMBER(1):= 1;
  BEGIN
          OPEN curCursorSalida FOR
        SELECT S.FIFOLIOSOLICITUD,
			   D.FIIDDETALLE,
			   E.FIEMPLEADO,
			   D.FIPAIS,
			   TO_NUMBER(TRIM(D.FCCANAL)) FICANAL,
			   TO_NUMBER( SUBSTR(TO_CHAR(D.FISUCURSAL),3,4) ) FISUCURSAL,
			   T.FCDIRIP,
			   P.FISKU,
			   P.FCDESCRIPCION,
			   P.FITALLA,
			   D.FICANTIDAD 
		  FROM UNIFORMES.TASOLICITUDES S
	INNER JOIN UNIFORMES.TASOLICITUDESDETALLE D
			ON S.FIFOLIOSOLICITUD = D.FIFOLIOSOLICITUD
	INNER JOIN UNIFORMES.TAEMPLEADOS E
			ON E.FIEMPLEADO = S.FIIDEMPLEADO
    INNER JOIN UNIFORMES.TATIENDAS T
            ON T.FIPAIS = D.FIPAIS
           AND T.FCCANAL = D.FCCANAL
           AND T.FISUCURSAL = D.FISUCURSAL
	INNER JOIN UNIFORMES.TAFUNCIONESXNEGOCIO F
			ON F.FIFUNCIONSAP = S.FIFUNCIONSAP
		   AND F.FIIDNEGOCIO = S.FIIDNEGOCIO
	INNER JOIN UNIFORMES.TASKUSXKIT SK
			ON SK.FIKIT = F.FIKIT
	INNER JOIN UNIFORMES.TAPRENDAS P
			ON P.FISKU = SK.FISKU
		   AND P.FIIDTIPOPRENDA = D.FIIDTIPOPRENDA
		   AND P.FITALLA = D.FITALLA
		   AND P.FIIDGENERO IN ( ( CASE WHEN E.FCGENERO = 'H' THEN vlGeneroH ELSE vlGeneroM END ) , vlGeneroUni)
    INNER JOIN UNIFORMES.TABITACORASOLICITUD B
           ON  B.FIFOLIOSOLICITUD = D.FIFOLIOSOLICITUD
	       AND B.FIIDDETALLE = D.FIIDDETALLE
	       AND B.FIIDESTATUSNVO = vlSolenTienda 
		   AND B.FIIDESTATUSANT = vlSolenTienda 
		   AND B.FINUMPEDIDO IS NULL
		   AND B.FIERROR = csgCero
	INNER JOIN ( SELECT MAX(FDFECHAEVENTO) FECHABITACORA,FIFOLIOSOLICITUD,FIIDDETALLE
				    FROM UNIFORMES.TABITACORASOLICITUD
					  GROUP BY FIFOLIOSOLICITUD,FIIDDETALLE )BACT
			ON B.FIFOLIOSOLICITUD = BACT.FIFOLIOSOLICITUD
	       AND B.FIIDDETALLE = BACT.FIIDDETALLE
	       AND B.FDFECHAEVENTO = BACT.FECHABITACORA
	     WHERE S.FIIDTIPOSOLICITUD IN (vlSolNuevoIng,vlSolVoluntaria)
	        OR (   S.FIIDTIPOSOLICITUD = vlSolSemestral
	           AND S.FIFOLIOSOLICITUD IN ( SELECT SO.FIFOLIOSOLICITUD 
	           							  FROM UNIFORMES.TASOLICITUDES SO
									INNER JOIN UNIFORMES.TASOLICITUDESXCARGA SC
											ON SO.FIFOLIOSOLICITUD = SC.FIFOLIOSOLICITUD
									INNER JOIN UNIFORMES.TACARGAS C
										  	ON C.FIIDCARGA = SC.FIIDCARGA
										 WHERE C.FIGENERARPEDIDO = csgUno )
				)	  
	  ORDER BY S.FIFOLIOSOLICITUD,
			   D.FIIDDETALLE,
			   E.FIEMPLEADO;
       RETURN curCursorSalida;
       	EXCEPTION
          WHEN OTHERS THEN
              vgErrCode := SQLCODE;
              vgErrMsg := SQLERRM;
              RAISE_APPLICATION_ERROR (-20002,'ERROR ' || vgErrCode  || ' EN "PASRVUNIFORMESCOMERCIO.FNCONSSOLPENDGRABARTIENDA": ' || vgErrMsg);
              
  END FNCONSSOLPENDGRABARTIENDA;
  
  PROCEDURE SPACTPEDIDOSOLBITACORA
  			(paSolicitud UNIFORMES.TABITACORASOLICITUD.FIFOLIOSOLICITUD%TYPE,
  			 paDetalle   UNIFORMES.TABITACORASOLICITUD.FIIDDETALLE%TYPE,
  			 paSku       UNIFORMES.TABITACORASOLICITUD.FISKU%TYPE,
  			 paCantidad  UNIFORMES.TASOLICITUDESDETALLE.FICANTIDAD%TYPE,
  			 paPedido    UNIFORMES.TABITACORASOLICITUD.FINUMPEDIDO%TYPE,
  			 paEvento    UNIFORMES.TABITACORASOLICITUD.FIIDTIPOEVENTO%TYPE,
  			 paEstAnt    UNIFORMES.TABITACORASOLICITUD.FIIDESTATUSANT%TYPE,
  			 paEstNvo    UNIFORMES.TABITACORASOLICITUD.FIIDESTATUSNVO%TYPE,
  			 paEstatusCD UNIFORMES.TAPEDIDOSCD.FIESTATUSCD%TYPE,
  			 paDescEstCD VARCHAR2,
  			 paDatos     VARCHAR2,
  			 paError     NUMBER,
  			 paResultado OUT NUMBER)
  IS 
  /*************************************************************
   Proyecto:                         Sistema de Uniformes
   Descripcion:                      Consulta datos de empleado
   Parametros de entrada:            paNumEmpleado    Numero de empleado
   Parametros de salida:             curDatos         Cursor de referencia
   Parametros de entrada-salida      No aplica
   Precondiciones:                   Tener creado el esquema
   Creador:                          
   Fecha de creacion:                
  *************************************************************/
  vlPais 	 UNIFORMES.TABITACORASOLICITUD.FIPAIS%TYPE;
  vlCanal 	 UNIFORMES.TABITACORASOLICITUD.FCCANAL%TYPE;
  vlSucursal UNIFORMES.TABITACORASOLICITUD.FIIDSUCURSAL%TYPE;
  vlIdBitacora UNIFORMES.TABITACORASOLICITUD.FIIDBITACORA%TYPE;
  
  BEGIN
  		paResultado := csgCero;
  		
  		BEGIN -- Obtiene la llave de la sucursal
  			SELECT DISTINCT FIPAIS,
  							FCCANAL,
  							FIIDSUCURSAL
  					   INTO vlPais,
  							vlCanal,
  							vlSucursal
  					   FROM UNIFORMES.TABITACORASOLICITUD
  					  WHERE FIFOLIOSOLICITUD = paSolicitud
  					    AND FIIDDETALLE = paDetalle;  		
  		END;
  		
  		BEGIN -- Obtiene el id de la bitacora
	    	
		    	SELECT NVL(MAX(FIIDBITACORA), csgCero) + csgUno
		    	  INTO vlIdBitacora
		    	  FROM UNIFORMES.TABITACORASOLICITUD;
		    	
		END;
  		
  		IF paPedido > 0 THEN
  		
  		MERGE INTO UNIFORMES.TAPEDIDOSCD PEDCD  
  			 USING (SELECT  vlPais PAIS,
  				    	    vlCanal CANAL,
  							vlSucursal SUCURSAL,
  							paPedido PEDIDO,
  							paSku SKU
  					   FROM DUAL) P
  			     ON (PEDCD.FIPAIS = P.PAIS 
  				AND	PEDCD.FCCANAL = P.CANAL 
  				AND	PEDCD.FIIDSUCURSAL = P.SUCURSAL
  				AND	PEDCD.FIPEDIDO = P.PEDIDO
  				AND	PEDCD.FISKU = P.SKU)
  			 WHEN MATCHED THEN
             	UPDATE SET PEDCD.FIIDESTATUSPEDIDO = paEstatusCD,
             			   PEDCD.FCOBSERVACIONES = paDescEstCD 
             WHEN NOT MATCHED THEN
  			 					   INSERT (FIPAIS, 
  										   FCCANAL, 
  										   FIIDSUCURSAL, 
  										   FIPEDIDO, 
  										   FISKU, 
  										   FICANTIDAD, 
  										   FIFOLIOSOLICITUD, 
  										   FIIDDETALLE, 
  										   FIIDESTATUSPEDIDO, 
  										   FIBANDERAERROR, 
  										   FIESTATUSCD, 
  										   FCOBSERVACIONES, 
  										   FIBORRADO)
  								  	VALUES (vlPais,
								  			vlCanal,
								  			vlSucursal,
			 								paPedido,
			 								paSku,
			 								paCantidad,
			 								paSolicitud,
			 								paDetalle,
			 								paEstNvo,
			 								paError,
			 								csgUno,
			 								'SOLICITADO EN TIENDA',
			 								csgCERO);
  		END IF;
  		
  		INSERT INTO UNIFORMES.TABITACORASOLICITUD (FIIDBITACORA, 
			 											FIFOLIOSOLICITUD, 
			 											FIIDDETALLE, 
			 											FIPAIS, 
			 											FCCANAL, 
			 											FIIDSUCURSAL, 
			 											FINUMPEDIDO, 
			 											FISKU, 
			 											FIIDTIPOEVENTO, 
			 											FXDATOS, 
			 											FIIDESTATUSANT, 
			 											FIIDESTATUSNVO, 
			 											FDFECHAEVENTO, 
			 											FIERROR, 
			 											FCCOMENTARIOS)
			        							VALUES  (vlIdBitacora,
			        									 paSolicitud,
			        							         paDetalle, 
			 											 vlPais,
								  						 vlCanal,
								  						 vlSucursal,
			 											 paPedido,
			 											 paSku,
			 											 paEvento,
			 											 XMLTYPE(paDatos),
			 											 paEstAnt,
			 											 paEstNvo,
			 											 SYSDATE,
			 											 paError,
			 											 ' ');
		paResultado := csgUno;
		COMMIT;
  		
          
       	EXCEPTION
          WHEN OTHERS THEN
              ROLLBACK;
              vgErrCode := SQLCODE;
              vgErrMsg := SQLERRM;
              RAISE_APPLICATION_ERROR (-20002,'ERROR ' || vgErrCode  || ' EN "PASRVUNIFORMESCOMERCIO.SPACTPEDIDOSOLBITACORA": ' || vgErrMsg);
              
  END SPACTPEDIDOSOLBITACORA;
   
   FUNCTION FNCONSSOLPENDGRABARCD
   RETURN rcgCursor
   IS 
  /*************************************************************
   Proyecto:                         Sistema de Uniformes
   Descripcion:                      Consulta datos de empleado
   Parametros de entrada:            paNumEmpleado    Numero de empleado
   Parametros de salida:             curDatos         Cursor de referencia
   Parametros de entrada-salida      No aplica
   Precondiciones:                   Tener creado el esquema
   Creador:                          
   Fecha de creacion:                
  *************************************************************/
  curCursorSalida rcgCursor;
  vlSolenTienda  NUMBER(1):= 1;
  BEGIN
          OPEN curCursorSalida FOR
        SELECT S.FIFOLIOSOLICITUD,
			   D.FIIDDETALLE,
			   E.FIEMPLEADO,
			   D.FIPAIS,
			   TO_NUMBER(TRIM(D.FCCANAL)) FICANAL,
			   TO_NUMBER( SUBSTR(TO_CHAR(D.FISUCURSAL),3,4) ) FISUCURSAL,
			   T.FCDIRIP,
			   B.FISKU,
			   B.FINUMPEDIDO,
			   D.FICANTIDAD
		  FROM UNIFORMES.TASOLICITUDES S
	INNER JOIN UNIFORMES.TASOLICITUDESDETALLE D
			ON S.FIFOLIOSOLICITUD = D.FIFOLIOSOLICITUD
	INNER JOIN UNIFORMES.TAEMPLEADOS E
			ON E.FIEMPLEADO = S.FIIDEMPLEADO
    INNER JOIN UNIFORMES.TATIENDAS T
            ON T.FIPAIS = D.FIPAIS
           AND T.FCCANAL = D.FCCANAL
           AND T.FISUCURSAL = D.FISUCURSAL
	INNER JOIN UNIFORMES.TABITACORASOLICITUD B
	        ON B.FIFOLIOSOLICITUD = D.FIFOLIOSOLICITUD
	       AND B.FIIDDETALLE = D.FIIDDETALLE
	INNER JOIN (  SELECT MAX(FDFECHAEVENTO) FECHABITACORA,FIFOLIOSOLICITUD,FIIDDETALLE
				    FROM UNIFORMES.TABITACORASOLICITUD
					  GROUP BY FIFOLIOSOLICITUD,FIIDDETALLE ) BACT
	        ON B.FIFOLIOSOLICITUD = BACT.FIFOLIOSOLICITUD
	       AND B.FIIDDETALLE = BACT.FIIDDETALLE
	       AND B.FDFECHAEVENTO = BACT.FECHABITACORA
	     WHERE B.FIIDESTATUSNVO = vlSolenTienda 
		   AND B.FIIDESTATUSANT = vlSolenTienda 
		   AND B.FINUMPEDIDO IS NOT NULL
		   AND B.FIERROR = csgCero
	  ORDER BY S.FIFOLIOSOLICITUD,
			   D.FIIDDETALLE,
			   E.FIEMPLEADO;
       RETURN curCursorSalida;
       	EXCEPTION
          WHEN OTHERS THEN
              vgErrCode := SQLCODE;
              vgErrMsg := SQLERRM;
              RAISE_APPLICATION_ERROR (-20002,'ERROR ' || vgErrCode  || ' EN "PASRVUNIFORMESCOMERCIO.FNCONSSOLPENDGRABARCD": ' || vgErrMsg);
              
  END FNCONSSOLPENDGRABARCD;
  
  FUNCTION FNCONSULTAPEDIDOSENCD
  RETURN rcgCursor
  IS 
  /*************************************************************
   Proyecto:                         Sistema de Uniformes
   Descripcion:                      Consulta datos de empleado
   Parametros de entrada:            paNumEmpleado    Numero de empleado
   Parametros de salida:             curDatos         Cursor de referencia
   Parametros de entrada-salida      No aplica
   Precondiciones:                   Tener creado el esquema
   Creador:                          
   Fecha de creacion:                
  *************************************************************/
  curCursorSalida rcgCursor;
  vlSolenTienda  NUMBER(1):= 1;
  vlSolenCD  NUMBER(1):= 2;
  
  BEGIN
          OPEN curCursorSalida FOR
        SELECT S.FIFOLIOSOLICITUD,
			   D.FIIDDETALLE,
			   E.FIEMPLEADO,
			   D.FIPAIS,
			   TO_NUMBER(TRIM(D.FCCANAL)) FICANAL,
			   TO_NUMBER( SUBSTR(TO_CHAR(D.FISUCURSAL),3,4) ) FISUCURSAL,
			   T.FCDIRIP,
			   B.FISKU,
			   B.FINUMPEDIDO,
			   D.FICANTIDAD
		  FROM UNIFORMES.TASOLICITUDES S
	INNER JOIN UNIFORMES.TASOLICITUDESDETALLE D
			ON S.FIFOLIOSOLICITUD = D.FIFOLIOSOLICITUD
	INNER JOIN UNIFORMES.TAEMPLEADOS E
			ON E.FIEMPLEADO = S.FIIDEMPLEADO
    INNER JOIN UNIFORMES.TATIENDAS T
            ON T.FIPAIS = D.FIPAIS
           AND T.FCCANAL = D.FCCANAL
           AND T.FISUCURSAL = D.FISUCURSAL
	INNER JOIN UNIFORMES.TABITACORASOLICITUD B
	        ON B.FIFOLIOSOLICITUD = D.FIFOLIOSOLICITUD
	       AND B.FIIDDETALLE = D.FIIDDETALLE
	INNER JOIN (  SELECT MAX(FDFECHAEVENTO) FECHABITACORA,FIFOLIOSOLICITUD,FIIDDETALLE
				    FROM UNIFORMES.TABITACORASOLICITUD
					  GROUP BY FIFOLIOSOLICITUD,FIIDDETALLE ) BACT
	        ON B.FIFOLIOSOLICITUD = BACT.FIFOLIOSOLICITUD
	       AND B.FIIDDETALLE = BACT.FIIDDETALLE
	       AND B.FDFECHAEVENTO = BACT.FECHABITACORA
	     WHERE B.FIIDESTATUSNVO = vlSolenCD 
		   AND B.FIIDESTATUSANT = vlSolenTienda 
		   AND B.FINUMPEDIDO IS NOT NULL
		   AND B.FIERROR = csgCero
	  ORDER BY S.FIFOLIOSOLICITUD,
			   D.FIIDDETALLE,
			   E.FIEMPLEADO;
       RETURN curCursorSalida;
       	EXCEPTION
          WHEN OTHERS THEN
              vgErrCode := SQLCODE;
              vgErrMsg := SQLERRM;
              RAISE_APPLICATION_ERROR (-20002,'ERROR ' || vgErrCode  || ' EN "PASRVUNIFORMESCOMERCIO.FNCONSULTAPEDIDOSENCD": ' || vgErrMsg);
              
  END FNCONSULTAPEDIDOSENCD;
   
END PASRVUNIFORMESCOMERCIO;

