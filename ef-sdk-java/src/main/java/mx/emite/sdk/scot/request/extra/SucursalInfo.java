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
	 *  nombre de la sucursal (único por emisor)
	 */
	@NotNull @Size(max=100)
	private String nombre;
	
	/**
	 *  razonSocialRazón Social de la sucursal 
	 */
	@NotNull @Size(max=100)
	public String razonSocial;
	
	
	/**
	 *  calle Calle de la sucursal
	 */
	@NotNull @Size(max=100)
	public String calle;
		
	/**
	 *  noext No. exterior de la sucursal
	 */
	@Size(max=100)
	public String noext;
		
	/**
	 *  noint No. interior de la sucursal
	 */
	@Size(max=100)
	public String noint;
		
	/**
	 *  cp Código postal de la sucursal 
	 */
	@Size(min=5,max=5) @Cp @NotNull
	public String cp;
		
	/**
	 *  colonia Colonia de la sucursal
	 */
	@Size(max=100)
	public String colonia;
		
	/**
	 *  referencias Referencias de la sucursal
	 * 
	 */
	@Size(max=100)
	public String referencias;
		
	/**
	 *  localidad Localidad de la sucursal
	 */
	@Size(max=50)
	public String localidad;
		
	/**
	 *  municipio Municipio / de laegación de la sucursal
	 */
	@NotNull @Size(max=50)
	public String municipio;
	
	/**
	 *  estado
	 */
	@NotNull
	@JsonSerialize(using=EstadosSerializer.class)
	public Estados idEstado;
		
	/**
	 *  pais
	 */
	@NotNull
	@JsonSerialize(using=PaisesSerializer.class)
	public Paises idPais=Paises.MEXICO ;
	 
	/**
	 *  regimen
	 */
	@NotNull
	@JsonSerialize(using=RegimenesSerializer.class)
	public RegimenesFiscales idRegimen;
	
	/**
	 *  forma de pago
	 */
	@NotNull
	@JsonSerialize(using=FormasPagoSerializer.class)
	public FormasPago idFormaPago;
	
	/**
	 *  número de cuenta pago
	 */
	@NotNull
	public String cuentapago;
	
	/**
	 *  correo Buzón de correo de la sucursal 
	 */
	@Email @NotNull
	public String correo;

	
	
	
	
}
