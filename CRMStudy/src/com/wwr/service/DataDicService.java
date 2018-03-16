package com.wwr.service;

import java.util.List;
import java.util.Map;

import com.wwr.entity.DataDic;
/**
 * DataDicService接口
 * @author Administrator
 *
 */
public interface DataDicService {
	
	/**
	 * 查询数据字典集合
	 * @param map
	 * @return
	 */
	public List<DataDic> find(Map<String,Object> map);
	/**
	 * 查询所有数据字典名称
	 * @return
	 */
	public List<DataDic> findAll();
	/**
	 * 查询总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	/**
	 * 添加数据字典
	 * @param dataDic
	 * @return
	 */
	public int add(DataDic dataDic);
	/**
	 * 修改数据字典
	 * @param dataDic
	 * @return
	 */
	public int update(DataDic dataDic);
	/**
	 * 删除数据字典
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
}
