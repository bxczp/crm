package com.bx.service;

import java.util.List;
import java.util.Map;

import com.bx.entity.Product;

/**
 * @date 2016年3月27日 ProductService.java
 * @author CZP
 * @parameter
 */
public interface ProductService {

	public List<Product> getProductList(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

}
