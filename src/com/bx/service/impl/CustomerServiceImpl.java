package com.bx.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.CustomerDao;
import com.bx.dao.CustomerLossDao;
import com.bx.dao.OrderDao;
import com.bx.entity.Customer;
import com.bx.entity.CustomerFw;
import com.bx.entity.CustomerGc;
import com.bx.entity.CustomerGx;
import com.bx.entity.CustomerLoss;
import com.bx.entity.Order;
import com.bx.service.CustomerService;

/**
 * @date 2016年3月29日 CustomerServiceImpl.java
 * @author CZP
 * @parameter
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerDao customerDao;

	@Resource
	private CustomerLossDao customerLossDao;

	@Resource
	private OrderDao orderDao;

	@Override
	public List<Customer> find(Map<String, Object> map) {
		return customerDao.find(map);
	}

	@Override
	public long getListCount(Map<String, Object> map) {
		return customerDao.getListCount(map);
	}

	@Override
	public int add(Customer customer) {
		return customerDao.add(customer);
	}

	@Override
	public int update(Customer customer) {
		return customerDao.update(customer);
	}

	@Override
	public int delete(int id) {
		return customerDao.delete(id);
	}

	@Override
	public Customer findById(int id) {
		return customerDao.findById(id);
	}

	@Override
	public List<Customer> findLossCustomer() {
		return customerDao.findLossCustomer();
	}

	// 在Spring(applicationContext.xml文件中)中配置Quartz,定时调用该方法
	// xmlns:task="http://www.springframework.org/schema/task"
	@Override
	public void checkCustomerLoss() {
		List<Customer> customerList = new ArrayList<>();
		customerList = customerDao.findLossCustomer();
		CustomerLoss customerLoss = new CustomerLoss();
		for (int i = 0; i < customerList.size(); i++) {
			Customer customer = customerList.get(i);
			Order order = orderDao.findLastOrderByCusId(customer.getId());
			// 有些客户是没有订单的
			if (order != null) {
				customerLoss.setLastOrderTime(order.getOrderDate());
			} else {
				customerLoss.setLastOrderTime(null);
			}
			customerLoss.setCusNo(customer.getKhno());
			customerLoss.setCusName(customer.getName());
			customerLoss.setCusManager(customer.getCusManager());
			customerLossDao.add(customerLoss);
			// 修改客户状态
			customer.setState(1);
			customerDao.update(customer);
		}
	}

	@Override
	public List<CustomerGx> findGx(Map<String, Object> map) {
		return customerDao.findGx(map);
	}

	@Override
	public long getGxCount(Map<String, Object> map) {
		return customerDao.getGxCount(map);
	}

	@Override
	public List<CustomerGc> findGc() {
		return customerDao.findGc();
	}

	@Override
	public List<CustomerFw> findFw() {
		return customerDao.findFw();
	}

}
