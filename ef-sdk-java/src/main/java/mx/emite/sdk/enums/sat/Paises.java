package mx.emite.sdk.enums.sat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

public enum Paises implements Sat<String>{
	
	MEXICO ("MEX","México"),
	AFGANISTAN ("AFG","Afganistán"),
	ISLASALAND ("ALA","Islas Åland"),
	ALBANIA ("ALB","Albania"),
	ALEMANIA ("DEU","Alemania"),
	ANDORRA ("AND","Andorra"),
	ANGOLA ("AGO","Angola"),
	ANGUILA ("AIA","Anguila"),
	ANTARTIDA ("ATA","Antártida"),
	ANTIGUAYBARBUDA ("ATG","Antigua y Barbuda"),
	ARABIASAUDITA ("SAU","Arabia Saudita"),
	ARGELIA ("DZA","Argelia"),
	ARGENTINA ("ARG","Argentina"),
	ARMENIA ("ARM","Armenia"),
	ARUBA ("ABW","Aruba"),
	AUSTRALIA ("AUS","Australia"),
	AUSTRIA ("AUT","Austria"),
	AZERBAIYAN ("AZE","Azerbaiyán"),
	BAHAMASLAS ("BHS","Bahamas (las)"),
	BANGLADES ("BGD","Bangladés"),
	BARBADOS ("BRB","Barbados"),
	BAREIN ("BHR","Baréin"),
	BELGICA ("BEL","Bélgica"),
	BELICE ("BLZ","Belice"),
	BENIN ("BEN","Benín"),
	BERMUDAS ("BMU","Bermudas"),
	BIELORRUSIA ("BLR","Bielorrusia"),
	MYANMAR ("MMR","Myanmar"),
	BOLIVIAESTADOPLURINACIONALDE ("BOL","Bolivia, Estado Plurinacional de"),
	BOSNIAYHERZEGOVINA ("BIH","Bosnia y Herzegovina"),
	BOTSUANA ("BWA","Botsuana"),
	BRASIL ("BRA","Brasil"),
	BRUNEIDARUSSALAM ("BRN","Brunéi Darussalam"),
	BULGARIA ("BGR","Bulgaria"),
	BURKINAFASO ("BFA","Burkina Faso"),
	BURUNDI ("BDI","Burundi"),
	BUTAN ("BTN","Bután"),
	CABOVERDE ("CPV","Cabo Verde"),
	CAMBOYA ("KHM","Camboya"),
	CAMERUN ("CMR","Camerún"),
	CANADA ("CAN","Canadá","[A-Z][0-9][A-Z] [0-9][A-Z][0-9]"),
	CATAR ("QAT","Catar"),
	BONAIRESANEUSTAQUIOYSABA ("BES","Bonaire, San Eustaquio y Saba"),
	CHAD ("TCD","Chad"),
	CHILE ("CHL","Chile"),
	CHINA ("CHN","China"),
	CHIPRE ("CYP","Chipre"),
	COLOMBIA ("COL","Colombia"),
	COMORAS ("COM","Comoras"),
	COREALAREPUBLICADEMOCRATICAPOPULARDE ("PRK","Corea (la República Democrática Popular de)"),
	COREALAREPUBLICADE ("KOR","Corea (la República de)"),
	COTEDIVOIRE ("CIV","Côte d'Ivoire"),
	COSTARICA ("CRI","Costa Rica"),
	CROACIA ("HRV","Croacia"),
	CUBA ("CUB","Cuba"),
	CURACAO ("CUW","Curaçao"),
	DINAMARCA ("DNK","Dinamarca"),
	DOMINICA ("DMA","Dominica"),
	ECUADOR ("ECU","Ecuador"),
	EGIPTO ("EGY","Egipto"),
	ELSALVADOR ("SLV","El Salvador"),
	EMIRATOSARABESUNIDOSLOS ("ARE","Emiratos Árabes Unidos (Los)"),
	ERITREA ("ERI","Eritrea"),
	ESLOVAQUIA ("SVK","Eslovaquia"),
	ESLOVENIA ("SVN","Eslovenia"),
	ESPANA ("ESP","España"),
	ESTADOSUNIDOSLOS ("USA","Estados Unidos (los)","[0-9]{5}(-[0-9]{4})?"),
	ESTONIA ("EST","Estonia"),
	ETIOPIA ("ETH","Etiopía"),
	FILIPINASLAS ("PHL","Filipinas (las)"),
	FINLANDIA ("FIN","Finlandia"),
	FIYI ("FJI","Fiyi"),
	FRANCIA ("FRA","Francia"),
	GABON ("GAB","Gabón"),
	GAMBIALA ("GMB","Gambia (La)"),
	GEORGIA ("GEO","Georgia"),
	GHANA ("GHA","Ghana"),
	GIBRALTAR ("GIB","Gibraltar"),
	GRANADA ("GRD","Granada"),
	GRECIA ("GRC","Grecia"),
	GROENLANDIA ("GRL","Groenlandia"),
	GUADALUPE ("GLP","Guadalupe"),
	GUAM ("GUM","Guam"),
	GUATEMALA ("GTM","Guatemala"),
	GUAYANAFRANCESA ("GUF","Guayana Francesa"),
	GUERNSEY ("GGY","Guernsey"),
	GUINEA ("GIN","Guinea"),
	GUINEABISAU ("GNB","Guinea-Bisáu"),
	GUINEAECUATORIAL ("GNQ","Guinea Ecuatorial"),
	GUYANA ("GUY","Guyana"),
	HAITI ("HTI","Haití"),
	HONDURAS ("HND","Honduras"),
	HONGKONG ("HKG","Hong Kong"),
	HUNGRIA ("HUN","Hungría"),
	INDIA ("IND","India"),
	INDONESIA ("IDN","Indonesia"),
	IRAK ("IRQ","Irak"),
	IRANLAREPUBLICAISLAMICADE ("IRN","Irán (la República Islámica de)"),
	IRLANDA ("IRL","Irlanda"),
	ISLABOUVET ("BVT","Isla Bouvet"),
	ISLADEMAN ("IMN","Isla de Man"),
	ISLADENAVIDAD ("CXR","Isla de Navidad"),
	ISLANORFOLK ("NFK","Isla Norfolk"),
	ISLANDIA ("ISL","Islandia"),
	ISLASCAIMANLAS ("CYM","Islas Caimán (las)"),
	ISLASCOCOSKEELING ("CCK","Islas Cocos (Keeling)"),
	ISLASCOOKLAS ("COK","Islas Cook (las)"),
	ISLASFEROELAS ("FRO","Islas Feroe (las)"),
	GEORGIADELSURYLASISLASSANDWICHDELSUR ("SGS","Georgia del sur y las islas sandwich del sur"),
	ISLAHEARDEISLASMCDONALD ("HMD","Isla Heard e Islas McDonald"),
	ISLASMALVINASFALKLANDLAS ("FLK","Islas Malvinas [Falkland] (las)"),
	ISLASMARIANASDELNORTELAS ("MNP","Islas Marianas del Norte (las)"),
	ISLASMARSHALLLAS ("MHL","Islas Marshall (las)"),
	PITCAIRN ("PCN","Pitcairn"),
	ISLASSALOMONLAS ("SLB","Islas Salomón (las)"),
	ISLASTURCASYCAICOSLAS ("TCA","Islas Turcas y Caicos (las)"),
	ISLASDEULTRAMARMENORESDEESTADOSUNIDOSLAS ("UMI","Islas de Ultramar Menores de Estados Unidos (las)"),
	ISLASVIRGENESBRITANICAS ("VGB","Islas Vírgenes (Británicas)"),
	ISLASVIRGENESEEUU("VIR","Islas Vírgenes (EE.UU.)"),
	ISRAEL ("ISR","Israel"),
	ITALIA ("ITA","Italia"),
	JAMAICA ("JAM","Jamaica"),
	JAPON ("JPN","Japón"),
	JERSEY ("JEY","Jersey"),
	JORDANIA ("JOR","Jordania"),
	KAZAJISTAN ("KAZ","Kazajistán"),
	KENIA ("KEN","Kenia"),
	KIRGUISTAN ("KGZ","Kirguistán"),
	KIRIBATI ("KIR","Kiribati"),
	KUWAIT ("KWT","Kuwait"),
	LAOLAREPUBLICADEMOCRATICAPOPULAR ("LAO","Lao, (la) República Democrática Popular"),
	LESOTO ("LSO","Lesoto"),
	LETONIA ("LVA","Letonia"),
	LIBANO ("LBN","Líbano"),
	LIBERIA ("LBR","Liberia"),
	LIBIA ("LBY","Libia"),
	LIECHTENSTEIN ("LIE","Liechtenstein"),
	LITUANIA ("LTU","Lituania"),
	LUXEMBURGO ("LUX","Luxemburgo"),
	MACAO ("MAC","Macao"),
	MADAGASCAR ("MDG","Madagascar"),
	MALASIA ("MYS","Malasia"),
	MALAUI ("MWI","Malaui"),
	MALDIVAS ("MDV","Maldivas"),
	MALI ("MLI","Malí"),
	MALTA ("MLT","Malta"),
	MARRUECOS ("MAR","Marruecos"),
	MARTINICA ("MTQ","Martinica"),
	MAURICIO ("MUS","Mauricio"),
	MAURITANIA ("MRT","Mauritania"),
	MAYOTTE ("MYT","Mayotte"),
	MICRONESIALOSESTADOSFEDERADOSDE ("FSM","Micronesia (los Estados Federados de)"),
	MOLDAVIALAREPUBLICADE ("MDA","Moldavia (la República de)"),
	MONACO ("MCO","Mónaco"),
	MONGOLIA ("MNG","Mongolia"),
	MONTENEGRO ("MNE","Montenegro"),
	MONTSERRAT ("MSR","Montserrat"),
	MOZAMBIQUE ("MOZ","Mozambique"),
	NAMIBIA ("NAM","Namibia"),
	NAURU ("NRU","Nauru"),
	NEPAL ("NPL","Nepal"),
	NICARAGUA ("NIC","Nicaragua"),
	NIGEREL ("NER","Níger (el)"),
	NIGERIA ("NGA","Nigeria"),
	NIUE ("NIU","Niue"),
	NORUEGA ("NOR","Noruega"),
	NUEVACALEDONIA ("NCL","Nueva Caledonia"),
	NUEVAZELANDA ("NZL","Nueva Zelanda"),
	OMAN ("OMN","Omán"),
	PAISESBAJOSLOS ("NLD","Países Bajos (los)"),
	PAKISTAN ("PAK","Pakistán"),
	PALAOS ("PLW","Palaos"),
	PALESTINAESTADODE ("PSE","Palestina, Estado de"),
	PANAMA ("PAN","Panamá"),
	PAPUANUEVAGUINEA ("PNG","Papúa Nueva Guinea"),
	PARAGUAY ("PRY","Paraguay"),
	PERU ("PER","Perú"),
	POLINESIAFRANCESA ("PYF","Polinesia Francesa"),
	POLONIA ("POL","Polonia"),
	PORTUGAL ("PRT","Portugal"),
	PUERTORICO ("PRI","Puerto Rico"),
	REINOUNIDOEL ("GBR","Reino Unido (el)"),
	REPUBLICACENTROAFRICANALA ("CAF","República Centroafricana (la)"),
	REPUBLICACHECALA ("CZE","República Checa (la)"),
	MACEDONIALAANTIGUAREPUBLICAYUGOSLAVADE ("MKD","Macedonia (la antigua República Yugoslava de)"),
	CONGO ("COG","Congo"),
	CONGOLAREPUBLICADEMOCRATICADEL ("COD","Congo (la República Democrática del)"),
	REPUBLICADOMINICANALA ("DOM","República Dominicana (la)"),
	REUNION ("REU","Reunión"),
	RUANDA ("RWA","Ruanda"),
	RUMANIA ("ROU","Rumania"),
	RUSIALAFEDERACIONDE ("RUS","Rusia, (la) Federación de"),
	SAHARAOCCIDENTAL ("ESH","Sahara Occidental"),
	SAMOA ("WSM","Samoa"),
	SAMOAAMERICANA ("ASM","Samoa Americana"),
	SANBARTOLOME ("BLM","San Bartolomé"),
	SANCRISTOBALYNIEVES ("KNA","San Cristóbal y Nieves"),
	SANMARINO ("SMR","San Marino"),
	SANMARTINPARTEFRANCESA ("MAF","San Martín (parte francesa)"),
	SANPEDROYMIQUELON ("SPM","San Pedro y Miquelón"),
	SANVICENTEYLASGRANADINAS ("VCT","San Vicente y las Granadinas"),
	SANTAHELENAASCENSIONYTRISTANDEACUNA ("SHN","Santa Helena, Ascensión y Tristán de Acuña"),
	SANTALUCIA ("LCA","Santa Lucía"),
	SANTOTOMEYPRINCIPE ("STP","Santo Tomé y Príncipe"),
	SENEGAL ("SEN","Senegal"),
	SERBIA ("SRB","Serbia"),
	SEYCHELLES ("SYC","Seychelles"),
	SIERRALEONA ("SLE","Sierra leona"),
	SINGAPUR ("SGP","Singapur"),
	SINTMAARTENPARTEHOLANDESA ("SXM","Sint Maarten (parte holandesa)"),
	SIRIALAREPUBLICAARABE ("SYR","Siria, (la) República Árabe"),
	SOMALIA ("SOM","Somalia"),
	SRILANKA ("LKA","Sri Lanka"),
	SUAZILANDIA ("SWZ","Suazilandia"),
	SUDAFRICA ("ZAF","Sudáfrica"),
	SUDANEL ("SDN","Sudán (el)"),
	SUDANDELSUR ("SSD","Sudán del Sur"),
	SUECIA ("SWE","Suecia"),
	SUIZA ("CHE","Suiza"),
	SURINAM ("SUR","Surinam"),
	SVALBARDYJANMAYEN ("SJM","Svalbard y Jan Mayen"),
	TAILANDIA ("THA","Tailandia"),
	TAIWANPROVINCIADECHINA ("TWN","Taiwán (Provincia de China)"),
	TANZANIAREPUBLICAUNIDADE ("TZA","Tanzania, República Unida de"),
	TAYIKISTAN ("TJK","Tayikistán"),
	TERRITORIOBRITANICODELOCEANOINDICOEL ("IOT","Territorio Británico del Océano Índico (el)"),
	TERRITORIOSAUSTRALESFRANCESESLOS ("ATF","Territorios Australes Franceses (los)"),
	TIMORLESTE ("TLS","Timor-Leste"),
	TOGO ("TGO","Togo"),
	TOKELAU ("TKL","Tokelau"),
	TONGA ("TON","Tonga"),
	TRINIDADYTOBAGO ("TTO","Trinidad y Tobago"),
	TUNEZ ("TUN","Túnez"),
	TURKMENISTAN ("TKM","Turkmenistán"),
	TURQUIA ("TUR","Turquía"),
	TUVALU ("TUV","Tuvalu"),
	UCRANIA ("UKR","Ucrania"),
	UGANDA ("UGA","Uganda"),
	URUGUAY ("URY","Uruguay"),
	UZBEKISTAN ("UZB","Uzbekistán"),
	VANUATU ("VUT","Vanuatu"),
	SANTASEDEESTADODELACIUDADDELVATICANOLA ("VAT","Santa Sede[Estado de la Ciudad del Vaticano] (la)"),
	VENEZUELAREPUBLICABOLIVARIANADE ("VEN","Venezuela, República Bolivariana de"),
	VIETNAM ("VNM","Viet Nam"),
	WALLISYFUTUNA ("WLF","Wallis y Futuna"),
	YEMEN ("YEM","Yemen"),
	YIBUTI ("DJI","Yibuti"),
	ZAMBIA ("ZMB","Zambia"),
	ZIMBABUE ("ZWE","Zimbabue"),
	PAISESNODECLARADOS ("ZZZ","Países no declarados"), 
	
