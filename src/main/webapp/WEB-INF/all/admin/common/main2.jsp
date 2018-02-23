<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> 
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>kenhome后台</title>

     <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
     <link href="${pageContext.request.contextPath}/resources/css/admin/style2.css" rel="stylesheet">
     <style type="text/css">    
     </style>
     <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
     <!-- 包括所有已编译的插件 -->
     <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
  
     <script>
    $().ready(function(){
    	
      //首级菜单栏首个资源带上nav-active
      $(".nav-item").eq(0).addClass("nav-active");
      
      //显示首级菜单栏首个资源的子资源菜单
       var rootID=$(".head-item").eq(0).attr("data-rootID");
       $(".nav-left-bar[data-parentID|="+rootID+"]").css("display","block");
      
       
      //左侧栏右滑动动画效果
      $(".leftbar").css({"position":"relative","left":"-10px"}).animate({left:"0px"},800);
      
       //右边栏上滑动动画效果
      $(".rightbar").css({"position":"relative","top":"15px"}).animate({top:"0px"},800);
      
      //二级菜单首个资源带上nav-leftActive
      $(".nav-left-bar").eq(0).find("a").addClass("nav-leftActive");
      
         
      
	  //iframe显示二级菜单首级资源的内容
	  var initUrl = $(".nav-left-bar").eq(0).find("a").attr("href");

	  $("#targetView").attr("href",initUrl);
      
      
	  //首页导航鼠标滑过效果
	  $(".nav-item").hover(function (){  
	     if($(this).hasClass("nav-active")){
		   return;			
	  	}
           $(this).css({"color":"#337ab7","background-color":"#f2f6ff"});  
         },function (){ 
           if($(this).hasClass("nav-active")){
		  return;			
		}		  
           $(this).css({"color":"white","background-color":"#0072bc"});
         }); 
	  
	  
	  //首页父级导航栏，点击某个父级资源
	  $(".nav-item").click(function(){
		  
		  //父菜单栏变化 
	     $(this).addClass("nav-active").parent().siblings().children().removeClass("nav-active").css({"color":"white","background-color":"#0072bc"});		
            
         //子菜单栏变化，动画显示对应的子资源,隐藏不相干的子资源     
         
         $(".leftbar").css({"position":"relative","left":"-10px"}).animate({left:"0px"},800);
         var partentID=$(this).parent().attr("data-rootID");
         
         
         $(".nav-left-bar[data-parentID !="+partentID+"]").css("display","none");
         $(".nav-left-bar[data-parentID|="+partentID+"]").css("display","block");
         
         //对应首个子资源被激活
		 $(".nav-left-bar[data-parentID|="+partentID+"]").eq(0).find(".nav-leftItem").addClass("nav-leftActive").css({"color":"white","background-color":"#0072bc"}).parent().siblings().children().removeClass("nav-leftActive").css({"color":"#0072bc","background-color":"#f2f6ff"});
          
		 //右边栏上滑动动画效果
	     $(".rightbar").css({"position":"relative","top":"15px"}).animate({top:"0px"},800);
		 
	    //iframe显示首个对应子资源的内容
		  var targettUrl = $(".nav-left-bar[data-parentID|="+partentID+"]").eq(0).find("a").attr("href");
		  $("#targetView").attr("src",targettUrl);
		 
		 
		 
	  })
	    
		
	  //左侧子菜单栏鼠标滑过变化
	  $(".nav-leftItem").hover(function (){  
	     if($(this).hasClass("nav-leftActive")){
		   return;			
	  	}
           $(this).css({"color":"white","background-color":"#0072bc"});
         },function (){ 
           if($(this).hasClass("nav-leftActive")){
		  return;			
		}		  
           $(this).css({"color":"#0072bc","background-color":"#f2f6ff"});
         }); 
	  
	  //左侧子菜单栏点击变化
	  $(".nav-leftItem").click(function(){
	     $(this).addClass("nav-leftActive").parent().siblings().children().removeClass("nav-leftActive").css({"color":"#0072bc","background-color":"#f2f6ff"});
	     
	     //右边栏上滑动动画效果
	     $(".rightbar").css({"position":"relative","top":"15px"}).animate({top:"0px"},800);
	     
	     //iframe显示首个对应子资源的内容
	     var targettUrl = $(this).attr("href");
		 $("#targetView").attr("src",targettUrl);
	     
	     return false;
	     
	  });
	
   });
  </script>
</head>
  <body>
     <div class="header-top">
	   <div class="container-fluid">
	     <div class="row">
	       <div class="col-md-12">
			     <div class="myself pull-right">
				  <i class="glyphicon glyphicon-user"></i><span>${manager.managerName}</span><span>|</span><span>${manager.roles.get(0).roleName}</span><span>|</span><a href="javascript:;"><span>切换风格</span></a><span>|</span><a href="${pageContext.request.contextPath}/admin/common/logout"><span>退出</span></a>
				 </div>
		   </div>
	     </div>
	     <div class="row main-item">
		   <div class="col-md-1">
		     <a href="${pageContext.request.contextPath}/admin/common/main"><img class="img-responsive" alt="凯之家" src="${pageContext.request.contextPath}/resources/image/logo/kenhome-white.png" style=""></a>
		   </div>
		   <div class="col-md-11">		     		   			   
			   <div class="col-md-12">
			     <ul class="nav nav-pills navstyle ">
			       
			       <c:forEach items="${firstGradeAcls}" var="eachFirst" >  
	                   
	                    <li class="head-item" data-rootID="${eachFirst.id}"><a class="nav-item" href="${eachFirst.aclUrl}">${eachFirst.aclName}</a></li>
	                    
	                  </c:forEach>  			
			     </ul>
			   </div>						
		 </div>		   
		 </div>
	   </div>
	 </div>
	 <div class="container-fluid" >
	   <div class="row">
	     <div class="col-md-1 leftbar">
		   <ul class="nav nav-pills nav-stacked leftbar-ul">
		     
		      <c:forEach items="${secondGradeAcls}" var="eachSecond">
		      
		         <li data-parentID="${eachSecond.parentId}" class="nav-left-bar" style="display:none;padding:0px;" ><a style="margin:0px;padding:15px 35px;text-align:center;" class="nav-leftItem" href="${pageContext.request.contextPath}${eachSecond.aclUrl}"><span></span>${eachSecond.aclName}</a></li>
		      
		      </c:forEach>		   			   
           </ul>
		 </div>
		 <div class="col-md-11 rightbar" >
		   <iframe id="targetView" name="target"   src="${pageContext.request.contextPath}/admin/background/info" ></iframe>
		 </div>
	   </div>	 
	 </div>
	
   </body>

</html>