<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberPage</title>
</head>
<body>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<%@include file="/WEB-INF/views/header.jsp"%>
<div>
 <label>아이디</label> <br>
	${dto.id} <br>
 <label>누적 결제 금액</label> <br>
	${dto.payhistory_DTO.paymoney} 원 <br>
 <label>등급</label> <br>
	${dto.grade} <br><br><br>
 <a href="http://localhost:8099/Project_Fresh/memberJumunList.do?id=${dto.id}">주문목록</a>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>