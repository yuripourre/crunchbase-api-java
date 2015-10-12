package br.com.etyllica.network.crunchbase.model.base;

import com.google.gson.annotations.SerializedName;

public class Metadata {
	int version;
	
	@SerializedName("www_path_prefix")
	String pathPrefix;
	
    @SerializedName("api_path_prefix")
    String apiPathPrefix;
    
    @SerializedName("image_path_prefix")
    String imagePathPrefix;	
}
