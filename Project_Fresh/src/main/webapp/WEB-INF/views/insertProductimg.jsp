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
			filebrowserUploadUrl:"./insertProductImg.do" 
			
		});
	});
</script>
<title>목록 썸네일 등록</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div id="container" style="width:90%; margin: auto;">
		<div class="col-sm-6">
			<form action="./insertProductImgForm.do" class="form-horizontal" role="form" id="editorForm" method="post" enctype="multipart/form-data">
					<h5>목록 썸네일 등록</h5>
					<input type="text"  class="form-control" name="sangpgnum" placeholder="sangpgnum"><br>
					<input type="text" class="form-control" id="imgname" placeholder="imgname" name="imgname" required="required"><br>
					<input type="text" class="form-control" id="savename" placeholder="savename" name="savename" required="required"><br>
					<textarea name="imgpath" id="ckeditor"></textarea>
					<input type="submit" value="등록">
			</form>
		</div>
	</div>
<%-- <%@include file="/WEB-INF/views/footer.jsp"%> --%>
</body>
</html>