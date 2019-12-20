<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fresh_비밀번호_재설정</title>
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/DormantAccount.js"></script>
<body>	
	<%@include file="/WEB-INF/views/header.jsp"%>
	<div id="container">
		"${mem.name}" 님 오랜만에 방문하셨네요^^<br>
		고객님의 계정은 장기간(6개월 이상) 서비스 이용 중단으로<br>
		휴면계정으로 전환되어 별도 보관되어 있습니다.<br>
		<br>
		비밀번호 재설정 후 고객님의 계정을 활성화 시킬 수 있습니다.<br>
		<form action="./loginPage.do" method="post" onsubmit="check()">
			<input type="hidden" id="pswdCheckVal" value="false">
			<input type="hidden" id="id" name="id" value="${mem.id}">
			<input type="hidden" id="delflag" name="delflag" value="${mem.delflag}">
			<!-- 비밀번호 -->
			<div class="join_row">
			    <h3 class="join_title">
			    	<label for="pswd1">비밀번호 <img src="./image/star.gif" alt="필수" />
					<span style="color: gray; font-size:11px; ">대·소문자, 숫자, 특수문자를 조합하여 8 ~ 15자리 이내여야 합니다.</span>
			    	</label>
			    	<br>
					<input type="password" id="password" name="password" required="required" maxlength="15">
					<span id="pswdResult" style="font-size: 13px"></span>
			    </h3>
			</div>
			<input type="button" value="취소">
			<input type="submit" value="확인">
		</form>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>