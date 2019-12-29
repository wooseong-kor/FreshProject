/**
 * ajax로 restful server 구축하여 페이징 구현
 */


var ajax = function(){
	
	$.ajax({
		url : "./memberJumunListpaging.do",
		data : $("#frm").serialize(),
		type : "post",
		dataType : "json",
		async : true,
		success : function(msg){
			alert("작동");
			alert(msg.rDto);
		},
		error: function(){
			alert("에러");
		}
	});
}

function pageIndex(i){
	var index = document.getElementById("index");
	index.value = i-1;
	ajax();
}