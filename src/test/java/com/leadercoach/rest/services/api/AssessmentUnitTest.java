package com.leadercoach.rest.services.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg.ContainerPerClassTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.leadercoach.rest.services.entity.GenericResponse;

/**
 * Test for Assessment Service
 * @author CodaGlobal
 */
public class AssessmentUnitTest extends ContainerPerClassTest {
	
	@Override
	protected Application configure() {
		return new ResourceConfig(AssessmentService.class);
	}
	
	/**
	 * Method to test add assessment service
	 */
	@Test
	public void addTest() {
		
		Map<String,Object> question = new HashMap<String,Object>();
		question.put("questionId", "123");
		question.put("timeTaken", "123");
		List<Map<String,Object>> questions = new ArrayList<Map<String,Object>>();
		questions.add(question);
		
		Map<String,Object> step = new HashMap<String,Object>();
		step.put("stepId", "123");
		step.put("allotedTime", "10");
		step.put("questions", questions);
		List<Map<String,Object>> steps = new ArrayList<Map<String,Object>>();
		steps.add(step);
		
		Map<String, Object> assessment = new HashMap<String, Object>();
		assessment.put("userId", "123");
		assessment.put("conversationId", "123");
		assessment.put("personalityTypeId", "123");
		assessment.put("durationByUser", "600");
		assessment.put("steps", steps);
		
		final Response response = target("/assessment").request().post(Entity.json(assessment));
		Assert.assertEquals(response.readEntity(GenericResponse.class).getResponseCode(), 200);		
	}
	
	/**
	 * Method to test add assessment service when questions is null
	 */
	@Test
	public void addQuestionsNullTest() {
		
		Map<String,Object> step = new HashMap<String,Object>();
		step.put("stepId", "123");
		step.put("allotedTime", "10");
		step.put("questions", null);
		List<Map<String,Object>> steps = new ArrayList<Map<String,Object>>();
		steps.add(step);
		
		Map<String, Object> assessment = new HashMap<String, Object>();
		assessment.put("userId", "123");
		assessment.put("conversationId", "123");
		assessment.put("personalityTypeId", "123");
		assessment.put("durationByUser", "600");
		assessment.put("steps", steps);
		
		final Response response = target("/assessment").request().post(Entity.json(assessment));
		System.out.println(response.readEntity(String.class));
		Assert.assertEquals(response.getStatus(), 400);		
	}
	
	/**
	 * Method to test assessment service when steps are null
	 */
	@Test
	public void addStepsNullTest() {
		
		Map<String, Object> assessment = new HashMap<String, Object>();
		assessment.put("userId", "123");
		assessment.put("conversationId", "123");
		assessment.put("personalityTypeId", "123");
		assessment.put("durationByUser", "600");
		assessment.put("steps", null);
		
		final Response response = target("/assessment").request().post(Entity.json(assessment));
		System.out.println(response.readEntity(String.class));
		Assert.assertEquals(response.getStatus(), 400);		
	}
	
}
