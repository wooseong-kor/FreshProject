package com.min.fresh.dto;

import java.io.Serializable;

public class Jumunpage_DTO implements Serializable{

	private static final long serialVersionUID = 6139150952919006260L;
	private String sangpgnum;
	private String sangcode;
	private String sangpname;
	private String title;
	private String content;
	
	private ProductImg_DTO productImg_DTO;
	private Product_DTO product_DTO;
	
	public Jumunpage_DTO() {}

	public Jumunpage_DTO(String sangpgnum, String sangcode, String sangpname, String title, String content,
			ProductImg_DTO productImg_DTO, Product_DTO product_DTO) {
		super();
		this.sangpgnum = sangpgnum;
		this.sangcode = sangcode;
		this.sangpname = sangpname;
		this.title = title;
		this.content = content;
		this.productImg_DTO = productImg_DTO;
		this.product_DTO = product_DTO;
	}

	@Override
	public String toString() {
		return "Jumunpage_DTO [sangpgnum=" + sangpgnum + ", sangcode=" + sangcode + ", sangpname=" + sangpname
				+ ", title=" + title + ", content=" + content + ", productImg_DTO=" + productImg_DTO + ", product_DTO="
				+ product_DTO + "]";
	}

	public String getSangpgnum() {
		return sangpgnum;
	}

	public void setSangpgnum(String sangpgnum) {
		this.sangpgnum = sangpgnum;
	}

	public String getSangcode() {
		return sangcode;
	}

	public void setSangcode(String sangcode) {
		this.sangcode = sangcode;
	}

	public String getSangpname() {
		return sangpname;
	}

	public void setSangpname(String sangpname) {
		this.sangpname = sangpname;
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

	public ProductImg_DTO getProductImg_DTO() {
		return productImg_DTO;
	}

	public void setProductImg_DTO(ProductImg_DTO productImg_DTO) {
		this.productImg_DTO = productImg_DTO;
	}

	public Product_DTO getProduct_DTO() {
		return product_DTO;
	}

	public void setProduct_DTO(Product_DTO product_DTO) {
		this.product_DTO = product_DTO;
	}
}
