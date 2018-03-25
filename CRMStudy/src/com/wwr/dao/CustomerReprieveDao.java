package com.wwr.dao;

import java.util.List;
import java.util.Map;

import com.wwr.entity.CustomerReprieve;


/**
 * 客户流失暂缓措施dao接口
 * @author wuwenrui
 *
 */
public interface CustomerReprieveDao {
	/**
	 * 查询客户流失暂缓措施集合
	 * @param map
	 * @return
	 */
	public List<CustomerReprieve> find(Map<String,Object> map);
	/**
	 * 或许客户流失暂缓措施最高记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	/**
	 * 添加客户流失暂缓措施
	 * @param customerReprieve
	 */
	public int add(CustomerReprieve customerReprieve);
	/**
	 * 修改客户流失暂缓措施
	 * @param customerReprieve
	 * @return
	 */
	public int update(CustomerReprieve customerReprieve);
	/**
	 * 删除客户流失暂缓措施
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	
}
