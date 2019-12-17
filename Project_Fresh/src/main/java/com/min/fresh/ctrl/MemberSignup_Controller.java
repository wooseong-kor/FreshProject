package com.min.fresh.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.min.fresh.model.IProductService;

@Controller
public class MemberSignup_Controller {
	
	private Logger log = LoggerFactory.getLogger(MemberSignup_Controller.class);
	
	@Autowired
	private IProductService service;
	
	@RequestMapping(value = "/termsOfUse.do", method = RequestMethod.GET)
	public String termsOfUse() {
		log.info("★★★★★ 회원가입 - 약관 페이지 이동 ★★★★★");
		return "TermsOfUse";
	}
	
	@RequestMapping(value = "/memberSignup.do", method = RequestMethod.GET)
	public String memberSignup() {
		log.info("★★★★★ 회원가입 - 정보입력 페이지 이동 ★★★★★");
		return "MemberSignup";
	}
	
	
}
