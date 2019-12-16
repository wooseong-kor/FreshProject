package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.fresh.dto.Chart_DTO;
import com.min.fresh.dto.Product_DTO;

@Service
public class ChartService_Impl implements IChartService{

	@Autowired
	private IChartDao dao;
	
	@Override
	public List<Chart_DTO> chartJumcntSangnameList(Map<String, String> map) {
		return dao.chartJumcntSangnameList(map);
	}

	@Override
	public List<Chart_DTO> chartJumcntSangnameYearList(String sangname) {
		return dao.chartJumcntSangnameYearList(sangname);
	}

	@Override
	public List<Chart_DTO> chartAllJumcntSangnameList(String year) {
		return dao.chartAllJumcntSangnameList(year);
	}

	@Override
	public List<Chart_DTO> chartAllJumcntSangnameYearList() {
		return dao.chartAllJumcntSangnameYearList();
	}

	@Override
	public List<Chart_DTO> chartPaymoneySangnameList(Map<String, String> map) {
		return dao.chartPaymoneySangnameList(map);
	}

	@Override
	public List<Chart_DTO> chartPaymoneySangnameYearList(String sangname) {
		return dao.chartPaymoneySangnameYearList(sangname);
	}

	@Override
	public List<Chart_DTO> chartAllPaymoneyList(String year) {
		return dao.chartAllPaymoneyList(year);
	}

	@Override
	public List<Chart_DTO> chartAllPaymoneyYearList() {
		return dao.chartAllPaymoneyYearList();
	}

	@Override
	public List<Chart_DTO> chartPyegicntSangnameList(Map<String, String> map) {
		return dao.chartPyegicntSangnameList(map);
	}

	@Override
	public List<Chart_DTO> chartPyegicntSangnameYearList(String sangname) {
		return dao.chartPyegicntSangnameYearList(sangname);
	}

	@Override
	public List<Chart_DTO> chartPyegiPriceList(Map<String, String> map) {
		return dao.chartPyegiPriceList(map);
	}

	@Override
	public List<Chart_DTO> chartPyegiPriceYearList(String sangname) {
		return dao.chartPyegicntSangnameYearList(sangname);
	}

	@Override
	public List<Chart_DTO> chartAllPyegicntList(String year) {
		return dao.chartAllPyegicntList(year);
	}

	@Override
	public List<Chart_DTO> chartAllPyegicntYearList() {
		return dao.chartAllPyegicntYearList();
	}

	@Override
	public List<Chart_DTO> chartAllPyegiPriceList(String year) {
		return dao.chartAllPyegiPriceList(year);
	}

	@Override
	public List<Chart_DTO> chartAllPyegiPriceYearList() {
		return dao.chartAllPyegiPriceYearList();
	}

	@Override
	public List<Product_DTO> selSangName() {
		return dao.selSangName();
	}

}
