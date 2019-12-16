package com.min.fresh.dto;

import java.io.Serializable;
import java.util.Date;

public class Payhistory_DTO implements Serializable{

	private static final long serialVersionUID = -1315271230354010479L;
	private String paynum;
	private String jumunnum;
	private int couseq;
	private String paywhat;
	private int paymoney;
	private Date payday;
	private String paystat;
	private int mileage;
	
	private Jumun_DTO jumun_DTO;

	public Payhistory_DTO() {
	}

	public Payhistory_DTO(String paynum, String jumunnum, int couseq, String paywhat, int paymoney, Date payday,
			String paystat, int mileage, Jumun_DTO jumun_DTO) {
		super();
		this.paynum = paynum;
		this.jumunnum = jumunnum;
		this.couseq = couseq;
		this.paywhat = paywhat;
		this.paymoney = paymoney;
		this.payday = payday;
		this.paystat = paystat;
		this.mileage = mileage;
		this.jumun_DTO = jumun_DTO;
	}

	@Override
	public String toString() {
		return "Payhistory_DTO [paynum=" + paynum + ", jumunnum=" + jumunnum + ", couseq=" + couseq + ", paywhat="
				+ paywhat + ", paymoney=" + paymoney + ", payday=" + payday + ", paystat=" + paystat + ", mileage="
				+ mileage + ", jumun_DTO=" + jumun_DTO + "]";
	}

	public String getPaynum() {
		return paynum;
	}

	public void setPaynum(String paynum) {
		this.paynum = paynum;
	}

	public String getJumunnum() {
		return jumunnum;
	}

	public void setJumunnum(String jumunnum) {
		this.jumunnum = jumunnum;
	}

	public int getCouseq() {
		return couseq;
	}

	public void setCouseq(int couseq) {
		this.couseq = couseq;
	}

	public String getPaywhat() {
		return paywhat;
	}

	public void setPaywhat(String paywhat) {
		this.paywhat = paywhat;
	}

	public int getPaymoney() {
		return paymoney;
	}

	public void setPaymoney(int paymoney) {
		this.paymoney = paymoney;
	}

	public Date getPayday() {
		return payday;
	}

	public void setPayday(Date payday) {
		this.payday = payday;
	}

	public String getPaystat() {
		return paystat;
	}

	public void setPaystat(String paystat) {
		this.paystat = paystat;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public Jumun_DTO getJumun_DTO() {
		return jumun_DTO;
	}

	public void setJumun_DTO(Jumun_DTO jumun_DTO) {
		this.jumun_DTO = jumun_DTO;
	}
	
	

}
