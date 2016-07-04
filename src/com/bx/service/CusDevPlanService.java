package com.bx.service;

import java.util.List;
import java.util.Map;

import com.bx.entity.CusDevPlan;

/**
 * @date 2016年3月28日 CusDevPlanService.java
 * @author CZP
 * @parameter
 */
public interface CusDevPlanService {

	public List<CusDevPlan> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int add(CusDevPlan cusDevPlan);

	public int delete(Integer id);

	public int update(CusDevPlan cusDevPlan);

}
