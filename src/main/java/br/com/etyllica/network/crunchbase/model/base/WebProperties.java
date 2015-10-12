package br.com.etyllica.network.crunchbase.model.base;

import com.google.gson.annotations.SerializedName;

public class WebProperties extends Properties {

	@SerializedName("permalink")
	String permalink;
	
	@SerializedName("api_path")
	String apiPath;

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}
    
}
