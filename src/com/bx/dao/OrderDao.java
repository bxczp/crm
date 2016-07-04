package com.bx.dao;

import java.util.List;
import java.util.Map;

import com.bx.entity.Order;

/**
 * @date 2016年3月29日 OrderDao.java
 * @author CZP
 * @parameter
 */
public interface OrderDao {

	public List<Order> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int add(Order order);

	public int update(Order order);

	public int delete(Integer id);

	public Order findById(int id);

	public Order findLastOrderByCusId(int cusId);

}
