package br.com.etyllica.network.crunchbase.model.category;

import com.google.gson.annotations.SerializedName;

import br.com.etyllica.network.crunchbase.model.base.Item;
import br.com.etyllica.network.crunchbase.model.base.Properties;

public class Category extends Item {

	@SerializedName("properties")
	Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
}
