package com.wwr.controller;

import java.lang.ProcessBuilder.Redirect;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wwr.entity.PageBean;
import com.wwr.entity.SaleChance;
import com.wwr.entity.User;
import com.wwr.service.SaleChanceService;
import com.wwr.util.ResponseUtil;
import com.wwr.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/**
 * 营销机会管理控制类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/saleChance")
public class SaleChanceController {

	@Resource
	private SaleChanceService saleChanceService;
	/**
	 * 数据初始化绑定：SpringMVC中，数据从前台过来会将字符串转换为日期对象
	 * @param binder
	 */
	 @InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，日期可以为空，false:不能为空值
	}
	
	/**
	 * 分页多条件查询销售机会集合
	 * @param page
	 * @param rows
	 * @param s_saleChance
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page")String page,@RequestParam(value="rows")String rows,SaleChance s_saleChance,HttpServletResponse response)throws Exception{
		/*HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		System.out.println("============================================");
		User user = (User) request.getSession().getAttribute("currentUser");
		System.out.println("============================================");
		if(user==null){
			System.err.println(request.getRequestURI());
			System.err.println(request.getContextPath()+"/user/login.do");
			//return ("http://localhost:8080"+request.getContextPath()+"/login");
			//return request.getContextPath()+"/login.jsp";
			return "redirect:/login.jsp";
		}*/
		
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("customerName", StringUtil.formatLike(s_saleChance.getCustomerName()));
		map.put("overView", StringUtil.formatLike(s_saleChance.getOverView()));
		map.put("createMan", StringUtil.formatLike(s_saleChance.getCreateMan()));
		map.put("state", s_saleChance.getState());
		map.put("devResult", s_saleChance.getDevResult());
		map.put("start",pageBean.getStart());
		map.put("size",pageBean.getPageSize());
		List<SaleChance> saleChanceList = saleChanceService.find(map);
		Long total = saleChanceService.getTotal(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		//进行格式转换的时候就可以将日期类型的过滤，转换为指定的字符串格式
		JSONArray jsonArray = JSONArray.fromObject(saleChanceList,jsonConfig);
		result.put("rows",jsonArray);
		result.put("total",total);
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 保存或修改销售机会
	 * @param s_saleChace
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	public String save(SaleChance saleChance,HttpServletResponse response)throws Exception{
		int resultTotal = 0;
		//由于参数中含有指派人，所以指派之后，此条记录的分配状态应该是已分配，否则是未分配
		if(StringUtil.isNotEmpty(saleChance.getAssignMan())){
			saleChance.setState(1);
		}else{
			saleChance.setState(0); //默认分分配状态为0：未分配
		}
		if(saleChance.getId()==null){
			saleChance.setDevResult(0); //添加的时候默认的是未开发状态
			resultTotal = saleChanceService.add(saleChance);
		}else{
			resultTotal = saleChanceService.update(saleChance);
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
	 * 删除销售机会
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
			resultTotal = saleChanceService.delete(Integer.parseInt(idsStr[i]));
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
	 * 通过id查询销售机会
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		SaleChance saleChance = saleChanceService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONObject result = JSONObject.fromObject(saleChance, jsonConfig);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 开发成功|开发失败方法
	 * @param id
	 * @param devResult
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateSalceChanceDev")
	public String updateSalceChanceDev(@RequestParam(value="id")String id,@RequestParam(value="devResult")String devResult,HttpServletResponse response)throws Exception{
		SaleChance saleChance = new SaleChance();
		saleChance.setId(Integer.parseInt(id));
		saleChance.setDevResult(Integer.parseInt(devResult));
		int resultTotal = saleChanceService.update(saleChance);
		JSONObject result = new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success",false);
		}
		ResponseUtil.write(response, result);
		return null;
		
	}
	
}
