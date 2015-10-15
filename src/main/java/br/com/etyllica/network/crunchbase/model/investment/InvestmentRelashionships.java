package br.com.etyllica.network.crunchbase.model.investment;

import br.com.etyllica.network.crunchbase.model.funding.FundingRound;
import br.com.etyllica.network.crunchbase.model.investor.InvestorList;

import com.google.gson.annotations.SerializedName;

public class InvestmentRelashionships {

	@SerializedName("funding_round")
	FundingRound fundingRound;
	
	@SerializedName("investors")
	InvestorList investors;

	public FundingRound getFundingRound() {
		return fundingRound;
	}

	public void setFundingRound(FundingRound fundingRound) {
		this.fundingRound = fundingRound;
	}

	public InvestorList getInvestors() {
		return investors;
	}

	public void setInvestors(InvestorList investors) {
		this.investors = investors;
	}

}
