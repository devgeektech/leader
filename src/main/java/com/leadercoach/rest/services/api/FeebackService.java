package com.leadercoach.rest.services.api;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leadercoach.rest.services.constants.ApplicationConstants;
import com.leadercoach.rest.services.delegate.FeedbackDelegate;
import com.leadercoach.rest.services.entity.FeedbackEntity;
import com.leadercoach.rest.services.entity.GenericResponse;
import com.leadercoach.rest.services.exception.LCRSSystemException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This service is used to push user feedback to database.
 * 
 * @author codaglobal
 */
@Api("Feedback Service")
@Path("/leadercoach/feedback/")
@Produces(MediaType.APPLICATION_JSON)
public class FeebackService {
	private static Logger LOGGER = LogManager.getLogger(FeebackService.class);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation("Add feedback")
	public GenericResponse<String> add(@Valid FeedbackEntity feedbackEntity) {
		LOGGER.entry();
		GenericResponse<String> result = null;
		String objectId = null;
		try {
			objectId = FeedbackDelegate.add(feedbackEntity);
			result = new GenericResponse<>(200, true, ApplicationConstants.FEEDBACK_RECEVIED, objectId);
		} catch (LCRSSystemException e) {
			return new GenericResponse<>(500, false, ApplicationConstants.REQUEST_FAILED, objectId);
		}

		LOGGER.exit();
		return result;
	}
}
