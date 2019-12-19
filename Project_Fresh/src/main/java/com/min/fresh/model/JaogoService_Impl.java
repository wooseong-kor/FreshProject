package com.min.fresh.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.fresh.dto.Ipgo_DTO;
import com.min.fresh.dto.Jaego_DTO;
import com.min.fresh.dto.Pyegi_DTO;
import com.min.fresh.dto.RowNum_DTO;

@Service
public class JaogoService_Impl implements IJaegoService {

	@Autowired
	private IJaegoDao dao;
	
	@Override
	public int countAllGoodJaego() {
		return dao.countAllGoodJaego();
	}

	@Override
	public List<Jaego_DTO> allGoodJaegoList() {
		return dao.allGoodJaegoList();
	}

	@Override
	public int countAllIpgo() {
		return dao.countAllIpgo();
	}

	@Override
	public List<Ipgo_DTO> allIpgoList() {
		return dao.allIpgoList();
	}

	@Override
	public int countAllPyegi() {
		return dao.countAllPyegi();
	}

	@Override
	public List<Pyegi_DTO> allPyegiList() {
		return dao.allPyegiList();
	}

	@Override
	public int insertJaego(Jaego_DTO dto) {
		return dao.insertJaego(dto);
	}

	@Override
	public int insertIpgo(Ipgo_DTO dto) {
		return dao.insertIpgo(dto);
	}

	@Override
	public int updateJaegoMinus(String paynum) {
		return dao.updateJaegoMinus(paynum);
	}

	@Override
	public int insertPyegi(Pyegi_DTO dto) {
		return dao.insertPyegi(dto);
	}

	@Override
	public int updateJaecountPyegiOne(String pyeginum) {
		return dao.updateJaecountPyegiOne(pyeginum);
	}

	@Override
	public int updatePyegiflagOne(String pyeginum) {
		return dao.updatePyegiflagOne(pyeginum);
	}

	@Override
	public int updateJaegostatOne() {
		return dao.updateJaegostatOne();
	}

	@Override
	public int updateJaegostat(Jaego_DTO dto) {
		return dao.updateJaegostat(dto);
	}
//	@Override
//	public List<Pyegi_DTO> allPyegiList(RowNum_DTO dto) {
//		return dao.allPyegiList(dto);
//	}
	
//	@Override
//	public boolean updateJaegoMinus(String paynum) {
//		return (dao.updateJaegoMinus(paynum)>0)?true:false;
//	}
	
//	@Override
//	public List<Ipgo_DTO> allIpgoList(RowNum_DTO dto) {
//		return dao.allIpgoList(dto);
//	}
	
//	@Override
//	public List<Jaego_DTO> allGoodJaegoList(RowNum_DTO dto) {
//		return dao.allGoodJaegoList(dto);
//	}


//	@Override
//	public List<Jaego_DTO> jaegoCodeList() {
//		return dao.jaegoCodeList();
//	}
//
//	@Override
//	public List<Jaego_DTO> jaegoExpdateList() {
//		return dao.jaegoExpdateList();
//	}

}
