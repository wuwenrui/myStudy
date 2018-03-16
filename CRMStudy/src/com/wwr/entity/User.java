package com.wwr.entity;
/**
 * 用户实体
 * @author wwr
 *
 */
public class User {
	
	private Integer id; //用户编号
	private String userName; //用户名
	private String password; //用户密码
	private String trueName; //真实姓名
	private String email;	//邮箱
	private String phone;	//手机号
	private String roleName; //角色名称:系统管理员、销售主管、客户经理、高管
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
