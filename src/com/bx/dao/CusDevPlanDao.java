package com.bx.dao;

import java.util.List;
import java.util.Map;

import com.bx.entity.CusDevPlan;

/**
 * @date 2016年3月28日 CusDevPlanDao.java
 * @author CZP
 * @parameter
 */
public interface CusDevPlanDao {

	public List<CusDevPlan> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int add(CusDevPlan cusDevPlan);

	public int delete(Integer id);

	public int update(CusDevPlan cusDevPlan);

}
