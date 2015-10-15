package br.com.etyllica.network.crunchbase.export;

import br.com.etyllica.network.crunchbase.model.funding.FundingRound;
import br.com.etyllica.network.crunchbase.model.investment.Investment;
import br.com.etyllica.network.crunchbase.model.investor.Investor;
import br.com.etyllica.network.crunchbase.model.organization.Organization;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationProperties;
import br.com.etyllica.network.crunchbase.model.person.PersonProperties;

public class InvestmentRow {

	public static String buildInvestmentText(Investment investment) {
		FundingRound round = investment.getRelashionships().getFundingRound();
		Organization organization = investment.getRelashionships().getFundingRound().getRelationships().getOrganizationPage().getOrganization();

		return buildInvestmentText(organization, round, investment);
	}

	public static String buildInvestmentText(Organization organization, FundingRound round, Investment investment) {

		//First investor
		Investor investor = investment.getRelashionships().getInvestors().getItems().get(0);

		String text = "";

		text = CompanyRow.companyData(organization);
		text += InvestmentRow.investorData(investor);
		text += FundingRoundRow.fundingRoundData(round);

		return text;
	}

	public static String buildInvestmentText(Organization organization, FundingRound round, Investment investment, Organization investor) {
		String text = "";

		text = CompanyRow.companyData(organization);
		text += CompanyRow.companyData(investor);
		text += FundingRoundRow.fundingRoundData(round);

		return text;
	}

	public static String investorData(Investor investor) {
		String text = "";

		text+=investor.getUuid()+CSV.SEP;

		if(Investor.TYPE_ORGANIZATION.equals(investor.getType())) {
			OrganizationProperties properties = investor.getOrganizationProperties();
			//investor_name
			text+=properties.getName()+CSV.SEP;
			//investor_category_list
			text+=/*categoriesList(investor)+*/CSV.SEP;
			//investor_market
			text+=CSV.SEP;
			//investor_country_code
			text+=CSV.SEP;
			//investor_state_code
			text+=CSV.SEP;
			//investor_region
			text+=CSV.SEP;
			//investor_city
			text+=CSV.SEP;
		} else {
			PersonProperties properties = investor.getPersonProperties();

			//investor_name
			text+=properties.getName()+CSV.SEP;
			//investor_category_list
			text+=/*categoriesList(investor)+*/CSV.SEP;
			//investor_market
			text+=CSV.SEP;
			//investor_country_code
			text+=CSV.SEP;
			//investor_state_code
			text+=CSV.SEP;
			//investor_region
			text+=CSV.SEP;
			//investor_city
			text+=CSV.SEP;
		}

		return text;
	}
}
