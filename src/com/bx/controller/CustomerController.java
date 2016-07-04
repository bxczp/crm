package com.bx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bx.entity.Customer;
import com.bx.entity.CustomerFw;
import com.bx.entity.CustomerGc;
import com.bx.entity.CustomerGx;
import com.bx.entity.PageBean;
import com.bx.service.CustomerService;
import com.bx.util.DateUtil;
import com.bx.util.ResponseUtil;
import com.bx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @date 2016年3月29日 CustomerController.java
 * @author CZP
 * @parameter
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Resource
	private CustomerService customerService;

	@RequestMapping("/list")
	public void list(String page, String rows, HttpServletResponse response, Customer s_customer) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		List<Customer> customerList = new ArrayList<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getSize());
		map.put("khno", StringUtil.formatLike(s_customer.getKhno()));
		map.put("name", StringUtil.formatLike(s_customer.getName()));
		customerList = customerService.find(map);
		JSONObject jsonObject = new JSONObject();
		long total = customerService.getListCount(map);
		JSONArray jsonArray = JSONArray.fromObject(customerList);
		jsonObject.put("total", total);
		jsonObject.put("rows", jsonArray);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/findCustomerGx")
	public void findCustomerGx(String page, String rows, HttpServletResponse response, String name) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		List<CustomerGx> customerGxList = new ArrayList<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getSize());
		map.put("name", StringUtil.formatLike(name));
		customerGxList = customerService.findGx(map);
		JSONObject jsonObject = new JSONObject();
		long total = customerService.getGxCount(map);
		JSONArray jsonArray = JSONArray.fromObject(customerGxList);
		jsonObject.put("total", total);
		jsonObject.put("rows", jsonArray);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/findCustomerGc")
	public void findCustomerGc(HttpServletResponse response) {
		List<CustomerGc> customerGcList = new ArrayList<>();
		customerGcList = customerService.findGc();
		JSONArray jsonArray = JSONArray.fromObject(customerGcList);
		try {
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/findCustomerFw")
	public void findCustomerFw(HttpServletResponse response) {
		List<CustomerFw> customerFwList = new ArrayList<>();
		customerFwList = customerService.findFw();
		JSONArray jsonArray = JSONArray.fromObject(customerFwList);
		try {
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/save")
	public void save(HttpServletResponse response, Customer customer) {
		int num = 0;
		JSONObject jsonObject = new JSONObject();
		if (customer.getId() == null) {
			customer.setKhno("KH" + DateUtil.getCurrentDate());
			num = customerService.add(customer);
		} else {
			num = customerService.update(customer);
		}
		if (num > 0) {
			jsonObject.put("success", true);
		} else {
			jsonObject.put("success", false);
		}
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/findById")
	public void findById(String id, HttpServletResponse response) {
		Customer customer = customerService.findById(Integer.parseInt(id));

		JSONObject jsonObject = JSONObject.fromObject(customer);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/delete")
	public void delete(String ids, HttpServletResponse response) {
		String[] id = ids.split(",");
		JSONObject jsonObject = new JSONObject();
		int num = 0;
		for (int i = 0; i < id.length; i++) {
			num = customerService.delete(Integer.parseInt(id[i]));
		}
		if (num > 0) {
			jsonObject.put("success", true);
		} else {
			jsonObject.put("success", false);
		}
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
