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
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/IpgoManagement.js"></script>
<script type="text/javascript" src="./js/JaegoManagement.js"></script>
<script type="text/javascript" src="./js/PyegiManagement.js"></script>
<script type="text/javascript">
$(document).ready(function(){
//  $(".dropdown-toggle").dropdown("toggle");
	$(".dropdown-menu").hide();
});
</script>
	<header>
		<nav class="navbar navbar-default navbar-expand-sm">
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
						<span>
							<img src="./image/logo.png" id="png">
						</span>
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
						<li class="nav-item dropdown"><a href="#">NOTICE</a></li>
						<li class="nav-item dropdown"><a href="#">Q&A</a></li>
						<li class="nav-item dropdown"><a href="#">FAQ</a></li>
					</ul>
					<!-- heder 우측 -->
					<ul class="nav navbar-nav navbar-right">
						<li id="navSignUp">
							<a href="./loginPage.do">
								<span><img src="./image/Member.png" alt="member"> LOGIN</span>
							</a>
						</li>
						<li id="navSignUp">
							<a href="#">
								<span>
									<img src="./image/Cart.png" alt="cart"> CART
								</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</header>