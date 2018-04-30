package mx.emite.sdk.cfdi33.complementos.cdc11;

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
@XmlType(name = "Determinados11")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class Determinados implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2503967578093747259L;
	@XmlElement(name="Determinado", namespace = ConsumoDeCombustibles11.NAMESPACE)
	@Valid @Singular("determinado")
	@NotEmpty
	private List<Determinado> determinados;
	
	
	
}
