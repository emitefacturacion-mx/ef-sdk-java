package mx.emite.sdk.cfdi32.nomina12;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
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
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.MetodosPago;
import mx.emite.sdk.enums.sat.Monedas;
import mx.emite.sdk.enums.sat.TipoDeComprobante;
import mx.emite.sdk.enums.sat.adaptadores.MetodosPagoAdapter;
import mx.emite.sdk.enums.sat.adaptadores.MonedasAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TipoDeComprobanteAdapter;
import mx.emite.sdk.serializers.LocalDateTimeAdapter;
import mx.emite.sdk.utils.Utilerias;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "emisor", "receptor", "conceptos", "impuestos", "complemento" })
@XmlRootElement(name = "Comprobante", namespace = "http://www.sat.gob.mx/cfd/3")
@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class ComprobanteNomina12  {

	
	@XmlElement(name = "Emisor", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private Emisor emisor;

	@XmlElement(name = "Receptor", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private Receptor receptor;

	@XmlElement(name = "Conceptos", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private Conceptos conceptos;

	@XmlElement(name = "Impuestos", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @NotNull
	private final Impuestos impuestos = new Impuestos();

	@XmlElement(name = "Complemento", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	private Complemento complemento = null;

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

	@XmlAttribute(required = true,name="formaDePago")
	@NotNull 
	protected final String formaDePago = "En una sola exhibición";

	@XmlAttribute
	@NotNull
	@XmlJavaTypeAdapter(MetodosPagoAdapter.class)
	protected final MetodosPago metodoDePago = MetodosPago.NA;

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
	protected final TipoDeComprobante tipoDeComprobante = TipoDeComprobante.EGRESO;

	@XmlAttribute(required = true)
	@NotNull @Min(value = 0)
	protected BigDecimal total;

	@XmlAttribute(name = "Moneda")
	@XmlJavaTypeAdapter(MonedasAdapter.class)
	protected final Monedas moneda = Monedas.MXN;

	@XmlAttribute(name = "TipoCambio")
	@Min(value = 0)
	protected final BigDecimal tipoCambio = null;

	@XmlAttribute(required = true)
	protected final String version = "3.2";

	@XmlAttribute(required = true, name = "NumCtaPago")
	@Null
	protected final String numCtaPago = null;

	public String generaXml(){
		return Utilerias.marshallnom12(this);
	}
}
