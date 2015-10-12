package br.com.etyllica.network.crunchbase.model.investment;

import br.com.etyllica.network.crunchbase.model.base.TemporalProperty;

import com.google.gson.annotations.SerializedName;

public class InvestmentProperties extends TemporalProperty {
	
	@SerializedName("money_invested")
	long moneyInvested;
	
	@SerializedName("money_invested_currency_code")
	String moneyInvestedCurrencyCode = "";
	
	@SerializedName("money_invested_usd")
	long moneyInvestedUsd;

	public long getMoneyInvested() {
		return moneyInvested;
	}

	public void setMoneyInvested(long moneyInvested) {
		this.moneyInvested = moneyInvested;
	}

	public String getMoneyInvestedCurrencyCode() {
		return moneyInvestedCurrencyCode;
	}

	public void setMoneyInvestedCurrencyCode(String moneyInvestedCurrencyCode) {
		this.moneyInvestedCurrencyCode = moneyInvestedCurrencyCode;
	}

	public long getMoneyInvestedUsd() {
		return moneyInvestedUsd;
	}

	public void setMoneyInvestedUsd(long moneyInvestedUsd) {
		this.moneyInvestedUsd = moneyInvestedUsd;
	}
		
}
