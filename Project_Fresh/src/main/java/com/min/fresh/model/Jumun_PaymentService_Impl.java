package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.fresh.dto.AddrList_DTO;
import com.min.fresh.dto.Jumun_DTO;
import com.min.fresh.dto.Payhistory_DTO;
import com.min.fresh.dto.RowNum_DTO;

@Service
public class Jumun_PaymentService_Impl implements IJumun_PaymentService{

	@Autowired
	private IJumun_PaymentDao dao;
	
	@Override
	public boolean insertJumun(Jumun_DTO dto) {
		return (dao.insertJumun(dto)>0)?true:false;
	}

	@Override
	public int countMemberJumun(String id) {
		return dao.countMemberJumun(id);
	}

	@Override
	public List<Jumun_DTO> memberJumunList(Map<String, Object> map) {
		return dao.memberJumunList(map);
	}

	@Override
	public int countAllJumun() {
		return dao.countAllJumun();
	}

	@Override
	public List<Jumun_DTO> allJumunList(RowNum_DTO dto) {
		return dao.allJumunList(dto);
	}

	@Override
	public AddrList_DTO addrListOne(String jumunnum) {
		return dao.addrListOne(jumunnum);
	}

	@Override
	public boolean deleteJumun(String jumunnum) {
		boolean p = dao.deletePayment(jumunnum)>0?true:false;
		boolean j = dao.deleteJumun(jumunnum)>0?true:false;
		return p&j;
	}

	@Override
	public boolean updateJumstatConfirm(String jumunnum) {
		return (dao.updateJumstatConfirm(jumunnum)>0)?true:false;
	}

	@Override
	public boolean updateJumstatAutoConfirm() {
		return (dao.updateJumstatAutoConfirm()>0)?true:false;
	}

	@Override
	@Transactional
	public boolean updateJumunPayhistoryDeposit(String jumunnum) {
		boolean j = dao.updateJumunDeposit(jumunnum);
		boolean p = dao.updatePayhistoryDeposit(jumunnum);
		return (j&p);
	}


	@Override
	public boolean insertPayhistory(Payhistory_DTO dto) {
		return (dao.insertPayhistory(dto)>0)?true:false;
	}

	@Override
	public int countMemberPayHistory() {
		return dao.countMemberPayHistory();
	}

	@Override
	public List<Payhistory_DTO> memberPayHistoryList(Map<String, Object> map) {
		return dao.memberPayHistoryList(map);
	}

	@Override
	public int countAllPayHistory() {
		return dao.countAllPayHistory();
	}

	@Override
	public List<Payhistory_DTO> allPayHistoryList(RowNum_DTO dto) {
		return dao.allPayHistoryList(dto);
	}

	@Override
	public String selectJumunnum(String id) {
		return dao.selectJumunnum(id);
	}

}
