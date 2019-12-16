<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateAddrlist</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<!-- 배송지 수정 -->
<form action="./updateAddrlistForm.do" method="post">
	<div>
		<input type="text" name="id"><br>
		<input type="text" name="bsgcode"><br>
		<input type="text" name="bsgname" placeholder="배송지이름"><br>
		<input type="text" name="juso" placeholder="주소지"><br>
		<input type="text" name="phone" placeholder="핸드폰번호"><br>
		<input type="submit" value="등록"><br>
	</div>
</form>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>