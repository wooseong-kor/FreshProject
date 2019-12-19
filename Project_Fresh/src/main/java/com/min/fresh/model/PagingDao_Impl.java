package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.fresh.dto.AddrList_DTO;
import com.min.fresh.dto.Couponhistory_DTO;
import com.min.fresh.dto.Hoogi_DTO;
import com.min.fresh.dto.Ipgo_DTO;
import com.min.fresh.dto.Jaego_DTO;
import com.min.fresh.dto.Jumun_DTO;
import com.min.fresh.dto.Jumunpage_DTO;
import com.min.fresh.dto.Member_DTO;
import com.min.fresh.dto.Payhistory_DTO;
import com.min.fresh.dto.Product_DTO;
import com.min.fresh.dto.Pyegi_DTO;
import com.min.fresh.dto.QA_GO_DTO;
import com.min.fresh.dto.RowNum_DTO;

@Repository
public class PagingDao_Impl implements IPagingDao {

	private final String NS = "com.min.fresh.IPagingDao.";
	private Logger log = LoggerFactory.getLogger(PagingDao_Impl.class);
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int countAllMember() {
		log.info("countAllMember 실행");
		return session.selectOne(NS+"countAllMember");
	}

	@Override
	public int countMember() {
		log.info("countMember 실행");
		return session.selectOne(NS+"countMember");
	}

	@Override
	public List<Member_DTO> allMemberList(RowNum_DTO dto) {
		log.info("allMemberList 실행");
		return session.selectList(NS+"allMemberList", dto);
	}

	@Override
	public List<Member_DTO> memberList(RowNum_DTO dto) {
		log.info("memberList 실행");
		return session.selectList(NS+"memberList", dto);
	}

	@Override
	public int countMemberCart(String id) {
		log.info("countMemberCart 실행");
		return session.selectOne(NS+"countMemberCart", id);
	}

	@Override
	public int countMemberQa(String id) {
		log.info("countMemberQa 실행");
		return session.selectOne(NS+"countMemberQa", id);
	}

	@Override
	public List<QA_GO_DTO> memberQaList(Map<String, Object> map) {
		log.info("memberQaList 실행");
		return session.selectList(NS+"memberQaList", map);
	}

	@Override
	public int countAllQa() {
		log.info("countAllQa 실행");
		return session.selectOne(NS+"countAllQa");
	}

	@Override
	public List<QA_GO_DTO> allQaList(RowNum_DTO dto) {
		log.info("allQaList 실행");
		return session.selectList(NS+"allQaList", dto);
	}

	@Override
	public int countAllGo() {
		log.info("countAllGo 실행");
		return session.selectOne(NS+"countAllGo");
	}

	@Override
	public List<QA_GO_DTO> allGoList(RowNum_DTO dto) {
		log.info("allGoList 실행");
		return session.selectList(NS+"allGoList", dto);
	}

	@Override
	public int updateTitleQa(Map<String, Object> map) {
		log.info("updateTitleQa 실행");
		return session.update(NS+"updateTitleQa", map);
	}

//	@Override
//	public int countMemberCouponHistory(String id) {
//		log.info("countMemberCouponHistory 실행");
//		return session.selectOne(NS+"countMemberCouponHistory", id);
//	}
//
//	@Override
//	public List<Couponhistory_DTO> memberCounponHistoryList(Map<String, Object> map) {
//		log.info("memberCounponHistoryList 실행");
//		return session.selectList(NS+"memberCounponHistoryList", map);
//	}

