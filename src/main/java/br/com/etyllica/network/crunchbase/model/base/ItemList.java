package br.com.etyllica.network.crunchbase.model.base;

import java.util.List;

public class ItemList<T> {
	
	private List<T> items;
	
	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
	
}
