package com.wwr.dao;

import java.util.List;
import java.util.Map;

import com.wwr.entity.CusDevPlan;



/**
 * 开发计划管理dao
 * @author wuwenrui
 *
 */
public interface CusDevPlanDao {

	/**
	 * 查询开发计划集合
	 * @param map
	 * @return
	 */
	public List<CusDevPlan> find(Map<String,Object> map);
	/**
	 * 增加开发计划
	 * @param cusDevPlan
	 * @return
	 */
	public int add(CusDevPlan cusDevPlan); 
	/**
	 * 修改开发计划
	 * @param cusDevPlan
	 * @return
	 */
	public int update(CusDevPlan cusDevPlan);
	/**
	 * 删除开发计划
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
}
