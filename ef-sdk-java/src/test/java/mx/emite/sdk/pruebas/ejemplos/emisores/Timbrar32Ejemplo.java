package mx.emite.sdk.pruebas.ejemplos.emisores;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.TimbrarRequest;
import mx.emite.sdk.proxy.response.TimbrarResponse;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;

@Slf4j
public class Timbrar32Ejemplo extends Ejemplo{

	
	@Test
	public void pruebaXmlBase64(){
		
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		try{
		final TimbrarRequest request = TimbrarRequest.builder()
				.usuario(props.getProperty("emisor.usuario"))
				.contrasena(props.getProperty("emisor.contrasena"))
				.xml(props.getProperty("xml.base64"))
				.build();
		
		final TimbrarResponse respuesta = api.cfdi32_Timbrador().ejecuta(request);
		log.debug(respuesta.toString());	
		}catch(ApiException ae){
			log.error("error",ae);
		}
	}
	
}
