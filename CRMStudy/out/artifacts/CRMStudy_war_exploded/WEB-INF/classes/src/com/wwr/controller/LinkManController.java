package com.wwr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwr.entity.LinkMan;
import com.wwr.service.LinkManService;
import com.wwr.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 联系人控制类
 * @author wuwenrui
 *
 */
@Controller
@RequestMapping("/linkMan")
public class LinkManController {

	@Resource
	private LinkManService linkManService;
	
	/**
	 * 查询联系人列表
	 * @param cusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="cusId",required=false)String cusId,HttpServletResponse response)throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cusId", cusId);
		List<LinkMan> list = linkManService.find(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"customer"});//排除掉customer，否则会报错
		JSONArray jsonArray = JSONArray.fromObject(list);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 保存或修改联系人信息
	 * @param linkMan
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(LinkMan linkMan,HttpServletResponse response)throws Exception{
		int resultTotal = 0;
		if(linkMan.getId()==null){
			resultTotal = linkManService.add(linkMan);
		}else{
			resultTotal = linkManService.update(linkMan);
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
	 * 删除联系人
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		linkManService.delete(Integer.parseInt(id));
		JSONObject result = new JSONObject();
		result.put("seccess", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
}
