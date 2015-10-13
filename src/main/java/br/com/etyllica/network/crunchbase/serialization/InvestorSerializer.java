package br.com.etyllica.network.crunchbase.serialization;

import java.lang.reflect.Type;

import br.com.etyllica.network.crunchbase.model.investor.Investor;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationProperties;
import br.com.etyllica.network.crunchbase.model.person.PersonProperties;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class InvestorSerializer implements JsonDeserializer<Investor> {

	@Override
	public Investor deserialize(JsonElement element, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		
		Investor investor = new Investor();
		
		JsonObject data = element.getAsJsonObject();
		investor.setType(data.get("type").getAsString());
		investor.setUuid(data.get("uuid").getAsString());
		
		JsonObject obj = data.get("properties").getAsJsonObject();
		
		if(Investor.TYPE_ORGANIZATION.equals(investor.getType())) {
			OrganizationProperties properties = context.deserialize(obj, OrganizationProperties.class);
			investor.setOrganizationProperties(properties);
		} else if(Investor.TYPE_PERSON.equals(investor.getType())) {
			PersonProperties properties = context.deserialize(obj, PersonProperties.class);
			investor.setPersonProperties(properties);
		}
		
		return investor;
	}

}
