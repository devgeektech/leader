package com.leadercoach.rest.services.exception;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.leadercoach.rest.services.entity.GenericResponse;

/**
 * This class is used to get output-format in json format for bean-validation
 * errors.
 * 
 * @author codaglobal
 *
 */
@Provider
public class LCRSConstraintViolationException implements ExceptionMapper<ConstraintViolationException> {

	/**
	 * Method to response an error
	 * @return response
	 */
	@Override
	public Response toResponse(ConstraintViolationException exception) {
		String errorMessage = null;
		StringBuilder errorMessages = new StringBuilder();
		int i = 0;
		GenericResponse<String> result = null;
		Set<ConstraintViolation<?>> constraintViolationImpls = exception.getConstraintViolations();
		for (ConstraintViolation<?> c : constraintViolationImpls) {
			i++;
			errorMessages.append(c.getMessage() + ", ");
			if (i == constraintViolationImpls.size())
				errorMessage = errorMessages.substring(0, errorMessages.length() - 2);
		}
		result = new GenericResponse<>(400, false, errorMessage, null);
		return Response.status(400).entity(result).type(MediaType.APPLICATION_JSON).build();
	}

}
