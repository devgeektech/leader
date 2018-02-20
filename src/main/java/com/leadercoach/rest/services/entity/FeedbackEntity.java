package com.leadercoach.rest.services.entity;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.mongodb.morphia.annotations.Entity;

import com.leadercoach.rest.dao.constants.DAOConstants;
import com.leadercoach.rest.services.constants.ApplicationConstants;

/**
 * To add feedback
 * @author CodaGlobal
 */
@Entity(DAOConstants.FEEDBACK_COLLECTION_NAME)
public class FeedbackEntity {

	@NotNull(message = ApplicationConstants.ASSESMENTID_NOTNULL_ERRMSG)
	private String assesment_Id;

	@NotNull(message = ApplicationConstants.EXPERIENCERATING_NOTNULL_ERRMSG)
	@DecimalMin(value = "1", message = ApplicationConstants.EXPERIENCERATING_FORMAT_ERRMSG)
	@DecimalMax(value = "10", message = ApplicationConstants.EXPERIENCERATING_FORMAT_ERRMSG)
	private Integer experience_Rating;

	@NotNull(message = ApplicationConstants.SATISFACTIONRATING_NOTNULL_ERRMSF)
	@DecimalMin(value = "1", message = ApplicationConstants.SATISFACTIONRATING_FORMAT_ERRMSG)
	@DecimalMax(value = "10", message = ApplicationConstants.SATISFACTIONRATING_FORMAT_ERRMSG)
	private Integer satisfaction_Rating;

	@Size(max = 100, message = ApplicationConstants.WHAT_SPECIALLY_WENT_WELL_SIZE_ERRMSG)
	private String what_Specially_went_well;

	@Size(max = 100, message = ApplicationConstants.WHAT_COULD_BE_BETTER_SIZE_ERRMSG)
	private String what_could_have_been_better;

	@Size(max = 100, message = ApplicationConstants.HOW_WILL_IMPROVE_NEXT_TIME_SIZE_ERRMSG)
	private String how_will_improve_next_time;

	public String getAssesment_Id() {
		return assesment_Id;
	}

	public void setAssesment_Id(String assesment_Id) {
		this.assesment_Id = assesment_Id;
	}

	public int getExperience_Rating() {
		return experience_Rating;
	}

	public void setExperience_Rating(int experience_Rating) {
		this.experience_Rating = experience_Rating;
	}

	public int getSatisfaction_Rating() {
		return satisfaction_Rating;
	}

	public void setSatisfaction_Rating(int satisfaction_Rating) {
		this.satisfaction_Rating = satisfaction_Rating;
	}

	public String getWhat_Specially_went_well() {
		return what_Specially_went_well;
	}

	public void setWhat_Specially_went_well(String what_Specially_went_well) {
		this.what_Specially_went_well = what_Specially_went_well;
	}

	public String getWhat_could_have_been_better() {
		return what_could_have_been_better;
	}

	public void setWhat_could_have_been_better(String what_could_have_been_better) {
		this.what_could_have_been_better = what_could_have_been_better;
	}

	public String getHow_will_improve_next_time() {
		return how_will_improve_next_time;
	}

	public void setHow_will_improve_next_time(String how_will_improve_next_time) {
		this.how_will_improve_next_time = how_will_improve_next_time;
	}

	public FeedbackEntity() {

	}

	public FeedbackEntity(String assesment_Id, int experience_Rating, int satisfaction_Rating,
			String what_Specially_went_well, String what_could_have_been_better, String how_will_improve_next_time) {
		super();
		this.assesment_Id = assesment_Id;
		this.experience_Rating = experience_Rating;
		this.satisfaction_Rating = satisfaction_Rating;
		this.what_Specially_went_well = what_Specially_went_well;
		this.what_could_have_been_better = what_could_have_been_better;
		this.how_will_improve_next_time = how_will_improve_next_time;
	}
}
