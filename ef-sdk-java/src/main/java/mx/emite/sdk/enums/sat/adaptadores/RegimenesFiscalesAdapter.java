package mx.emite.sdk.enums.sat.adaptadores;

import mx.emite.sdk.enums.sat.RegimenesFiscales;

public class RegimenesFiscalesAdapter extends SatAdapter<String,RegimenesFiscales>{

	@Override
	public RegimenesFiscales unmarshal(String metodo) throws Exception {
		if(metodo==null)
			return null;
		return RegimenesFiscales.busca(metodo);		
	}

}