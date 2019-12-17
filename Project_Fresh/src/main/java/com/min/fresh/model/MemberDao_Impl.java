package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.fresh.dto.Member_DTO;
import com.min.fresh.dto.Warning_DTO;

@Repository
public class MemberDao_Impl implements IMemberDao{

	private final String NS = "com.min.fresh.IMemberDao.";
	private Logger log = LoggerFactory.getLogger(MemberDao_Impl.class);
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertMember(Member_DTO dto) {
		log.info("insertMember 실행");
		return session.insert(NS+"insertMember", dto);
	}

	@Override
	public boolean idCheck(String id) {
		log.info("idCheck 실행");
		int cnt = session.selectOne(NS+"idCheck", id);
		return (cnt == 1)?false:true;
	}

	@Override
	public boolean emailCheck(String email) {
		log.info("emailCheck 실행");
		int cnt = session.selectOne(NS+"emailCheck", email);
		return (cnt == 1)?false:true;
	}

	@Override
	public int updateGradeOne(Map<String, Object> map) {
		log.info("updateGradeOne 실행");
		return session.update(NS+"updateGradeOne", map);
	}

	@Override
	public int insertWarning(Map<String, Object> map) {
		log.info("insertWarning 실행");
		return session.insert(NS+"insertWarning", map);
	}

	@Override
	public Warning_DTO countOneGyngcntMember(String id) {
		log.info("countOneGyngcntMember 실행");
		return session.selectOne(NS+"countOneGyngcntMember", id);
	}

	@Override
	public List<Member_DTO> countAllGyungcntMember() {
		log.info("countAllGyungcntMember 실행");
		return session.selectList(NS+"countAllGyungcntMember");
	}

	@Override
	public List<Member_DTO> allMemberListScroll() {
		log.info("allMemberListScroll 실행");
		return session.selectList(NS+"allMemberListScroll");
	}

	@Override
	public List<Member_DTO> memberListScroll() {
		log.info("memberListScroll 실행");
		return session.selectList(NS+"memberListScroll");
	}

	@Override
	public Member_DTO memberSearchOne(Map<String, Object> map) {
		log.info("memberSearchOne 실행");
		return session.selectOne(NS+"memberSearchOne", map);
	}

	@Override
	public Member_DTO loginMember(Map<String, Object> map) {
		log.info("loginMember 실행");
		return session.selectOne(NS+"loginMember", map);
	}

	@Override
	public String ecPasswordLogin(String id) {
		log.info("ecPasswordLogin 실행");
		return session.selectOne(NS+"ecPasswordLogin", id);
	}

	@Override
	public Member_DTO enLogin(String id) {
		log.info("enLogin 실행");
		return session.selectOne(NS+"enLogin", id);
	}

	@Override
	public int updateMemberDelflagJ() {
		log.info("updateMemberDelflagJ 실행");
		return session.update(NS+"updateMemberDelflagJ");
	}

	@Override
	public int updateMemberDelflagH() {
		log.info("updateMemberDelflagH 실행");
		return session.update(NS+"updateMemberDelflagH");
	}

	@Override
	public int updateMemberDelflagTOne(String id) {
		log.info("updateMemberDelflagTOne 실행");
		return session.update(NS+"updateMemberDelflagTOne", id);
	}

	@Override
	public int resetPassword(Map<String, String> map) {
		log.info("resetPassword 실행");
		return session.update(NS+"resetPassword", map);
	}

}
