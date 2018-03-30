package com.wwr.service;

import java.util.List;
import java.util.Map;

import com.wwr.entity.User;

/**
 * userservice接口
 * @author wwr
 *
 */
public interface UserService {

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public abstract User login(User user);
	/**
	 * 查询用户集合
	 * @param map
	 * @return
	 */
	public List<User> find(Map<String,Object> map);
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int add(User user);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public int update(User user);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
}
