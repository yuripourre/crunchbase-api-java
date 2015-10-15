package br.com.etyllica.network.crunchbase;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.etyllica.network.crunchbase.model.funding.FundingRound;
import br.com.etyllica.network.crunchbase.model.funding.FundingRoundProperties;
import br.com.etyllica.network.crunchbase.model.investment.Investment;
import br.com.etyllica.network.crunchbase.model.investor.Investor;

public class FundingRoundParser {

	private FundingRound round;
	
	@Before
	public void setUp() throws IOException {
		String json = CrunchBaseAPITest.readFixture("aeromot-funding.json");
		round = CrunchBaseAPI.parseFundingRound(json);
	}
	
	@Test
	public void testFundingRoundPropertiesConversion() {
		
		FundingRoundProperties properties = round.getProperties();
		
		Assert.assertEquals(FundingRound.TYPE_VENTURE, properties.getFundingType());
		Assert.assertEquals(FundingRound.SERIES_A, properties.getSeries());
		Assert.assertEquals("1985-05-01", properties.getAnnouncedOn());
		Assert.assertEquals("1985-05-01", properties.getClosedOn());
		Assert.assertEquals(243000, properties.getMoneyRaised());
		Assert.assertEquals("USD", properties.getMoneyRaisedCorrencyCode());
		Assert.assertEquals(243000, properties.getMoneyRaisedUsd());
		Assert.assertEquals(0, properties.getTargetMoneyRaised());
		Assert.assertEquals("USD", properties.getTargetMoneyRaisedCorrencyCode());
        Assert.assertEquals(0, properties.getTargetMoneyRaisedUsd());
		Assert.assertEquals(1399108387, properties.getCreatedAt());
        Assert.assertEquals(1400600965, properties.getUpdatedAt());
	}
	
	@Test
	public void testFundingRoundInvestment() {
		List<Investment> investments = round.getRelationships().getInvestmentsPage().getList().getItems();
		Investment investment = investments.get(0);
		
		Assert.assertEquals(1, investments.size());
		Assert.assertNotNull(investment);
		
		Assert.assertEquals(1399108485,investment.getProperties().getCreatedAt());
		Assert.assertEquals(1443567265,investment.getProperties().getUpdatedAt());
		
		Assert.assertNotNull(investment.getRelashionships());
		
		//Testing investors
		List<Investor> investors = investment.getRelashionships().getInvestors().getItems();
		Investor investor = investors.get(0);
		
		Assert.assertEquals(Investor.TYPE_ORGANIZATION, investor.getType());
		
	}

}
