package com.wwr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwr.entity.PageBean;
import com.wwr.entity.Product;
import com.wwr.service.ProductService;
import com.wwr.util.ResponseUtil;
import com.wwr.util.StringUtil;

import net.sf.json.JSONObject;
/**
 * 产品controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Resource
	private ProductService productService;
	/**
	 * 分页查询产品
	 * @param page
	 * @param rows
	 * @param s_product
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page")String page,@RequestParam(value="rows")String rows,Product s_product,HttpServletResponse response)throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("productName",StringUtil.formatLike(s_product.getProductName()));
		map.put("start",pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Product> productList = productService.find(map);
		Long total = productService.getTotal(map);
		JSONObject result = new JSONObject();
		result.put("rows",productList);
		result.put("total",total);
		ResponseUtil.write(response, result);
		return null;
	}
	
}
