<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 화면 줄였을 때 스크린 넓이를 디바이스에 맞춤,원래 비율 사용 -->
<meta name='viewport' content='width=device-width, initial-scale=1'>
<meta charset="UTF-8">
<title>헤더</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/sweetalert.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href ="./css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href ="./css/bootstrap-theme.min.css">
</head>
<script type="text/javascript">
$(document).ready(function(){
  $(".dropdown-toggle").dropdown("toggle");
});
</script>
<style type="text/css">
a{
	color: black;
}
.dropdown-menu{
  box-shadow:0 0px 0px rgba(0, 0, 0, 0);
  width: 5px;
}
</style>
<body>
	<nav class="navbar navbar-default navbar-expand-sm">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" 
				data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img src="./image/logo.png" width="auto" height="42px" id="png"></a>
				</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
						<li class="nav-item dropdown">
					      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
					        PRODUCT
					      </a>
					      <div class="dropdown-menu">
					        <a class="dropdown-item" href="#">&nbsp;&nbsp;&nbsp;CATEGORY</a>
						      </div>
					    </li>
						<li class="nav-item dropdown"><a href="#">NOTICE</a></li>
						<li class="nav-item dropdown"><a href="#">Q&A</a></li>
						<li class="nav-item dropdown"><a href="#">FAQ</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li id="navSignUp"><a href="#">LOGIN</a></li>
					<li id="navSignUp"><a href="#">CART</a></li>
				</ul>
				
			</div>
		</div>
		
	</nav>
</body>
</html>