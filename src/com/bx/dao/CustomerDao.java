package com.bx.dao;

import java.util.List;
import java.util.Map;

import com.bx.entity.Customer;
import com.bx.entity.CustomerFw;
import com.bx.entity.CustomerGc;
import com.bx.entity.CustomerGx;

/**
 * @date 2016年3月29日 CustomerDao.java
 * @author CZP
 * @parameter
 */
public interface CustomerDao {

	public List<Customer> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int add(Customer customer);

	public int update(Customer customer);

	public int delete(int id);

	public Customer findById(int id);

	public List<Customer> findLossCustomer();

	public List<CustomerGx> findGx(Map<String, Object> map);

	public long getGxCount(Map<String, Object> map);

	public List<CustomerGc> findGc();

	public List<CustomerFw> findFw();

}
