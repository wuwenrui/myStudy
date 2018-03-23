package com.wwr.service;

import java.util.List;
import java.util.Map;

import com.wwr.entity.CustomerLoss;
/**
 * 客户流失service接口
 * @author wuwenrui
 *
 */
public interface CustomerLossService {

	/**
	 * 分条件查询客户流失集合
	 * @param map
	 * @return
	 */
	public List<CustomerLoss> find(Map<String,Object> map);
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	/**
	 * 客户流失添加
	 * @param customerLoss
	 */
	public int add(CustomerLoss customerLoss);
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public CustomerLoss findById(Integer id);
	/**
	 * 修改客户流失
	 * @param customerLoss
	 */
	public int update(CustomerLoss customerLoss);
	
}
