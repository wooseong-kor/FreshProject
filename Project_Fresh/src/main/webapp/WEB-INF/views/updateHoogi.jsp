<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 후기 수정</title>
<style type="text/css">
.col-sm-6{
margin: 0 25%;
}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<form action="./updateHoogiForm.do" method="post">
<div class="col-sm-6">
		<input type="text" name="seq" class="form-control" placeholder="${dto.seq}" readonly="readonly" value="${dto.seq}"><br>
		<input type="text" name="title" class="form-control" placeholder="${dto.title}" value="${dto.title}"><br>
		<input type="text" name="content" class="form-control" placeholder="${dto.content}" value="${dto.content}"><br>
		<input type="submit" value="수정" class="form-control"><br>
	</div>
</form>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>