package com.leadercoach.rest.services.entity;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

import com.leadercoach.rest.dao.constants.DAOConstants;

/**
 * PersonalityType Entity Bean
 * @author CodaGlobal
 */
@Entity(DAOConstants.PERSONALITY_COLLECTION_NAME)
public class PersonalityTypeEntity {

	private String personalityId;
	private String type;
	private String subType;
	private String[] description;
	@Embedded
	private List<DataEntity> data;

	public String getPersonalityId() {
		return personalityId;
	}

	public void setPersonalityId(String personalityId) {
		this.personalityId = personalityId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}
	
	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}

	public List<DataEntity> getData() {
		return data;
	}

	public void setData(List<DataEntity> data) {
		this.data = data;
	}

	public PersonalityTypeEntity() {}
	
	public PersonalityTypeEntity(String personalityId, String type, String subType, String[] description, List<DataEntity> data) {
		super();
		this.personalityId = personalityId;
		this.type = type;
		this.subType = subType;
		this.description = description;
		this.data = data;
	}

}