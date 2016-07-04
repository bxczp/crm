package com.bx.service;

import java.util.List;
import java.util.Map;

import com.bx.entity.CustomerLoss;

/**
 * @date 2016年3月30日 CustomerLossService.java
 * @author CZP
 * @parameter
 */
public interface CustomerLossService {

	public List<CustomerLoss> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int add(CustomerLoss customerLoss);

	public int update(CustomerLoss customerLoss);

	public CustomerLoss findById(int id);

	public int delete(int id);

}
