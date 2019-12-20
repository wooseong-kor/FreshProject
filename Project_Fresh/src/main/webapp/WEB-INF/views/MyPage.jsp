<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 뿌리기</title>
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<body>
	<%@include file="/WEB-INF/views/header.jsp"%>
	<div id="container">
		<h2>" ${mem.name} " 님</h2>
		${mem}
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>