package com.zensar.services;

import java.util.List;

import com.zensar.daos.UserDao;
import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;

/**
 * @author Akansha Shah
 * @version 2.0
 * @creation_date 21st sep 2019 5.35PM
 * @modification_date 28st sep 2019 11.46AM
 * @copyright Zensar Technologies. All rights reserved.
 * @description:It is 
 */
public class UserServiceImpl implements UserService {

	private UserDao userdao;

	public void setuserDao(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public void addUser(User user) throws ServiceException {
		userdao.insert(user);

	}

	@Override
	public void updateUser(User user) throws ServiceException {
		userdao.update(user);

	}

	@Override
	public void removeUser(User user) throws ServiceException {
		userdao.delete(user);
	}

	@Override
	public User findUserByUserName(String username) throws ServiceException {
		// TODO Auto-generated method stub
		User user;
		user = userdao.getByUserName(username);
		return user;

	}

	@Override
	public List<User> findAllUsers() throws ServiceException {
		return userdao.getAll();

	}

	@Override
	public boolean validateUser(User user) throws ServiceException {
		// TODO Auto-generated method stub

		User dbUser = findUserByUserName(user.getUsername());

		if (dbUser != null && dbUser.getPassword().equals(user.getPassword()))
			return true;
		else
			return false;
	}

}
