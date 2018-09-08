package org.lanqiao.bean;

public class UserTemp {
	String userId ;
	String userName;
	String password;
	String roleName ;
	
	@Override
	public String toString() {
		return "UserTemp [userId=" + userId + ", userName=" + userName + ", password=" + password + ", roleName="
				+ roleName + "]";
	}
	public UserTemp() {
		super();
	}
	public UserTemp(String userId, String userName, String password, String roleName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.roleName = roleName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
