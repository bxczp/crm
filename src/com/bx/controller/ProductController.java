package com.bx.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.bx.entity.PageBean;
import com.bx.entity.Product;
import com.bx.service.ProductService;
import com.bx.util.ResponseUtil;
import com.bx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

/**
 * @date 2016年3月27日 ProductController.java
 * @author CZP
 * @parameter
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Resource
	private ProductService productService;

	@RequestMapping("/list")
	public String list(String page, String rows, Product s_product, HttpServletResponse response) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		List<Product> productList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getSize());
		map.put("productName", StringUtil.formatLike(s_product.getProductName()));
		productList = productService.getProductList(map);
		long count = productService.getListCount(map);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(productList);
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", count);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
