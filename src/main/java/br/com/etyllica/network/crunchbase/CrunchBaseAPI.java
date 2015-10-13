package br.com.etyllica.network.crunchbase;

import java.io.IOException;
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
import br.com.etyllica.network.crunchbase.model.organization.Organization;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationPage;
import br.com.etyllica.network.crunchbase.serialization.JsonBuilder;

import com.google.gson.Gson;

public class CrunchBaseAPI {

	public static String ORGANIZATION_URL = "https://api.crunchbase.com/v/3/organizations/";

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

	public static Organization parseOrganization(String json) {
		Gson gson = JsonBuilder.buildGson();
		Organization organization = gson.fromJson(json, OrganizationPage.class).getData();

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
	
	private static String extractJson(CloseableHttpResponse response)
			throws IOException {
		HttpEntity entity = response.getEntity();
		String json = EntityUtils.toString(entity, "UTF-8");
		EntityUtils.consume(entity);
		return json;
	}

}
