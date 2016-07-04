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

import com.bx.entity.CustomerLoss;
import com.bx.entity.PageBean;
import com.bx.service.CustomerLossService;
import com.bx.util.DateJsonValueProcessor;
import com.bx.util.DateUtil;
import com.bx.util.ResponseUtil;
import com.bx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * @date 2016年3月30日 CustomerLossController.java
 * @author CZP
 * @parameter
 */
@Controller
@RequestMapping("/customerLoss")
public class CustomerLossController {

	@Resource
	private CustomerLossService customerLossService;

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

	@RequestMapping("/list")
	public void list(String page, String rows, HttpServletResponse response, CustomerLoss s_customerLoss) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		List<CustomerLoss> customerLossList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getSize());
		map.put("cusName", StringUtil.formatLike(s_customerLoss.getCusName()));
		map.put("cusManager", StringUtil.formatLike(s_customerLoss.getCusManager()));
		map.put("state", s_customerLoss.getState());
		customerLossList = customerLossService.find(map);
		long total = customerLossService.getListCount(map);
		JSONObject jsonObject = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(customerLossList, jsonConfig);
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/findById")
	public void findById(HttpServletResponse response, String id) {
		CustomerLoss customerLoss = customerLossService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject jsonObject = JSONObject.fromObject(customerLoss, jsonConfig);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/confirmLoss")
	public void confirmLoss(String id, String lossReason, HttpServletResponse response) throws Exception {
		CustomerLoss customerLoss = new CustomerLoss();
		customerLoss.setId(Integer.parseInt(id));
		customerLoss.setLossReason(lossReason);
		// customerLoss
		// .setConfirmLossTime(DateUtil.formatString(DateUtil.formatDate(new
		// Date(), "yyyy-MM-dd"), "yyyy-MM-dd"));
		// 注意JDBC的版本，太低了会报错
		customerLoss.setConfirmLossTime(new Date());
		customerLoss.setState(1);
		int num = customerLossService.update(customerLoss);
		JSONObject jsonObject = new JSONObject();
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
	public void save(CustomerLoss customerLoss, HttpServletResponse response) {
		int num = 0;
		JSONObject jsonObject = new JSONObject();
		if (customerLoss.getId() == null) {
			num = customerLossService.add(customerLoss);
		} else {
			num = customerLossService.update(customerLoss);
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
		num = customerLossService.delete(Integer.parseInt(id));
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
