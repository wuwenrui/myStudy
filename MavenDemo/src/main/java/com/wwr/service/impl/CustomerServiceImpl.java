package com.wwr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wwr.dao.CustomerDao;
import com.wwr.dao.CustomerLossDao;
import com.wwr.dao.OrderDao;
import com.wwr.entity.Customer;
import com.wwr.entity.CustomerLoss;
import com.wwr.entity.Order;
import com.wwr.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Resource
	private CustomerDao customerDao;
	
	@Resource
	private CustomerLossDao customerLossDao;
	
	@Resource
	private OrderDao        orderDao;
	
	
	public List<Customer> find(Map<String, Object> map) {
		return customerDao.find(map);
	}

	
	public Long getTotal(Map<String, Object> map) {
		return customerDao.getTotal(map);
	}

	
	public int add(Customer customer) {
		return customerDao.add(customer);
	}

	
	public int update(Customer customer) {
		return customerDao.update(customer);
	}

	
	public int delete(Integer id) {
		return customerDao.delete(id);
	}

	
	public Customer findById(Integer id) {
		return customerDao.findById(id);
	}

	
	public List<Customer> getCustomerLoss() {
		return customerDao.getCustomerLoss();
	}

	
	public void checkCustomerLoss(){
		List<Customer> customerList = customerDao.getCustomerLoss();
		for(Customer c:customerList){
			CustomerLoss cus = new CustomerLoss();
			cus.setCusNo(c.getKhno());  //客户编号
			cus.setCusName(c.getName()); //客户名称
			cus.setCusManager(c.getCusManager());  //客户经理
			Order order = orderDao.getLastOrderTime(c.getId()); //获取客户最后下单实体
			if(order==null){
				cus.setLastOrderTime(null);
			}else{
				cus.setLastOrderTime(order.getOrderDate());
			}
			customerLossDao.add(cus);	//添加到流失客户
			/**
			 * 添加完成之后修改客户表中状态，1的话是客户流失，如果客户六个月没下单且没流失（状态为0），则添加到
			 * 客户流失表，此时如果进修改客户流失状态，则会一直添加相同的数据。
			 */
			c.setState(1);
			customerDao.update(c);
		}
	}
	
}
