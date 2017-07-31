package com.dao;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="user_tab")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="NAME")
	private String name;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_veh_tab",joinColumns=@JoinColumn(name="U_ID"),inverseJoinColumns=@JoinColumn(name="V_ID"))
	private List<Vehicle> vlist;
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
	public List<Vehicle> getVlist() {
		return vlist;
	}
	public void setVlist(List<Vehicle> vlist) {
		this.vlist = vlist;
	}
	
	
}
