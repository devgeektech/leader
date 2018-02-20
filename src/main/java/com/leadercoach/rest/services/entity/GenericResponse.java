package com.leadercoach.rest.services.entity;

/**
 * All response are converted into Generic response and sent it to the client
 * @author CodaGlobal
 * @param <T> T can be an Object or List<Object>
 */
public class GenericResponse<T> {
	
	private int responseCode;
	private Boolean isSuccess;
	private String responseMessage;
	private T data;
	
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responceCode) {
		this.responseCode = responceCode;
	}
	
	public Boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public GenericResponse() {}
	
	public GenericResponse(int responseCode, Boolean isSuccess, String responseMessage, T data) {
		super();
		this.responseCode = responseCode;
		this.isSuccess = isSuccess;
		this.responseMessage = responseMessage;
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "GenericResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage + ", isSuccess="
				+ isSuccess + ", data=" + data + "]";
	}

}
