package com.wwr.controller;

import java.util.Date;
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
	/**
	 * 根据id查找客户流失信息
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		CustomerLoss customerLoss = customerLossService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject result = JSONObject.fromObject(customerLoss,jsonConfig);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 确认客户流失
	 * @param customerLoss
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/confirmLoss")
	public String confirmLoss(int id,String lossReason ,HttpServletResponse response)throws Exception{
		CustomerLoss customerLoss = new CustomerLoss();
		customerLoss.setId(id);
		customerLoss.setLossreason(lossReason);
		customerLoss.setConfirmLossTime(new Date());
		customerLoss.setState(1);
		int resultTotal = customerLossService.update(customerLoss);
		JSONObject result = new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
}
