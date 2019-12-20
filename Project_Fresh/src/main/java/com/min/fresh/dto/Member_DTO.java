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
	private Date llogin;
	private Date lpwchange;
	private String delflag;
	private String sns;
	private int mileage;
	private Date hiredate;

	//Cart 테이블에 사용되는 컬럼
	private int seq;
	private String sangpgnum;
	private int cartcnt;
	
	//Grade 테이블에 사용되는 컬럼
	private String grade;
	
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

	public Member_DTO(String id, String password, String gcode, String name, String email, String phone, String agree,
			Date llogin, Date lpwchange, String delflag, String sns, int mileage, Date hiredate, int seq,
			String sangpgnum, int cartcnt, String grade, Warning_DTO warning_DTO, Payhistory_DTO payhistory_DTO) {
		super();
		this.id = id;
		this.password = password;
		this.gcode = gcode;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.agree = agree;
		this.llogin = llogin;
		this.lpwchange = lpwchange;
		this.delflag = delflag;
		this.sns = sns;
		this.mileage = mileage;
		this.hiredate = hiredate;
		this.seq = seq;
		this.sangpgnum = sangpgnum;
		this.cartcnt = cartcnt;
		this.grade = grade;
		this.warning_DTO = warning_DTO;
		this.payhistory_DTO = payhistory_DTO;
	}

	@Override
	public String toString() {
		return "Member_DTO [id=" + id + ", password=" + password + ", gcode=" + gcode + ", name=" + name + ", email="
				+ email + ", phone=" + phone + ", agree=" + agree + ", llogin=" + llogin + ", lpwchange=" + lpwchange
				+ ", delflag=" + delflag + ", sns=" + sns + ", mileage=" + mileage + ", hiredate=" + hiredate + ", seq="
				+ seq + ", sangpgnum=" + sangpgnum + ", cartcnt=" + cartcnt + ", grade=" + grade + ", warning_DTO="
				+ warning_DTO + ", payhistory_DTO=" + payhistory_DTO + "]";
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

	public Date getLlogin() {
		return llogin;
	}

	public void setLlogin(Date llogin) {
		this.llogin = llogin;
	}

	public Date getLpwchange() {
		return lpwchange;
	}

	public void setLpwchange(Date lpwchange) {
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

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
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
