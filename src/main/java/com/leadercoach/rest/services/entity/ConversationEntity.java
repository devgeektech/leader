package com.leadercoach.rest.services.entity;

import java.util.Arrays;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

import com.leadercoach.rest.dao.constants.DAOConstants;

/**
 * Conversation Entity to get conversation details
 * @author CodaGlobal
 */
@Entity(DAOConstants.CONVERSATION_COLLECTION_NAME)
public class ConversationEntity {

	private String conversationId;
	private String name;
	private String description;
	private String[] introduction;
	private String note;
	@Embedded
	private List<StepsEntity> steps;

	public String getConversationId() {
		return conversationId;
	}

	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String[] getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String[] introduction) {
		this.introduction = introduction;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<StepsEntity> getSteps() {
		return steps;
	}

	public void setSteps(List<StepsEntity> steps) {
		this.steps = steps;
	}
	
	public ConversationEntity() {}

	public ConversationEntity(String conversationId, String name, String description, String[] introduction,
			String note,List<StepsEntity> steps) {
		super();
		this.conversationId = conversationId;
		this.name = name;
		this.description = description;
		this.introduction = introduction;
		this.note = note;
		this.steps = steps;
	}

	@Override
	public String toString() {
		return "ConversationEntity [conversationId=" + conversationId + ", name=" + name + ", description="
				+ description + ", introduction=" + Arrays.toString(introduction) + ", note=" + note + ", steps="
				+ steps + "]";
	}
	
}
