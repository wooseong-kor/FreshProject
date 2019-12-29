<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fresh_가입축하</title>
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript">
	function takeCoupon() {
		var id = document.getElementById("id");
		location.href = "./takeCoupon.do?id="+id.value;
	}
</script>
<body>	
	<%@include file="/WEB-INF/views/header.jsp"%>
	<div id="container">
		<img alt="환영합니다." src="./image/welcome.jpg">
		<br>
		<input type="hidden" id="id" name="id" value="${id}">
		<input type="button" value="가입축하 쿠폰받기" onclick="takeCoupon()">
		<br>
		<a href="./loginPage.do">
			<input type="button" value="로그인 하러가기">
		</a>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>