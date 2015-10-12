package br.com.etyllica.network.crunchbase.model.funding;

import br.com.etyllica.network.crunchbase.model.base.PageData;

import com.google.gson.annotations.SerializedName;

public class FundingRoundPageData {
	
	@SerializedName("paging")
	PageData page;
	
	@SerializedName("items")
	FundingRoundList list;

	public PageData getPage() {
		return page;
	}

	public void setPage(PageData page) {
		this.page = page;
	}
	
	public FundingRoundList getList() {
		return list;
	}

	public void setList(FundingRoundList list) {
		this.list = list;
	}
	
}
