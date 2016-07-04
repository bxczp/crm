package com.bx.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.ContactDao;
import com.bx.entity.Contact;
import com.bx.service.ContactService;

/**
 * @date 2016年3月29日 ContactServiceImpl.java
 * @author CZP
 * @parameter
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService {
	@Resource
	private ContactDao contactDao;

	@Override
	public List<Contact> find(Map<String, Object> map) {
		return contactDao.find(map);
	}

	@Override
	public long getListCount(Map<String, Object> map) {
		return contactDao.getListCount(map);
	}

	@Override
	public int add(Contact contact) {
		return contactDao.add(contact);
	}

	@Override
	public int update(Contact contact) {
		return contactDao.update(contact);
	}

	@Override
	public int delete(Integer id) {
		return contactDao.delete(id);
	}

}
