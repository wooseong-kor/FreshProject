<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송지 등록</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.min.js"></script>
<script type="text/javascript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
function openDaumZipAddress() {
	new daum.Postcode({
		oncomplete:function(data) {
			jQuery("#postcode1").val(data.postcode1);
			jQuery("#postcode2").val(data.postcode2);
			jQuery("#zonecode").val(data.zonecode);
			jQuery("#address").val(data.address);
			jQuery("#address_etc").focus();
			console.log(data);
		}
	}).open();
}

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
<h3>배송지 등록하기</h3>
<form action="./insertAddrlistForm.do" method="post" id="formData">
	<div>
		<input type="text" class="form-control" name="id" id="id" value="${dto.id}" ><br>
		<input type="text" class="form-control" name="bsgname" placeholder="배송지 이름" required="required"><br>
		<!-- <input type="text" class="form-control" name="juso" placeholder="주소지" required="required"> --><br>
		<input type="button" onClick="openDaumZipAddress();" value = "주소 찾기" /><br>

		<input type="text" id="address" value="" style="width:240px;" name="juso" class="form-control"/>

		<input type="text" id="address_etc" value="" style="width:200px;" name="juso" class="form-control"/>
	
		<input type="text" class="form-control" name="phone" placeholder="휴대폰" required="required"><br>
		<input type="button" class="form-control" value="등록" onclick="insertAddr()"><br>
	</div>  
</form>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>