package com.bx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.ProductDao;
import com.bx.entity.Product;
import com.bx.service.ProductService;

/**
 * @date 2016年3月27日 ProductServiceImpl.java
 * @author CZP
 * @parameter
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductDao productDao;

	@Override
	public List<Product> getProductList(Map<String, Object> map) {
		return productDao.getProductList(map);
	}

	@Override
	public long getListCount(Map<String, Object> map) {
		return productDao.getListCount(map);
	}

}
