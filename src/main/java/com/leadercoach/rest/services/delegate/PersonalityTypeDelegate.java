package com.leadercoach.rest.services.delegate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leadercoach.rest.dao.constants.DAOConstants.DAO_CLASS_NAME;
import com.leadercoach.rest.dao.entity.Data;
import com.leadercoach.rest.dao.entity.PersonalityType;
import com.leadercoach.rest.dao.exception.LCDAOSystemException;
import com.leadercoach.rest.dao.factory.DAOFactory;
import com.leadercoach.rest.dao.impl.PersonalityTypeDAOImpl;
import com.leadercoach.rest.dao.inf.PersonalityTypeDAO;
import com.leadercoach.rest.services.constants.ApplicationConstants;
import com.leadercoach.rest.services.entity.DataEntity;
import com.leadercoach.rest.services.entity.PersonalityTypeEntity;
import com.leadercoach.rest.services.exception.LCRSExceptionDetails;
import com.leadercoach.rest.services.exception.LCRSSystemException;

/**
 * Delegate for Personality type
 * @author CodaGlobal
 */
public class PersonalityTypeDelegate {

	private static Logger LOGGER = LogManager.getLogger(PersonalityTypeDelegate.class);

	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ApplicationConstants.PERSONALITY_TYPE_SERVICE_BUNDLE);
	
	/**
	 * Method to get all personality types
	 * @return list of all personality types
	 * @throws LCRSSystemException
	 */
	public static List<PersonalityTypeEntity> getAll(String type) throws LCRSSystemException {
		LOGGER.entry();
		List<PersonalityTypeEntity> personalityTypeEntities = null;
		// getting dao from dao factory and calling the dao
		PersonalityTypeDAO personalityTypeDao = (PersonalityTypeDAO) DAOFactory.getDAO(DAO_CLASS_NAME.PERSONALITY_TYPE_DAO);
		List<PersonalityType> personalityTypes;
		try {
			personalityTypes = personalityTypeDao.getAll(type);
			personalityTypeEntities = convertPersonalityDaoToWar(personalityTypes);
			
		} catch (LCDAOSystemException e) {
			String errorMessage = MessageFormat.format(BUNDLE.getString("LCRSPTY4001E"), e.getMessage());
			LOGGER.error(errorMessage, e);
			LCRSExceptionDetails errorObject = new LCRSExceptionDetails("LCRSPTY4001E", errorMessage);
			Response httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorObject).build();
			LCRSSystemException systemException = new LCRSSystemException(errorMessage, e);
			systemException.setHttpResponse(httpResponse);
			throw systemException;
		}
		catch (Exception e) {
			String errorMessage = MessageFormat.format(BUNDLE.getString("LCRSPTY4002E"), e.getMessage());
			LOGGER.error(errorMessage, e);
			LCRSExceptionDetails errorObject = new LCRSExceptionDetails("LCRSPTY4002E", errorMessage);
			Response httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorObject).build();
			LCRSSystemException systemException = new LCRSSystemException(errorMessage, e);
			systemException.setHttpResponse(httpResponse);
			throw systemException;
		}

		LOGGER.exit(personalityTypeEntities);
		return personalityTypeEntities;
	}
	
	/**
	 * Method to convert Personality Dao to Personality entity
	 * @param personalityTypes
	 * @return list of personalityTypeEntities
	 */
	private static List<PersonalityTypeEntity> convertPersonalityDaoToWar(List<PersonalityType> personalityTypes) {
		
		PersonalityTypeEntity warEntity;
		List<PersonalityTypeEntity> personalityTypeEntities = new ArrayList<>();
		if(personalityTypes != null)
		for(PersonalityType daoEntity : personalityTypes) {
			warEntity = new PersonalityTypeEntity();
			warEntity.setPersonalityId(daoEntity.getPersonalityId());
			warEntity.setType(daoEntity.getType());
			warEntity.setSubType(daoEntity.getSubType());
			warEntity.setDescription(daoEntity.getDescription());
			warEntity.setData(convertDataDaoToWar(daoEntity.getData()));
			personalityTypeEntities.add(warEntity);
		}
		
		return personalityTypeEntities;
	}
	
	/**
	 * Method to convert all Data dao to data entity
	 * @param dataList
	 * @return list of all dataEntities
	 */
	private static List<DataEntity> convertDataDaoToWar(List<Data> dataList) {
		
		DataEntity warEntity;
		List<DataEntity> dataEntityList = new ArrayList<>();
		if(dataList != null)
		for(Data daoEntity : dataList) {
			warEntity = new DataEntity();
			warEntity.setIndicatorColor(daoEntity.getPersonalityIndicator().getColorCode());
			warEntity.setPercentage(daoEntity.getPercentage());
			dataEntityList.add(warEntity);
		}
		return dataEntityList;
	}
	
	/**
	 * Method to get a personality type
	 * @param type
	 * @param subType
	 * @return a personality type
	 * @throws LCRSSystemException
	 */
	public static PersonalityTypeEntity get(String type, String subType) throws LCRSSystemException {
		LOGGER.entry(type, subType);
		
		PersonalityType personalityType = null;
		PersonalityTypeEntity personalityTypeEntity = new PersonalityTypeEntity();
		PersonalityTypeDAO personalityTypeDAO = (PersonalityTypeDAOImpl) DAOFactory.getDAO(DAO_CLASS_NAME.PERSONALITY_TYPE_DAO);
		
		try{
			personalityType = personalityTypeDAO.get(type, subType);
			personalityTypeEntity.setPersonalityId(personalityType.getPersonalityId());
			personalityTypeEntity.setType(personalityType.getType());
			personalityTypeEntity.setSubType(personalityType.getSubType());
			personalityTypeEntity.setDescription(personalityType.getDescription());
			personalityTypeEntity.setData(convertDataDaoToWar(personalityType.getData()));
		}catch(LCDAOSystemException e) {
			String errorMessage = MessageFormat.format(BUNDLE.getString("LCRSPTY4001E"), e.getMessage());
			LOGGER.error(errorMessage, e);
			LCRSExceptionDetails errorObject = new LCRSExceptionDetails("LCRSPTY4001E", errorMessage);
			Response httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorObject).build();
			LCRSSystemException systemException = new LCRSSystemException(errorMessage, e);
			systemException.setHttpResponse(httpResponse);
			throw systemException;
		}
		catch (Exception e) {
			String errorMessage = MessageFormat.format(BUNDLE.getString("LCRSPTY4002E"), e.getMessage());
			LOGGER.error(errorMessage, e);
			LCRSExceptionDetails errorObject = new LCRSExceptionDetails("LCRSPTY4002E", errorMessage);
			Response httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorObject).build();
			LCRSSystemException systemException = new LCRSSystemException(errorMessage, e);
			systemException.setHttpResponse(httpResponse);
			throw systemException;
		}
		return personalityTypeEntity;
	}
	
}
