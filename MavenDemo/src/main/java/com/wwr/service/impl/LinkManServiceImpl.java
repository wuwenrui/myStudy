package com.wwr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wwr.dao.LinkManDao;
import com.wwr.entity.LinkMan;
import com.wwr.service.LinkManService;

/**
 * 联系人Service接口实现类
 * @author wuwenrui
 *
 */
@Service("linkManService")
public class LinkManServiceImpl implements LinkManService{

	@Resource
	private LinkManDao linkManDao;
	
	
	public List<LinkMan> find(Map<String, Object> map) {
		return linkManDao.find(map);
	}

	
	public Long getTotal(Map<String, Object> map) {
		return linkManDao.getTotal(map);
	}

	
	public Integer add(LinkMan linkMan) {
		return linkManDao.add(linkMan);
	}

	
	public Integer update(LinkMan linkMan) {
		return linkManDao.update(linkMan);
	}

	
	public Integer delete(Integer id) {
		return linkManDao.delete(id);
	}
	
	
}
