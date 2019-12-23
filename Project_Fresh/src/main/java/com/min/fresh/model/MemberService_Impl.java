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
	
	//회원가입
	@Override
	public boolean insertMember(Member_DTO dto) {
		return (dao.insertMember(dto)>0)?true:false;
	}

	//아이디 중복 확인
	@Override
	public boolean idCheck(String id) {
		return dao.idCheck(id);
	}

	//이메일 중복 확인
	@Override
	public boolean emailCheck(String email) {
		return dao.emailCheck(email);
	}

	//로그인
	@Override
	public Member_DTO loginMember(Map<String, Object> map) {
		return dao.loginMember(map);
	}
	
	//회원 자동 정지처리
	@Override
	public boolean updateMemberDelflagJ() {
		return (dao.updateMemberDelflagJ()>0)?true:false;
	}

	//회원 자동 휴먼처리
	@Override
	public boolean updateMemberDelflagH() {
		return (dao.updateMemberDelflagH()>0)?true:false;
	}
	
	//비밀번호 재설정
	@Override
	public boolean resetPassword(Map<String, Object> map) {
		return (dao.resetPassword(map)>0)?true:false;
	}
	
	// 이전 비밀번호확인 (비밀번호 재설정시 사용)
	@Override
	public Member_DTO searchPassword(String id) {
		return dao.searchPassword(id);
	}

	// 휴면계정 해제
	@Override
	public boolean updateMemberDelflagN(String id) {
		return (dao.updateMemberDelflagN(id) > 0)?true:false;
	}

	//회원 전체 조회
	@Override
	public List<Member_DTO> allMemberListScroll() {
		return dao.allMemberListScroll();
	}
	
	//사용중 회원 전체 조회
	@Override
	public List<Member_DTO> memberListScroll() {
		return dao.memberListScroll();
	}
	
	//경고받은 회원 조회
	@Override
	public List<Member_DTO> countAllGyungcntMember() {
		return dao.countAllGyungcntMember();
	}
	
	//회원 검색
	@Override
	public Member_DTO memberSearchOne(Map<String, Object> map) {
		return dao.memberSearchOne(map);
	}
	
	//회원 등급 변경
	@Override
	public boolean updateGradeOne(Map<String, Object> map) {
		return (dao.updateGradeOne(map)>0)?true:false;
	}
	
	//회원 경고 부여
	@Override
	public boolean insertWarning(Map<String, Object> map) {
		return (dao.insertWarning(map)>0)?true:false;
	}
	
	//특정회원 경고 횟수 조회
	@Override
	public Warning_DTO countOneGyngcntMember(String id) {
		return dao.countOneGyngcntMember(id);
	}
	
	//회원 탈퇴
	@Override
	public boolean updateMemberDelflagTOne(String id) {
		return (dao.updateMemberDelflagTOne(id)>0)?true:false;
	}
	
	//암호화 확인 쿼리(시큐리티)
	@Override
	public String ecPasswordLogin(String id) {
		return dao.ecPasswordLogin(id);
	}

	//암호화 로그인(시큐리티)
	@Override
	public Member_DTO enLogin(String id) {
		return dao.enLogin(id);
	}
	
}
