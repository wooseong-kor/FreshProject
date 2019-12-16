<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>QnA 질문 작성</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div id="container" style="width:90%; margin: auto;">
		<div class="col-sm-6">
			<form action="./QagoWrite.do" class="form-horizontal" role="form" id="editorForm" method="post">
					<label for="id">작성자</label> 
					<p class="form-control">${dto.id}</p>
					<label for="title">제목</label>
					<input type="text" class="form-control" id="title" placeholder="Enter title" name="title" required="required"><br>
					<label for="content">내용</label> 
					 <textarea name="content" id="ckeditor"></textarea>
				
					<input type="submit" value="글등록">
			
			</form>
		</div>
	</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>