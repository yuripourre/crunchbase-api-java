package br.com.etyllica.network.crunchbase.serialization;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.network.crunchbase.model.address.Address;
import br.com.etyllica.network.crunchbase.model.address.AddressList;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class AddressListSerializer implements JsonDeserializer<AddressList> {
	
	@Override
	public AddressList deserialize(JsonElement element, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		
		List<Address> addresses = new ArrayList<Address>();
		
		JsonArray items = element.getAsJsonArray();
		
		for (int i = 0; i < items.size(); i++) {
			JsonObject item = items.get(i).getAsJsonObject();
			
			Address address = context.deserialize(item, Address.class);
			addresses.add(address);
		}
		
		AddressList itemList = new AddressList();
		itemList.setItems(addresses);
		
		return itemList;
	}

}
