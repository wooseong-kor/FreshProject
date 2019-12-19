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

import com.min.fresh.dto.Product_DTO;
import com.min.fresh.model.IProductService;

@Controller
public class Product_Controller {
	
	private Logger log = LoggerFactory.getLogger(Product_Controller.class);
	
	@Autowired
	private IProductService service;
	
	/**
	 * 상품관리 페이지 이동
	 * @return 상품관리 페이지
	 */
	@RequestMapping(value = "/product.do", method = RequestMethod.GET)
	public String product() {
		log.info("★★★★★ 상품관리 페이지 이동 ★★★★★");
		return "ProductManagement";
	}
	
	/**
	 * 상품 전체 정보 조회
	 * @return 상품 전체 정보 json형태
	 */
	@RequestMapping(value = "/productJSON.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String productJqgrid () {
		log.info("★★★★★ 상품 JSON ★★★★★");
		service.updateProductSoldout(); // 자동 품절 처리
		service.updateProductSale(); // 자동 판매중 처리 (단종아니고, 재고상태Good일때)
		JSONObject json = null;
		List<Product_DTO> lists = service.allProductList();
		json = obejctJSON(lists); // 상품조회결과를 json에 담는다.
		return json.toString();
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject obejctJSON (List<Product_DTO> lists) {
		JSONObject json = new JSONObject(); // {}
		JSONArray jlists = new JSONArray(); // []
		JSONObject jdto = null; // [{},{},{}]
		
		for (Product_DTO dto : lists) {
			jdto = new JSONObject();
			jdto.put("sangcode", dto.getSangcode()); // 상품코드
			jdto.put("sangname", dto.getSangname()); // 상품이름
			jdto.put("price", dto.getPrice()); //상품가격
			jdto.put("sangstat", dto.getSangstat()); //상품상태
			jlists.add(jdto); // []안에 {},{} 넣기 => [{},{},{}]
		}
		json.put("productAllList", jlists);
		return json;
	}
	
	/**
	 * 상품 판매가, 상태 수정
	 * @param jDto 재고정보
	 * @param pDto 상품정보
	 * @return 상품정보 그리드
	 */
	@RequestMapping(value = "/productEdit.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String productEdit(Product_DTO pDto) {
		log.info("★★★★★상품 Edit 후 DTO확인★★★★★");
		int pEdit = service.updateProductPriceSangstat(pDto); // 상품 - 판매가, 상태 수정
		return (pEdit > 0)?"redirect:/productJSON.do":"Error";
	}
	
	/**
	 * 상품 추가
	 * @param jDto 재고정보
	 * @param pDto 상품정보
	 * @return 상품정보 그리드
	 */
	@RequestMapping(value = "/productAdd.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String productAdd(Product_DTO pDto) {
		log.info("★★★★★상품 Edit 후 DTO확인★★★★★");
		int cntP = service.insertProduct(pDto);
		return (cntP > 0)?"redirect:/productJSON.do":"Error";
	}
	
}
