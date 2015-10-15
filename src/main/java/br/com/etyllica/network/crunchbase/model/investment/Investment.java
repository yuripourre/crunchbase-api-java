package br.com.etyllica.network.crunchbase.model.investment;

import br.com.etyllica.network.crunchbase.model.base.Item;

import com.google.gson.annotations.SerializedName;

public class Investment extends Item {

	@SerializedName("properties")
	InvestmentProperties properties;

	@SerializedName("relationships")
	InvestmentRelashionships relashionships;

	public InvestmentProperties getProperties() {
		return properties;
	}

	public void setProperties(InvestmentProperties properties) {
		this.properties = properties;
	}

	public InvestmentRelashionships getRelashionships() {
		return relashionships;
	}

	public void setRelashionships(InvestmentRelashionships relashionships) {
		this.relashionships = relashionships;
	}
	
}
