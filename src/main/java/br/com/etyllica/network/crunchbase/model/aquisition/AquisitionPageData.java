package br.com.etyllica.network.crunchbase.model.aquisition;

import br.com.etyllica.network.crunchbase.model.base.PageData;

import com.google.gson.annotations.SerializedName;

public class AquisitionPageData {
	
	@SerializedName("paging")
	PageData page;
	
	@SerializedName("items")
	AquisitionList list;

	public PageData getPage() {
		return page;
	}

	public void setPage(PageData page) {
		this.page = page;
	}

	public AquisitionList getList() {
		return list;
	}

	public void setList(AquisitionList list) {
		this.list = list;
	}
		
}
