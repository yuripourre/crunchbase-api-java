package br.com.etyllica.network.crunchbase.export;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import br.com.etyllica.network.crunchbase.CrunchBaseAPI;
import br.com.etyllica.network.crunchbase.model.funding.FundingRound;
import br.com.etyllica.network.crunchbase.model.investment.Investment;
import br.com.etyllica.network.crunchbase.model.investor.Investor;
import br.com.etyllica.network.crunchbase.model.organization.Organization;

public class SheetExporter {
	
	public static final String COMPANY_CSV = "company.csv";
	public static final String ROUNDS_CSV = "rounds.csv";
	public static final String INVESTMENTS_CSV = "investments.csv";
	public static final String AQUISITIONS_CSV = "aquisitions.csv";
	
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
			exportCompany(apiKey, companyWriter, roundsWriter,
					investmentsWriter, aquisitionsWriter, permalink);
		}

		closeFiles(companyWriter, roundsWriter, investmentsWriter, aquisitionsWriter);
	}

	public static void exportCompany(String apiKey, PrintWriter companyWriter,
			PrintWriter roundsWriter, PrintWriter investmentsWriter,
			PrintWriter aquisitionsWriter, String permalink)
			throws ClientProtocolException, IOException {
		
		Organization company = CrunchBaseAPI.queryCompany(apiKey, permalink);
		
		exportCompany(apiKey, company, companyWriter, roundsWriter, investmentsWriter, aquisitionsWriter);
	}
	
	public static void exportCompany(String apiKey, Organization company, PrintWriter companyWriter,
			PrintWriter roundsWriter, PrintWriter investmentsWriter,
			PrintWriter aquisitionsWriter)
			throws ClientProtocolException, IOException {
				
		System.out.println(company.getUuid());

		CompanyRow row = new CompanyRow(company);
		System.out.println(Exporter.writeLine(companyWriter, row.buildCompanyText()));
		System.out.println(Exporter.writeLine(aquisitionsWriter, row.buildAquisionsText()));

		//System.out.println(Exporter.writeLine(roundsWriter, row.buildRoundsText()));
		//System.out.println(Exporter.writeLine(investmentsWriter, row.buildInvestmentsText()));
		
		writeFundingRounds(apiKey, roundsWriter, investmentsWriter, company);
	}

	private static void writeFundingRounds(String apiKey, PrintWriter roundsWriter, PrintWriter investmentWriter, Organization organization) throws ClientProtocolException, IOException {
		List<FundingRound> fundingRounds = organization.getRelationships().getFundingRounds();

		if(fundingRounds.isEmpty()) {
			return;
		}

		for(FundingRound round:fundingRounds) {
			FundingRound fundingRound = CrunchBaseAPI.queryFundingRound(apiKey, round.getUuid());
			System.out.println(Exporter.writeLine(roundsWriter, FundingRoundRow.buildFundingRoundText(organization, round)));
			
			writeInvestments(apiKey, investmentWriter, fundingRound, organization);
		}
	}
	
	private static void writeInvestments(String apiKey, PrintWriter investmentsWriter, FundingRound round, Organization organization) throws ClientProtocolException, IOException {
		List<Investment> investments = round.getRelationships().getInvestmentsPage().getList().getItems();

		if(investments.isEmpty()) {
			return;
		}

		for(Investment investment : investments) {
			Investor investor = investment.getRelashionships().getInvestors().getItems().get(0);
			
			if(Investor.TYPE_ORGANIZATION.equals(investor.getType())) {
				Organization fullInvestor = CrunchBaseAPI.queryCompany(apiKey, investor.getOrganizationProperties().getPermalink());
				System.out.println(Exporter.writeLine(investmentsWriter, InvestmentRow.buildInvestmentText(organization, round, investment, fullInvestor)));	
			} else {
				System.out.println(Exporter.writeLine(investmentsWriter, InvestmentRow.buildInvestmentText(organization, round, investment)));	
			}
		}
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

		for (String line : Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8)) {
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

		for (String line : Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8)) {
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

	public static Map<String, String> loadFilter(String file) throws IOException {
		Map<String, String> filter = new HashMap<String, String>();
		
		for (String line : Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8)) {
			if(line.startsWith("#") || line.isEmpty()) {
				continue;
			}
			
			if(!line.contains(",")) {
				System.out.println("Problem: "+line);
				continue;
			}
			
			String name = line.split(",")[0];
			String url = line.split(",")[1];
			
			filter.put(name, url);
		}
		
		return filter;
	}

}
