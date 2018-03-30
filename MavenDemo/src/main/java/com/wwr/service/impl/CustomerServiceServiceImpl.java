package com.wwr.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wwr.dao.CustomerServiceDao;
import com.wwr.entity.CustomerService;
import com.wwr.service.CustomerServiceService;
/**
 * 客户服务Service实现类
 * @author wuwenrui
 *
 */
@Service("customerServiceService")
public class CustomerServiceServiceImpl implements CustomerServiceService{

	@Resource
	private CustomerServiceDao customerServcieDao;
	
	
	public int add(CustomerService customerService) {
		return customerServcieDao.add(customerService);
	}

}
