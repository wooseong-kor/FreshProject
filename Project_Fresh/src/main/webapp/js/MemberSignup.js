$(document).ready(function(){
// 		alert("dd");
	$("#id").keyup(function(){
		var id = $(this).val();
		var idLength = $(this).val().length;
// 			alert(id);
		if (idLength == 0) {
			$("#idCheckVal").val("false");
			$("#idResult").html("");
		} else if (id.indexOf(" ") != -1) { // 공백이나 공백 특수문자 있으면
			$("#idResult").css("color", "red");
			$("#idResult").html("공백을 포함할 수 없습니다.");
			$("#idCheckVal").val("false");
		} // if 
		else if (idLength >= 5) { // id자리는 5~10만 가능 (max 10설정되어있으니까 최소만 조건에 넣음)
// 				alert(id);
			jQuery.ajax({
				type:"post",
				url:"./idCheck.do",
				data:"id="+id,
				async: true,
				success:function(msg) {
// 						alert(msg.isc);
					if (msg.isc == "true") {
// 							alert("success");
						$("#idCheckVal").val("true");
						$("#idResult").css("color", "blue");
						$("#idResult").html("사용할 수 있는 ID입니다.");
					} else {
						$("#idCheckVal").val("false");
						$("#idResult").css("color", "red");
						$("#idResult").html("사용중인 ID입니다.");
					}
				},
				error: function(){
					alert("잘못된 요청입니다.");
				}
			}); // ajax
		} //else if
		else {
			$("#idResult").css("color", "red");
			$("#idResult").html("5 ~ 10자리만 사용가능합니다.");
			$("#idCheckVal").val("false");
		}
	}); // #id key up
	
	$("#pswd2").keyup(function(){
// 			alert("작동");
		var pw1 = $("#pswd1").val();
		var pw2 = $(this).val();
		var pwRule = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&]).*$/;
		
		if (pw1.length == 0 && pw2.length == 0) {
			$("#pswdCheckVal").val("false");
			$("#pswdResult").html("");
		} else if (pw1.indexOf(" ") != -1 || pw2.indexOf(" ") != -1) {
			$("#pswdResult").css("color", "red");
			$("#pswdResult").html("비밀번호는 공백을 포함 할 수 없습니다.");
			$("#pswdCheckVal").val("false");
		} else if (!pwRule.test($("input[id='pswd2']").val())) {
			// 정규식 test했을때 값이 안맞으면
			$("#pswdResult").css("color", "red");
			$("#pswdResult").html("비밀번호는 영문, 숫자, 특수문자 조합이여야 합니다.");
			$("#pswdCheckVal").val("false");
		} else {
// 				alert("1차 성공");
			if (pw1 == pw2) {
				$("#pswdResult").css("color", "blue");
				$("#pswdResult").html("사용가능 : 비밀번호가 일치합니다.");
				$("#pswdCheckVal").val("true");
			} else {
				$("#pswdResult").css("color", "red");
				$("#pswdResult").html("비밀번호가 불일치 합니다. 재확인 바랍니다.");
				$("#pswdCheckVal").val("false");
			}
		}
	}); // #pswd2 key up
	
	$("#name").keyup(function(){
		var name = $(this).val();
		if (name.indexOf(" ") != -1) {
			$("#nameResult").css("color", "red");
			$("#nameResult").html("공백을 포함할 수 없습니다.");
			$("#nameCheckVal").val("false");
		} else if (name.length < 2) {
			$("#nameResult").css("color", "red");
			$("#nameResult").html("최소 2글자 이상 작성해야 합니다.");
			$("#nameCheckVal").val("false");
		} else {
			$("#nameCheckVal").val("true");
			$("#nameResult").html("");
		} 
	}); // #name key up
	
	$("#email").keyup(function(){
		var em = $(this).val(); 
		var emRule = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
		
		if (em.length == 0) {
			$("#emailResult").html("");
			$("#emailCheckVal").val("false");
		} else if (em.indexOf(" ") != -1) { // 공백이나 공백 특수문자 있으면
			$("#emailResult").css("color", "red");
			$("#emailResult").html("공백을 포함할 수 없습니다.");
			$("#emailCheckVal").val("false");
		} else if (!emRule.test($("input[id='email']").val())) {
			$("#emailResult").css("color", "red");
			$("#emailResult").html("email 주소 형식에 맞지 않습니다.");
			$("#emailCheckVal").val("false");
		} else {
			jQuery.ajax({
				type:"post",
				url:"./emailCheck.do",
				data:"email="+em,
				async: true,
				success:function(msg){
//					alert(msg.isc);
					if (msg.isc == "true") {
// 						alert("success");
						$("#emailCheckVal").val("true");
						$("#emailResult").css("color", "blue");
						$("#emailResult").html("사용할 수 있는 e-mail입니다.");
					} else {
						$("#idCheckVal").val("false");
						$("#emailResult").css("color", "red");
						$("#emailResult").html("사용중인 e-mail입니다.");
					}
				},
				error: function() {
					alert("잘못된 요청입니다.");
				}
			}); // ajax
		} // else
	}); // #email key up
	
	$("#phone2").keyup(function(){
		var phoneCenter = $(this).val();
		var phoneRule = /^[0-9]*$/;
		
		if (phoneCenter.length == 0) {
			$("#phoneResult").html("");
		} else if (phoneCenter.indexOf(" ") != -1) { // 공백이나 공백 특수문자 있으면
			$("#phoneResult").css("color", "red");
			$("#phoneResult").html("공백을 포함할 수 없습니다.");
		} else if (!phoneRule.test($("input[id='phone2']").val())) {
			$("#phoneResult").css("color", "red");
			$("#phoneResult").html("숫자만 입력 가능합니다.");
		} else if (phoneCenter.length > 3) {
			$("#phone3").focus();
		}  
	});
	
	$("#phone3").keyup(function(){
		var phoneLast = $(this).val();
		var phoneRule = /^[0-9]*$/;
		
		if (phoneLast.length == 0) {
			$("#phoneResult").html("");
		} else if (phoneLast.indexOf(" ") != -1) { // 공백이나 공백 특수문자 있으면
			$("#phoneResult").css("color", "red");
			$("#phoneResult").html("공백을 포함할 수 없습니다.");
		} else if (!phoneRule.test($("input[id='phone3']").val())) {
			$("#phoneResult").css("color", "red");
			$("#phoneResult").html("숫자만 입력 가능합니다.");
		}  
	});
	
}); // ready

/* 회원가입 클릭시!! */
function check(){
	var idCheckVal = document.getElementById("idCheckVal").value;
	var pswdCheckVal = document.getElementById("pswdCheckVal").value;
	var emailCheckVal = document.getElementById("emailCheckVal").value;
	var nameCheckVal = document.getElementById("nameCheckVal").value;
	
	if (idCheckVal == "false") {
		alert("아이디를 확인해주세요.");
		return false;
	} else if (pswdCheckVal == "false") {
		alert("비밀번호를 확인해주세요.");
		return false;
	} else if (emailCheckVal == "false") {
		alert("이메일을 확인해주세요.");
		return false;
	} else if (nameCheckVal == "false") {
		alert("이름을 확인해주세요.");
		return false;
	} else {
		return true;
	}
}

/* 가입취소(돌아가기) */
function cancleSignup(){
	location.href = "./index.jsp";
}
