package com.bx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.UserDao;
import com.bx.entity.User;
import com.bx.service.UserService;

/**
 * @date 2016年3月27日 UserServiceImpl.java
 * @author CZP
 * @parameter
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	/**
	 * UserDao的bean是在 applicationContext.xml中配置注解的
	 */
	@Resource
	private UserDao userDao;

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public List<User> find(Map<String, Object> map) {
		return userDao.find(map);
	}

	@Override
	public long getTotal(Map<String, Object> map) {
		return userDao.getTotal(map);
	}

	@Override
	public int add(User user) {
		return userDao.add(user);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	public int delete(int id) {
		return userDao.delete(id);
	}

	@Override
	public int updateModifyPassword(Map<String, Object> map) {
		return userDao.updateModifyPassword(map);
	}

}
