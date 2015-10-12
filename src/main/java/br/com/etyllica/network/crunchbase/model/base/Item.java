package br.com.etyllica.network.crunchbase.model.base;

import com.google.gson.annotations.SerializedName;

public class Item {
	@SerializedName("type")
	String type;
	
	@SerializedName("uuid")
	String uuid;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
