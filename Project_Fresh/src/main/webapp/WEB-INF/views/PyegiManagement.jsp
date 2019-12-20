<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fresh_페기관리</title>
<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.20/themes/redmond/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/css/ui.jqgrid.css" />
<link type="text/css" rel="stylesheet" href ="./css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href ="./css/bootstrap-theme.min.css">
<style type="text/css">
	html, body { font-size: 75%; }
</style>
</head>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/js/i18n/grid.locale-kr.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.5/modules/jqmodal.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.5/modules/jqdnr.js"></script>
<script type="text/javascript" src="./js/PyegiManagement.js"></script>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
	<table id="pyegiList">
		<tr>
			<td></td>
		</tr>
	</table>
	<div id="pageOption"></div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>