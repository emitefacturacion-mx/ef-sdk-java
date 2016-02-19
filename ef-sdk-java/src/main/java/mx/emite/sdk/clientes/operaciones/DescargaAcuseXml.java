package mx.emite.sdk.clientes.operaciones;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.XmlRequest;
import mx.emite.sdk.proxy.response.XmlResponse;

/**
 *  <h1>Operacion de descarga acuses de cancelación</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class DescargaAcuseXml extends Operacion<XmlRequest,XmlResponse> {

	public DescargaAcuseXml(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.ACUSE);
	}

	
	
	/**
	 * Método que descarga un acuse de cancelación 
	 * 
	 * @param request Parametros de descarga (usuario, contraseña, uuid)
	 * @return Objeto con el xml codificado en Base 64
	 * @throws ApiException en caso de que ocurra algun error
	 * @see XmlRequest
	 */
	@Override
	public XmlResponse ejecuta(XmlRequest request) throws ApiException{
		final String ruta = creaRuta();
		return this.getCliente().post(ruta,request,XmlResponse.class);
	}
	
}
