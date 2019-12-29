package com.min.fresh.dto;

import java.io.Serializable;
import java.util.Date;

public class Member_DTO implements Serializable {

	private static final long serialVersionUID = -3375438780807597810L;
	private String id;
	private String password;
	private String gcode;
	private String name;
	private String email;
	private String phone;
	private String agree;
	private String llogin;
	private String lpwchange;
	private String delflag;
	private String sns;
	private int mileage;
	private String hiredate;

	//Cart 테이블에 사용되는 컬럼
	private int seq;
	private String sangpgnum;
	private int cartcnt;
	
	//Grade 테이블에 사용되는 컬럼
	private String grade;
	
	//경고 join
	private Warning_DTO warning_DTO;
	
	private Payhistory_DTO payhistory_DTO;
	
	public Member_DTO() {
	}

	/**
	 * @author ChoiWooSeong 
	 * 회원의 API 회원가입시 사용되는 생성자
	 * @param id
	 * @param name
	 * @param email
	 * @param agree
	 * @param sns
	 * @since 2019-12-04
	 */
	public Member_DTO(String id, String name, String email, String agree, String sns) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.agree = agree;
		this.sns = sns;
	}

	/**
	 * @author ChoiWooSeong 
	 * 회원의 일반 회원가입시 사용되는 생성자
	 * @param id
	 * @param password
	 * @param name
	 * @param email
	 * @param agree
	 * @param hiredate
	 * @param sns
	 * @since 2019-12-04
	 */
	public Member_DTO(String id, String password, String name, String email, String agree, String sns) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.agree = agree;
		this.sns = sns;
	}

	/**
	 * @author ChoiWooSeong
	 * 회원의 장바구니 입력시 사용되는 생성자
	 * @param id
	 * @param seq
	 * @param sangpgnum
	 * @param cartcnt
	 * @since 2019-12-05
	 */
	public Member_DTO(String id, int seq, String sangpgnum, int cartcnt) {
		super();
		this.id = id;
		this.seq = seq;
		this.sangpgnum = sangpgnum;
		this.cartcnt = cartcnt;
	}

	@Override
	public String toString() {
		return "Member_DTO [id=" + id + ", password=" + password + ", gcode=" + gcode + ", name=" + name + ", email="
				+ email + ", phone=" + phone + ", agree=" + agree + ", llogin=" + llogin + ", lpwchange=" + lpwchange
				+ ", delflag=" + delflag + ", sns=" + sns + ", mileage=" + mileage + ", hiredate=" + hiredate + ", seq="
				+ seq + ", sangpgnum=" + sangpgnum + ", cartcnt=" + cartcnt + ", grade=" + grade + ", warning_DTO="
				+ warning_DTO + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGcode() {
		return gcode;
	}

	public void setGcode(String gcode) {
		this.gcode = gcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}

	public String getLlogin() {
		return llogin;
	}

	public void setLlogin(String llogin) {
		this.llogin = llogin;
	}

	public String getLpwchange() {
		return lpwchange;
	}

	public void setLpwchange(String lpwchange) {
		this.lpwchange = lpwchange;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
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

	public int getCartcnt() {
		return cartcnt;
	}

	public void setCartcnt(int cartcnt) {
		this.cartcnt = cartcnt;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Warning_DTO getWarning_DTO() {
		return warning_DTO;
	}

	public void setWarning_DTO(Warning_DTO warning_DTO) {
		this.warning_DTO = warning_DTO;
	}

	public Payhistory_DTO getPayhistory_DTO() {
		return payhistory_DTO;
	}

	public void setPayhistory_DTO(Payhistory_DTO payhistory_DTO) {
		this.payhistory_DTO = payhistory_DTO;
	}
	
}
