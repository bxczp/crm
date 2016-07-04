package com.bx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.DataDicDao;
import com.bx.entity.DataDic;
import com.bx.service.DataDicService;

/**
 * @date 2016年3月27日 DataDicServiceImpl.java
 * @author CZP
 * @parameter
 */

@Service("dataDicService")
public class DataDicServiceImpl implements DataDicService {

	@Resource
	private DataDicDao dataDicDao;

	@Override
	public List<DataDic> find(Map<String, Object> map) {
		return dataDicDao.find(map);
	}

	@Override
	public long getListCount(Map<String, Object> map) {
		return dataDicDao.getListCount(map);
	}

	@Override
	public List<DataDic> findAll() {
		return dataDicDao.findAll();
	}

	@Override
	public int add(DataDic dataDic) {
		return dataDicDao.add(dataDic);
	}

	@Override
	public int update(DataDic dataDic) {
		return dataDicDao.update(dataDic);
	}

	@Override
	public int delete(int id) {
		return dataDicDao.delete(id);
	}

}