	@Override
	public int countMemberAddrList(String id) {
		log.info("countMemberAddrList 실행");
		return session.selectOne(NS+"countMemberAddrList", id);
	}

//	@Override
//	public int countMemberPayHistory(String id) {
//		log.info("countMemberPayHistory 실행");
//		return session.selectOne(NS+"countMemberPayHistory", id);
//	}
//
//	@Override
//	public List<Payhistory_DTO> memberPayHistoryList(Map<String, Object> map) {
//		log.info("memberPayHistoryList 실행");
//		return session.selectList(NS+"memberPayHistoryList", map);
//	}
//
//	@Override
//	public int countAllPayHistory() {
//		log.info("countAllPayHistory 실행");
//		return session.selectOne(NS+"countAllPayHistory");
//	}
//
//	@Override
//	public List<Payhistory_DTO> allPayHistoryList(RowNum_DTO dto) {
//		log.info("allPayHistoryList 실행");
//		return session.selectList(NS+"allPayHistoryList", dto);
//	}
//
//	@Override
//	public AddrList_DTO addrListOne(String jumunnum) {
//		log.info("addrListOne 실행");
//		return session.selectOne(NS+"addrListOne", jumunnum);
//	}
//
	@Override
	public int countMemberJumun(String id) {
		log.info("countMemberJumun 실행");
		return session.selectOne(NS+"countMemberJumun", id);
	}
//
	@Override
	public List<Jumun_DTO> memberJumunList(Map<String, Object> map) {
		log.info("memberJumunList 실행");
		return session.selectList(NS+"memberJumunList", map);
	}
//
	@Override
	public int countAllJumun() {
		log.info("countAllJumun 실행");
		return session.selectOne(NS+"countAllJumun");
	}
//
//	@Override
//	public List<Jumun_DTO> allJumunList(RowNum_DTO dto) {
//		log.info("allJumunList 실행");
//		return session.selectList(NS+"allJumunList", dto);
//	}

	@Override
	public int countAllJumunpage() {
		log.info("countAllJumunpage 실행");
		return session.selectOne(NS+"countAllJumunpage");
	}

	@Override
	public List<Jumunpage_DTO> allJumunpageList(Map<String, Object> map) {
		log.info("allJumunpageList 실행");
		return session.selectList(NS+"allJumunpageList", map);
	}

	@Override
	public int countDynamicJumunpage(Map<String, String> map) {
		log.info("countDynamicJumunpage 실행");
		return session.selectOne(NS+"countDynamicJumunpage", map);
	}

	@Override
	public List<Jumunpage_DTO> dynamicJumunList(Map<String, Object> map) {
		log.info("dynamicJumunList 실행");
		return session.selectList(NS+"dynamicJumunList", map);
	}

	@Override
	public int countSangpgnumHoogi(String sangpgnum) {
		log.info("countSangpgnumHoogi 실행");
		return session.selectOne(NS+"countSangpgnumHoogi", sangpgnum);
	}

	@Override
	public List<Hoogi_DTO> sangpgnumHoogiList(Map<String, Object> map) {
		log.info("sangpgnumHoogiList 실행");
		return session.selectList(NS+"sangpgnumHoogiList", map);
	}

//	@Override
//	public int countAllProduct() {
//		log.info("countAllProduct 실행");
//		return session.selectOne(NS+"countAllProduct");
//	}
//
//	@Override
//	public List<Product_DTO> allProductList(RowNum_DTO dto) {
//		log.info("allProductList 실행");
//		return session.selectList(NS+"allProductList", dto);
//	}

	@Override
	public List<Member_DTO> memberCartList(Map<Object, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public int countAllJaego() {
//		log.info("countAllJaego 실행");
//		return session.selectOne(NS+"countAllJaego");
//	}
//
//	@Override
//	public List<Jaego_DTO> allJaegoList(RowNum_DTO dto) {
//		log.info("allJaegoList 실행");
//		return session.selectList(NS+"allJaegoList", dto);
//	}
//
//	@Override
//	public int countAllIpgo() {
//		log.info("countAllIpgo 실행");
//		return session.selectOne(NS+"countAllIpgo");
//	}
//
//	@Override
//	public List<Ipgo_DTO> allIpgoList(RowNum_DTO dto) {
//		log.info("allIpgoList 실행");
//		return session.selectList(NS+"allIpgoList", dto);
//	}
//
//	@Override
//	public int countAllPyegi() {
//		log.info("countAllPyegi 실행");
//		return session.selectOne(NS+"countAllPyegi");
//	}
//
//	@Override
//	public List<Pyegi_DTO> allPyegiList(RowNum_DTO dto) {
//		log.info("allPyegiList 실행");
//		return session.selectList(NS+"allPyegiList", dto);
//	}

}
