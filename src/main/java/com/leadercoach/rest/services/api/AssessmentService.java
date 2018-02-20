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
import com.leadercoach.rest.services.delegate.AssessmentDelegate;
import com.leadercoach.rest.services.entity.AssessmentEntity;
import com.leadercoach.rest.services.entity.GenericResponse;
import com.leadercoach.rest.services.exception.LCRSSystemException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Service to Add assessment details
 * 
 * @author CodaGlobal
 */
@Api("Assessment service")
@Path("/leadercoach/assessment")
public class AssessmentService {

	private static Logger LOGGER = LogManager.getLogger(AssessmentService.class);

	/**
	 * Method to add new assessment
	 * 
	 * @param assessment
	 * @return response or exception
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Add new assessment")
	public GenericResponse<String> add(@Valid AssessmentEntity assessment) {
		LOGGER.entry(assessment);

		String assessmentId;
		GenericResponse<String> genericResponse = null;

		try {
			assessmentId = AssessmentDelegate.add(assessment);
			genericResponse = new GenericResponse<>(200, true, ApplicationConstants.ASSESSMENT_ADDED, assessmentId);
		} catch (LCRSSystemException e) {
			return new GenericResponse<>(500, false, ApplicationConstants.REQUEST_FAILED, null);
		}

		LOGGER.exit(genericResponse);
		return genericResponse;
	}
}
