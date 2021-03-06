package mx.emite.sdk.cfdi32.nomina12;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.RegimenesFiscales;
import mx.emite.sdk.enums.sat.adaptadores.RegimenesFiscalesIdSatAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegimenFiscal{

	@XmlAttribute(name = "Regimen")
	@XmlJavaTypeAdapter(RegimenesFiscalesIdSatAdapter.class)
	@NotNull
	protected RegimenesFiscales Regimen;

	
}
