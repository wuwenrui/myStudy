package com.wwr.dao;

import java.util.List;
import java.util.Map;

import com.wwr.entity.OrderDetails;

/**
 * 订单明细dao接口
 * @author wuwenrui
 *
 */
public interface OrderDetailsDao {

	/**
	 * 分页查询订单明细
	 * @param map
	 * @return
	 */
	public List<OrderDetails> find(Map<String,Object> map);
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	/**
	 * 获取订单明细的总金额
	 * @param orderId
	 * @return
	 */
	public float getTotalPriceByOrderId(Integer orderId);
	
}
