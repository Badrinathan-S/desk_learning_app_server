package com.desk.learning.model;

import java.util.Date;

public class KBModel {
	
	private Integer id;
	private String title;
	private Date date;
	private Integer length;
	private String description;
	
	public KBModel(Integer id, String title, Date date, Integer length, String description) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.length = length;
		this.description = description;
	}

	public KBModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
