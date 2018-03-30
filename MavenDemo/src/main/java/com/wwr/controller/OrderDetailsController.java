package com.wwr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwr.entity.OrderDetails;
import com.wwr.entity.PageBean;
import com.wwr.service.OrderDetailsService;
import com.wwr.util.ResponseUtil;
import com.wwr.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 联系人控制类
 * @author wuwenrui
 *
 */
@Controller
@RequestMapping("/orderDetails")
public class OrderDetailsController {

	@Resource
	private OrderDetailsService orderDetailsService;
	
	/**
	 * 查询联系人列表
	 * @param cusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,@RequestParam(value="orderId",required=false)String orderId,HttpServletResponse response)throws Exception{
		if(StringUtil.isEmpty(orderId)){
			return null;
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderId", orderId);
		map.put("start", pageBean.getPage());
		map.put("size", pageBean.getPageSize());
		List<OrderDetails> list = orderDetailsService.find(map);
		Long total = orderDetailsService.getTotal(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(list);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 根据订单编号或许订单总金额
	 * @param orderId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTotalPrice")
	public String getTotalPrice(@RequestParam(value="orderId")String orderId,HttpServletResponse response)throws Exception{
		float sum = orderDetailsService.getTotalPriceByOrderId(Integer.parseInt(orderId));
		JSONObject jsonObject =new JSONObject();
		jsonObject.put("totalMoney", sum);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	
}
