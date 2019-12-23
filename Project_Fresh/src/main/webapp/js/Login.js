function loginCheck() {
// 		alert("dd");
		var id = document.getElementById("loginId");
		var password = document.getElementById("loginPassword");
		var delflag = document.getElementById("loginDelflag");
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
				data: "id="+id.value+"&password="+password.value+"&delflag="+delflag.value,
				success: function(msg){
					if (msg.isc == "성공") {
// 						alert(msg.delflag);
						if (msg.delflag == 'J') {
							alert("해당 계정으로는 로그인 할 수 없습니다.\n※사유※ : 경고 2회 이상으로 정지처리된 회원입니다.")
						} else if (msg.delflag == 'T') {
							alert("해당 계정으로는 로그인 할 수 없습니다.\n※사유※ : 탈퇴처리된 회원입니다.")
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

$(document).ready(function() {
    $("#login_Captcha").click(function() {
        $.ajax({
            url: './VerifyRecaptcha.do',
            type: 'post',
            data: {
                recaptcha: $("#g-recaptcha-response").val()
            },
            success: function(data) {
                switch (data) {
                    case 0:
                        alert("자동 가입 방지 봇 통과");
                        break;

                    case 1:
                        alert("자동 가입 방지 봇을 확인 한뒤 진행 해 주세요.");
                        break;

                    default:
                        alert("자동 가입 방지 봇을 실행 하던 중 오류가 발생 했습니다. [Error bot Code : " + Number(data) + "]");
                        break;
                }
            }
        });
    });
});
