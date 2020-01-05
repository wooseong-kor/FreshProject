<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertAnswer</title>
<style type="text/css">
.col-sm-6{
margin: 0 25%;
}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<form action="./insertAnswerForm.do" method="post" id="formData">
	<div class="col-sm-6">
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