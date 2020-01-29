package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.fresh.dto.Couponhistory_DTO;
import com.min.fresh.dto.RowNum_DTO;

@Repository
public class CouponMileageDao_Impl implements ICouponMileageDao {

	private final String NS = "com.min.fresh.ICouponMileageDao.";
	private Logger log = LoggerFactory.getLogger(CouponMileageDao_Impl.class);
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int updateMileageRMember(Map<String, Object> map) {
		log.info("updateMileageRMember 실행");
		return session.update(NS+"updateMileageRMember", map);
	}

	@Override
	public int updateMileageBMember(Map<String, Object> map) {
		log.info("updateMileageBMember 실행");
		return session.update(NS+"updateMileageBMember", map);
	}

	@Override
	public int updateMileageSMember(Map<String, Object> map) {
		log.info("updateMileageSMember 실행");
		return session.update(NS+"updateMileageSMember", map);
	}

	@Override
	public int updateMileageVMember(Map<String, Object> map) {
		log.info("updateMileageVMember 실행");
		return session.update(NS+"updateMileageVMember", map);
	}

	@Override
	public int updateMileageOneMember(Map<String, Object> map) {
		log.info("updateMileageOneMember 실행");
		return session.update(NS+"updateMileageOneMember", map);
	}

	@Override
	public int updatePaymoneyMOne(String jumunnum) {
		log.info("updatePaymoneyMOne 실행");
		return session.update(NS+"updatePaymoneyMOne", jumunnum);
	}

	@Override
	public int updateUseflagOne(int couseq) {
		log.info("updatePaymoneyMOne 실행");
		return session.update(NS+"updateUseflagOne", couseq);
	}

	@Override
	public int insertCouponhistoryG(String id) {
		log.info("insertCouponhistoryG 실행");
		return session.insert(NS+"insertCouponhistoryG", id);
	}

	@Override
	public int insertCouponhistoryB(String id) {
		log.info("insertCouponhistoryB 실행");
		return session.insert(NS+"insertCouponhistoryB", id);
	}

	@Override
	public int insertCouponhistoryS(String id) {
		log.info("insertCouponhistoryS 실행");
		return session.insert(NS+"insertCouponhistoryS", id);
	}

	@Override
	public int insertCouponhistoryV(String id) {
		log.info("insertCouponhistoryV 실행");
		return session.insert(NS+"insertCouponhistoryV", id);
	}

	@Override
	public int updatePaymoneyGOne(Map<String, Object> map) {
		log.info("updatePaymoneyGOne 실행");
		return session.update(NS+"updatePaymoneyGOne", map);
	}

	@Override
	public int updatePaymoneyBOne(Map<String, Object> map) {
		log.info("updatePaymoneyBOne 실행");
		return session.update(NS+"updatePaymoneyBOne", map);
	}

	@Override
	public int updatePaymoneySOne(Map<String, Object> map) {
		log.info("updatePaymoneySOne 실행");
		return session.update(NS+"updatePaymoneySOne", map);
	}

	@Override
	public int updatePaymoneyVOne(Map<String, Object> map) {
		log.info("updatePaymoneyVOne 실행");
		return session.update(NS+"updatePaymoneyVOne", map);
	}

	@Override
	public int updateUseflagAutoOne(String id) {
		log.info("updateUseflagAutoOne 실행");
		return session.update(NS+"updateUseflagAutoOne", id);
	}

	@Override
	public int updateCouponUseflaghistory() {
		log.info("updateCouponUseflaghistory 실행");
		return session.update(NS+"updateCouponUseflaghistory");
	}

	@Override
	public int countMemberCouponHistory(String id) {
		log.info("countMemberCouponHistory 실행");
		return session.selectOne(NS+"countMemberCouponHistory", id);
	}

	@Override
	public List<Couponhistory_DTO> memberCounponHistoryList(Map<String, Object> map) {
		log.info("memberCounponHistoryList 실행");
		return session.selectList(NS+"memberCounponHistoryList", map);
	}

	@Override
	public int countAllCouponHistory() {
		log.info("countAllCouponHistory 실행");
		return session.selectOne(NS+"countAllCouponHistory");
	}

	@Override
	public List<Couponhistory_DTO> allCounponHistoryList(RowNum_DTO dto) {
		log.info("allCounponHistoryList 실행");
		return session.selectList(NS+"allCounponHistoryList", dto);
	}

	@Override
	public List<Couponhistory_DTO> memberUseMineCou(String id) {
		log.info("memberUseMineCou 실행");
		return session.selectList(NS+"memberUseMineCou", id);
	}

}
