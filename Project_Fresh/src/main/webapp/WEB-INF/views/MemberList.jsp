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
	function mileageAdd(id){
// 		alert(id); // 각 회원의 아이디 잘가져옴
		// 회원 아이디로 회원검색
		// 해당 회원의 마일리지 확인
		// OPENER에 띄우기
		var url = "./mileageAdd.do?id="+id;
		var title = "관리자 마일리지 적립";
		var prop = "width=300px, height=200px";
		open(url, title, prop);		
	}
</script>
<body>

	<%@include file="/WEB-INF/views/header.jsp"%>
	
	<p style="color: darkgray; text-align: right; margin-right: 35px">회원관리 > 사용중 회원 조회</p>
	<div id="container">
		<h1>사용중 회원 조회</h1>
		<table class="table table-boardered"> <!-- 해당 class로 bootstrap 설정됨 -->
			<thead>
				<tr>
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
			<tbody id="userList">
  				<c:forEach var="dto" items="${MemberLists}">
					<tr>
						<td>
							<button id="mileageBtn" class="btn btn-primary btn-center btn-sm" onclick="mileageAdd('${dto.id}')">마일리지 적립</button>
						</td>
						<td><c:out value="${dto.id}"/></td>
						<td><c:out value="${dto.name}"/></td>
						<td><c:out value="${dto.gcode}"/></td>
						<td><c:out value="${dto.email}"/></td>
						<td><c:out value="${dto.phone}"/></td>
						<td class="userMileage"><c:out value="${dto.mileage}"/></td>
						<td><c:out value="${dto.hiredate}"/></td>
					</tr>
  				</c:forEach>
			</tbody>
			<tfoot>
				<!-- 페이징 넣을 부분 -->
			</tfoot>
		</table>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>
