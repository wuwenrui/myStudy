package com.wwr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wwr.dao.SaleChanceDao;
import com.wwr.entity.SaleChance;
import com.wwr.service.SaleChanceService;
/**
 * 销售机会service接口实现类
 * @author Administrator
 *
 */
@Service("saleChanceService")
public class SaleChanceServiceImpl implements SaleChanceService{

	@Resource
	private SaleChanceDao saleChanceDao;
	
	@Override
	public List<SaleChance> find(Map<String, Object> map) {
		return saleChanceDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return saleChanceDao.getTotal(map);
	}

	@Override
	public int add(SaleChance saleChance) {
		return saleChanceDao.add(saleChance);
	}

	@Override
	public int update(SaleChance saleChance) {
		return saleChanceDao.update(saleChance);
	}

	@Override
	public int delete(Integer id) {
		return saleChanceDao.delete(id);
	}

	@Override
	public SaleChance findById(Integer id) {
		return saleChanceDao.findById(id);
	}

}
