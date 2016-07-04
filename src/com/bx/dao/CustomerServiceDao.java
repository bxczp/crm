package com.bx.dao;

import java.util.List;
import java.util.Map;

import com.bx.entity.CustomerService;

/**
 * @date 2016年3月30日 CustomerServiceDao.java
 * @author CZP
 * @parameter
 */
public interface CustomerServiceDao {

	public int add(CustomerService customerService);

	public List<CustomerService> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int update(CustomerService customerService);

}
