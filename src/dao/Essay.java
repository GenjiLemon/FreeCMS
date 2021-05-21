package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.EssayBean;

public class Essay extends DbConn{
	public String getContent(String eid) {
		String sql="select content from essay where eid='"+eid+"'";
		ResultSet res = DbSelect(sql);
		String ret=null;
		try {
			res.next();
			ret=res.getString("content");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public ArrayList<EssayBean> getAllEaasy(){
		String sql="select eid,author,title from essay ";
		ResultSet res = DbSelect(sql);
		ArrayList<EssayBean> essayList=new ArrayList<EssayBean>();
		try {
			while(res.next()) {
				int eid=res.getInt("eid");
				String title=res.getString("title");
				String author =res.getString("author");
				EssayBean node=new EssayBean(eid,title,author);
				essayList.add(node);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return essayList;
	}
	public boolean update(EssayBean essay) {
		String sql="update essay set author ='"+essay.getAuthor()+"' ,title='"+essay.getTitle()+"' ,content='"+essay.getContent()+"' where eid="+essay.getEid();
		int res=this.DbChange(sql);
		if(res==1)return true;
		else return false;
	}
	public boolean delete(int eid) {
		String sql="delete from essay where eid="+eid;
		int res=this.DbChange(sql);
		if(res==1)return true;
		else return false;
	}
	public boolean add(EssayBean essay) {
		String sql="insert into essay (title,author,content) values ('"+essay.getTitle()+"','"+essay.getAuthor()+"','"+essay.getContent()+"')";
		
		int res=this.DbChange(sql);
		if(res==1)return true;
		else return false;
	}
	public EssayBean find(int eid) {
		String sql="select title,author,content from essay where eid="+eid;
		EssayBean e=null;
		ResultSet res=this.DbSelect(sql);
		try {
			if(res.next()) {
				e=new EssayBean(res.getString("title"), res.getString("author"), res.getString("content"));
				e.setEid(eid);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}
}
