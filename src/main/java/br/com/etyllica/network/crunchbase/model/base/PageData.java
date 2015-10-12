package br.com.etyllica.network.crunchbase.model.base;

import com.google.gson.annotations.SerializedName;

public class PageData {

	@SerializedName("total_items")
	int totalItems = 3;
	
	@SerializedName("number_of_pages")
	int numberOfPages;
    
	@SerializedName("current_page")
	int currentPage;
	
	@SerializedName("items_per_page")
	int itemsPerPage;
	
	@SerializedName("sort_order")
	String sortOrder;
	
	@SerializedName("next_page_url")
	String nextPageUrlOrder;
	
	@SerializedName("prev_page_url")
	String prevPageUrlOrder;
	
}
