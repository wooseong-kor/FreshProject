package com.min.fresh.dto;

import java.io.Serializable;
import java.util.Date;

public class Warning_DTO implements Serializable{

	private static final long serialVersionUID = -2329792098686642698L;
	private int gyungseq;
	private String id;
	private int gyungcnt;
	private String gyungcont;
	private Date gyungdate;
	
	public Warning_DTO() {}

	public Warning_DTO(int gyungseq, String id, int gyungcnt, String gyungcont, Date gyungdate) {
		super();
		this.gyungseq = gyungseq;
		this.id = id;
		this.gyungcnt = gyungcnt;
		this.gyungcont = gyungcont;
		this.gyungdate = gyungdate;
	}

	@Override
	public String toString() {
		return "Warning_DTO [gyungseq=" + gyungseq + ", id=" + id + ", gyungcnt=" + gyungcnt + ", gyungcont="
				+ gyungcont + ", gyungdate=" + gyungdate + "]";
	}

	public int getGyungseq() {
		return gyungseq;
	}

	public void setGyungseq(int gyungseq) {
		this.gyungseq = gyungseq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGyungcnt() {
		return gyungcnt;
	}

	public void setGyungcnt(int gyungcnt) {
		this.gyungcnt = gyungcnt;
	}

	public String getGyungcont() {
		return gyungcont;
	}

	public void setGyungcont(String gyungcont) {
		this.gyungcont = gyungcont;
	}

	public Date getGyungdate() {
		return gyungdate;
	}

	public void setGyungdate(Date gyungdate) {
		this.gyungdate = gyungdate;
	}
	
	
}
