<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.input{
	padding : 0px;
	border : 0.02px solid;
	width: 150px;
	height: 30px;
}

</style>
<link type="text/css" rel="stylesheet" href="./css/sweetalert.css">
</head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/sweetalert.js"></script>
<script type="text/javascript">
	
	function transfer(){
		
		var regex = /^[A-Za-z0-9]{6,12}$/;
		var pw = $("#pw").val();
		var pwConfirm = $("#pwConfirm").val();
		if (!regex.test(pw)) {
			swal("비밀번호 오류","비밀번호 형식에 맞추어 작성해 주십시오.");
		}else if(pw != pwConfirm){
			swal("비밀번호 오류","비밀번호가 맞지 않습니다.");
		}else{
			$.ajax({
				url : "./reset.do",
				data : $("#from").serialize(),
				type: "post",
				success : function(x){
					alert(x);
					if (x=="true") {
						self.location.href="./loginPage.do";
					}
				},
				error: function(){
					alert("실패");
				}
			});
			}
		
	}
</script>
<body>
<div style="width: 300px; margin: auto; margin-top: 30%;">
<form id="from">
<input type="hidden" name="id" id="id" value="${id}">
<input class="input" type="password" name="password" id="pw" placeholder="새로운 비밀번호 입력"><br>
<input class="input" style="margin-top: 10px" type="password" id="pwConfirm" placeholder="비밀번호 재입력"><br>
<input class="input" style="margin-top: 10px" type="button" onclick="transfer()" value="변경">
</form>
</div>
</body>
</html>