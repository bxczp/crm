package com.bx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bx.entity.CustomerReprieve;
import com.bx.entity.PageBean;
import com.bx.service.CustomerReprieveService;
import com.bx.service.impl.CustomerReprieveServiceImpl;
import com.bx.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * @date 2016年3月30日 CustomerReprieveController.java
 * @author CZP
 * @parameter
 */
@Controller
@RequestMapping("/customerReprieve")
public class CustomerReprieveController {

	@Resource
	private CustomerReprieveService customereprieveService;

	@RequestMapping("/list")
	public void list(String page, String rows, String lossId, HttpServletResponse response,
			CustomerReprieve s_customerReprieve) {
		// PageBean pageBean = new PageBean(Integer.parseInt(page),
		// Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		List<CustomerReprieve> customerReprieveList = new ArrayList<>();
		// map.put("start", pageBean.getStart());
		// map.put("size", pageBean.getSize());
		map.put("lossId", Integer.parseInt(lossId));
		customerReprieveList = customereprieveService.find(map);
		long total = customereprieveService.getListCount(map);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "customerLoss" });
		JSONArray jsonArray = JSONArray.fromObject(customerReprieveList, jsonConfig);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", total);
		jsonObject.put("rows", jsonArray);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/delete")
	public void delete(String id, HttpServletResponse response) {
		int num = 0;
		JSONObject jsonObject = new JSONObject();
		num = customereprieveService.delete(Integer.parseInt(id));
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

	@RequestMapping("/save")
	public void save(CustomerReprieve customerReprieve, HttpServletResponse response) {
		int num = 0;
		JSONObject jsonObject = new JSONObject();
		if (customerReprieve.getId() == null) {
			num = customereprieveService.add(customerReprieve);
		} else {
			num = customereprieveService.update(customerReprieve);
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
