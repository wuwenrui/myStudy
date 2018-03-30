package com.wwr.quartz;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wwr.service.CustomerService;

/**
 * 查询流失客户定时任务
 * @author wuwenrui
 *
 */
@Component
public class FindLossCustomerJob {

	@Resource
	private CustomerService customerService; //客户service
	
	@Scheduled(cron="0 0 2 * * ?")
	public void work(){
		customerService.checkCustomerLoss(); //将流失客户添加到客户流失表
	}
	
}
