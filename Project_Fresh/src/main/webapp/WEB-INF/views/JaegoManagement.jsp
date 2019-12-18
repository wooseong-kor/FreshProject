<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리 페이지</title>
<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.20/themes/redmond/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/css/ui.jqgrid.css" />
<link type="text/css" rel="stylesheet" href ="./css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href ="./css/bootstrap-theme.min.css">
<style type="text/css">
	html, body { font-size: 75%; }
</style>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/sweetalert.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/js/i18n/grid.locale-kr.js"></script>
<script type="text/javascript">
	$.jgrid.no_legacy_api = true;
	$.jgrid.useJSON = true;
</script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.5/modules/jqmodal.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.5/modules/jqdnr.js"></script>
<style type="text/css">
body {font-family: Arial;}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}

</style>
</head>
<body>

<h2>Tabs</h2>
<p>Click on the buttons inside the tabbed menu:</p>

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'jaegoList')">재고관리</button>
  <button class="tablinks" onclick="openCity(event, 'ipgoList')">입고관리</button>
  <button class="tablinks" onclick="openCity(event, 'pyegiList')">폐기관리</button>
</div>

<div id="jaegoList" class="tabcontent">

</div>

<div id="ipgoList" class="tabcontent">
</div>

<div id="pyegiList" class="tabcontent">
</div>

<script type="text/javascript">

