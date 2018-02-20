package com.leadercoach.rest.services.api;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg.ContainerPerClassTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FeedbackServiceUnitsTest extends ContainerPerClassTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(FeebackService.class);
	}
	
	@Test
	public void testCorrectInput(){
		Map<String, Object> feedback = new HashMap<String, Object>();
		feedback.put("assesment_Id", "AS9981");
		feedback.put("experience_Rating", 1);//can be >=1
		feedback.put("satisfaction_Rating", 1);//can be >=1
		feedback.put("what_Specially_went_well", "a1");
		feedback.put("what_could_have_been_better", "a2");
		feedback.put("how_will_improve_next_time", "a3");
		final Response response = target("/feedback/").request().post(Entity.json(feedback));
		Assert.assertEquals(response.getStatus(), 200);
	}
	
	@Test
	public void testInvalidExperienceRating(){
		Map<String, Object> feedback = new HashMap<String, Object>();
		feedback.put("assesment_Id", "AS9981");
		feedback.put("experience_Rating", -1);
		feedback.put("satisfaction_Rating", 1);
		feedback.put("what_Specially_went_well", "a1");
		feedback.put("what_could_have_been_better", "a2");
		feedback.put("how_will_improve_next_time", "a3");
		final Response response = target("/feedback/").request().post(Entity.json(feedback));
		Assert.assertEquals(response.getStatus(), 400);
	}
	
	@Test
	public void testNullExperienceRating(){
		Map<String, Object> feedback = new HashMap<String, Object>();
		feedback.put("assesment_Id", "AS9981");
		//feedback.put("experience_Rating", -1); //Null
		feedback.put("satisfaction_Rating", 1);
		feedback.put("what_Specially_went_well", "a1");
		feedback.put("what_could_have_been_better", "a2");
		feedback.put("how_will_improve_next_time", "a3");
		final Response response = target("/feedback/").request().post(Entity.json(feedback));
		Assert.assertEquals(response.getStatus(), 400);
	}
	
	@Test
	public void testInvalidSatisfactionRating(){
		Map<String, Object> feedback = new HashMap<String, Object>();
		feedback.put("assesment_Id", "AS9981");
		feedback.put("experience_Rating", 1);
		feedback.put("satisfaction_Rating", -1);
		feedback.put("what_Specially_went_well", "a1");
		feedback.put("what_could_have_been_better", "a2");
		feedback.put("how_will_improve_next_time", "a3");
		final Response response = target("/feedback/").request().post(Entity.json(feedback));
		Assert.assertEquals(response.getStatus(), 400);
	}
	
	@Test
	public void testNullSatisfactionRating(){
		Map<String, Object> feedback = new HashMap<String, Object>();
		feedback.put("assesment_Id", "AS9981");
		feedback.put("experience_Rating", 1);
		//feedback.put("satisfaction_Rating", 0); //Null
		feedback.put("what_Specially_went_well", "a1");
		feedback.put("what_could_have_been_better", "a2");
		feedback.put("how_will_improve_next_time", "a3");
		final Response response = target("/feedback/").request().post(Entity.json(feedback));
		Assert.assertEquals(response.getStatus(), 400);
	}
	
	@Test
	public void testNullAssesmentId(){
		Map<String, Object> feedback = new HashMap<String, Object>();
		//feedback.put("assesment_Id", "AS9981"); //Null
		feedback.put("experience_Rating", 1);
		feedback.put("satisfaction_Rating", 1);
		feedback.put("what_Specially_went_well", "a1");
		feedback.put("what_could_have_been_better", "a2");
		feedback.put("how_will_improve_next_time", "a3");
		final Response response = target("/feedback/").request().post(Entity.json(feedback));
		Assert.assertEquals(response.getStatus(), 400);
	}
	
	@Test
	public void testNullwhat_Specially_went_well(){
		Map<String, Object> feedback = new HashMap<String, Object>();
		feedback.put("assesment_Id", "AS9981"); 
		feedback.put("experience_Rating", 1);
		feedback.put("satisfaction_Rating", 1);
		//feedback.put("what_Specially_went_well", "a1");//Null
		feedback.put("what_could_have_been_better", "a2");
		feedback.put("how_will_improve_next_time", "a3");
		final Response response = target("/feedback/").request().post(Entity.json(feedback));
		Assert.assertEquals(response.getStatus(), 200);
	}
	
	@Test
	public void testNullwhat_could_have_been_better(){
		Map<String, Object> feedback = new HashMap<String, Object>();
		feedback.put("assesment_Id", "AS9981"); 
		feedback.put("experience_Rating", 1);
		feedback.put("satisfaction_Rating", 1);
		feedback.put("what_Specially_went_well", "a1");
		//feedback.put("what_could_have_been_better", "a2");//Null
		feedback.put("how_will_improve_next_time", "a3");
		final Response response = target("/feedback/").request().post(Entity.json(feedback));
		Assert.assertEquals(response.getStatus(), 200);
	}
	
	@Test
	public void testNull(){
		Map<String, Object> feedback = new HashMap<String, Object>();
		feedback.put("assesment_Id", "AS9981"); 
		feedback.put("experience_Rating", 1);
		feedback.put("satisfaction_Rating", 1);
		feedback.put("what_Specially_went_well", "a1");
		feedback.put("what_could_have_been_better", "a2");
		//feedback.put("how_will_improve_next_time", "a3"); //Null
		final Response response = target("/feedback/").request().post(Entity.json(feedback));
		Assert.assertEquals(response.getStatus(), 200);
	}
}
