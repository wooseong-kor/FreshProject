<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fresh_로그인</title>
</head>
<body>	
	<%@include file="/WEB-INF/views/header.jsp"%>
	<div id="container">
		<!-- 일반 로그인 -->
		<form method="post" id="frm">	
			<input type="hidden" id="loginDelflag" name="delflag" value="N">
			<fieldset>
				<label class="id">
					<span><img src="./image/id.jpg"></span>
					<input type="text" id="loginId" name="id" placeholder="아이디를 입력하세요." required="required">
				</label>
				<br>
				<label class="password">
					<span><img src="./image/password.jpg"></span>
					<input type="password" id="loginPassword" name="password" placeholder="비밀번호를 입력하세요." required="required">
				</label>
				<ul>
					<li class="security">
						<img src="./image/security.gif" alt="보안접속"> 보안접속
					</li>
				    <li>
						<a href="#">아이디찾기</a> / <a href="#">비밀번호찾기</a>
					</li>
				</ul>
				<div>
					<input type="button" id="login" name="login" value="로그인" onclick="loginCheck()">
				</div>
				<p class="link">
			        아직 회원이 아니신가요?<br>
			        고객님을 위한 다양한 혜택이 준비되어 있습니다.<br>
			        <input type="button" id="SignUp" name="signup" value="회원가입" onclick="location.href='./memberSignup.do'">
				</p>
			</fieldset>
		</form>
		<!-- SNS Login -->
		<ul class="snsArea">
			<!-- 네이버 로그인 -->
			<li class="displaynone">
				<a href="#none" onclick="">
					<img src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/btn_naver_login.gif" alt="네이버 로그인">
				</a>
	        </li>
			<!-- 카카오 로그인 -->        
			<li class="displaynone">
				<a href="#none" onclick="">
					<img src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/btn_kakao_login.gif" alt="카카오 로그인">
				</a>
			</li>
			<!-- 구글 로그인 -->
			<li class="displaynone">
				<a href="#none" onclick="">
					<img src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/btn_google_login.gif" alt="구글 로그인">
				</a>
			</li>
		</ul>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>