package mx.emite.sdk.pruebas.ejemplos.emisores;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.cfdi32.Comprobante;
import mx.emite.sdk.cfdi32.Concepto;
import mx.emite.sdk.cfdi32.Conceptos;
import mx.emite.sdk.cfdi32.Emisor;
import mx.emite.sdk.cfdi32.Impuestos;
import mx.emite.sdk.cfdi32.Receptor;
import mx.emite.sdk.cfdi32.RegimenFiscal;
import mx.emite.sdk.cfdi32.Retencion;
import mx.emite.sdk.cfdi32.Retenciones;
import mx.emite.sdk.cfdi32.TUbicacion;
import mx.emite.sdk.cfdi32.TUbicacionFiscal;
import mx.emite.sdk.cfdi32.Traslado;
import mx.emite.sdk.cfdi32.Traslados;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.enums.sat.Estados;
import mx.emite.sdk.enums.sat.TipoPago;
import mx.emite.sdk.enums.sat.FormasPago;
import mx.emite.sdk.enums.sat.Monedas;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.RegimenesFiscales;
import mx.emite.sdk.enums.sat.TipoDeComprobante;
import mx.emite.sdk.enums.sat.TiposImpuesto;
import mx.emite.sdk.enums.sat.UnidadesMedida;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.SellarYTimbrarRequest;
import mx.emite.sdk.proxy.response.SellarYTimbrarResponse;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;

@Slf4j
public class FacturaSellaYTimbraEjemplo extends Ejemplo{

	
	@Test
	public void pruebaXmlBase64(){
		try{
		final Comprobante comprobante = Comprobante.builder()
				.lugarExpedicion("México, D.F.")
				.fecha(LocalDateTime.now())
				.folio(1000)
				.formaDePago(TipoPago.PAGOENUNASOLAEXHIBICION)
				.metodoDePago(FormasPago.CANCELACION)
				.tipoDeComprobante(TipoDeComprobante.INGRESO)
				.subTotal(BigDecimal.ZERO)
				.total(BigDecimal.ZERO)
				.moneda(Monedas.MXN)
				.numCtaPago("NO IDENTIFICADO")
				.emisor(Emisor.builder()
						.nombre(props.getProperty("emisor.nombre"))
						.rfc(props.getProperty("emisor.usuario"))
						.domicilioFiscal(TUbicacionFiscal.builder()
										.calle("CALLE")
										.codigoPostal("03300")
										.municipio("BENITO JUAREZ")
										.estado(Estados.DISTRITOFEDERAL ) 
										.pais(Paises.MEXICO )
								.build())
						.regimenFiscal(RegimenFiscal.builder()
								.Regimen(RegimenesFiscales.GENERALDELEYPERSONASMORALES)
								.build())
						.build())				
				.receptor(Receptor.builder()
						.nombre("RECEPTOR SA DE CV")
						.rfc("XAXX010101000")
						.domicilio(TUbicacion.builder()
										.calle("CALLE")
										.codigoPostal("03300")
										.municipio("BENITO JUAREZ")
										.estado(Estados.DISTRITOFEDERAL ) 
										.pais(Paises.MEXICO )
								.build())
						
						.build())
				.conceptos(Conceptos.builder()
							.concepto(Concepto.builder()
										.cantidad(BigDecimal.ONE)
										.descripcion("DESCRIPCION")
										.importe(BigDecimal.ZERO)
										.valorUnitario(BigDecimal.ZERO)
										.unidad(UnidadesMedida.SERVICIO)
									.build())
						.build())
				.impuestos(Impuestos.builder()
							.totalImpuestosRetenidos(BigDecimal.valueOf(0))
							.totalImpuestosTrasladados(BigDecimal.ZERO)
							.retenciones(Retenciones.builder()
											.retencion(Retencion.builder()
											.importe(BigDecimal.ZERO)
											.impuesto(TiposImpuesto.ISR)
											.build())
											
									.build())
							.traslados(Traslados.builder()
											.traslado(Traslado.builder()
											.tasa(BigDecimal.valueOf(16))
											.importe(BigDecimal.ZERO)
											.impuesto(TiposImpuesto.IVA)
											.build())
											
									.build())
						.build())
				.build()
				;
		
		
			
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		
		final SellarYTimbrarRequest request = SellarYTimbrarRequest.builder()
				.usuario(props.getProperty("emisor.usuario"))
				.contrasena(props.getProperty("emisor.contrasena"))
				.comprobante(comprobante)
				.build();
		
		final SellarYTimbrarResponse respuesta = api.selladorytimbrador32().ejecuta(request);
		log.debug(respuesta.toString());
		log.debug(respuesta.getXmlDecodificado());
		}catch(ApiException ex){
			log.error(Arrays.toString(ex.getErrores().toArray()),ex);
		}
	}
	
	
}
