package mx.emite.sdk.pruebas.ejemplos.emisores;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.cfdi32.Concepto;
import mx.emite.sdk.cfdi32.Conceptos;
import mx.emite.sdk.cfdi32.Emisor;
import mx.emite.sdk.cfdi32.Impuestos;
import mx.emite.sdk.cfdi32.Receptor;
import mx.emite.sdk.cfdi32.RegimenFiscal;
import mx.emite.sdk.cfdi32.Retencion;
import mx.emite.sdk.cfdi32.Retenciones;
import mx.emite.sdk.cfdi32.TUbicacionFiscal;
import mx.emite.sdk.cfdi32.Traslado;
import mx.emite.sdk.cfdi32.Traslados;
import mx.emite.sdk.cfdi32.nomina11.Complemento;
import mx.emite.sdk.cfdi32.nomina11.ComprobanteNomina11;
import mx.emite.sdk.cfdi32.nomina11.Deduccion;
import mx.emite.sdk.cfdi32.nomina11.Deducciones;
import mx.emite.sdk.cfdi32.nomina11.Nomina;
import mx.emite.sdk.cfdi32.nomina11.Percepcion;
import mx.emite.sdk.cfdi32.nomina11.Percepciones;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.enums.sat.Estados;
import mx.emite.sdk.enums.sat.MetodosPago;
import mx.emite.sdk.enums.sat.Monedas;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.RegimenesFiscales;
import mx.emite.sdk.enums.sat.TipoPago;
import mx.emite.sdk.enums.sat.TiposDeduccion;
import mx.emite.sdk.enums.sat.TiposImpuesto;
import mx.emite.sdk.enums.sat.TiposPercepcion;
import mx.emite.sdk.enums.sat.TiposPeriodicidad;
import mx.emite.sdk.enums.sat.TiposRegimen;
import mx.emite.sdk.enums.sat.UnidadesMedida;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.SellarYTimbrarRequest;
import mx.emite.sdk.proxy.response.SellarYTimbrarResponse;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;

@Slf4j
public class FacturaSellaYTimbraNominaEjemplo extends Ejemplo{

	
	@Test
	public void pruebaXmlBase64(){
		try{
		final ComprobanteNomina11 comprobante = ComprobanteNomina11.builder()
				.lugarExpedicion("México, D.F.")
				.fecha(LocalDateTime.now())
				.serie("N")
				.folio("2")
				.formaDePago(TipoPago.PAGOENUNASOLAEXHIBICION)
				.metodoDePago(MetodosPago.OTROS)
				.subTotal(BigDecimal.ZERO)
				.total(BigDecimal.ZERO)
				.moneda(Monedas.MXN)
				.numCtaPago("NO IDENTIFICADO")
				.emisor(Emisor.builder()
						.nombre(props.getProperty("emisor.nombre"))
						.rfc(props.getProperty("emisor.rfc"))
						.domicilioFiscal(TUbicacionFiscal.builder()
										.calle("EJE CENTRAL LAZARO CARDENAS")
										.noExterior("1006")
										.noInterior("2")
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
						.nombre("VENTA AL PUBLICO")
						.rfc("XAXX010101000") 
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
				.complemento(Complemento.builder()
						.nomina(Nomina.builder()
								.numEmpleado("123456")
								.curp("SATI771031HDFNNN05")
								.tipoRegimen(TiposRegimen.ASIMILADOS_HONORARIOS)
								.fechaPago(LocalDate.now())
								.fechaInicialPago(LocalDate.now())
								.fechaFinalPago(LocalDate.now())
								.numDiasPagados(1)
								.periodicidadPago(TiposPeriodicidad.DIARIO)
								.percepciones(Percepciones.builder()
										.totalGravado(BigDecimal.ZERO)
										.totalExento(BigDecimal.ZERO)
										.percepcion(Percepcion.builder()
												.tipoPercepcion(TiposPercepcion.OTROSINGRESOSPORSALARIOS)
												.clave(TiposPercepcion.OTROSINGRESOSPORSALARIOS.getClave())
												.concepto(TiposPercepcion.OTROSINGRESOSPORSALARIOS.getConcepto())
												.importeGravado(BigDecimal.ZERO)
												.importeExento(BigDecimal.ZERO)
												.build())
										.build())
								.deducciones(Deducciones.builder()
										.totalGravado(BigDecimal.ZERO)
										.totalExento(BigDecimal.ZERO)
										.deduccion(Deduccion.builder()
												.tipoDeduccion(TiposDeduccion.ISR)
												.clave(TiposDeduccion.ISR.getClave())
												.concepto(TiposDeduccion.ISR.getConcepto())
												.importeGravado(BigDecimal.ZERO)
												.importeExento(BigDecimal.ZERO)
												.build())
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
		//log.debug(Utilerias.decodifica64Utf8(request.getXml()));
		
		final SellarYTimbrarResponse respuesta = api.nom32_SelladorTimbrador().ejecuta(request);
		log.debug(respuesta.toString().replace(",", ",\n"));
		log.debug(respuesta.getXmlDecodificado());
		}catch(ApiException ex){
			log.error(Arrays.toString(ex.getErrores().toArray()),ex);
		}
	}
	
	public static void main(String[] args){
		String fecha="2016-04-20T11:59:33.153863";
		String isolargo="yyyy-MM-dd'T'HH:mm:ss.SSSSSSS";
		try{
			System.out.println(DateTimeFormatter.ofPattern(isolargo).parse(fecha));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	
}
