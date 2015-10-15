package br.com.etyllica.network.crunchbase.model.base;

import com.google.gson.annotations.SerializedName;

public class PageData {

	@SerializedName("total_items")
	int totalItems;
	
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

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getNextPageUrlOrder() {
		return nextPageUrlOrder;
	}

	public void setNextPageUrlOrder(String nextPageUrlOrder) {
		this.nextPageUrlOrder = nextPageUrlOrder;
	}

	public String getPrevPageUrlOrder() {
		return prevPageUrlOrder;
	}

	public void setPrevPageUrlOrder(String prevPageUrlOrder) {
		this.prevPageUrlOrder = prevPageUrlOrder;
	}
	
}
