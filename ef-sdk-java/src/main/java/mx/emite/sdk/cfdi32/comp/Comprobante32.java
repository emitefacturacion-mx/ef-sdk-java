package mx.emite.sdk.cfdi32.comp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.enums.sat.MetodosPago;
import mx.emite.sdk.enums.sat.Monedas;
import mx.emite.sdk.enums.sat.TipoDeComprobante;
import mx.emite.sdk.enums.sat.TipoPago;
import mx.emite.sdk.enums.sat.adaptadores.MetodosPagoAdapter;
import mx.emite.sdk.enums.sat.adaptadores.MonedasAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TipoDeComprobanteAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TipoPagoAdapter;
import mx.emite.sdk.serializers.LocalDateTimeAdapter;
import mx.emite.sdk.utils.Utilerias;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "emisor", "receptor", "conceptos", "impuestos", "complemento" })
@XmlRootElement(name = "Comprobante", namespace = "http://www.sat.gob.mx/cfd/3")
@Data
@Builder
@AllArgsConstructor
public class Comprobante32  {

	
	@XmlElement(name = "Emisor", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private Emisor32 emisor;

	@XmlElement(name = "Receptor", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private Receptor32 receptor;

	@XmlElement(name = "Conceptos", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private Conceptos32 conceptos;

	@XmlElement(name = "Impuestos", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private Impuestos32 impuestos;

	@XmlElement(name = "Complemento", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	private Complemento32 complemento;

	@XmlAttribute
	protected String certificado;

	@XmlAttribute(name = "LugarExpedicion")
	@NotNull
	protected String lugarExpedicion;

	@XmlAttribute
	@Min(value = 0)
	protected BigDecimal descuento;

	@XmlAttribute(name="motivoDescuento")
	protected String motivoDescuento;
	
	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@NotNull
	protected LocalDateTime fecha;

	@XmlAttribute(required = true)
	protected String folio;

	@XmlAttribute(required = true)
	@NotNull 
	@XmlJavaTypeAdapter(TipoPagoAdapter.class)
	protected TipoPago formaDePago = TipoPago.PAGOENUNASOLAEXHIBICION;

	@XmlAttribute
	@NotNull
	@XmlJavaTypeAdapter(MetodosPagoAdapter.class)
	protected MetodosPago metodoDePago;

	@XmlAttribute(required = true)
	@Digits(integer=20, fraction = 0)
	protected String noCertificado;

	@XmlAttribute(required = true)
	protected String sello;

	@XmlAttribute
	protected String serie;

	@XmlAttribute(required = true)
	@NotNull @Min(value = 0)
	protected BigDecimal subTotal;

	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(TipoDeComprobanteAdapter.class)
	@NotNull
	protected TipoDeComprobante tipoDeComprobante;

	@XmlAttribute(required = true)
	@NotNull @Min(value = 0)
	protected BigDecimal total;

	@XmlAttribute(name = "Moneda")
	@XmlJavaTypeAdapter(MonedasAdapter.class)
	protected Monedas moneda = Monedas.MXN;

	@XmlAttribute(name = "TipoCambio")
	@Min(value = 0)
	protected BigDecimal tipoCambio;

	@XmlAttribute(required = true)
	protected final String version = "3.2";

	@XmlAttribute(required = true, name = "NumCtaPago")
	@NotNull
	protected String numCtaPago;
	
	@XmlAttribute(name="FolioFiscalOrig")
	private String folioFiscalOrig;

	public String generaXml(){
		return Utilerias.marshallcfdi32(this);
	}
	
	public static Comprobante32 nuevo() {
		return builder().build();
	}
	
	
	public Comprobante32() {
		formaDePago = TipoPago.PAGOENUNASOLAEXHIBICION;
		moneda = Monedas.MXN;
	}
	
}
