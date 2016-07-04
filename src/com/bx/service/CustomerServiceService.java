package com.bx.service;

import java.util.List;
import java.util.Map;

import com.bx.entity.CustomerService;

/**
 * @date 2016年3月30日 CustomerServiceService.java
 * @author CZP
 * @parameter
 */
public interface CustomerServiceService {

	public int add(CustomerService customerService);

	public List<CustomerService> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int update(CustomerService customerService);

}
