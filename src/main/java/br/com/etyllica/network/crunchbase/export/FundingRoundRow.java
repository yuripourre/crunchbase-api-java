package br.com.etyllica.network.crunchbase.export;

import br.com.etyllica.network.crunchbase.model.funding.FundingRound;
import br.com.etyllica.network.crunchbase.model.funding.FundingRoundProperties;
import br.com.etyllica.network.crunchbase.model.organization.Organization;

public class FundingRoundRow {

	public static String buildFundingRoundText(FundingRound fundingRound) {		
		Organization organization = fundingRound.getRelationships().getOrganizationPage().getOrganization();

		return buildFundingRoundText(organization, fundingRound);
	}
	
	public static String buildFundingRoundText(Organization organization, FundingRound fundingRound) {
		String text = "";

		text = CompanyRow.companyData(organization);
		text += fundingRoundData(fundingRound);

		return text;
	}
	
	public static String fundingRoundData(FundingRound fundingRound) {
		FundingRoundProperties round = fundingRound.getProperties();
		
		String text = "";

		//funding_round_permalink
		text += round.getPermalink()+CSV.SEP;		
		//funding_round_type
		text+=round.getFundingType()+CSV.SEP;
		//funding_round_code
		text+=roundSeries(round)+CSV.SEP;

		//funded_at
		text+=round.getAnnouncedOn()+CSV.SEP;
		//funded_month
		text+=CSV.month(round.getAnnouncedOn())+CSV.SEP;
		//funded_quarter
		text+=CSV.quarter(round.getAnnouncedOn())+CSV.SEP;
		//funded_year
		text+=CSV.year(round.getAnnouncedOn())+CSV.SEP;
		//raised_amount_usd
		text+=round.getMoneyRaisedUsd();
		return text;
	}
	
	private static String roundSeries(FundingRoundProperties round) {
		return CSV.avoidNull(round.getSeries()).toUpperCase();
	}
	
}
