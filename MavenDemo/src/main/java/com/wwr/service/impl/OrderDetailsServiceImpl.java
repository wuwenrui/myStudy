package com.wwr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wwr.dao.OrderDetailsDao;
import com.wwr.entity.OrderDetails;
import com.wwr.service.OrderDetailsService;

/**
 * 订单明细service接口实现类
 * @author wuwenrui
 *
 */
@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Resource
	private OrderDetailsDao orderDetailsDao;
	
	
	public List<OrderDetails> find(Map<String, Object> map) {
		return orderDetailsDao.find(map);
	}

	
	public Long getTotal(Map<String, Object> map) {
		return orderDetailsDao.getTotal(map);
	}

	
	public float getTotalPriceByOrderId(Integer orderId) {
		return orderDetailsDao.getTotalPriceByOrderId(orderId);
	}

}
