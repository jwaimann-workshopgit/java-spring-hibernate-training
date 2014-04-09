package com.flacom.jpa.hibernate.example.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Post implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long idpost;
    
    private String title;
    private String content;
    private Date date;
      
	@ManyToOne
    @JoinColumn(name = "idauthor",referencedColumnName="id")
	private User user;
    
	public long getId() {
		return idpost;
	}

	public void setId(long id) {
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
	
	public Date getDate()
	{
		return date;
	}
}
