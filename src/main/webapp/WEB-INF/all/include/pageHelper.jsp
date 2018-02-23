<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>分页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style type="text/css">
     .button-disabled{background-color:#eee;color:#b1afaf;pointer-events: none; cursor:default;opacity: 0.8;}
    </style>
    
    <script src="${pageContext.request.contextPath}/resources/js/include/pageHelper.js"></script>
    
    <script type="text/javascript">
    
    
    
    </script>
  </head>
  
 <body>
  <div class="row">
     <div class="col-md-3 text-info">
	   <span>共有记录：</span>
	   <span>${pageInfo.getTotal()}</span>
	   <span>条</span>
	   <span>,</span>
	   <span>当前显示第</span>
	   <span>${pageInfo.getPageNum()}</span>
	   <span>/</span>
	   <span>${pageInfo.getPages()}</span>
	   <span>页</span>	   
	 </div>
	 	 
     <div class="col-md-5 col-md-offset-2 common-page">
	   <nav aria-label="Page navigation" class="pull-right">
		  <ul class="pagination ">
		    <li id="First">
			  <a href="javascript:skipPage(${pageInfo.navigateFirstPage});" aria-label="First">
				<span aria-hidden="true">|&laquo;</span>
			  </a>
			</li>
			<li id="Previous">
			  <a href="javascript:skipPage(${pageInfo.prePage});" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
			  </a>
			</li>
			
			<c:if test="${pageInfo.pageNum>2}">
			  <li><a href="javascript:skipPage(${pageInfo.pageNum-2});">${pageInfo.pageNum-2}</a></li>
			</c:if>
			
						
			<c:if test="${pageInfo.pageNum>1}">
			  <li><a href="javascript:skipPage(${pageInfo.pageNum-1});">${pageInfo.pageNum-1}</a></li>	
			</c:if>
			
							
			<li class="active"><a href="javascript:skipPage(${pageInfo.pageNum});">${pageInfo.pageNum}</a></li>
			
			<c:if test="${pageInfo.pageNum<pageInfo.pages}">
			  <li><a href="javascript:skipPage(${pageInfo.pageNum+1});">${pageInfo.pageNum+1}</a></li>
			</c:if>
							
			<c:if test="${pageInfo.pageNum<pageInfo.pages-1}">
			  <li><a href="javascript:skipPage(${pageInfo.pageNum+2});">${pageInfo.pageNum+2}</a></li>
			</c:if>
			
			<li id="Next">
			  <a href="javascript:skipPage(${pageInfo.nextPage});" aria-label="Next">
				<span aria-hidden="true">&raquo;</span>
			  </a>
			</li>
			<li id="End" data-pages="${pageInfo.pages}">
			  <a href="javascript:skipPage(${pageInfo.navigateLastPage});" aria-label="End">
				<span aria-hidden="true">&raquo;|</span>
			  </a>
			</li>
		  </ul>
         </nav>
	 </div>
	 <div class="col-md-2  common-page-jump">
	   <div class="input-group">
		  <input id="jumpPage" type="text" class="form-control" placeholder="请选择页数" style="padding:0px;text-align:center;">
		  <span class="input-group-btn">
			<button id="slectPage" class="btn btn-default" type="button">选择</button>
		  </span>
	   </div>
	 </div>
   </div>	   
</body>
</html>