package com.leadercoach.rest.services.exception;

import javax.ws.rs.core.Response;

public class LCRSBusinessException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5702680180706115139L;
	private String sourceErrorCode;
	private Response httpResponse;

	public LCRSBusinessException() {

	}

	public LCRSBusinessException(String message) {
		super(message);
	}

	public LCRSBusinessException(Throwable cause) {
		super(cause);
	}

	public LCRSBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public LCRSBusinessException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.setSourceErrorCode(errorCode);
	}

	public String getSourceErrorCode() {
		return sourceErrorCode;
	}

	public void setSourceErrorCode(String sourceErrorCode) {
		this.sourceErrorCode = sourceErrorCode;
	}

	public Response getHttpResponse() {
		return httpResponse;
	}

	public void setHttpResponse(Response httpResponse) {
		this.httpResponse = httpResponse;
	}

}
