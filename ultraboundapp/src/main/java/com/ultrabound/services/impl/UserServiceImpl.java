package com.ultrabound.services.impl;

import com.ultrabound.dao.UserDao;
import com.ultrabound.domain.UserEntity;
import com.ultrabound.services.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	/**
	 * 
	 * Create user - persist to database
	 * 
	 * @param userEntity
	 * @return true if create user succeeds
	 */
	public boolean createUser(UserEntity userEntity) {
		userDao.save(userEntity);
		return true;
	}
	
	public boolean checkUser(UserEntity userEntity) {
		return userDao.checkUser(userEntity.getUserName(), userEntity.getPassword());
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
