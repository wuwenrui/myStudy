package com.wwr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wwr.dao.DataDicDao;
import com.wwr.entity.DataDic;
import com.wwr.service.DataDicService;
/**
 * DataDicService接口实现类
 * @author Administrator
 *
 */
@Service("dataDicService")
public class DataDicServiceImpl implements DataDicService{

	@Resource
	private DataDicDao dataDicDao;
	
	
	public List<DataDic> find(Map<String, Object> map) {
		return dataDicDao.find(map);
	}

	
	public List<DataDic> findAll() {
		return dataDicDao.findAll();
	}

	
	public Long getTotal(Map<String, Object> map) {
		return dataDicDao.getTotal(map);
	}

	
	public int add(DataDic dataDic) {
		return dataDicDao.add(dataDic);
	}

	
	public int update(DataDic dataDic) {
		return dataDicDao.update(dataDic);
	}

	
	public int delete(Integer id) {
		return dataDicDao.delete(id);
	}

}
