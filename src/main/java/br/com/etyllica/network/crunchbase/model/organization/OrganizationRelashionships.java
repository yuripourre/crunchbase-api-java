package br.com.etyllica.network.crunchbase.model.organization;

import java.util.List;

import br.com.etyllica.network.crunchbase.model.address.Address;
import br.com.etyllica.network.crunchbase.model.address.AddressPageData;
import br.com.etyllica.network.crunchbase.model.aquisition.Aquisition;
import br.com.etyllica.network.crunchbase.model.aquisition.AquisitionPageData;
import br.com.etyllica.network.crunchbase.model.category.Category;
import br.com.etyllica.network.crunchbase.model.category.CategoryPageData;
import br.com.etyllica.network.crunchbase.model.funding.FundingRound;
import br.com.etyllica.network.crunchbase.model.funding.FundingRoundPageData;
import br.com.etyllica.network.crunchbase.model.investment.Investment;
import br.com.etyllica.network.crunchbase.model.investment.InvestmentPageData;
import br.com.etyllica.network.crunchbase.model.investor.Investor;
import br.com.etyllica.network.crunchbase.model.investor.InvestorPageData;

import com.google.gson.annotations.SerializedName;

public class OrganizationRelashionships {
	
	@SerializedName("aquisitions")
    AquisitionPageData aquisitionsPage;
	
	@SerializedName("aquired_by")
    AquisitionPageData aquiredByPage;
	
	@SerializedName("categories")
    CategoryPageData categoriesPage;
	
	@SerializedName("funding_rounds")
    FundingRoundPageData fundingRoundsPage;
	
	@SerializedName("investments")
    InvestmentPageData investmentsPage;
	
	@SerializedName("investors")
	InvestorPageData investorsPage;

	@SerializedName("headquarters")
	AddressPageData headquartersPage;
	
	@SerializedName("offices")
    AddressPageData officesPage;
	
	public AquisitionPageData getAquisitionsPage() {
		return aquisitionsPage;
	}

	public void setAquisitionsPage(AquisitionPageData aquisitionsPage) {
		this.aquisitionsPage = aquisitionsPage;
	}

	public AquisitionPageData getAquiredByPage() {
		return aquiredByPage;
	}

	public void setAquiredByPage(AquisitionPageData aquiredByPage) {
		this.aquiredByPage = aquiredByPage;
	}

	public CategoryPageData getCategoriesPage() {
		return categoriesPage;
	}

	public void setCategoriesPage(CategoryPageData categoriesPage) {
		this.categoriesPage = categoriesPage;
	}

	public FundingRoundPageData getFundingRoundsPage() {
		return fundingRoundsPage;
	}

	public void setFundingRoundsPage(FundingRoundPageData fundingRoundsPage) {
		this.fundingRoundsPage = fundingRoundsPage;
	}
		
	public InvestmentPageData getInvestmentsPage() {
		return investmentsPage;
	}

	public void setInvestmentsPage(InvestmentPageData investmentsPage) {
		this.investmentsPage = investmentsPage;
	}
		
	public AddressPageData getOfficesPage() {
		return officesPage;
	}

	public void setOfficesPage(AddressPageData officesPage) {
		this.officesPage = officesPage;
	}

	public AddressPageData getHeadquartersPage() {
		return headquartersPage;
	}

	public void setHeadquartersPage(AddressPageData headquartersPage) {
		this.headquartersPage = headquartersPage;
	}
	
	public InvestorPageData getInvestorsPage() {
		return investorsPage;
	}

	public void setInvestorsPage(InvestorPageData investorsPage) {
		this.investorsPage = investorsPage;
	}

	//Helper Methods
	public List<Aquisition> getAquisitions() {
		return aquisitionsPage.getList().getItems();
	}
	
	public List<Category> getCategories() {
		return categoriesPage.getList().getItems();
	}
	
	public List<FundingRound> getFundingRounds() {
		return fundingRoundsPage.getList().getItems();
	}
	
	public List<Investment> getInvestments() {
		return investmentsPage.getList().getItems();
	}
	
	public List<Investor> getInvestors() {
		return investorsPage.getList().getItems();
	}
	
	public List<Address> getOffices() {
		return officesPage.getList().getItems();
	}
	
	public List<Address> getHeadquarters() {
		return headquartersPage.getList().getItems();
	}
	
}
