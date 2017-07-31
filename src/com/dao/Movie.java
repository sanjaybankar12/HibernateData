package com.dao;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="mov_tab")
public class Movie {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="NAME")
	private String name;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="move_song_tab",joinColumns=@JoinColumn(name="MV_ID"),inverseJoinColumns=@JoinColumn(name="S_ID"))
	private List<Song> songs;
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
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
}
