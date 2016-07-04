package com.bx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bx.entity.Order;
import com.bx.entity.PageBean;
import com.bx.service.OrderService;
import com.bx.util.DateJsonValueProcessor;
import com.bx.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * @date 2016年3月29日 OrderController.java
 * @author CZP
 * @parameter
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	private OrderService orderService;

	// 初始化的绑定 把字符串类型的日期转换成Date类型的日期对象
	/**
	 * 在实际操作中经常会碰到表单中的字符串类型的日期和Javabean中的日期类型的属性自动转换，
	 * 而springMVC默认不支持这个格式的转换，所以必须要手动配置， 自定义数据类型的绑定才能实现这个功能。
	 * 比较简单的可以直接应用springMVC的注解@initbinder和spring自带的WebDataBinder类和操作
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// setLenient用于设置dateFormat是否宽松解析字符串，如果为false，则严格解析；默认为true，宽松解析
		dateFormat.setLenient(false);
		// true:允许输入空值，false:不能为空值
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Boolean.class, new CustomBooleanEditor(true));
		// binder.registerCustomEditor(long.class, new LongEditor());
		// binder.registerCustomEditor(double.class, new DoubleEditor());
		// binder.registerCustomEditor(float.class, new FloatEditor());
	}

	@RequestMapping("/list")
	public void list(String page, String rows, HttpServletResponse response, String cusId) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		List<Order> orderList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("cusId", Integer.parseInt(cusId));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getSize());
		orderList = orderService.find(map);
		long total = orderService.getListCount(map);
		JSONObject jsonObject = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "customer" });
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(orderList, jsonConfig);
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("save")
	public void save(Order order, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		int num = 0;
		if (order.getId() == null) {
			num = orderService.add(order);
		} else {
			num = orderService.update(order);
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
		Order order = orderService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "customer" });
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONObject jsonObject = JSONObject.fromObject(order, jsonConfig);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/delete")
	public void delete(String id, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		int num = 0;
		num = orderService.delete(Integer.parseInt(id));
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
