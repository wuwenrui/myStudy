package com.wwr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wwr.dao.CustomerDao;
import com.wwr.dao.CustomerLossDao;
import com.wwr.dao.OrderDao;
import com.wwr.entity.Customer;
import com.wwr.entity.CustomerLoss;
import com.wwr.entity.Order;
import com.wwr.service.CustomerLossService;
/**
 * 客户流失service接口实现类
 * @author wuwenrui
 *
 */
@Service("customerLossService")
public class CustomerLossServiceImpl implements CustomerLossService{

	@Resource
	private CustomerLossDao customerLossDao;
	
	@Override
	public List<CustomerLoss> find(Map<String, Object> map) {
		return customerLossDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return customerLossDao.getTotal(map);
	}

	@Override
	public void add(CustomerLoss customerLoss) {
		customerLossDao.add(customerLoss);
	}

}
