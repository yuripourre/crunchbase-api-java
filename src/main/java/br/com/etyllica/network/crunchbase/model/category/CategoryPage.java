package br.com.etyllica.network.crunchbase.model.category;

import com.google.gson.annotations.SerializedName;

public class CategoryPage {
	
	@SerializedName("data")
	CategoryPageData data;

	public CategoryPageData getData() {
		return data;
	}

	public void setData(CategoryPageData data) {
		this.data = data;
	}

}
