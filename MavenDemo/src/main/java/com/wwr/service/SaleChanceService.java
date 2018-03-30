package com.wwr.service;

import java.util.List;
import java.util.Map;

import com.wwr.entity.SaleChance;
/**
 * 销售机会Service接口
 * @author Administrator
 *
 */
public interface SaleChanceService {

	/**
	 * 查询销售机会集合
	 * @param map
	 * @return
	 */
	public List<SaleChance> find(Map<String,Object> map);
	/**
	 * 查询总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	/**
	 * 添加销售机会
	 * @param saleChance
	 * @return
	 */
	public int add(SaleChance saleChance);
	/**
	 * 修改销售机会
	 * @param saleChance
	 * @return
	 */
	public int update(SaleChance saleChance);
	/**
	 * 删除销售机会
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	/**
	 * 通过id查找销售机会
	 * @param id
	 * @return
	 */
	public SaleChance findById(Integer id);
}
