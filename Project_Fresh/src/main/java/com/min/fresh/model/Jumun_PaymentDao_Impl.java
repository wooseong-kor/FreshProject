package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.fresh.dto.AddrList_DTO;
import com.min.fresh.dto.Jumun_DTO;
import com.min.fresh.dto.Payhistory_DTO;
import com.min.fresh.dto.RowNum_DTO;

@Repository
public class Jumun_PaymentDao_Impl implements IJumun_PaymentDao {

	private final String NS = "com.min.fresh.IJumun_PaymentDao.";
	private Logger log = LoggerFactory.getLogger(Jumun_PaymentDao_Impl.class);
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertJumun(Jumun_DTO dto) {
		log.info("insertJumun 실행");
		return session.insert(NS+"insertJumun", dto);
	}

	@Override
	public int countMemberJumun(String id) {
		log.info("countMemberJumun 실행");
		return session.selectOne(NS+"countMemberJumun", id);
	}

	@Override
	public List<Jumun_DTO> memberJumunList(Map<String, Object> map) {
		log.info("memberJumunList 실행");
		return session.selectList(NS+"memberJumunList", map);
	}

	@Override
	public int countAllJumun() {
		log.info("countAllJumun 실행");
		return session.selectOne(NS+"countAllJumun");
	}

	@Override
	public List<Jumun_DTO> allJumunList(RowNum_DTO dto) {
		log.info("allJumunList 실행");
		return session.selectList(NS+"allJumunList", dto);
	}

	@Override
	public AddrList_DTO addrListOne(String jumunnum) {
		log.info("addrListOne 실행");
		return session.selectOne(NS+"addrListOne", jumunnum);
	}

	@Override
	public int deleteJumun(String jumunnum) {
		log.info("deleteJumun 실행");
		return session.delete(NS+"deleteJumun",jumunnum);
	}
	
	@Override
	public int deletePayment(String jumunnum) {
		log.info("deletePatment 실행");
		return session.delete(NS+"deletePayment", jumunnum);
	}


	@Override
	public int updateJumstatConfirm(String jumunnum) {
		log.info("updateJumstatConfirm 실행");
		return session.update(NS+"updateJumstatConfirm", jumunnum);
	}

	@Override
	public int updateJumstatAutoConfirm() {
		log.info("updateJumstatAutoConfirm 실행");
		return session.update(NS+"updateJumstatAutoConfirm");
	}

	@Override
	public boolean updateJumunDeposit(String jumunnum) {
		log.info("updateJumunDeposit 실행");
		return (session.update(NS+"updateJumunDeposit", jumunnum)>0)?true:false;
	}

	@Override
	public boolean updatePayhistoryDeposit(String jumunnum) {
		log.info("updatePayhistoryDeposit 실행");
		return (session.update(NS+"updatePayhistoryDeposit", jumunnum)>0)?true:false;
	}

	@Override
	public int insertPayhistory(Payhistory_DTO dto) {
		log.info("insertPayhistory 실행");
		return session.insert(NS+"insertPayhistory", dto);
	}

	@Override
	public int countMemberPayHistory() {
		log.info("countMemberPayHistory 실행");
		return session.selectOne(NS+"countMemberPayHistory");
	}

	@Override
	public List<Payhistory_DTO> memberPayHistoryList(Map<String, Object> map) {
		log.info("memberPayHistoryList 실행");
		return session.selectList(NS+"memberPayHistoryList", map);
	}

	@Override
	public int countAllPayHistory() {
		log.info("countAllPayHistory 실행");
		return session.selectOne(NS+"countAllPayHistory");
	}

	@Override
	public List<Payhistory_DTO> allPayHistoryList(RowNum_DTO dto) {
		log.info("allPayHistoryList 실행");
		return session.selectList(NS+"allPayHistoryList", dto);
	}

	@Override
	public String selectJumunnum(String id) {
		log.info("selectJumunnum 실행");
		return session.selectOne(NS+"selectJumunnum", id);
	}

	
}
