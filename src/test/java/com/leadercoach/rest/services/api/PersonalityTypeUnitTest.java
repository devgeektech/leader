package com.leadercoach.rest.services.api;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg.ContainerPerClassTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.leadercoach.rest.services.entity.GenericResponse;

/**
 * Test to check the service Personality
 * @author CodaGlobal
 */
public class PersonalityTypeUnitTest extends ContainerPerClassTest {
	
	@Override
	protected Application configure() {
		return new ResourceConfig(PersonalityTypeService.class);
	}
	
	/**
	 * Method to test get all personality type according to MBTI, LTI, etc.
	 */
	@Test
	public void getAllTest() {
		final Response res = target("/personality/MBTI").request().get();
		Assert.assertEquals(res.getStatus(), 200);
	}
	
	/**
	 * Method to test unknown type as path
	 */
	@Test
	public void getAllUnknownTypeTest() {
		final Response response = target("/personality/abc").request().get();
		Assert.assertEquals(response.readEntity(GenericResponse.class).getResponseCode(), 204);
	}
	
	/**
	 * Method to test get a personality type according to MBTI/ISTJ or etc.
	 */
	@Test
	public void getTest() {
		final Response res = target("/personality/MBTI/ISTJ").request().get();
		Assert.assertEquals(res.getStatus(), 200);
	}
	

	/**
	 * Method to test get a personality type according to MBTI/abc or etc.
	 */
	@Test
	public void getUnknownSubTypeTest() {
		final Response res = target("/personality/MBTI/abc").request().get();
		Assert.assertEquals(res.readEntity(GenericResponse.class).getResponseCode(), 204);
	}
}
