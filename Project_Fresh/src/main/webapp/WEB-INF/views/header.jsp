<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- 화면 줄였을 때 스크린 넓이를 디바이스에 맞춤,원래 비율 사용 -->
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link type="text/css" rel="stylesheet" href ="./css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href ="./css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="./css/footer.css">
<style type="text/css">
#container{
	height: 580px;
	width: auto;
	text-align: center;
}
img {
	max-width: 100%;
	max-height: 100%;
}
a{
	color: black;
}
.dropdown-menu{
  box-shadow:0 0px 0px rgba(0, 0, 0, 0);
  width: 5px;
}
</style>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".dropdown-menu").hide();
});
</script>
	<header>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- heder 좌측 -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>                        
					</button>
					<a class="navbar-brand" href="./Main.do">
						<span><img src="./image/logo.png" id="png"></span>
					</a>
				</div>
				<!-- 좌측항목 -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-left">
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
							PRODUCT 
							</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="http://localhost:8099/Project_Fresh/jumunpageListScroll.do?sangcode=0">&nbsp;&nbsp;&nbsp;CATEGORY</a>
							</div>
						</li>
						<li class="nav-item dropdown"><a href="./noticeList.do">NOTICE</a></li>
						<li class="nav-item dropdown"><a href="./pagingTest.do">Q&A</a></li>
						<c:choose>
							<c:when test="${mem.gcode eq 'A'}">
								<li class="nav-item dropdown"><a href="./product.do">상품관리</a></li>
								<li class="nav-item dropdown"><a href="#">입고관리</a></li>
								<li class="nav-item dropdown"><a href="#">재고관리</a></li>
								<li class="nav-item dropdown"><a href="#">폐기관리</a></li>
<!-- 								<li class="nav-item dropdown"><a href="./memberManagement.do">회원관리</a></li> -->
								
								<li class="nav-item dropdown">
<!-- 									<a class="nav-link dropdown-toggle" href="./memberManagement.do" id="navbardrop" data-toggle="dropdown"> -->
									<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
									회원관리
									</a>
									<div class="dropdown-menu">
										<a class="dropdown-item" href="./allMemberList.do">&nbsp;&nbsp;&nbsp;전체 회원</a>
										<br>
										<a class="dropdown-item" href="./memberList.do">&nbsp;&nbsp;&nbsp;사용중 회원</a>
									</div>
								</li>
								
								<li class="nav-item dropdown"><a href="#">통계</a></li>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</ul>
					<!-- heder 우측 -->
					<ul class="nav navbar-nav navbar-right">
						 <!-- 세션여부확인 -->
						 <c:choose>
						 	<c:when test="${empty mem}">
						 		<li><a href="./loginPage.do"><span><img src="./image/Member.png" alt="member">LOG IN</span></a></li>
						 	</c:when>
						 	<c:otherwise>
						 		<li><span>${mem.name} 님</span></li>
								<!-- 관리자 사용자 구분해서 장바구니 출력 -->
								<c:choose>
									<c:when test="${mem.gcode eq 'A'}"></c:when>
									<c:otherwise>
										<li><a href="#"><span><img src="./image/Cart.png" alt="cart"> CART</span></a></li>
										<li><a href="./myPage.do"><span><img src="./image/MemberEdit.png" alt="My_page"> MyPage</span></a></li>
									</c:otherwise>
								</c:choose>
						 		<li><a href="./logout.do"><span><img src="./image/Member.png" alt="member">LOG OUT</span></a></li>
						 	</c:otherwise>
						 </c:choose>
					</ul>
				</div>
			</div>
		</nav>
	</header>