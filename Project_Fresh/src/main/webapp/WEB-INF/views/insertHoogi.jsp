<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 등록</title>
<style type="text/css">
.col-sm-6{
margin: 0 25%;
}
</style>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/sweetalert.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<!-- 배송지 등록 -->
<form action="./insertHoogiForm.do" method="post" id="formData">
	<div class="col-sm-6">
		<input type="text" class="form-control" name="id" id="id" placeholder="아이디"><br>
		<input type="text" class="form-control" name="sangpgnum" placeholder="상품 페이지 번호"><br>
		<input type="text" class="form-control" name="title" placeholder="제목"><br>
		<input type="text" class="form-control" name="content" placeholder="내용"><br>
		<input type="submit" class="form-control" value="등록">
	</div>  
</form>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>