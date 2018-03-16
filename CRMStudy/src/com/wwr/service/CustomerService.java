package com.wwr.service;

import java.util.List;
import java.util.Map;

import com.wwr.entity.Customer;

public interface CustomerService {

	/**
	 * 查询客户集合
	 * @param map
	 * @return
	 */
	public List<Customer> find(Map<String,Object> map);
	/**
	 * 获取最大记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	/**
	 * 添加客户信息
	 * @param customer
	 * @return
	 */
	public int add(Customer customer);
	/**
	 * 修改客户信息
	 * @param customer
	 * @return
	 */
	public int update(Customer customer);
	/**
	 * 删除客户
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	/**
	 * 根据id查询客户
	 * @param id
	 * @return
	 */
	public Customer findById(Integer id);
}
