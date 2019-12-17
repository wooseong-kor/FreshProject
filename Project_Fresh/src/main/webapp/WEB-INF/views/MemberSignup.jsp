<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입_이용약관</title>
</head>
<body>

<table border="1" summary="">
	<tbody>
	<!-- 아이디 -->
		<tr>
			<th scope="row">
				아이디
				<img src="./image/star.gif" alt="필수" />
			</th>
			<td>
				<input id="member_id" name="member_id" fw-filter="isFill&amp;isFill&amp;isMin[4]&amp;isMax[16]&amp;isIdentity" 
					fw-label="아이디" fw-msg="" class="inputTypeText" placeholder="" value="" type="text">
				<a href="#none" title="새창 열기" onclick="checkIdLayer('/member/check_id.html')" class="-btn -white">
					<i class="fa fa-check"></i> &nbsp; 아이디 중복확인
				</a> (영문소문자/숫자, 4~16자)
			</td>
		</tr>
	<!-- 비밀번호 -->
		<tr>
			<th scope="row">
				비밀번호
				<img src="./image/star.gif" alt="필수" />
			</th>
			
			<td>
				<input id="passwd" name="passwd" fw-filter="isFill&amp;isMin[4]&amp;isMax[16]" 
					fw-label="비밀번호" fw-msg="" autocomplete="off" maxlength="16" 0="disabled" value="" type="password" />
				(영문 대소문자/숫자 4자~16자)
			</td>
		</tr>
	<!-- 비밀번호 확인 -->
		<tr>
			<th scope="row">
				비밀번호 확인 
				<img src="./image/star.gif" alt="필수" />
			</th>
			<td>
				<input id="user_passwd_confirm" name="user_passwd_confirm" fw-filter="isFill&amp;isMatch[passwd]" 
					fw-label="비밀번호 확인" fw-msg="비밀번호가 일치하지 않습니다." autocomplete="off" maxlength="16" 0="disabled" value="" type="password" />
				<span id="pwConfirmMsg"></span> 
			</td>
		</tr>
	<!-- 이름 -->
		<tr>
			<th scope="row" id="nameTitle">
				이름 
				<img src="./image/star.gif" alt="필수" />
			</th>
			<td>
				<span id="nameContents">
					<input type="text" name="name" id="name" maxlength="20">
				</span>
			</td>
		</tr>
	<!-- 연락처 -->
		<tr class="">
			<th scope="row">
				휴대전화
				<img src="./image/star.gif" alt="필수" />
			</th>
			<td>
				<select id="mobile1" name="mobile[]" fw-filter="isNumber" fw-label="휴대전화" fw-alone="N" fw-msg="">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select>
				-
				<input id="mobile2" name="mobile[]" maxlength="4" fw-filter="isNumber" fw-label="휴대전화" fw-alone="N" fw-msg="" value="" type="text">
				-
				<input id="mobile3" name="mobile[]" maxlength="4" fw-filter="isNumber" fw-label="휴대전화" fw-alone="N" fw-msg="" value="" type="text"></td>
		</tr>
	<!-- 이메일 -->
		<tr>
			<th scope="row">
				이메일 
				<img src="./image/star.gif" alt="필수" />
			</th>
			<td>
				<input id="email1" name="email1" fw-filter="isFill&amp;isEmail" 
					fw-label="이메일" fw-alone="N" fw-msg="" value="" type="text"> 
				<span id="emailMsg"></span>
			</td>
		</tr>
	<!-- 연락처 & 이메일 수신여부 -->
		<tr class="">
			<th scope="row">
				연락처 & 이메일<br>수신여부 
				<img src="./image/star.gif" alt="필수" />
			</th>
			<td>
				<label for="is_news_mail0">
				<input id="is_news_mail0" name="is_news_mail" fw-label="is_news_mail" fw-msg="" class="ec-base-chk" value="T" type="checkbox">동의함</label>
				<p>쇼핑몰에서 제공하는 유익한 이벤트 소식을 이메일로 받으실 수 있습니다.</p>
				<p>주문정보, 아이디 & 비밀번호 찾기 등에 사용됩니다.</p>
			</td>
		</tr>
	</tbody>
</table>

</body>
</html>