package com.min.fresh.ctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.min.fresh.dto.Member_DTO;
import com.min.fresh.model.IMemberService;
import com.min.fresh.model.IProductService;

@Controller
public class MemberSignup_Controller {
	
private Logger log = LoggerFactory.getLogger(MemberSignup_Controller.class);
	
	@Autowired
	private IMemberService service;
	
	@Autowired
	private JavaMailSender mail;
	
	@RequestMapping(value = "/Main.do", method = RequestMethod.GET)
	public String loginForm() {
		log.info("Welcome loginForm.do : \t{}", new Date());
		return "MainContainer";
	}
	
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
		System.out.println("★★★★★ 아이디 중복체크 결과 : " + isc);
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
		System.out.println("★★★★★ 이메일 중복체크 결과 : " + isc);
		map.put("isc", isc+"");
		return map;
	}
	
	/**
	 * 회원가입
	 * @param dto 회원정보
	 * @param password 비밀번호
	 * @param phone1 핸드폰 앞자리 3자리
	 * @param phone2 핸드폰 가운데 4자리
	 * @param phone3 핸드폰 뒷자리 4자리
	 * @return 회원가입
	 */
	@RequestMapping(value = "/memberAdd.do", method = RequestMethod.POST)
	public String memberAdd(Member_DTO dto, @RequestParam("pswd2") String password,
			@RequestParam("phone1") String phone1, @RequestParam("phone2") String phone2,
			@RequestParam("phone3") String phone3 ) {
		String phone = phone1 +"-"+ phone2 +"-"+ phone3;
		dto.setPassword(password);
		dto.setPhone(phone);
		log.info("★★★★★ 회원가입 - 회원추가 ★★★★★\n {}", dto);
		return service.insertMember(dto)?"WelcomeFresh":"Error";
	}
	
	/**
	 * 로그인 페이지 이동
	 * @return 로그인페이지 이동
	 */
	@RequestMapping(value = "/loginPage.do", method = RequestMethod.GET)
	public String loginPage () {
		log.info("★★★★★ 로그인 페이지 이동 ★★★★★");
		return "Login";
	}
	
	/**
	 * 로그인 가능여부 확인
	 * @param id 회원 아이디
	 * @param pw 회원 비밀번호
	 * @return true 성공 / false 실패
	 */
	@RequestMapping(value = "/loginCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> loginCheck (Member_DTO dto) {
		log.info("★★★★★ 로그인 - 가능여부확인 ★★★★★\n▶▷▶ {}", dto);
		service.updateMemberDelflagJ(); // 자동 정지처리 (경고횟수 2회 이상)
		service.updateMemberDelflagH(); // 자동 휴먼처리 (마지막로그인 기준 6개월)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", dto.getId()); // 로그인시 필요한 id
		map.put("password", dto.getPassword()); // 로그인시 필요한 password
		map.put("delflag", dto.getDelflag()); // 처음에 무조건N
		Member_DTO mDto = service.loginMember(map);
		System.out.println("▶▷▶▶▷▶확인 = " + mDto);
		if (mDto == null) {
			map.put("isc", "실패");
		} else {
			map.put("delflag", mDto.getDelflag()); // 로그인 후 받아온 회원상태로 업데이트
			map.put("name", mDto.getName()); // 휴면계정 회원 이름 띄우려고
			map.put("isc", "성공");
		}
		return map;
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String login(HttpSession session, Member_DTO dto) {
		log.info("★★★★★ 로그인 ★★★★★\n▶▷▶ {}", dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", dto.getId());
		map.put("password", dto.getPassword());
		map.put("delflag", dto.getDelflag());
		map.put("gcode", dto.getGcode()); // 회원등급 (관리자, 회원 구분을 위해)
		Member_DTO mDto = service.loginMember(map);
		session.setAttribute("mem", mDto);
		System.out.println("▶▷▶ 로그인 정보 확인 = " + map.toString());
		if (mDto.getDelflag().equals("N")) {
			if (mDto.getGcode().equals("A")) { // 관리자
				return "AdminMain"; // 관리자 메인
			} else {
				return "MyPage"; // 사용자 메인
			}
		} else { 
			return "DormantAccountPasswordSetting"; // 휴면계정 상태
		}
	}
	
	/**
	 * 휴면계정 비밀번호 재설정
	 * @param dto 회원정보
	 * @return 로그인페이지 이동
	 */
	@RequestMapping(value = "/pwCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> resetPwLogin (Member_DTO dto) {
		log.info("★★★★★ 휴면계정 비밀번호 재설정 확인 ★★★★★");
		System.out.println("▶▷▶재설정에서 받아온 정보" + dto.getDelflag() + ", " + dto.getId() + ", " + dto.getPassword());
		Map<String, String> map = new HashMap<String, String>();
		Member_DTO mDto = service.searchPassword(dto.getId());
		System.out.println("▶▷▶session에 담긴 id로 검색한 pw&delflag = " + mDto.getPassword() +", " + mDto.getDelflag());
		if (dto.getPassword().equals(mDto.getPassword())) {
			System.out.println("★★★이전 비밀번호와 동일함. 사용불가★★★");
			map.put("isc", "불가");
		} else {
			map.put("isc", "가능");
		}
		return map;
	}
	
	/**
	 * 휴면계정 비밀번호 재설정 후 로그인이동
	 * @return 로그인화면
	 */
	@RequestMapping(value = "/loginPage.do", method = RequestMethod.POST)
	public String dapsLogin (HttpSession session, Member_DTO dto) {
		log.info("★★★★★ 휴면계정 비밀번호 셋팅 후 로그인 페이지 이동 ★★★★★\n{}", dto);
		boolean isc = service.updateMemberDelflagN(dto.getId()); // 휴면계정 해제
		Member_DTO mDto = service.searchPassword(dto.getId()); // id로 비밀번호, 상태 확인 (비밀번호는 변경전꺼)

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", dto.getId());
		map.put("password", dto.getPassword()); // 새로 입력한 비밀번호 가져와서 넣어주기
		map.put("delflag", mDto.getDelflag()); // 휴면계정해제 처리된 상태값 넣어주기

		boolean isc2 = service.resetPassword(map); // 재설정한 비밀번호로 정보변경
		
		Member_DTO mDto2 = service.loginMember(map);
		session.setAttribute("mem", mDto2);
		
		System.out.println("▶▷▶휴면계정해제 확인 = " + isc);
		System.out.println("▶▷▶변경한비번으로 변경여부 확인 = " + isc2);
		System.out.println("▶▷▶새로 담은 유저 정보 : "+ map.toString());
		System.out.println("▶▷▶session값 확인 : " + session.getAttribute("mem")); 

		session.invalidate();
		return "redirect:/loginPage.do";
	}
	
	/**
	 * 로그아웃
	 * @param session 회원정보를 담고 있다.
	 * @return 메인화면 이동
	 */
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		log.info("★★★★★ 로그아웃 처리 ★★★★★");
		session.invalidate();
		return "redirect:/Main.do";
	}
	
	/**
	 * 사용자 마이페이지
	 * @return 마이페이지 이동
	 */
	@RequestMapping(value = "/myPage.do")
	public String myPage() {
		log.info("★★★★★ 회원 마이페이지 이동 ★★★★★");
		return "MyPage";
	}
	
	/**
	 * 관리자 회원관리
	 * @return 회원관리 페이지 이동
	 */
	@RequestMapping(value = "/memberManagement.do")
	public String memberManagement() {
		log.info("★★★★★ 관리자 회원관리 이동 ★★★★★");
		return "MemberManagement";
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
   @RequestMapping(value = "/sendResetMail.do",method = RequestMethod.POST,
		   produces = "application/text; charset=UTF-8")
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
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("id", id);
      map.put("password", password);
      log.info("비번 초기화 하겠다");
      boolean isc = service.resetPassword(map);
      System.out.println(isc);
      
      return "true";
   }
}
