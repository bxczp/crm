package com.bx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.CustomerServiceDao;
import com.bx.entity.CustomerService;
import com.bx.service.CustomerServiceService;

/**
 * @date 2016年3月30日 CustomerServiceServiceImpl.java
 * @author CZP
 * @parameter
 */
@Service("customerServiceService")
public class CustomerServiceServiceImpl implements CustomerServiceService {

	@Resource
	private CustomerServiceDao customerServiceDao;

	@Override
	public int add(CustomerService customerService) {
		return customerServiceDao.add(customerService);
	}

	@Override
	public List<CustomerService> find(Map<String, Object> map) {
		return customerServiceDao.find(map);
	}

	@Override
	public long getListCount(Map<String, Object> map) {
		return customerServiceDao.getListCount(map);
	}

	@Override
	public int update(CustomerService customerService) {
		return customerServiceDao.update(customerService);
	}

}
