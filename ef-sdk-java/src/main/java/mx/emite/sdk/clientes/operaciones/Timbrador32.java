package mx.emite.sdk.clientes.operaciones;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.TimbrarRequest;
import mx.emite.sdk.proxy.response.TimbrarResponse;

/**
 *  <h1>Operacion de timbrado de cfdi sellado en version 3.2</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class Timbrador32 extends Operacion<TimbrarRequest,TimbrarResponse> {

	public Timbrador32(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.TIMBRAR32);
	}

	
	
	/**
	 * Método que timbra un comprobante cfdi 3.2 sellado en Base64
	 * 
	 * @param request
	 * @return
	 * @throws ApiException
	 * @see TimbrarRequest
	 */
	@Override
	public TimbrarResponse ejecuta(TimbrarRequest request) throws ApiException{
		final String ruta = creaRuta();
		return this.getCliente().post(ruta,request,TimbrarResponse.class);
	}
	
}
