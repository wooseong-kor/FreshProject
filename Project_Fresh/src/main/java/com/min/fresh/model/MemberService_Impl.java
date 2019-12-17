package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.fresh.dto.Member_DTO;
import com.min.fresh.dto.Warning_DTO;

@Service
public class MemberService_Impl implements IMemberService{

	@Autowired
	private IMemberDao dao;
	
	@Override
	public boolean insertMember(Member_DTO dto) {
		return (dao.insertMember(dto)>0)?true:false;
	}

	@Override
	public boolean idCheck(String id) {
		return dao.idCheck(id);
	}

	@Override
	public boolean emailCheck(String email) {
		return dao.emailCheck(email);
	}

	@Override
	public boolean updateGradeOne(Map<String, Object> map) {
		return (dao.updateGradeOne(map)>0)?true:false;
	}

	@Override
	public boolean insertWarning(Map<String, Object> map) {
		return (dao.insertWarning(map)>0)?true:false;
	}

	@Override
	public Warning_DTO countOneGyngcntMember(String id) {
		return dao.countOneGyngcntMember(id);
	}

	@Override
	public List<Member_DTO> countAllGyungcntMember() {
		return dao.countAllGyungcntMember();
	}

	@Override
	public List<Member_DTO> allMemberListScroll() {
		return dao.allMemberListScroll();
	}

	@Override
	public List<Member_DTO> memberListScroll() {
		return dao.allMemberListScroll();
	}

	@Override
	public Member_DTO memberSearchOne(Map<String, Object> map) {
		return dao.memberSearchOne(map);
	}

	@Override
	public Member_DTO loginMember(Map<String, Object> map) {
		return dao.loginMember(map);
	}

	@Override
	public String ecPasswordLogin(String id) {
		return dao.ecPasswordLogin(id);
	}

	@Override
	public Member_DTO enLogin(String id) {
		return dao.enLogin(id);
	}

	@Override
	public boolean updateMemberDelflagJ() {
		return (dao.updateMemberDelflagJ()>0)?true:false;
	}

	@Override
	public boolean updateMemberDelflagH() {
		return (dao.updateMemberDelflagH()>0)?true:false;
	}

	@Override
	public boolean updateMemberDelflagTOne(String id) {
		return (dao.updateMemberDelflagTOne(id)>0)?true:false;
	}

	@Override
	public boolean resetPassword(Map<String, String> map) {
		return (dao.resetPassword(map)>0)?true:false;
	}

}
