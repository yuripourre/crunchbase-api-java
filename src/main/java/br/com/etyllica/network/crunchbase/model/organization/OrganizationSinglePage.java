package br.com.etyllica.network.crunchbase.model.organization;

import com.google.gson.annotations.SerializedName;

public class OrganizationSinglePage {

	@SerializedName("data")
	Organization data;

	public Organization getData() {
		return data;
	}

	public void setData(Organization data) {
		this.data = data;
	}
	
}
