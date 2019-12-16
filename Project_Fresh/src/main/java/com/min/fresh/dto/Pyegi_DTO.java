package com.min.fresh.dto;

public class Pyegi_DTO {

	private String pyeginum;
	private String jaegocode;
	private int pyegicnt;
	private String pyegisayu;
	private String pyegiflag;
	
	public Pyegi_DTO() {}

	public Pyegi_DTO(String pyeginum, String jaegocode, int pyegicnt, String pyegisayu, String pyegiflag) {
		super();
		this.pyeginum = pyeginum;
		this.jaegocode = jaegocode;
		this.pyegicnt = pyegicnt;
		this.pyegisayu = pyegisayu;
		this.pyegiflag = pyegiflag;
	}

	@Override
	public String toString() {
		return "Pyegi_DTO [pyeginum=" + pyeginum + ", jaegocode=" + jaegocode + ", pyegicnt=" + pyegicnt
				+ ", pyegisayu=" + pyegisayu + ", pyegiflag=" + pyegiflag + "]";
	}

	public String getPyeginum() {
		return pyeginum;
	}

	public void setPyeginum(String pyeginum) {
		this.pyeginum = pyeginum;
	}

	public String getJaegocode() {
		return jaegocode;
	}

	public void setJaegocode(String jaegocode) {
		this.jaegocode = jaegocode;
	}

	public int getPyegicnt() {
		return pyegicnt;
	}

	public void setPyegicnt(int pyegicnt) {
		this.pyegicnt = pyegicnt;
	}

	public String getPyegisayu() {
		return pyegisayu;
	}

	public void setPyegisayu(String pyegisayu) {
		this.pyegisayu = pyegisayu;
	}

	public String getPyegiflag() {
		return pyegiflag;
	}

	public void setPyegiflag(String pyegiflag) {
		this.pyegiflag = pyegiflag;
	}
	
	
}
