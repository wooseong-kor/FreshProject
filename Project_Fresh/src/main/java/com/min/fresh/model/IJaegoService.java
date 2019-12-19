package com.min.fresh.model;

import java.util.List;

import com.min.fresh.dto.Ipgo_DTO;
import com.min.fresh.dto.Jaego_DTO;
import com.min.fresh.dto.Pyegi_DTO;
import com.min.fresh.dto.RowNum_DTO;

public interface IJaegoService {

	//Good 상태인 재고 개수
		public int countAllGoodJaego();
		
		//재고조회
		public List<Jaego_DTO> allGoodJaegoList();
		
		
		//재고수정
		public int updateJaegostat(Jaego_DTO dto);
		
		//입고 개수
		public int countAllIpgo();
		
		//입고 조회
		public List<Ipgo_DTO> allIpgoList();
		
		
		//폐기 개수
		public int countAllPyegi();
		
		//폐기 조회
		public List<Pyegi_DTO> allPyegiList();
		
			
		//재고 - 재고정보를 입력한다.
		public int insertJaego(Jaego_DTO dto);
		
		//입고 - 입고정보를 입력한다
		public int insertIpgo(Ipgo_DTO dto);
		
		//재고 - 출고 (수정)
		public int updateJaegoMinus(String paynum);
		
		//재고 - 폐기할 상품의 정보를 입력한다.
		public int insertPyegi(Pyegi_DTO dto);
		
		//재고 - 폐기처리된 수량만큼 재고량을 감소 시킨다.
		public int updateJaecountPyegiOne(String pyeginum);
		
		//재고 - 재고량에 반영된 폐기품의 상태를 변경한다.
		public int updatePyegiflagOne(String pyeginum);
		
		//재고 - 재고상태 수정 (출고 불가)
		public int updateJaegostatOne();
		
		//Good 상태인 재고 페이징
//		public List<Jaego_DTO> allGoodJaegoList(RowNum_DTO dto);
		
		//입고 페이징
//		public List<Ipgo_DTO> allIpgoList(RowNum_DTO dto);
		
		//폐기 페이징
//		public List<Pyegi_DTO> allPyegiList(RowNum_DTO dto);
	
		
		
		
//		//코드별 조회
//		public List<Jaego_DTO> jaegoCodeList();
//		
//		//유통기한별 조회
//		public List<Jaego_DTO> jaegoExpdateList();
		
		
	}
