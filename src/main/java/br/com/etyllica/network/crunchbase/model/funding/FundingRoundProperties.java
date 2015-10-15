package br.com.etyllica.network.crunchbase.model.funding;

import com.google.gson.annotations.SerializedName;

import br.com.etyllica.network.crunchbase.model.base.WebProperties;

public class FundingRoundProperties extends WebProperties {

	@SerializedName("funding_type")
    String fundingType = "";
		
	@SerializedName("announced_on")
    String announcedOn = "";
	
	@SerializedName("announced_on_trust_code")
	int announcedOnTrustCode = 0;
    	
	@SerializedName("closed_on")
    String closedOn = "";
	
	@SerializedName("closed_on_trust_code")
	int closedOnTrustCode = 0;
	
	@SerializedName("money_raised")
	int moneyRaised = 0;
    
	@SerializedName("money_raised_currency_code")
	String moneyRaisedCorrencyCode;
    
	@SerializedName("money_raised_usd")
	int moneyRaisedUsd;
	    
    @SerializedName("target_money_raised")
	int targetMoneyRaised = 0;
    
	@SerializedName("target_money_raised_currency_code")
	String targetMoneyRaisedCorrencyCode = "";
    
    @SerializedName("target_money_raised_usd")
	int targetMoneyRaisedUsd;
    
    @SerializedName("series")
	String series = "";

	public String getFundingType() {
		return fundingType;
	}

	public void setFundingType(String fundingType) {
		this.fundingType = fundingType;
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

	public String getClosedOn() {
		return closedOn;
	}

	public void setClosedOn(String closedOn) {
		this.closedOn = closedOn;
	}

	public int getClosedOnTrustCode() {
		return closedOnTrustCode;
	}

	public void setClosedOnTrustCode(int closedOnTrustCode) {
		this.closedOnTrustCode = closedOnTrustCode;
	}

	public int getMoneyRaised() {
		return moneyRaised;
	}

	public void setMoneyRaised(int moneyRaised) {
		this.moneyRaised = moneyRaised;
	}

	public String getMoneyRaisedCorrencyCode() {
		return moneyRaisedCorrencyCode;
	}

	public void setMoneyRaisedCorrencyCode(String moneyRaisedCorrencyCode) {
		this.moneyRaisedCorrencyCode = moneyRaisedCorrencyCode;
	}

	public int getMoneyRaisedUsd() {
		return moneyRaisedUsd;
	}

	public void setMoneyRaisedUsd(int moneyRaisedUsd) {
		this.moneyRaisedUsd = moneyRaisedUsd;
	}

	public int getTargetMoneyRaised() {
		return targetMoneyRaised;
	}

	public void setTargetMoneyRaised(int targetMoneyRaised) {
		this.targetMoneyRaised = targetMoneyRaised;
	}

	public String getTargetMoneyRaisedCorrencyCode() {
		return targetMoneyRaisedCorrencyCode;
	}

	public void setTargetMoneyRaisedCorrencyCode(
			String targetMoneyRaisedCorrencyCode) {
		this.targetMoneyRaisedCorrencyCode = targetMoneyRaisedCorrencyCode;
	}

	public int getTargetMoneyRaisedUsd() {
		return targetMoneyRaisedUsd;
	}

	public void setTargetMoneyRaisedUsd(int targetMoneyRaisedUsd) {
		this.targetMoneyRaisedUsd = targetMoneyRaisedUsd;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}
		
}
