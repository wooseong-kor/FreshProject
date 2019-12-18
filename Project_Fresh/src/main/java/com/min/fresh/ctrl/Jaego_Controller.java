package com.min.fresh.ctrl;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.fresh.dto.Ipgo_DTO;
import com.min.fresh.dto.Jaego_DTO;
import com.min.fresh.dto.Product_DTO;
import com.min.fresh.dto.Pyegi_DTO;
import com.min.fresh.dto.RowNum_DTO;
import com.min.fresh.model.IJaegoService;
import com.min.fresh.model.IProductService;

@Controller
public class Jaego_Controller {

	
	private Logger log = LoggerFactory.getLogger(Jaego_Controller.class);
	
	@Autowired
	private IJaegoService jvice;
	
	@Autowired
	private IProductService service;

	
	/**
	 * 재고관리 페이지 이동
	 * @return 재고관리 페이지
	 */
	@RequestMapping(value = "/jaego.do", method = RequestMethod.GET)
	public String Jaego() {
		log.info("재고관리 페이지 이동");
		return "JaegoManagement";
	}
	
	/**
	 *  재고 정보조회
	 * @return 상품 전체 정보 json형태
	 */
	@RequestMapping(value = "/jaegoJSON.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String jagoJqgrid (RowNum_DTO dto) {
		log.info("Jaego JSON");
		service.updateProductSoldout(); // 자동 품절 처리
		service.updateProductSale(); // 자동 판매중 처리 (단종아니고, 재고상태Good일때)
		JSONObject json = null;
		List<Jaego_DTO> lists = jvice.allGoodJaegoList(dto);
		json = obejctJSON1(lists); // 상품조회결과를 json에 담는다.
		return json.toString();
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject obejctJSON1 (List<Jaego_DTO> lists) {
		JSONObject json = new JSONObject(); // {}
		JSONArray jlists = new JSONArray(); // []
		JSONObject jdto = null; // [{},{},{}]
		
		for (Jaego_DTO dto : lists) {
			jdto = new JSONObject();
			jdto.put("jaegocode", dto.getJaegocode()); // 재고코드
			jdto.put("sangcode", dto.getSangcode()); //상품코드
			jdto.put("jaegocnt", dto.getJaegocnt()); //재고량
			jdto.put("jaegostat", dto.getJaegostat()); //재고상태
			jlists.add(jdto); // []안에 {},{} 넣기 => [{},{},{}]
		}
		json.put("jaegoAllList", jlists);
		return json;
	}
	
	/**
	 * 재고 상품 등록
	 * @return 상품정보 그리드
	 */
	@RequestMapping(value = "/jaegoAdd.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String jaegoAdd(Jaego_DTO sDto) {
		log.info("★★★★★상품 Edit 후 DTO확인★★★★★");
		boolean cntP = jvice.insertJaego(sDto);
		return cntP?"redirect:/jaegoJSON.do":"error";
	}


	@RequestMapping(value = "/ipgoJSON.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String ipgoJqgrid (RowNum_DTO dto) {
		log.info("Ipgo JSON");
		service.updateProductSoldout(); // 자동 품절 처리
		service.updateProductSale(); // 자동 판매중 처리 (단종아니고, 재고상태Good일때)
		JSONObject json = null;
		List<Ipgo_DTO> lists = jvice.allIpgoList(dto);
		json = obejctJSON(lists); // 상품조회결과를 json에 담는다.
		return json.toString();
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject obejctJSON (List<Ipgo_DTO> lists) {
		JSONObject json = new JSONObject(); // {}
		JSONArray jlists = new JSONArray(); // []
		JSONObject jdto = null; // [{},{},{}]
		
		for (Ipgo_DTO dto : lists) {
			jdto = new JSONObject();
			jdto.put("ipgonum", dto.getIpgonum()); // 입고번호
			jdto.put("jaegocode", dto.getJaegocode()); // 재고코드
			jdto.put("ipgodate", dto.getIpgodate()); //입고일자
			jdto.put("ipgocnt", dto.getIpgocnt()); //입고수량
			jdto.put("expdate", dto.getExpdate()); //유통기한
			jlists.add(jdto); // []안에 {},{} 넣기 => [{},{},{}]
		}
		json.put("allIpgoList", jlists);
		return json;
	}
	
	/**
	 * 입고 상품 등록
	 * @return 상품정보 그리드
	 */
	@RequestMapping(value = "/ipgoAdd.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String ipgoAdd(Ipgo_DTO pDto) {
		log.info("★★★★★상품 Edit 후 DTO확인★★★★★");
		boolean cntP = jvice.insertIpgo(pDto);
		return cntP?"redirect:/ipgoAdd.do":"error";
	}
	
	

	/**
	 *  재고 정보조회
	 * @return 상품 전체 정보 json형태
	 */
	@RequestMapping(value = "/pyegiJSON.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String pyegiJqgrid (RowNum_DTO dto) {
		log.info("Jaego JSON");
		service.updateProductSoldout(); // 자동 품절 처리
		service.updateProductSale(); // 자동 판매중 처리 (단종아니고, 재고상태Good일때)
		JSONObject json = null;
		List<Pyegi_DTO> lists = jvice.allPyegiList(dto);
		json = obejctJSON3(lists); // 상품조회결과를 json에 담는다.
		return json.toString();
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject obejctJSON3 (List<Pyegi_DTO> lists) {
		JSONObject json = new JSONObject(); // {}
		JSONArray jlists = new JSONArray(); // []
		JSONObject jdto = null; // [{},{},{}]
		
		for (Pyegi_DTO dto : lists) {
			jdto = new JSONObject();
			jdto.put("ipgonum", dto.getPyeginum()); // 입고번호
			jdto.put("jaegocode", dto.getJaegocode()); // 재고코드
			jdto.put("ipgodate", dto.getPyegicnt()); //입고일자
			jdto.put("ipgocnt", dto.getPyegiflag()); //입고수량
			jdto.put("expdate", dto.getPyegisayu()); //유통기한
			jlists.add(jdto); // []안에 {},{} 넣기 => [{},{},{}]
		}
		json.put("allIpgoList", jlists);
		return json;
	}

	
	
//	/**
//	 * 상품 판매가, 상태 수정
//	 * @return 상품정보 그리드
//	 */
//	@RequestMapping(value = "/productEdit.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
//	@ResponseBody
//	public String productEdit(Ipgo_DTO pDto) {
//		log.info("★★★★★상품 Edit 후 DTO확인★★★★★");
//		int pEdit = jvice.insupdateProductPriceSangstat(pDto); // 상품 - 판매가, 상태 수정
//		return (pEdit > 0)?"redirect:/productJSON.do":"error";
//	}
//	
//	
//
	/**
	 * 폐기 상품 등록
	 * @param jDto 재고정보
	 * @param pDto 상품정보
	 * @return 상품정보 그리드
	 */
	@RequestMapping(value = "/pyegiAdd.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String pyegiAdd(Pyegi_DTO pDto) {
		log.info("★★★★★상품 Edit 후 DTO확인★★★★★");
		boolean cntP = jvice.insertPyegi(pDto);
		return cntP?"redirect:/productJSON.do":"error";
	}
	
}
