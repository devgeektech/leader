package com.leadercoach.rest.services.entity;

import java.util.List;

public class LC_TokenEntity {

	private String userId;
	private String token;
	private boolean isValidate;
	private List<String> subscriptionIds;
	private boolean enabled;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public boolean isValidate() {
		return isValidate;
	}
	public void setValidate(boolean isValidate) {
		this.isValidate = isValidate;
	}
	
	public List<String> getSubscriptionIds() {
		return subscriptionIds;
	}
	public void setSubscriptionIds(List<String> subscriptionIds) {
		this.subscriptionIds = subscriptionIds;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return "LC_Token [userId=" + userId + ", token=" + token + ", isValidate="
				+ isValidate + ", subscriptionIds=" + subscriptionIds + ", enabled=" + enabled + "]";
	}
	
}
