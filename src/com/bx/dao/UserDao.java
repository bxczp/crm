package com.bx.dao;

import java.util.List;
import java.util.Map;

import com.bx.entity.PageBean;
import com.bx.entity.User;

/**
 * @date 2016年3月27日 UserDao.java
 * @author CZP
 * @parameter
 */
public interface UserDao {
	/**
	 * Dao的实现 要在mapper.xml文件中
	 * 
	 * @param user
	 * @return
	 */

	public User login(User user);

	public List<User> find(Map<String, Object> map);

	public long getTotal(Map<String, Object> map);

	public int add(User user);

	public int update(User user);

	public int delete(int id);

	public int updateModifyPassword(Map<String, Object> map);
}
