package com.bx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.OrderDetailsDao;
import com.bx.entity.OrderDetails;
import com.bx.service.OrderDetailsService;

/**
 * @date 2016年3月29日 OrderDetailsServiceImpl.java
 * @author CZP
 * @parameter
 */

@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Resource
	private OrderDetailsDao orderDetailsDao;

	@Override
	public List<OrderDetails> find(Map<String, Object> map) {
		return orderDetailsDao.find(map);
	}

	@Override
	public long getListCount(Map<String, Object> map) {
		return orderDetailsDao.getListCount(map);
	}

	@Override
	public int add(OrderDetails orderDetails) {
		return orderDetailsDao.add(orderDetails);
	}

	@Override
	public int update(OrderDetails orderDetails) {
		return orderDetailsDao.update(orderDetails);
	}

	@Override
	public int delete(int id) {
		return orderDetailsDao.delete(id);
	}

	@Override
	public float getTotalPriceByOrderId(int orderId) {
		return orderDetailsDao.getTotalPriceByOrderId(orderId);
	}

}
