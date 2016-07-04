package com.bx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bx.entity.LinkMan;
import com.bx.entity.PageBean;
import com.bx.service.LinkManService;
import com.bx.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * @date 2016年3月29日 LinkManController.java
 * @author CZP
 * @parameter
 */
@Controller
@RequestMapping("/linkMan")
public class LinkManController {

	@Resource
	private LinkManService linkManService;

	@RequestMapping("/list")
	public void list(String page, String rows, HttpServletResponse response, String cusId, LinkMan s_linkMan) {
		// PageBean pageBean = new PageBean(Integer.parseInt(page),
		// Integer.parseInt(rows));
		List<LinkMan> linkManList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		// map.put("start", pageBean.getStart());
		// map.put("size", pageBean.getSize());
		// map.put("cusId", s_linkMan.getCustomer().getId());
		map.put("cusId", Integer.parseInt(cusId));
		linkManList = linkManService.find(map);
		long total = linkManService.getListCount(map);
		JSONObject jsonObject = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "customer" });
		JSONArray jsonArray = JSONArray.fromObject(linkManList, jsonConfig);
		jsonObject.put("rows", jsonArray);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("save")
	public void save(LinkMan linkMan, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		int num = 0;
		if (linkMan.getId() == null) {
			num = linkManService.add(linkMan);
		} else {
			num = linkManService.update(linkMan);
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
		JSONObject jsonObject = new JSONObject();
		int num = 0;
		num = linkManService.delete(Integer.parseInt(id));
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
