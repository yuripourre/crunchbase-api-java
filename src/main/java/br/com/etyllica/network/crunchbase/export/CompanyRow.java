package br.com.etyllica.network.crunchbase.export;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.etyllica.network.crunchbase.model.address.AddressProperties;
import br.com.etyllica.network.crunchbase.model.aquisition.Aquisition;
import br.com.etyllica.network.crunchbase.model.category.Category;
import br.com.etyllica.network.crunchbase.model.funding.FundingRound;
import br.com.etyllica.network.crunchbase.model.funding.FundingRoundProperties;
import br.com.etyllica.network.crunchbase.model.investment.Investment;
import br.com.etyllica.network.crunchbase.model.organization.Organization;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationProperties;

public class CompanyRow {

	private static final String SEP = ",";
	private static final String NEW_LINE = "\r\n";

	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

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
		text+=props.getPermalink()+SEP;

		//name
		text+=props.getName()+SEP;

		//homepage_url
		text+=homepage(props)+SEP;

		//categories_list
		text+=categoriesList()+SEP;

		//market
		text+=market()+SEP;

		//total_funding_usd
		text+=props.getTotalFundingUsd()+SEP;

		//status
		text+=props.isClosed() ? "closed":"";
		text+=SEP;

		text+=addressText();//+SEP

		//funding_rounds
		text+=fundingRoundCount()+SEP;

		//founded_at
		text+=props.getFoundedAt()+SEP;

		//founded_month
		text+=month(props.getFoundedAt())+SEP;
		//founded_quarter
		text+=quarter(props.getFoundedAt())+SEP;
		//founded_year
		text+=year(props.getFoundedAt())+SEP;
		//first_funding_at
		text+=firstFoundedAt()+SEP;
		//last_funding_at
		text+=lastFoundedAt()+"";

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

	private String categoriesList() {
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
			text += buildFundingRoundText(round)+NEW_LINE;
		}

		return text;
	}

	public String buildInvestmentsText() {
		List<Investment> investments = organization.getRelationships().getInvestments();

		if(investments.isEmpty()) {
			return "";
		}

		String text = "";

		for(Investment investment:investments) {
			text += buildInvestmentText(investment)+NEW_LINE;
		}

		return text;
	}

	private String buildFundingRoundText(FundingRound fundingRound) {
		OrganizationProperties company = organization.getProperties();
		FundingRoundProperties round = fundingRound.getProperties();

		String text = "";

		text = companyData(company);
		text += fundingRoundData(round);

		return text;
	}

	private String fundingRoundData(FundingRoundProperties round) {
		String text = "";

		//funding_round_permalink
		text += round.getPermalink()+SEP;		
		//funding_round_type
		text+=round.getFundingType()+SEP;
		//funding_round_code
		text+=roundSeries(round)+SEP;

		//funded_at
		text+=round.getAnnouncedOn()+SEP;
		//funded_month
		text+=month(round.getAnnouncedOn())+SEP;
		//funded_quarter
		text+=quarter(round.getAnnouncedOn())+SEP;
		//funded_year
		text+=year(round.getAnnouncedOn())+SEP;
		//raised_amount_usd
		text+=round.getMoneyRaisedUsd();
		return text;
	}

	private String roundSeries(FundingRoundProperties round) {
		if(round.getSeries()==null) {
			return "";
		}
		return round.getSeries().toUpperCase();
	}

	private String buildInvestmentText(Investment investment) {
		OrganizationProperties company = organization.getProperties();
		FundingRoundProperties round = investment.getRelashionships().getFundingRound().getProperties();
		
		String text = "";

		text = companyData(company);
		
		//investor_permalink
		text+=SEP;
		//investor_name
		text+=SEP;
		//investor_category_list
		text+=SEP;
		//investor_market
		text+=SEP;
		//investor_country_code
		text+=SEP;
		//investor_state_code
		text+=SEP;
		//investor_region
		text+=SEP;
		//investor_city
		text+=SEP;

		text += fundingRoundData(round);

		return text;
	}


	public String buildAquisionsText() {
		if(organization.getRelationships().getAquisitionsPage() == null) {
			return "";
		}
		
		OrganizationProperties company = organization.getProperties();
		
		String text = "";

		text = companyData(company);
		
		for(Aquisition aquisition : organization.getRelationships().getAquisitions()) {
			Organization aquarier = aquisition.getRelationships().getOrganization();
			//acquirer_permalink	acquirer_name	acquirer_category_list	acquirer_market	acquirer_country_code	acquirer_state_code	acquirer_region	acquirer_city	acquired_at	acquired_month	acquired_quarter	acquired_year	 
			text = companyData(aquarier.getProperties());
			text += aquisition.getProperties().getPrice()+SEP;
			text += aquisition.getProperties().getPriceCurrencyCode();
		}

		return text;
	}

	private String companyData(OrganizationProperties company) {
		String text = "";
		//company_permalink
		text+=company.getPermalink()+SEP;
		//company_name
		text+=company.getName()+SEP;
		//company_category_list
		text+=categoriesList()+SEP;
		//company_market
		text+=market()+SEP;

		text += addressText();//+SEP

		return text;
	}

	private String addressText() {
		String text = "";

		if(organization.getRelationships().getOfficesPage()!=null) {
			AddressProperties address = organization.getRelationships().getOffices().get(0).getProperties();
			//company_country_code
			text+=avoidNull(address.getCountryCode())+SEP;
			//company_state_code
			text+=avoidNull(address.getRegionCode())+SEP;
			//company_region
			text+=avoidNull(address.getRegion())+SEP;
			//company_city
			text+=avoidNull(address.getCity())+SEP;
		} else {
			//company_country_code
			text+=SEP;
			//company_state_code
			text+=SEP;
			//company_region
			text+=SEP;
			//company_city
			text+=SEP;
		}
		return text;
	}

	private String avoidNull(String text) {
		if(text == null) {
			return "";
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

	public static String month(String date) {
		if(date == null)
			return "";
		return year(date)+"-"+date.split("-")[1];	
	}

	public static String year(String date) {
		if(date == null)
			return "";

		return date.split("-")[0];
	}

	public static String quarter(String date) {
		if(date == null)
			return "";
		String month = date.split("-")[1];
		int m = Integer.parseInt(month);
		return year(date)+"-Q"+(m/4+1);
	}

	public Date toDate(String dateText) {
		Date date = new Date();
		try {
			date = DATE_FORMATTER.parse(dateText);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
