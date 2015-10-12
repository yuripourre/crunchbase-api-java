package br.com.etyllica.network.crunchbase.serialization;

import br.com.etyllica.network.crunchbase.model.address.AddressList;
import br.com.etyllica.network.crunchbase.model.aquisition.AquisitionList;
import br.com.etyllica.network.crunchbase.model.category.CategoryList;
import br.com.etyllica.network.crunchbase.model.funding.FundingRoundList;
import br.com.etyllica.network.crunchbase.model.investment.InvestmentList;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonBuilder {
	
	public static Gson buildGson() {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(AddressList.class, new AddressListSerializer());
		builder.registerTypeAdapter(CategoryList.class, new CategoryListSerializer());
		builder.registerTypeAdapter(FundingRoundList.class, new FundingRoundListSerializer());
		builder.registerTypeAdapter(InvestmentList.class, new InvestmentListSerializer());
		builder.registerTypeAdapter(AquisitionList.class, new AquisitionListSerializer());
		builder.registerTypeAdapter(OrganizationList.class, new OrganizationListSerializer());
		Gson gson = builder.create();
		return gson;
	}

}
