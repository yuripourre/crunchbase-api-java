package br.com.etyllica.network.crunchbase.model.person;

import com.google.gson.annotations.SerializedName;

import br.com.etyllica.network.crunchbase.model.base.Item;

public class Person extends Item {
	
	@SerializedName("properties")
	PersonProperties properties;
	
}
