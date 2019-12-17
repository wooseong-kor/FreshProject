$(document).ready(function(){
// 		alert("dd");
	$("#id").keyup(function(){
		var id = $(this).val();
		var idLength = $(this).val().length;
// 			alert(id);
		if (idLength == 0) {
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
			$("#pswdResult").html("");
		} else if (!pwRule.test($("input[id='pswd2']").val())) {
			// 정규식 test했을때 값이 안맞으면
			$("#pswdResult").css("color", "red");
			$("#pswdResult").html("비밀번호가 입력되지 않았습니다.");
			return false;
		} else {
// 				alert("1차 성공");
			if (pw1 == pw2) {
				$("#pswdResult").css("color", "blue");
				$("#pswdResult").html("사용가능 : 비밀번호가 일치합니다.");
				return true;
			} else {
				$("#pswdResult").css("color", "red");
				$("#pswdResult").html("비밀번호가 불일치 합니다. 재확인 바랍니다.");
				return false;
			}
		}
	}); // #pswd2 key up
	
	$("#name").keyup(function(){
		var name = $(this).val();
		if (name.length == 0) {
			$("#nameResult").html("");
		} else if (name.indexOf(" ") != -1) {
			$("#nameResult").css("color", "red");
			$("#nameResult").html("공백을 포함할 수 없습니다.");
		} else if (name.length < 2) {
			$("#nameResult").css("color", "red");
			$("#nameResult").html("최소 2글자 이상 작성해야 합니다.");
		}
	}); // #name key up
	
	$("#email").keyup(function(){
		var em = $(this).val(); 
		var emRule = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
		
		if (em.length == 0) {
			$("#emailResult").html("");
		} else if (em.indexOf(" ") != -1) { // 공백이나 공백 특수문자 있으면
			$("#emailResult").css("color", "red");
			$("#emailResult").html("공백을 포함할 수 없습니다.");
			$("#emailCheckVal").val("false");
		} else if (!emRule.test($("input[id='email']").val())) {
			$("#emailResult").css("color", "red");
			$("#emailResult").html("email 주소 형식에 맞지 않습니다.");
		} else {
			$("#emailResult").css("color", "blue");
			$("#emailResult").html("email 형식에 맞습니다.");
			
			jQuery.ajax({
				type:"post",
				url:"./emailCheck.do",
				data:"email="+em,
				async: true,
				success:function(msg){
					alert(msg.isc);
					if (msg.isc == "true") {
// 							alert("success");
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
	
}); // ready

/* 회원가입 클릭시!! */
function check(){
// 		alert("dd");
	// id중복, pw일치여부, email정규화 => false - true
	var idCheckVal = document.getElementById("idCheckVal").value;
	var emailCheckVal = document.getElementById("emailCheckVal").value;
	
	var id = document.getElementById("id").value;
	var pswd1 = document.getElementById("pswd1").value;
	var pswd2 = document.getElementById("pswd2").value;
	var name = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	
	if (idCheckVal == "false") {
		alert("아이디를 확인해주세요.");
		return false;
	} else if (emailCheckVal == "false") {
		alert("이메일을 확인해주세요.");
		return false;
	}
}

/* 가입취소(돌아가기) */
function cancleSignup(){
	location.href = "./index.jsp";
}
