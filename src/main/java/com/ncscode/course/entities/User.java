package com.ncscode.course.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String mail;
	private String phone;
	private String password;
	
	public User(Integer id, String name, String mail, String phone, String password) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.password = password;
	}
	
	public User() {
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}	
	
}
