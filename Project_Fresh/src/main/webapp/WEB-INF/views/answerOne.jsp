<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>answerOne</title>
<style type="text/css">
.col-sm-6{
margin: 0 25%;
}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<form action="./deleteAnswer.do" method="post">
    <div class="col-sm-6">
      <label>번호</label> 
      <input type="text" class="form-control" value="${dto.seq}" readonly="readonly" name="seq">
      <label>내용</label> 
      <input type="text" class="form-control" value="${dto.content}">
      <label>답변일</label> 
      <input type="text" class="form-control" value="${dto.regdate}">
      <input type="submit" class="form-control" value="답변 삭제">
    </div>
  </form>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>