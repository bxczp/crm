package com.bx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.CusDevPlanDao;
import com.bx.entity.CusDevPlan;
import com.bx.service.CusDevPlanService;

/**
 * @date 2016年3月28日 CusDevPlanServiceImpl.java
 * @author CZP
 * @parameter
 */
@Service("cusDevPlanService")
public class CusDevPlanServiceImpl implements CusDevPlanService {

	@Resource
	private CusDevPlanDao cusDevPlanDao;

	@Override
	public List<CusDevPlan> find(Map<String, Object> map) {
		return cusDevPlanDao.find(map);
	}

	@Override
	public long getListCount(Map<String, Object> map) {
		return cusDevPlanDao.getListCount(map);
	}

	@Override
	public int add(CusDevPlan cusDevPlan) {
		return cusDevPlanDao.add(cusDevPlan);
	}

	@Override
	public int delete(Integer id) {
		return cusDevPlanDao.delete(id);
	}

	@Override
	public int update(CusDevPlan cusDevPlan) {
		return cusDevPlanDao.update(cusDevPlan);
	}

}
