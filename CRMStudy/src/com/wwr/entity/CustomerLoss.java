package com.wwr.entity;

import java.util.Date;

public class CustomerLoss {

	private Integer id;   //编号
	private String  cusNo;//客户编号
	private String  cusName; //客户名称
	private String  cusManager; //客户经理
	private Date    lastOrderTime;  //上次下单时间
	private Date    confirmLossTime;  //确认流失时间
	private Integer  state;			//状态    0 暂缓流失   1 确认流失
	private String    lossreason;   //流失原因
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCusNo() {
		return cusNo;
	}
	public void setCusNo(String cusNo) {
		this.cusNo = cusNo;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusManager() {
		return cusManager;
	}
	public void setCusManager(String cusManager) {
		this.cusManager = cusManager;
	}
	public Date getLastOrderTime() {
		return lastOrderTime;
	}
	public void setLastOrderTime(Date lastOrderTime) {
		this.lastOrderTime = lastOrderTime;
	}
	public Date getConfirmLossTime() {
		return confirmLossTime;
	}
	public void setConfirmLossTime(Date confirmLossTime) {
		this.confirmLossTime = confirmLossTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getLossreason() {
		return lossreason;
	}
	public void setLossreason(String lossreason) {
		this.lossreason = lossreason;
	}
	
	
}
