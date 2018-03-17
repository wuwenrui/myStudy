package com.wwr.service;

import java.util.List;
import java.util.Map;

import com.wwr.entity.Contact;

/**
 * 交往记录Service接口
 * @author wuwenrui
 *
 */
public interface ContactService {
	/**
	 * 根据条件查询交往记录集合
	 * @param map
	 */
	public List<Contact> find(Map<String,Object> map);
	/**
	 * 根据条件查询交往记录总数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	/**
	 * 添加交往记录
	 * @param contact
	 * @return
	 */
	public Integer add(Contact contact);
	/**
	 * 修改交往记录
	 * @param contact
	 * @return
	 */
	public Integer update(Contact contact);
	/**
	 * 删除交往记录
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	
}
