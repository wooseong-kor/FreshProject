<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰선택</title>
</head>
<script type="text/javascript">

 	window.onload = function() {
		var result = document.getElementById("result");
		var resultInt = parseInt(result.value);
		var obj = document.getElementsByName("couseq");
		if(resultInt < 30000) {
			for (var i = 1; i < obj.length; i++) {
				obj[i].disabled = true;
			}
		}else if(resultInt < 50000) {
			for (var i = 2; i < obj.length; i++) {
				obj[i].disabled = true;
			}
		}else if(resultInt < 100000) {
			for (var i = 3; i < obj.length; i++) {
				obj[i].disabled = true;
			}
		}
		var couponselect = document.getElementById("couponselect");
		couponselect.disabled = true;
 	}

	
	function mulChkDont(chk) {
		var obj = document.getElementsByName("couseq");
		for (var i = 0; i < obj.length; i++) {
			if(obj[i] != chk) {
				obj[i].checked = false;
			}
		}
	}
	
	function couponCheck() {
		var price = document.getElementById("childPrice");
		var obj = document.getElementsByName("couseq");
		var result = document.getElementById("result");
		var resultInt = parseInt(result.value);
		var discountprice = document.getElementById("discountPrice");
		var resultPrice = document.getElementById("resultPrice");
		if(obj[0].checked) {
			discountprice.value = "3000";
			var discountpriceInt = parseInt(discountprice.value);
			resultPrice.value = resultInt - discountpriceInt;
		}else if (obj[1].checked) {
			discountprice.value = (resultInt/100)*5;
			var discountpriceInt = parseInt(discountprice.value);
			resultPrice.value = resultInt - discountpriceInt;  
		}else if (obj[2].checked) {
			discountprice.value = (resultInt/100)*10;
			var discountpriceInt = parseInt(discountprice.value);
			resultPrice.value = resultInt - discountpriceInt; 
		}else if (obj[3].checked) {
			discountprice.value = (resultInt/100)*15;
			var discountpriceInt = parseInt(discountprice.value);
			resultPrice.value = resultInt - discountpriceInt; 
		}
		var couponselect = document.getElementById("couponselect");
		couponselect.disabled = false;
	}
	
	function couponSelect() {
		var resultPrice = document.getElementById("resultPrice").value;
		var obj = document.getElementsByName("couseq"); 
		for (var i = 0; i < obj.length; i++) {
			if(obj[i].checked) {
				opener.document.getElementById("couseq").value = obj[i].value;			
			}
		}
		opener.document.getElementById("resultPrice").value = resultPrice;
		self.close();
	}
</script>
<body>
<table id="coupontable">
	<tr>
		<td>쿠폰이름</td>
		<td>할인혜택</td>
		<td>쿠폰선택</td>
	</tr>
	<c:forEach var="dto" items="${lists}">
			<tr>
				<td>${dto.couname}</td>
				<c:choose>
				<c:when test="${dto.coucode eq 'COU01'}">
					<td><input type="hidden" value="${dto.coucode}"></td>
				</c:when>
				<c:when test="${dto.coucode eq 'COU02'}">
					<td>5%</td>
				</c:when>
				<c:when test="${dto.coucode eq 'COU03'}">
					<td>10%</td>
				</c:when>
				<c:when test="${dto.coucode eq 'COU04'}">
					<td>15%</td>
				</c:when>
				</c:choose>
				<td><input type="checkbox" name="couseq" value="${dto.couseq}" onclick="mulChkDont(this)"></td>
			</tr>
	</c:forEach>
	
	<tr>
		<td>상품원가</td>
		<td>할인금액</td>
		<td>적용후주문금액</td>
	</tr>
	<tr>
		<td><input type="text" id="childPrice" value="${price}" readonly="readonly"></td>
		<td><input type="text" id="discountPrice" readonly="readonly"></td>
		<td><input type="text" id="resultPrice" readonly="readonly"></td>
	</tr>
</table>
<input type="hidden" id="result" value="${result}">
<input type="button" value="확인하기" onclick="couponCheck()">
<input type="button" id="couponselect" value="쿠폰적용" onclick="couponSelect()">
</body>
</html>