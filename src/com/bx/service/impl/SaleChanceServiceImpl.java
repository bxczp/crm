package com.bx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.SaleChanceDao;
import com.bx.entity.SaleChance;
import com.bx.service.SaleChanceService;

/**
 * @date 2016年3月28日 SaleChanceServiceImpl.java
 * @author CZP
 * @parameter
 */
@Service("saleChanceService")
public class SaleChanceServiceImpl implements SaleChanceService {

	@Resource
	private SaleChanceDao saleChanceDao;

	@Override
	public List<SaleChance> find(Map<String, Object> map) {
		return saleChanceDao.find(map);
	}

	@Override
	public long getListCount(Map<String, Object> map) {
		return saleChanceDao.getListCount(map);
	}

	@Override
	public int add(SaleChance saleChance) {
		return saleChanceDao.add(saleChance);
	}

	@Override
	public int update(SaleChance saleChance) {
		return saleChanceDao.update(saleChance);
	}

	@Override
	public int delete(Integer id) {
		return saleChanceDao.delete(id);
	}

	@Override
	public SaleChance findById(Integer id) {
		return saleChanceDao.findById(id);
	}

}
