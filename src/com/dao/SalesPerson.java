package com.dao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

public class SalesPerson extends Employee {

	private int comm;

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}
	
	
}
