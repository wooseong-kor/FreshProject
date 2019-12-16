package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import com.min.fresh.dto.Jaego_DTO;
import com.min.fresh.dto.Member_DTO;
import com.min.fresh.dto.Product_DTO;
import com.min.fresh.dto.RowNum_DTO;

public interface IProductDao {

	//상품관리 - 상품 등록
	public int insertProduct(Product_DTO dto);
	
	//상품관리 - 상품 판매가&상태 수정
	public int updateProductPriceSangstat(Product_DTO dto);
	
	//상품관리 - 상품정보 전체조회
	public List<Product_DTO> allProductList();
	
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
