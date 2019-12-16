<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리 페이지</title>
<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.20/themes/redmond/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/css/ui.jqgrid.css" />
<style type="text/css">
	html, body { font-size: 75%; }
</style>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/js/i18n/grid.locale-en.js"></script>
<script type="text/javascript">
	$.jgrid.no_legacy_api = true;
	$.jgrid.useJSON = true;
</script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.5/modules/jqmodal.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.5/modules/jqdnr.js"></script>

<!-- Controller에서 JSON 받아오기 & jqGrid 만들기 -->
<script type="text/javascript">
	onload = function(){
		$.ajax({
			url : "./productJSON.do",
			type : "POST",
			async: true, // 동기식, 전역변수에 Controller에서 넘어온 값을 사용하기 위해서
			dataType: "json",
			success: function(msg) { grid(); },
			error : function() { alert("데이터를 처리하지 못했습니다."); }
		});
	}
	
	function grid() {
		$("#productList").jqGrid({
			url : "./productJSON.do",
			datatype: "json", // 데이터 타입
			caption: "상품관리", // 그리드의 제목
			mtype: "POST", // 데이터 전송방식
			loadtext: "잠시만 기다려주세요~♡", // 로딩메시지
			loadError: function() {alert("Error");}, // 로딩에러 메시지
			
			colNames : ['상품코드', '상품이름', '판매가', '상품상태'],
			
			colModel: [
				{name : 'sangcode', index : 'sangcode', width : 100, editable: true},	
				{name : 'sangname', index : 'sangname', editable: true},
				{name : 'price', index : 'price', width : 70, align : "right", editable: true, formatter: "integer"},
				{name : 'sangstat', index : 'sangstat', width : 50, align : "center", editable: true, formatter: 'select', edittype:"select", 
					editoptions:{value: "Y:판매중;S:품절;D:단종"}, stype: 'select'},
			],
			
			jsonReader: { // json형태의 data읽기위해 필요
				root : "productJaegoList",
				page: "currpage",
				total: "totalpages",
				records: "totalrecords",
				repeatitems: false, // json data의 요소를 name으로 검색할 수 있다.
			}, 
			
			loadonce: true, // 데이터 전체를 한번에 로딩
			pager: "#pageOption", // 페이징 사용 위치
			rowNum : 10, // 한번에 뿌려질 데이터의 개수 
			rowList : [ 10, 15, 20, 25, 30 ], // 뿌려질 데이터 개수 선택
			viewrecords: true, // 전체 페이지와 보여지고 있는 레코드 수를 보여준다.
			rownumbers : true, // row number 활성화 여부 좌측 행번호
			gridview: true, // 성능향상
			height: "100%", // 그리드 높이
			emptyrecords: "데이터가 존재하지 않습니다.", // 데이터가 없을때 보여줄 문자열  
			formatter: {
				integer: {thousandsSeparator: ",", defaultValue: "0"} // price(판매가) 천원 단위로 ',' 찍기
			},
		}); // jqGrid
		
		// grid 옵션 추가
		$('#productList').jqGrid('navGrid', '#pageOption',
							{
								edit : true, // 수정
								add : true, // 추가
								del : false, // 삭제 비활성화
								search : true, // 검색
								refresh : true, // body 새로고침
							},
							
							// 수정
							{
								url: "./productEdit.do",
								editCaption: "상품 수정", // 수정form title
								bSubmit: "수정", // submit 버튼 이름 변경
								bCancel: "취소", // cancel 버튼 이름 변경
								bClose: "Close",
								
								recreateForm: true,
								savekey: [true, 13], // form에서 13(Enter) 확인 버튼작동시키기
								reloadAfterSubmit: true, // 서버 Ajax 후 그리드 데이터 다시 로드
								closeAfterEdit: true, // submit 후 form닫기
								closeOnEscape: true // ESC키를 이용해 모달창을 닫을 수 있다.
							},
							
							// 추가
							{
								url: "./productAdd.do",
								addCaption: "상품 등록", // 등록form title
								bSubmit: "등록", // submit 버튼 이름 변경
								bCancel: "취소", // cancel 버튼 이름 변경
								bClose: "Close",
								
								recreateForm: true,
								savekey: [true, 13], // form에서 13(Enter) 확인 버튼작동시키기
								reloadAfterSubmit: true, // 서버 Ajax 후 그리드 데이터 다시 로드
								closeAfterEdit: true, // submit 후 form닫기
								closeOnEscape: true // ESC키를 이용해 모달창을 닫을 수 있다.
							}
					
						); // navGrid
		
	}
</script>
</head>
<body>
    
	<table id="productList">
		<tr>
			<td></td>
		</tr>
	</table>
	<div id="pageOption"></div>
	
</body>
</html>