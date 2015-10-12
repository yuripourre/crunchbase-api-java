package br.com.etyllica.network.crunchbase.model.address;

import com.google.gson.annotations.SerializedName;

import br.com.etyllica.network.crunchbase.model.base.Item;

public class Address extends Item {

	@SerializedName("properties")
	AddressProperties properties;

	public AddressProperties getProperties() {
		return properties;
	}

	public void setProperties(AddressProperties properties) {
		this.properties = properties;
	}
		
}
