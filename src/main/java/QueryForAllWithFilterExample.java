import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.client.ClientProtocolException;

import br.com.etyllica.network.crunchbase.CrunchBaseAPI;
import br.com.etyllica.network.crunchbase.export.SheetExporter;
import br.com.etyllica.network.crunchbase.model.organization.Organization;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationPage;

public class QueryForAllWithFilterExample {

	private static Set<String> found = new HashSet<String>();
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, ClientProtocolException, IOException {

		Map<String, String> filter;
		
		String apiKey = "";

		try {
			apiKey = SheetExporter.loadKey("../key.txt");
		} catch (IOException e) {
			System.err.println("File key.txt not found.");
			return;
		}
		
		try {
			filter = SheetExporter.loadFilter("../filter.txt");
		} catch (IOException e) {
			System.err.println("File filter.txt not found.");
			return;
		}
		
		System.out.println("Filter loaded.");

		OrganizationPage page = CrunchBaseAPI.queryCompaniesPage(apiKey, 1);

		int totalPages = page.getData().getPage().getNumberOfPages();
		System.out.println("Listing: "+totalPages*100+" companies.");

		listFilteredCompanies(filter, page);
		System.out.println("Page 1");

		for(int i = 2; i <= totalPages; i++) {
			System.out.println("Page "+i);
			page = CrunchBaseAPI.queryCompaniesPage(apiKey, i);
			listFilteredCompanies(filter, page);
		}
	}

	public static void listFilteredCompanies(Map<String, String> filter, OrganizationPage page) {
		List<Organization> companies = page.getData().getList().getItems();
		for(Organization organization: companies) {
			String name = organization.getProperties().getName();
			if(filter.containsKey(name)) {
				found.add(name);
				System.out.println(organization.getProperties().getName());				
			}
		}
	}
}
