package com.wwr.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wwr.dao.OrderDao;
import com.wwr.entity.Order;
import com.wwr.service.OrderService;
/**
 * 订单service实现类
 * @author wuwenrui
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Resource
	private OrderDao orderDao;
	
	
	public List<Order> find(Map<String, Object> map) {
		return orderDao.find(map);
	}

	
	public Long getTotal(Map<String, Object> map) {
		return orderDao.getTotal(map);
	}

	
	public Order findById(Integer Id) {
		return orderDao.findById(Id);
	}

	
	public Order getLastOrderTime(Integer cusId) {
		return orderDao.getLastOrderTime(cusId);
	}

}
