package br.com.etyllica.network.crunchbase.model.funding;

import br.com.etyllica.network.crunchbase.model.base.Item;

import com.google.gson.annotations.SerializedName;

public class FundingRound extends Item {

	public static final String TYPE_VENTURE = "venture";

	public static final String SERIES_A = "A";
	public static final String SERIES_B = "B";

	@SerializedName("properties")
	FundingRoundProperties properties;
	
	@SerializedName("relationships")
	FundingRoundRelationships relationships;

	public FundingRoundProperties getProperties() {
		return properties;
	}

	public void setProperties(FundingRoundProperties properties) {
		this.properties = properties;
	}

	public FundingRoundRelationships getRelationships() {
		return relationships;
	}

	public void setRelationships(FundingRoundRelationships relationships) {
		this.relationships = relationships;
	}
	
}
