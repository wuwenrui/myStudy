package com.wwr.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wwr.entity.Order;
/**
 * 订单Service接口
 * @author wuwenrui
 *
 */
public interface OrderService {

	/**
	 * 分页查询订单
	 * @param map
	 * @return
	 */
	public List<Order> find(Map<String,Object> map);
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * 根据id查找实体
	 * @param Id
	 * @return
	 */
	public Order findById(Integer Id);
	/**
	 * 根据客户id获取客户最后下单时间
	 * @param cusId
	 * @return
	 */
	public Order getLastOrderTime(Integer cusId);
}
