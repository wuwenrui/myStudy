package com.wwr.entity;

import java.util.Date;
/**
 * 交往记录实体类
 * @author wuwenrui
 *
 */
public class Contact {

	private Integer id;	//id
	private Customer customer; //客户关联
	private Date contactTime;  //交往时间
	private String address;    //地址
	private String overview;   //概要
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getContactTime() {
		return contactTime;
	}
	public void setContactTime(Date contactTime) {
		this.contactTime = contactTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	
}
