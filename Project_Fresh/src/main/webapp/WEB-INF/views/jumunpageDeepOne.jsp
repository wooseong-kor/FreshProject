<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<title>jumunpageDeepOne</title>
</head>
<body>
	<%@include file="/WEB-INF/views/header.jsp"%>
	<div id="container" style="width: 90%; margin: auto;">
		<div class="col-sm-10">
			<h5>상품 코드 -${dto.sangcode}</h5>
			<h3>상품명 -${dto.sangpname}</h3>
			<h1>${dto.title}</h1>
			<h4>수량-${n}</h4>
			<h5>가격 -${dto.product_DTO.price}</h5>
			${dto.content}
		</div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>