package com.min.fresh.dto;

import java.io.Serializable;

public class ProductImg_DTO implements Serializable{

	private static final long serialVersionUID = -7127342529828899491L;
	private String seq;
	private String sangpgnum;
	private String imgname;
	private String savename;
	private String imgpath;
	
	public ProductImg_DTO() {
	}

	public ProductImg_DTO(String seq, String sangpgnum, String imgname, String savename, String imgpath) {
		super();
		this.seq = seq;
		this.sangpgnum = sangpgnum;
		this.imgname = imgname;
		this.savename = savename;
		this.imgpath = imgpath;
	}

	@Override
	public String toString() {
		return "ProductImg_DTO [seq=" + seq + ", sangpgnum=" + sangpgnum + ", imgname=" + imgname + ", savename="
				+ savename + ", imgpath=" + imgpath + "]";
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getSangpgnum() {
		return sangpgnum;
	}

	public void setSangpgnum(String sangpgnum) {
		this.sangpgnum = sangpgnum;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public String getSavename() {
		return savename;
	}

	public void setSavename(String savename) {
		this.savename = savename;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	
	
}
