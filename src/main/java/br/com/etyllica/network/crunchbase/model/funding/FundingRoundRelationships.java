package br.com.etyllica.network.crunchbase.model.funding;

import br.com.etyllica.network.crunchbase.model.investment.InvestmentPageData;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationSinglePageData;

import com.google.gson.annotations.SerializedName;

public class FundingRoundRelationships {

	@SerializedName("investments")
	InvestmentPageData investmentsPage;
	
	@SerializedName("funded_organization")
	OrganizationSinglePageData organizationPage;

	public InvestmentPageData getInvestmentsPage() {
		return investmentsPage;
	}

	public void setInvestmentsPage(InvestmentPageData investmentsPage) {
		this.investmentsPage = investmentsPage;
	}

	public OrganizationSinglePageData getOrganizationPage() {
		return organizationPage;
	}

	public void setOrganizationPage(OrganizationSinglePageData organizationPage) {
		this.organizationPage = organizationPage;
	}
	
}
