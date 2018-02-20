package com.leadercoach.rest.services.delegate;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leadercoach.rest.dao.constants.DAOConstants.DAO_CLASS_NAME;
import com.leadercoach.rest.dao.exception.LCDAOSystemException;
import com.leadercoach.rest.dao.factory.DAOFactory;
import com.leadercoach.rest.dao.inf.LC_TokenDao;
import com.leadercoach.rest.services.constants.ApplicationConstants;
import com.leadercoach.rest.services.exception.LCRSExceptionDetails;
import com.leadercoach.rest.services.exception.LCRSSystemException;

/**
 * Class to request the Lc Token dao
 * @author CodaGlobal
 */
public class LC_TokenDelegate {

	private static final Logger LOGGER = LogManager.getLogger(LC_TokenDelegate.class);
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ApplicationConstants.LC_TOKEN_BUNDLE);
	
	/**
	 * Validate Token method validates the token is already used or not.
	 * @param token
	 * @return true/false
	 * @throws LCRSSystemException
	 */
	public static boolean validateToken(String token) throws LCRSSystemException {
		LOGGER.entry(token);
		boolean flag;
		LC_TokenDao lcTokenDao = (LC_TokenDao) DAOFactory.getDAO(DAO_CLASS_NAME.LC_TOKEN_DAO);
		try {
			flag = lcTokenDao.validateToken(token);
		}catch (LCDAOSystemException e) {
			String errorMessage = MessageFormat.format(BUNDLE.getString("LCRSTOK4001E"), e.getMessage());
			LOGGER.error(errorMessage, e);
			LCRSExceptionDetails errorObject = new LCRSExceptionDetails("LCRSTOK4001E", errorMessage);
			Response httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorObject).build();
			LCRSSystemException systemException = new LCRSSystemException(errorMessage, e);
			systemException.setHttpResponse(httpResponse);
			throw systemException;
		}
		catch (Exception e) {
			String errorMessage = MessageFormat.format(BUNDLE.getString("LCRSTOK4001E"), e.getMessage());
			LOGGER.error(errorMessage, e);
			LCRSExceptionDetails errorObject = new LCRSExceptionDetails("LCRSTOK4001E", errorMessage);
			Response httpResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorObject).build();
			LCRSSystemException systemException = new LCRSSystemException(errorMessage, e);
			systemException.setHttpResponse(httpResponse);
			throw systemException;
		}
		LOGGER.exit(flag);
		return flag;
	}
}
