<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송지 선택</title>
</head>
<script type="text/javascript">
function mulChkDont(chk) {
	var obj = document.getElementsByName("check");
	for (var i = 0; i < obj.length; i++) {
		if(obj[i] != chk) {
			obj[i].checked = false;
		}
	}
}
</script>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>BSGCODE</th>
			<th>BSGNAME</th>
			<th>JUSO</th>
			<th>PHONE</th>
		</tr>
		<c:forEach items="${lists}" var="dto">
		<tr>
			<td>${dto.id}</td>
			<td>${dto.bsgcode}</td>
			<td>${dto.bsgname}</td>
			<td>${dto.juso}</td>
			<td>${dto.phone}</td>
			<td><input type="checkbox" name="check" onclick="mulChkDont(this)"></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>