package mx.emite.sdk.scot.request.extra;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.cfdi32.validadores.Cp;
import mx.emite.sdk.enums.sat.Estados;
import mx.emite.sdk.enums.sat.FormasPago;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.RegimenesFiscales;
import mx.emite.sdk.serializers.EstadosSerializer;
import mx.emite.sdk.serializers.FormasPagoSerializer;
import mx.emite.sdk.serializers.PaisesSerializer;
import mx.emite.sdk.serializers.RegimenesSerializer;

@Data
@Builder
public class SucursalInfo {

	/**
	 * @return nombre de la sucursal (único por emisor)
	 */
	@NotNull @Size(max=100)
	private String nombre;
	
	/**
	 * @return razonSocialRazón Social de la sucursal 
	 */
	@NotNull @Size(max=100)
	public String razonSocial;
	
	
	/**
	 * @return calle Calle de la sucursal
	 */
	@NotNull @Size(max=100)
	public String calle;
		
	/**
	 * @return noext No. exterior de la sucursal
	 */
	@Size(max=100)
	public String noext;
		
	/**
	 * @return noint No. interior de la sucursal
	 */
	@Size(max=100)
	public String noint;
		
	/**
	 * @return cp Código postal de la sucursal 
	 */
	@Size(min=5,max=5) @Cp @NotNull
	public String cp;
		
	/**
	 * @return colonia Colonia de la sucursal
	 */
	@Size(max=100)
	public String colonia;
		
	/**
	 * @return referencias Referencias de la sucursal
	 * 
	 */
	@Size(max=100)
	public String referencias;
		
	/**
	 * @return localidad Localidad de la sucursal
	 */
	@Size(max=50)
	public String localidad;
		
	/**
	 * @return municipio Municipio / de laegación de la sucursal
	 */
	@NotNull @Size(max=50)
	public String municipio;
	
	/**
	 * @param estado
	 */
	@NotNull
	@JsonSerialize(using=EstadosSerializer.class)
	public Estados idEstado;
		
	/**
	 * @param pais
	 */
	@NotNull
	@JsonSerialize(using=PaisesSerializer.class)
	public Paises idPais=Paises.MEXICO ;
	
	/**
	 * @param regimen
	 */
	@NotNull
	@JsonSerialize(using=RegimenesSerializer.class)
	public RegimenesFiscales idRegimen;
	
	/**
	 * @param forma de pago
	 */
	@NotNull
	@JsonSerialize(using=FormasPagoSerializer.class)
	public FormasPago idFormaPago;
	
	/**
	 * @param número de cuenta pago
	 */
	@NotNull
	public String cuentapago;
	
	/**
	 * @return correo Buzón de correo de la sucursal 
	 */
	@Email @NotNull
	public String correo;

	
	
	
	
}