function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");

  document.getElementById(cityName).style.display = "block";
  $(document).ready(function() {
  			$("#jaegoList").jqGrid({
  				url : "./jaegoJSON.do",
  				datatype: "json", // 데이터 타입
  				mtype: "POST", // 데이터 전송방식
  				caption: "재고관리", // 그리드의 제목
  				loadtext: "잠시만 기다려주세요~♡", // 로딩메시지
  				loadError: function() {alert("Error");}, // 로딩에러 메시지
  				
  				colNames : ['재고코드', '상품코드', '재고량', '재고상태'],
  				
  				colModel: [
  					{name : 'jaegocode', index : 'jaegocode', width : 100, editable: true, sortable:false,
  						cellattr: function ( rowId , tv , rowObject , cm , rdata ) { 
  							if (rowObject.jaegostat == "GOOD") { return 'style="color:#1C1C1C"' }
  							else if (rowObject.jaegostat == "BAD") { return 'style="color:#FE2E2E"' }
  						}
  					},	
  					
  					{name : 'sangcode', index : 'sangcode', editable: true, sortable:false,
  						cellattr: function ( rowId , tv , rowObject , cm , rdata ) { 
  							if (rowObject.jaegostat == "GOOD") { return 'style="color:#1C1C1C"' }
  							else if (rowObject.jaegostat == "BAD") { return 'style="color:#FE2E2E"' }
  						}
  					},
  					
  					{name : 'jaegocnt', index : 'jaegocnt', align : "right", editable: true, sortable:false, formatter: "integer",
  						cellattr: function ( rowId , tv , rowObject , cm , rdata ) { 
  							if (rowObject.jaegostat == "GOOD") { return 'style="color:#1C1C1C"' }
  							else if (rowObject.jaegostat == "BAD") { return 'style="color:#FE2E2E"' }
  						}
  					},
  					{name : 'jaegostat', index : 'jaegostat', align : "center", editable: true, sortable:false,
  						formatter: 'select', edittype:"select", 
  						editoptions:{value: "GOOD:출고가능;BAD:폐기"}, stype: 'select',
  						cellattr: function ( rowId , tv , rowObject , cm , rdata ) { 
  									if (rowObject.jaegostat == "GOOD") { return 'style="color:#1C1C1C"' }
  									else if (rowObject.jaegostat == "BAD") { return 'style="color:#FE2E2E"' }
  								}
  					},
  				],
  				
  				
  				jsonReader: { // json형태의 data읽기위해 필요
  					root : "jaegoAllList",
  					page: "currpage",
  					total: "totalpages",
  					records: "totalrecords",
  					repeatitems: false, // json data의 요소를 name으로 검색할 수 있다.
  				}, 
  				
  				// 페이징 or 스크롤 관련
  				loadonce: false, // true이면 데이터를 1번만 받고 새로 안받음, false 리플레쉬는 되나, 페이징이 안먹음
  				pager: "#pageOption0", // 페이징, 전체글수, 추가, 수정, 검색, 새고고침 버튼 있는 곳 활성화 여부
  				rowNum : 1000, // 한번에 뿌려질 데이터의 개수
  				width:700,
  				viewrecords: true, // 전체 페이지와 보여지고 있는 레코드 수를 보여준다.
  				emptyrecords: "데이터가 존재하지 않습니다.", // 데이터가 없을때 보여줄 문자열  
  				
  				// 부가옵션
  				rownumbers : true, // row number 활성화 여부 좌측 행번호
  				gridview: true, // 성능향상
  				formatter: {
  					integer: {thousandsSeparator: ",", defaultValue: "0"} // price(판매가) 천원 단위로 ',' 찍기
  				},

  			}).jqGrid('navGrid', '#pageOption',
  							{
  								edit : true, // 수정
  								add : true, // 추가
  								del : false, // 삭제 비활성화
  								search : false, // 검색
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
  								url: "./jaegoAdd.do",
  								addCaption: "재고등록", // 등록form title
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

  	$(document).ready(function() {
  			$("#ipgoList").jqGrid({
  				url : "./ipgoJSON.do",
  				datatype: "json", // 데이터 타입
  				mtype: "POST", // 데이터 전송방식
  				caption: "입고관리", // 그리드의 제목
  				loadtext: "잠시만 기다려주세요~♡", // 로딩메시지
  				loadError: function() {alert("Error");}, // 로딩에러 메시지
  				
  				colNames : ['입고번호', '재고코드', '입고일자', '입고수량','유통기한'],
  				
  				colModel: [
  					{name : 'ipgonum', index : 'ipgonum', width : 80, editable: true, sortable:false},	
  					
  					{name : 'jaegocode', index : 'jaegocode', editable: true, sortable:false,},
  					
  					{name : 'ipgodate', index : 'ipgodate', align : "right", editable: true, sortable:false, formatter: "integer", sorttype:"date", datefmt:'yyyy-MM-dd' },
  					{name : 'ipgocnt', index : 'ipgocnt', align : "right", editable: true, sortable:false, formatter: "integer"},
  					{name : 'expdate', index : 'expdate', align : "center", editable: true, sortable:false, sorttype:"date", datefmt:'yyyy-MM-dd'},
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
  				pager: "#pageOption1", // 페이징, 전체글수, 추가, 수정, 검색, 새고고침 버튼 있는 곳 활성화 여부
  				rowNum : 1000, // 한번에 뿌려질 데이터의 개수 
  				width:700, //가로길이
  				viewrecords: true, // 전체 페이지와 보여지고 있는 레코드 수를 보여준다.
  				emptyrecords: "데이터가 존재하지 않습니다.", // 데이터가 없을때 보여줄 문자열  
  				
  				// 부가옵션
  				rownumbers : true, // row number 활성화 여부 좌측 행번호
  				gridview: true, // 성능향상
  				formatter: {
  					integer: {thousandsSeparator: ",", defaultValue: "0"} // price(판매가) 천원 단위로 ',' 찍기
  				},

  			}).jqGrid('navGrid', '#pageOption1',
  							{
  								edit : true, // 수정
  								add : true, // 추가
  								del : false, // 삭제 비활성화
  								search : false, // 검색
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

  	$(document).ready(function() {
  		$("#pyegiList").jqGrid({
  			url : "./pyegiJSON.do",
  			datatype: "json", // 데이터 타입
  			mtype: "POST", // 데이터 전송방식
  			caption: "폐기관리", // 그리드의 제목
  			loadtext: "잠시만 기다려주세요~♡", // 로딩메시지
  			loadError: function() {alert("Error");}, // 로딩에러 메시지
  			
  			colNames : ['폐기번호', '재고코드', '폐기수량', '폐기여부','폐기사유'],
  			
  			colModel: [
  				{name : 'pyeginum', index : 'pyeginum', width : 100, editable: true, sortable:false,
  					cellattr: function ( rowId , tv , rowObject , cm , rdata ) { 
  						if (rowObject.pyeflag == "Y") { return 'style="color:#1C1C1C"' }
  						else if (rowObject.pyeflag == "N") { return 'style="color:#FE2E2E"' }
  					}
  				},	
  				
  				{name : 'jaegocode', index : 'jaegocode', editable: true, sortable:false,
  					cellattr: function ( rowId , tv , rowObject , cm , rdata ) { 
  						if (rowObject.pyeflag == "Y") { return 'style="color:#1C1C1C"' }
  						else if (rowObject.pyeflag == "N") { return 'style="color:#FE2E2E"' }
  					}
  				},
  				
  				{name : 'pyegicnt', index : 'pyegicnt', align : "right", editable: true, sortable:false, formatter: "integer",
  					cellattr: function ( rowId , tv , rowObject , cm , rdata ) { 
  						if (rowObject.pyeflag == "Y") { return 'style="color:#1C1C1C"' }
  						else if (rowObject.pyeflag == "N") { return 'style="color:#FE2E2E"' }
  					}
  				},
  				{name : 'pyegisayu', index : 'pyegisayu', align : "right", editable: true, sortable:false, formatter: "integer",
  					cellattr: function ( rowId , tv , rowObject , cm , rdata ) { 
  						if (rowObject.pyeflag == "Y") { return 'style="color:#1C1C1C"' }
  						else if (rowObject.pyeflag == "N") { return 'style="color:#FE2E2E"' }
  					}
  				},
  				{name : 'pyeflag', index : 'pyeflag', align : "center", editable: true, sortable:false,
  					formatter: 'select', edittype:"select", 
  					editoptions:{value: "Y:폐기 처리된 상태;N:폐기 미처리 상태"}, stype: 'select',
  					cellattr: function ( rowId , tv , rowObject , cm , rdata ) { 
  								if (rowObject.pyeflag == "Y") { return 'style="color:#1C1C1C"' }
  								else if (rowObject.pyeflag == "N") { return 'style="color:#FE2E2E"' }
  							}
  				},
  			],
  			
  			jsonReader: { // json형태의 data읽기위해 필요
  				root : "pyegiAllList",
  				page: "currpage",
  				total: "totalpages",
  				records: "totalrecords",
  				repeatitems: false, // json data의 요소를 name으로 검색할 수 있다.
  			}, 
  			
  			// 페이징 or 스크롤 관련
  			loadonce: false, // true이면 데이터를 1번만 받고 새로 안받음, false 리플레쉬는 되나, 페이징이 안먹음
  			pager: "#pageOption2", // 페이징, 전체글수, 추가, 수정, 검색, 새고고침 버튼 있는 곳 활성화 여부
  			rowNum : 1000, // 한번에 뿌려질 데이터의 개수 
  			viewrecords: true, // 전체 페이지와 보여지고 있는 레코드 수를 보여준다.
  			emptyrecords: "데이터가 존재하지 않습니다.", // 데이터가 없을때 보여줄 문자열  
  			
  			// 부가옵션
  			rownumbers : true, // row number 활성화 여부 좌측 행번호
  			gridview: true, // 성능향상
  			formatter: {
  			},

  		}).jqGrid('navGrid', '#pageOption2',
  						{
  							edit : true, // 수정
  							add : true, // 추가
  							del : false, // 삭제 비활성화
  							search : false, // 검색
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
  							url: "./pyegiAdd.do",
  							addCaption: "폐기등록", // 등록form title
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
  evt.currentTarget.className += " active";
}
</script>
	
</body>
</html>