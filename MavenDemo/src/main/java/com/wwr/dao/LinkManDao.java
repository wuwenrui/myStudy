package com.wwr.dao;

import java.util.List;
import java.util.Map;

import com.wwr.entity.LinkMan;


/**
 * 联系人Dao接口
 * @author wuwenrui
 *
 */
public interface LinkManDao {
	/**
	 * 根据条件查询联系人集合
	 * @param map
	 */
	public List<LinkMan> find(Map<String,Object> map);
	/**
	 * 根据条件查询联系人总数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	/**
	 * 添加联系人
	 * @param linkMan
	 * @return
	 */
	public Integer add(LinkMan linkMan);
	/**
	 * 修改联系人
	 * @param linkMan
	 * @return
	 */
	public Integer update(LinkMan linkMan);
	/**
	 * 删除联系人
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	
}
