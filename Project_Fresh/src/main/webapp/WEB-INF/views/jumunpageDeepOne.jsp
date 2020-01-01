<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<title>상품 구매 페이지</title>
<style type="text/css">
body {
  font-family: "Lato", sans-serif;
}

.wrapper{
  padding: 0 30px;
}

#main {/* 이미지 div */
  width: 60%;
  float:left;
}

#main img{ /* 이미지 */
    width: 100%;
}

#sidenav-wrapper{
    float:left;
    margin-left: 2%; 
}

.sidenav {
  width: 550px;
  position: fixed;
  z-index: 1;
  background-color: #EAEAEA;
  overflow-x: hidden;
  padding: 20px;
}

.sidenav form{
	display: block;
	margin: 0 auto;
	text-align: center;
}

.tag-name {
margin-bottom: 50px;
}

input[type=button]{
	width: 200px;
	padding: 5px;
	display: block;
	margin: 0 auto;
}

.wrapper::after{
    display: table;
    clear: both;
    content: "";
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/header.jsp"%>
	<script type="text/javascript">
		function change() {
			sel = $("#count option:selected").val();
			totalmoney = $("#absolprice").val();
			var sangcode = document.getElementById("realsangcode").value;
			$("#price").html(sel * totalmoney);
			$("#jummoney").val(Number(sel * totalmoney));

			$.ajax({
				url : "./selectJaegoCnt.do",
				type : "post",
				data : "sangcode=" + sangcode,
				success : function(cnt) {
					$("#cnt").html(cnt);
					if (cnt === '0') {
						$("#cnt").html("품절").css("color", "tomato");
						//주문버튼 비활성화
						$("#onPayment").attr("disabled",true);
					}
				},
				error : function() {
					alert("실패");
				}
			});

		}

		function selOption() {
			var rbox = document.getElementsByName("couOrMile");
			var mileage = document.getElementById("mileage");
			var couponuse = document.getElementById("couponuse");
			var maxmile = document.getElementById("maxmile");
			var memberMileage = document.getElementById("memberMileage");
			var resultPrice = document.getElementById("resultPrice");
			var couseq = document.getElementById("couseq");
			if (rbox[0].checked) {
				mileage.value = "";
				resultPrice.value = "";
				maxmile.checked = false;
				mileage.disabled = true;
				maxmile.disabled = true;
				couponuse.disabled = false;
			} else {
				resultPrice.value = "";
				couseq.value = "";
				mileage.disabled = false;
				maxmile.disabled = false;
				couponuse.disabled = true;

			}

		}

		function limitMileage() {
			var memberMile = $("#memberMileage");
			var mileage = $("#mileage");
			var memberMileInt = parseInt(memberMile.val());
			var mileageInt = parseInt(mileage.val());
			var price = document.getElementById("price");
			var priceInt = parseInt(price.textContent);
			alert(priceInt);
			if (mileageInt > memberMileInt) {
				alert("회원의 보유 마일리지 한도를 초과 하셨습니다.");
				mileage.val(memberMile.val());
			}
			var resultprice = document.getElementById("resultPrice");
			var resultpriceInt = priceInt - parseInt(mileage.val());
			resultprice.value = resultpriceInt.toString();

		}

		function maxMile() {
			var mileage = document.getElementById("mileage");
			var maxmile = document.getElementById("maxmile");
			var memberMileage = document.getElementById("memberMileage");
			var price = document.getElementById("price");
			var priceInt = parseInt(price.textContent);
			var resultprice = document.getElementById("resultPrice");
			if (maxmile.checked) {
				mileage.value = memberMileage.value;
				var resultpriceInt = priceInt - parseInt(mileage.value);
				resultprice.value = resultpriceInt.toString();
			} else {
				mileage.value = "";
				resultprice.value = "";
			}

		}

		function couponUse() {
			var price = document.getElementById("absolprice");
			var jumcnt = document.getElementById("count");
			var url = "./couponUse.do?price=" + price.value + "&jumcnt="
					+ jumcnt.value;
			var title = "쿠폰적용";
			var prop = "width=500px, height=500px";
			open(url, title, prop);
		}

		window.onload = function() {
			var mileage = document.getElementById("mileage");
			var couponuse = document.getElementById("couponuse");
			var maxmile = document.getElementById("maxmile");
			mileage.disabled = true;
			couponuse.disabled = true;
			maxmile.disabled = true;
		}

		function payment() {
			var couseq = $("#couseq");
			if (couseq.val() == "") {
				couseq.val("0");
			}
			var bsg = $("#bsg");
			if (bsg.val() == 'null') {
				alert("배송지를 입력해주세요");
			} else {
				$.ajax({
					url : "./insertjumon.do",
					data : $("#payment").serialize(),
					type : "post",
					async : true,
					success : function(map) {
						
						jQuery.ajax({
							url : "./mail.do",
							data : $("#payment").serialize(),
							type: "post",
							async: true,
							success: function (){
								
							},
							error: function (){
								
							}
						});
						
						var url = "./toss.do?orderNo=" + map.orderNo
								+ "&amount=" + map.amount + "&productDesc="
								+ map.productDesc;
						var title = "결제";
						var prop = "width=500px, height =500px";
						open(url, title, prop);
					},
					error : function() {
						alert("실패");
					}
				});
			}
		}

		function selectBSG() {
			var url = "./selectBSG.do";
			var title = "배송지";
			var prop = "width=600px, height=500px";
			open(url, title, prop);
		}
	</script>
	<!-- <div id="container" style="width: 90%; margin: auto;"> -->
		<!-- <div class="col-sm-10"> -->
			<%-- <h5>상품 코드 -${dto.sangcode}</h5>
			<h3>상품명 -${dto.sangpname}</h3>
			<h1>${dto.title}</h1>
			<h4>수량-${n}</h4>
			<h5>가격 -${dto.product_DTO.price}</h5> --%>
			<!-- 이자리에 썸네일 들어갈거야 -->
			<%-- ${dto.content} --%>
		<!-- </div> -->

<section class="wrapper">
    <article id="main">
        <img src="./image/watmude.jpg">
    </article><!-- class="main" end // 이 박스에 이미지 넣으면 됨 -->  
    <article id="sidenav-wrapper">
        <div class="sidenav">
            <form action="#" id="payment">
                <div>
                   <h5 id="sangcodetag" class="tag-name">
                      상품 코드 - <span id="sangcode">${dto.sangcode}</span>
                   </h5>
                   <h3 id="pricetag">
                      가격 - <span id="price">${dto.product_DTO.price}</span>
                   </h3>
                   <input type="hidden" id="absolprice"
                      value="${dto.product_DTO.price}"> <input type="hidden"
                      id="realsangcode" name="sangcode" value="${dto.sangcode}">
                   <h4>
                      수량 - <select id="count" name="jumcnt" onchange="change()">
                         <option value="1" selected="selected">1</option>
                         <option value="2">2</option>
                         <option value="3">3</option>
                         <option value="4">4</option>
                         <option value="5">5</option>
                      </select> 재고량 - <span id="cnt">${n}</span>
                   </h4>
                </div>
                <div>
                   <input type="radio" name="couOrMile" onclick="selOption()">쿠폰
                   <input type="radio" name="couOrMile" onclick="selOption()">마일리지<br>
                   <input type="button" class="form-control"class="form-control" id="couponuse" value="쿠폰 적용" onclick="couponUse()">
                   <input type="text" name="mileage" id="mileage" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');" onchange="limitMileage()">
                   <input type="hidden" id="memberMileage" value="${mileage}"> 
                   <input type="checkbox" id="maxmile" onclick="maxMile()">최대금액 적용<br>
                   결제금액 - <input type="text" name="paymoney" readonly="readonly"
                      id="resultPrice" value="0"> <input type="hidden"
                      id="couseq" name="couseq"> <input type="hidden"
                      name="paywhat" value="t"> <input type="hidden"
                      name="sangpgnum" value="${dto.sangpgnum}"> <br>
                      <input type="hidden" id="jummoney" name="jummoney" value="0"> 
                      <input type="hidden" name="bsgcode" id="bsg" value="null"> <br>
                      <input type="button" class="form-control" onclick="selectBSG()" value="배송지 설정하기"> <br>
                      <input type="button" class="form-control" id="onPayment" onclick="payment()" value="결제하기">
                </div>
             </form>
        </div> <!-- class="sidenav" end -->
    </article>
</section><!-- class="wrapper" end -->
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>