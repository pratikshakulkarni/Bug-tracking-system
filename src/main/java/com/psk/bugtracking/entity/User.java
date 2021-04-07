package com.psk.bugtracking.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Email
	@NotEmpty
	@Column(name="email",unique = true)
	private String email;
	
	@NotEmpty
	@Column(name="name")
	private String name;
	
	@Size(min=7)
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Bug> bugs;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLES", joinColumns= {
			@JoinColumn(name="USER_EMAIL",referencedColumnName = "email")
	},inverseJoinColumns = {
			@JoinColumn(name="ROLE_NAME",referencedColumnName = "name")
	})
	private List<Role> roles;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Bug> getBugs() {
		return bugs;
	}
	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}
	public User() {
		super();
	}

}
