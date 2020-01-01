package com.min.fresh.ctrl;


import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.fresh.auth.SNSLogin;
import com.min.fresh.auth.SnsValue;


@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	

//	
//	@Inject
//	private SnsValue naverSns;
//	
//	@Inject
//	private SnsValue googleSns;
//	
//	@Inject
//	private GoogleConnectionFactory googleConnectionFactory;
//	
//	@Inject
//	private OAuth2Parameters googleOAuth2Parameters;
//	
//	@RequestMapping(value = "/auth/{snsService}/callback", 
//			method = { RequestMethod.GET, RequestMethod.POST})
//	public String snsLoginCallback(Model model,@RequestParam String code) throws Exception {
//		
//		
//		// 1. code를 이용해서 access_token 받기
//		// 2. access_token을 이용해서 사용자 profile 정보 가져오기
//		SNSLogin snsLogin = new SNSLogin(googleSns);
//		String profile = snsLogin.getUserprofile(code); 
//		System.out.println("Profile>>"+profile);
//		model.addAttribute("result", profile);
//		// 3. DB 해당 유저가 존재하는 체크 (googleid, naverid 컬럼 추가)
//		
//			// 4. 존재시 강제로그인
//	
//		return "loginResult";
//	}
////	@RequestMapping(value = "/logout", method = RequestMethod.GET)
////	public String logout(HttpSession session, 
////			HttpServletRequest request, HttpServletResponse response) throws Exception {
////		logger.info("logout GET .....");
////		logger.debug("TTTTTTTTTTT My Own Code");
////		logger.info("Master Edited!!");
////		session.removeAttribute(SessionNames.LOGIN);
////		session.invalidate();
////		
////		Cookie loginCookie = WebUtils.getCookie(request, SessionNames.LOGIN);
////		if (loginCookie != null) {
////			loginCookie.setPath("/");
////			loginCookie.setMaxAge(0);
////			
////			response.addCookie(loginCookie);
////			
////			User user = (User)session.getAttribute(SessionNames.LOGIN);
////			service.keepLogin(user.getUid(), session.getId(), new Date());
////		}
////		
////		return "/login";
////	}
//	
//	@RequestMapping(value = "/loginNaver.do", method = RequestMethod.GET)
//	public void login(Model model) throws Exception {
//		logger.info("login 수령하는중~~~~~~");
//		
//		SNSLogin snsLogin = new SNSLogin(naverSns);
//		model.addAttribute("naver_url", snsLogin.getNaverAuthURL());
//		
////		SNSLogin googleLogin = new SNSLogin(googleSns);
////		model.addAttribute("google_url", googleLogin.getNaverAuthURL());
//		
//		/* 구글code 발행을 위한 URL 생성 */
//		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
//		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
//		model.addAttribute("google_url", url);
//	}
}