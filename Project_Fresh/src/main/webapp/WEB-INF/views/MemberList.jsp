<%@page import="com.min.fresh.dto.Member_DTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원전체조회</title>
<style type="text/css">
	th, td {
		text-align: left;
	}
	input {
		align-content: left;
	}
</style>
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript">
	// 전체 체크
	function checkAll(bool) {
// 		alert(bool);
		var chk = document.getElementsByName("chkVal");
// 		alert(chk.length);
		for (var i = 0; i < chk.length; i++) {
			chk[i].checked = bool;
		}
	}
	
	function mileageAdd(){
		var chkId = document.getElementById("chkVal");
		alert(chkId.value);
	}
</script>
<body>

	<%@include file="/WEB-INF/views/header.jsp"%>
	
	<p style="color: darkgray; text-align: right; margin-right: 35px">회원관리 > 사용중 회원 조회</p>
	<input type="button" class="btn btn-primary" value="마일리지 적립" onclick="mileageAdd()" style="text-align: left; margin-left: 10px;">
	<div id="container">
		<h1>사용중 회원 조회</h1>
		<table class="table table-boardered"> <!-- 해당 class로 bootstrap 설정됨 -->
			<thead>
				<tr>
<!-- 					<th><input type="checkbox" onclick="checkAll(this.checked)"></th> -->
					<th></th>
					<th>ID</th>
					<th>NAME</th>
					<th>GRADE</th>
					<th>E-MAIL</th>
					<th>PHONE</th>
					<th>MILEAGE</th>
					<th>HIREDATE</th>
				</tr>
			</thead>
			<tbody>
  				<c:forEach var="dto" items="${MemberLists}">
					<tr>
						<td><input type="checkbox" id="chkVal" name="chkVal" value="${dto.id}"></td>
						<td><c:out value="${dto.id}"/></td>
						<td><c:out value="${dto.name}"/></td>
						<td><c:out value="${dto.gcode}"/></td>
						<td><c:out value="${dto.email}"/></td>
						<td><c:out value="${dto.phone}"/></td>
						<td><c:out value="${dto.mileage}"/></td>
						<td><c:out value="${dto.hiredate}"/></td>
					</tr>
  				</c:forEach>
			</tbody>
			<tfoot>
				
			</tfoot>
		</table>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>