package mx.emite.sdk.clientes.operaciones.emisores.nom32;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.CancelarRequest;
import mx.emite.sdk.proxy.response.CancelarResponse;

/**
 *  <h1>Operacion de cancelación de cfdi version 3.2</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class Nom32Cancelador extends Operacion<CancelarRequest,CancelarResponse> {

	public Nom32Cancelador(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.NOM32_CANCELAR);
	}

	
	
	/**
	 * Método que cancela un comprobante cfdi 3.2 
	 * 
	 * @param request Parametros de cancelación (usuario, contraseña, lista de uuids y pfx en caso de no tenerlo guardado en Scot)
	 * @return Objeto con el xml de acuse de recibo de la cancelación ante el SAT
	 * @throws ApiException en caso de que ocurra algun error
	 * @see CancelarRequest
	 */
	@Override
	public CancelarResponse ejecuta(CancelarRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,CancelarResponse.class));
	}
	
}
