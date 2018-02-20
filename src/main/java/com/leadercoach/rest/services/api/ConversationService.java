package com.leadercoach.rest.services.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leadercoach.rest.services.constants.ApplicationConstants;
import com.leadercoach.rest.services.delegate.ConversationDelegate;
import com.leadercoach.rest.services.entity.ConversationEntity;
import com.leadercoach.rest.services.entity.ConversationGroupEntity;
import com.leadercoach.rest.services.entity.GenericResponse;
import com.leadercoach.rest.services.exception.LCRSSystemException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Service to get conversation details
 * 
 * @author CodaGlobal
 */
@Api("Conversation Service")
@Path("/leadercoach")
public class ConversationService {

	private static Logger LOGGER = LogManager.getLogger(ConversationService.class);

	/**
	 * This method gets the conversation types supported by the application
	 * 
	 * @return all conversation details
	 */
	@GET
	@Path("/conversations/{token}")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation("Get the conversation types supported by the application")
	public GenericResponse<List<ConversationGroupEntity>> getAll(@PathParam("token")String token) {
		LOGGER.entry();
		GenericResponse<List<ConversationGroupEntity>> result = null;
		List<ConversationGroupEntity> conversationGroupEntity;
		try {
			// calling the delagate to get the list of conversation types
			conversationGroupEntity = ConversationDelegate.getAll(token);
			result = new GenericResponse<>(200, true, ApplicationConstants.REQUEST_SUCCESFULL, conversationGroupEntity);
		} catch (LCRSSystemException e) {
			return new GenericResponse<>(500, false, ApplicationConstants.REQUEST_FAILED, null);
		}

		LOGGER.exit(result);
		return result;
	}

	/**
	 * Method to get particular conversation
	 * 
	 * @param conversationId
	 * @return conversation details
	 */
	@GET
	@Path("/conversation/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation("Get particular conversation")
	public GenericResponse<ConversationEntity> get(@PathParam("id") String conversationId) {
		LOGGER.entry(conversationId);
		ConversationEntity conversationWAREntity = null;
		GenericResponse<ConversationEntity> result = null;
		try {
			conversationWAREntity = ConversationDelegate.get(conversationId);
			result = new GenericResponse<>(200, true, ApplicationConstants.REQUEST_SUCCESFULL, conversationWAREntity);
		} catch (LCRSSystemException e) {
			return new GenericResponse<>(500, false, ApplicationConstants.REQUEST_FAILED, null);
		}
		LOGGER.exit(result);
		return (conversationWAREntity.getSteps().isEmpty())
				? new GenericResponse<>(204, false, ApplicationConstants.NO_CONTENT, conversationWAREntity)
				: new GenericResponse<>(200, true, ApplicationConstants.REQUEST_SUCCESFULL, conversationWAREntity);
	}
}
