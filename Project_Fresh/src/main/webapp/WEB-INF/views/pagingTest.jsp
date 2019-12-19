<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<form>
<c:forEach var="dto" items="${lists}" varStatus="vs">
		<div class="col-sm-10">
		<table>
		<tr>
			<th>${dto.seq}</th>
			<th>${dto.title}</th>
			<th>${dto.content}</th>
			<th>${dto.regdate}</th>
		</tr>
		</table>	
		</div>
</c:forEach>
</form>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>