import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import br.com.etyllica.network.crunchbase.export.SheetExporter;

public class CompanyExample {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, ClientProtocolException, IOException {
		
		String apiKey = "";
		List<String> companies = new ArrayList<String>();
		
		try {
			apiKey = SheetExporter.loadKey("../key.txt");
		} catch (IOException e) {
			System.err.println("File key.txt not found.");
			return;
		}

		try {
			companies = SheetExporter.loadCompanies("../query.txt");
		} catch (IOException e) {
			System.err.println("File query.txt not found.");
		}

		SheetExporter.exportCompanies(apiKey, companies);
	}
	
}