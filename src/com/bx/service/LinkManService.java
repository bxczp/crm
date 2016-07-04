package com.bx.service;

import java.util.List;
import java.util.Map;

import com.bx.entity.LinkMan;

/**
 * @date 2016年3月29日 LinkManService.java
 * @author CZP
 * @parameter
 */
public interface LinkManService {

	public List<LinkMan> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int add(LinkMan linkMan);

	public int update(LinkMan linkMan);

	public int delete(int id);

}
