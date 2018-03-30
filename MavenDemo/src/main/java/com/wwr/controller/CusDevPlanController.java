package com.wwr.controller;

import com.wwr.entity.CusDevPlan;
import com.wwr.entity.SaleChance;
import com.wwr.service.CusDevPlanService;
import com.wwr.service.SaleChanceService;
import com.wwr.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 客户开发计划控制类
 * @author wuwenrui
 *
 */
@Controller
@RequestMapping("/cusDevPlan")
public class CusDevPlanController {

	@Resource
	private CusDevPlanService cusDevPlanService;
	
	@Resource
	private SaleChanceService saleChanceService;
	
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
	  * 查询开发计划集合
	  * @param saleChanceId
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/list")
	 public String list(@RequestParam(value="saleChanceId")String saleChanceId,HttpServletResponse response)throws Exception{
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("saleChanceId", saleChanceId);
		 List<CusDevPlan> list = cusDevPlanService.find(map);
		 JSONObject result = new JSONObject();
		 JsonConfig jsonConfig = new JsonConfig();
		 //将saleChance排除掉，不然会导致死循环:过滤不需要转换的属性
		 jsonConfig.setExcludes(new String[]{"saleChance"});
		 jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		 JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		 result.put("rows", jsonArray);
		 ResponseUtil.write(response, result);
		 return null;
	 }
	 /**
	  * 保存或修改开发计划
	  * @param cusDevPlan
	  * @param response
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/save")
	 public String save(CusDevPlan cusDevPlan,HttpServletResponse response)throws Exception{
		 int resultTotal = 0;  //影响的记录行数
		 if(cusDevPlan.getId()==null){
			 //进行开发时：此条销售机会状态应该修改为开发中
			 SaleChance saleChance = new SaleChance();
			 saleChance.setId(cusDevPlan.getSaleChance().getId());
			 saleChance.setDevResult(1);
			 saleChanceService.update(saleChance);
			 resultTotal = cusDevPlanService.add(cusDevPlan);
		 }else{
			 resultTotal = cusDevPlanService.update(cusDevPlan);
		 }
		 JSONObject result = new JSONObject();
		 if(resultTotal>0){
			 result.put("success", true);
		 }else{
			 result.put("success",false);
		 }
		 ResponseUtil.write(response, result);
		 return null;
	 }
	/**
	 * 删除客户开发计划
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping("delete")
	 public String delete(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		 cusDevPlanService.delete(Integer.parseInt(id));
		 JSONObject result = new JSONObject();
		 result.put("success",true);
		 ResponseUtil.write(response, result);
		 return null;
	 }
	 
}
