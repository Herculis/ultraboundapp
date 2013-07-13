package com.ultrabound.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.util.Assert;

import com.ultrabound.dao.UserDao;

/**
 * Data access object JPA implementation to work with
 * User entity database operations
 * 
 * @author Fabian Wanner
 *
 */

public class UserJpaDao extends GenericJpaDao<UserEntity, Long> implements UserDao {

	public UserJpaDao() {
		super(UserEntity.class);
	}

	/**
	 *  Queries database for user name available
	 *  
	 * @param userName
	 * @return true if available
	 */
	
	public boolean checkAvailable(String userName) {
		Assert.notNull(userName);
		
		Query query = getEntityManager().createQuery("select count(*) from " + getPersistentClass().getSimpleName()
				+ " u where u.userName = :userName").setParameter("userName",  userName);
		Long count = (Long) query.getSingleResult();
		return (count  < 1);
	}

	/**
	 * Queries user by username and returns the user entity
	 * 
	 * @param userName
	 * @return
	 */
	public UserEntity loadUserByUserName(String userName) {
		Assert.notNull(userName);
		
		UserEntity user = null;
		Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName() + 
				" u where u.userName = :userName").setParameter("userName", userName);
		
		try {
			user = (UserEntity) query.getSingleResult();
		} catch (NoResultException e) {
			// do nothing, just return null
		}
		
		return user;
	}

	/**
	 *  Queries database for user name and password
	 *  
	 * @param userName
	 * @return true if available
	 */
	public boolean checkUser(String userName, String password) {
		Assert.notNull(userName);
		Assert.notNull(password);
		
		Query query = getEntityManager().createQuery("select count(*) from " + getPersistentClass().getSimpleName()
				+ " u where u.userName = :userName AND u.password = :password").setParameter("userName",  userName).setParameter("password", password);
		Long count = (Long) query.getSingleResult();

		return (count == 1);
	}

	
}
