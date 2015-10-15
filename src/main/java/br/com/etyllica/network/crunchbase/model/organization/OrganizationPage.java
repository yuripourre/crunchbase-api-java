package br.com.etyllica.network.crunchbase.model.organization;

import com.google.gson.annotations.SerializedName;

import br.com.etyllica.network.crunchbase.model.base.Page;

public class OrganizationPage extends Page {

	@SerializedName("data")
	OrganizationPageData data;

	public OrganizationPageData getData() {
		return data;
	}

	public void setData(OrganizationPageData data) {
		this.data = data;
	}
		
}
