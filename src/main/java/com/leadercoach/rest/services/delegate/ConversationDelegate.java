package com.leadercoach.rest.services.delegate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leadercoach.rest.dao.constants.DAOConstants.DAO_CLASS_NAME;
import com.leadercoach.rest.dao.entity.BaseConversation;
import com.leadercoach.rest.dao.entity.Conversation;
import com.leadercoach.rest.dao.entity.LC_Token;
import com.leadercoach.rest.dao.entity.Questions;
import com.leadercoach.rest.dao.entity.Steps;
import com.leadercoach.rest.dao.exception.LCDAOSystemException;
import com.leadercoach.rest.dao.factory.DAOFactory;
import com.leadercoach.rest.dao.impl.ConversationDAOImpl;
import com.leadercoach.rest.dao.inf.ConversationDAO;
import com.leadercoach.rest.dao.inf.LC_TokenDao;
import com.leadercoach.rest.services.constants.ApplicationConstants;
import com.leadercoach.rest.services.entity.ConversationEntity;
import com.leadercoach.rest.services.entity.ConversationGroupEntity;
import com.leadercoach.rest.services.entity.QuestionsEntity;
import com.leadercoach.rest.services.entity.StepsEntity;
import com.leadercoach.rest.services.exception.LCRSExceptionDetails;
import com.leadercoach.rest.services.exception.LCRSSystemException;
import com.leadertype.rest.dao.constants.DaoConstants.DAO_CLASSES;
import com.leadertype.rest.dao.entity.SPackages;
import com.leadertype.rest.dao.factory.DaoFactory;
import com.leadertype.rest.dao.inf.SPackagesDao;

/**
 * Delegate for Conversation
 * @author CodaGlobal
 */
public class ConversationDelegate {

