package bean;

import java.io.Serializable;

public class Identity implements Serializable{
	private String username;
	private int status;//1是用户、2是管理员、3是游客,4是超级管理员
	public Identity(){
		this.status=3;
		this.username="游客";
	}
	public boolean canEdit(String author) {
		if(this.username.equals(author)||this.isAdmin()) {
			return true;
		}
		else return false;
	}
	public boolean isVisitors() {
		if(this.status==3)return true;
		else return false;
	}

	public boolean isRoot() {
		if(this.status==4)return true;
		else return false;
	}
	public boolean isAdmin() {
		if(this.status==2||this.status==4)return true;
		else return false;
	}
	public Identity(String username, int status) {
		super();
		this.username = username;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}	
