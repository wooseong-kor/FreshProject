package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.fresh.dto.AddrList_DTO;
import com.min.fresh.dto.Couponhistory_DTO;
import com.min.fresh.dto.Hoogi_DTO;
import com.min.fresh.dto.Jumunpage_DTO;
import com.min.fresh.dto.Member_DTO;
import com.min.fresh.dto.Payhistory_DTO;
import com.min.fresh.dto.QA_GO_DTO;

@Repository
public class BoardDao_Impl implements IBoardDao {

	private final String NS = "com.min.fresh.IBoardDao.";
	private Logger log = LoggerFactory.getLogger(BoardDao_Impl.class);

	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<Couponhistory_DTO> couhistoryList(String id) {
		log.info("couhistoryList 실행");
		return session.selectList(NS + "couhistoryList", id);
	}

	@Override
	public Payhistory_DTO gradeList(String id) {
		log.info("gradeList 실행");
		return session.selectOne(NS + "gradeList", id);
	}

	@Override
	public int insertAddrlist(AddrList_DTO aDto) {
		log.info("insertAddrlist 실행");
		return session.insert(NS + "insertAddrlist", aDto);
	}

	@Override
	public int updateAddrlist(AddrList_DTO aDto) {
		log.info("updateAddrlist 실행");
		return session.update(NS + "updateAddrlist", aDto);
	}

	@Override
	public int deleteAddrlist(String bsgcode, String id) {
		log.info("deleteAddrlist 실행");
		return session.delete(NS + "deleteAddrlist", id);
	}

	@Override
	public List<AddrList_DTO> addrlistIdList(String id) {
		log.info("addrlistIdList 실행");
		return session.selectList(NS+"addrlistIdList",id);
	}

	@Override
	public int countMemberAddrList(String id) {
		log.info("countMemberAddrList 실행");
		return session.selectOne(NS + "countMemberAddrList", id);
	}

	@Override
	public AddrList_DTO addrListOne(Map<String, Object> map) {
		log.info("addrListOne 실행");
		return session.selectOne(NS + "addrListOne", map);
	}

	@Override
	public Payhistory_DTO jumunMylist(Map<String, Object> map) {
		log.info("jumunMylist 실행");
		return session.selectOne(NS + "jumunMylist", map);
	}

	@Override
	public int insertFileimg(QA_GO_DTO qDto) {
		log.info("insertFileimg 실행");
		return session.insert(NS + "insertFileimg", qDto);
	}

	@Override
	public int deleteFileimg(int fileseq) {
		log.info("deleteFileimg 실행");
		return session.delete(NS + "deleteFileimg", fileseq);
	}

	@Override
	public int insertQago(QA_GO_DTO qDto) {
		log.info("insertQago 실행");
		return session.insert(NS + "insertQago", qDto);
	}

	@Override
	public int updateQago(QA_GO_DTO qDto) {
		log.info("updateQago 실행");
		return session.update(NS + "updateQago", qDto);
	}

	@Override
	public int deleteQago(int seq) {
		log.info("deleteQago 실행");
		return session.delete(NS + "deleteQago", seq);
	}

	@Override
	public QA_GO_DTO qagoOne(int seq) {
		log.info("qagoOne 실행");
		return session.selectOne(NS + "qagoOne", seq);
	}

	@Override
	public int insertAnswer(Map<String, Object> map) {
		log.info("insertAnswer 실행");
		return session.insert(NS + "insertAnswer", map);
	}

	@Override
	public int updateAnswer(Map<String, Object> map) {
		log.info("updateAnswer 실행");
		return session.update(NS + "updateAnswer", map);
	}

	@Override
	public int deleteAnswer(int seq) {
		log.info("deleteAnswer 실행");
		return session.delete(NS + "deleteAnswer", seq);
	}

	@Override
	public QA_GO_DTO answerOne(int seq) {
		log.info("answerOne 실행");
		return session.selectOne(NS + "answerOne", seq);
	}

	@Override
	public Jumunpage_DTO jumunpageListScroll(String sangcode) {
		log.info("jumunpageListScroll 실행");
		Jumunpage_DTO lists = session.selectOne(NS + "jumunpageListScroll", sangcode);
		return lists;
	}

	@Override
	public Jumunpage_DTO jumunpageDeepListScroll(String sangname) {
		log.info("jumunpageDeepListScroll 실행");
		return session.selectOne(NS + "jumunpageDeepListScroll", sangname);
	}

	@Override
	public Jumunpage_DTO searchJumunpageList(String sangname) {
		log.info("searchJumunpageList 실행");
		return session.selectOne(NS + "searchJumunpageList", sangname);
	}

	@Override
	public Jumunpage_DTO jumunpageDeepOne(String sangpgnum) {
		log.info("jumunpageDeepOne 실행");
		return session.selectOne(NS + "jumunpageDeepOne", sangpgnum);
	}

	@Override
	public int selectJaegoCnt(String sangcode) {
		log.info("selectJaegoCnt 실행");
		return session.selectOne(NS + "selectJaegoCnt", sangcode);
	}

	@Override
	public int insertHoogi(Hoogi_DTO hDto) {
		log.info("insertHoogi 실행");
		return session.insert(NS + "insertHoogi", hDto);
	}

	@Override
	public int deleteHoogi(int seq) {
		log.info("deleteHoogi 실행");
		return session.delete(NS + "deleteHoogi", seq);
	}

	@Override
	public int updateHoogi(Hoogi_DTO hDto) {
		log.info("updateHoogi 실행");
		return session.delete(NS + "updateHoogi", hDto);
	}

	@Override
	public int countSangpgnumHoogi(String sangpgnum) {
		log.info("countSangpgnumHoogi 실행");
		return session.selectOne(NS + "countSangpgnumHoogi", sangpgnum);
	}

	@Override
	public Hoogi_DTO sangpgnumHoogiList(Map<String, Object> map) {
		log.info("sangpgnumHoogiList 실행");
		Hoogi_DTO dto = session.selectOne(NS + "sangpgnumHoogiList", map);
		return dto;
	}

	@Override
	public Hoogi_DTO hoogiOne(Map<String, Object> map) {
		log.info("hoogiOne 실행");
		return session.selectOne(NS + "hoogiOne", map);
	}

	@Override
	public int insertJumunpage(Jumunpage_DTO jDto) {
		log.info("insertJumunpage 실행");
		return session.insert(NS + "insertJumunpage", jDto);
	}

	@Override
	public int insertProductimg(Jumunpage_DTO jDto) {
		log.info("insertProductimg 실행");
		return session.insert(NS + "insertProductimg", jDto);
	}

	@Override
	public int cartInsert(Member_DTO mDto) {
		log.info("cartInsert 실행");
		return session.insert(NS + "cartInsert", mDto);
	}

	@Override
	public int cartUpdate(Member_DTO mDto) {
		log.info("cartUpdate 실행");
		return session.insert(NS + "cartUpdate", mDto);
	}

	@Override
	public Member_DTO memberCartList(Map<String, Object> map) {
		log.info("memberCartList 실행");
		return session.selectOne(NS + "memberCartList", map);
	}

	@Override
	public int cartDelete(int seq) {
		log.info("cartDelete 실행");
		return session.delete(NS + "cartDelete", seq);
	}

}
