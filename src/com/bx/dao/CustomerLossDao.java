package com.bx.dao;

import java.util.List;
import java.util.Map;

import com.bx.entity.CustomerLoss;

/**
 * @date 2016年3月30日 CustomerLossDao.java
 * @author CZP
 * @parameter
 */
public interface CustomerLossDao {

	public List<CustomerLoss> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int add(CustomerLoss customerLoss);

	public int update(CustomerLoss customerLoss);

	public int delete(int id);

	public CustomerLoss findById(int id);

}
