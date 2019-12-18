<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jumunpageListScroll</title>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/sweetalert.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript">
function readURL(input) {
    if (input.files && input.files[0]) {
       var reader = new FileReader();
       reader.onload = function(e) {
          $("#image").attr("src", e.target.result).width(150).height(200);
       }
       reader.readAsDataURL(input.files[0]);
       $("#image").show();
    }
 }

</script>
<style type="text/css">

</style>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
	<div id="container" style="width: 90%; margin: auto;">
		<div class="col-sm-10">
		 <c:forEach var="dto" items="${lists}" varStatus="vs">
		    <h5>상품명 -${dto.sangpname}</h5>
			<h3>${dto.title}</h3>
			<p id="image">${dto.content}</p>
			<h5>가격 -${dto.product_DTO.price}</h5>
			</c:forEach>
		</div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>