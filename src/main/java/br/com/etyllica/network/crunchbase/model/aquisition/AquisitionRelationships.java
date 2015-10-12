package br.com.etyllica.network.crunchbase.model.aquisition;

import br.com.etyllica.network.crunchbase.model.base.TemporalProperty;
import br.com.etyllica.network.crunchbase.model.organization.Organization;

import com.google.gson.annotations.SerializedName;

public class AquisitionRelationships extends TemporalProperty {

	@SerializedName("acquiree")
	Organization organization;

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}
