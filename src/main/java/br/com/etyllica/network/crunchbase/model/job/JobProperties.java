package br.com.etyllica.network.crunchbase.model.job;

import com.google.gson.annotations.SerializedName;

import br.com.etyllica.network.crunchbase.model.base.TemporalProperty;

public class JobProperties extends TemporalProperty {

	@SerializedName("title")
	String title;
	
	@SerializedName("started_on")
	String startedOn;
	
	@SerializedName("started_on_trust_code")
	int startedOnTrustCode;
	
	@SerializedName("ended_on")
	String endedOn;
	
	@SerializedName("ended_on_trust_code")
	int endedOnTrustCode;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(String startedOn) {
		this.startedOn = startedOn;
	}

	public int getStartedOnTrustCode() {
		return startedOnTrustCode;
	}

	public void setStartedOnTrustCode(int startedOnTrustCode) {
		this.startedOnTrustCode = startedOnTrustCode;
	}

	public String getEndedOn() {
		return endedOn;
	}

	public void setEndedOn(String endedOn) {
		this.endedOn = endedOn;
	}

	public int getEndedOnTrustCode() {
		return endedOnTrustCode;
	}

	public void setEndedOnTrustCode(int endedOnTrustCode) {
		this.endedOnTrustCode = endedOnTrustCode;
	}
    
}
