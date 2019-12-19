<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome_Fresh_Wolrd</title>
</head>
<body>
	<%@include file="/WEB-INF/views/header.jsp"%>
	<div id="container">
		<!-- 관리자 -->
		<c:if test="${fn:trim(mem.gcode) eq 'A'}">
			${mem.name} (${mem.gcode}) 관리자 모드로 로그인 되었습니다.
		</c:if>
		<!-- 회원 -->
		<c:if test="${fn:trim(mem.gcode) ne 'A'}">
			${mem.name} (${mem.gcode}) 님 반갑습니다~♥
		</c:if>
		<br>
		${mem}
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>