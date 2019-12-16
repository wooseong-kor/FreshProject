

package com.min.fresh.ctrl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	@Autowired
//	private IMemberService service;
	
	/**
	 * 네이버 로그인 창을 띄운다
	 * @param model
	 * @param session
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/login.do",method = RequestMethod.GET)
	public void login(Model model, HttpSession session) throws UnsupportedEncodingException {
		logger.info("네이버 로그인 진입");
		 String clientId = "JM0KTccnO5VR3Agsnv0Q";//애플리케이션 클라이언트 아이디값";
		    String redirectURI = URLEncoder.encode("http://localhost:8099/NaverLogin/callBack", "UTF-8");
		    SecureRandom random = new SecureRandom();
		    String state = new BigInteger(130, random).toString();
		    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code"; // 네아로 창으로 이동하는 API 주소
		    apiURL += "&client_id=" + clientId;
		    apiURL += "&redirect_uri=" + redirectURI;
		    apiURL += "&state=" + state;
		    
		    session.setAttribute("state", state);
		    System.out.print(apiURL);
		    model.addAttribute("apiURL", apiURL); 
	}
	
	/**
	 * 엑세스 토큰을 발급받게 함
	 * @param model
	 * @param code
	 * @param state
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/callBack.do",method = RequestMethod.GET)
	public String callBack(Model model,String code,String state) throws UnsupportedEncodingException {
		logger.info("콜백 진입");
		String clientId = "JM0KTccnO5VR3Agsnv0Q";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "vkdKEUJpIQ";//애플리케이션 클라이언트 시크릿값";
	    String redirectURI = URLEncoder.encode("http://localhost:8099/NaverLogin/Join", "UTF-8");
	    String apiURL;
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&"; // 엑세스 토큰 받아오는 API 주소
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;
	    String access_token = "";
	    String refresh_token = "";
	    System.out.println("apiURL="+apiURL);
	    try {
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET"); // 엑세스 토큰 받아옴
	      int responseCode = con.getResponseCode();
	      BufferedReader br;
	      System.out.print("responseCode="+responseCode);
	      if(responseCode==200) { // 정상 호출
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // 에러 발생
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String inputLine;
	      StringBuffer res = new StringBuffer();
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      br.close();
	      if(responseCode==200) {
	        model.addAttribute("res", res.toString());
	        
	        Object obj = JSONValue.parse(res.toString());  // 엑세스 토큰 JSON으로 받아와서 String 으로 변환해줌
	        System.out.println(obj+"오브젝트 제이슨");
	        JSONObject json = (JSONObject)obj;
	        refresh_token = (String)json.get("refresh_token");
	        access_token = (String)json.get("access_token");
	        model.addAttribute("access_token",access_token);
	      }
	    } catch (Exception e) {
	      System.out.println(e);
	    }
		
		return "redirect:/join";
	}
	
	/**
	 * 엑세스 토큰으로 사용자 프로필을 받아온다
	 * @param model
	 * @param access_token
	 * @return
	 */
//	@RequestMapping(value = "/join")
//	public String join(Model model,String access_token,HttpSession session) {
//		String token = access_token;// 네이버 로그인 접근 토큰;
//        String header = "Bearer " + token; // Bearer 다음에 공백 추가
//        try {
//        	System.out.println("나는 화면에서 전달받은 엑세스 토큰이야"+token);
//        	String apiURL = "https://openapi.naver.com/v1/nid/me"; // 엑세스 토큰으로 사용자의 프로필을 가져오는 api 주소
//            URL url = new URL(apiURL);
//            HttpURLConnection con = (HttpURLConnection)url.openConnection();
//            con.setRequestMethod("GET");
//            con.setRequestProperty("Authorization", header);
//            int responseCode = con.getResponseCode(); // 받아옴
//            BufferedReader br;
//            if(responseCode==200) { // 정상 호출
//                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            } else {  // 에러 발생
//                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
//            }
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = br.readLine()) != null) {
//                response.append(inputLine);
//            }
//            br.close();
//            System.out.println("사용자의 정보"+response.toString());
//            
//            JSONObject json = (JSONObject) JSONValue.parse(response.toString());
//            JSONObject rJson = (JSONObject) json.get("response");
//            String email = (String) rJson.get("email");
//            String sns = email.substring(email.indexOf("@")+1);  // 받아온 사용자 프로필에서 이메일만 추출
//            
//            SnsMemberDto dto = service.SNSLogin(email);
//            if (dto != null) {
//            	session.setAttribute("session", dto);
//            	return "main";
//            }else {
//            	model.addAttribute("sns", sns);
//            	model.addAttribute("email", email);
//            	model.addAttribute("user", response.toString());
//            	model.addAttribute("eauth", MailSender.CreateUUID()); // 이메일 인증을 위한 난수
//            	return "signUp";
//            }
//            
//        } catch (Exception e) {
//            System.out.println(e);
//            return "callBack";
//        }
//	}
	
	
	
	
}
