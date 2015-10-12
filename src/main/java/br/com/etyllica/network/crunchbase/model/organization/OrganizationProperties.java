package br.com.etyllica.network.crunchbase.model.organization;

import br.com.etyllica.network.crunchbase.model.base.WebProperties;

import com.google.gson.annotations.SerializedName;

public class OrganizationProperties extends WebProperties {
		    
    @SerializedName("primary_role")
    String primaryRole = "";
    
    @SerializedName("role_company")
    boolean roleCompany;
    
    @SerializedName("role_investor")
    boolean roleInvestor;
    
    @SerializedName("founded_on")
    String foundedAt = "";
        
    @SerializedName("total_funding_usd")
    int totalFundingUsd = 0;
    
    @SerializedName("number_of_investments")
    int numberOfInvestments = 0;
    
    @SerializedName("homepage_url")
    String homepageUrl = "";
    
    @SerializedName("is_closed")
    boolean isClosed = false;
        
    /*
    "role_group": null,
    "role_school": null,
    "founded_on": null,
    "founded_on_trust_code": null,
    "is_closed": null,
    "closed_on": null,
    "closed_on_trust_code": 0,
    "num_employees_min": null,
    "num_employees_max": null,
    "stock_exchange": null,
    "stock_symbol": null,    
    */

	public String getPrimaryRole() {
		return primaryRole;
	}

	public void setPrimaryRole(String primaryRole) {
		this.primaryRole = primaryRole;
	}

	public boolean isRoleCompany() {
		return roleCompany;
	}

	public void setRoleCompany(boolean roleCompany) {
		this.roleCompany = roleCompany;
	}

	public boolean isRoleInvestor() {
		return roleInvestor;
	}

	public void setRoleInvestor(boolean roleInvestor) {
		this.roleInvestor = roleInvestor;
	}

	public int getTotalFundingUsd() {
		return totalFundingUsd;
	}

	public void setTotalFundingUsd(int totalFundingUsd) {
		this.totalFundingUsd = totalFundingUsd;
	}

	public int getNumberOfInvestments() {
		return numberOfInvestments;
	}

	public void setNumberOfInvestments(int numberOfInvestments) {
		this.numberOfInvestments = numberOfInvestments;
	}

	public String getHomepageUrl() {
		return homepageUrl;
	}

	public void setHomepageUrl(String homepageUrl) {
		this.homepageUrl = homepageUrl;
	}

	public boolean isClosed() {
		return isClosed;
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	public String getFoundedAt() {
		if(foundedAt==null) {
			return "";
		}
		return foundedAt;
	}

	public void setFoundedAt(String foundedAt) {
		this.foundedAt = foundedAt;
	}

}
