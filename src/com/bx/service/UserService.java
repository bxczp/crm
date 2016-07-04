package com.bx.service;

import java.util.List;
import java.util.Map;

import com.bx.entity.User;

/**
 * @date 2016年3月27日 UserService.java
 * @author CZP
 * @parameter
 */
public interface UserService {

	public User login(User user);

	public List<User> find(Map<String, Object> map);

	public long getTotal(Map<String, Object> map);

	public int add(User user);

	public int update(User user);

	public int updateModifyPassword(Map<String, Object> map);

	public int delete(int id);

}
