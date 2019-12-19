function memberSignupAction(){
		var serviceChk = document.getElementById("agree_service_check").checked;
		var privacyChk = document.getElementById("agree_privacy_check").checked;
		
		if (serviceChk == true && privacyChk == true) {
			alert("약관확인완료\n회원가입 페이지로 이동합니다.")
			location.href = "./memberSignup.do";
		} else if(serviceChk == false && privacyChk == true) {
			alert("이용약관은 필수 동의 사항입니다.")
		} else if(serviceChk == true && privacyChk == false) {
			alert("개인정보 수집 및 이용은 필수 동의 사항입니다.")
		} else {
			alert("약관 정보 확인 후 동의 진행바랍니다.")
		}
}