package com.wwr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wwr.dao.ProductDao;
import com.wwr.entity.Product;
import com.wwr.service.ProductService;
/**
 * productService接口实现类
 * @author Administrator
 *
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Resource
	private  ProductDao productDao;
	
	
	public List<Product> find(Map<String, Object> map) {
		return productDao.find(map);
	}

	
	public Long getTotal(Map<String, Object> map) {
		return productDao.getTotal(map);
	}

}
