package com.min.fresh.dto;

import java.io.Serializable;
import java.util.Date;

public class Jumun_DTO implements Serializable{

	private static final long serialVersionUID = 1931282401388109283L;
	private String jumunnum;
	private String id;
	private String sangpgnum;
	private String bsgcode;
	private int jummoney;
	private int jumcnt;
	private String jumstat;
	private Date jumdate;
	
	private Jumunpage_DTO jumunpage_DTO;
	
	public Jumun_DTO() {
	}

	public Jumun_DTO(String jumunnum, String id, String sangpgnum, String bsgcode, int jummoney, int jumcnt,
			String jumstat, Date jumdate, Jumunpage_DTO jumunpage_DTO) {
		super();
		this.jumunnum = jumunnum;
		this.id = id;
		this.sangpgnum = sangpgnum;
		this.bsgcode = bsgcode;
		this.jummoney = jummoney;
		this.jumcnt = jumcnt;
		this.jumstat = jumstat;
		this.jumdate = jumdate;
		this.jumunpage_DTO = jumunpage_DTO;
	}

	@Override
	public String toString() {
		return "Jumun_DTO [jumunnum=" + jumunnum + ", id=" + id + ", sangpgnum=" + sangpgnum + ", bsgcode=" + bsgcode
				+ ", jummoney=" + jummoney + ", jumcnt=" + jumcnt + ", jumstat=" + jumstat + ", jumdate=" + jumdate
				+ ", jumunpage_DTO=" + jumunpage_DTO + "]";
	}

	public String getJumunnum() {
		return jumunnum;
	}

	public void setJumunnum(String jumunnum) {
		this.jumunnum = jumunnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSangpgnum() {
		return sangpgnum;
	}

	public void setSangpgnum(String sangpgnum) {
		this.sangpgnum = sangpgnum;
	}

	public String getBsgcode() {
		return bsgcode;
	}

	public void setBsgcode(String bsgcode) {
		this.bsgcode = bsgcode;
	}

	public int getJummoney() {
		return jummoney;
	}

	public void setJummoney(int jummoney) {
		this.jummoney = jummoney;
	}

	public int getJumcnt() {
		return jumcnt;
	}

	public void setJumcnt(int jumcnt) {
		this.jumcnt = jumcnt;
	}

	public String getJumstat() {
		return jumstat;
	}

	public void setJumstat(String jumstat) {
		this.jumstat = jumstat;
	}

	public Date getJumdate() {
		return jumdate;
	}

	public void setJumdate(Date jumdate) {
		this.jumdate = jumdate;
	}

	public Jumunpage_DTO getJumunpage_DTO() {
		return jumunpage_DTO;
	}

	public void setJumunpage_DTO(Jumunpage_DTO jumunpage_DTO) {
		this.jumunpage_DTO = jumunpage_DTO;
	}


}
