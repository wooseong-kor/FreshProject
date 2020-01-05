<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addrlistIdList</title>
<style type="text/css">
.col-sm-6{
margin: 0 25%;
}
table.tab{
border-collapse: separate;
border-spacing: 1px; 
text-align: center; 
line-height: 1.5; 
margin: 20px 10px;
text-decoration: none;
}
table.tab th { 
width: 155px; 
padding: 10px; 
font-weight: bold; 
vertical-align: top; 
color: #fff; 
background: #006400;
}
table.tab td { 
width: 155px; 
padding: 10px; 
vertical-align: top; 
border-bottom: 1px solid #ccc; 
background: #eee;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/header.jsp"%>
	<div id="container" class="col-sm-6">
	<table class="tab">
	<tr>
		<th>배송지 코드</th>
		<th>배송지 이름</th>
		<th>주소</th>
		<th>핸드폰 번호</th>
	</tr>	
	<c:forEach var="dto" items="${aDto}" varStatus="v">
	<tr>
		<td><a href="http://localhost:8099/Project_Fresh/addrListOne.do?id=MAN&bsgcode=${dto.bsgcode}">${dto.bsgcode}</a></td>
		<td>${dto.bsgname}</td>
		<td>${dto.juso}</td>
		<td>${dto.phone}</td>
	</tr>	
	</c:forEach>
	</table>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>