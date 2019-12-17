<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jumunpageListScroll</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
	<div id="container" style="width: 90%; margin: auto;">
		<div class="col-sm-10">
		 <c:forEach var="dto" items="${lists}" varStatus="vs">
		    <h5>상품명 -${dto.sangpname}</h5>
			<h3>${dto.title}</h3>
			<h1>${dto.content}</h1>
			<h5>가격 -${dto.product_DTO.price}</h5>
			</c:forEach>
		</div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>