$.jgrid.no_legacy_api = true;
	$.jgrid.useJSON = true;

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
		pager: "#pageOption", // 페이징, 전체글수, 추가, 수정, 검색, 새고고침 버튼 있는 곳 활성화 여부
		rowNum : 1000, // 한번에 뿌려질 데이터의 개수 
		viewrecords: true, // 전체 페이지와 보여지고 있는 레코드 수를 보여준다.
		emptyrecords: "데이터가 존재하지 않습니다.", // 데이터가 없을때 보여줄 문자열  
		
		// 부가옵션
		rownumbers : true, // row number 활성화 여부 좌측 행번호
		gridview: true, // 성능향상

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
						url: "./jaegoEdit.do",
						editCaption: "재고 수정", // 수정form title
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
						addCaption: "재고 등록", // 등록form title
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