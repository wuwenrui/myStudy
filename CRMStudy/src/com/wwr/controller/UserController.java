package com.wwr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwr.entity.PageBean;
import com.wwr.entity.User;
import com.wwr.service.UserService;
import com.wwr.util.ResponseUtil;
import com.wwr.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 用户controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	/**
	 * 用户登录
	 * 业务逻辑实现：页面封装user到User对象，调service接口登录，将user传过去，返回resultUser，
	 * 对resultUser进行判断，如果为null，则登录失败，将用户信息回显到页面，返回登录页面
	 * 如果登录成功，用request对象获取session对象，将用户信息放在session中，重定向到主页
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request){
		User resultUser = userService.login(user);
		if(resultUser==null){
			request.setAttribute("user",user);
			request.setAttribute("errorMsg","用户名或密码错误！");
			return "login";
		}else{
			HttpSession session = request.getSession();
			//session.setMaxInactiveInterval(15);
			session.setAttribute("currentUser",resultUser);
			return "redirect:/main.jsp";
		}
	}
	/**
	 * 带条件的分页查询
	 * @param page    第几页
	 * @param pageSize 每页记录数
	 * @param response 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String pageSize,User s_user,HttpServletResponse response)throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(pageSize));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", StringUtil.formatLike(s_user.getUserName()));
		map.put("start",pageBean.getStart());
		map.put("size",pageBean.getPageSize());
		List<User> userList = userService.find(map);
		Long total = userService.getTotal(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(userList);
		result.put("rows",jsonArray);
		result.put("total",total);
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 获取客户经理信息:下拉框数据用到
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/customerManagerComboList")
	public String customerManagerComboList(HttpServletResponse response)throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleName","客户经理");
		List<User> userList = userService.find(map);
		JSONArray jsonArray = JSONArray.fromObject(userList);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
	
	/**
	 * 添加或者修改用户:如果获取的用户的id为null的话，那就是添加方法，否则是修改
	 * @param user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(User user,HttpServletResponse response)throws Exception{
		int resultTotal = 0; //定义操作的记录数
		if(user.getId()==null){
			resultTotal = userService.add(user);
		}else{
			resultTotal = userService.update(user);
		}
		JSONObject result = new JSONObject();
		if(resultTotal>0){
			result.put("success",true);
		}else{
			result.put("success",false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 删除用户
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		String []idsStr = ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			userService.delete(Integer.parseInt(idsStr[i]));
		}
		JSONObject result = new JSONObject();
		result.put("success",true);
		ResponseUtil.write(response, result);
		return null;
	}

}
