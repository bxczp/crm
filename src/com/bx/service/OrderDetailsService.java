package com.bx.service;

import java.util.List;
import java.util.Map;

import com.bx.entity.OrderDetails;

/**
 * @date 2016年3月29日 OrderDetailsDao.java
 * @author CZP
 * @parameter
 */
public interface OrderDetailsService {

	public List<OrderDetails> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int add(OrderDetails orderDetails);

	public int update(OrderDetails orderDetails);

	public int delete(int id);

	public float getTotalPriceByOrderId(int orderId);

}
