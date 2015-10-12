package br.com.etyllica.network.crunchbase.model.investment;

import com.google.gson.annotations.SerializedName;

import br.com.etyllica.network.crunchbase.model.funding.FundingRound;

public class InvestmentRelashionships {

	@SerializedName("funding_round")
	FundingRound fundingRound;

	public FundingRound getFundingRound() {
		return fundingRound;
	}

	public void setFundingRound(FundingRound fundingRound) {
		this.fundingRound = fundingRound;
	}
}
