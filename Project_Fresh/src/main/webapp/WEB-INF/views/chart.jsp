<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통계 조회</title>
</head>
<%@include file="/WEB-INF/views/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">



	function chartSubmit() {
// 		return false;
		if ($("div").length > 0) {
			var preDiv = document.getElementById("top_x_div");
			var preDiv2 = document.getElementsByTagName("div"); 
			document.body.removeChild(preDiv);	
			document.body.removeChild(preDiv2[0]);
		}
		var selectCheck = document.getElementById("selPOrA");
		var sangList = document.getElementById("sangNameList");
		if (selectCheck.options[selectCheck.selectedIndex].value == "product") {
			if (sangList.options[sangList.selectedIndex].value == "NoneSN") {
				alert("상품 이름을 선택하여 주십시오");
				return false;
			}
		}
		sangList.disabled = false;
		var newDiv = document.createElement("div");
		document.body.appendChild(newDiv);
		newDiv.setAttribute("id", 'top_x_div');
		googleChartAjax();
		
	}

	function googleChartAjax(){
		alert("작동");
		$.ajax({
			url:"./chart.do",
			type:"post",
			data:$("#chart").serialize(),
			async:true,
			success: function(msg) {
				var array = msg.split("|");
				var array2 = array[0].split(",");
// 				for (var i = 0; i < array2.length; i++) {
// 					alert(array2[i]);
// 				}
				google.charts.load('current', {'packages':['bar']});
			      google.charts.setOnLoadCallback(drawStuff);

			      function drawStuff() {
			        var data = new google.visualization.DataTable();
			        data.addColumn('string', array2[0]);
			        data.addColumn('number', array2[1]);
			        
					data.addRows(array.length-1);
			        for (var i = 0; i < array.length-1; i++) {
			        	var jala = array[i+1].split(",");
						data.setCell(i, 0, jala[0]);
						data.setCell(i, 1, parseInt(jala[1]));
// 						alert(i);
					}

			        var options = {
			          width: 400,
			          height: 300,
			          legend: { position: 'none' },
			          chart: {
			            title: '통계 차트',
			          },
			          bar: { groupWidth: "5%" }
			        };

			        var chart = new google.charts.Bar(document.getElementById('top_x_div'));
			        chart.draw(data, google.charts.Bar.convertOptions(options));
			      };
				var selectCheck = document.getElementById("selPOrA");
				var sangList = document.getElementById("sangNameList");
				if(selectCheck.options[selectCheck.selectedIndex].value == "all"){
					sangList.disabled = true;
				}
			},
			error: function() {
				alert("젠장할");
			}
		});
	}
	
	function stopClicking() {
		var selectCheck = document.getElementById("selPOrA");
		var sangList = document.getElementById("sangNameList");
		if(selectCheck.options[selectCheck.selectedIndex].value =="product"){
			sangList.disabled = false;
		}else{
			$("#sangNameList option:eq(0)").prop("selected", true);
			sangList.disabled = true;
		}
	}
	
	window.onload = function() {
		var selectCheck = document.getElementById("selPOrA");
		var sangList = document.getElementById("sangNameList");
// 		alert(selectCheck.options[selectCheck.selectedIndex].value);
		if(selectCheck.options[selectCheck.selectedIndex].value == "all"){
			sangList.disabled = true;
		}
	}
</script>

<body>
<!--  	<div id="top_x_div" style="width: 900px; height: 300px;"></div> -->
	<form action="#" id="chart" method="post">
		<select name="options" id="options">
			<option value="saleCnt">판매량</option>
			<option value="saleMoney">판매금액</option>
			<option value="pyegiCnt">폐기량</option>
			<option value="pyegiMoney">폐기금액</option>
		</select>
		<select name="selPOrA" id="selPOrA" onchange="stopClicking()">
			<option value="all">총</option>
			<option value="product">제품별</option>
		</select>
		<select name="sangNameList" id="sangNameList">
			<option value="NoneSN">----</option>
			<c:forEach var="dto" items="${lists}">
				<option value="${dto.sangname}">${dto.sangname}</option>
			</c:forEach>
		</select>
		<select name="date" id="date">
			<option value="year">----</option>
			<c:forEach var="num" items="${year}">
				<option value="${num}">${num}</option>
			</c:forEach>
		</select>
	</form>
		<input type="button" value="차트보기" onclick="chartSubmit()">
</body>
</html>