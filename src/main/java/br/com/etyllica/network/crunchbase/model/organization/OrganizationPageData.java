package br.com.etyllica.network.crunchbase.model.organization;

import br.com.etyllica.network.crunchbase.model.base.PageData;

import com.google.gson.annotations.SerializedName;

public class OrganizationPageData {
	
	@SerializedName("paging")
	PageData page;
	
	@SerializedName("items")
	OrganizationList list;

	public PageData getPage() {
		return page;
	}

	public void setPage(PageData page) {
		this.page = page;
	}

	public OrganizationList getList() {
		return list;
	}

	public void setList(OrganizationList list) {
		this.list = list;
	}
		
}
