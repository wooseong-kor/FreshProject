package com.min.fresh.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChartService_Impl implements IChartService{

	@Autowired
	private IChartDao dao;
	
	@Override
	public List<Map<String, String>> chartJumcntSangnameList(Map<String, String> map) {
		return dao.chartJumcntSangnameList(map);
	}

	@Override
	public List<Map<String, String>> chartJumcntSangnameYearList(String sangname) {
		return dao.chartJumcntSangnameYearList(sangname);
	}

	@Override
	public List<Map<String, String>> chartAllJumcntSangnameList(String year) {
		return dao.chartAllJumcntSangnameList(year);
	}

	@Override
	public List<Map<String, String>> chartAllJumcntSangnameYearList() {
		return dao.chartAllJumcntSangnameYearList();
	}

	@Override
	public List<Map<String, String>> chartPaymoneySangnameList(Map<String, String> map) {
		return dao.chartPaymoneySangnameList(map);
	}

	@Override
	public List<Map<String, String>> chartPaymoneySangnameYearList(String sangname) {
		return dao.chartPaymoneySangnameYearList(sangname);
	}

	@Override
	public List<Map<String, String>> chartAllPaymoneyList(String year) {
		return dao.chartAllPaymoneyList(year);
	}

	@Override
	public List<Map<String, String>> chartAllPaymoneyYearList() {
		return dao.chartAllPaymoneyYearList();
	}

	@Override
	public List<Map<String, String>> chartPyegicntSangnameList(Map<String, String> map) {
		return dao.chartPyegicntSangnameList(map);
	}

	@Override
	public List<Map<String, String>> chartPyegicntSangnameYearList(String sangname) {
		return dao.chartPyegicntSangnameYearList(sangname);
	}

	@Override
	public List<Map<String, String>> chartPyegiPriceList(Map<String, String> map) {
		return dao.chartPyegiPriceList(map);
	}

	@Override
	public List<Map<String, String>> chartPyegiPriceYearList(String sangname) {
		return dao.chartPyegicntSangnameYearList(sangname);
	}

	@Override
	public List<Map<String, String>> chartAllPyegicntList(String year) {
		return dao.chartAllPyegicntList(year);
	}

	@Override
	public List<Map<String, String>> chartAllPyegicntYearList() {
		return dao.chartAllPyegicntYearList();
	}

	@Override
	public List<Map<String, String>> chartAllPyegiPriceList(String year) {
		return dao.chartAllPyegiPriceList(year);
	}

	@Override
	public List<Map<String, String>> chartAllPyegiPriceYearList() {
		return dao.chartAllPyegiPriceYearList();
	}

}
