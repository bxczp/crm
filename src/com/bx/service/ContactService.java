package com.bx.service;

import java.util.List;
import java.util.Map;

import com.bx.entity.Contact;

/**
 * @date 2016年3月29日 ContactService.java
 * @author CZP
 * @parameter
 */
public interface ContactService {

	public List<Contact> find(Map<String, Object> map);

	public long getListCount(Map<String, Object> map);

	public int add(Contact contact);

	public int update(Contact contact);

	public int delete(Integer id);

}
