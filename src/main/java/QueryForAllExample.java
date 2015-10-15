import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import br.com.etyllica.network.crunchbase.CrunchBaseAPI;
import br.com.etyllica.network.crunchbase.export.Exporter;
import br.com.etyllica.network.crunchbase.export.SheetExporter;
import br.com.etyllica.network.crunchbase.model.organization.Organization;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationPage;

public class QueryForAllExample {

	static String apiKey = "";
	static PrintWriter companyWriter;
	static PrintWriter roundsWriter;
	static PrintWriter investmentsWriter;
	static PrintWriter aquisitionsWriter;
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, ClientProtocolException, IOException {

		try {
			apiKey = SheetExporter.loadKey("../key.txt");
		} catch (IOException e) {
			System.err.println("File key.txt not found.");
			return;
		}

		//Open files
		companyWriter = Exporter.openFile("../"+SheetExporter.COMPANY_CSV);
		roundsWriter = Exporter.openFile("../"+SheetExporter.ROUNDS_CSV);
		investmentsWriter = Exporter.openFile("../"+SheetExporter.INVESTMENTS_CSV);
		aquisitionsWriter = Exporter.openFile("../"+SheetExporter.AQUISITIONS_CSV);

		SheetExporter.exportHeaders(companyWriter, roundsWriter, investmentsWriter, aquisitionsWriter);

		OrganizationPage page = CrunchBaseAPI.queryCompaniesPage(apiKey, 1);

		int totalPages = page.getData().getPage().getNumberOfPages();
		System.out.println("Listing: "+totalPages*100+" companies.");
		listCompanies(page);

		/*for(int i = 2; i <= totalPages; i++) {
			page = CrunchBaseAPI.queryCompaniesPage(apiKey, i);
			listCompanies(page);
		}*/
		
		System.out.println("Finished!");

		SheetExporter.closeFiles(companyWriter, roundsWriter, investmentsWriter, aquisitionsWriter);
	}

	public static void listCompanies(OrganizationPage page) throws ClientProtocolException, IOException {
		List<Organization> companies = page.getData().getList().getItems();
		for(Organization organization: companies) {
			SheetExporter.exportCompany(apiKey, companyWriter, roundsWriter,
					investmentsWriter, aquisitionsWriter, organization.getProperties().getPermalink());
		}
	}

}