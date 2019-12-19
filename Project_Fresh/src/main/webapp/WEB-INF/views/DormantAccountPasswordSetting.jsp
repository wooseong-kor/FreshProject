<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재설정</title>
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#password").keyup(function(){
// 		alert("작동");
		var id = document.getElementById("id").value;
// 		alert(id);
		var password = $(this).val();
		var pwRule = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&]).*$/;
	
		if (password.length == 0) {
			$("#pswdCheckVal").val("false");
			$("#pswdResult").html("");
		} else if (password.indexOf(" ") != -1) {
			$("#pswdResult").css("color", "red");
			$("#pswdResult").html("비밀번호는 공백을 포함 할 수 없습니다.");
			$("#pswdCheckVal").val("false");
		} else if (!pwRule.test($("input[id='password']").val())) {
			// 정규식 test했을때 값이 안맞으면
			$("#pswdResult").css("color", "red");
			$("#pswdResult").html("비밀번호는 영문, 숫자, 특수문자 조합이여야 합니다.");
			$("#pswdCheckVal").val("false");
		} else if(password.length > 0) {
			jQuery.ajax({
				type:"post",
				url:"./pwCheck.do",
				data:"id="+id+"&password="+password,
				async: true,
				success:function(msg) {
// 						alert(msg.isc);
					if (msg.isc == "불가") {
						$("#pswdCheckVal").val("false");
						$("#pswdResult").css("color", "red");
						$("#pswdResult").html("이전 비밀번호는 사용할 수 없습니다.");
					} else {
						$("#pswdResult").css("color", "blue");
						$("#pswdResult").html("사용가능");
						$("#pswdCheckVal").val("true");
						dd
					}
				},
				error: function(){
					alert("잘못된 요청입니다.");
				}
			}); // ajax
		}
		
	}); // #pswd2 key up
});

/* 확인 클릭시!! */
function check(){
	var pswdCheckVal = document.getElementById("pswdCheckVal").value;
	
	if (pswdCheckVal == "false") {
		alert("비밀번호를 확인해주세요.");
		return false;
	} else {
		return true;
	}
} // check()

</script>
<body>
<%-- 	${mem} --%>
<!-- 	<hr> -->
	"${mem.name}" 님 오랜만에 방문하셨네요^^<br>
	고객님의 계정은 장기간(6개월 이상) 서비스 이용 중단으로<br>
	휴면계정으로 전환되어 별도 보관되어 있습니다.<br>
	<br>
	비밀번호 재설정 후 고객님의 계정을 활성화 시킬 수 있습니다.<br>
<form action="./loginPage.do" method="post" onsubmit="check()">
	<input type="hidden" id="pswdCheckVal" value="false">
	<input type="hidden" id="id" name="id" value="${mem.id}">
	<input type="hidden" id="delflag" name="delflag" value="${mem.delflag}">
	<!-- 비밀번호 -->
	<div class="join_row">
	    <h3 class="join_title">
	    	<label for="pswd1">비밀번호 <img src="./image/star.gif" alt="필수" />
			<span style="color: gray; font-size:11px; ">대·소문자, 숫자, 특수문자를 조합하여 8 ~ 15자리 이내여야 합니다.</span>
	    	</label>
	    	<br>
			<input type="password" id="password" name="password" required="required" maxlength="15">
			<span id="pswdResult" style="font-size: 13px"></span>
	    </h3>
	</div>
	<input type="button" value="취소">
	<input type="submit" value="확인">
</form>
</body>
</html>