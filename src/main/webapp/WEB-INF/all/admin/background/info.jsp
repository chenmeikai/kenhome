<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>后台信息</title>

     <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
     
      <style>
         body{background-color:hsla(214, 41%, 78%, 0.27);}
	    .text-margin-top-8{margin-top:8px;}
	  </style>

     <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
     <!-- 包括所有已编译的插件 -->
     <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
  
    
</head>
  <body>
     <div class="container-fluid">
	   <div class="row">
	     <div class="col-md-12" style="font-size:15px;color:rgb(101, 80, 80);font-weight:600;margin-top:10px;padding-bottom:5px;border-bottom:1px solid #a59d9d;">
		   系统信息
		 </div>
		 <div class="col-md-12" style="font-size:13px;font-weight:600;color:rgb(101, 80, 80);padding-left:25px;margin-top:10px;">
		   <div class="text-margin-top-8">
		     <span>平台名称：</span>
			 <span>凯之家</span>
		   </div >
		   <div class="text-margin-top-8">
		     <span>系统版本：</span>
			 <span>1.0</span>
		   </div>
		   <div class="text-margin-top-8">
		     <span>JAVA版本：</span>
			 <span>1.8.0_80</span>
		   </div>
		   <div class="text-margin-top-8">
		     <span>操作系统名称：</span>
			 <span>1.20</span>
		   </div>
		   <div class="text-margin-top-8">
		     <span>Servlet信息：</span>
			 <span>Apache Tomcat/8.0.57</span>
		   </div>
		  
		   
		 </div>
	   </div>
	 </div>  
   </body>
</html>