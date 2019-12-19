<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>

<script type="text/javascript">
	function loginCheck() {
// 		alert("dd");
		var id = document.getElementById("id");
		var password = document.getElementById("password");
		var frm = document.getElementById("frm");
		
		frm.action = "./login.do"; // ajax에서 이동할 주소
		
		if (id.value == null || id.value.trim() == "") {
			id.focus();
			id.value = "";
		} else if (password.value == null || password.value.trim() == "") {
			password.focus();
			password.value = "";
		} else {
			jQuery.ajax({
				type: "post",
				url: "./loginCheck.do",
				data: "id="+id.value+"&password="+password.value,
				success: function(msg){
					if (msg.isc == "성공") {
// 						alert(msg.delflag);
						if (msg.delflag == "J") {
							alert("해당 계정으로는 로그인 할 수 없습니다.\n※사유※ : 경고 2회 이상으로 정지처리된 회원입니다.")
						} else {
							frm.submit(); // 사용가능, 휴면계정 모두 (휴면계정은 login.do에서 처리)
						}
					} else {
						alert("로그인 실패\n아이디, 비밀번호 재확인바랍니다.")
					}
				},
				error: function(){
					alert("로그인 실패\n로그인에 문제가 발생하였습니다\n다시 시도해주세요.")
				}
			}); // ajax
		}
	}
</script>
<body>
	<div class="login">
		<!-- 일반 로그인 -->
		<form method="post" id="frm">	
			<fieldset>
				<label class="id">
					<span><img src="./image/id.jpg"></span>
					<input type="text" id="id" name="id" placeholder="아이디를 입력하세요." required="required">
				</label>
				<br>
				<label class="password">
					<span><img src="./image/password.jpg"></span>
					<input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요." required="required">
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
			        <input type="button" id="SignUp" name="signup" value="회원가입">
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
</body>
</html>