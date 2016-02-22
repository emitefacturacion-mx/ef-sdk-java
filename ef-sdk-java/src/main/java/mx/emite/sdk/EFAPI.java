package mx.emite.sdk;

import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.emisores.Cancelador32;
import mx.emite.sdk.clientes.operaciones.emisores.Correos;
import mx.emite.sdk.clientes.operaciones.emisores.DescargaAcuseXml;
import mx.emite.sdk.clientes.operaciones.emisores.DescargaMasiva;
import mx.emite.sdk.clientes.operaciones.emisores.DescargaXml;
import mx.emite.sdk.clientes.operaciones.emisores.Pdf;
import mx.emite.sdk.clientes.operaciones.emisores.PdfAcuse;
import mx.emite.sdk.clientes.operaciones.emisores.SelladorYTimbrador32;
import mx.emite.sdk.clientes.operaciones.emisores.Servicios;
import mx.emite.sdk.clientes.operaciones.emisores.Timbrador32;
import mx.emite.sdk.enums.Ambiente;


/**
 * @author enrique
 *
 *	Solo para uso interno
 *
 *	
 */
@Deprecated
public class EFAPI {

	
	private final ClienteJson cliente;
	
	private final Servicios servicios;
	private final Timbrador32 timbrador32;
	private final SelladorYTimbrador32 selladorytimbrador32;
	private final Cancelador32 cancelador32;
	private final DescargaXml descargaxml;
	private final DescargaAcuseXml descargaacusexml;
	private final Pdf pdf;
	private final PdfAcuse pdfacuse;
	private final Correos correos;
	private final DescargaMasiva descargamasiva;
	
	/**
	 * Se crea un objeto de tipo api, mediante el cual se ejecutarán todos los servicios implementados
	 * 
	 * @param ambiente 
	 * <h3>PRODUCCION</h3><p>Ambiente productivo</p>
	 * <h3>PRUEBAS</h3><p>Ambiente de pruebas</p>
	 * <h3>LOCAL</h3><p>Ambiente de uso exclusivo emite</p>
	 * @see Ambiente
	 */
	public EFAPI(final Ambiente ambiente){
		this.cliente=new ClienteJson(ambiente);
		this.servicios=new Servicios(this.cliente);
		this.timbrador32=new Timbrador32(this.cliente);
		this.selladorytimbrador32=new SelladorYTimbrador32(this.cliente);
		this.cancelador32=new Cancelador32(this.cliente);
		this.descargaxml=new DescargaXml(this.cliente);
		this.descargaacusexml=new DescargaAcuseXml(this.cliente);
		this.pdf = new Pdf(this.cliente);
		this.pdfacuse = new PdfAcuse(this.cliente);
		this.correos=new Correos(this.cliente);
		this.descargamasiva=new DescargaMasiva(this.cliente);
	}
	
	/**
	 * Servicio de listado de Servicios
	 * @return servicios
	 * @since 0.0.1
	 */
	public Servicios servicios(){
		return servicios;
	}

	/**
	 * Servicio Timbrado de CFDI 3.2
	 * @return timbrador32
	 * @since 0.0.1
	 */
	public Timbrador32 timbrador32(){
		return timbrador32;
	}
	
	
	
	/**
	 * Servicio de Sellado y Timbrado de CFDI 3.2
	 * @return selladorytimbrador32
	 * @since 0.0.1
	 */
	public SelladorYTimbrador32 selladorytimbrador32(){
		return selladorytimbrador32;
	}
	

	/**
	 * Servicio de Cancelación de CFDI 3.2
	 * @return cancelador32
	 * @since 0.0.2
	 */
	public Cancelador32 cancelador32(){
		return cancelador32;
	}
	
	/**
	 * Servicio de Descarga de CFDI 3.2
	 * @return descargaxml
	 * @since 0.0.2
	 */
	public DescargaXml descargaxml(){
		return descargaxml;
	}
	
	/**
	 * Servicio de Descarga Acuses de Cancelación
	 * @return descargaacusexml
	 * @since 0.0.2
	 */
	public DescargaAcuseXml descargaacusexml(){
		return descargaacusexml;
	}

	/**
	 * Servicio de Descarga de Pdf
	 * @return pdf
	 * @since 0.0.2
	 */
	public Pdf pdf(){
		return pdf;
	}
	
	/**
	 * Servicio de Descarga de Pdf de acuse
	 * @return pdf
	 * @since 0.0.2
	 */
	public PdfAcuse pdfacuse(){
		return pdfacuse;
	}
	
	/**
	 * Servicio de Envio de Correos
	 * @return correos
	 * @since 0.0.2
	 */
	public Correos correos(){
		return correos;
	}
	
	/**
	 * Servicio de Descarga Masiva
	 * @return descargamasiva
	 * @since 0.0.2
	 */
	public DescargaMasiva descargamasiva(){
		return descargamasiva;
	}
}