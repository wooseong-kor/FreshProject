package com.min.fresh.dto;

import java.io.Serializable;

public class Chart_DTO implements Serializable{
	
	private static final long serialVersionUID = -9136012281778474535L;
	
	private String year;
	private String month;
	private String money;
	private String cnt;
	
	public Chart_DTO() {
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Chart_Dto [year=" + year + ", month=" + month + ", money=" + money + ", cnt=" + cnt + "]";
	}
	
}
