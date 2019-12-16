package com.min.fresh.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.fresh.dto.Product_DTO;

@Repository
public class ProductDao_Impl implements IProductDao {

	private final String NS = "com.min.fresh.IProductDao.";
	private Logger log = LoggerFactory.getLogger(ProductDao_Impl.class);
	
	@Autowired
	private SqlSessionTemplate session;
	
	/**
	 * <h2>상품관리 - 상품 등록</h2>
	 * @param 상품코드, 상품이름, 판매가, 상품상태
	 * @return true 사용가능 &#47; false 사용불가
	 */
	@Override
	public int insertProduct(Product_DTO dto) {
		log.info("insertProduct 실행");
		return session.insert(NS+"insertProduct", dto);
	}

	/**
	 * <h2>상품관리 - 상품 판매가&상태 수정</h2>
	 * @param 상품코드, 판매가
	 * @return true 사용가능 &#47; false 사용불가
	 */
	@Override
	public int updateProductPriceSangstat(Product_DTO dto) {
		log.info("updateProductPriceSangstat 실행");
		return session.update(NS+"updateProductPriceSangstat", dto);
	}

	/**
	 * <h2>상품관리 - 상품상태 자동 품절처리</h2>
	 * @return true 사용가능 &#47; false 사용불가
	 */
	@Override
	public int updateProductSoldout() {
		log.info("updateProductSoldout 실행");
		return session.update(NS+"updateProductSoldout");
	}

	/**
	 * <h2>상품관리 - 상품상태 자동 판매중 처리</h2>
	 * @return true 사용가능 &#47; false 사용불가
	 */
	@Override
	public int updateProductSale() {
		log.info("updateProductSale 실행");
		return session.update(NS+"updateProductSale");
	}
	
	/**
	 * <h2>상품관리 - 상품정보 전체조회</h2>
	 * @return 모든 상품의 정보
	 */
	@Override 
	public List<Product_DTO> allProductList() {
		log.info("allProductList 실행");
		return session.selectList(NS+"allProductList");
	}

	/**
	 * <h2>상품관리 - 상품 단종처리(DELFLAG) : 단일 다중</h2>
	 * @param 상품이름
	 * @return true 사용가능 &#47; false 사용불가
	 */
//	@Override
//	public int updateProductDiscontinued(Product_DTO dto) {
//		log.info("updateProductDiscontinued 실행");
//		return session.update(NS+"updateProductDiscontinued", dto);
//	}
//	@Override
//	public int updateProductDiscontinued(Map<String, Object> map) {
//		log.info("updateProductDiscontinued 실행");
//		return session.update(NS+"updateProductDiscontinued", map);
//	}

	/**
	 * <h2>상품관리 - 상품+재고 정보 전체 조회</h2>
	 * @return 모든 상품의 정보와 각 상품의 재고량
	 */
//	@Override
//	public List<Jaego_DTO> allProductJaegoList() {
//		log.info("allProductJaegoList 실행");
//		return session.selectList(NS+"allProductJaegoList");
//	}

	/**
	 * <h2>상품관리 - 상품명으로 상품정보 검색</h2>
	 * @param 상품이름
	 * @return 상품정보
	 */
//	@Override
//	public List<Member_DTO> productSearchOne(String sangname) {
//		log.info("productSearchOne 실행");
//		return session.selectOne(NS+"productSearchOne", sangname);
//	}

	/**
	 * <h2>상품관리 - 상품명으로 상품정보+재고 검색</h2>
	 * @param 상품이름
	 * @return 상품정보와 해당상품의 재고량
	 */
//	@Override
//	public List<Jaego_DTO> productJaegoSearchOne(String sangname) {
//		log.info("productJaegoSearchOne 실행");
//		return session.selectOne(NS+"productJaegoSearchOne", sangname);
//	}

	/**
	 * <h2>상품관리 - 상품 개수</h2>
	 * @return 
	 */
//	@Override
//	public int countAllProduct() {
//		log.info("countAllProduct 실행");
//		return session.selectOne(NS+"countAllProduct");
//	}

	/**
	 * <h2>상품관리 - 상품 페이징</h2>
	 * @param 상품코드, 상품이름, 판매가, 상품상태 5개씩
	 * @return 모든 상품의 정보
	 */
//	@Override
//	public List<Product_DTO> allProductList(RowNum_DTO dto) {
//		log.info("allProductList (dto) 실행");
//		return session.selectList(NS+"allProductList", dto);
//	}

}
