<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 질문 상세</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div id="container" style="width:90%; margin: auto;">
		<div class="col-sm-6">
					${qDto}
					<input type="button" value="삭제">
		</div>
	</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>