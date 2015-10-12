package br.com.etyllica.network.crunchbase.model.investment;

import br.com.etyllica.network.crunchbase.model.base.PageData;

import com.google.gson.annotations.SerializedName;

public class InvestmentPageData {
	
	@SerializedName("paging")
	PageData page;
	
	@SerializedName("items")
	InvestmentList list;

	public PageData getPage() {
		return page;
	}

	public void setPage(PageData page) {
		this.page = page;
	}

	public InvestmentList getList() {
		return list;
	}

	public void setList(InvestmentList list) {
		this.list = list;
	}
		
}
