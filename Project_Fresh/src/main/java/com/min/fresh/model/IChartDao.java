package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import com.min.fresh.dto.Chart_DTO;
import com.min.fresh.dto.Product_DTO;

public interface IChartDao {

		// 품목별 특정년도  월별 판매량
		public List<Chart_DTO> chartJumcntSangnameList(Map<String, String> map);
		// 품목별 년도만 판매량
		public List<Chart_DTO> chartJumcntSangnameYearList(String sangname);
		// 전체 년, 월별 판매량 
		public List<Chart_DTO> chartAllJumcntSangnameList(String year);
		// 전체 년도별 판매량
		public List<Chart_DTO> chartAllJumcntSangnameYearList();
		// 제품별 총 판매액 월별
		public List<Chart_DTO> chartPaymoneySangnameList(Map<String, String> map);
		// 제품별 총 판매액 년도별
		public List<Chart_DTO> chartPaymoneySangnameYearList(String sangname);
		// 총 판매액 년,월별
		public List<Chart_DTO> chartAllPaymoneyList(String year);
		// 총 판매액 년도별
		public List<Chart_DTO> chartAllPaymoneyYearList();
		// 제품별 총 폐기량 년월별 
		public List<Chart_DTO> chartPyegicntSangnameList(Map<String, String> map);
		// 제품별 총 폐기량 년도별
		public List<Chart_DTO> chartPyegicntSangnameYearList(String sangname);
		// 제품별 총 폐기금액 년월별 
		public List<Chart_DTO> chartPyegiPriceList(Map<String, String> map);
		// 제품별 총 폐기금액 년도별
		public List<Chart_DTO> chartPyegiPriceYearList(String sangname);
		// 총 폐기량 년월별
		public List<Chart_DTO> chartAllPyegicntList(String year);
		// 총 폐기량 년도별
		public List<Chart_DTO> chartAllPyegicntYearList();
		// 총 폐기금액 년월별
		public List<Chart_DTO> chartAllPyegiPriceList(String year);
		// 총 폐기금액 년도별
		public List<Chart_DTO> chartAllPyegiPriceYearList();
		// 상품이름 모두 조회
		public List<Product_DTO> selSangName();
}
