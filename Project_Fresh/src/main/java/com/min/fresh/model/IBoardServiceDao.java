package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import com.min.fresh.dto.AddrList_DTO;
import com.min.fresh.dto.Couponhistory_DTO;
import com.min.fresh.dto.Hoogi_DTO;
import com.min.fresh.dto.Jumunpage_DTO;
import com.min.fresh.dto.Member_DTO;
import com.min.fresh.dto.Payhistory_DTO;
import com.min.fresh.dto.QA_GO_DTO;

public interface IBoardServiceDao {

//	마이페이지-쿠폰 내역 조회
	public List<Couponhistory_DTO> couhistoryList(String id);
//	마이페이지-등급 조회
	public Payhistory_DTO gradeList(String id);
//	배송지 입력
	public boolean insertAddrlist(AddrList_DTO aDto);
//	배송지 수정
	public boolean updateAddrlist(AddrList_DTO aDto);
//	배송지 삭제
	public boolean deleteAddrlist(String bsgcode,String id);
//	배송지 목록 조회
	public List<AddrList_DTO> addrlistIdList(String id);
//  배송지 3개까지 하기 위한 갯수 확인
	public int countMemberAddrList(String id);
//	배송지 상세 조회
	public AddrList_DTO addrListOne(Map<String, Object> map);
//	주문내역 상세보기
	public Payhistory_DTO jumunMylist(Map<String, Object> map);
//	게시판 파일 업로드
	public boolean insertFileimg(QA_GO_DTO qDto);
//	게시판 파일 삭제
	public boolean deleteFileimg(int fileseq);
//	QnA 글 작성
	public boolean insertQago(QA_GO_DTO qDto);
//	QnA 글 수정
	public boolean updateQago(QA_GO_DTO qDto);
//	QnA,공지사항 글 삭제
	public boolean deleteQago(int seq);
//	QnA,공지사항 글 상세 보기
	public QA_GO_DTO qagoOne(int seq);
//	QnA 답변 글 작성
	public boolean insertAnswer(Map<String, Object> map);
//	QnA 답변 글 수정
	public boolean updateAnswer(Map<String, Object> map);
//	QnA 답변 글 삭제 
	public boolean deleteAnswer(int seq);
//	QnA 답변 글 조회
	public QA_GO_DTO answerOne(int seq);
//	카테고리 별 상품 목록 조회
	public Jumunpage_DTO jumunpageListScroll(String sangcode);
//	세부 품목 별 상품 목록 조회
	public Jumunpage_DTO jumunpageDeepListScroll(String sangname);
//	사용자의 상품 검색 
	public Jumunpage_DTO searchJumunpageList(String sangname);
//	상품 상세보기(구매페이지)
	public Jumunpage_DTO jumunpageDeepOne(String sangpgnum);
//	상품 수량 가져오기(품절위해)
	public int selectJaegoCnt(String sangcode);
//	후기 입력
	public boolean insertHoogi(Hoogi_DTO hDto);
//	후기 삭제
	public boolean deleteHoogi(int seq);
//	후기 수정
	public boolean updateHoogi(Hoogi_DTO hDto);
//	후기 페이지별 후기 갯수
	public int countSangpgnumHoogi(String sangpgnum);
//	후기 페이지별 페이징
	public Hoogi_DTO sangpgnumHoogiList(Map<String, Object> map);
//	후기 상세 조회
	public Hoogi_DTO hoogiOne(Map<String, Object> map);
//	상품 구매 페이지 입력
	public boolean insertJumunpage(Jumunpage_DTO jDto);
//	상품 이미지 입력
	public boolean insertProductimg(Jumunpage_DTO jDto);
//	장바구니 입력
	public boolean cartInsert(Member_DTO mDto);
//	장바구니 수정
	public boolean cartUpdate(Member_DTO mDto);
//	장바구니 목록 조회
	public Member_DTO memberCartList(Map<String, Object> map);
//	장바구니 삭제 
	public boolean cartDelete(int seq);
	
}
