package com.min.fresh.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.min.fresh.model.IMemberService;
import com.min.fresh.model.IProductService;

@Controller
public class MemberSignup_Controller {
	
private Logger log = LoggerFactory.getLogger(MemberSignup_Controller.class);
	
	@Autowired
	private IMemberService service;
	
	@Autowired
	private JavaMailSender mail;
	
	/**
	 * 회원가입 - 1단계 이동
	 * @return 약관정보 동의여부 페이지 이동
	 */
	@RequestMapping(value = "/termsOfUse.do", method = RequestMethod.GET)
	public String termsOfUse() {
		log.info("★★★★★ 회원가입 - 약관 페이지 이동 ★★★★★");
		return "TermsOfUse";
	}
	
	/**
	 * 회원가입 - 2단계 이동
	 * @return 회원 정보입력 페이지 이동
	 */
	@RequestMapping(value = "/memberSignup.do", method = RequestMethod.GET)
	public String memberSignup() {
		log.info("★★★★★ 회원가입 - 정보입력 페이지 이동 ★★★★★");
		return "MemberSignup";
	}
	
	/**
	 * 아이디 중복검사
	 * @param id
	 * @return 중복여부 true 사용가능, false 사용불가
	 */
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> idCheck(String id) {
		log.info("★★★★★ 회원가입 - 아이디 중복 체크 ★★★★★ {}", id);
		Map<String, String> map = new HashMap<String, String>();
		boolean isc = service.idCheck(id);
		System.out.println("%%%%%%%^^^^^^" + isc);
		map.put("isc", isc+"");
		return map;
	}
	
	/**
	 * 이메일주소 중복검사
	 * @param email
	 * @return 중복여부 true 사용가능, false 사용불가
	 */
	@RequestMapping(value = "/emailCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> emailCheck(String email) {
		log.info("★★★★★ 회원가입 - 이메일 중복 체크 ★★★★★ {}", email);
		Map<String, String> map = new HashMap<String, String>();
		boolean isc = service.emailCheck(email);
		System.out.println("%%%%%%%^^^^^^" + isc);
		map.put("isc", isc+"");
		return map;
	}
	
	/**
    * 주문을 하면 주문내역을 이메일로 쏴줌
    * @param content
    * @return
    */
   @RequestMapping(value = "/mail.do",method = RequestMethod.POST,
		   produces = "application/text; charset=UTF-8")
   @ResponseBody
   public String sendMail(String content) {
      
      MimeMessage mimeMessage = mail.createMimeMessage();
      
      try {
         MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
         helper.setFrom("ghkdgo868@naver.com");
         helper.setTo("ghkdgo868@naver.com");
         helper.setSubject("지방이"+"님의 주문내역");
         helper.setText("회원님의 주문내역을 알려드립니다"+content, true);
         mail.send(mimeMessage);
      } catch (MessagingException e) {
         e.printStackTrace();
      }
      
      return "메일 발송";
   }
   
   /**
    * 비밀번호 초기화 창으로이동
    * @param id
    * @return
    */
   @RequestMapping(value = "/sendResetMail.do",method = RequestMethod.POST)
   @ResponseBody
   public String sendResetPW(String id) {
      
      MimeMessage mimeMessage = mail.createMimeMessage();
      
      try {
         MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
         helper.setFrom("ghkdgo868@naver.com");
         helper.setTo("ghkdgo868@naver.com");
         helper.setSubject(id+"님의 주문내역");
         helper.setText("<a href='http://localhost:8099/Project_Fresh/reset.do?id="+id+"'>링크를 눌러 비밀번호를 재설정해 주세요</a>", true);
         mail.send(mimeMessage);
      } catch (MessagingException e) {
         e.printStackTrace();
      }
      
      return "메일발송";
   }
   
   /**
    * 비밀번호 재설정 
    * @param id
    * @return
    */
   @RequestMapping(value = "/reset.do",method = RequestMethod.GET)
   public ModelAndView resetPassword(String id) {
      log.info("비밀번호 초기화 시작");
      ModelAndView mav = new ModelAndView();
      System.out.println(id);
      mav.addObject("id", id);
      mav.setViewName("resetpassword");
      return mav;
   }
   
   /**
    * 비밀번호 초기화
    * @param id
    * @param password
    * @return
    */
   @RequestMapping(value = "/reset.do",method = RequestMethod.POST,
		   produces = "application/text; charset=UTF-8")
   @ResponseBody
   public String resetPW(String id,String password) {
      log.info("비밀번호 초기화 완료");
      System.out.println("비번"+id+password);
      Map<String, String> map = new HashMap<String, String>();
      map.put("id", id);
      map.put("password", password);
      log.info("비번 초기화 하겠다");
      boolean isc = service.resetPassword(map);
      System.out.println(isc);
      
      return "초기화";
   }
}
