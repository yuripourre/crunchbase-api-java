package br.com.etyllica.network.crunchbase.model.aquisition;

import br.com.etyllica.network.crunchbase.model.base.Item;

import com.google.gson.annotations.SerializedName;

public class Aquisition extends Item {
	
	@SerializedName("properties")
	AquisitionProperties properties;
	
	@SerializedName("relationships")
	AquisitionRelationships relationships;

	public AquisitionProperties getProperties() {
		return properties;
	}

	public void setProperties(AquisitionProperties properties) {
		this.properties = properties;
	}

	public AquisitionRelationships getRelationships() {
		return relationships;
	}

	public void setRelationships(AquisitionRelationships relationships) {
		this.relationships = relationships;
	}
		
}
