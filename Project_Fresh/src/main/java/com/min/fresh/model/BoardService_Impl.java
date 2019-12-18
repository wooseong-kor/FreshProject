package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.fresh.dto.AddrList_DTO;
import com.min.fresh.dto.Couponhistory_DTO;
import com.min.fresh.dto.Hoogi_DTO;
import com.min.fresh.dto.Jumunpage_DTO;
import com.min.fresh.dto.Member_DTO;
import com.min.fresh.dto.Payhistory_DTO;
import com.min.fresh.dto.ProductImg_DTO;
import com.min.fresh.dto.QA_GO_DTO;

@Service
public class BoardService_Impl implements IBoardServiceDao {

	private Logger log=LoggerFactory.getLogger(BoardService_Impl.class);
	
	@Autowired
	private IBoardDao dao;
	
	@Override
	public List<Couponhistory_DTO> couhistoryList(String id) {
		log.info("couhistoryList");
		return dao.couhistoryList(id);
	}

	@Override
	public Payhistory_DTO gradeList(String id) {
		log.info("gradeList");
		return dao.gradeList(id);
	}

	@Override
	public boolean insertAddrlist(AddrList_DTO aDto) {
		log.info("insertAddrlist");
		return (dao.insertAddrlist(aDto)>0)?true:false;
	}

	@Override
	public boolean updateAddrlist(AddrList_DTO aDto) {
		log.info("updateAddrlist");
		return (dao.updateAddrlist(aDto)>0)?true:false;
	}

	@Override
	public boolean deleteAddrlist(String bsgcode, String id) {
		log.info("deleteAddrlist");
		return (dao.deleteAddrlist(bsgcode, id)>0)?true:false;
	}

	@Override
	public List<AddrList_DTO> addrlistIdList(String id) {
		log.info("addrlistIdList");
		return dao.addrlistIdList(id);
	}

	@Override
	public int countMemberAddrList(String id) {
		log.info("countMemberAddrList");
		return dao.countMemberAddrList(id);
	}

	@Override
	public AddrList_DTO addrListOne(Map<String, Object> map) {
		log.info("addrListOne");
		return dao.addrListOne(map);
	}

	@Override
	public Payhistory_DTO jumunMylist(Map<String, Object> map) {
		log.info("addrListOne");
		return dao.jumunMylist(map);
	}

	@Override
	public boolean insertFileimg(QA_GO_DTO qDto) {
		log.info("addrListOne");
		return (dao.insertFileimg(qDto)>0)?true:false;
	}

	@Override
	public boolean deleteFileimg(int fileseq) {
		log.info("addrListOne");
		return (dao.deleteFileimg(fileseq)>0)?true:false;
	}

	@Override
	public boolean insertQago(QA_GO_DTO qDto) {
		log.info("addrListOne");
		return (dao.insertQago(qDto)>0)?true:false;
	}

	@Override
	public boolean updateQago(QA_GO_DTO qDto) {
		log.info("updateQago");
		return (dao.updateQago(qDto)>0)?true:false;
	}

	@Override
	public boolean deleteQago(int seq) {
		log.info("deleteQago");
		return (dao.deleteQago(seq)>0)?true:false;
	}

	@Override
	public QA_GO_DTO qagoOne(int seq) {
		log.info("qagoOne");
		return qagoOne(seq);
	}

	@Override
	public boolean insertAnswer(Map<String, Object> map) {
		log.info("insertAnswer");
		return (dao.insertAnswer(map)>0)?true:false;
	}

	@Override
	public boolean updateAnswer(Map<String, Object> map) {
		log.info("updateAnswer");
		return (dao.updateAnswer(map)>0)?true:false;
	}

	@Override
	public boolean deleteAnswer(int seq) {
		log.info("deleteAnswer");
		return (dao.deleteAnswer(seq)>0)?true:false;
	}

	@Override
	public QA_GO_DTO answerOne(int seq) {
		log.info("answerOne");
		return dao.answerOne(seq);
	}

	@Override
	public List<Jumunpage_DTO> jumunpageListScroll(String sangcode) {
		log.info("jumunpageListScroll");
		return dao.jumunpageListScroll(sangcode);
	}

	@Override
	public List<Jumunpage_DTO> jumunpageDeepListScroll(String sangname) {
		log.info("jumunpageDeepListScroll");
		return dao.jumunpageDeepListScroll(sangname);
	}

	@Override
	public Jumunpage_DTO searchJumunpageList(String sangname) {
		log.info("searchJumunpageList");
		return dao.searchJumunpageList(sangname);
	}

	@Override
	public Jumunpage_DTO jumunpageDeepOne(String sangpgnum) {
		log.info("jumunpageDeepOne");
		return dao.jumunpageDeepOne(sangpgnum);
	}

	@Override
	public int selectJaegoCnt(String sangcode) {
		log.info("selectJaegoCnt");
		return dao.selectJaegoCnt(sangcode);
	}

	@Override
	public boolean insertHoogi(Hoogi_DTO hDto) {
		log.info("insertHoogi");
		return (dao.insertHoogi(hDto)>0)?true:false;
	}

	@Override
	public boolean deleteHoogi(int seq) {
		log.info("deleteHoogi");
		return (dao.deleteHoogi(seq)>0)?true:false;
	}

	@Override
	public boolean updateHoogi(Hoogi_DTO hDto) {
		log.info("updateHoogi");
		return (dao.updateHoogi(hDto)>0)?true:false;
	}

	@Override
	public int countSangpgnumHoogi(String sangpgnum) {
		log.info("countSangpgnumHoogi");
		return dao.countSangpgnumHoogi(sangpgnum);
	}

	@Override
	public Hoogi_DTO sangpgnumHoogiList(Map<String, Object> map) {
		log.info("sangpgnumHoogiList");
		return dao.sangpgnumHoogiList(map);
	}

	@Override
	public Hoogi_DTO hoogiOne(Map<String, Object> map) {
		log.info("hoogiOne");
		return dao.hoogiOne(map);
	}

	@Override
	public boolean insertJumunpage(Jumunpage_DTO jDto) {
		log.info("insertJumunpage");
		return (dao.insertJumunpage(jDto)>0)?true:false;
	}

	@Override
	public boolean insertProductimg(ProductImg_DTO pDto) {
		log.info("insertProductimg");
		return (dao.insertProductimg(pDto)>0)?true:false;
	}

	@Override
	public boolean cartInsert(Member_DTO mDto) {
		log.info("cartInsert");
		return (dao.cartInsert(mDto)>0)?true:false;
	}

	@Override
	public boolean cartUpdate(Member_DTO mDto) {
		log.info("cartUpdate");
		return (dao.cartUpdate(mDto)>0)?true:false;
	}

	@Override
	public Member_DTO memberCartList(Map<String, Object> map) {
		log.info("memberCartList");
		return dao.memberCartList(map);
	}

	@Override
	public boolean cartDelete(int seq) {
		log.info("cartDelete");
		return (dao.cartDelete(seq)>0)?true:false;
	}

}
