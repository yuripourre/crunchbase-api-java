package br.com.etyllica.network.crunchbase.model.funding.single;

import br.com.etyllica.network.crunchbase.model.base.Page;
import br.com.etyllica.network.crunchbase.model.funding.FundingRound;

import com.google.gson.annotations.SerializedName;

public class FundingRoundSinglePage extends Page {
	
	@SerializedName("data")
	FundingRound fundingRound;

	public FundingRound getFundingRound() {
		return fundingRound;
	}

	public void setFundingRound(FundingRound fundingRound) {
		this.fundingRound = fundingRound;
	}

}
