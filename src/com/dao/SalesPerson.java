package com.dao;

import javax.persistence.Entity;

@Entity
public class SalesPerson extends Employee {

	private int comm;

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}
	
	
}
