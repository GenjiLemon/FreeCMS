package bean;

import java.io.Serializable;
import dao.User;
public class UserBean implements Serializable {
	private int uid;
	private String username;
	private String password;
	private int status;//1用户，2管理，3游客
	public UserBean() {
		
	}
	
	public UserBean(int uid, String username, String password, int status) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.status=status;
	}

	public UserBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public UserBean(int uid, String username, String password) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
	}

	public UserBean(String username, String password,int status) {
		super();
		this.username = username;
		this.password = password;
		this.status=status;
	}
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void checkStatus() {
		this.status=new User().getStatus(this.username);
	}
	public boolean checkUsername() {
		if(new User().find(this.username)!=null) {
			return true;
		}
		return false;
	}
	public boolean checkPassword() {
		if(new User().find(this.username).getPassword().equals(this.password)) {
			return true;
		}
		return false;
	}
	public boolean create() {
		boolean res= new User().add(this);
		if(res) this.status=1;
		return res;
	}
	
	public boolean update() {
		return  new User().update(this);
		
		
	}
	
	public boolean delete() {
		return  new User().delete(this.uid);

		
	}
}
