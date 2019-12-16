package com.min.fresh.dto;

import java.io.Serializable;
import java.util.Date;

public class Couponhistory_DTO implements Serializable {

	private static final long serialVersionUID = -7595060238972348485L;
	private int couseq;
	private String coucode;
	private String id;
	private int cnt;
	private Date jgnalza;
	private String useflag;

	// Coupon 테이블의 컬럼
	private int limite;
	private String couname;
	private int discount;

	public Couponhistory_DTO() {
	}

	public Couponhistory_DTO(int couseq, String coucode, String id, int cnt, Date jgnalza, String useflag, int limite,
			String couname, int discount) {
		super();
		this.couseq = couseq;
		this.coucode = coucode;
		this.id = id;
		this.cnt = cnt;
		this.jgnalza = jgnalza;
		this.useflag = useflag;
		this.limite = limite;
		this.couname = couname;
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Couponhistory_DTO [couseq=" + couseq + ", coucode=" + coucode + ", id=" + id + ", cnt=" + cnt
				+ ", jgnalza=" + jgnalza + ", useflag=" + useflag + ", limite=" + limite + ", couname=" + couname
				+ ", discount=" + discount + "]";
	}

	public int getCouseq() {
		return couseq;
	}

	public void setCouseq(int couseq) {
		this.couseq = couseq;
	}

	public String getCoucode() {
		return coucode;
	}

	public void setCoucode(String coucode) {
		this.coucode = coucode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Date getJgnalza() {
		return jgnalza;
	}

	public void setJgnalza(Date jgnalza) {
		this.jgnalza = jgnalza;
	}

	public String getUseflag() {
		return useflag;
	}

	public void setUseflag(String useflag) {
		this.useflag = useflag;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public String getCouname() {
		return couname;
	}

	public void setCouname(String couname) {
		this.couname = couname;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	
	
}
