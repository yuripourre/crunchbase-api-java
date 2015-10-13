package br.com.etyllica.network.crunchbase.model.investor;

import br.com.etyllica.network.crunchbase.model.base.PageData;

import com.google.gson.annotations.SerializedName;

public class InvestorPageData {
	
	@SerializedName("paging")
	PageData page;
	
	@SerializedName("items")
	InvestorList list;

	public PageData getPage() {
		return page;
	}

	public void setPage(PageData page) {
		this.page = page;
	}

	public InvestorList getList() {
		return list;
	}

	public void setList(InvestorList list) {
		this.list = list;
	}
	
}
