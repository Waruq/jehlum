package com.jehlum.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PostAdd {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	private String category;
	
	private String addtitle;
	
	private String description;
	
	private Double salary;
	
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date postTime;
	
	@ManyToOne
	private User user;
	
	@ElementCollection
	private List<String> files = new ArrayList<String>();

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddtitle() {
		return addtitle;
	}

	public void setAddtitle(String addtitle) {
		this.addtitle = addtitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getFiles() {
		return files;
	}

	public void setFiles(List<String> files) {
		this.files = files;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getPostTime() {
		return postTime;
	}
	
	public int getPostTimeinMonths() {
		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(this.postTime);
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(new Date());
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		return diffMonth;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	
	

}
