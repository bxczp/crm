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

import com.bx.entity.CusDevPlan;
import com.bx.entity.SaleChance;
import com.bx.service.CusDevPlanService;
import com.bx.service.SaleChanceService;
import com.bx.util.DateJsonValueProcessor;
import com.bx.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * @date 2016年3月28日 CusDevPlanController.java
 * @author CZP
 * @parameter
 */

@Controller
@RequestMapping("cusDevPlan")
public class CusDevPlanController {

	@Resource
	private CusDevPlanService cusDevPlanService;

	@Resource
	private SaleChanceService saleChanceService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 注意 时间格式 会报400错误
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		// true:允许输入空值，false:不能为空值
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("/list")
	public void list(String saleChanceId, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		map.put("saleChanceId", Integer.parseInt(saleChanceId));
		List<CusDevPlan> cusDevPlanList = new ArrayList<>();
		cusDevPlanList = cusDevPlanService.find(map);
		JsonConfig jsonConfig = new JsonConfig();
		// 排除 指定变量名，防止出现死循环
		jsonConfig.setExcludes(new String[] { "saleChance" });
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray json = JSONArray.fromObject(cusDevPlanList, jsonConfig);
		// 不能使用jsonObject 会出现'object' is an array. Use JSONArray instead
		// jsonObject只能装单个对象，不能装集合
		// JSONObject json = JSONObject.fromObject(cusDevPlanList, jsonConfig);
		try {
			ResponseUtil.write(response, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/save")
	public void add(HttpServletResponse response, CusDevPlan cusDevPlan) {
		JSONObject jsonObject = new JSONObject();
		int num = 0;
		if (cusDevPlan.getId() == null) {
			// 添加客户开发计划后修改对应的销售机会
			SaleChance saleChance = saleChanceService.findById(cusDevPlan.getSaleChance().getId());
			saleChance.setDevResult(1);
			saleChanceService.update(saleChance);
			num = cusDevPlanService.add(cusDevPlan);
		} else {
			num = cusDevPlanService.update(cusDevPlan);
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
	public void delete(HttpServletResponse response, String id) {
		JSONObject jsonObject = new JSONObject();
		int num = 0;
		num = cusDevPlanService.delete(Integer.parseInt(id));
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

	@RequestMapping("/updateSaleChanceDevResult")
	public void updateSaleChanceDevResult(String id, String devResult, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		SaleChance saleChance = new SaleChance();
		saleChance.setId(Integer.parseInt(id));
		saleChance.setDevResult(Integer.parseInt(devResult));
		int num = saleChanceService.update(saleChance);
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
