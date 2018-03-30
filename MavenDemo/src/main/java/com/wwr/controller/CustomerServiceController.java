package com.wwr.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wwr.entity.CustomerService;
import com.wwr.service.CustomerServiceService;
import com.wwr.util.ResponseUtil;

import net.sf.json.JSONObject;

/**
 * 客户服务控制类
 * @author wuwenrui
 *
 */
@Controller
@RequestMapping("/customerService")
public class CustomerServiceController {

	@Resource
	private CustomerServiceService customerServiceService;
	
	/**
	 * 保存或修改联系人信息
	 * @param CustomerService
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(CustomerService customerService,HttpServletResponse response)throws Exception{
		int resultTotal = 0;
		if(customerService.getId()==null){
			resultTotal = customerServiceService.add(customerService);
		}else{
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
	
}
