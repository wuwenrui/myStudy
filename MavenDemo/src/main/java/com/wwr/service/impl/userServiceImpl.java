package com.wwr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wwr.dao.UserDao;
import com.wwr.entity.User;
import com.wwr.service.UserService;

/**
 * UserService实现类
 * @author wwr
 *
 */
//注解注入userService  controller需要用
@Service("userService")
public class userServiceImpl implements UserService{

	@Resource
	private UserDao userDao;

	
	public User login(User user) {
		return userDao.login(user);
	}

	
	public List<User> find(Map<String, Object> map) {
		return userDao.find(map);
	}

	
	public Long getTotal(Map<String, Object> map) {
		return userDao.getTotal(map);
	}

	
	public int add(User user) {
		return userDao.add(user);
	}

	
	public int update(User user) {
		return userDao.update(user);
	}

	
	public int delete(Integer id) {
		return userDao.delete(id);
	}
	
}
