package com.min.fresh.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.fresh.dto.Jumun_DTO;
import com.min.fresh.dto.RowNum_DTO;
import com.min.fresh.model.IJumun_PaymentService;
import com.min.fresh.utils.TossAPI;

@Controller
public class Jumun_Controller<E> {

	private Logger log = LoggerFactory.getLogger(Jumun_Controller.class);
	
	@Autowired
	private IJumun_PaymentService service;
	
	@Autowired
	private TossAPI toss;
	
	@Autowired
	private JavaMailSender mail;
	
	@RequestMapping(value = "/jumun.do",method = {RequestMethod.POST,RequestMethod.GET})
	public String Jumun() {
		log.info("주문 페이지이지만 지금은 테스트용");
		
		
		return "Test";
	}
	
	@RequestMapping(value = "/cancle.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String cancle(String jumunnum) {
		
		boolean isc = service.deleteJumun(jumunnum);
		
		
		
		return "성공";
	}
	
	@RequestMapping(value = "/insertjumon.do",method = RequestMethod.POST)
	public String jomon(Jumun_DTO dto) {
		System.out.println(dto);
		boolean isc= service.insertJumun(dto);
		System.out.println(isc);
		return "Test";
	}
	
	@RequestMapping(value = "/selectJumun.do",method = RequestMethod.POST,
			produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String selectJumun(Model model,String id) {
		log.info("나 시작했어 아작스 너무싫어 {}",id);
		Map<String, Object> map = new HashMap<String, Object>();
		RowNum_DTO dto = new RowNum_DTO();
		dto.setTotal(service.countMemberJumun(id));
		int count = dto.getCount();
		System.out.println(count);
		System.out.println(dto);
		map.put("first", dto.getFirst());
		map.put("last", dto.getLast());
		map.put("id", id);
		List<Jumun_DTO> lists = service.memberJumunList(map);
		JSONArray jlist = new JSONArray();
		JSONObject json = new JSONObject();
		for (Jumun_DTO D : lists) {
			json.put("String", D);
			jlist.add(json);
		}
		JSONObject gson = new JSONObject();
		gson.put("hey",jlist);
		System.out.println(gson.toString()+"투스트링 제이슨");
		return gson.toString();
	}
	
	@RequestMapping(value = "/deleteJumun.do",method = RequestMethod.GET)
	public String deleteJumun(String jumunnum) {
		boolean isc = service.deleteJumun(jumunnum);
		System.out.println(isc);
		boolean iscs2 = service.updateJumstatConfirm(jumunnum);
		System.out.println("주문확정"+iscs2);
		boolean iscauto = service.updateJumstatAutoConfirm();
		System.out.println(iscauto+" : 주문 자동확정");
		return "Test";
	}
	
	@RequestMapping(value = "/updatePayment.do", method = RequestMethod.POST)
	@ResponseBody
	public String updatePayment(String jumunnum){
		boolean isc = service.updateJumunPayhistoryDeposit(jumunnum);
		System.out.println("이름 : "+jumunnum);
		if (isc) {
			System.out.println("주문정보 수정 성공");
			return "true";
		}else {  
			System.out.println("주문정보 수정 실패");
			return "false";
		}
	}
	
	@RequestMapping(value = "/toss.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> payment(Jumun_DTO dto){
		log.info("결제 실행");
		Map<String , Object> map = new HashMap<String, Object>();
		System.out.println(dto+" : dto");
		map.put("orderNo", dto.getJumunnum());
		map.put("amount", dto.getJummoney());
		map.put("productDesc", dto.getSangpgnum());
		
		return map;
	}
	
	@RequestMapping(value = "/toss.do",method = RequestMethod.GET)
	public String doToss(Model model,String orderNo,String amount,String productDesc) {
		System.out.println(orderNo+":"+amount+":"+productDesc);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderNo", orderNo);
		map.put("amount", Integer.parseInt(amount));
		map.put("productDesc", productDesc);
		JSONObject json = toss.doToss(map);
		
		model.addAttribute("toss", json);
		
		return "toss";
	}
	
	@RequestMapping(value = "/mail.do",method = RequestMethod.POST)
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
	
}
