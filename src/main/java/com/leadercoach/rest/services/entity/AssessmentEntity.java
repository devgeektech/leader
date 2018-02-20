package com.leadercoach.rest.services.entity;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.mongodb.morphia.annotations.Embedded;

import com.leadercoach.rest.services.constants.ApplicationConstants;

/**
 * Assessment Entity to add assessment details
 * @author CodaGlobal
 */
public class AssessmentEntity {
	
	@NotNull(message = ApplicationConstants.USERID_NOTNULL_ERRMSG)
	private String userId;
	@NotNull(message = ApplicationConstants.CONVERSATIONID_NOTNULL_ERRMSG)
	private String conversationId;
	@NotNull(message = ApplicationConstants.PERSONALITYTYPEID_NOTNULL_ERRMSG)
	private String personalityTypeId;
	@NotNull(message = ApplicationConstants.DURATIONBYUSER_NOTNULL_ERRMSG)
	@DecimalMin(value = "600", message = ApplicationConstants.DURATIONBYUSER_MIN_ERRMSG)
	@DecimalMax(value = "28800", message = ApplicationConstants.DURATIONBYUSER_MAX_ERRMSG)
	private Integer durationByUser;
	@Valid
	@Embedded
	@NotNull(message = ApplicationConstants.STEPS_NOTNULL_ERRMSG)
	private List<AssessmentStepEntity> steps;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getConversationId() {
		return conversationId;
	}
	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}
	
	public String getPersonalityTypeId() {
		return personalityTypeId;
	}
	public void setPersonalityTypeId(String personalityTypeId) {
		this.personalityTypeId = personalityTypeId;
	}
	
	public Integer getDurationByUser() {
		return durationByUser;
	}
	public void setDurationByUser(Integer durationByUser) {
		this.durationByUser = durationByUser;
	}
	
	public List<AssessmentStepEntity> getSteps() {
		return steps;
	}
	public void setSteps(List<AssessmentStepEntity> steps) {
		this.steps = steps;
	}
	
	@Override
	public String toString() {
		return "Assessment [userId=" + userId + ", conversationId=" + conversationId
				+ ", personalityTypeId=" + personalityTypeId + ", durationByUser=" + durationByUser + ", steps=" + steps
				+ "]";
	}
}
