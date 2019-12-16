package com.min.fresh.model;

import java.util.List;

import com.min.fresh.dto.Product_DTO;

public interface IProductService {

	//상품관리 - 상품 등록
	public int insertProduct(Product_DTO dto);
	
	//상품관리 - 상품 판매가&상태 수정
	public int updateProductPriceSangstat(Product_DTO dto);
	
	//상품관리 - 상품상태 자동 품절처리
	public int updateProductSoldout();
	
	//상품관리 - 상품상태 자동 판매중 처리
	public int updateProductSale();
	
	//상품관리 - 상품정보 전체조회
	public List<Product_DTO> allProductList();
	
	//상품관리 - 상품 단종처리(DELFLAG) : 단일 다중
//	public int updateProductDiscontinued(Product_DTO dto);
//	public boolean updateProductDiscontinued(Map<String, Object> map);
	
	//상품관리 - 상품+재고 정보 전체 조회
//	public List<Jaego_DTO> allProductJaegoList();
	
	//상품관리 - 상품명으로 상품정보 검색
//	public List<Member_DTO> productSearchOne(String sangname);
	
	//상품관리 - 상품명으로 상품정보+재고 검색
//	public List<Jaego_DTO> productJaegoSearchOne(String sangname);
	
	//상품 개수
//	public int countAllProduct();
	
	//상품 페이징
//	public List<Product_DTO> allProductList(RowNum_DTO dto);

}
