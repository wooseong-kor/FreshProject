package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.fresh.dto.Member_DTO;
import com.min.fresh.dto.Warning_DTO;

@Repository
public class MemberDao_Impl implements IMemberDao{

	private final String NS = "com.min.fresh.IMemberDao.";
	private Logger log = LoggerFactory.getLogger(MemberDao_Impl.class);
	
	@Autowired
	private SqlSessionTemplate session;
	
	// 비밀번호 암호화
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// 회원가입
	@Override
	public int insertMember(Member_DTO dto) {
		log.info("insertMember 실행");
		return session.insert(NS+"insertMember", dto);
	}

	// 아이디 중복
	@Override
	public boolean idCheck(String id) {
		log.info("idCheck 실행");
		int cnt = session.selectOne(NS+"idCheck", id);
		return (cnt == 1)?false:true;
	}

	// 이메일 중복
	@Override
	public boolean emailCheck(String email) {
		log.info("emailCheck 실행");
		int cnt = session.selectOne(NS+"emailCheck", email);
		return (cnt == 1)?false:true;
	}
	
	// 로그인
	@Override
	public Member_DTO loginMember(Map<String, Object> map) {
		log.info("loginMember 실행");
		return session.selectOne(NS+"loginMember", map);
	}
	
	// 회원 자동 정지처리
	@Override
	public int updateMemberDelflagJ() {
		log.info("updateMemberDelflagJ 실행");
		return session.update(NS+"updateMemberDelflagJ");
	}
	
	// 회원 자동 휴먼 처리
	@Override
	public int updateMemberDelflagH() {
		log.info("updateMemberDelflagH 실행");
		return session.update(NS+"updateMemberDelflagH");
	}
	
	// 비밀번호 초기화
	@Override
	public int resetPassword(Map<String, Object> map) {
		log.info("resetPassword 실행");
		String encodePW = passwordEncoder.encode((CharSequence)map.get("password"));
		map.put("password", encodePW);
		System.out.println("바뀐비밀번호"+encodePW);
		return session.update(NS+"resetPassword", map);
	}

	// (비밀번호 재설정시 사용) 비밀번호, 상태확인
	@Override
	public Member_DTO searchPassword(String id) {
		log.info("searchPassword 실행");
		return session.selectOne(NS+"searchPassword", id);
	}

	// 휴면계정 해제
	@Override
	public int updateMemberDelflagN(String id) {
		log.info("updateMemberDelflagN 실행");
		return session.update(NS+"updateMemberDelflagN", id);
	}
	
	// 회원 전체 조회
	@Override
	public List<Member_DTO> allMemberListScroll() {
		log.info("allMemberListScroll 실행");
		return session.selectList(NS+"allMemberListScroll");
	}

	// 사용중인 회원 전체 조회
	@Override
	public List<Member_DTO> memberListScroll() {
		log.info("memberListScroll 실행");
		return session.selectList(NS+"memberListScroll");
	}
	
	// 회원 검색
	@Override
	public Member_DTO memberSearchOne(String id) {
		log.info("memberSearchOne 실행");
		return session.selectOne(NS+"memberSearchOne", id);
	}

	// 회원 마일리지 추가 지급
	@Override
	public boolean updateMileageMemberOne(Map<String, Object> map) {
		log.info("updateMileageMemberOne 실행");
		int cnt = session.update(NS+"updateMileageMemberOne", map);
		return (cnt > 0)?true:false;
	}
	
	// 경고받은 회원 조회
	@Override
	public List<Member_DTO> countAllGyungcntMember() {
		log.info("countAllGyungcntMember 실행");
		return session.selectList(NS+"countAllGyungcntMember");
	}

	// 회원 경고 부여
	@Override
	public int insertWarning(Map<String, Object> map) {
		log.info("insertWarning 실행");
		return session.insert(NS+"insertWarning", map);
	}

	// 특정회원 경고 횟수 조회
	@Override
	public Warning_DTO countOneGyngcntMember(String id) {
		log.info("countOneGyngcntMember 실행");
		return session.selectOne(NS+"countOneGyngcntMember", id);
	}

	// 회원 탈퇴
	@Override
	public int updateMemberDelflagTOne(String id) {
		log.info("updateMemberDelflagTOne 실행");
		return session.update(NS+"updateMemberDelflagTOne", id);
	}

	// 암호화 확인 쿼리(시큐리티)
	@Override
	public String ecPasswordLogin(String id) {
		log.info("ecPasswordLogin 실행");
		return session.selectOne(NS+"ecPasswordLogin", id);
	}
	
	// 암호화 로그인(시큐리티)
	@Override
	public Member_DTO enLogin(String id) {
		log.info("enLogin 실행");
		return session.selectOne(NS+"enLogin", id);
	}
	
}
