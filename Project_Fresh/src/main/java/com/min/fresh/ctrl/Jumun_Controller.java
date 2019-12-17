package com.min.fresh.ctrl;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.min.fresh.dto.Jumun_DTO;
import com.min.fresh.dto.Payhistory_DTO;
import com.min.fresh.dto.RowNum_DTO;
import com.min.fresh.model.ICouponMileageService;
import com.min.fresh.model.IJumun_PaymentService;
import com.min.fresh.model.IMemberService;
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
	
	@Autowired
	private IMemberService Ivice;
	
	@Autowired
	private ICouponMileageService coupon;
	
	@RequestMapping(value = "/jumun.do",method = {RequestMethod.POST,RequestMethod.GET})
	public String Jumun() {
		log.info("주문 페이지이지만 지금은 테스트용");
		
		
		return "Test";
	}
	
	@RequestMapping(value = "/cancle.do", method = RequestMethod.POST,
			produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String cancle(String jumunnum) {
		
		boolean isc = service.deleteJumun(jumunnum);
		
		
		
		return "성공";
	}
	
	/**
	 * 주문 및 결제 테이블에 입력 후 결제 창 호출
	 * @param attr
	 * @param dto
	 * @param pDto
	 * @return
	 */
	@RequestMapping(value = "/insertjumon.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertJumun(/*RedirectAttributes attr,*/Jumun_DTO dto,Payhistory_DTO pDto) {
		System.out.println(dto);
		boolean isc= service.insertJumun(dto);
		System.out.println(isc);
		System.out.println(pDto+"결제 DTO");
		Map<String, Object> map =new HashMap<String, Object>();
		if (isc) {
			String jumunnum = service.selectJumunnum(dto.getId());
			System.out.println(jumunnum+" : 주문넘");
			pDto.setJumunnum(jumunnum);
			pDto.setMileage(dto.getJummoney()-pDto.getPaymoney());
			System.out.println(pDto+"결제 DTO : 이후");
			boolean pisc = service.insertPayhistory(pDto);
			System.out.println(pisc);
			map.put("orderNo", jumunnum);
			map.put("amount", pDto.getPaymoney());
			map.put("productDesc", dto.getSangpgnum());
			// 주문 완료 페이지로 간다
//			attr.addFlashAttribute("map", map);
		}
		
		return map;
//		return "redirect:/toss.do";
	}
	
	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
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
	public String doToss(HttpServletRequest request,Model model,String orderNo,String amount,String productDesc) {
//		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
//		Map<String, Object> map = (Map<String, Object>) flashMap.get("map");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderNo", orderNo);
		map.put("amount", Integer.valueOf(amount));
		map.put("productDesc", productDesc);
		System.out.println(map.toString());
		JSONObject json = toss.doToss(map);
		
		model.addAttribute("toss", json);
		
		return "toss";
	}
	
	/**
	 * 주문을 하면 주문내역을 이메일로 쏴줌
	 * @param content
	 * @return
	 */
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
	@RequestMapping(value = "/reset.do",method = RequestMethod.POST)
	public String resetPW(String id,String password) {
		log.info("비밀번호 초기화 완료");
		System.out.println("비번"+id+password);
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		log.info("비번 초기화 하겠다");
		boolean isc = Ivice.resetPassword(map);
		System.out.println(isc);
		
		return null;
	}
	
	
	
}
