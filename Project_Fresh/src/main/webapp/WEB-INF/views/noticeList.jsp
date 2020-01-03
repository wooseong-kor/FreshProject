<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
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
<div style="width: 90%; margin: auto;">
<h3>Notice</h3>
	<table class="tab">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성일</th>
	</tr>	
	<tr>
		<td>1</td>
		<td><a href="http://localhost:8099/Project_Fresh/noticeOne.do">상품 관련 공지사항</a></td>
		<td>2020년 01월 01일</td>
	</tr>	
	<tr>
		<td>2</td>
		<td><a href="http://localhost:8099/Project_Fresh/noticeOne.do">배송 관련 공지사항</a></td>
		<td>2020년 01월 01일</td>
	</tr>	
	</table>
	</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>