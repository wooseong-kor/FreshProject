<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function submit(){
		$.ajax({
			url : "./reset.do",
			data : "id="+$("#id").val()+"&password="+$("$pw").val(),
			type: "post",
			async: true,
			success :function(x){
				alert(x);
				if (x=="초기화") {
					alert(x+"초기화");
					self.close();
				}
			},
			error: function(){
				alert("실패");
			},
		});
		
	}
</script>
<body>
<form action="#" id="from">
<input type="hidden" name="id" id="id" value="${id}">
<input type="text" name="password" id="pw" placeholder="비밀번호 재설정">
<input type="button" onclick="submit()" value="변경">
</form>
</body>
</html>