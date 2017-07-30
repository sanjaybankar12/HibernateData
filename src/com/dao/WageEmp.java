package com.dao;

import javax.persistence.Entity;

@Entity
public class WageEmp extends Employee {

	private int hr;
	private int rt;
	public int getHr() {
		return hr;
	}
	public void setHr(int hr) {
		this.hr = hr;
	}
	public int getRt() {
		return rt;
	}
	public void setRt(int rt) {
		this.rt = rt;
	}
	
	
}
