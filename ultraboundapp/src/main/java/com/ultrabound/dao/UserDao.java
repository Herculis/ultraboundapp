package com.ultrabound.dao;

import com.ultrabound.commons.dao.GenericDao;
import com.ultrabound.domain.UserEntity;

/**
 * Data access object interface to work with
 * User entity database operations
 * 
 * @author Fabian Wanner
 *
 */

public interface UserDao extends GenericDao<UserEntity, Long> {
		
	/**
	 *  Queries database for user name available
	 *  
	 * @param userName
	 * @return true if available
	 */
	boolean checkAvailable(String userName);
	boolean checkUser(String userName, String password);

	
	/**
	 * Queries user by username and returns the user entity
	 * 
	 * @param userName
	 * @return
	 */
	UserEntity loadUserByUserName(String userName);
}
