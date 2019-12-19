<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<title>jumunpageDeepOne</title>
<style type="text/css">
	.jumunContainer{
		position : fixed;
		width: 300px;
		right: 300px;
	}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<script type="text/javascript">
	function change(){
		sel = $("#count option:selected").val();
		totalmoney = $("#absolprice").val();
		var sangcode = document.getElementById("realsangcode").value;
		$("#price").html(sel*totalmoney);
		
		$.ajax({
			url : "./selectJaegoCnt.do",
			type : "post",
			data : "sangcode="+sangcode,
			success : function(cnt){
				$("#cnt").html(cnt);
				if (cnt==='0') {
				$("#cnt").html("품절").css("color", "tomato");
					//주문버튼 비활성화
				}
			},
			error : function(){
				alert("실패");
			}
		});
		
	}
	
	function selOption() {
		var rbox = document.getElementsByName("couOrMile");
		var mileageuse = document.getElementById("mileageuse");
		var couponuse = document.getElementById("couponuse");
		var maxmile = document.getElementById("maxmile");
		var memberMileage = document.getElementById("memberMileage");
		var resultPrice = document.getElementById("resultPrice");
		var couseq = document.getElementById("couseq");
		if(rbox[0].checked) {
			mileageuse.value = "";
			maxmile.checked = false;
			mileageuse.disabled = true;
			maxmile.disabled = true;
			couponuse.disabled = false;
		}else {
			resultPrice.value = "";
			couseq.value = "";
			mileageuse.disabled = false;
			maxmile.disabled = false;
			couponuse.disabled = true;
		}
		
	}
	
	function maxMile() {
		var mileageuse = document.getElementById("mileageuse");
		var maxmile = document.getElementById("maxmile");
		var memberMileage = document.getElementById("memberMileage");
		if(maxmile.checked){
			mileageuse.value = memberMileage.value;
		}else {
			mileageuse.value = "";
		}
		
	}
	
	function couponUse() {
		var price = document.getElementById("absolprice");
		var jumcnt = document.getElementById("count");
		var url="./couponUse.do?price="+price.value+"&jumcnt="+jumcnt.value;
		var title="쿠폰적용";
		var prop = "width=500px, height=500px";
		open(url,title,prop);
	}
	
	window.onload = function() {
		var mileageuse = document.getElementById("mileageuse");
		var couponuse = document.getElementById("couponuse");
		var maxmile = document.getElementById("maxmile");
		mileageuse.disabled = true;
		couponuse.disabled = true;
		maxmile.disabled = true;
	}
</script>
	<div id="container" style="width: 90%; margin: auto;">
		<div class="col-sm-10">
			<h5>상품 코드 -${dto.sangcode}</h5>
			<h3>상품명 -${dto.sangpname}</h3>
			<h1>${dto.title}</h1>
			<h4>수량-${n}</h4>
			<h5>가격 -${dto.product_DTO.price}</h5>
			${dto.content}
		</div>
	</div>
	<div class="jumunContainer" >
		<div>
			<p>상품페이지번호 : ${dto.sangpgnum}</p>
			<h3>상품명 : ${dto.sangpname}</h3>
			<h1>${dto.title}</h1>
		</div>
			<form action="#">
		<div>
			<h5 id="sangcodetag">상품 코드 - <span id="sangcode">${dto.sangcode}</span></h5>
			<h3 id="pricetag">가격 - <span id="price">${dto.product_DTO.price}</span></h3>
			<input type="hidden" id="absolprice" value="${dto.product_DTO.price}">
			<input type="hidden" id="realsangcode" name="sangcode" value="${dto.sangcode}">
			<h4>
				수량 -
				<select id="count" name="jumcnt" onchange="change()">
					<option value="1" selected="selected">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				재고량 - <span id="cnt">${n}</span>
			</h4>
		</div>
			</form>
		<div>
			<input type="radio" name="couOrMile" onclick="selOption()">쿠폰 
			<input type="radio" name="couOrMile" onclick="selOption()">마일리지<br>
			<input type="button" id="couponuse" value="쿠폰 적용" onclick="couponUse()">
			<input type="text" id="mileageuse">
			<input type="hidden" id="memberMileage" value="${mileage}">
			<input type="checkbox" id="maxmile" onclick="maxMile()">최대금액 적용<br>
			<input type="hidden" id="resultPrice">
			<input type="hidden" id="couseq">
		</div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>