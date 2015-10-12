package br.com.etyllica.network.crunchbase.model.organization;

import br.com.etyllica.network.crunchbase.model.base.Item;

import com.google.gson.annotations.SerializedName;

public class Organization extends Item {
		
	@SerializedName("properties")
	OrganizationProperties properties;
	
	@SerializedName("relationships")
    OrganizationRelashionships relationships;

	public OrganizationProperties getProperties() {
		return properties;
	}

	public void setProperties(OrganizationProperties properties) {
		this.properties = properties;
	}

	public OrganizationRelashionships getRelationships() {
		return relationships;
	}

	public void setRelationships(OrganizationRelashionships relationships) {
		this.relationships = relationships;
	}
	    
}
