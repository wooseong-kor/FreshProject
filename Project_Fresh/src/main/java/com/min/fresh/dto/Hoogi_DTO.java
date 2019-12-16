package com.min.fresh.dto;

import java.io.Serializable;
import java.util.Date;

public class Hoogi_DTO implements Serializable{

	private static final long serialVersionUID = -3119276577545462225L;
	private int seq;
	private String sangpgnum;
	private String id;
	private String title;
	private String content;
	private Date regdate;
	
	public Hoogi_DTO() {}

	public Hoogi_DTO(int seq, String sangpgnum, String id, String title, String content, Date regdate) {
		super();
		this.seq = seq;
		this.sangpgnum = sangpgnum;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Hoogi_DTO [seq=" + seq + ", sangpgnum=" + sangpgnum + ", id=" + id + ", title=" + title + ", content="
				+ content + ", regdate=" + regdate + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getSangpgnum() {
		return sangpgnum;
	}

	public void setSangpgnum(String sangpgnum) {
		this.sangpgnum = sangpgnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
