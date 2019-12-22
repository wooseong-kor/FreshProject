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
</style>
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<body>

	<%@include file="/WEB-INF/views/header.jsp"%>
	
	<p style="color: darkgray; text-align: right; margin-right: 35px">회원관리 > 전체 회원 조회</p>
	<div id="container">
		<h1>전체 회원 조회</h1>
		<table class="table table-boardered"> <!-- 해당 class로 bootstrap 설정됨 -->
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>GRADE</th>
					<th>E-MAIL</th>
					<th>PHONE</th>
					<th>AGREE</th>
					<th>DELFLAG</th>
					<th>MILEAGE</th>
					<th>SNS</th>
					<th>Last Login</th>
					<th>Last PW Change</th>
					<th>HIREDATE</th>
				</tr>
			</thead>
			<tbody>
  				<c:forEach var="dto" items="${AllMemberLists}">
					<tr>
						<td><c:out value="${dto.id}"/></td>
						<td><c:out value="${dto.name}"/></td>
						<td><c:out value="${dto.gcode}"/></td>
						<td><c:out value="${dto.email}"/></td>
						<td><c:out value="${dto.phone}"/></td>
						<td><c:out value="${dto.agree}"/></td>
						<td><c:out value="${dto.delflag}"/></td>
						<td><c:out value="${dto.mileage}"/></td>
						<c:choose>
							<c:when test="${empty dto.sns}">
								<td>H</td>
							</c:when>
							<c:otherwise>
								<td><c:out value="${dto.sns}"/></td>
							</c:otherwise>
						</c:choose>
						<td><c:out value="${dto.llogin}"/></td>
						<td><c:out value="${dto.lpwchange}"/></td>
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