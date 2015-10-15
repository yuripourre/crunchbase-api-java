package br.com.etyllica.network.crunchbase.export;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import br.com.etyllica.network.crunchbase.model.address.AddressProperties;
import br.com.etyllica.network.crunchbase.model.aquisition.Aquisition;
import br.com.etyllica.network.crunchbase.model.category.Category;
import br.com.etyllica.network.crunchbase.model.funding.FundingRound;
import br.com.etyllica.network.crunchbase.model.organization.Organization;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationProperties;

public class CompanyRow {

	private Organization organization;

	public CompanyRow(Organization organization) {
		super();
		this.organization = organization;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String buildCompanyText() {

		OrganizationProperties props = organization.getProperties();

		String text = "";

		//permalink
		text+=props.getPermalink()+CSV.SEP;

		//name
		text+=props.getName()+CSV.SEP;

		//homepage_url
		text+=homepage(props)+CSV.SEP;

		//categories_list
		text+=categoriesList(organization)+CSV.SEP;

		//market
		text+=market()+CSV.SEP;

		//total_funding_usd
		text+=props.getTotalFundingUsd()+CSV.SEP;

		//status
		text+=props.isClosed() ? "closed":"";
		text+=CSV.SEP;

		text+=addressText();//+CSV.SEP

		//funding_rounds
		text+=fundingRoundCount()+CSV.SEP;

		//founded_at
		text+=props.getFoundedAt()+CSV.SEP;

		//founded_month
		text+=CSV.month(props.getFoundedAt())+CSV.SEP;
		//founded_quarter
		text+=CSV.quarter(props.getFoundedAt())+CSV.SEP;
		//founded_year
		text+=CSV.year(props.getFoundedAt())+CSV.SEP;
		//first_funding_at
		text+=firstFoundedAt()+CSV.SEP;
		//last_funding_at
		text+=lastFoundedAt();

		return text;
	}

	private String homepage(OrganizationProperties props) {
		if(props.getHomepageUrl() == null) {
			return "";
		}
		return props.getHomepageUrl();
	}

	private String lastFoundedAt() {
		List<FundingRound> fundingRounds = organization.getRelationships().getFundingRounds();

		String lastDate = "";
		long lastTime = 0;

		if(fundingRounds.isEmpty()) {
			return "";
		} else {
			for(FundingRound round: fundingRounds) {

				String dateText = round.getProperties().getAnnouncedOn();

				long time = toDate(dateText).getTime();
				if(time > lastTime) {
					lastDate = dateText;
					lastTime = time;
				}
			}
		}

		return lastDate;
	}

	private String firstFoundedAt() {
		List<FundingRound> fundingRounds = organization.getRelationships().getFundingRounds();

		String firstDate = "";
		long firstTime = Long.MAX_VALUE;

		if(fundingRounds.isEmpty()) {
			return "";	
		} else {
			for(FundingRound round: fundingRounds) {
				String dateText = round.getProperties().getAnnouncedOn();

				long time = toDate(dateText).getTime();
				if(time < firstTime) {
					firstDate = dateText;
					firstTime = time;
				}
			}
		}

		return firstDate;
	}

	public static String categoriesList(Organization organization) {
		if(organization.getRelationships() == null) {
			return "";
		}
		
		List<Category> categories = organization.getRelationships().getCategories();

		String text = "|";

		if(categories!=null && !categories.isEmpty()) {
			for(Category category : categories) {
				text+=category.getProperties().getName()+"|";
			}
			return text;
		}
		return "";
	}

	private String market() {
		return market(organization);
	}
	
	private static String market(Organization organization) {
		List<Category> categories = organization.getRelationships().getCategories();
		if(categories != null && !categories.isEmpty()) {
			return categories.get(0).getProperties().getName();
		}
		return "";
	}

	public String buildRoundsText() {
		List<FundingRound> fundingRounds = organization.getRelationships().getFundingRounds();

		if(fundingRounds.isEmpty()) {
			return "";
		}

		String text = "";

		for(FundingRound round:fundingRounds) {
			text += FundingRoundRow.buildFundingRoundText(round)+CSV.NEW_LINE;
		}

		return text;
	}

	public String buildAquisionsText() {
		if(organization.getRelationships().getAquisitionsPage() == null) {
			return "";
		}

		String text = "";

		text = companyData(organization);

		for(Aquisition aquisition : organization.getRelationships().getAquisitions()) {
			Organization aquarier = aquisition.getRelationships().getOrganization();
			//acquirer_permalink	acquirer_name	acquirer_category_list	acquirer_market	acquirer_country_code	acquirer_state_code	acquirer_region	acquirer_city	acquired_at	acquired_month	acquired_quarter	acquired_year	 
			text = companyData(aquarier);
			text += aquisition.getProperties().getPrice()+CSV.SEP;
			text += aquisition.getProperties().getPriceCurrencyCode();
		}

		return text;
	}
	
	public static String companyData(Organization organization) {
		
		OrganizationProperties properties = organization.getProperties();
		
		String text = "";
		//company_permalink
		text+=properties.getPermalink()+CSV.SEP;
		//company_name
		text+=properties.getName()+CSV.SEP;
		//company_category_list
		text+=categoriesList(organization)+CSV.SEP;
		//company_market
		text+=market(organization)+CSV.SEP;

		text += addressText(organization);//+CSV.SEP

		return text;
	}

	private String addressText() {
		return addressText(organization);
	}
	
	public static String addressText(Organization organization) {
		String text = "";

		if(organization.getRelationships().getOfficesPage()!=null && !organization.getRelationships().getOfficesPage().getList().getItems().isEmpty()) {
			AddressProperties address = organization.getRelationships().getOfficesPage().getList().getItems().get(0).getProperties();
			//company_country_code
			text+=CSV.avoidNull(address.getCountryCode())+CSV.SEP;
			//company_state_code
			text+=CSV.avoidNull(address.getRegionCode())+CSV.SEP;
			//company_region
			text+=CSV.avoidNull(address.getRegion())+CSV.SEP;
			//company_city
			text+=CSV.avoidNull(address.getCity())+CSV.SEP;
		} else {
			//company_country_code
			text+=CSV.SEP;
			//company_state_code
			text+=CSV.SEP;
			//company_region
			text+=CSV.SEP;
			//company_city
			text+=CSV.SEP;
		}
		return text;
	}

	private String fundingRoundCount() {
		if(organization.getRelationships().getFundingRoundsPage() == null) {
			return "0";
		} else {
			return Integer.toString(organization.getRelationships().getFundingRounds().size());	
		}
	}

	public Date toDate(String dateText) {
		Date date = new Date();
		try {
			date = CSV.DATE_FORMATTER.parse(dateText);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
