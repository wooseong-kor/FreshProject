<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertAnswer</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<form action="./insertAnswerForm.do" method="post" id="formData">
	<div>
		<label>seq</label>
		<input type="text" class="form-control" name="seq" value="${dto.seq}"><br>
		<label>답변</label>
		<input type="text" class="form-control" name="acontent" placeholder="답변"><br>
		<input type="submit" class="form-control" value="등록">
	</div>  
</form>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>