package com.bx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bx.entity.OrderDetails;
import com.bx.entity.PageBean;
import com.bx.service.OrderDetailsService;
import com.bx.util.ResponseUtil;
import com.bx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * @date 2016年3月29日 OrderDetailsController.java
 * @author CZP
 * @parameter
 */
@Controller
@RequestMapping("/orderDetails")
public class OrderDetailsController {

	@Resource
	private OrderDetailsService orderDetailsService;

	@RequestMapping("/list")
	public void list(HttpServletResponse response, String orderId, String page, String rows) {
		if (StringUtil.isEmpty(orderId)) {
			return;
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		List<OrderDetails> orderDetailsList = new ArrayList<>();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "order" });
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getSize());
		map.put("orderId", Integer.parseInt(orderId));
		orderDetailsList = orderDetailsService.find(map);
		long total = orderDetailsService.getListCount(map);
		JSONArray jsonArray = JSONArray.fromObject(orderDetailsList, jsonConfig);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/getTotalPrice")
	public void getTotalPriceByOrderId(String orderId, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		float sum = orderDetailsService.getTotalPriceByOrderId(Integer.parseInt(orderId));
		jsonObject.put("totalMoney", sum);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/save")
	public void save(OrderDetails orderDetails, HttpServletResponse response) {
		int num = 0;
		JSONObject jsonObject = new JSONObject();
		if (orderDetails.getId() == null) {
			orderDetailsService.add(orderDetails);
		} else {
			orderDetailsService.update(orderDetails);
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

	@RequestMapping("/delete")
	public void delete(String id, HttpServletResponse response) {
		int num = 0;
		JSONObject jsonObject = new JSONObject();
		num = orderDetailsService.delete(Integer.parseInt(id));
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
