<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/sweetalert.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
<link type="text/css" rel="stylesheet" href="./css/sweetalert.css">
</head>
<body>
<script type="text/javascript">
	 function cancle() {
		
		$.ajax({
			url : "./cancle.do",
			data : "jumunnum="+$("#cancleOrder").val(),
			type : "post",
			async: true,
			success: function(s){
				swal("작동시험"+s);
			},
			error: function(){
				swal("비작동");
			}
		});
		
		
	} 
	
	function seeker(){
		$.ajax({
			url : "./selectJumun.do",
			type : 'post',
			data : "id="+$("#id").val(),
			async: true,
			success: function(val){
				$("#spansel").html(val);
			},
			error : function(){
				alert("실패");
			}
		});
	}
	
	function updatePay(){
		
		var si = document.getElementById("jumunnum").value;
		$.ajax({
			url : "./updatePayment.do",
			type: "post",
			data : "jumunnum=" + $("#jumunnum").val(),
			async: false,
			success: function(map){
				if(map == "true"){
					swal("성공!");
				}else{
					swal("실패!");
				}
			},
			error: function(){
				swal("실패");
			}
		});
	}
	
	function toss(){
		
		$.ajax({
			url : "./insertjumon.do",
			type: "post",
			data : $("#toss").serialize(),
			async: true,
			success: function(map){
				var url = "./toss.do?orderNo="+map.orderNo+"&amount="+map.amount+"&productDesc="+map.productDesc;
				var title = "결제";
				var prop = "width=500px, height =500px";
				open(url,title,prop);
			},
			error: function(){
				swal("실패");
			}
		});
	}
/* 	function toss(){
		
		$.ajax({
			url : "./toss.do",
			type: "post",
			data : $("#toss").serialize(),
			async: true,
			success: function(map){
				var url = "./toss.do?orderNo="+map.orderNo+"&amount="+map.amount+"&productDesc="+map.productDesc;
				var title = "결제";
				var prop = "width=500px, height =500px";
				open(url,title,prop);
			},
			error: function(){
				swal("실패");
			}
		});
	} */
	
	function mail(){
		
		$.ajax({
			url : "./mail.do",
			type: "post",
			data: "content="+$("#content").val(),
			async: false,
			success: function(s){
				alert(s);
			},
			error : function(){
				alert("메일 발송 실패");
			}
		});
		
	}
	
	function sendPw(){
		$.ajax({
			url : "./sendResetMail.do",
			data : $("#sendmail").serialize(),
			type: "post",
			success: function(x){
				alert("메일발송 성공?"+x);
			},
			error : function(){
				alert("실패");
			}
		});
	}
	
</script>
<div>
	<form action="#" id="frm">
		<input type="text" value="주문 취소"  id="cancleOrder" onclick="cancle(this.val)">
	</form>
</div><hr>
<form action="#" id="toss">
<input type="hidden" name="paymoney" value="10000">
<input type="hidden" name="couseq" value="1">
<input type="hidden" name="paywhat" value="t">
<input type="text" name="id" placeholder="id 입력하여라"><br>
<input type="text" name="sangpgnum" placeholder="sangpgnum 입력하여라"><br>
<input type="text" name="bsgcode" placeholder="bsgcode 입력하여라"><br>
<input type="text" name="jummoney" placeholder="jummoney 입력하여라"><br>
<input type="text" name="jumcnt" placeholder="jumcnt 입력하여라"><br>
<button onclick="toss()">입력 부터 결제까지</button>
</form>
${lists} ${count}
<hr>
<form action="#" id="frm2">
<input type="text" id="id" name="id" onclick="seeker()"><span id="spansel"></span>
</form>
<Hr>
<a href="./deleteJumun.do?jumunnum=takemehome">삭제하기/수동/자동주문확정하기</a>
<hr>
<form action="#" id="updatefrm">
<input type="text" id="jumunnum" name="jumunnum"><span id="spanupdate"><button onclick="updatePay()">집에가고 싶구나!</button></span>
</form>
<hr>
<!-- <form action="#" id="toss">
<input type="text" id="jumunnum" name="jumunnum">
<input type="text" id="sangpgnum" name="sangpgnum">
<input type="text" id="jummoney" name="jummoney">
<button onclick="toss()">결제</button>
</form> -->

<form action="#" id="mail">
<input type="text" name="cotent" id="content">
<button onclick="mail()">메일</button>
</form>

<form action="#" id="sendmail">
<input type="text" name="id">
<input type="button" onclick="sendPw()" value="비밀번호찾기인증번호 전송">
</form>

</body>
</html>