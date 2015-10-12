package br.com.etyllica.network.crunchbase.export;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Exporter {

	public static PrintWriter openFile(String filepath) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(filepath, "UTF-8");
		return writer;
	}
		
	public static String writeLine(PrintWriter writer, String content) {
		if(content.isEmpty()) {
			return content;
		}
		writer.println(content);
		return content;
	}
	
	public static void closeFile(PrintWriter writer) {
		writer.close();
	}
	
	public static String buildCompanyHeaders() {
		return "permalink,name,homepage_url,category_list,market,funding_total_usd,status,country_code,state_code,region,city,funding_rounds,founded_at,founded_month,founded_quarter,founded_year,first_funding_at,last_funding_at";
	}
	
	public static String buildRoundHeaders() {
		return "company_permalink,company_name,company_category_list,company_market,company_country_code,company_state_code,company_region,company_city,funding_round_permalink,funding_round_type,funding_round_code,funded_at,funded_month,funded_quarter,funded_year,raised_amount_usd";
	}
	
	public static String buildInvestmentHeaders() {
		return "company_permalink,company_name,company_category_list,company_market,company_country_code,company_state_code,company_region,company_city,investor_permalink,investor_name,investor_category_list,investor_market,investor_country_code,investor_state_code,investor_region,investor_city,funding_round_permalink,funding_round_type,funding_round_code,funded_at,funded_month,funded_quarter,funded_year,raised_amount_usd";
	}
	
	public static String buildAquisitionHeaders() {
		return "company_permalink,company_name,company_category_list,company_market,company_country_code,company_state_code,company_region,company_city,acquirer_permalink,acquirer_name,acquirer_category_list,acquirer_market,acquirer_country_code,acquirer_state_code,acquirer_region,acquirer_city,acquired_at,acquired_month,acquired_quarter,acquired_year,price_amount,price_currency_code";
	}
	
}
