package br.com.etyllica.network.crunchbase.serialization;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.network.crunchbase.model.organization.Organization;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationList;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class OrganizationListSerializer implements JsonDeserializer<OrganizationList> {

	@Override
	public OrganizationList deserialize(JsonElement element, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		
		List<Organization> list = new ArrayList<Organization>();
		
		JsonArray items = element.getAsJsonArray();
		
		for (int i = 0; i < items.size(); i++) {
			JsonObject item = items.get(i).getAsJsonObject();
			
			list.add((Organization) context.deserialize(item, Organization.class));
		}
		
		OrganizationList itemList = new OrganizationList();
		itemList.setItems(list);
		
		return itemList;
	}

}
