
package com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ConectorUnicoSoap", targetNamespace = "http://tempuri.org/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ConectorUnicoSoap {


    /**
     * Consulta el saldo disponible con SAP
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.VerificaSaldoResponse
     */
    @WebMethod(operationName = "VerificaSaldo", action = "http://tempuri.org/VerificaSaldo")
    @WebResult(name = "VerificaSaldoResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public VerificaSaldoResponse verificaSaldo(
        @WebParam(name = "VerificaSaldo", targetNamespace = "http://tempuri.org/", partName = "parameters")
        VerificaSaldo parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.AvanceCargaRealSPPIResponse
     */
    @WebMethod(operationName = "AvanceCargaRealSPPI", action = "http://tempuri.org/AvanceCargaRealSPPI")
    @WebResult(name = "AvanceCargaRealSPPIResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public AvanceCargaRealSPPIResponse avanceCargaRealSPPI(
        @WebParam(name = "AvanceCargaRealSPPI", targetNamespace = "http://tempuri.org/", partName = "parameters")
        AvanceCargaRealSPPI parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.AvanceCargaVirtualSPPIResponse
     */
    @WebMethod(operationName = "AvanceCargaVirtualSPPI", action = "http://tempuri.org/AvanceCargaVirtualSPPI")
    @WebResult(name = "AvanceCargaVirtualSPPIResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public AvanceCargaVirtualSPPIResponse avanceCargaVirtualSPPI(
        @WebParam(name = "AvanceCargaVirtualSPPI", targetNamespace = "http://tempuri.org/", partName = "parameters")
        AvanceCargaVirtualSPPI parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.CargaRealesSPPIResponse
     */
    @WebMethod(operationName = "CargaRealesSPPI", action = "http://tempuri.org/CargaRealesSPPI")
    @WebResult(name = "CargaRealesSPPIResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public CargaRealesSPPIResponse cargaRealesSPPI(
        @WebParam(name = "CargaRealesSPPI", targetNamespace = "http://tempuri.org/", partName = "parameters")
        CargaRealesSPPI parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.CargaRealesSPPIDistribuidoResponse
     */
    @WebMethod(operationName = "CargaRealesSPPIDistribuido", action = "http://tempuri.org/CargaRealesSPPIDistribuido")
    @WebResult(name = "CargaRealesSPPIDistribuidoResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public CargaRealesSPPIDistribuidoResponse cargaRealesSPPIDistribuido(
        @WebParam(name = "CargaRealesSPPIDistribuido", targetNamespace = "http://tempuri.org/", partName = "parameters")
        CargaRealesSPPIDistribuido parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.CargaVirtualesIUSASPPIResponse
     */
    @WebMethod(operationName = "CargaVirtualesIUSASPPI", action = "http://tempuri.org/CargaVirtualesIUSASPPI")
    @WebResult(name = "CargaVirtualesIUSASPPIResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public CargaVirtualesIUSASPPIResponse cargaVirtualesIUSASPPI(
        @WebParam(name = "CargaVirtualesIUSASPPI", targetNamespace = "http://tempuri.org/", partName = "parameters")
        CargaVirtualesIUSASPPI parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.CargaVirtualesSPPIResponse
     */
    @WebMethod(operationName = "CargaVirtualesSPPI", action = "http://tempuri.org/CargaVirtualesSPPI")
    @WebResult(name = "CargaVirtualesSPPIResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public CargaVirtualesSPPIResponse cargaVirtualesSPPI(
        @WebParam(name = "CargaVirtualesSPPI", targetNamespace = "http://tempuri.org/", partName = "parameters")
        CargaVirtualesSPPI parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.CargaVirtualesSPPIDistribuidoResponse
     */
    @WebMethod(operationName = "CargaVirtualesSPPIDistribuido", action = "http://tempuri.org/CargaVirtualesSPPIDistribuido")
    @WebResult(name = "CargaVirtualesSPPIDistribuidoResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public CargaVirtualesSPPIDistribuidoResponse cargaVirtualesSPPIDistribuido(
        @WebParam(name = "CargaVirtualesSPPIDistribuido", targetNamespace = "http://tempuri.org/", partName = "parameters")
        CargaVirtualesSPPIDistribuido parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.CatalogoCentrosCostosResponse
     */
    @WebMethod(operationName = "CatalogoCentrosCostos", action = "http://tempuri.org/CatalogoCentrosCostos")
    @WebResult(name = "CatalogoCentrosCostosResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public CatalogoCentrosCostosResponse catalogoCentrosCostos(
        @WebParam(name = "CatalogoCentrosCostos", targetNamespace = "http://tempuri.org/", partName = "parameters")
        CatalogoCentrosCostos parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.CatalogoServiciosResponse
     */
    @WebMethod(operationName = "CatalogoServicios", action = "http://tempuri.org/CatalogoServicios")
    @WebResult(name = "CatalogoServiciosResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public CatalogoServiciosResponse catalogoServicios(
        @WebParam(name = "CatalogoServicios", targetNamespace = "http://tempuri.org/", partName = "parameters")
        CatalogoServicios parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.CatalogoServiciosMonedaResponse
     */
    @WebMethod(operationName = "CatalogoServiciosMoneda", action = "http://tempuri.org/CatalogoServiciosMoneda")
    @WebResult(name = "CatalogoServiciosMonedaResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public CatalogoServiciosMonedaResponse catalogoServiciosMoneda(
        @WebParam(name = "CatalogoServiciosMoneda", targetNamespace = "http://tempuri.org/", partName = "parameters")
        CatalogoServiciosMoneda parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.DetalleCargaRealSPPIResponse
     */
    @WebMethod(operationName = "DetalleCargaRealSPPI", action = "http://tempuri.org/DetalleCargaRealSPPI")
    @WebResult(name = "DetalleCargaRealSPPIResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public DetalleCargaRealSPPIResponse detalleCargaRealSPPI(
        @WebParam(name = "DetalleCargaRealSPPI", targetNamespace = "http://tempuri.org/", partName = "parameters")
        DetalleCargaRealSPPI parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.DetalleCargaRealSPPIDistribuidoResponse
     */
    @WebMethod(operationName = "DetalleCargaRealSPPIDistribuido", action = "http://tempuri.org/DetalleCargaRealSPPIDistribuido")
    @WebResult(name = "DetalleCargaRealSPPIDistribuidoResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public DetalleCargaRealSPPIDistribuidoResponse detalleCargaRealSPPIDistribuido(
        @WebParam(name = "DetalleCargaRealSPPIDistribuido", targetNamespace = "http://tempuri.org/", partName = "parameters")
        DetalleCargaRealSPPIDistribuido parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.DetalleCargaVirtualSPPIResponse
     */
    @WebMethod(operationName = "DetalleCargaVirtualSPPI", action = "http://tempuri.org/DetalleCargaVirtualSPPI")
    @WebResult(name = "DetalleCargaVirtualSPPIResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public DetalleCargaVirtualSPPIResponse detalleCargaVirtualSPPI(
        @WebParam(name = "DetalleCargaVirtualSPPI", targetNamespace = "http://tempuri.org/", partName = "parameters")
        DetalleCargaVirtualSPPI parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.DetalleCargaVirtualSPPIDistribuidoResponse
     */
    @WebMethod(operationName = "DetalleCargaVirtualSPPIDistribuido", action = "http://tempuri.org/DetalleCargaVirtualSPPIDistribuido")
    @WebResult(name = "DetalleCargaVirtualSPPIDistribuidoResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public DetalleCargaVirtualSPPIDistribuidoResponse detalleCargaVirtualSPPIDistribuido(
        @WebParam(name = "DetalleCargaVirtualSPPIDistribuido", targetNamespace = "http://tempuri.org/", partName = "parameters")
        DetalleCargaVirtualSPPIDistribuido parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.DetalleDisponibleSPPIResponse
     */
    @WebMethod(operationName = "DetalleDisponibleSPPI", action = "http://tempuri.org/DetalleDisponibleSPPI")
    @WebResult(name = "DetalleDisponibleSPPIResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public DetalleDisponibleSPPIResponse detalleDisponibleSPPI(
        @WebParam(name = "DetalleDisponibleSPPI", targetNamespace = "http://tempuri.org/", partName = "parameters")
        DetalleDisponibleSPPI parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.DetalleFacturacionRealSPPIResponse
     */
    @WebMethod(operationName = "DetalleFacturacionRealSPPI", action = "http://tempuri.org/DetalleFacturacionRealSPPI")
    @WebResult(name = "DetalleFacturacionRealSPPIResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public DetalleFacturacionRealSPPIResponse detalleFacturacionRealSPPI(
        @WebParam(name = "DetalleFacturacionRealSPPI", targetNamespace = "http://tempuri.org/", partName = "parameters")
        DetalleFacturacionRealSPPI parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.DetalleFacturacionVirtualSPPIResponse
     */
    @WebMethod(operationName = "DetalleFacturacionVirtualSPPI", action = "http://tempuri.org/DetalleFacturacionVirtualSPPI")
    @WebResult(name = "DetalleFacturacionVirtualSPPIResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public DetalleFacturacionVirtualSPPIResponse detalleFacturacionVirtualSPPI(
        @WebParam(name = "DetalleFacturacionVirtualSPPI", targetNamespace = "http://tempuri.org/", partName = "parameters")
        DetalleFacturacionVirtualSPPI parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.SPPITVAAvanceCargaVirtualSPPIResponse
     */
    @WebMethod(operationName = "SPPITVAAvanceCargaVirtualSPPI", action = "http://tempuri.org/SPPITVAAvanceCargaVirtualSPPI")
    @WebResult(name = "SPPITVAAvanceCargaVirtualSPPIResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public SPPITVAAvanceCargaVirtualSPPIResponse sppitvaAvanceCargaVirtualSPPI(
        @WebParam(name = "SPPITVAAvanceCargaVirtualSPPI", targetNamespace = "http://tempuri.org/", partName = "parameters")
        SPPITVAAvanceCargaVirtualSPPI parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.SPPITVACatalogoCentrosCostosResponse
     */
    @WebMethod(operationName = "SPPITVACatalogoCentrosCostos", action = "http://tempuri.org/SPPITVACatalogoCentrosCostos")
    @WebResult(name = "SPPITVACatalogoCentrosCostosResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public SPPITVACatalogoCentrosCostosResponse sppitvaCatalogoCentrosCostos(
        @WebParam(name = "SPPITVACatalogoCentrosCostos", targetNamespace = "http://tempuri.org/", partName = "parameters")
        SPPITVACatalogoCentrosCostos parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.SPPITVACatalogoServiciosMonedaResponse
     */
    @WebMethod(operationName = "SPPITVACatalogoServiciosMoneda", action = "http://tempuri.org/SPPITVACatalogoServiciosMoneda")
    @WebResult(name = "SPPITVACatalogoServiciosMonedaResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public SPPITVACatalogoServiciosMonedaResponse sppitvaCatalogoServiciosMoneda(
        @WebParam(name = "SPPITVACatalogoServiciosMoneda", targetNamespace = "http://tempuri.org/", partName = "parameters")
        SPPITVACatalogoServiciosMoneda parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.SPPITVADetalleCargaVirtualSPPIResponse
     */
    @WebMethod(operationName = "SPPITVADetalleCargaVirtualSPPI", action = "http://tempuri.org/SPPITVADetalleCargaVirtualSPPI")
    @WebResult(name = "SPPITVADetalleCargaVirtualSPPIResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public SPPITVADetalleCargaVirtualSPPIResponse sppitvaDetalleCargaVirtualSPPI(
        @WebParam(name = "SPPITVADetalleCargaVirtualSPPI", targetNamespace = "http://tempuri.org/", partName = "parameters")
        SPPITVADetalleCargaVirtualSPPI parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.elektra.uniformes.comercio.cron.dao.clienteWS.SPPI.SPPITVADetalleFacturacionVirtualSPPIResponse
     */
    @WebMethod(operationName = "SPPITVADetalleFacturacionVirtualSPPI", action = "http://tempuri.org/SPPITVADetalleFacturacionVirtualSPPI")
    @WebResult(name = "SPPITVADetalleFacturacionVirtualSPPIResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public SPPITVADetalleFacturacionVirtualSPPIResponse sppitvaDetalleFacturacionVirtualSPPI(
        @WebParam(name = "SPPITVADetalleFacturacionVirtualSPPI", targetNamespace = "http://tempuri.org/", partName = "parameters")
        SPPITVADetalleFacturacionVirtualSPPI parameters);

}
