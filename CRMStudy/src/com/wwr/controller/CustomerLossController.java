package com.wwr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwr.entity.CustomerLoss;
import com.wwr.entity.PageBean;
import com.wwr.service.CustomerLossService;
import com.wwr.util.ResponseUtil;
import com.wwr.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/customerLoss")
public class CustomerLossController {

	@Resource
	private CustomerLossService customerLossService;
	
	/**
	 * 多条件分页查询客户流失记录
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,CustomerLoss s_customerLoss,HttpServletResponse response)throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("cusName", StringUtil.formatLike(s_customerLoss.getCusName()));
		map.put("cusManager", StringUtil.formatLike(s_customerLoss.getCusManager()));
		map.put("state", s_customerLoss.getState());
		List<CustomerLoss> list = customerLossService.find(map);
		Long total = customerLossService.getTotal(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		result.put("rows",jsonArray);
		result.put("total",total);
		ResponseUtil.write(response, result);
		return null;
	}
	
}
