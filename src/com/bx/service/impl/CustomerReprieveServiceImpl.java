package com.bx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.CustomerReprieveDao;
import com.bx.entity.CustomerReprieve;
import com.bx.service.CustomerReprieveService;

/**
 * @date 2016年3月30日 CustomerReprieveServiceImpl.java
 * @author CZP
 * @parameter
 */
@Service("customerReprieve")
public class CustomerReprieveServiceImpl implements CustomerReprieveService {

	@Resource
	private CustomerReprieveDao customerReprieveDao;

	@Override
	public List<CustomerReprieve> find(Map<String, Object> map) {
		return customerReprieveDao.find(map);
	}

	@Override
	public long getListCount(Map<String, Object> map) {
		return customerReprieveDao.getListCount(map);
	}

	@Override
	public int add(CustomerReprieve customerReprieve) {
		return customerReprieveDao.add(customerReprieve);
	}

	@Override
	public int update(CustomerReprieve customerReprieve) {
		return customerReprieveDao.update(customerReprieve);
	}

	@Override
	public int delete(int id) {
		return customerReprieveDao.delete(id);
	}

}