	;
	
	private final String idSat,descripcionPais,patronCp;
	
	Paises(String idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	Paises(String idSat,String descripcion,String patronCp){
		this.idSat=idSat;
		this.descripcionPais=descripcion;
		this.patronCp=patronCp;
	}
	
	public String valor(){
		return name();
	}
	
	@Override
	public String getDescripcion(){
		return descripcionPais;
	}
	
	/**
	 * Busca un país de acuerdo a su descripción
	 * @param descripcion de acuerdo al catalogo del SAT
	 * @return Paises valor del enum de acuerdo al pais
	 */
	public static Paises busca(String descripcion) {
		if(StringUtils.isEmpty(descripcion))
			return null;
		for(Paises m:values()){
			if(Utilerias.compara(m.descripcionPais,descripcion))
				return m;
			else if(Utilerias.compara(m.idSat,descripcion))
				return m;
		}
		return null;
	}

	/**
	 * Busca un país de acuerdo a su id del SAT
	 * @param idPais de acuerdo al catalogo del SAT
	 * @return Paises valor del enum de acuerdo al pais
	 */
	public static Paises id(String idPais) {
		for(Paises m:values()){
			if(Utilerias.compara(m.idSat,idPais))
				return m;
		}
		return null;
	}

	public static Paises[] principales() {
		return new Paises[]{Paises.MEXICO ,Paises.ESTADOSUNIDOSLOS ,Paises.CANADA };
	}
	
	public String getIdPais(){
		return idSat;
	}

	@Override
	public String getIdSat() {
		return idSat;
	}

	public String getDescripcionPais() {
		return descripcionPais;
	}
	
	public static Paises unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final Paises estado =  Paises.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El pais "+metodo+" no se encuentra en el catálogo de paises SAT");
		else
			return estado;
	}
	
	
	public static String marshall(Paises v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}

	public static Paises getDefault() {
		return Paises.MEXICO ;
	}

	public static boolean existe(String idSat) {
		for(Paises m:values()){
			if(m.getIdSat().equals(idSat))
				return true;
		}
		return false;
	}
	
	public String getPatronCp(){
		return patronCp;
	}
	
	public static List<String> ids() {
		return Arrays.asList(values()).stream().map(Paises::getIdSat).collect(Collectors.toList());		
	}
	
}
