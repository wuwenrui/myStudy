package com.wwr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwr.entity.Customer;
import com.wwr.entity.PageBean;
import com.wwr.service.CustomerService;
import com.wwr.util.DateUtil;
import com.wwr.util.ResponseUtil;
import com.wwr.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Resource
	private CustomerService customerService;
	
	
	@RequestMapping("/list")
	public String list(@RequestParam(value="page")String page,@RequestParam(value="rows")String rows,Customer s_customer,HttpServletResponse response)throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("khno", StringUtil.formatLike(s_customer.getKhno()));
		map.put("name", StringUtil.formatLike(s_customer.getName()));
		map.put("size", pageBean.getPageSize());
		map.put("start",pageBean.getStart());
		List<Customer> list = customerService.find(map);
		Long total = customerService.getTotal(map);
		JSONObject result = new JSONObject();
		result.put("rows",list);
		result.put("total",total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 添加或者修改客户信息
	 * @param customer
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Customer customer,HttpServletResponse response)throws Exception{
		int resultTotal = 0;
		if(customer.getId()==null){
			customer.setKhno("KH"+DateUtil.getCurrentDateStr());
			resultTotal=customerService.add(customer);
		}else{
			resultTotal=customerService.update(customer);
		}
		JSONObject result = new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 删除客户数据
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		int resultTotal = 0;
		String[] idsStr = ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			resultTotal = customerService.delete(Integer.parseInt(idsStr[i]));
		}
		JSONObject jsonObject = new JSONObject();
		if(resultTotal>0){
			jsonObject.put("success", true);
		}else{
			jsonObject.put("success", false);
		}
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	/**
	 * 根据id查询客户
	 * @param cusId
	 * @return
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id")String cusId,HttpServletResponse response)throws Exception{
		Customer customer = customerService.findById(Integer.parseInt(cusId));
		JSONObject jsonObject = JSONObject.fromObject(customer);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	
}
