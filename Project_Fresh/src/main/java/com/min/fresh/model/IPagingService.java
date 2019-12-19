package com.min.fresh.model;

import java.util.List;
import java.util.Map;

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

public interface IPagingService {

	//전체 회원 수
	public int countAllMember();
	//활동중인 회원 수
	public int countMember();
	//전체 회원수 페이징
	public List<Member_DTO> allMemberList(RowNum_DTO dto);
	//활동중인 회원수 페이징
	public List<Member_DTO> memberList(RowNum_DTO dto);
	//한 회원의 전체 장바구니 수
	public int countMemberCart(String id);
	//한 회원의 전체 장바구니 수 페이징
	public List<Member_DTO> memberCartList(Map<Object,String> map);
	//QA게시판 회원별 글수
	public int countMemberQa(String id);
	//QA게시판 회원별 글수 페이징
	public List<QA_GO_DTO> memberQaList(Map<String, Object> map);
	//QA게시판 관리자용 전체글 수
	public int countAllQa();
	//QA게시판 관리자용 전체글 수
	public List<QA_GO_DTO> allQaList(RowNum_DTO dto);
	//공지사항게시판 전체 게시글 수
	public int countAllGo();
	//공지사항게시판 전체 게시글 수 페이징
	public List<QA_GO_DTO> allGoList(RowNum_DTO dto);
	//QA 관리자가 답변을달면 제목 변경해주는 쿼리 이건 다른 매퍼로 이동
	public int updateTitleQa(Map<String, Object> map);
//	//쿠폰 내역 아이디별 전체 개수
//	public int countMemberCouponHistory(String id);
//	//쿠폰 내역 아이디별 전체 개수 페이징
//	public List<Couponhistory_DTO> memberCounponHistoryList(Map<String, Object> map);
	//아이디별 주소록 몇개인지 알려주는 쿼리(3개 이상이면 더 못만들게 화면에서 처리할 것) 다른 매퍼로 이동
	public int countMemberAddrList(String id);
//	//회원별 결제 내역 수
//	public int countMemberPayHistory(String id);
//	//회원별 결제 내역 페이징
//	public List<Payhistory_DTO> memberPayHistoryList(Map<String, Object> map);
//	//전체 결제 내역 수
//	public int countAllPayHistory();
//	//전체 결제 내역 페이징 관리자용
//	public List<Payhistory_DTO> allPayHistoryList(RowNum_DTO dto);
//	//배송지 보기 (주문내역,결제내역에서 배송지코드만 나오게 했는데 버튼을 누르면 상세내용이 아작스로 표출) 다른 매퍼로 이동
//	public AddrList_DTO addrListOne(String jumunnum);
//	//회원별 주문 내역
	public int countMemberJumun(String id);
//	//회원별 주문 내역 페이징
	public List<Jumun_DTO> memberJumunList(Map<String, Object> map);
//	//전체 주문내역 수
	public int countAllJumun();
//	//전체 주문내역 페이징 관리자용
//	public List<Jumun_DTO> allJumunList(RowNum_DTO dto);
	//상품 상세 페이지 전체 개수
	public int countAllJumunpage();
	//상품 상세 페이지 전체 페이징
	public List<Jumunpage_DTO> allJumunpageList(Map<String, Object> map);
	//상품 품목/제목별 개수
	public int countDynamicJumunpage(Map<String, String> map);
	//상품 품목/제목별 페이징
	public List<Jumunpage_DTO> dynamicJumunList(Map<String, Object> map);
	//후기 페이지별 후기 개수 
	public int countSangpgnumHoogi(String sangpgnum);
	//후기 페이지별 후기 페이징
	public List<Hoogi_DTO> sangpgnumHoogiList(Map<String, Object> map);
//	//상품 개수
//	public int countAllProduct();
//	//상품 페이징
//	public List<Product_DTO> allProductList(RowNum_DTO dto);
//	//재고 개수
//	public int countAllJaego();
//	//재고 페이징
//	public List<Jaego_DTO> allJaegoList(RowNum_DTO dto);
//	//입고 개수
//	public int countAllIpgo();
//	//입고 페이징
//	public List<Ipgo_DTO> allIpgoList(RowNum_DTO dto);
//	//폐기 개수
//	public int countAllPyegi();
//	//폐기 페이징
//	public List<Pyegi_DTO> allPyegiList(RowNum_DTO dto);
}
