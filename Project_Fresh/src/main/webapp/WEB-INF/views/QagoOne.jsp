<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 질문 상세</title>
<style type="text/css">
.col-sm-6{
margin: 0 25%;
}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<form>
<div id="container" style="width:90%; margin: auto;">
	<div class="col-sm-6">
	<h4>${qDto.id}님의 질문</h4>
	  <label>제목</label> <br>
      ${qDto.title}<br>
      <label>내용</label> <br>
      ${qDto.content}<br>
      <label>작성일</label> <br>
      ${qDto.regdate}
    <input type="button" class="form-control" value="질문 수정" onclick="update()">
    <input type="button" class="form-control" value="질문 삭제" id="del">
    <input type="button" class="form-control" value="답변 확인" onclick="reply()">
    </div>
</div>
</form>
<script type="text/javascript">
  window.onload=function(){
		var del=document.getElementById("del");
		del.onclick=function(){
			var formData=document.forms[0];
			formData.action="./deleteQago.do?seq=${qDto.seq}";
			formData.method="post";
			formData.submit();
		}
	}
  function update(){
	  location.href="./updateQago.do?seq=${qDto.seq}";
  }
  function reply(){
	  location.href="./answerOne.do?seq=${dto.seq}";
  }
  </script>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>