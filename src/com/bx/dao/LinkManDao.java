package com.bx.dao;

import java.util.List;
import java.util.Map;

import com.bx.entity.LinkMan;

/**
 * @date 2016年3月29日 LinkManDao.java
 * @author CZP
 * @parameter
 */
public interface LinkManDao {

	public List<LinkMan> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int add(LinkMan linkMan);

	public int update(LinkMan linkMan);

	public int delete(int id);

}
