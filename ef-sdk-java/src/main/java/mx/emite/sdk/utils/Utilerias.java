package mx.emite.sdk.utils;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.Collator;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import lombok.Cleanup;
import mx.emite.sdk.cfdi32.Comprobante;
import mx.emite.sdk.cfdi32.nomina.ComprobanteNomina;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.proxy.request.extra.generico.cfdi.xml.GenericoFactura;
import mx.emite.sdk.proxy.request.extra.generico.nomina.xml.GenericoNomina;

public class Utilerias {

	
	private final static Decoder decoder = Base64.getDecoder();
	private final static Encoder encoder = Base64.getEncoder();
	private final static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	private final static Collator comparador = creaComparador();
	
	public static String decodifica64Utf8(final String xmlBase64) throws ApiException{
		try{
		return new String(decodifica64Utf8Byte(xmlBase64));
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.DECODIFICANDO,ex);
		}
	}

	public static byte[] decodifica64Utf8Byte(final String xmlBase64) throws ApiException{
		try{
		return decoder.decode(utf8(xmlBase64));
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.DECODIFICANDO,ex);
		}
	}
	
	private static Collator creaComparador() {
		final Collator res = Collator.getInstance(new Locale("es","MX"));
		res.setStrength(Collator.NO_DECOMPOSITION);
		return res;
	}

	public static String codifica64Utf8(final String xml) throws ApiException{
		try{
		return  utf8(encoder.encode(utf8(xml)));
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.CODIFICANDO,ex);
		}
	}
	
	public static String codifica64Binario(byte[] cer) throws ApiException{
		try{
		return  utf8(encoder.encode(cer));
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.CODIFICANDO,ex);
		}
	}

	
	public static byte[] utf8(String xmlBase64) throws Exception{
		return xmlBase64.getBytes(Charset.forName("UTF-8"));
	}
	
	public static String utf8(byte[] xml) throws Exception{
		return new String(xml, Charset.forName("UTF-8"));
	}

	public static String leeArchivo(String ruta) throws ApiException {
		try{
			return utf8(Files.readAllBytes(Paths.get(ruta)));
		}
		catch(Exception io){
			throw new ApiException(I_Api_Errores.LEYENDO_ARCHIVO,io);
		}
	}

	public static <T> void valida(T objeto) throws ApiException{
		if(objeto==null) return;
		final Set<ConstraintViolation<T>> errores = validator.validate(objeto);
		if(errores.isEmpty())
			return;
		throw new ApiException(I_Api_Errores.CLIENTE_REQUEST_INVALIDO,errores);
	}

	public static String leeArchivo(InputStream is) throws ApiException {
		try{
			@Cleanup ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    byte[] buffer = new byte[1024];
		    int length = 0;
		    while ((length = is.read(buffer)) != -1) {
		        baos.write(buffer, 0, length);
		    }
		    return utf8(baos.toByteArray());
		}
		catch(Exception io){
			throw new ApiException(I_Api_Errores.LEYENDO_ARCHIVO,io);
		}
		finally{
			if(is!=null)
				try {
					is.close();
				} catch (IOException e) {
					;	
				}
		}
	}

	public static String marshallcfdi32(Comprobante comprobante) throws ApiException {
		valida(comprobante);
		return MarshallerUnmarshaller.marshallCfdi32(comprobante);
	}

	public static String marshallnom32(ComprobanteNomina comprobante) throws ApiException {
		valida(comprobante);
		return MarshallerUnmarshaller.marshallNomina32(comprobante);
	}
	
	public static GenericoFactura unmarshallGenerico(final String xml) throws ApiException {
		return MarshallerUnmarshaller.unmarshallGenerico(xml);
	}
	
	public static GenericoNomina unmarshallGenericoNomina(final String xml) throws ApiException {
		return MarshallerUnmarshaller.unmarshallGenericoNomina(xml);
	}
	
	public static boolean compara(String source, String target) {
		return comparador.compare(source, target)==0;
	}

	public static byte[] decodificaBinario(String pdf) throws ApiException{
		try{
			return decoder.decode(pdf.getBytes());
			}catch(Exception ex){
				throw new ApiException(I_Api_Errores.DECODIFICANDO,ex);
		}
	}

	public static void guardaArchivo(String ruta, byte[] pdfDecodificado) throws ApiException{
		try{
				Files.write(Paths.get(ruta), pdfDecodificado);
			}catch(Exception ex){
				throw new ApiException(I_Api_Errores.GUARDANDOARCHIVO,ex);
		}
	}

	public static void guardaUrl(String ruta, String url) {
		try{
			final URL u = new URL(url);
			final URLConnection con = u.openConnection();
			try (ReadableByteChannel source = Channels.newChannel(con.getInputStream());
		        FileChannel out = FileChannel.open(Paths.get(ruta), StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
				out.transferFrom(source, 0, Long.MAX_VALUE);
		    }
			
		}catch(Exception ex){
			throw new ApiException(I_Api_Errores.GUARDANDOARCHIVO,ex);
	}
		
	}

	public static <T> T nvl(T valor,T sinulo) {
		if(valor==null)
			return sinulo;
		return valor;
	}
	
	

	public static GenericoFactura unmarshallTxtGenerico(String txt) throws ApiException {
		BeanReader in=null;
		try{
		final StreamFactory factory = StreamFactory.newInstance();
        factory.load(Utilerias.class.getResourceAsStream("/facturagenericatxt.xml"));
        final StringReader sr = new StringReader(decodifica64Utf8(txt));
        // use a StreamFactory to create a BeanReader
        in = factory.createReader("emiteGenerico",sr);
        GenericoFactura res = (GenericoFactura) in.read();
        in.close();
        return res;
        
		}
		catch(ApiException api){throw api;}
		catch(Exception ex){
			if(ex.getCause() instanceof ApiException)
				throw (ApiException)ex.getCause();
			else
				throw new ApiException(I_Api_Errores.PROXY_LEYENDO_TXT,ex);
		}
		finally{
			if(in!=null)
				try{in.close();}catch(Exception ex){ex.printStackTrace();}
		}
	}

	public static GenericoNomina unmarshallTxtGenericoNomina(String txt) throws ApiException {
		BeanReader in=null;
		try{
		final StreamFactory factory = StreamFactory.newInstance();
        factory.load(Utilerias.class.getResourceAsStream("/facturagenericatxt.xml"));
        final StringReader sr = new StringReader(decodifica64Utf8(txt));
        // use a StreamFactory to create a BeanReader
        in = factory.createReader("emiteGenericoNomina",sr);
        GenericoNomina res = (GenericoNomina) in.read();
        in.close();
        return res;
        
		}
		catch(ApiException api){
			try{if(in!=null)in.close();}catch(Exception ex){ex.printStackTrace();}
			throw api;
		}
		catch(Exception ex){
			try{if(in!=null)in.close();}catch(Exception ex3){ex3.printStackTrace();}
			if(ex.getCause() instanceof ApiException)
				throw (ApiException)ex.getCause();
			else
				throw new ApiException(I_Api_Errores.PROXY_LEYENDO_TXT,ex);
		}
		
	}

	public static String marshallTxtGenericoNomina(final GenericoNomina txt) throws ApiException {
		BeanWriter out=null;
		try{
		final StreamFactory factory = StreamFactory.newInstance();
        factory.load(Utilerias.class.getResourceAsStream("/facturagenericatxt.xml"));
        final StringWriter writer = new StringWriter();
        out = factory.createWriter("emiteGenericoNomina", writer);
        out.write(txt);
        out.close();
        return writer.toString();
        
		}
		catch(ApiException api){
			try{if(out!=null) out.close();}catch(Exception ex){ex.printStackTrace();}
			throw api;
		}
		catch(Exception ex){
			try{if(out!=null) out.close();}catch(Exception ex3){ex3.printStackTrace();}
			if(ex.getCause() instanceof ApiException)
				throw (ApiException)ex.getCause();
			else
				throw new ApiException(I_Api_Errores.PROXY_LEYENDO_TXT,ex);
		}
		
	}
	
	
	public static String marshallGenerico(GenericoFactura comprobante) {
		return MarshallerUnmarshaller.marshallGenericoXml(comprobante);
	}

	public static String marshallGenericoNomina(GenericoNomina comprobante) {
		return MarshallerUnmarshaller.marshallGenericoNominaXml(comprobante);
	}
	
	public static Long toLong(String folio, I_Api_Errores error, String campo) throws ApiException{
		try{
			return Long.parseLong(folio);
		}
		catch(Exception ex){
			throw new ApiException(error,"El "+campo+ " "+ folio + " no es un número válido",ex);
		}
	}

	
	 
	
}
