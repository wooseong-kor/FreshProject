package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import com.min.fresh.dto.Member_DTO;
import com.min.fresh.dto.Warning_DTO;

public interface IMemberService {

	// 회원가입
	public boolean insertMember(Member_DTO dto);
	
	// 아이디 중복 확인
	public boolean idCheck(String id);
	
	// 이메일 중복 확인
	public boolean emailCheck(String email);
	
	// 로그인
	public Member_DTO loginMember(Map<String, Object> map);
	
	// 회원 자동 정지처리
	public boolean updateMemberDelflagJ();
	
	// 회원 자동 휴먼처리
	public boolean updateMemberDelflagH();
	
	// 비밀번호 재설정
	public boolean resetPassword(Map<String, Object> map);
	
	// 이전 비밀번호확인 (비밀번호 재설정시 사용)
	public Member_DTO searchPassword(String id);
	
	// 휴면계정 해제
	public boolean updateMemberDelflagN(String id);
	
	// 회원 전체 조회
	public List<Member_DTO> allMemberListScroll();
	
	// 사용중 회원 전체 조회
	public List<Member_DTO> memberListScroll();
	
	// 회원 검색
	public Member_DTO memberSearchOne(String id);
	
	// 회원 마일리지 추가 지급
	public boolean updateMileageMemberOne(Map<String, Object> map);
	
	// 경고받은 회원 조회
	public List<Member_DTO> countAllGyungcntMember();
	
	// 회원 경고 부여
	public boolean insertWarning(Map<String, Object> map);
	
	// 특정회원 경고 횟수 조회
	public Warning_DTO countOneGyngcntMember(String id);
	
	// 회원 탈퇴
	public boolean updateMemberDelflagTOne(String id);
	
	// 암호화 확인 쿼리(시큐리티)
	public String ecPasswordLogin(String id);
	
	// 암호화 로그인(시큐리티)
	public Member_DTO enLogin(String id);
	
}
