<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입고 관리 페이지</title>

<style type="text/css">
	html, body { font-size: 75%; }
</style>
<script type="text/javascript">
	$.jgrid.no_legacy_api = true;
	$.jgrid.useJSON = true;

$(document).ready(function() {
	$("#ipgoList").jqGrid({ 
		url : "./ipgoJSON.do",
		datatype: "json", // 데이터 타입
		mtype: "POST", // 데이터 전송방식
		caption: "입고관리", // 그리드의 제목
		loadtext: "잠시만 기다려주세요~♡", // 로딩메시지
		loadError: function() {alert("Error");}, // 로딩에러 메시지
		
		colNames : ['입고번호', '재고코드', '입고일자', '입고수량', '유통기한'],
		
		colModel: [
			{name : 'ipgonum', index:'ipgonum', width : 80, editable: true, sortable:false},	
			{name : 'jaegocode', index:'jaegocode', editable: true, sortable:false},
			{name : 'ipgodate', index:'ipgodate', align : "right", editable: false, sortable:false},
			{name : 'ipgocnt', index:'ipgocnt', align : "right", editable: true, sortable:false, formatter: "integer"},
			{name : 'expdate', index:'expdate', align : "center", editable: false, sortable:false},
		],
		
		jsonReader: { // json형태의 data읽기위해 필요
			root : "allIpgoList",
			page: "currpage",
			total: "totalpages",
			records: "totalrecords",
			repeatitems: false, // json data의 요소를 name으로 검색할 수 있다.
		}, 
		
		// 페이징 or 스크롤 관련
		loadonce: false, // true이면 데이터를 1번만 받고 새로 안받음, false 리플레쉬는 되나, 페이징이 안먹음
		pager: "#pageOption", // 페이징, 전체글수, 추가, 수정, 검색, 새고고침 버튼 있는 곳 활성화 여부
		rowNum : 1000, // 한번에 뿌려질 데이터의 개수 
		//가로길이
		viewrecords: true, // 전체 페이지와 보여지고 있는 레코드 수를 보여준다.
		emptyrecords: "데이터가 존재하지 않습니다.", // 데이터가 없을때 보여줄 문자열  
		
		// 부가옵션
		rownumbers : true, // row number 활성화 여부 좌측 행번호
		gridview: true, // 성능향상
		formatter: {
			integer: {thousandsSeparator: ",", defaultValue: "0"} 
		},

	}).jqGrid('navGrid', '#pageOption',
					{
						edit : true, // 수정
						add : true, // 추가
						del : false, // 삭제 비활성화
						search : false, // 검색
						refresh : true, // body 새로고침
					},
					
// 					// 수정
// 					{
// 						url: "./productEdit.do",
// 						editCaption: "상품 수정", // 수정form title
// 						bSubmit: "수정", // submit 버튼 이름 변경
// 						bCancel: "취소", // cancel 버튼 이름 변경
// 						bClose: "Close",
						
// 						recreateForm: true,
// 						savekey: [true, 13], // form에서 13(Enter) 확인 버튼작동시키기
// 						reloadAfterSubmit: true, // 서버 Ajax 후 그리드 데이터 다시 로드
// 						closeAfterEdit: true, // submit 후 form닫기
// 						closeOnEscape: true // ESC키를 이용해 모달창을 닫을 수 있다.
// 					},
					
					// 추가
					{
						url: "./ipgoAdd.do",
						addCaption: "입고 등록", // 등록form title
						bSubmit: "등록", // submit 버튼 이름 변경
						bCancel: "취소", // cancel 버튼 이름 변경
						bClose: "Close",
						
						recreateForm: true, //true 설정 시 colModel의 새옵션으로 대화상자가 활성화 될때마다 form이 다시 생성된다.
						savekey: [true, 13], // form에서 13(Enter) 확인 버튼작동시키기
						reloadAfterSubmit: true, // 서버 Ajax 후 그리드 데이터 다시 로드
						closeAfterAdd: true, // submit 후 form닫기
						closeOnEscape: true // ESC키를 이용해 모달창을 닫을 수 있다.
					}
			
		) // jqGrid
});
</script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
    
	<table id="ipgoList"></table>
	<div id="pageOption"></div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>