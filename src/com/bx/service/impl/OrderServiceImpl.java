package com.bx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.OrderDao;
import com.bx.entity.Order;
import com.bx.service.OrderService;

/**
 * @date 2016年3月29日 OrderServiceImpl.java
 * @author CZP
 * @parameter
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao orderDao;

	@Override
	public List<Order> find(Map<String, Object> map) {
		return orderDao.find(map);
	}

	@Override
	public long getListCount(Map<String, Object> map) {
		return orderDao.getListCount(map);
	}

	@Override
	public int add(Order order) {
		return orderDao.add(order);
	}

	@Override
	public int update(Order order) {
		return orderDao.update(order);
	}

	@Override
	public int delete(Integer id) {
		return orderDao.delete(id);
	}

	@Override
	public Order findById(int id) {
		return orderDao.findById(id);
	}

	@Override
	public Order findLastOrderByCusId(int cusId) {
		return orderDao.findLastOrderByCusId(cusId);
	}

}
