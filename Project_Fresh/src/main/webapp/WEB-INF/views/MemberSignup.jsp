<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fresh_회원가입_정보입력</title>
</head>
<body>	
	<%@include file="/WEB-INF/views/header.jsp"%>
	<div id="container" role="main">
		<input type="hidden" id="idCheckVal" value="false">
		<input type="hidden" id="pswdCheckVal" value="false">
		<input type="hidden" id="emailCheckVal" value="false">
		<input type="hidden" id="nameCheckVal" value="false">
        <form action="./memberAdd.do" method="post" onsubmit="return check()">
            <!-- tg-text=title -->
            <div class="join_content">
                <!-- 필수 정보 입력 -->
                <div class="row_group">
            		<!-- 아이디 -->    
                    <div class="join_row">
                        <h3 class="join_title"><label for="id">아이디 <img src="./image/star.gif" alt="필수" /></label></h3>
						<input type="text" id="id" name="id" required="required" maxlength="10">
						<span id="idResult"></span>
                    </div>
					<!-- 비밀번호 -->
                    <div class="join_row">
                        <h3 class="join_title">
                        	<label for="pswd1">비밀번호 <img src="./image/star.gif" alt="필수" />
							<span style="color: gray; font-size:11px; ">대·소문자, 숫자, 특수문자를 조합하여 8 ~ 15자리 이내여야 합니다.</span>
                        	</label></h3>
						<input type="password" id="pswd1" name="pswd1" required="required" maxlength="15">
						
                        <h3 class="join_title"><label for="pswd2">비밀번호 재확인 <img src="./image/star.gif" alt="필수" /></label></h3>
						<input type="password" id="pswd2" name="pswd2" required="required" maxlength="15">
						<span id="pswdResult"></span>
                    </div>
                    <!-- 이름 -->
                    <div class="join_row">
                        <h3 class="join_title"><label for="name">이름 <img src="./image/star.gif" alt="필수" /></label></h3>
						<input type="text" id="name" name="name" required="required" maxlength="10">
						<span id="nameResult"></span>
                    </div>
					<!-- 이메일 -->
                    <div class="join_row">
                        <h3 class="join_title"><label for="email">이메일 <img src="./image/star.gif" alt="필수" /></label></h3>
						<input type="text" id="email" name="email" required="required" maxlength="100">
						<span id="emailResult"></span>
                    </div>
	                <!-- 선택사항 - 휴대전화 번호 입력 -->
	                <div class="join_row" id="mobDiv">
	                    <h3 class="join_title"><label for="phone2">휴대전화
						<span style="color: gray; font-size:11px; ">(선택사항)</span>
	                    </label></h3>
						<select id="phone1" name="phone1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
						</select>
						-
						<input type="tel" id="phone2" name="phone2" maxlength="4" style="width: 60px; height: 20px;">
						-
						<input type="tel" id="phone3" name="phone3" maxlength="4" style="width: 60px; height: 20px;">
						<span id="phoneResult"></span>
	                </div>
               </div>

                <div id="button" style="margin-top: 10px;">
					<input type="submit" class="btn btn-success" value="회원가입">	
					<input type="button" class="btn btn-primary" value="돌아가기" onclick="cancleSignup()">	
				</div>
            </div>
        </form>
    </div>
    <%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>