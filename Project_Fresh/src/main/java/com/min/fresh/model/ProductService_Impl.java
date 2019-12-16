package com.min.fresh.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.fresh.dto.Jaego_DTO;
import com.min.fresh.dto.Member_DTO;
import com.min.fresh.dto.Product_DTO;
import com.min.fresh.dto.RowNum_DTO;

@Service
public class ProductService_Impl implements IProductService {
	
	private Logger log = LoggerFactory.getLogger(ProductService_Impl.class);

	@Autowired
	private IProductDao dao;
	
	/**
	 * <h2>상품관리 - 상품 등록</h2>
	 * @param 상품코드, 상품이름, 판매가, 상품상태
	 * @return true 사용가능 &#47; false 사용불가
	 */
	@Override
	public int insertProduct(Product_DTO dto) {
		log.info("ProductService_Impl --- insertProduct {}", dto);
		return dao.insertProduct(dto);
	}
	
	/**
	 * <h2>상품관리 - 상품 판매가&상태 수정</h2>
	 * @param 상품코드, 판매가, 상품상태
	 * @return true 사용가능 &#47; false 사용불가
	 */
	@Override
	public int updateProductPriceSangstat(Product_DTO dto) {
		log.info("ProductService_Impl --- updateProductPriceSangstat {}", dto);
		return dao.updateProductPriceSangstat(dto);
	}

	/**
	 * <h2>상품관리 - 상품상태 자동 품절처리</h2>
	 * @return true 사용가능 &#47; false 사용불가
	 */
	@Override
	public int updateProductSoldout() {
		log.info("ProductService_Impl --- updateProductSoldout {}", new Date());
		return dao.updateProductSoldout();
	}

	/**
	 * <h2>상품관리 - 상품상태 자동 판매중 처리</h2>
	 * @return true 사용가능 &#47; false 사용불가
	 */
	@Override
	public int updateProductSale() {
		log.info("ProductService_Impl --- updateProductSale {}", new Date());
		return dao.updateProductSale();
	}

	/**
	 * <h2>상품관리 - 상품정보 전체조회</h2>
	 * @return 모든 상품의 정보
	 */
	@Override
	public List<Product_DTO> allProductList() {
		log.info("ProductService_Impl --- allProductList {}", new Date());
		return dao.allProductList();
	}

	/**
	 * <h2>상품관리 - 상품 단종처리(DELFLAG) : 단일 다중</h2>
	 * @param 상품이름
	 * @return true 사용가능 &#47; false 사용불가
	 */
//	@Override
//	public int updateProductDiscontinued(Product_DTO dto) {
//		log.info("ProductService_Impl --- updateProductDiscontinued {}", dto);
//		return dao.updateProductDiscontinued(dto);
//	}
//	@Override
//	public boolean updateProductDiscontinued(Map<String, Object> map) {
//		log.info("ProductService_Impl --- updateProductDiscontinued {}", map);
//		int cnt = dao.updateProductDiscontinued(map);
//		return (cnt>0)?true:false;
//	}
	
	/**
	 * <h2>상품관리 - 상품+재고 정보 전체 조회</h2>
	 * @return 모든 상품의 정보와 각 상품의 재고량
	 */
//	@Override
//	public List<Jaego_DTO> allProductJaegoList() {
//		log.info("ProductService_Impl --- allProductJaegoList {}", new Date());
//		return dao.allProductJaegoList();
//	}

	/**
	 * <h2>상품관리 - 상품명으로 상품정보 검색</h2>
	 * @param 상품이름
	 * @return 상품정보
	 */
//	@Override
//	public List<Member_DTO> productSearchOne(String sangname) {
//		log.info("ProductService_Impl --- productSearchOne {}", sangname);
//		return dao.productSearchOne(sangname);
//	}

	/**
	 * <h2>상품관리 - 상품명으로 상품정보+재고 검색</h2>
	 * @param 상품이름
	 * @return 상품정보와 해당상품의 재고량
	 */
//	@Override
//	public List<Jaego_DTO> productJaegoSearchOne(String sangname) {
//		log.info("ProductService_Impl --- productSearchOne {}", sangname);
//		return dao.productJaegoSearchOne(sangname);
//	}

	/**
	 * <h2>상품관리 - 상품 개수</h2>
	 * @return 
	 */
//	@Override
//	public int countAllProduct() {
//		log.info("ProductService_Impl --- countAllProduct {}", new Date());
//		return dao.countAllProduct();
//	}

	/**
	 * <h2>상품관리 - 상품 페이징</h2>
	 * @param 상품코드, 상품이름, 판매가, 상품상태 5개씩
	 * @return 모든 상품의 정보
	 */
//	@Override
//	public List<Product_DTO> allProductList(RowNum_DTO dto) {
//		log.info("ProductService_Impl --- allProductList {}", new Date());
//		return dao.allProductList(dto);
//	}

}
