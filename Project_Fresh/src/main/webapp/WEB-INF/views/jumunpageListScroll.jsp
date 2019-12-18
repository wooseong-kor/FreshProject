<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jumunpageListScroll</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/sweetalert.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript">
</script>
<style type="text/css">
.vertical-menu {
  width: 150px;
  position: absolute;
  left: 30px;
}

.vertical-menu a {
  background-color: #eee;
  color: black;
  display: block;
  padding: 12px;
  text-decoration: none;
}

.vertical-menu a:hover {
  background-color: #ccc;
}

.vertical-menu a.active {
  background-color: #10620A;
  color: white;
}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
	<div id="container" style="width: 90%; margin: auto;">
		<div class="vertical-menu">
			<a href="http://localhost:8099/Project_Fresh/jumunpageListScroll.do?sangcode=0" class="active">Category</a>
			<a href="http://localhost:8099/Project_Fresh/jumunpageListScroll.do?sangcode=AP">Apple</a>
			<a href="http://localhost:8099/Project_Fresh/jumunpageListScroll.do?sangcode=DU">Durian</a>
			<a href="http://localhost:8099/Project_Fresh/jumunpageListScroll.do?sangcode=WA">Watermelon</a>
			<a href="http://localhost:8099/Project_Fresh/jumunpageListScroll.do?sangcode=TO">Tomato</a>
		</div>	
		<div style="margin-left:14%">
		<div class="col-sm-10">
		<table>
		 <c:forEach var="dto" items="${lists}" varStatus="vs">
			<h5>상품명 -${dto.sangpname}</h5>
			<h3>${dto.title}</h3>
			<p id="image">${dto.productImg_DTO.imgpath}</p>
			<h5>가격 -${dto.product_DTO.price}</h5>
			</c:forEach>
		</table>	
		</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>