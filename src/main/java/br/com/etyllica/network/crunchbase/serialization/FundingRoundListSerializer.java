package br.com.etyllica.network.crunchbase.serialization;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.network.crunchbase.model.funding.FundingRound;
import br.com.etyllica.network.crunchbase.model.funding.FundingRoundList;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class FundingRoundListSerializer implements JsonDeserializer<FundingRoundList> {

	@Override
	public FundingRoundList deserialize(JsonElement element, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		
		List<FundingRound> list = new ArrayList<FundingRound>();
		
		JsonArray items = element.getAsJsonArray();
		
		for (int i = 0; i < items.size(); i++) {
			JsonObject item = items.get(i).getAsJsonObject();
			
			list.add((FundingRound) context.deserialize(item, FundingRound.class));
		}
		
		FundingRoundList itemList = new FundingRoundList();
		itemList.setItems(list);
		
		return itemList;
	}

}
