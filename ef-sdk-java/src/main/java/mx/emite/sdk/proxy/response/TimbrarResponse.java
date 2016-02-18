package mx.emite.sdk.proxy.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.emite.sdk.proxy.ProxyResponse;
import mx.emite.sdk.proxy.response.extra.InfoCfdi;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true)
public class TimbrarResponse extends ProxyResponse {

	private Integer timbresRestantes;
	
	private String xml;
	
	private InfoCfdi info;
	
		
	
	
}
