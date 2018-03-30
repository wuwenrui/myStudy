package com.wwr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwr.entity.CustomerReprieve;
import com.wwr.service.CustomerReprieveService;
import com.wwr.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 客户流失暂缓措施控制类
 * @author wuwenrui
 *
 */
@Controller
@RequestMapping("/customerReprieve")
public class CustomerReprieveController {

	@Resource
	private CustomerReprieveService customerReprieveService;
	
	/**
	 * 查询客户流失暂缓措施列表
	 * @param cusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="lossId",required=false)String lossId,HttpServletResponse response)throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("lossId", lossId);
		List<CustomerReprieve> list = customerReprieveService.find(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"customerLoss"});//排除掉customerLoss，否则会报错
		JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 保存或修改客户流失暂缓措施信息
	 * @param customerReprieve
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(CustomerReprieve customerReprieve,HttpServletResponse response)throws Exception{
		int resultTotal = 0;
		if(customerReprieve.getId()==null){
			resultTotal = customerReprieveService.add(customerReprieve);
		}else{
			resultTotal = customerReprieveService.update(customerReprieve);
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
	 * 删除客户流失暂缓措施
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		customerReprieveService.delete(Integer.parseInt(id));
		JSONObject result = new JSONObject();
		result.put("seccess", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
}
