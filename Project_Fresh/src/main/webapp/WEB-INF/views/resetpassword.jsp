<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	
	function transfer(){
		$.ajax({
			url : "./reset.do",
			data : $("#from").serialize(),
			type: "post",
			success : function(x){
				alert(x);
				if (x=="true") {
					self.location.href="./login.do";
				}
			},
			error: function(){
				alert("실패");
			}
		});
		
	}
</script>
<body>
<form id="from">
<input type="hidden" name="id" id="id" value="${id}">
<input type="text" name="password" id="pw" placeholder="비밀번호 재설정">
<input type="button" onclick="transfer()" value="변경">
</form>
</body>
</html>