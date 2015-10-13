package br.com.etyllica.network.crunchbase;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import br.com.etyllica.network.crunchbase.model.organization.Organization;
import br.com.etyllica.network.crunchbase.model.organization.OrganizationProperties;

public class CrunchBaseAPITest {

	private static final String FIXTURE_PATH = "test/fixtures/"; 

	@Test
	public void testConversionWithInvestors() throws IOException {

		String json = readFixture("waywire.json");

		Organization organizationData = CrunchBaseAPI.parseOrganization(json);
		OrganizationProperties organization = organizationData.getProperties();

		Assert.assertEquals("waywire", organization.getPermalink());
		Assert.assertEquals("#waywire", organization.getName());
		Assert.assertEquals("organizations/waywire", organization.getApiPath());
		Assert.assertEquals("organization/waywire", organization.getWebPath());
		Assert.assertEquals("company", organization.getPrimaryRole());
		Assert.assertEquals("2012-06-01", organization.getFoundedAt());
		
		Assert.assertEquals(6, organizationData.getRelationships().getInvestors().size());
	}

	protected String readFixture(String filename) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get(FIXTURE_PATH+filename)), StandardCharsets.UTF_8);
		return contents;
	}

}
