package br.com.etyllica.network.crunchbase.model.funding;

import br.com.etyllica.network.crunchbase.model.base.Page;

import com.google.gson.annotations.SerializedName;

public class FundingRoundPage extends Page {
	
	@SerializedName("data")
	FundingRoundPageData data;

	public FundingRoundPageData getData() {
		return data;
	}

	public void setData(FundingRoundPageData data) {
		this.data = data;
	}

}
