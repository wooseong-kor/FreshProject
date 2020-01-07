<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 후기 목록</title>
<style type="text/css">
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
<form>
		<div id="container" style="width: 90%; margin: auto;">
		<table class="tab">
		<tr>
		<th>번호</th>
		<th>제목</th>
		<th>아이디</th>
		<th>작성일</th>
		</tr>	
	<c:forEach var="dto" items="${hdto}" varStatus="v">
		<tr>
			<td>${dto.seq}</td>
			<td><a href="http://localhost:8099/Project_Fresh/hoogiOne.do?id=${dto.id}&seq=${dto.seq}">${dto.title}</a></td>
			<td>${dto.id}</td>
			<td>${dto.regdate}</td>
		</tr>
	</c:forEach>
		</table>	
		</div>
</form>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>