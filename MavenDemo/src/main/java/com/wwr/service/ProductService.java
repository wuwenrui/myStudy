package com.wwr.service;

import java.util.List;
import java.util.Map;

import com.wwr.entity.Product;
/**
 * productService接口
 * @author Administrator
 *
 */
public interface ProductService {
	
	/**
	 * 查询产品集合
	 * @param map
	 * @return
	 */
	public List<Product> find(Map<String,Object> map);
	/**
	 * 获取最大记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
}
