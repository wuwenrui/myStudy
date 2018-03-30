package com.wwr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wwr.dao.CustomerReprieveDao;
import com.wwr.entity.CustomerReprieve;
import com.wwr.service.CustomerReprieveService;
/**
 * 客户流失暂缓措施Service实现类
 * @author wuwenrui
 *
 */
@Service("customerReprieveService")
public class CustomerReprieveServiceImpl implements CustomerReprieveService{

	@Resource
	private CustomerReprieveDao customerReprieveDao;
	
	public List<CustomerReprieve> find(Map<String, Object> map) {
		return customerReprieveDao.find(map);
	}

	
	public Long getTotal(Map<String, Object> map) {
		return customerReprieveDao.getTotal(map);
	}

	
	public int add(CustomerReprieve customerReprieve) {
		return customerReprieveDao.add(customerReprieve);
	}

	
	public int update(CustomerReprieve customerReprieve) {
		return customerReprieveDao.update(customerReprieve);
	}

	
	public int delete(Integer id) {
		return customerReprieveDao.delete(id);
	}

}
