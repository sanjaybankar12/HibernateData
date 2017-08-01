package com.dao;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="user_tab")
@NamedQuery(name="UserBy.ID",query="select u.name from User u where u.id=?")
@NamedNativeQuery(name="NativeUserBy.NAME",query="select * from user_tab where NAME LIKE ?")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="NAME")
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	
}
