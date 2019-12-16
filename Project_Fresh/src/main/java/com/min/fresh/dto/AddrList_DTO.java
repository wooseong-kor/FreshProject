package com.min.fresh.dto;

import java.io.Serializable;

public class AddrList_DTO implements Serializable{

	private static final long serialVersionUID = -256643366306082538L;
	private String bsgcode;
	private String id;
	private String bsgname;
	private String juso;
	private String phone;
	
	public AddrList_DTO() {}

	public AddrList_DTO(String bsgcode, String id, String bsgname, String juso, String phone) {
		super();
		this.bsgcode = bsgcode;
		this.id = id;
		this.bsgname = bsgname;
		this.juso = juso;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AddrList_DTO [bsgcode=" + bsgcode + ", id=" + id + ", bsgname=" + bsgname + ", juso=" + juso
				+ ", phone=" + phone + "]";
	}

	public String getBsgcode() {
		return bsgcode;
	}

	public void setBsgcode(String bsgcode) {
		this.bsgcode = bsgcode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBsgname() {
		return bsgname;
	}

	public void setBsgname(String bsgname) {
		this.bsgname = bsgname;
	}

	public String getJuso() {
		return juso;
	}

	public void setJuso(String juso) {
		this.juso = juso;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
