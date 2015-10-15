package br.com.etyllica.network.crunchbase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import br.com.etyllica.network.crunchbase.model.category.Category;
import br.com.etyllica.network.crunchbase.model.category.CategoryPage;
import br.com.etyllica.network.crunchbase.model.funding.FundingRound;
import br.com.etyllica.network.crunchbase.model.funding.FundingRoundPage;
import br.com.etyllica.network.crunchbase.model.funding.single.FundingRoundSinglePage;
import br.com.etyllica.network.crunchbase.model.organization.Organization;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationPage;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationSinglePage;
import br.com.etyllica.network.crunchbase.serialization.JsonBuilder;

import com.google.gson.Gson;

public class CrunchBaseAPI {

	public static String ORGANIZATION_URL = "https://api.crunchbase.com/v/3/organizations/";
	public static String FUNDING_ROUND_URL = "https://api.crunchbase.com/v/3/funding-rounds/";

	public static Organization queryCompany(String userKey, String permaLink) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(CrunchBaseAPI.ORGANIZATION_URL+permaLink+"?user_key="+userKey);
		CloseableHttpResponse response = httpclient.execute(httpGet);

		try {
			String json = extractJson(response);
			return parseOrganization(json);
		} finally {
			response.close();
			httpclient.close();
		}
	}
	
	public static List<Organization> queryCompanyByName(String userKey, String name) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String fixedName = fixString(name);
		HttpGet httpGet = new HttpGet(CrunchBaseAPI.ORGANIZATION_URL+"?user_key="+userKey+"&name="+fixedName);
		CloseableHttpResponse response = httpclient.execute(httpGet);

		try {
			String json = extractJson(response);
			return parseOrganizationPage(json).getData().getList().getItems();
		} finally {
			response.close();
			httpclient.close();
		}
	}
	
	public static OrganizationPage queryCompaniesPage(String userKey, int page) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(CrunchBaseAPI.ORGANIZATION_URL+"?user_key="+userKey+"&page="+page);
		CloseableHttpResponse response = httpclient.execute(httpGet);

		try {
			String json = extractJson(response);
			return parseOrganizationPage(json);
		} finally {
			response.close();
			httpclient.close();
		}
	}
	
	public static List<Organization> queryCompanies(String userKey, int page) throws ClientProtocolException, IOException {
		return queryCompaniesPage(userKey, page).getData().getList().getItems();
	}
	
	private static String fixString(String name) {
		return name.replaceAll(" ", "%20");
	}
	
	public static Organization parseOrganization(String json) {
		Gson gson = JsonBuilder.buildGson();
		Organization organization = gson.fromJson(json, OrganizationSinglePage.class).getData();

		return organization;
	}
	
	public static OrganizationPage parseOrganizationPage(String json) {
		Gson gson = JsonBuilder.buildGson();
		OrganizationPage organization = gson.fromJson(json, OrganizationPage.class);

		return organization;
	}

	public static List<Category> queryCategories(String apiKey, String permaLink) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(CrunchBaseAPI.ORGANIZATION_URL+permaLink+"/categories/?user_key="+apiKey);
		CloseableHttpResponse response = httpclient.execute(httpGet);

		try {
			String json = extractJson(response);
			Gson gson = JsonBuilder.buildGson();
			
			List<Category> categories = gson.fromJson(json, CategoryPage.class).getData().getList().getItems();

			return categories;
		} finally {
			response.close();
			httpclient.close();
		}
	}
	
	public static List<FundingRound> queryFundingRounds(String apiKey, String permaLink) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(CrunchBaseAPI.ORGANIZATION_URL+permaLink+"/funding_rounds/?user_key="+apiKey);
		CloseableHttpResponse response = httpclient.execute(httpGet);

		try {
			String json = extractJson(response);
			Gson gson = JsonBuilder.buildGson();
			
			List<FundingRound> fundingRounds = gson.fromJson(json, FundingRoundPage.class).getData().getList().getItems();

			return fundingRounds;
		} finally {
			response.close();
			httpclient.close();
		}
	}
	
	public static FundingRound queryFundingRound(String apiKey, String uuid) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(CrunchBaseAPI.FUNDING_ROUND_URL+uuid+"/?user_key="+apiKey);
		CloseableHttpResponse response = httpclient.execute(httpGet);

		try {
			String json = extractJson(response);
			return parseFundingRound(json);
		} finally {
			response.close();
			httpclient.close();
		}
	}

	public static FundingRound parseFundingRound(String json) {
		Gson gson = JsonBuilder.buildGson();
		
		FundingRound fundingRound = gson.fromJson(json, FundingRoundSinglePage.class).getFundingRound();
		return fundingRound;
	}
	
	private static String extractJson(CloseableHttpResponse response)
			throws IOException {
		HttpEntity entity = response.getEntity();
		String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
		EntityUtils.consume(entity);
		return json;
	}

}
