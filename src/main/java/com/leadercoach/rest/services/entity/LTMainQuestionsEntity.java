package com.leadercoach.rest.services.entity;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

public class LTMainQuestionsEntity {

	private String stepId;
	private Long maxValue;
	private Long minValue;
	@Embedded
	private List<LTSubQuestionsEntity> questions;
	
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}
	
	public Long getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(Long maxValue) {
		this.maxValue = maxValue;
	}
	
	public Long getMinValue() {
		return minValue;
	}
	public void setMinValue(Long minValue) {
		this.minValue = minValue;
	}
	
	public List<LTSubQuestionsEntity> getQuestions() {
		return questions;
	}
	public void setQuestions(List<LTSubQuestionsEntity> questions) {
		this.questions = questions;
	}
	
	@Override
	public String toString() {
		return "LTMainQuestionsEntity [stepId=" + stepId + ", maxValue=" + maxValue + ", minValue=" + minValue
				+ ", questions=" + questions + "]";
	}
	
}
