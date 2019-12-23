package com.min.fresh.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.fresh.dto.Member_DTO;
import com.min.fresh.model.IMemberService;

@Controller
public class MemberManagement_Controller {

	private Logger log = LoggerFactory.getLogger(MemberManagement_Controller.class);

	@Autowired
	private IMemberService service;

	@RequestMapping(value = "/allMemberList.do", method = RequestMethod.GET)
	public String allMemberList(Model model) {
		log.info("☆☆☆☆☆ 전체 회원 조회 이동 ☆☆☆☆☆");
		List<Member_DTO> lists = service.allMemberListScroll();
		model.addAttribute("AllMemberLists", lists);
		return "AllMemberList";
	}
	
	@RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
	public String memberListScroll(Model model) {
		log.info("☆☆☆☆☆ 전체 회원 조회 이동 ☆☆☆☆☆");
		List<Member_DTO> lists = service.memberListScroll();
		model.addAttribute("MemberLists", lists);
		return "MemberList";
	}

}
