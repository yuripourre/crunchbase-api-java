import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;

import br.com.etyllica.network.crunchbase.CrunchBaseAPI;
import br.com.etyllica.network.crunchbase.export.SheetExporter;
import br.com.etyllica.network.crunchbase.model.funding.FundingRound;
import br.com.etyllica.network.crunchbase.model.investment.Investment;
import br.com.etyllica.network.crunchbase.model.investor.Investor;
import br.com.etyllica.network.crunchbase.model.organization.Organization;

public class QueryExample {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, ClientProtocolException, IOException {
		
		String apiKey = "";
		
		try {
			apiKey = SheetExporter.loadKey("key.txt");
		} catch (IOException e) {
			System.err.println("File key.txt not found.");
			return;
		}
		
		Organization company = CrunchBaseAPI.queryCompany(apiKey, "aeromot");
		System.out.println(company.getProperties().getName());
		/*
		
		List<Category> categories = CrunchBaseAPI.queryCategories(apiKey, "igov");
		for(Category category: categories) {
			System.out.println(category.getProperties().getName());
		}
		
		//Problematic
		List<FundingRound> rounds = CrunchBaseAPI.queryFundingRounds(apiKey, "igov");
		for(FundingRound round: rounds) {
			System.out.println(round.getUuid());
		}*/
		//List<FundingRound> rounds = CrunchBaseAPI.queryFundingRounds(apiKey, "aeromot");
		for(FundingRound round: company.getRelationships().getFundingRounds()) {
			FundingRound fundingRound = CrunchBaseAPI.queryFundingRound(apiKey, round.getUuid());
			Investment investment = fundingRound.getRelationships().getInvestmentsPage().getList().getItems().get(0);
			Investor investor = investment.getRelashionships().getInvestors().getItems().get(0);
			
			System.out.println(investor.getType());
			if(Investor.TYPE_ORGANIZATION.equals(investor.getType())) {
				System.out.println(investor.getOrganizationProperties().getName());
			} else {
				System.out.println(investor.getPersonProperties().getName());
			}
		}
	}
	
}