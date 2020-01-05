<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 검색</title>
<script type="text/javascript" src="./js/sweetalert.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
${dto.sangpgnum}
${dto.sangcode}
${dto.sangpname}
${dto.title}
${dto.content}
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>