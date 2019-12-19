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
