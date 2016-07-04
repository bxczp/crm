package com.bx.dao;

import java.util.List;
import java.util.Map;

import com.bx.entity.DataDic;

/**
 * @date 2016年3月27日 DataDicDao.java
 * @author CZP
 * @parameter
 */
public interface DataDicDao {

	public List<DataDic> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public List<DataDic> findAll();

	public int add(DataDic dataDic);

	public int update(DataDic dataDic);

	public int delete(int id);

}
