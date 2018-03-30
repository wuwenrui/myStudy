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
import com.wwr.entity.Contact;
import com.wwr.service.ContactService;
import com.wwr.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import net.sf.json.JsonConfig;

/**
 * 交往记录控制类
 * @author wuwenrui
 *
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

	@Resource
	private ContactService contactService;
	
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
	 * 查询交往记录列表
	 * @param cusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="cusId",required=false)String cusId,HttpServletResponse response)throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cusId", cusId);
		List<Contact> list = contactService.find(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"customer"});//排除掉customer，否则会报错
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 保存或修改交往记录信息
	 * @param contact
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Contact contact,HttpServletResponse response)throws Exception{
		int resultTotal = 0;
		if(contact.getId()==null){
			resultTotal = contactService.add(contact);
		}else{
			resultTotal = contactService.update(contact);
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
	 * 删除交往记录
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		contactService.delete(Integer.parseInt(id));
		JSONObject result = new JSONObject();
		result.put("seccess", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
}
