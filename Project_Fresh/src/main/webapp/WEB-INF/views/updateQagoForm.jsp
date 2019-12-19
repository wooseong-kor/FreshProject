<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./ckeditor/ckeditor.js"></script>
<script type="text/javascript">
//json
	$(function() {
		CKEDITOR.replace('ckeditor', {
			width:"100%",
			height:"300px",
			filebrowserUploadUrl:"./insertQagoImg.do" 
			
		});
	});
</script>
<title>QnA 질문 수정</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div id="container" style="width:90%; margin: auto;">
		<div class="col-sm-6">
			<form action="./updateQagoForm.do" class="form-horizontal" role="form" id="editorForm" method="post">
					<h2>QnA 질문 수정</h2>
					<label for="id">번호</label> 
					<input type="text"  class="form-control" name="seq">
					<label for="id">아이디</label> 
					<input type="text"  class="form-control" name="id" placeholder="아이디">
					<label for="title">제목</label>
					<input type="text" class="form-control" id="title" placeholder="제목" name="title" required="required"><br>
					<label for="content">내용</label> 
					 <textarea name="content" id="ckeditor">${dto}</textarea>
				
					<input type="submit" value="글수정">
			</form>
		</div>
	</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>