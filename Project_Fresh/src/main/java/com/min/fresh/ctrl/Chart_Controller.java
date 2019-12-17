package com.min.fresh.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.min.fresh.dto.Chart_DTO;

import com.min.fresh.dto.Product_DTO;
import com.min.fresh.dto.RowNum_DTO;
import com.min.fresh.model.IChartService;
import com.min.fresh.model.IPagingService;

@Controller
public class Chart_Controller {

	private Logger log = LoggerFactory.getLogger(Chart_Controller.class);
	
	@Autowired
	private IChartService service;
	
	@RequestMapping(value = "/gochart.do", method = RequestMethod.GET)
	public String paging(Model model) {
		List<Product_DTO> list = service.selSangName();
		List<Integer> numList = new ArrayList<Integer>();
		int year = 2019;
		for(int i = 0; i<21; i++) {
			numList.add(i, year+i);
		}
		model.addAttribute("year", numList);
		model.addAttribute("lists", list);
		return "chart";
	}
		
	@RequestMapping(value = "/chart.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String paging(@RequestParam String options, @RequestParam String selPOrA, @RequestParam String sangNameList, @RequestParam String date) {
//		log.info("페이징 1차 실험");
//		RowNum_DTO dto = new RowNum_DTO();
//		dto.setTotal(service.countAllProduct());
//		int count = dto.getCount();
//		System.out.println(count);
//		System.out.println(dto);
//		List<Product_DTO> lists = service.allProductList(dto);
//		model.addAttribute("lists", lists);
//		model.addAttribute("count", count);
		log.info("차트조회 실험");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("sangname", sangNameList);
		map.put("year", date);
		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("year", "2019");
//		map.put("sangname", "흑수박");
			
//		String sangname = "흑수박";
//		String year = "2019";
		
		List<Chart_DTO> list = null;
		
//		List<Map<String, String>> list = service.chartJumcntSangnameList(map);
//		List<Map<String, String>> list = service.chartAllJumcntSangnameYearList();
			
		if(options.equalsIgnoreCase("saleCnt")) {
			if(selPOrA.equalsIgnoreCase("all")) {
//				list = service.chartAllJumcntSangnameYearList();
				if(date.equalsIgnoreCase("year")) {
					list = service.chartAllJumcntSangnameYearList();
				}else {
					list = service.chartAllJumcntSangnameList(date);
				}
			}else {
//				list = service.chartAllJumcntSangnameList(year);
				if(date.equalsIgnoreCase("year")) {
					list = service.chartJumcntSangnameYearList(sangNameList);
				}else {
					list = service.chartJumcntSangnameList(map);
				}
			}
		}else if(options.equalsIgnoreCase("saleMoney")) {
			if(selPOrA.equalsIgnoreCase("all")) {
				if(date.equalsIgnoreCase("year")) {
					list = service.chartAllPaymoneyYearList();
				}else {
					list = service.chartAllPaymoneyList(date);
				}
			}else {
				if(date.equalsIgnoreCase("year")) {
					list = service.chartPaymoneySangnameYearList(sangNameList);
				}else {
					list = service.chartPaymoneySangnameList(map);
				}
			}
		}else if(options.equalsIgnoreCase("pyegiCnt")) {
			if(selPOrA.equalsIgnoreCase("all")) {
				if(date.equalsIgnoreCase("year")) {
					list = service.chartAllPyegicntYearList();
				}else {
					list = service.chartAllPyegicntList(date);
				}
			}else {
				if(date.equalsIgnoreCase("year")) {
					list = service.chartPyegicntSangnameYearList(sangNameList);
				}else {
					list = service.chartPyegicntSangnameList(map);
				}
			}
		}else {
			if(selPOrA.equalsIgnoreCase("all")) {
				if(date.equalsIgnoreCase("year")) {
					list = service.chartAllPyegiPriceYearList();
				}else {
					list = service.chartAllPyegiPriceList(date);
				}
			}else {
				if(date.equalsIgnoreCase("year")) {
					list = service.chartPyegiPriceYearList(sangNameList);
				}else {
					list = service.chartPyegiPriceList(map);
				}
			}
		}
		
		System.out.println(list);
		
		
		Gson gson = new Gson();
		JsonArray jlist = new JsonArray();
		for ( Chart_DTO dto : list) {
			String json = gson.toJson(dto);
			jlist.add(json);
		}
//		for ( Map<String, String> jmap : list) {
//			jlist.add(gson.toJsonTree(jmap));
//		}
		System.out.println(jlist.toString());
		String google = jlist.toString();
		google = google.replace("\"", "'");
		google = google.replace("\\", "");
		google = google.replace("{", "");
		google = google.replace("}", "");
		google= google.replace("''month':", "");
		google= google.replace("''year':", "");
		google= google.replace("'cnt':", "");
		google= google.replace("'money':", "");
		google= google.replace("'',", "'|");
//		google= google.replace("',", "|");
//		google= google.replace("\"", "'");
//		google= google.replace("{", "[");
//		google= google.replace("}", "]");
//		google= google.substring(1, google.lastIndexOf("]"));
//		google= "['Month','Value'],"+google;
//		google= "['YEAR','Value'],"+google;
		google= google.replace("],", "|");
		google= google.replace("[", "");
		google= google.replace("']", "");
		google= google.replace(",'", ",");
		google= google.replace("'|'", "|");
		if (date.equalsIgnoreCase("year")) {
			google= "'Year','Value'|"+google;
		}else {
			google= "'Month','Value'|"+google;
		}
		google= google.substring(0, google.lastIndexOf("'"));
//		google= google.replace("],", "]|");
//		google= google.replace("[", "");
//		google= google.replace("]", "");
//		google= google.replace("\\", "");
//		google= google.trim();
		System.out.println(google+"----------------------------------");
		
//		,google.lastIndexOf("]")
//		json.add("chart", jlist);
//		System.out.println(json.toString());
//		List<Map<String, String>> list = service.chartJumcntSangnameYearList(sangname);
//		List<Map<String, String>> list = service.chartAllJumcntSangnameList(year);
//		List<Map<String, String>> list = service.chartAllJumcntSangnameYearList();
//		List<Map<String, String>> list = service.chartPaymoneySangnameList(map);
//		List<Map<String, String>> list = service.chartPaymoneySangnameYearList(sangname);
//		List<Map<String, String>> list = service.chartAllPaymoneyList(year);
//		List<Map<String, String>> list = service.chartAllPaymoneyYearList();
//		List<Map<String, String>> list = service.chartPyegicntSangnameList(map);
//		List<Map<String, String>> list = service.chartPyegicntSangnameYearList(sangname);
//		List<Map<String, String>> list = service.chartPyegiPriceList(map);
//		List<Map<String, String>> list = service.chartPyegiPriceYearList(sangname);
//		List<Map<String, String>> list = service.chartAllPyegicntList(year);
//		List<Map<String, String>> list = service.chartAllPyegicntYearList();
//		List<Map<String, String>> list = service.chartAllPyegiPriceList(year);
//		List<Map<String, String>> list = service.chartAllPyegiPriceYearList();
		
//		model.addAttribute("lists", list);
		
		return google;
		
		
	}

}
