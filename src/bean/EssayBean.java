package bean;

import java.io.Serializable;

import dao.*;

public class EssayBean implements Serializable{
	private int eid;
	private String title;
	private String author;
	private String content;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public EssayBean(int eid,String title, String author) {
		super();
		this.eid=eid;
		this.title = title;
		this.author = author;
	}
	public EssayBean(int eid) {
		super();
		this.eid=eid;
		this.loadById();
	}
	public EssayBean(String title, String author, String content) {
		super();
		this.title = title;
		this.author = author;
		this.content = content;
	}
	public EssayBean(int eid,String title, String author, String content) {
		super();
		this.eid=eid;
		this.title = title;
		this.author = author;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void loadById() {
		EssayBean e=new dao.Essay().find(this.eid);
		if(e==null)
		{
			this.author=null;
			this.content=null;
			this.title=null;
		}
		else {
			this.author=e.author;
			this.title=e.title;
			this.content=e.content;
		}
	}
	public boolean create() {
		return new Essay().add(this);

	
	}
	
	public boolean update() {
		return new Essay().update(this);
		
	}
	
	public boolean delete() {
		return new Essay().delete(this.eid);
		
	}
	
}
