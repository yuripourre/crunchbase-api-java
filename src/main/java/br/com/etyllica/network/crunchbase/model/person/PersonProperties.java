package br.com.etyllica.network.crunchbase.model.person;

import com.google.gson.annotations.SerializedName;

import br.com.etyllica.network.crunchbase.model.base.WebProperties;

public class PersonProperties extends WebProperties {

	@SerializedName("first_name")
	String firstName;
	
	@SerializedName("last_name")
	String lastName;
	
	//"also_known_as": null,
	
	@SerializedName("bio")
	String bio;
    
    //"role_investor": null,
	
	@SerializedName("born_on")
	String bornOn;
	
	@SerializedName("born_on_trust_code")
	int bornOnTrustCode;
	
	@SerializedName("died_on")
	String diedOn;
	
	@SerializedName("died_on_trust_code")
	int diedOnTrustCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getBornOn() {
		return bornOn;
	}

	public void setBornOn(String bornOn) {
		this.bornOn = bornOn;
	}

	public int getBornOnTrustCode() {
		return bornOnTrustCode;
	}

	public void setBornOnTrustCode(int bornOnTrustCode) {
		this.bornOnTrustCode = bornOnTrustCode;
	}

	public String getDiedOn() {
		return diedOn;
	}

	public void setDiedOn(String diedOn) {
		this.diedOn = diedOn;
	}

	public int getDiedOnTrustCode() {
		return diedOnTrustCode;
	}

	public void setDiedOnTrustCode(int diedOnTrustCode) {
		this.diedOnTrustCode = diedOnTrustCode;
	}
			
}
