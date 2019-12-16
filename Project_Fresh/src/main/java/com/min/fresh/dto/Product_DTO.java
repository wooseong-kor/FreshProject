package com.min.fresh.dto;

import java.io.Serializable;

public class Product_DTO implements Serializable{

	private static final long serialVersionUID = 1841769068716450683L;
	private String sangcode;
	private String sangname;
	private int price;
	private String sangstat;
	
	
	public Product_DTO() {
	}

	public Product_DTO(String sangcode, String sangname, int price, String sangstat) {
		super();
		this.sangcode = sangcode;
		this.sangname = sangname;
		this.price = price;
		this.sangstat = sangstat;
	}

	@Override
	public String toString() {
		return "Product_DTO [sangcode=" + sangcode + ", sangname=" + sangname + ", price=" + price + ", sangstat="
				+ sangstat + "]";
	}

	public String getSangcode() {
		return sangcode;
	}

	public void setSangcode(String sangcode) {
		this.sangcode = sangcode;
	}

	public String getSangname() {
		return sangname;
	}

	public void setSangname(String sangname) {
		this.sangname = sangname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSangstat() {
		return sangstat;
	}

	public void setSangstat(String sangstat) {
		this.sangstat = sangstat;
	}

	
}
