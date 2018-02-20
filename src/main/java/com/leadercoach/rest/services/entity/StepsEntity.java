package com.leadercoach.rest.services.entity;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

/**
 * To get all conversation steps
 * @author CodaGlobal
 */
@Embedded
public class StepsEntity {

	private String stepId;
	private String name;
	private String indicatorColor;
	private int timePercentage;
	@Embedded
	private List<QuestionsEntity> questions;

	public String getStepId() {
		return stepId;
	}

	public void setStepId(String stepId) {
		this.stepId = stepId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndicatorColor() {
		return indicatorColor;
	}

	public void setIndicatorColor(String indicatorColor) {
		this.indicatorColor = indicatorColor;
	}

	public int getTimePercentage() {
		return timePercentage;
	}

	public void setTimePercentage(int timePercentage) {
		this.timePercentage = timePercentage;
	}

	public List<QuestionsEntity> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionsEntity> questionsDAOEntity) {
		this.questions = questionsDAOEntity;
	}

	public StepsEntity() {}
	
	public StepsEntity(String stepId, String name, String indicatorColor, int timePercentage,
			List<QuestionsEntity> questions) {
		super();
		this.stepId = stepId;
		this.name = name;
		this.indicatorColor = indicatorColor;
		this.timePercentage = timePercentage;
		this.questions = questions;
	}

}
