import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import br.com.etyllica.network.crunchbase.CrunchBaseAPI;
import br.com.etyllica.network.crunchbase.export.SheetExporter;
import br.com.etyllica.network.crunchbase.model.organization.Organization;

public class QueryByNameExample {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, ClientProtocolException, IOException {
		
		String apiKey = "";
		
		try {
			apiKey = SheetExporter.loadKey("../key.txt");
		} catch (IOException e) {
			System.err.println("File key.txt not found.");
			return;
		}
		
		List<Organization> companies = CrunchBaseAPI.queryCompanyByName(apiKey, "Tip Jar");
		System.out.println(companies.get(0).getProperties().getName());
	}
	
}