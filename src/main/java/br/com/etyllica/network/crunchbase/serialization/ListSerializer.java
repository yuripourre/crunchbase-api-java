package br.com.etyllica.network.crunchbase.serialization;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.network.crunchbase.model.base.ItemList;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class ListSerializer<T> implements JsonDeserializer<ItemList<T>> {

	private Class<T> itemClass;
	
	public ListSerializer(Class<T> klazz) {
		this.itemClass = klazz;
	}
	
	@Override
	public ItemList<T> deserialize(JsonElement element, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		
		List<T> list = new ArrayList<T>();
		
		JsonArray items = element.getAsJsonArray();
		
		for (int i = 0; i < items.size(); i++) {
			JsonObject item = items.get(i).getAsJsonObject();
			
			list.add((T) context.deserialize(item, itemClass));
		}
		
		ItemList<T> itemList = new ItemList<T>();
		itemList.setItems(list);
		
		return itemList;
	}

}
