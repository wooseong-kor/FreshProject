package com.min.fresh.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.fresh.dto.Jaego_DTO;
import com.min.fresh.dto.Product_DTO;
import com.min.fresh.dto.RowNum_DTO;
import com.min.fresh.model.IJaegoService;
import com.min.fresh.model.IPagingService;

@Controller
public class Paging_Controller {

//	private Logger log = LoggerFactory.getLogger(Paging_Controller.class);
//	
//	@Autowired
//	private IPagingService service;
//	
//	@Autowired
//	private IJaegoService jservice;
//	
//	@RequestMapping(value = "/paging.do", method = RequestMethod.GET)
//	public String paging(Model model) {
//		log.info("페이징 1차 실험");
//		RowNum_DTO dto = new RowNum_DTO();
//		dto.setTotal(jservice.countAllGoodJaego());
//		int count = dto.getCount();
//		System.out.println(count);
//		System.out.println(dto);
//		List<Jaego_DTO> lists = jservice.allGoodJaegoList(dto);
//		model.addAttribute("lists", lists);
//		model.addAttribute("count", count);
//		return "page";
//	}
	
}
