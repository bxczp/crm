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

import com.bx.entity.PageBean;
import com.bx.entity.SaleChance;
import com.bx.service.SaleChanceService;
import com.bx.util.DateJsonValueProcessor;
import com.bx.util.ResponseUtil;
import com.bx.util.StringUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * @date 2016年3月28日 SaleChanceController.java
 * @author CZP
 * @parameter
 */

@Controller
@RequestMapping("/saleChance")
public class SaleChanceController {
	@Resource
	private SaleChanceService saleChanceService;

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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// true:允许输入空值，false:不能为空值
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("/list")
	public void list(String page, String rows, HttpServletResponse response, SaleChance s_saleChance) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		List<SaleChance> saleChanceList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("customerName", StringUtil.formatLike(s_saleChance.getCustomerName()));
		map.put("overView", StringUtil.formatLike(s_saleChance.getOverView()));
		map.put("createMan", StringUtil.formatLike(s_saleChance.getCreateMan()));
		map.put("devResult", s_saleChance.getDevResult());
		map.put("state", s_saleChance.getState());
		map.put("size", pageBean.getSize());
		map.put("start", pageBean.getStart());
		saleChanceList = saleChanceService.find(map);
		long total = saleChanceService.getListCount(map);
		JSONObject jsonObject = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONArray jsonArray = JSONArray.fromObject(saleChanceList, jsonConfig);
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/save")
	public void add(SaleChance saleChance, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		int num = 0;
		// 已分配的机会
		if (StringUtil.isNotEmpty(saleChance.getAssignMan())) {
			saleChance.setState(1);
		} else {
			saleChance.setState(0);
		}
		if (saleChance.getId() == null) {
			// 开发状态
			saleChance.setDevResult(0);
			num = saleChanceService.add(saleChance);
		} else {
			num = saleChanceService.update(saleChance);
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
		SaleChance saleChance = saleChanceService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		/**
		 * JsonObject的格式是 {"assignMan":"3","assignTime":"2015-05-24 16:15:00"
		 * ,"cgjl":100,"chanceSource":"主动来找的","createMan":"Jack" ,"createTime":
		 * "2014-01-01 00:00:00"
		 * ,"customerName":"风软科技","description":"。。。","devResult":0,"id":1,
		 * "linkMan"
		 * :"张先生","linkPhone":"137234576543","overView":"采购笔记本意向","state":1}
		 * 可以使用 jsonObject.属性名 jsonObject=jsonArray[0] JsonArray的格式是
		 * [{"assignMan":"3","assignTime":"2015-05-24 16:15:00"
		 * ,"cgjl":100,"chanceSource":"主动来找的","createMan":"Jack" ,"createTime":
		 * "2014-01-01 00:00:00"
		 * ,"customerName":"风软科技","description":"。。。","devResult":0,"id":1,
		 * "linkMan"
		 * :"张先生","linkPhone":"137234576543","overView":"采购笔记本意向","state":1}]
		 * 不可以使用 JsonArray.属性 注意区别！！！ 但可以 jsonArray[0].属性
		 */
		JSONObject jsonObject = JSONObject.fromObject(saleChance, jsonConfig);
		// JSONArray jsonArray = JSONArray.fromObject(saleChance, jsonConfig);
		try {
			ResponseUtil.write(response, jsonObject);
			// ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/delete")
	public void delete(String ids, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		String[] id = ids.split(",");
		for (int i = 0; i < id.length; i++) {
			saleChanceService.delete(Integer.parseInt(id[i]));
		}
		jsonObject.put("success", true);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