	private static Logger LOGGER = LogManager.getLogger(ConversationDelegate.class);

	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ApplicationConstants.CONVERSATION_SERVICE_BUNDLE);
	
	/**
	 * Method to get all conversations
	 * @return conversation entity
	 * @throws LCRSSystemException
	 */
	public static List<ConversationGroupEntity> getAll(String token) throws LCRSSystemException {
		LOGGER.entry(token);
		// getting dao from dao factory and calling the dao
		ConversationDAO conversationDao = (ConversationDAO) DAOFactory.getDAO(DAO_CLASS_NAME.CONVERSATION_DAO);
		List<BaseConversation> conversations;
		List<ConversationGroupEntity> conversationGroupList;
		try {
			conversations = conversationDao.getAllTypesOfConversation();
			conversationGroupList = groupConversation(conversations, token);
		} catch (LCDAOSystemException e) {
			String errorMessage = MessageFormat.format(BUNDLE.getString("LCRSCON4001E"), e.getMessage());
			LOGGER.error(errorMessage, e);
			LCRSExceptionDetails errorObject = new LCRSExceptionDetails("LCRSCON4001E", errorMessage);
			Response httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorObject).build();
			LCRSSystemException systemException = new LCRSSystemException(errorMessage, e);
			systemException.setHttpResponse(httpResponse);
			throw systemException;
		}
		catch (Exception e) {
			String errorMessage = MessageFormat.format(BUNDLE.getString("LCRSCON4001E"), e.getMessage());
			LOGGER.error(errorMessage, e);
			LCRSExceptionDetails errorObject = new LCRSExceptionDetails("LCRSCON4001E", errorMessage);
			Response httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorObject).build();
			LCRSSystemException systemException = new LCRSSystemException(errorMessage, e);
			systemException.setHttpResponse(httpResponse);
			throw systemException;
		}
		LOGGER.exit(conversationGroupList);
		return conversationGroupList;
	}
	
	/**
	 * Method to get a conversation
	 * @param conversationId
	 * @return a conversation
	 */
	public static ConversationEntity get(String conversationId) throws LCRSSystemException {
		LOGGER.entry(conversationId);
		ConversationEntity conversationEntity = null;
		ConversationDAO conversationDaoImpl = (ConversationDAOImpl) DAOFactory
				.getDAO(DAO_CLASS_NAME.CONVERSATION_DAO);
		try {
			Conversation conversationDAOEntity = conversationDaoImpl
					.get(conversationId);

			List<Steps> stepsDAOEntitys = conversationDAOEntity.getStepsDAOEntities();

			conversationEntity = new ConversationEntity();
			conversationEntity.setConversationId(conversationId);
			conversationEntity.setName(conversationDAOEntity.getName());
			conversationEntity.setDescription(conversationDAOEntity.getDescription());
			conversationEntity.setIntroduction(conversationDAOEntity.getIntroduction());
			conversationEntity.setNote(conversationDAOEntity.getNote());
			conversationEntity.setSteps(convertStepsDaoToWar(stepsDAOEntitys));

		} catch (LCDAOSystemException e) {
			String errorMessage = MessageFormat.format(BUNDLE.getString("LCRSCON4001E"), e.getMessage());
			LOGGER.error(errorMessage, e);
			LCRSExceptionDetails errorObject = new LCRSExceptionDetails("LCRSCON4001E", errorMessage);
			Response httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorObject).build();
			LCRSSystemException systemException = new LCRSSystemException(errorMessage, e);
			systemException.setHttpResponse(httpResponse);
			throw systemException;
		}
		catch (Exception e) {
			String errorMessage = MessageFormat.format(BUNDLE.getString("LCRSCON4001E"), e.getMessage());
			LOGGER.error(errorMessage, e);
			LCRSExceptionDetails errorObject = new LCRSExceptionDetails("LCRSCON4001E", errorMessage);
			Response httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorObject).build();
			LCRSSystemException systemException = new LCRSSystemException(errorMessage, e);
			systemException.setHttpResponse(httpResponse);
			throw systemException;
		}
		LOGGER.exit(conversationEntity);
		return conversationEntity;
	}
	
	/**
	 * Method to convert conversation dao to entity
	 * @param conversationDAOEntities
	 * @return conversation entities
	 */
	private static List<ConversationEntity> convertConversationDaoToWar(List<BaseConversation> conversationDAOEntities) {
		LOGGER.entry(conversationDAOEntities);
		ConversationEntity warEntity;
		List<ConversationEntity> conversationEntities = new ArrayList<>();
		if(conversationDAOEntities != null)
		for(BaseConversation daoEntity : conversationDAOEntities) {
			warEntity = new ConversationEntity();
			warEntity.setConversationId(daoEntity.getConversationId());
			warEntity.setName(daoEntity.getName());
			warEntity.setDescription(daoEntity.getDescription());
			warEntity.setIntroduction(daoEntity.getIntroduction());
			warEntity.setNote(daoEntity.getNote());
			conversationEntities.add(warEntity);
		}
		LOGGER.exit(conversationEntities);
		return conversationEntities;
	}
	
	/**
	 * Method to convert conversation step dao to entity
	 * @param stepsDAOEntities
	 * @return step entities
	 */
	private static List<StepsEntity> convertStepsDaoToWar(List<Steps> stepsDAOEntities) {
		LOGGER.entry(stepsDAOEntities);
		StepsEntity warEntity;
		List<StepsEntity> stepsEntities = new ArrayList<>();
		if(stepsDAOEntities != null)
		for(Steps daoEntity : stepsDAOEntities) {
			warEntity = new StepsEntity();
			warEntity.setStepId(daoEntity.getStepId());
			warEntity.setName(daoEntity.getName());
			warEntity.setIndicatorColor(daoEntity.getPersonalityIndicator().getColorCode());
			warEntity.setTimePercentage(daoEntity.getTimePercentage());
			warEntity.setQuestions(convertQuestionsDaoToWar(daoEntity.getQuestionsDAOEntity()));
			stepsEntities.add(warEntity);
		}
		LOGGER.exit(stepsEntities);
		return stepsEntities;
	}

	/**
	 * Method to convert conversation questions dao to entity
	 * @param questionsDAOEntities
	 * @return question entities
	 */
	private static List<QuestionsEntity> convertQuestionsDaoToWar(List<Questions> questionsDAOEntities) {
		LOGGER.entry(questionsDAOEntities);
		QuestionsEntity warEntity;
		List<QuestionsEntity> questionsEntities = new ArrayList<>();
		if(questionsDAOEntities != null)
		for(Questions daoEntity : questionsDAOEntities) {
			warEntity = new QuestionsEntity();
			warEntity.setQuestionId(daoEntity.getQuestionId());
			warEntity.setQuestion(daoEntity.getQuestion());
			questionsEntities.add(warEntity);
		}
		LOGGER.exit(questionsEntities);
		return questionsEntities;
	}
	
	private static List<ConversationGroupEntity> groupConversation(List<BaseConversation> conversations, String token) throws LCDAOSystemException {
		LOGGER.entry(conversations, token);
		List<String> subscriptions = null;
		if(token != null) {
			LC_TokenDao lcTokenDao = (LC_TokenDao) DAOFactory.getDAO(DAO_CLASS_NAME.LC_TOKEN_DAO);
			LC_Token lcToken = lcTokenDao.get(token);
			if(lcToken != null){
				subscriptions = lcToken.getSubscriptionIds();
			}
		}
		SPackagesDao sPackagesDao = (SPackagesDao) DaoFactory.getDAO(DAO_CLASSES.SPACKAGES_DAO);
		List<ConversationGroupEntity> conversationGroupList = new ArrayList<>();
		List<ConversationGroupEntity> conversationGroupListUnBought = new ArrayList<>();
		Map< String, List<BaseConversation>> groupMap = new HashMap<>();
		conversations.forEach((x)->{
			
			if(groupMap.containsKey(x.getGroupId())) {
				List<BaseConversation> baseConversations = groupMap.get(x.getGroupId());
				baseConversations.add(x);
				groupMap.put(x.getGroupId(), baseConversations);
			}else {
				List<BaseConversation> conversationList = new ArrayList<>();
				conversationList.add(x);
				groupMap.put( x.getGroupId(), conversationList);
			}
			
		});
		List<String> subs = subscriptions;
		groupMap.forEach(( key, value)->{
			
			ConversationGroupEntity conversationGroup = new ConversationGroupEntity();
			try {
				if(key != null) {
					SPackages sPackages = sPackagesDao.get(key);
					conversationGroup.setGroupId(sPackages.getPackageId());
					conversationGroup.setHeader(sPackages.getTitle());
					if(subs != null) {
						if(subs.contains(sPackages.getPackageId())) {
							conversationGroup.setBought(true);
							conversationGroup.setConversations(convertConversationDaoToWar(value));
							conversationGroupList.add(conversationGroup);
						}else {
							conversationGroup.setBought(false);
							conversationGroup.setConversations(convertConversationDaoToWar(value));
							conversationGroupListUnBought.add(conversationGroup);
						}
					}else {
						conversationGroup.setBought(false);
						conversationGroup.setConversations(convertConversationDaoToWar(value));
						conversationGroupListUnBought.add(conversationGroup);
					}
				}else {
					conversationGroup.setGroupId(null);
					conversationGroup.setHeader(null);
					conversationGroup.setBought(true);
					conversationGroup.setConversations(convertConversationDaoToWar(value));
					conversationGroupList.add(conversationGroup);
				}
			} catch (Exception e) {
				try {
					throw e;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		conversationGroupList.addAll(conversationGroupListUnBought);
		LOGGER.exit(conversationGroupList);
		return conversationGroupList;
	}
}
