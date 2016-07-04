package com.bx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bx.entity.CustomerService;
import com.bx.entity.PageBean;
import com.bx.service.CustomerServiceService;
import com.bx.util.DateJsonValueProcessor;
import com.bx.util.ResponseUtil;
import com.bx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * @date 2016年3月30日 CustomerServiceController.java
 * @author CZP
 * @parameter
 */
@Controller
@RequestMapping("customerService")
public class CustomerServiceController {

	@Resource
	private CustomerServiceService customerServiceService;

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
		dateFormat.setLenient(false);
		// true:允许输入空值，false:不能为空值
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("save")
	public void save(CustomerService customerService, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		int num = 0;
		if (customerService.getId() == null) {
			num = customerServiceService.add(customerService);
		} else {
			num = customerServiceService.update(customerService);
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

	@RequestMapping("/list")
	public void list(String page, String rows, HttpServletResponse response, String createTimefrom, String createTimeto,
			CustomerService s_customerService) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		List<CustomerService> customerServiceList = new ArrayList<>();
		map.put("customer", StringUtil.formatLike(s_customerService.getCustomer()));
		map.put("overView", StringUtil.formatLike(s_customerService.getOverview()));
		map.put("createTimefrom", createTimefrom);
		map.put("createTimeto", createTimeto);
		map.put("serviceType", StringUtil.formatLike(s_customerService.getServeType()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getSize());
		map.put("state", s_customerService.getState());
		customerServiceList = customerServiceService.find(map);
		long total = customerServiceService.getListCount(map);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(customerServiceList, jsonConfig);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
