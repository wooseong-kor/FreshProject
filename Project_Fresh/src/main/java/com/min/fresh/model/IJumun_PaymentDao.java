package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import com.min.fresh.dto.AddrList_DTO;
import com.min.fresh.dto.Jumun_DTO;
import com.min.fresh.dto.Payhistory_DTO;
import com.min.fresh.dto.RowNum_DTO;

public interface IJumun_PaymentDao {
	
	//주문을 입력한다
	public int insertJumun(Jumun_DTO dto);
	//회원의 주문내역 조회
	//회원별 주문 내역 수
	public int countMemberJumun(String id);
	//회원별 주문 내역 페이징
	public List<Jumun_DTO> memberJumunList(Map<String, Object> map);
	//전체 주문내역 수 관리자용
	public int countAllJumun();
	//전체 주문내역 페이징 관리자용 관리자용
	public List<Jumun_DTO> allJumunList(RowNum_DTO dto);
	//배송지 보기 (주문내역,결제내역에서 배송지코드만 나오게 했는데 버튼을 누르면 상세내용이 아작스로 표출)
	public AddrList_DTO addrListOne(String jumunnum);
	//관리자, 회원 주문을 취소한다 회원은 결제 전에만 가능
	public int deleteJumun(String jumunnum);
	//구매확정 진행시 교환불가하다
	public int updateJumstatConfirm(String jumunnum);
	//주문일자 기준 1개월 이내 가능하며, 이후 자동으로 확정 처리된다.
	public int updateJumstatAutoConfirm();
	//돈이 결제 되었을 때 결제 상태와 주문 상태를 바꿈
	public boolean updateJumunDeposit(String jumunnum);
	//같이 실행됨
	public boolean updatePayhistoryDeposit(String jumunnum);
	//결제 정보 입력	
	public int insertPayhistory(Payhistory_DTO dto);
	//회원의 결제 내역 조회
	//회원별 결제 내역 수
	public int countMemberPayHistory();
	//회원별 결제 내역 페이징
	public List<Payhistory_DTO> memberPayHistoryList(Map<String, Object> map);
	//전체 결제 내역 수 관리자용
	public int countAllPayHistory();
	//전체 결제 내역 페이징 관리자용
	public List<Payhistory_DTO> allPayHistoryList(RowNum_DTO dto);
	
	
}
