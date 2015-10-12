package br.com.etyllica.network.crunchbase.export;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import br.com.etyllica.network.crunchbase.CrunchBaseAPI;
import br.com.etyllica.network.crunchbase.model.organization.Organization;

public class SheetExporter {

	public static final String COMPANY_CSV = "../company.csv";
	public static final String ROUNDS_CSV = "../rounds.csv";
	public static final String INVESTMENTS_CSV = "../investments.csv";
	public static final String AQUISITIONS_CSV = "../aquisitions.csv";
	
	public static void exportCompanies(String apiKey, List<String>companies)
			throws FileNotFoundException, UnsupportedEncodingException,
			ClientProtocolException, IOException {
		
		//Open files
		PrintWriter companyWriter = Exporter.openFile(COMPANY_CSV);
		PrintWriter roundsWriter = Exporter.openFile(ROUNDS_CSV);
		PrintWriter investmentsWriter = Exporter.openFile(INVESTMENTS_CSV);
		PrintWriter aquisitionsWriter = Exporter.openFile(AQUISITIONS_CSV);
		
		exportHeaders(companyWriter, roundsWriter, investmentsWriter, aquisitionsWriter);

		for(String permalink: companies) {
			Organization company = CrunchBaseAPI.queryCompany(apiKey, permalink);
			System.out.println(company.getUuid());

			CompanyRow row = new CompanyRow(company);
			System.out.println(Exporter.writeLine(companyWriter, row.buildCompanyText()));
			System.out.println(Exporter.writeLine(roundsWriter, row.buildRoundsText()));
			System.out.println(Exporter.writeLine(investmentsWriter, row.buildInvestmentsText()));
			System.out.println(Exporter.writeLine(aquisitionsWriter, row.buildAquisionsText()));
		}

		closeFiles(companyWriter, roundsWriter, investmentsWriter, aquisitionsWriter);
	}

	public static void closeFiles(PrintWriter companyWriter,PrintWriter roundsWriter,PrintWriter investmentsWriter,PrintWriter aquisitionsWriter) {
		Exporter.closeFile(companyWriter);
		Exporter.closeFile(roundsWriter);
		Exporter.closeFile(investmentsWriter);
		Exporter.closeFile(aquisitionsWriter);
	}

	public static void exportHeaders(PrintWriter companyWriter,PrintWriter roundsWriter,PrintWriter investmentsWriter,PrintWriter aquisitionsWriter) {
		System.out.println(Exporter.writeLine(companyWriter, Exporter.buildCompanyHeaders()));
		System.out.println(Exporter.writeLine(roundsWriter, Exporter.buildRoundHeaders()));
		System.out.println(Exporter.writeLine(investmentsWriter, Exporter.buildInvestmentHeaders()));
		System.out.println(Exporter.writeLine(aquisitionsWriter, Exporter.buildAquisitionHeaders()));
	}
	
	public static String loadKey(String file) throws IOException {
		String key = "";

		for (String line : Files.readAllLines(Paths.get(file))) {
			System.out.println(line);
			if(line.startsWith("#") || line.isEmpty()) {
				continue;
			}
			key = line;
		}
		return key;
	}

	public static List<String> loadCompanies(String file) throws IOException {
		List<String> companies = new ArrayList<String>();
		
		for (String line : Files.readAllLines(Paths.get(file))) {
			System.out.println(line);
			if(line.startsWith("#") || line.isEmpty()) {
				continue;
			}
			companies.add(line);
		}
		
		//Sort companies' names
		Collections.sort(companies);
		
		return companies;
	}

}
