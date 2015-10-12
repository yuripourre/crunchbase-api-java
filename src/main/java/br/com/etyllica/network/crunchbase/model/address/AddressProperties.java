package br.com.etyllica.network.crunchbase.model.address;

import br.com.etyllica.network.crunchbase.model.base.TemporalProperty;

import com.google.gson.annotations.SerializedName;

public class AddressProperties extends TemporalProperty {

	@SerializedName("name")
	String name;
	
	@SerializedName("street_1")
	String street1;
	
	@SerializedName("street_2")
	String street2;
	
	@SerializedName("postal_code")
	String postalCode;
	
	@SerializedName("city")
	String city;
	
	@SerializedName("city_web_path")
	String cityWebPath;
	
	@SerializedName("region")
	String region;
	
	@SerializedName("region_code2")
	String regionCode;
	
	@SerializedName("region_web_path")
	String regionWebPath;

	@SerializedName("country")
	String country;
	
	@SerializedName("country_code2")
	String countryCode2;
	
	@SerializedName("country_code3")
	String countryCode;
	
	@SerializedName("country_web_path")
	String countryCodeWebPath;
	
	@SerializedName("latitude")
	double latitude;
	
	@SerializedName("longitude")
	double longitude;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityWebPath() {
		return cityWebPath;
	}

	public void setCityWebPath(String cityWebPath) {
		this.cityWebPath = cityWebPath;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionWebPath() {
		return regionWebPath;
	}

	public void setRegionWebPath(String regionWebPath) {
		this.regionWebPath = regionWebPath;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode2() {
		return countryCode2;
	}

	public void setCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCodeWebPath() {
		return countryCodeWebPath;
	}

	public void setCountryCodeWebPath(String countryCodeWebPath) {
		this.countryCodeWebPath = countryCodeWebPath;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
			
}
