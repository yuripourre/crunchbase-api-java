package br.com.etyllica.network.crunchbase.model.job;

import com.google.gson.annotations.SerializedName;

import br.com.etyllica.network.crunchbase.model.base.Item;

public class Job extends Item {
	
	@SerializedName("properties")
	JobProperties properties;
	
	@SerializedName("relationships")
	JobRelationships relationships;
	
}
