package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import com.min.fresh.dto.Couponhistory_DTO;
import com.min.fresh.dto.RowNum_DTO;

public interface ICouponMileageDao {

	//마일리지 적립 R
	public int updateMileageRMember(Map<String, Object> map);
	//마일리지 적립 B
	public int updateMileageBMember(Map<String, Object> map);
	//마일리지 적립 S
	public int updateMileageSMember(Map<String, Object> map);
	//마일리지 적립 V
	public int updateMileageVMember(Map<String, Object> map);
	//결재시 회원 보유 마일리지 차감
	public int updateMileageOneMember(Map<String, Object> map); 
	//결재 할때 결제금액 주문금액에 사용마일리지빼서 바꿔줌
	public int updatePaymoneyMOne(String jumunnum);
	//쿠폰 사용시 쿠폰 상태 변경
	public int updateUseflagOne(int couseq);
	//가입 쿠폰 지급, 쿼리수정
	public int insertCouponhistoryG(String id);
	//그외 쿠폰 지급, 쿼리 수정
	public int insertCouponhistoryB(String id);
	//그외 쿠폰 지급, 쿼리 수정
	public int insertCouponhistoryS(String id);
	//그외 쿠폰 지급, 쿼리 수정
	public int insertCouponhistoryV(String id);
	//결제할때 결제금액에 쿠폰금액 차감된걸로 결제금액 변경(가입)
	public int updatePaymoneyGOne(Map<String, Object> map);
	//결제할때 결제금액에 쿠폰금액 차감된걸로 결제금액 변경(브론즈)
	public int updatePaymoneyBOne(Map<String, Object> map);
	//결제할때 결제금액에 쿠폰금액 차감된걸로 결제금액 변경(실버)
	public int updatePaymoneySOne(Map<String, Object> map);
	//결제할때 결제금액에 쿠폰금액 차감된걸로 결제금액 변경(VIP)
	public int updatePaymoneyVOne(Map<String, Object> map);
	//만료된 가입쿠폰 지우기
	public int updateUseflagAutoOne(String id);
	//만료된 그외의 쿠폰 지우기
	public int updateCouponUseflaghistory();
	//쿠폰 내역 아이디별 전체 개수
	public int countMemberCouponHistory(String id);
	//쿠폰 내역 아이디별 전체 개수 페이징
	public List<Couponhistory_DTO> memberCounponHistoryList(Map<String, Object> map);
	//쿠폰 내역 전체 개수
	public int countAllCouponHistory();
	//쿠폰 내역 전체 개수 페이징
	public List<Couponhistory_DTO> allCounponHistoryList(RowNum_DTO dto);
	//아이디별 사용가능한 쿠폰 출력
	public List<Couponhistory_DTO> memberUseMineCou(String id);
	
}
