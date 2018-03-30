package com.wwr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wwr.dao.CusDevPlanDao;
import com.wwr.entity.CusDevPlan;
import com.wwr.service.CusDevPlanService;
/**
 * 开发计划service实现类
 * @author wuwenrui
 *
 */
@Service("cusDevPlanService")
public class CusDevPlanServiceImpl implements CusDevPlanService{

	@Resource
	private CusDevPlanDao cusDevPlanDao;
	
	public List<CusDevPlan> find(Map<String, Object> map) {
		return cusDevPlanDao.find(map);
	}

	public int add(CusDevPlan cusDevPlan) {
		return cusDevPlanDao.add(cusDevPlan);
	}

	public int update(CusDevPlan cusDevPlan) {
		return cusDevPlanDao.update(cusDevPlan);
	}

	public int delete(Integer id) {
		return cusDevPlanDao.delete(id);
	}

}
