package br.com.etyllica.network.crunchbase.serialization;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.network.crunchbase.model.investor.Investor;
import br.com.etyllica.network.crunchbase.model.investor.InvestorList;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class InvestorListSerializer implements JsonDeserializer<InvestorList> {

	@Override
	public InvestorList deserialize(JsonElement element, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		
		List<Investor> list = new ArrayList<Investor>();
		
		JsonArray items = element.getAsJsonArray();
		
		for (int i = 0; i < items.size(); i++) {
			JsonObject item = items.get(i).getAsJsonObject();
			
			list.add((Investor) context.deserialize(item, Investor.class));
		}
		
		InvestorList itemList = new InvestorList();
		itemList.setItems(list);
		
		return itemList;
	}

}
