package com.flacom.jpa.hibernate.example.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Post implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private int idpost;
       
    private String title;
    private String content;
    
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date date;
      
	@ManyToOne
    @JoinColumn(name = "idauthor",referencedColumnName="id")
	private User user;
    
	
	public int getId() {
		return idpost;
	}

	public void setId(int id) {
		this.idpost = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public long getIdAuthor()
	{
		return user.getId();
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDate()
	{
		return date.toString().substring(0, 11);
	}
}
