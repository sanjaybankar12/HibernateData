package com.dao;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="song_tab")
public class Song {
	
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
}
