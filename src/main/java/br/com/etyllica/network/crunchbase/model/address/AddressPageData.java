package br.com.etyllica.network.crunchbase.model.address;

import br.com.etyllica.network.crunchbase.model.base.PageData;

import com.google.gson.annotations.SerializedName;

public class AddressPageData {
	
	@SerializedName("paging")
	PageData page;
	
	@SerializedName("items")
	AddressList list;

	public PageData getPage() {
		return page;
	}

	public void setPage(PageData page) {
		this.page = page;
	}
	
	public AddressList getList() {
		return list;
	}

	public void setList(AddressList list) {
		this.list = list;
	}
	
}
