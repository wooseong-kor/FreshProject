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
			filebrowserUploadUrl:"./insertJumunpageImg.do" 
			
		});
	});
</script>
<title>상품 구매페이지 등록</title>
<style type="text/css">
.col-sm-6{
margin: 0 25%;
padding-bottom: 10%;
}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div id="container" style="width:90%; margin: auto;">
		<div class="col-sm-6">
			<form action="./insertJumunpageForm.do" class="form-horizontal" role="form" id="editorForm" method="post">
					<h5>상품 구매페이지 등록</h5>
					<input type="text"  class="form-control" name="sangpgnum" placeholder="sangpgnum"><br>
					<input type="text" class="form-control" id="sangcode" placeholder="sangcode" name="sangcode" required="required"><br>
					<input type="text" class="form-control" id="sangpname" placeholder="sangpname" name="sangpname" required="required"><br>
					<input type="text" class="form-control" id="title" placeholder="title" name="title" required="required"><br>
					<textarea name="content" id="ckeditor"></textarea>
				
					<input type="submit" value="등록">
			</form>
		</div>
	</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>