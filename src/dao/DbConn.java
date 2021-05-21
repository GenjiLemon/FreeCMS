package dao;

import java.io.Serializable;
import java.sql.*;

public class DbConn implements Serializable{
	private String url = "jdbc:mysql://106.13.1.69:3306/CMS?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf-8";
	private String username = "CMS";
	private String psw = "CMS";
	private static Connection conn;
	private  static Statement state;

	public DbConn() {
		if (state == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, username, psw);
				state = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public  ResultSet DbSelect(String sql) {
		ResultSet res = null;
		try {
			res = state.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public int DbChange(String sql) {
		int resline = 0 ;
		try {
			resline = state.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resline;
	}

	public void Destory() {
		try {
			this.state.close();
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
