<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>凯之家商城-分类查看(测试)
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      
      <!-- font样式 -->
      <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
     	  
	  <link href="${pageContext.request.contextPath}/resources/css/shop/common.css" rel="stylesheet">
	  	  
	  <style type="text/css">
	    
	  </style>
	 	  	
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/shop/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			  
		     
				
		  });
	  </script>
	  
   </head>
   <body>
     <div id="category-content" class="container-fluid">
       <div class="row">
         <div class="col-md-10">
           <c:forEach items="${categorys}" var="category" varStatus="statu">
             <div class="row" style="margin-bottom:20px;margin-top:20px;line-height:20px;" >
               <div class="col-md-2">
                 <a href="javascript:window.open('${pageContext.request.contextPath}/shop/good/listThird?categoryId=${category.id}');"><strong style="">${category.categoryName}</strong></a>
                 <span class="mg-left-5">></span>               
               </div>
               <div class="col-md-10" >
                 <c:forEach items="${category.childrenCategorys}" var="subCategory" varStatus="statu">
                   <a href="javascript:window.open('${pageContext.request.contextPath}/shop/good/listThird?categoryId=${subCategory.id}');"><span class="mg-left-5 ">${subCategory.categoryName}</span></a>
                   <span class="mg-left-5 ">|</span>
                 </c:forEach>
               </div>
             </div>
           </c:forEach>
           
         </div>
         <div class="col-md-2">
           <c:forEach items="${categoryBrands}" var="categoryBrand" varStatus="statu">
             <a href="javascript:;"><img alt="" src="${pros.fictitiousRoot}${categoryBrand.logo}" class="" style="padding-bottom:10px;width:42%;margin-top:25px;margin-right:5px;"></a>           
           </c:forEach>
         </div>
       </div>
     </div>
  
   </body>
</html>