package mx.emite.sdk.enums.sat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Estados implements Sat<String>{

	AGUASCALIENTES ("AGU",Paises.MEXICO ,"Aguascalientes"),
	BAJACALIFORNIA ("BCN",Paises.MEXICO ,"Baja California"),
	BAJACALIFORNIASUR ("BCS",Paises.MEXICO ,"Baja California Sur"),
	CAMPECHE ("CAM",Paises.MEXICO ,"Campeche"),
	CHIAPAS ("CHP",Paises.MEXICO ,"Chiapas"),
	CHIHUAHUA ("CHH",Paises.MEXICO ,"Chihuahua"),
	COAHUILA ("COA",Paises.MEXICO ,"Coahuila"),
	COLIMA ("COL",Paises.MEXICO ,"Colima"),
	DISTRITOFEDERAL ("DIF",Paises.MEXICO ,"Ciudad de México"),
	DURANGO ("DUR",Paises.MEXICO ,"Durango"),
	GUANAJUATO ("GUA",Paises.MEXICO ,"Guanajuato"),
	GUERRERO ("GRO",Paises.MEXICO ,"Guerrero"),
	HIDALGO ("HID",Paises.MEXICO ,"Hidalgo"),
	JALISCO ("JAL",Paises.MEXICO ,"Jalisco"),
	ESTADODEMEXICO ("MEX",Paises.MEXICO ,"Estado de México"),
	MICHOACAN ("MIC",Paises.MEXICO ,"Michoacán"),
	MORELOS ("MOR",Paises.MEXICO ,"Morelos"),
	NAYARIT ("NAY",Paises.MEXICO ,"Nayarit"),
	NUEVOLEON ("NLE",Paises.MEXICO ,"Nuevo León"),
	OAXACA ("OAX",Paises.MEXICO ,"Oaxaca"),
	PUEBLA ("PUE",Paises.MEXICO ,"Puebla"),
	QUERETARO ("QTO",Paises.MEXICO ,"Querétaro"),
	QUINTANAROO ("ROO",Paises.MEXICO ,"Quintana Roo"),
	SANLUISPOTOSI ("SLP",Paises.MEXICO ,"San Luis Potosí"),
	SINALOA ("SIN",Paises.MEXICO ,"Sinaloa"),
	SONORA ("SON",Paises.MEXICO ,"Sonora"),
	TABASCO ("TAB",Paises.MEXICO ,"Tabasco"),
	TAMAULIPAS ("TAM",Paises.MEXICO ,"Tamaulipas"),
	TLAXCALA ("TLA",Paises.MEXICO ,"Tlaxcala"),
	VERACRUZ ("VER",Paises.MEXICO ,"Veracruz"),
	YUCATAN ("YUC",Paises.MEXICO ,"Yucatán"),
	ZACATECAS ("ZAC",Paises.MEXICO ,"Zacatecas"),
	ALABAMA ("AL",Paises.ESTADOSUNIDOSLOS ,"Alabama"),
	ALASKA ("AK",Paises.ESTADOSUNIDOSLOS ,"Alaska"),
	ARIZONA ("AZ",Paises.ESTADOSUNIDOSLOS ,"Arizona"),
	ARKANSAS ("AR",Paises.ESTADOSUNIDOSLOS ,"Arkansas"),
	CALIFORNIA ("CA",Paises.ESTADOSUNIDOSLOS ,"California"),
	CAROLINADELNORTE ("NC",Paises.ESTADOSUNIDOSLOS ,"Carolina del Norte"),
	CAROLINADELSUR ("SC",Paises.ESTADOSUNIDOSLOS ,"Carolina del Sur"),
	COLORADO ("CO",Paises.ESTADOSUNIDOSLOS ,"Colorado"),
	CONNECTICUT ("CT",Paises.ESTADOSUNIDOSLOS ,"Connecticut"),
	DAKOTADELNORTE ("ND",Paises.ESTADOSUNIDOSLOS ,"Dakota del Norte"),
	DAKOTADELSUR ("SD",Paises.ESTADOSUNIDOSLOS ,"Dakota del Sur"),
	DELAWARE ("DE",Paises.ESTADOSUNIDOSLOS ,"Delaware"),
	FLORIDA ("FL",Paises.ESTADOSUNIDOSLOS ,"Florida"),
	GEORGIA ("GA",Paises.ESTADOSUNIDOSLOS ,"Georgia"),
	HAWAI ("HI",Paises.ESTADOSUNIDOSLOS ,"Hawái"),
	IDAHO ("ID",Paises.ESTADOSUNIDOSLOS ,"Idaho"),
	ILLINOIS ("IL",Paises.ESTADOSUNIDOSLOS ,"Illinois"),
	INDIANA ("IN",Paises.ESTADOSUNIDOSLOS ,"Indiana"),
	IOWA ("IA",Paises.ESTADOSUNIDOSLOS ,"Iowa"),
	KANSAS ("KS",Paises.ESTADOSUNIDOSLOS ,"Kansas"),
	KENTUCKY ("KY",Paises.ESTADOSUNIDOSLOS ,"Kentucky"),
	LUISIANA ("LA",Paises.ESTADOSUNIDOSLOS ,"Luisiana"),
	MAINE ("ME",Paises.ESTADOSUNIDOSLOS ,"Maine"),
	MARYLAND ("MD",Paises.ESTADOSUNIDOSLOS ,"Maryland"),
	MASSACHUSETTS ("MA",Paises.ESTADOSUNIDOSLOS ,"Massachusetts"),
	MICHIGAN ("MI",Paises.ESTADOSUNIDOSLOS ,"Míchigan"),
	MINNESOTA ("MN",Paises.ESTADOSUNIDOSLOS ,"Minnesota"),
	MISISIPI ("MS",Paises.ESTADOSUNIDOSLOS ,"Misisipi"),
	MISURI ("MO",Paises.ESTADOSUNIDOSLOS ,"Misuri"),
	MONTANA ("MT",Paises.ESTADOSUNIDOSLOS ,"Montana"),
	NEBRASKA ("NE",Paises.ESTADOSUNIDOSLOS ,"Nebraska"),
	NEVADA ("NV",Paises.ESTADOSUNIDOSLOS ,"Nevada"),
	NUEVAJERSEY ("NJ",Paises.ESTADOSUNIDOSLOS ,"Nueva Jersey"),
	NUEVAYORK ("NY",Paises.ESTADOSUNIDOSLOS ,"Nueva York"),
	NUEVOHAMPSHIRE ("NH",Paises.ESTADOSUNIDOSLOS ,"Nuevo Hampshire"),
	NUEVOMEXICO ("NM",Paises.ESTADOSUNIDOSLOS ,"Nuevo México"),
	OHIO ("OH",Paises.ESTADOSUNIDOSLOS ,"Ohio"),
	OKLAHOMA ("OK",Paises.ESTADOSUNIDOSLOS ,"Oklahoma"),
	OREGON ("OR",Paises.ESTADOSUNIDOSLOS ,"Oregón"),
	PENSILVANIA ("PA",Paises.ESTADOSUNIDOSLOS ,"Pensilvania"),
	RHODEISLAND ("RI",Paises.ESTADOSUNIDOSLOS ,"Rhode Island"),
	TENNESSEE ("TN",Paises.ESTADOSUNIDOSLOS ,"Tennessee"),
	TEXAS ("TX",Paises.ESTADOSUNIDOSLOS ,"Texas"),
	UTAH ("UT",Paises.ESTADOSUNIDOSLOS ,"Utah"),
	VERMONT ("VT",Paises.ESTADOSUNIDOSLOS ,"Vermont"),
	VIRGINIA ("VA",Paises.ESTADOSUNIDOSLOS ,"Virginia"),
	VIRGINIAOCCIDENTAL ("WV",Paises.ESTADOSUNIDOSLOS ,"Virginia Occidental"),
	WASHINGTON ("WA",Paises.ESTADOSUNIDOSLOS ,"Washington"),
	WISCONSIN ("WI",Paises.ESTADOSUNIDOSLOS ,"Wisconsin"),
	WYOMING ("WY",Paises.ESTADOSUNIDOSLOS ,"Wyoming"),
	ONTARIO ("ON",Paises.CANADA ,"Ontario "),
	QUEBEC ("QC",Paises.CANADA ,"Quebec "),
	NUEVAESCOCIA ("NS",Paises.CANADA ,"Nueva Escocia"),
	NUEVOBRUNSWICK("NB",Paises.CANADA ,"Nuevo Brunswick"),
	MANITOBA ("MB",Paises.CANADA ,"Manitoba"),
	COLUMBIABRITANICA ("BC",Paises.CANADA ,"Columbia Británica"),
	ISLADELPRINCIPEEDUARDO ("PE",Paises.CANADA ,"Isla del Príncipe Eduardo"),
	SASKATCHEWAN ("SK",Paises.CANADA ,"Saskatchewan"),
	ALBERTA ("AB",Paises.CANADA ,"Alberta"),
	TERRANOVAYLABRADOR ("NL",Paises.CANADA ,"Terranova y Labrador"),
	TERRITORIOSDELNOROESTE ("NT",Paises.CANADA ,"Territorios del Noroeste"),
	YUKON ("YT",Paises.CANADA ,"Yukón"),
	NUNAVUT ("UN",Paises.CANADA ,"Nunavut");
	
	private final String idSat,descripcion;
	private final Paises pais;
	
	Estados(String idSat,Paises pais,String descripcion){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.pais=pais;
		
	}
	
	
	/**
	 * Busca un estado de acuerdo a su descripción
	 * @param descripcion de acuerdo al catalogo del SAT
	 * @return Estados valor del enum de acuerdo al estado
	 */
	public static Estados busca(String descripcion) {
		if(StringUtils.isEmpty(descripcion))
			return null;
		for(Estados m:values()){
			if(Utilerias.compara(m.descripcion,descripcion))
				return m;
			else if(Utilerias.compara(m.idSat,descripcion))
				return m;
		}
		return null;
	}
	
	/**
	 * Busca un estado de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return Estados valor del enum de acuerdo al estado
	 */
	public static Estados id(String idSat) {
		for(Estados m:values()){
			if(Utilerias.compara(m.idSat,idSat))
				return m;
		}
		return null;
	}


	public static List<Estados> pais(String idPais) {
		final List<Estados> res = new ArrayList<>();
		for(Estados e:values()){
			if(e.getPais().getIdSat().equals(idPais))
				res.add(e);
		}
		return res;
	}
	
	public static List<String> paisId(Paises idPais) {
		final List<String> res = new ArrayList<>();
		for(Estados e:values()){
			if(e.getPais().getIdSat().equals(idPais.getIdSat()))
				res.add(e.getIdSat());
		}
		return res;
	}
	
	public String getIdEstado(){
		return idSat;
	}


	public static Estados unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final Estados estado =  Estados.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El estado "+metodo+" no se encuentra en el catálogo de estados del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(Estados v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}


	public static Estados getDefault() {
		return Estados.DISTRITOFEDERAL ;
	}


	public static boolean existe(String idEstado, String idPais) {
		for(Estados e:values()){
			if(e.getIdSat().equals(idEstado)){
				if(e.getPais().getIdSat().equals(idPais))
					return true;
				else
					return false;
			}
		}
		return false;
	}

	public static boolean existe(String idSat) {
		for(Estados reg:values()){
			if(reg.getIdSat().equals(idSat))
				return true;
		}
		return false;
	}
	
	public static List<String> ids() {
		return Arrays.asList(values()).stream().map(Estados::getIdSat).collect(Collectors.toList());		
	}


	public static Estados getEstadoMexico(String idEstado) {
		if(StringUtils.isEmpty(idEstado))
			return null;
		for(Estados e:values()){
			if(e.getPais().equals(Paises.MEXICO ) && e.getIdSat().equals(idEstado)){
				return e;
			}
		}
		return null;
	}
	
}
