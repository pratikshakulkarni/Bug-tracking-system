package com.psk.bugtracking.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="bug")
public class Bug {
	
	@Id
	@GeneratedValue	
	private Long id;
	
	@CreationTimestamp
	private Date date;
	
	@UpdateTimestamp
	private Date lastUpdated;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String description;
	
	@ManyToOne
	@JoinColumn(name="USER_EMAIL")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bug(String name, String description, User user) {
		this.name = name;
		this.description = description;
		this.user = user;
	}

	public Bug(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Bug() {
}
	
	

}
