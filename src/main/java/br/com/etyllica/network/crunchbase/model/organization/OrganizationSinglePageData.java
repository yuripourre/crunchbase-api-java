package br.com.etyllica.network.crunchbase.model.organization;

import br.com.etyllica.network.crunchbase.model.base.PageData;

import com.google.gson.annotations.SerializedName;

public class OrganizationSinglePageData {
	
	@SerializedName("paging")
	PageData page;
	
	@SerializedName("item")
	Organization organization;

	public PageData getPage() {
		return page;
	}

	public void setPage(PageData page) {
		this.page = page;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
}
