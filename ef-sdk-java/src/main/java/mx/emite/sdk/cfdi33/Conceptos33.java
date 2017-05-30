package mx.emite.sdk.cfdi33;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conceptos33 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4858874427627113221L;
	
	/**
	 * conceptos Nodo requerido para registrar la información detallada de un bien o servicio amparado en el comprobante.
	 */
	@XmlElement(name="Concepto", namespace = "http://www.sat.gob.mx/cfd/3")
	@NotEmpty
	@Valid
	@Singular("concepto")
	protected List<Concepto33> conceptos;

	
	
}
