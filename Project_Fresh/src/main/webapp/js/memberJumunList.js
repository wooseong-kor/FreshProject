/**
 * ajax로 restful server 구축하여 페이징 구현
 */


var ajax = function(){
	
	var list = document.getElementsByClassName("list");
	$.ajax({
		url : "./memberJumunListpaging.do",
		data : $("#frm").serialize(),
		type : "post",
		dataType : "json",
		async : true,
		success : function(msg){
//			alert("작동");
			$.each(msg, function(key, value) {
				alert(msg.lists[2].jumunnum);
				if (key=="lists") {
					alert(value);
					$.each(value, function(i, elt) {
						list[0].innerHTML = elt.jumunnum;
						list[1].innerHTML = elt.sangpgnum;
						list[2].innerHTML = elt.bsgcode;
						list[3].innerHTML = elt.jummoney;
						list[4].innerHTML = elt.jumcnt;
						list[5].innerHTML = elt.jumstat;
						list[6].innerHTML = elt.jumdate;
					})
				}
				
			})
			
			
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