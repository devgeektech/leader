package com.leadercoach.rest.services.entity;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.mongodb.morphia.annotations.Embedded;

import com.leadercoach.rest.services.constants.ApplicationConstants;

/**
 * Steps that are comes under assessment
 * @author CodaGlobal
 */
@Embedded
public class AssessmentStepEntity {

	@NotNull(message = ApplicationConstants.STEPID_NOTNULL_ERRMSG)
	private String stepId;
	@NotNull(message = ApplicationConstants.ALLOTEDTIME_NOTNULL_ERRMSG)
	@DecimalMin(value = "0", message = ApplicationConstants.ALLOTEDTIME_MIN_ERRMSG)
	private Integer allotedTime;
	@Valid
	@Embedded
	@NotNull(message = ApplicationConstants.QUESTIONS_NOTNULL_ERRMSG)
	private List<AssessmentQuestionEntity> questions;
	
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}
	
	public Integer getAllotedTime() {
		return allotedTime;
	}
	public void setAllotedTime(Integer allotedTime) {
		this.allotedTime = allotedTime;
	}
	
	public List<AssessmentQuestionEntity> getQuestions() {
		return questions;
	}
	public void setQuestions(List<AssessmentQuestionEntity> questions) {
		this.questions = questions;
	}
	
	@Override
	public String toString() {
		return "AssessmentStep [stepId=" + stepId + ", allotedTime=" + allotedTime + ", questions=" + questions + "]";
	}
	
}
