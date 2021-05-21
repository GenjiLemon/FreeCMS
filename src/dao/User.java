package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.EssayBean;
import bean.UserBean;
public class User extends DbConn{
	
	
	public ArrayList<UserBean> getAllUser(){
		String sql="select uid,username,password from user ";
		ArrayList<UserBean> list=new ArrayList<UserBean>();
		ResultSet res=this.DbSelect(sql);
		try {
			while(res.next()) {
				int uid=res.getInt("uid");
				String username=res.getString("username");
				String password=res.getString("password");
				UserBean node=new UserBean(uid,username,password);
				list.add(node);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<UserBean> getUser(int status){
		if(status==4)return this.getAllUser();
		String sql="select uid,username,password from user where status=1";
		ArrayList<UserBean> list=new ArrayList<UserBean>();
		ResultSet res=this.DbSelect(sql);
		try {
			while(res.next()) {
				int uid=res.getInt("uid");
				String username=res.getString("username");
				String password=res.getString("password");
				UserBean node=new UserBean(uid,username,password);
				list.add(node);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int getStatus(String username) {
		String sql="select status from user where username = '"+username+"'";
		int ret=3;
		ResultSet res;
		if((res=DbSelect(sql))!=null) {
			try {
				res.next();
				ret=res.getInt("status");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return ret;
		
	}
//	public String getPassword(String username) {
//		String sql="select password from user where username = '"+username+"'";
//		String ret=null;
//		ResultSet res;
//		if((res=DbSelect(sql))!=null) {
//			try {
//				res.next();
//				ret=res.getString("password");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		return ret;
//	}
	public boolean update(UserBean user) {
		String sql="update user set username='"+user.getUsername()+"' ,password='"+user.getPassword()+"' ,status="+user.getStatus()+ "  where uid="+user.getUid();
	
		int res=this.DbChange(sql);
		if(res==1)return true;
		else return false;
	}
	public boolean delete(int uid) {
		String sql="delete from user where uid="+uid;
		int res=this.DbChange(sql);
		if(res==1)return true;
		else return false;
	}
	public boolean add(UserBean user) {
		String sql="insert into user (username,password,status) values ('"+user.getUsername()+"','"+user.getPassword()+"',"+user.getStatus()+")";
		int res=this.DbChange(sql);
		if(res==1)return true;
		else return false;
	}
	public UserBean find(String username) {
		String sql="select uid,username,password from user where username='"+username+"'";
		UserBean user=null;
		ResultSet res=this.DbSelect(sql);
		try {
			if(res.next()) {
				user=new UserBean(res.getInt("uid"),res.getString("username"),res.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public UserBean find(int uid) {
		String sql="select uid,username,password from user where uid="+uid+"";
		
		UserBean user=null;
		ResultSet res=this.DbSelect(sql);
		try {
			if(res.next()) {
				user=new UserBean(res.getInt("uid"),res.getString("username"),res.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
