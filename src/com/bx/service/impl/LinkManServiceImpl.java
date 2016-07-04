package com.bx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.LinkManDao;
import com.bx.entity.LinkMan;
import com.bx.service.LinkManService;

/**
 * @date 2016年3月29日 LinkManServiceImpl.java
 * @author CZP
 * @parameter
 */
@Service("linkManService")
public class LinkManServiceImpl implements LinkManService {

	@Resource
	private LinkManDao linkManDao;

	@Override
	public List<LinkMan> find(Map<String, Object> map) {
		return linkManDao.find(map);
	}

	@Override
	public long getListCount(Map<String, Object> map) {
		return linkManDao.getListCount(map);
	}

	@Override
	public int add(LinkMan linkMan) {
		return linkManDao.add(linkMan);
	}

	@Override
	public int update(LinkMan linkMan) {
		return linkManDao.update(linkMan);
	}

	@Override
	public int delete(int id) {
		return linkManDao.delete(id);
	}

}
