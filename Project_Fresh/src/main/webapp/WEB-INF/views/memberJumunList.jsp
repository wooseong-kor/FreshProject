<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function goPage(i){
	location.href="./jumunpageDeepOne.do?sangpgnum="+i;
}

</script>
<style type="text/css">
table{
	border: 1px solid chocolate;
	border-collapse: collapse;
}
th,td{
	border: 1px solid chocolate;
	border-collapse: collapse;
}
</style>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<table>
<tr>
	<th>주문번호</th>
	<th>상품</th>
	<th>배송지</th>
	<th>주문금액</th>
	<th>수량</th>
	<th>상태</th>
	<th>주문날짜</th>
</tr>
<c:forEach var="i" items="${lists}" varStatus="v">
<tr onclick="goPage(${i.sangpgnum})">
	<td>${i.jumunnum}</td>
	<td>${i.jumunpage_DTO.sangpname}</td>
	<td>${i.bsgcode}</td>
	<td>${i.jummoney}</td>
	<td>${i.jumcnt}</td>
	<td>${i.jumstat}</td>
	<td>${i.jumdate}</td>
</tr>
</c:forEach>
</table>
<c:forEach var="i" begin="${rDto.pageNum}" end="${rDto.listNum}">
	<a href="http://localhost:8099/Project_Fresh/memberJumunList.do?id=MAN&page=${i}">${i}</a>
</c:forEach>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>