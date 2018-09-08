package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.bean.User;
import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao ;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	public boolean saveUser(String username, String roleId) {
		return userDao.saveUser(username, roleId);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public String getRoleName(String roleId) {
		return userDao.getRoleName(roleId);
	}

	@Override
	public User getUser(String username) {
		return userDao.getUser(username);
	}

	@Override
	public boolean updataUser(String username, String userId, String password, String roleId) {
		return userDao.updataUser(username, userId, password, roleId);
	}

	@Override
	public boolean deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

}
