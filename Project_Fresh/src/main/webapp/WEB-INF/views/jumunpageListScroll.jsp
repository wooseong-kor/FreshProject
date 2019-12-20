<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jumunpageListScroll</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="./js/sweetalert.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript">
</script>
<style type="text/css">
.vertical-menu {
  width: 170px;
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
		
		 <c:forEach var="dto" items="${lists}" varStatus="vs">
		<div class="col-sm-10" onclick="jumunDeep(${dto.sangpgnum})">
		 	<div class="image" style="display: inline; float: left;">
			<p>${dto.productImg_DTO.imgpath}</p>
			</div>
			<div class="content" style="display: inline; float: left; margin-top: 8px; margin-left: 30px; ">
			<h3>${dto.title}</h3>
			<h4>가격 -${dto.product_DTO.price}</h4>
			<p>상품명 -${dto.sangpname}</p>
			<p>배송비-2500원</p>
			</div>
			</div>
			</c:forEach>
		</div>
	</div>
	<script type="text/javascript">
	function jumunDeep(val) {
		location.href="./jumunpageDeepOne.do?sangpgnum="+val;
	}
	</script>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>