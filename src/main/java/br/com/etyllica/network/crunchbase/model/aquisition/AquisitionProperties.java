package br.com.etyllica.network.crunchbase.model.aquisition;

import com.google.gson.annotations.SerializedName;

import br.com.etyllica.network.crunchbase.model.base.WebProperties;

/**
 * Reference: http://data.crunchbase.com/v3/docs/acquisition
 * 
 */
public class AquisitionProperties extends WebProperties {

	@SerializedName("price")
	int price;

	@SerializedName("price_currency_code")
	String priceCurrencyCode;
	
	@SerializedName("price_usd")
	int price_usd;
		
	@SerializedName("payment_type")
	String paymentType;

	@SerializedName("acquisition_type")
	String aquisitionType;

	@SerializedName("acquisition_status")
	String aquisitionStatus;

	@SerializedName("disposition_of_acquired")
	String dispositionOfAquired;

	@SerializedName("announced_on")
	String announcedOn;
	
	@SerializedName("announced_on_trust_code")
	int announcedOnTrustCode;

	@SerializedName("completed_on_on")
	String completedOn;

	@SerializedName("completed_on_trust_code")
	int completedOnTrustCode;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPriceCurrencyCode() {
		return priceCurrencyCode;
	}

	public void setPriceCurrencyCode(String priceCurrencyCode) {
		this.priceCurrencyCode = priceCurrencyCode;
	}

	public int getPrice_usd() {
		return price_usd;
	}

	public void setPrice_usd(int price_usd) {
		this.price_usd = price_usd;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getAquisitionType() {
		return aquisitionType;
	}

	public void setAquisitionType(String aquisitionType) {
		this.aquisitionType = aquisitionType;
	}

	public String getAquisitionStatus() {
		return aquisitionStatus;
	}

	public void setAquisitionStatus(String aquisitionStatus) {
		this.aquisitionStatus = aquisitionStatus;
	}

	public String getDispositionOfAquired() {
		return dispositionOfAquired;
	}

	public void setDispositionOfAquired(String dispositionOfAquired) {
		this.dispositionOfAquired = dispositionOfAquired;
	}

	public String getAnnouncedOn() {
		return announcedOn;
	}

	public void setAnnouncedOn(String announcedOn) {
		this.announcedOn = announcedOn;
	}

	public int getAnnouncedOnTrustCode() {
		return announcedOnTrustCode;
	}

	public void setAnnouncedOnTrustCode(int announcedOnTrustCode) {
		this.announcedOnTrustCode = announcedOnTrustCode;
	}

	public String getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(String completedOn) {
		this.completedOn = completedOn;
	}

	public int getCompletedOnTrustCode() {
		return completedOnTrustCode;
	}

	public void setCompletedOnTrustCode(int completedOnTrustCode) {
		this.completedOnTrustCode = completedOnTrustCode;
	}

}
