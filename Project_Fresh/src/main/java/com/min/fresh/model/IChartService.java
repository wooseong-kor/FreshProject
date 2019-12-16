package com.min.fresh.model;

import java.util.List;
import java.util.Map;

public interface IChartService {

	// 품목별  년월별 판매량
		public List<Map<String, String>> chartJumcntSangnameList(Map<String, String> map);
		// 품목별 년도만 판매량
		public List<Map<String, String>> chartJumcntSangnameYearList(String sangname);
		// 전체 년, 월별 판매량 
		public List<Map<String, String>> chartAllJumcntSangnameList(String year);
		// 전체 년도별 판매량
		public List<Map<String, String>> chartAllJumcntSangnameYearList();
		// 제품별 총 판매액 월별
		public List<Map<String, String>> chartPaymoneySangnameList(Map<String, String> map);
		// 제품별 총 판매액 년도별
		public List<Map<String, String>> chartPaymoneySangnameYearList(String sangname);
		// 총 판매액 년,월별
		public List<Map<String, String>> chartAllPaymoneyList(String year);
		// 총 판매액 년도별
		public List<Map<String, String>> chartAllPaymoneyYearList();
		// 제품별 총 폐기량 년월별 
		public List<Map<String, String>> chartPyegicntSangnameList(Map<String, String> map);
		// 제품별 총 폐기량 년도별
		public List<Map<String, String>> chartPyegicntSangnameYearList(String sangname);
		// 제품별 총 폐기금액 년월별 
		public List<Map<String, String>> chartPyegiPriceList(Map<String, String> map);
		// 제품별 총 폐기금액 년도별
		public List<Map<String, String>> chartPyegiPriceYearList(String sangname);
		// 총 폐기량 년월별
		public List<Map<String, String>> chartAllPyegicntList(String year);
		// 총 폐기량 년도별
		public List<Map<String, String>> chartAllPyegicntYearList();
		// 총 폐기금액 년월별
		public List<Map<String, String>> chartAllPyegiPriceList(String year);
		// 총 폐기금액 년도별
		public List<Map<String, String>> chartAllPyegiPriceYearList();
}
