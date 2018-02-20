package com.leadercoach.rest.services.delegate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leadercoach.rest.dao.constants.DAOConstants.DAO_CLASS_NAME;
import com.leadercoach.rest.dao.entity.Assessment;
import com.leadercoach.rest.dao.entity.AssessmentQuestion;
import com.leadercoach.rest.dao.entity.AssessmentStep;
import com.leadercoach.rest.dao.exception.LCDAOSystemException;
import com.leadercoach.rest.dao.factory.DAOFactory;
import com.leadercoach.rest.dao.inf.AssessmentDAO;
import com.leadercoach.rest.services.constants.ApplicationConstants;
import com.leadercoach.rest.services.entity.AssessmentEntity;
import com.leadercoach.rest.services.entity.AssessmentQuestionEntity;
import com.leadercoach.rest.services.entity.AssessmentStepEntity;
import com.leadercoach.rest.services.exception.LCRSExceptionDetails;
import com.leadercoach.rest.services.exception.LCRSSystemException;

/**
 * Assessment Delegate
 * 
 * @author CodaGlobal
 */
public class AssessmentDelegate {

	private static Logger LOGGER = LogManager.getLogger(AssessmentDelegate.class);

	private static final ResourceBundle BUNDLE = ResourceBundle
			.getBundle(ApplicationConstants.ASSESSMENT_SERVICE_BUNDLE);

	/**
	 * Method to add new assessment
	 * 
	 * @param assessmentEntity
	 * @return assessment id
	 * @throws LCRSSystemException
	 */
	public static String add(AssessmentEntity assessmentEntity) throws LCRSSystemException {
		LOGGER.entry(assessmentEntity);

		String assessmentId;
		Assessment assessment = convertAssessmentEntityToDao(assessmentEntity);
		AssessmentDAO assessmentDAO = (AssessmentDAO) DAOFactory.getDAO(DAO_CLASS_NAME.ASSESSMENT_DAO);

		try {
			assessmentId = assessmentDAO.add(assessment);
		} catch (LCDAOSystemException e) {
			String errorMessage = MessageFormat.format(BUNDLE.getString("LCRSASS4001E"), e.getMessage());
			LCRSExceptionDetails exceptionDetails = new LCRSExceptionDetails("LCRSASS4001E", errorMessage);
			LOGGER.error(errorMessage);
			Response httpResponse = Response.status(Status.INTERNAL_SERVER_ERROR).entity(exceptionDetails).build();
			LCRSSystemException lcrsSystemException = new LCRSSystemException(errorMessage, e);
			lcrsSystemException.setHttpResponse(httpResponse);
			throw lcrsSystemException;
		}

		LOGGER.exit(assessmentId);
		return assessmentId;
	}

	/**
	 * Method to conver assessment entity to dao
	 * 
	 * @param assessmentEntity
	 * @return assessment object
	 */
	public static Assessment convertAssessmentEntityToDao(AssessmentEntity assessmentEntity) {
		Assessment assessment = new Assessment();
		assessment.setAssessmentId(RandomIdGeneration.get(ApplicationConstants.ASSESSMENTID_PREFIX));
		assessment.setUserId(assessmentEntity.getUserId());
		assessment.setConversationId(assessmentEntity.getConversationId());
		assessment.setPersonalityTypeId(assessmentEntity.getPersonalityTypeId());
		assessment.setDurationByUser(assessmentEntity.getDurationByUser());
		assessment.setSteps(convertStepEntityToDao(assessmentEntity.getSteps()));
		return assessment;
	}

	/**
	 * Method to convert assessment steps entity to dao
	 * 
	 * @param assessmentStepEntities
	 * @return assessment steps
	 */
	private static List<AssessmentStep> convertStepEntityToDao(List<AssessmentStepEntity> assessmentStepEntities) {

		List<AssessmentStep> steps = new ArrayList<>();
		AssessmentStep assessmentStep = null;
		for (AssessmentStepEntity assessmentStepEntity : assessmentStepEntities) {
			assessmentStep = new AssessmentStep();
			assessmentStep.setStepId(assessmentStepEntity.getStepId());
			assessmentStep.setAllotedTime(assessmentStepEntity.getAllotedTime());
			assessmentStep.setQuestions(convertAssessmentQuestionToDao(assessmentStepEntity.getQuestions()));
			steps.add(assessmentStep);
		}
		return steps;
	}

	/**
	 * Method to convert assessment question entity to dao
	 * 
	 * @param assessmentQuestionEntities
	 * @return assessment questions
	 */
	private static List<AssessmentQuestion> convertAssessmentQuestionToDao(
			List<AssessmentQuestionEntity> assessmentQuestionEntities) {

		List<AssessmentQuestion> questions = new ArrayList<>();
		AssessmentQuestion assessmentQuestion = null;
		for (AssessmentQuestionEntity assessmentQuestionEntity : assessmentQuestionEntities) {
			assessmentQuestion = new AssessmentQuestion();
			assessmentQuestion.setQuestionId(assessmentQuestionEntity.getQuestionId());
			assessmentQuestion.setTimeTaken(assessmentQuestionEntity.getTimeTaken());
			questions.add(assessmentQuestion);
		}
		return questions;
	}
}
