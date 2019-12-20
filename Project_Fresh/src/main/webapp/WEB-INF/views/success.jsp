<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function success() {
	opener.location.href="./main.do";
	self.close();
}
</script>
<body>
<h1>주문 결제가 정상적으로 처리되었습니다.</h1>
<h3 onclick="success()">처음화면으로 돌아가기</h3>
</body>
</html>