<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>日志中心
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
     
	  <!--时间控件-->
	  <link href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.css" rel="stylesheet">
	  
	  <link href="${pageContext.request.contextPath}/resources/css/admin/common.css" rel="stylesheet">
	  	  
	  <style type="text/css">
	    .{margin-right:15px;}
	    .log-search{margin-top:20px;}
	  </style>
	 	  

      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  
	  <!--时间控件-->
	  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.js"></script>
	  <!--时间控件汉化-->
	  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.zh-CN.js"></script>

	  <script src="${pageContext.request.contextPath}/resources/js/admin/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			  
	     
            				            
		  }); 
			 
		      	 
	  </script>
	  
   </head>
   <body>
     <div class="container-fluid">
	   <div class="row common-head">
	     <div class="col-md-2">
		   <span class="common-name">日志中心</span>
		   <span>(</span>
		   <span class="text-success">${pageInfo.getTotal()}</span>
		   <span id="entityNums">条记录</span>
		   <span>)</span>
		 </div>
		 <div class="col-md-2 pull-right text-right">		  
		   <a id="excel-export" href="javascript:;" data-href="${pageContext.request.contextPath}/admin/system/log/export?" class="btn btn-xs btn-warning btn-outline-warning ">
		    <i class="glyphicon glyphicon-export"></i>
			<span>导出excel</span>
		   </a>
		 </div>			 
	   </div>
	   
	   <!--搜索栏-->
	   <form id="listForm" class="row common-search " action="${pageContext.request.contextPath}/admin/system/log/main"  method = "GET">          
	     <div class="row form-group "> 
	        <div class="col-md-2">	   		 
			  <input type="text" class="form-control reset" placeholder="操作IP" name="operateIp" value="${params.operateIp}">		   
		    </div>
	        <div class="col-md-2">	   		 
			  <input type="text" class="form-control reset" placeholder="操作人" name="operator" value="${params.operator}">		   
		    </div>
		    <div class="col-md-2">		  		 
			  <input type="text" class="form-control reset" placeholder="动作" name="operation" value="${params.operation}">		   
		    </div>	
		    <div class="input-group  col-md-3" style="margin-left:15px;">		   		 
			    <input type="text" class="form-control datetimepicker reset" placeholder="记录起始" name="startCreateDate" value="${params.startCreateDate}" id="oneDate" >
			    <span class="input-group-addon" >到</span>
			    <input type="text" class="form-control datetimepicker reset" placeholder="结束时间" name="endCreateDate" value="${params.endCreateDate}" id="twoDate" >		   
		    </div>
		    <div class="col-md-2 form-inline log-search">
		      <input id="formSearch" type="button" class="form-control" value="搜索" >
			  <input id="searchReset" type="button" class="form-control" value="重置">	
		    </div>		   	   	   		  		   		   			 		   
		  </div>	
		 <div class="row form-group form-inline "> 	       		  		 
		      			 		   
		 </div>	 	   
		 
		 <!-- 隐藏 -->
		 <input type="hidden" id="currentPage" name="currentPage" value="1" />		 	 
	   </form>
	   
	   <!--分割线-->
	   <div class="row cut-line">
	     
	   </div>
	   
	   <!--列表-->
	   <div class="row margin-top-15px">
	     <table class="table table-bordered table-hover table-striped">
		  <thead class="imformation-thead">
			<tr>
			  <th>操作人</th>
			  <th>操作动作</th>
			  <th>操作内容</th>
			  <th>操作IP</th>
			  <th>操作时间</th>			               			  
			</tr>
		  </thead>
		  <tbody >
		   <c:forEach var="pageLog"   items="${pageInfo.getList()}" varStatus="statu" >
		     
		     <tr id="${pageLog.id}" class="tr">		    
			  <td width="8%">${pageLog.operator}</td>
			  <td width="8%">${pageLog.operation}</td>
			  <td width="66%">${pageLog.content}</td>
			  <td width="8%">${pageLog.operateIp}</td>
			  <td width="10%"><fmt:formatDate type="both" value="${pageLog.createDate}"/></td>			   			 
			</tr>		   
		   </c:forEach>
		   		
		  </tbody>
		</table>
	   </div>
	   
	   <!--页码-->
	  <%@ include file="/WEB-INF/all/include/pageHelper.jsp"%> 
	</div>   
		  
  </body>
</html>