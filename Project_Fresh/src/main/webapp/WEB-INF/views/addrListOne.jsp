<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송지 상세조회</title>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/sweetalert.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<form>
    <div class="col-sm-6">
      <label>아이디</label> 
      <input type="text" class="form-control" value="${aDto.id}" readonly="readonly">
      <label>배송지 이름</label> 
      <input type="text" class="form-control" value="${aDto.bsgname}">
      <label>주소</label> 
      <input type="text" class="form-control" value="${aDto.juso}">
      <label>핸드폰 번호</label> 
      <input type="text" class="form-control" value="${aDto.phone}">
    </div>
  </form>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>