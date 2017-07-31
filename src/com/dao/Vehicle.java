package com.dao;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="veh_tab")
public class Vehicle {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="NAME")
	private String name;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="veh_user_tab",joinColumns=@JoinColumn(name="V_ID"),inverseJoinColumns=@JoinColumn(name="U_ID"))
	private List<User> ulist;
	
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
	public List<User> getUlist() {
		return ulist;
	}
	public void setUlist(List<User> ulist) {
		this.ulist = ulist;
	}	
	
}
