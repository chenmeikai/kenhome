/**
 * 
 * 分页js
 * 
 */

$().ready(function(){
	
	pagePrevent();    
		 
		 
		  
		  
})	

  //页数尽头添加禁止图标
  function pagePrevent(){
	
	var pageNum = $(".pagination>.active").text();	
	
	var pages   = $("#End").attr("data-pages");
	
	if(pageNum==1){
		$("#Previous").addClass("button-disabled");
		$("#First").addClass("button-disabled");
	}else{
		$("#Previous").removeClass("button-disabled");
		$("#First").removeClass("button-disabled");
	}
	
	if(pageNum==pages){
		$("#Next").addClass("button-disabled");
		$("#End").addClass("button-disabled");
	}else{
		$("#Next").removeClass("button-disabled");
		$("#End").removeClass("button-disabled");
	}	
}


//$.ajax方法
//$.ajax({
//	url: target,
//	type: "Get",
//	dataType:'html',
//	success:function(msg){
//		if (msg) {
//			window.location.href = target;
//			}
//	},
//	error:function(er){
//	alert("fall")}
//	});

