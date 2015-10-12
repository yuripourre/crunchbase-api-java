package br.com.etyllica.network.crunchbase.model.aquisition;

public enum AquisitionType {
	AQUISITION("Acquisition"),
	ACQUI_HIRE("Acqui-Hire"),
	LBO("LBO");
	
	private String code;
	
	AquisitionType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
