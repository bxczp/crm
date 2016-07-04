package com.bx.dao;

import java.util.List;
import java.util.Map;

import com.bx.entity.Product;

/**
 * @date 2016年3月27日 ProductDao.java
 * @author CZP
 * @parameter
 */
public interface ProductDao {

	public List<Product> getProductList(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

}
