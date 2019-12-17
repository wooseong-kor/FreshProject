package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.fresh.dto.Chart_DTO;
import com.min.fresh.dto.Product_DTO;

/**
 * 
 * @author Fresh
 * 차트쿼리 DAO
 */

@Repository
public class ChartDao_Impl implements IChartDao {
	
	// log를 남기기위해 로그를남길 객체를 등록
	private Logger logger = LoggerFactory.getLogger(ChartDao_Impl.class);
	// dtoper에 설정해준 namespace를 변수로 만듬
	private final String NS = "com.min.fresh.ChartMapper.";
	
	// 쿼리를 실행해주기위한 SqlSessionFactory객체를 spring탬플릿으로 담은 객체
	@Autowired
	private SqlSessionTemplate session;

	/**
	 * @param dto (String year, String sangname)
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 품목별 특정년도  월별 판매량
	 */
	@Override
	public List<Chart_DTO> chartJumcntSangnameList(Map<String, String> map) {
		logger.info("chartJumcntSangnameList실행");
		return session.selectList(NS+"chartJumcntSangnameList", map);
	}

	/**
	 * @param String sangnam
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 품목별 년도만 판매량
	 */
	@Override
	public List<Chart_DTO> chartJumcntSangnameYearList(String sangname) {
		logger.info("chartJumcntSangnameYearList");
		return session.selectList(NS+"chartJumcntSangnameYearList", sangname);
	}

	/**
	 * @param String year
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 총제품 년도의 월별 판매량
	 */
	@Override
	public List<Chart_DTO> chartAllJumcntSangnameList(String year) {
		logger.info("chartAllJumcntSangnameList");
		return session.selectList(NS+"chartAllJumcntSangnameList", year);
	}

	/**
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 총제품 년도 판매량 총합
	 */
	@Override
	public List<Chart_DTO> chartAllJumcntSangnameYearList() {
		logger.info("chartAllJumcntSangnameYearList");
		return session.selectList(NS+"chartAllJumcntSangnameYearList");
	}

	/**
	 * @param dto (String year, String sangname)
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 한제품의 특정년도 월별 판매액
	 */
	@Override
	public List<Chart_DTO> chartPaymoneySangnameList(Map<String, String> map) {
		logger.info("chartPaymoneySangnameList");
		return session.selectList(NS+"chartPaymoneySangnameList", map);
	}

	/**
	 * @param String year
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 한제품의 년도별 총 판매액
	 */
	@Override
	public List<Chart_DTO> chartPaymoneySangnameYearList(String sangname) {
		logger.info("chartPaymoneySangnameYearList");
		return session.selectList(NS+"chartPaymoneySangnameYearList", sangname);
	}

	/**
	 * @param String year
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 총제품 특정년도 월별 금액 통계
	 */
	@Override
	public List<Chart_DTO> chartAllPaymoneyList(String year) {
		logger.info("chartAllPaymoneyList");
		return session.selectList(NS+"chartAllPaymoneyList", year);
	}

	/**
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 총 판매액 년도별
	 */
	@Override
	public List<Chart_DTO> chartAllPaymoneyYearList() {
		logger.info("chartAllPaymoneyYearList");
		return session.selectList(NS+"chartAllPaymoneyYearList");
	}

	/**
	 * @param dto (String year, String sangname)
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 제품별 총 폐기량 특정년도 월별
	 */
	@Override
	public List<Chart_DTO> chartPyegicntSangnameList(Map<String, String> map) {
		logger.info("chartPyegicntSangnameList");
		return session.selectList(NS+"chartPyegicntSangnameList", map);
	}

	/**
	 * @param String sangname
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 제품별 총 폐기량 년도별
	 */
	@Override
	public List<Chart_DTO> chartPyegicntSangnameYearList(String sangname) {
		logger.info("chartPyegicntSangnameYearList");
		return session.selectList(NS+"chartPyegicntSangnameYearList", sangname);
	}

	/**
	 * @param dto (String year, String sangname)
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 제품별 총 폐기금액 특정년도 월별
	 */
	@Override
	public List<Chart_DTO> chartPyegiPriceList(Map<String, String> map) {
		logger.info("chartPyegiPriceList");
		return session.selectList(NS+"chartPyegiPriceList", map);
	}

	/**
	 * @param String sangname
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 제품별 총 폐기금액 년도별
	 */
	@Override
	public List<Chart_DTO> chartPyegiPriceYearList(String sangname) {
		logger.info("chartPyegiPriceYearList");
		return session.selectList(NS+"chartPyegiPriceYearList", sangname);
	}

	/**
	 * @param String year
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 제품 총 폐기량 특정년도의 월별
	 */
	@Override
	public List<Chart_DTO> chartAllPyegicntList(String year) {
		logger.info("chartAllPyegicntList");
		return session.selectList(NS+"chartAllPyegicntList", year);
	}

	/**
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 제품 총 폐기량 년도별 
	 */
	@Override
	public List<Chart_DTO> chartAllPyegicntYearList() {
		logger.info("chartAllPyegicntYearList");
		return session.selectList(NS+"chartAllPyegicntYearList");
	}

	/**
	 * @param String year
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 총 폐기 금액 특정년도 월별
	 */
	@Override
	public List<Chart_DTO> chartAllPyegiPriceList(String year) {
		logger.info("chartAllPyegiPriceList");
		return session.selectList(NS+"chartAllPyegiPriceList", year);
	}

	/**
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 총 폐기금액 년도별
	 */
	@Override
	public List<Chart_DTO> chartAllPyegiPriceYearList() {
		logger.info("chartAllPyegiPriceYearList");
		return session.selectList(NS+"chartAllPyegiPriceYearList");
	}

	/**
	 * @return List형태로 되어있는 컬럼값의 리스트
	 * 상품 모두 조회
	 */
	@Override
	public List<Product_DTO> selSangName() {
		logger.info("selSangName");
		return session.selectList(NS+"selSangName");
	}

}
