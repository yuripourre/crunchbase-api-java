package br.com.etyllica.network.crunchbase.model.organization;

import com.google.gson.annotations.SerializedName;

import br.com.etyllica.network.crunchbase.model.base.Page;

public class OrganizationPage extends Page {

	@SerializedName("data")
	Organization data;

	public Organization getData() {
		return data;
	}

	public void setData(Organization data) {
		this.data = data;
	}
		
}
