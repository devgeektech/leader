package com.leadercoach.rest.services.entity;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.mongodb.morphia.annotations.Embedded;

import com.leadercoach.rest.services.constants.ApplicationConstants;

/***
 * Questions details that are comes under assessment step
 * @author CodaGlobal
 */
@Embedded
public class AssessmentQuestionEntity {
	
	@NotNull(message = ApplicationConstants.QUESTIONID_NOTNULL_ERRMSG)
	private String questionId;
	@NotNull(message = ApplicationConstants.TIMETAKEN_NOTNULL_ERRMSG)
	@DecimalMin(value = "0", message = ApplicationConstants.TIMETAKEN_MIN_ERRMSG)
	private Integer timeTaken;
	
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	public Integer getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(Integer timeTaken) {
		this.timeTaken = timeTaken;
	}
	
	@Override
	public String toString() {
		return "AssessmentQuestion [questionId=" + questionId + ", timeTaken=" + timeTaken + "]";
	}
	
}
