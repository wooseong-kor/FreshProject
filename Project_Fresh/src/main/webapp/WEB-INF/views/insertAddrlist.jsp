<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송지 등록</title>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/sweetalert.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript">
function insertAddr() {
	$.ajax({
		url:"./insertAddrlistForm.do",
		type:"post",
		data:$("#formData").serialize(),
		async:true,
		success:function(val){
			alert(val)
		},
		error:function(val){
			alert(val)
		}
	});
}
</script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<!-- 배송지 등록 -->
<form action="./insertAddrlistForm.do" method="post" id="formData">
	<div>
		<input type="text" name="id" id="id" placeholder="아이디"><br>
		<input type="text" name="bsgname" placeholder="배송지 이름"><br>
		<input type="text" name="juso" placeholder="주소지"><br>
		<input type="text" name="phone" placeholder="휴대폰"><br>
		<input type="button" value="등록" onclick="insertAddr()">
	</div>  
</form>
<a href="./updateAddrlist.do">배송지 수정하기</a><br>
<a href="./addrlistIdList.do">배송지 조회하기</a>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>