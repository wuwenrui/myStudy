package com.wwr.dao;

import java.util.List;
import java.util.Map;

import com.wwr.entity.Order;
/**
 * 订单dao接口
 * @author wuwenrui
 *
 */
public interface OrderDao {

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
	
}
