package com.min.fresh.dto;

import java.io.Serializable;
import java.util.Date;

public class Ipgo_DTO implements Serializable{

	private static final long serialVersionUID = 6283118791472209374L;
	private String ipgonum;
	private String jaegocode;
	private Date ipgodate;
	private int ipgocnt;
	private Date expdate;
	
	public Ipgo_DTO() {}

	public Ipgo_DTO(String ipgonum, String jaegocode, Date ipgodate, int ipgocnt, Date expdate) {
		super();
		this.ipgonum = ipgonum;
		this.jaegocode = jaegocode;
		this.ipgodate = ipgodate;
		this.ipgocnt = ipgocnt;
		this.expdate = expdate;
	}

	@Override
	public String toString() {
		return "Ipgo_DTO [ipgonum=" + ipgonum + ", jaegocode=" + jaegocode + ", ipgodate=" + ipgodate + ", ipgocnt="
				+ ipgocnt + ", expdate=" + expdate + "]";
	}

	public String getIpgonum() {
		return ipgonum;
	}

	public void setIpgonum(String ipgonum) {
		this.ipgonum = ipgonum;
	}

	public String getJaegocode() {
		return jaegocode;
	}

	public void setJaegocode(String jaegocode) {
		this.jaegocode = jaegocode;
	}

	public Date getIpgodate() {
		return ipgodate;
	}

	public void setIpgodate(Date ipgodate) {
		this.ipgodate = ipgodate;
	}

	public int getIpgocnt() {
		return ipgocnt;
	}

	public void setIpgocnt(int ipgocnt) {
		this.ipgocnt = ipgocnt;
	}

	public Date getExpdate() {
		return expdate;
	}

	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}
	
	
}
