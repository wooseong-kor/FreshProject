package com.min.fresh.ctrl;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.fresh.dto.Member_DTO;


@Controller
public class MailController {

	/**
	 * 회원가입시 인증 이메일을 보낸다
	 */
	@Autowired
	private JavaMailSender sender;
	
	@RequestMapping(value = "/mail.do",method = RequestMethod.GET)
	public String mail(HttpSession session) {
		Member_DTO dto = (Member_DTO) session.getAttribute("dto");
		System.out.println(dto);
		String setForm = "ghkdgo868@naver.com";
		
		MimeMessage mimeMessage = sender.createMimeMessage();
		
		try {
			final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setFrom(setForm);
			helper.setTo(dto.getEmail());
			helper.setSubject("회원가입 인증");
			helper.setText("<h2>링크를 눌러 이메일 인증을 완료해 주세요<a href='http://localhost:8099/NaverLogin/auth.do?eauth="+dto.getAgree()+"'>인증</a><h2>",true);
			sender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "redirect:/login.do";
	}
	
}
