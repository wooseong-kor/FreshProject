package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class PagingService_Impl implements IPagingService {

	@Autowired
	private IPagingDao dao;
	
	@Override
	public int countAllMember() {
		return dao.countAllMember();
	}

	@Override
	public int countMember() {
		return dao.countMember();
	}

	@Override
	public List<Member_DTO> allMemberList(RowNum_DTO dto) {
		return dao.allMemberList(dto);
	}

	@Override
	public List<Member_DTO> memberList(RowNum_DTO dto) {
		return dao.memberList(dto);
	}

	@Override
	public int countMemberCart(String id) {
		return dao.countMemberCart(id);
	}

	@Override
	public int countMemberQa(String id) {
		return dao.countMemberQa(id);
	}

	@Override
	public List<QA_GO_DTO> memberQaList(Map<String, Object> map) {
		return dao.memberQaList(map);
	}

	@Override
	public int countAllQa() {
		return dao.countAllQa();
	}

	@Override
	public List<QA_GO_DTO> allQaList(RowNum_DTO dto) {
		return dao.allQaList(dto);
	}

	@Override
	public int countAllGo() {
		return dao.countAllGo();
	}

	@Override
	public List<QA_GO_DTO> allGoList(RowNum_DTO dto) {
		return dao.allGoList(dto);
	}

	@Override
	public int updateTitleQa(Map<String, Object> map) {
		return dao.updateTitleQa(map);
	}

//	@Override
//	public int countMemberCouponHistory(String id) {
//		return dao.countMemberCouponHistory(id);
//	}
//
//	@Override
//	public List<Couponhistory_DTO> memberCounponHistoryList(Map<String, Object> map) {
//		return dao.memberCounponHistoryList(map);
//	}

	@Override
	public int countMemberAddrList(String id) {
		return dao.countMemberAddrList(id);
	}

//	@Override
//	public int countMemberPayHistory(String id) {
//		return dao.countMemberPayHistory(id);
//	}
//
//	@Override
//	public List<Payhistory_DTO> memberPayHistoryList(Map<String, Object> map) {
//		return dao.memberPayHistoryList(map);
//	}
//
//	@Override
//	public int countAllPayHistory() {
//		return dao.countAllPayHistory();
//	}
//
//	@Override
//	public List<Payhistory_DTO> allPayHistoryList(RowNum_DTO dto) {
//		return dao.allPayHistoryList(dto);
//	}
//
//	@Override
//	public AddrList_DTO addrListOne(String jumunnum) {
//		return dao.addrListOne(jumunnum);
//	}
//
//	@Override
//	public int countMemberJumun(String id) {
//		return dao.countMemberJumun(id);
//	}
//
//	@Override
//	public List<Jumun_DTO> memberJumunList(Map<String, Object> map) {
//		return dao.memberJumunList(map);
//	}
//
//	@Override
//	public int countAllJumun() {
//		return dao.countAllJumun();
//	}
//
//	@Override
//	public List<Jumun_DTO> allJumunList(RowNum_DTO dto) {
//		return dao.allJumunList(dto);
//	}

	@Override
	public int countAllJumunpage() {
		return dao.countAllJumunpage();
	}

	@Override
	public List<Jumunpage_DTO> allJumunpageList(Map<String, Object> map) {
		return dao.allJumunpageList(map);
	}

	@Override
	public int countDynamicJumunpage(Map<String, String> map) {
		return dao.countDynamicJumunpage(map);
	}

	@Override
	public List<Jumunpage_DTO> dynamicJumunList(Map<String, Object> map) {
		return dao.dynamicJumunList(map);
	}

	@Override
	public int countSangpgnumHoogi(String sangpgnum) {
		return dao.countSangpgnumHoogi(sangpgnum);
	}

	@Override
	public List<Hoogi_DTO> sangpgnumHoogiList(Map<String, Object> map) {
		return dao.sangpgnumHoogiList(map);
	}

//	@Override
//	public int countAllProduct() {
//		return dao.countAllProduct();
//	}
//
//	@Override
//	public List<Product_DTO> allProductList(RowNum_DTO dto) {
//		return dao.allProductList(dto);
//	}

//	@Override
//	public int countAllJaego() {
//		return dao.countAllJaego();
//	}
//
//	@Override
//	public List<Jaego_DTO> allJaegoList(RowNum_DTO dto) {
//		return dao.allJaegoList(dto);
//	}
//
//	@Override
//	public int countAllIpgo() {
//		return dao.countAllIpgo();
//	}
//
//	@Override
//	public List<Ipgo_DTO> allIpgoList(RowNum_DTO dto) {
//		return dao.allIpgoList(dto);
//	}
//
//	@Override
//	public int countAllPyegi() {
//		return dao.countAllPyegi();
//	}
//
//	@Override
//	public List<Pyegi_DTO> allPyegiList(RowNum_DTO dto) {
//		return dao.allPyegiList(dto);
//	}

	@Override
	public List<Member_DTO> memberCartList(Map<Object, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
