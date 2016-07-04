package com.bx.service;

import java.util.List;
import java.util.Map;

import com.bx.entity.CustomerReprieve;

/**
 * @date 2016年3月30日 CustomerReprieveService.java
 * @author CZP
 * @parameter
 */
public interface CustomerReprieveService {

	public List<CustomerReprieve> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int add(CustomerReprieve customerReprieve);

	public int update(CustomerReprieve customerReprieve);

	public int delete(int id);

}
