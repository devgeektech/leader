package com.leadercoach.rest.services.constants;

/**
 * ApplicationConstants is contains paths to all bundles , And including
 * constants
 * 
 * @author codaglobal
 *
 */
public class ApplicationConstants {

	// Bundle Names
	public static final String BUNDLE_BASE_PATH = "com.leadercoach.rest.services.war.properties.";
	public static final String ADD_FEEDBACK = BUNDLE_BASE_PATH + "AddFeedback";
	public static final String CONVERSATION_SERVICE_BUNDLE = "ConversationService";
	public static final String PERSONALITY_TYPE_SERVICE_BUNDLE = "PersonalityTypeProp";
	public static final String ASSESSMENT_SERVICE_BUNDLE = "AssessmentProp";
	public static final String AUTH0SERVICE_BUNDLE = "auth0";
	public static final String LC_TOKEN_BUNDLE = "LCToken";

	// Responce Messages
	public static final String REQUEST_SUCCESFULL = "Request Successful";
	public static final String REQUEST_FAILED = "Request Failed";
	public static final String NO_CONTENT = "No Content";
	public static final String FEEDBACK_RECEVIED = "Feedback Recevied";
	public static final String ASSESSMENT_ADDED = "Assesment added";

	// RandomId prefixes
	public static final String FEEDBACKID_PREFIX = "FI";
	public static final String ASSESSMENTID_PREFIX = "AS";

	// BeanValidations Messages
	// AssessmentEntity
	public static final String STEPS_NOTNULL_ERRMSG = "Steps shouldn't be null";
	public static final String USERID_NOTNULL_ERRMSG = "user Id shouldn't be null";
	public static final String CONVERSATIONID_NOTNULL_ERRMSG = "conversation Id shouldn't be null";
	public static final String PERSONALITYTYPEID_NOTNULL_ERRMSG = "personality Id shouldn't be null";
	public static final String DURATIONBYUSER_NOTNULL_ERRMSG = "Duration selected by user shouldn't be null";
	public static final String DURATIONBYUSER_MIN_ERRMSG = "Duration selected by user should greater than 600sec";
	public static final String DURATIONBYUSER_MAX_ERRMSG = "Duration selected by user should less than 28800sec";
	
	//AssessmentStepEntity
	public static final String STEPID_NOTNULL_ERRMSG = "step id shouldn't be null";
	public static final String ALLOTEDTIME_NOTNULL_ERRMSG = "Allotedtime shouldn't be null";
	public static final String ALLOTEDTIME_MIN_ERRMSG = "Alloted time should greater than 0sec";
	public static final String QUESTIONS_NOTNULL_ERRMSG = "Questions shouldn't be null";
	
	//AssessmentQuestionEntity
	public static final String QUESTIONID_NOTNULL_ERRMSG = "question id shouldn't be null";
	public static final String TIMETAKEN_NOTNULL_ERRMSG = "Time taken shouldn't be null";
	public static final String TIMETAKEN_MIN_ERRMSG = "Time taken should greater than 0sec";
	
	//FeedbackEntity
	public static final String ASSESMENTID_NOTNULL_ERRMSG = "assesmentId shouldn't be null";
	public static final String EXPERIENCERATING_NOTNULL_ERRMSG = "experienceRating shouldn't be null";
	public static final String EXPERIENCERATING_FORMAT_ERRMSG = "experienceRating Should be between 1 to 10";
	public static final String SATISFACTIONRATING_NOTNULL_ERRMSF = "satisfactionRating shouldn't be null";
	public static final String SATISFACTIONRATING_FORMAT_ERRMSG = "satisfactionRating Should be between 1 to 10";
	public static final String WHAT_SPECIALLY_WENT_WELL_SIZE_ERRMSG = "'what specially went well' field should be less than 100 characters";
	public static final String WHAT_COULD_BE_BETTER_SIZE_ERRMSG = "'what could have been better' field should be less than 100 characters";
	public static final String HOW_WILL_IMPROVE_NEXT_TIME_SIZE_ERRMSG = "'how will improve next time' field should be less than 100 characters";
	
	//UserProfileEntity
	public static final String FIRST_NAME_CANNOT_BE_EMPTY = "firstname cannot be empty";
	public static final String LAST_NAME_CANNOT_BE_EMPTY = "lastname cannot be empty";
	public static final String EMAIL_CANNOT_BE_EMPTY = "email cannot be empty";
	public static final String PHONENUMBER_CANNOT_BE_EMPTY = "phone number cannot be empty";
	public static final String COMAPNY_NAME_CANNOT_BE_EMPTY = "comapanyname cannot be empty";
	public static final String JOB_TITLE_CANNOT_BE_EMPTY = "job title cannot be empty";
	public static final String GENDER_CANNOT_BE_EMPTY = "gender cannot be empty";
	public static final String YEAR_OF_BIRTH_CANNOT_BE_EMPTY = "year of birth cannot be empty";
	public static final String LAST_UPDATE_CANNOT_BE_EMPTY = "lastupdate cannot be empty";
	

}
