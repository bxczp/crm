package com.bx.dao;

import java.util.List;
import java.util.Map;

import com.bx.entity.CustomerReprieve;
import com.bx.entity.LinkMan;

/**
 * @date 2016年3月30日 CustomerReprieveDao.java
 * @author CZP
 * @parameter
 */
public interface CustomerReprieveDao {

	public List<CustomerReprieve> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int add(CustomerReprieve customerReprieve);

	public int update(CustomerReprieve customerReprieve);

	public int delete(int id);

}
