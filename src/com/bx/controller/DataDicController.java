package com.bx.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.bx.entity.DataDic;
import com.bx.entity.PageBean;
import com.bx.service.DataDicService;
import com.bx.util.ResponseUtil;
import com.bx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

/**
 * @date 2016年3月27日 DataDicController.java
 * @author CZP
 * @parameter
 */
@Controller
@RequestMapping("/dataDic")
public class DataDicController {

	@Resource
	private DataDicService dataDicService;

	@RequestMapping("/list")
	public void list(String page, String rows, HttpServletResponse response, DataDic s_dataDic) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("dataDicName", s_dataDic.getDataDicName());
		map.put("dataDicValue", StringUtil.formatLike(s_dataDic.getDataDicValue()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getSize());
		List<DataDic> dataDicList = dataDicService.find(map);
		long total = dataDicService.getListCount(map);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(dataDicList);
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/dataDicComboList")
	public void dataDicComboList(String dataDicName, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		map.put("dataDicName", StringUtil.formatLike(dataDicName));
		List<DataDic> dataDicList = dataDicService.find(map);
		JSONArray jsonArray = JSONArray.fromObject(dataDicList);
		// 直接输出，不需要再装入jsonObject
		try {
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/findDataDicName")
	public void dataDicNameList(HttpServletResponse response) {
		List<DataDic> dataDicNameList = dataDicService.findAll();
		JSONArray jsonArray = JSONArray.fromObject(dataDicNameList);
		// 直接输出，不需要再装入jsonObject
		try {
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/save")
	public void add(DataDic dataDic, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		int num = 0;
		if (dataDic.getId() == null) {
			num = dataDicService.add(dataDic);
		} else {
			num = dataDicService.update(dataDic);
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
	public void delete(HttpServletResponse response, String ids) {
		JSONObject jsonObject = new JSONObject();
		String[] id = ids.split(",");
		for (int i = 0; i < id.length; i++) {
			dataDicService.delete(Integer.parseInt(id[i]));
		}
		jsonObject.put("success", true);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
