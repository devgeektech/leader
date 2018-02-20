package com.leadercoach.rest.services.api;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leadercoach.rest.services.constants.ApplicationConstants;
import com.leadercoach.rest.services.delegate.LC_TokenDelegate;
import com.leadercoach.rest.services.entity.GenericResponse;
import com.leadercoach.rest.services.exception.LCRSSystemException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Token Service")
@Path("/leadercoach/token")
public class TokenService {

	private static Logger LOGGER = LogManager.getLogger(TokenService.class);
	
	@PUT
	@Path("/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation("Validate Token")
	public GenericResponse<Boolean> validateToken(@PathParam("token")String token) {
		LOGGER.entry(token);
		GenericResponse<Boolean> response;
		
		try {
			response = new GenericResponse<Boolean>( 200, true, ApplicationConstants.REQUEST_SUCCESFULL, LC_TokenDelegate.validateToken(token));
		}catch (LCRSSystemException e) {
			return new GenericResponse<>(500, false, ApplicationConstants.REQUEST_FAILED, null);
		}
		
		LOGGER.exit(response);
		return response;
	}
}
