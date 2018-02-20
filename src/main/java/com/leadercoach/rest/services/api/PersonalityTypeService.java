package com.leadercoach.rest.services.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leadercoach.rest.services.constants.ApplicationConstants;
import com.leadercoach.rest.services.delegate.PersonalityTypeDelegate;
import com.leadercoach.rest.services.entity.GenericResponse;
import com.leadercoach.rest.services.entity.PersonalityTypeEntity;
import com.leadercoach.rest.services.exception.LCRSSystemException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Service for request and response to personality types
 * 
 * @author CodaGlobal
 */
@Api("Personality type service")
@Path("/leadercoach/personality/{type}")
public class PersonalityTypeService {

	private static Logger LOGGER = LogManager.getLogger(PersonalityTypeService.class);

	/**
	 * This method gets the personality types
	 * 
	 * @throws WebApplicationException
	 * @return list of all personality types
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation("Get all Personality entity types")
	public GenericResponse<List<PersonalityTypeEntity>> getAll(@PathParam("type") String type) {
		LOGGER.entry(type);

		List<PersonalityTypeEntity> personalityTypes;

		try {
			// calling the delagate to get the list of personality types
			personalityTypes = PersonalityTypeDelegate.getAll(type);
		} catch (LCRSSystemException e) {
			return new GenericResponse<>(500, false, ApplicationConstants.REQUEST_FAILED, null);
		}

		LOGGER.exit();
		return (personalityTypes.isEmpty())
				? new GenericResponse<>(204, false, ApplicationConstants.NO_CONTENT, personalityTypes)
				: new GenericResponse<>(200, true, ApplicationConstants.REQUEST_SUCCESFULL, personalityTypes);
	}

	@GET
	@Path("/{subType}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation("Get a personality type entity")
	public GenericResponse<PersonalityTypeEntity> get(@PathParam("type") String type,
			@PathParam("subType") String subType) {
		LOGGER.entry(type, subType);

		PersonalityTypeEntity personalityTypeEntity;

		try {
			personalityTypeEntity = PersonalityTypeDelegate.get(type, subType);
		} catch (LCRSSystemException e) {
			return new GenericResponse<>(500, false, ApplicationConstants.REQUEST_FAILED, null);
		}
		return (personalityTypeEntity.getData().isEmpty())
				? new GenericResponse<>(204, false, ApplicationConstants.NO_CONTENT, personalityTypeEntity)
				: new GenericResponse<>(200, true, ApplicationConstants.REQUEST_SUCCESFULL, personalityTypeEntity);
	}
}
