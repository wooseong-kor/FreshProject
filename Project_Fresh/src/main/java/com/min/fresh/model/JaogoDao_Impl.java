package com.min.fresh.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.fresh.dto.Ipgo_DTO;
import com.min.fresh.dto.Jaego_DTO;
import com.min.fresh.dto.Pyegi_DTO;
import com.min.fresh.dto.RowNum_DTO;

@Repository
public class JaogoDao_Impl implements IJaegoDao {

	private final String NS = "com.min.fresh.IJaegoDao.";
	private Logger log = LoggerFactory.getLogger(JaogoDao_Impl.class);
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int countAllGoodJaego() {
		log.info("countAllGoodJaego 실행");
		return session.selectOne(NS+"countAllGoodJaego");
	}

	@Override
	public List<Jaego_DTO> allGoodJaegoList(RowNum_DTO dto) {
		log.info("allGoodJaegoList 실행");
		return session.selectList(NS+"allGoodJaegoList", dto);
	}

	@Override
	public int countAllIpgo() {
		log.info("countAllIpgo 실행");
		return session.selectOne(NS+"countAllIpgo");
	}

	@Override
	public List<Ipgo_DTO> allIpgoList(RowNum_DTO dto) {
		log.info("allIpgoList 실행");
		return session.selectList(NS+"allIpgoList", dto);
	}

	@Override
	public int countAllPyegi() {
		log.info("countAllPyegi 실행");
		return session.selectOne(NS+"countAllPyegi");
	}

	@Override
	public List<Pyegi_DTO> allPyegiList(RowNum_DTO dto) {
		log.info("allPyegiList 실행");
		return session.selectList(NS+"allPyegiList", dto);
	}

	@Override
	public int insertJaego(Jaego_DTO dto) {
		log.info("insertJaego 실행");
		return session.insert(NS+"insertJaego", dto);
	}

	@Override
	public int insertIpgo(Ipgo_DTO dto) {
		log.info("insertIpgo 실행");
		return session.insert(NS+"insertIpgo",dto);
	}

	@Override
	public int updateJaegoMinus(String paynum) {
		log.info("updateJaegoMinus 실행");
		return session.update(NS+"updateJaegoMinus", paynum);
	}

	@Override
	public int insertPyegi(Pyegi_DTO dto) {
		log.info("insertPyegi 실행");
		return session.insert(NS+"insertPyegi", dto);
	}

	@Override
	public int updateJaecountPyegiOne(String pyeginum) {
		log.info("updateJaecountPyegiOne 실행");
		return session.update(NS+"updateJaecountPyegiOne", pyeginum);
	}

	@Override
	public int updatePyegiflagOne(String pyeginum) {
		log.info("updatePyegiflagOne 실행");
		return session.update(NS+"updatePyegiflagOne", pyeginum);
	}

	@Override
	public int updateJaegostatOne() {
		log.info("updateJaegostatOne 실행");
		return session.update(NS+"updateJaegostatOne");
	}

	@Override
	public List<Jaego_DTO> jaegoCodeList() { // 실행여부 불투명 매퍼확인바람
		log.info("jaegoCodeList 실행");
		return session.selectList(NS+"jaegoCodeList");
	}

	@Override
	public List<Jaego_DTO> jaegoExpdateList() { // 실행여부 불투명 매퍼확인바람
		log.info("jaegoExpdateList 실행");
		return session.selectList(NS+"jaegoExpdateList");
	}

}
