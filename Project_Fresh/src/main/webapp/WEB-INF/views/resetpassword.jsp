<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./reset.do" method="post">
<input type="hidden" name="id" value="${id}">
<input type="text" name="password" placeholder="비밀번호 재설정">
<input type="submit" value="변경">
</form>
</body>
</html>