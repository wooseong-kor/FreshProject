<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 마일리지</title>
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript">
	function add(){
		var mileage = document.getElementById("mileage").value;
		var addMileage = document.getElementById("addMileage").value;
		var totalMileage = parseInt(mileage) + parseInt(addMileage);  // 기존 마일리지 + 입력한 마일리지
		$.ajax({
			type:"post",
			url:"./mileageAddOK.do",
			data:"id="+id+"&mileage="+totalMileage,
			async: true,
			success: function(msg) {
				var bun = 0;
				for (var i = 0; i < msg.allDto.length; i++) {
					if (msg.allDto[i].id == msg.id) {
						bun = i;
					}
				}
				opener.document.getElementsByClassName("userMileage")[bun].innerHTML = totalMileage;
				self.close();
			},
			error: function(){
				alert("실패다...ㅠㅠ");
			}
		});
	}
	
	function cancle() {
		self.close();
	}
</script>
<body>
	<div id="container">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" id="id" value="${id}" readonly="readonly">
				</td>
			</tr>
			
			<tr>
				<th>이름</th>
				<td>
					<input type="text" id="name" value="${name}" readonly="readonly">
				</td>
			</tr>
			
			<tr>
				<th>마일리지</th>
				<td>
					<input type="text" id="mileage" value="${mileage}" readonly="readonly">
				</td>
			</tr>
			
			<tr>
				<th>추가 마일리지</th>
				<td>
					<input type="number" id="addMileage">
				</td>
			</tr>
		</table>
		<div id="bnt">
			<input type="button" class="btn btn-success" value="적립" onclick="add()">
			<input type="button" class="btn btn-danger" value="취소" onclick="cancle()">
		</div>
	</div>
</body>
</html>