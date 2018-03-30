package com.wwr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wwr.dao.ContactDao;
import com.wwr.entity.Contact;
import com.wwr.service.ContactService;

/**
 * 交往记录Service接口实现类
 * @author wuwenrui
 *
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService{

	@Resource
	private ContactDao contactDao;

	public List<Contact> find(Map<String, Object> map) {
		return contactDao.find(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return contactDao.getTotal(map);
	}

	public Integer add(Contact contact) {
		return contactDao.add(contact);
	}

	public Integer update(Contact contact) {
		return contactDao.update(contact);
	}

	public Integer delete(Integer id) {
		return contactDao.delete(id);
	}
	
}
