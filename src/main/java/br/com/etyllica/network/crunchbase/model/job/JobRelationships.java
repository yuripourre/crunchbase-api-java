package br.com.etyllica.network.crunchbase.model.job;

import com.google.gson.annotations.SerializedName;

import br.com.etyllica.network.crunchbase.model.base.TemporalProperty;
import br.com.etyllica.network.crunchbase.model.person.Person;

public class JobRelationships extends TemporalProperty {

	@SerializedName("person")
	Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	    
}
