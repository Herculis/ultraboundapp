package com.ultrabound.services;

import com.ultrabound.domain.UserEntity;

/**
 * 
 * Service to providing service methods to work with user data and entity
 * 
 * @author Fabian Wanner
 *
 */

public interface UserService {
	
	/**
	 * 
	 * Create user - persist to database
	 * 
	 * @param userEntity
	 * @return true if success
	 */
	
	boolean createUser(UserEntity userEntity);
	boolean checkUser(UserEntity userEntity);

}
