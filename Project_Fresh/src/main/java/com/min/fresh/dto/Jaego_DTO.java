package com.min.fresh.dto;

import java.io.Serializable;

public class Jaego_DTO implements Serializable{

	private static final long serialVersionUID = 6394571553160732802L;
	private String jaegocode;
	private String sangcode;
	private String jaegocnt;
	private String jaegostat;

	private Product_DTO product_DTO;
	
	public Jaego_DTO() {
	}

	public Jaego_DTO(String jaegocode, String sangcode, String jaegocnt, String jaegostat) {
		super();
		this.jaegocode = jaegocode;
		this.sangcode = sangcode;
		this.jaegocnt = jaegocnt;
		this.jaegostat = jaegostat;
	}

	@Override
	public String toString() {
		return "Jaego_DTO [jaegocode=" + jaegocode + ", sangcode=" + sangcode + ", jaegocnt=" + jaegocnt
				+ ", jaegostat=" + jaegostat + ", Product_DTO" +product_DTO+ "]";
	}

	public String getJaegocode() {
		return jaegocode;
	}

	public void setJaegocode(String jaegocode) {
		this.jaegocode = jaegocode;
	}

	public String getSangcode() {
		return sangcode;
	}

	public void setSangcode(String sangcode) {
		this.sangcode = sangcode;
	}

	public String getJaegocnt() {
		return jaegocnt;
	}

	public void setJaegocnt(String jaegocnt) {
		this.jaegocnt = jaegocnt;
	}

	public String getJaegostat() {
		return jaegostat;
	}

	public void setJaegostat(String jaegostat) {
		this.jaegostat = jaegostat;
	}

	public Product_DTO getProduct_DTO() {
		return product_DTO;
	}

	public void setProduct_DTO(Product_DTO product_DTO) {
		this.product_DTO = product_DTO;
	}
	
	
	
}
