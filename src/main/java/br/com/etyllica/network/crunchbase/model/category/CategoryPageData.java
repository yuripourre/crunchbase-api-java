package br.com.etyllica.network.crunchbase.model.category;

import br.com.etyllica.network.crunchbase.model.base.PageData;

import com.google.gson.annotations.SerializedName;

public class CategoryPageData {
	
	@SerializedName("paging")
	PageData page;
	
	@SerializedName("items")
	CategoryList list;

	public PageData getPage() {
		return page;
	}

	public void setPage(PageData page) {
		this.page = page;
	}
	
	public CategoryList getList() {
		return list;
	}

	public void setList(CategoryList list) {
		this.list = list;
	}
	
}
