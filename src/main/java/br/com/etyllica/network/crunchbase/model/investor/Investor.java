package br.com.etyllica.network.crunchbase.model.investor;

import br.com.etyllica.network.crunchbase.model.base.Item;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationProperties;
import br.com.etyllica.network.crunchbase.model.person.PersonProperties;

public class Investor extends Item {

	public static final String TYPE_ORGANIZATION = "Organization";
	public static final String TYPE_PERSON = "Person";
	
	private PersonProperties personProperties;
	
	private OrganizationProperties organizationProperties;

	public PersonProperties getPersonProperties() {
		return personProperties;
	}

	public void setPersonProperties(PersonProperties personProperties) {
		this.personProperties = personProperties;
	}

	public OrganizationProperties getOrganizationProperties() {
		return organizationProperties;
	}

	public void setOrganizationProperties(
			OrganizationProperties organizationProperties) {
		this.organizationProperties = organizationProperties;
	}
	
}
