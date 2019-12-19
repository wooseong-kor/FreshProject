<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송지 등록</title>
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
		error:function(){
			alert("항목을 입력해주세요.")
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
		<input type="text" class="form-control" name="id" id="id" value="${dto.id}" ><br>
		<input type="text" class="form-control" name="bsgname" placeholder="배송지 이름" required="required"><br>
		<input type="text" class="form-control" name="juso" placeholder="주소지" required="required"><br>
		<input type="text" class="form-control" name="phone" placeholder="휴대폰" required="required"><br>
		<input type="button" class="form-control" value="등록" onclick="insertAddr()"><br>
	</div>  
</form>
<a href="./updateAddrlist.do?id=${dto.id}&bsgcode=${dto.bsgcode}">배송지 수정하기</a><br>
<a href="./addrlistIdList.do?id=${dto.id}">배송지 조회하기</a>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>