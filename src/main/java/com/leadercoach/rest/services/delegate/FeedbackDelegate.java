package com.leadercoach.rest.services.delegate;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leadercoach.rest.dao.constants.DAOConstants.DAO_CLASS_NAME;
import com.leadercoach.rest.dao.entity.Feedback;
import com.leadercoach.rest.dao.exception.LCDAOSystemException;
import com.leadercoach.rest.dao.factory.DAOFactory;
import com.leadercoach.rest.dao.impl.FeedbackDAOimpl;
import com.leadercoach.rest.services.constants.ApplicationConstants;
import com.leadercoach.rest.services.entity.FeedbackEntity;
import com.leadercoach.rest.services.exception.LCRSExceptionDetails;
import com.leadercoach.rest.services.exception.LCRSSystemException;

/**
 * This delegate class will map beans and do interaction on AddFeedbackDAOimpl
 * 
 * @author codaglobal
 *
 */
public class FeedbackDelegate {
	private static Logger LOGGER = LogManager.getLogger(FeedbackDelegate.class);
	private static ResourceBundle BUNDLE = ResourceBundle.getBundle(ApplicationConstants.ADD_FEEDBACK);

	/**
	 * Method to add feedback
	 * @param feedbackEntity
	 * @return Id of the feedback
	 * @throws LCRSSystemException
	 */
	public static String add(FeedbackEntity feedbackEntity) throws LCRSSystemException {
		LOGGER.entry();
		String objectId = null;
		Feedback feedback = new Feedback();
		feedback.setFeedbackID(RandomIdGeneration.get(ApplicationConstants.FEEDBACKID_PREFIX));
		feedback.setAssesment_Id(feedbackEntity.getAssesment_Id());
		feedback.setExperience_Rating(feedbackEntity.getExperience_Rating());
		feedback.setSatisfaction_Rating(feedbackEntity.getSatisfaction_Rating());
		feedback.setWhat_Specially_went_well(feedbackEntity.getWhat_Specially_went_well());
		feedback.setWhat_could_have_been_better(feedbackEntity.getWhat_could_have_been_better());
		feedback.setHow_will_improve_next_time(feedbackEntity.getHow_will_improve_next_time());
		FeedbackDAOimpl addFeedbackDAOimpl = (FeedbackDAOimpl) DAOFactory.getDAO(DAO_CLASS_NAME.ADD_FEEDBACK_DAO);
		try {
			objectId = addFeedbackDAOimpl.add(feedback);
		} catch (LCDAOSystemException e) {
			String errorMessage = MessageFormat.format(BUNDLE.getString("LCRRSAF3001E"), e.getMessage());
			LOGGER.error(errorMessage, e);
			LCRSExceptionDetails errorObject = new LCRSExceptionDetails("LCRRSAF3001E", errorMessage);
			Response httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorObject).build();
			LCRSSystemException systemException = new LCRSSystemException(errorMessage, e);
			systemException.setHttpResponse(httpResponse);
			throw systemException;
		}
		catch (Exception e) {
			String errorMessage = MessageFormat.format(BUNDLE.getString("LCRRSAF3002E"), e.getMessage());
			LOGGER.error(errorMessage, e);
			LCRSExceptionDetails errorObject = new LCRSExceptionDetails("LCRRSAF3002E", errorMessage);
			Response httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorObject).build();
			LCRSSystemException systemException = new LCRSSystemException(errorMessage, e);
			systemException.setHttpResponse(httpResponse);
			throw systemException;
		}
		LOGGER.exit();
		return objectId;
	}
}
