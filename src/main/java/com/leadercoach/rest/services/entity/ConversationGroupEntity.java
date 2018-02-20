package com.leadercoach.rest.services.entity;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

public class ConversationGroupEntity {

	private String groupId;
	private String header;
	private boolean isBought;
	@Embedded
	private List<ConversationEntity> conversations;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	
	public List<ConversationEntity> getConversations() {
		return conversations;
	}
	public void setConversations(List<ConversationEntity> conversations) {
		this.conversations = conversations;
	}
	
	public boolean isBought() {
		return isBought;
	}
	public void setBought(boolean isBought) {
		this.isBought = isBought;
	}
	
	@Override
	public String toString() {
		return "ConversationGroupEntity [groupId=" + groupId + ", header=" + header + ", isBought=" + isBought
				+ ", conversations=" + conversations + "]";
	}
	
}
