package com.bx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.CustomerLossDao;
import com.bx.entity.CustomerLoss;
import com.bx.service.CustomerLossService;

/**
 * @date 2016年3月30日 CustomerLossServiceImpl.java
 * @author CZP
 * @parameter
 */
@Service("customerLossService")
public class CustomerLossServiceImpl implements CustomerLossService {

	@Resource
	private CustomerLossDao customerLossDao;

	@Override
	public List<CustomerLoss> find(Map<String, Object> map) {
		return customerLossDao.find(map);
	}

	@Override
	public long getListCount(Map<String, Object> map) {
		return customerLossDao.getListCount(map);
	}

	@Override
	public int add(CustomerLoss customerLoss) {
		return customerLossDao.add(customerLoss);
	}

	@Override
	public int update(CustomerLoss customerLoss) {
		return customerLossDao.update(customerLoss);
	}

	@Override
	public int delete(int id) {
		return customerLossDao.delete(id);
	}

	@Override
	public CustomerLoss findById(int id) {
		return customerLossDao.findById(id);
	}

}
