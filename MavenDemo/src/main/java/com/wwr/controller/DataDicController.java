package com.wwr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwr.entity.DataDic;
import com.wwr.entity.PageBean;
import com.wwr.service.DataDicService;
import com.wwr.util.ResponseUtil;
import com.wwr.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/dataDic")
public class DataDicController {

	@Resource
	private DataDicService dataDicService;
	/**
	 * 分页查询数据字典
	 * @param page
	 * @param rows
	 * @param s_dataDic
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page")String page,@RequestParam(value="rows")String rows,DataDic s_dataDic,HttpServletResponse response)throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("dataDicName",s_dataDic.getDataDicName());
		map.put("dataDicValue",StringUtil.formatLike(s_dataDic.getDataDicValue()));
		map.put("start",pageBean.getStart());
		map.put("size",pageBean.getPageSize());
		List<DataDic> dataDicList = dataDicService.find(map);
		Long total = dataDicService.getTotal(map);
		JSONObject result = new JSONObject();
		result.put("rows",dataDicList);
		result.put("total",total);
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 查询所有的数据字典名称
	 * @param response
	 * @return
	 * @throws Eception
	 */
	@RequestMapping("/findDataDicName")
	public String dataDicComboList(HttpServletResponse response)throws Exception{
		JSONArray jsonArray = new JSONArray();
		List<DataDic> dataDicList = dataDicService.findAll();
		JSONArray rows = JSONArray.fromObject(dataDicList);
		jsonArray.addAll(rows);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
	/**
	 * 添加或者修改数据字典
	 * @param dataDic
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(DataDic dataDic,HttpServletResponse response)throws Exception{
		int resultTotal = 0;
		if(dataDic.getId()==null){
			resultTotal = dataDicService.add(dataDic);
		}else{
			resultTotal = dataDicService.update(dataDic);
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
	 * 删除数据字典信息
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		String []idsStr = ids.split(",");
		int resultTotal = 0;
		for(int i=0;i<idsStr.length;i++){
			resultTotal = dataDicService.delete(Integer.parseInt(idsStr[i]));
		}
		JSONObject result = new JSONObject();
		if(resultTotal>0){
			result.put("success",true);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 根据名称查询数据
	 * @param dataDicName
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDicComList")
	public String getDicComList(@RequestParam(value="dataDicName")String dataDicName,HttpServletResponse response)throws Exception{
		JSONArray jsonArray = new JSONArray();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("dataDicName",dataDicName);
		List<DataDic> list = dataDicService.find(map);
		JSONArray rows = JSONArray.fromObject(list);
		jsonArray.addAll(rows);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
	
}
