package com.leadercoach.rest.services.exception;

import javax.ws.rs.core.Response;

public class LCRSSystemException extends Exception {

	private static final long serialVersionUID = -6083562499039805291L;
	private Response httpResponse;

	public LCRSSystemException() {

	}

	public LCRSSystemException(String message) {
		super(message);
	}

	public LCRSSystemException(Throwable cause) {
		super(cause);
	}

	public LCRSSystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public Response getHttpResponse() {
		return httpResponse;
	}

	public void setHttpResponse(Response httpResponse) {
		this.httpResponse = httpResponse;
	}

}
