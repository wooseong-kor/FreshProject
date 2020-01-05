<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 상세 조회</title>
<style type="text/css">
.col-sm-6{
margin: 0 25%;
}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div class="col-sm-6">
	<h3>후기 상세 조회</h3><br>
	<label>번호</label>
		<input type="text" name="seq" class="form-control" readonly="readonly" value="${dto.seq}"><br>
	<label>상품번호</label>
		<input type="text" name="sangpgnum" class="form-control" value="${dto.sangpgnum}"><br>
	<label>아이디</label>
		<input type="text" name="id" class="form-control" value="${dto.id}"><br>
	<label>후기 제목</label>
		<input type="text" name="title" class="form-control" value="${dto.title}"><br>
	<label>후기 내용</label>
		<input type="text" name="content" class="form-control" value="${dto.content}"><br>
	<label>작성일</label>
		<input type="text" name="regdate" class="form-control" value="${dto.regdate}"><br>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>