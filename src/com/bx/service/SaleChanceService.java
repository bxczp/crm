package com.bx.service;

import java.util.List;
import java.util.Map;

import com.bx.entity.SaleChance;

/**
 * @date 2016年3月28日 SaleChanceDao.java
 * @author CZP
 * @parameter
 */
public interface SaleChanceService {

	public List<SaleChance> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int add(SaleChance saleChance);

	public int update(SaleChance saleChance);

	public int delete(Integer id);

	public SaleChance findById(Integer id);
}
