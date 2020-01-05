<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송지 수정</title>
<style type="text/css">
.col-sm-6{
margin: 0 25%;
}
</style>
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
</script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<!-- 배송지 수정 -->
<form action="./updateAddrlistForm.do" method="post">
	<div class="col-sm-6">
		<input type="text" name="id" class="form-control" placeholder="${dto.id}" readonly="readonly" value="${dto.id}"><br>
		<input type="text" name="bsgcode" class="form-control" placeholder="${dto.bsgcode}" value="${dto.bsgcode}"><br>
		<input type="text" name="bsgname" class="form-control" placeholder="배송지이름" required="required"><br>
		<input type="button" onClick="openDaumZipAddress();" value = "주소 찾기" /><br>
		<input type="text" id="address" value="" style="width:240px;" name="juso" class="form-control" required="required"/>
		<input type="text" id="address_etc" value="" style="width:200px;" name="juso" class="form-control"/>
		<input type="text" name="phone" class="form-control" placeholder="핸드폰번호" required="required"><br>
		<input type="submit" value="등록" class="form-control"><br>
	</div>
</form>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>