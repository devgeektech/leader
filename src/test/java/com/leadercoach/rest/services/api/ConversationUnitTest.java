package com.leadercoach.rest.services.api;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg.ContainerPerClassTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.leadercoach.rest.services.entity.GenericResponse;

/**
 * Test for Conversation service
 * @author CodaGlobal
 */
public class ConversationUnitTest extends ContainerPerClassTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(ConversationService.class);
	}
	
	/**
	 * Method to test get all conversation 
	 */
	@Test
	public void getAll() {
		final Response res = target("/conversations").request().get();
		Assert.assertEquals(res.getStatus(), 200);
	}
	@Test
	public void testgetParticularConversation(){
		final Response response = target("/conversations/C1001").request().get();
		Assert.assertEquals(response.getStatus(), 200);
	}
	@Test
	public void testINvalidConversation(){
		final Response response = target("/conversations/C10eef01").request().get();
		Assert.assertEquals(response.readEntity(GenericResponse.class).getResponseCode(), 204);
	}
}
