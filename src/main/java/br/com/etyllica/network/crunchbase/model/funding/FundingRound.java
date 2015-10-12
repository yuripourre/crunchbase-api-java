package br.com.etyllica.network.crunchbase.model.funding;

import br.com.etyllica.network.crunchbase.model.base.Item;

import com.google.gson.annotations.SerializedName;

public class FundingRound extends Item {

	@SerializedName("properties")
	FundingRoundProperties properties;

	public FundingRoundProperties getProperties() {
		return properties;
	}

	public void setProperties(FundingRoundProperties properties) {
		this.properties = properties;
	}
	
}
