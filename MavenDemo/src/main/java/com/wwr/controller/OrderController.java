package com.wwr.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwr.entity.Order;
import com.wwr.entity.PageBean;
import com.wwr.service.OrderService;
import com.wwr.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 订单控制类
 * @author wuwenrui
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	private OrderService orderService;
	
	/**
	 * 数据初始化绑定：SpringMVC中，数据从前台过来会将字符串转换为日期对象
	 * @param binder
	 */
	 @InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，日期可以为空，false:不能为空值
	}
	 /**
	  * 分页查询订单
	  * @param page
	  * @param rows
	  * @param cusId
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/list")
	 public String list(@RequestParam(value="page")String page,@RequestParam(value="rows")String rows,@RequestParam(value="cusId",required=false)String cusId,HttpServletResponse response)throws Exception{
		 PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("start", pageBean.getStart());
		 map.put("size", pageBean.getPageSize());
		 map.put("cusId", Integer.parseInt(cusId));
		 List<Order> list = orderService.find(map);
		 Long total = orderService.getTotal(map);
		 JsonConfig jsonConfig = new JsonConfig();
		 jsonConfig.setExcludes(new String[]{"customer"});
		 jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		 JSONObject result = new JSONObject();
		 JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		 result.put("rows",jsonArray);
		 result.put("total", total);
		 ResponseUtil.write(response, result);
		 return null;
	 }
	 
	 /**
	  * 根据id查找实体
	  * @param id
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("findById")
	 public String findById(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		 Order order = orderService.findById(Integer.parseInt(id));
		 JsonConfig jsonConfig = new JsonConfig();
		 jsonConfig.setExcludes(new String[]{"customer"});
		 jsonConfig.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor("yyyy-MM-dd"));
		 JSONObject jsonObject = JSONObject.fromObject(order,jsonConfig);
		 ResponseUtil.write(response, jsonObject);
		 return null;
	 }
	
}
