package mx.emite.sdk.clientes.operaciones.emisores.nom32;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.Operacion;
import mx.emite.sdk.enums.Proveedor;
import mx.emite.sdk.enums.Rutas;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.PdfRequest;
import mx.emite.sdk.proxy.response.PdfResponse;

/**
 *  <h1>Operacion de descarga de pdf</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
public class Nom32Pdf extends Operacion<PdfRequest,PdfResponse> {

	public Nom32Pdf(final ClienteJson cliente) {
		super(cliente,Proveedor.PROXY,Rutas.NOM32_PDF);
	}

	
	
	/**
	 * Método que descarga un pdf
	 * 
	 * @param request Parametros de descarga (usuario, contraseña, uuid)
	 * @return Objeto con el pdf binario codificado en Base 64
	 * @throws ApiException en caso de que ocurra algun error
	 * @see PdfRequest
	 */
	@Override
	public PdfResponse ejecuta(PdfRequest request) throws ApiException{
		final String ruta = creaRuta(request);
		return procesa(this.getCliente().post(ruta,request,PdfResponse.class));
	}
	
}
