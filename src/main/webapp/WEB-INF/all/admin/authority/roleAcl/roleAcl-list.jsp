<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>权限分配
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	  <link href="${pageContext.request.contextPath}/resources/css/admin/common.css" rel="stylesheet">  
	  <style type="text/css">
	   .roleAcl-head{padding-bottom:5px;margin-top:10px;}
	   .roleAcl-name{height:30px;padding-top:8px;}
	   .roleAcl-name>strong{font-size:15px;}
	   .acl-left-bar{box-shadow: #666 0px 0px 10px;}
	   .acl-right-bar{min-height:800px;padding:0px;}
	   .acl-right-bar iframe{width:100%;box-shadow: #666 0px 0px 10px;min-height:2000px;border:0px;}
	   .arrow-style{font-size:100px;color:#1f3f53;}
	  </style>
	 	  
	  <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/admin/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){			  
			  //加载更多
			  $("#loadMoreRole").click(function(){
				  $(this).text("加载中...").attr("disabled","disabled");  
				  var targetUrl = $(this).attr("data-loadUrl");
				  var dataPage  = $(this).attr("data-loadPage");
				  var roleName  = $("#roleName").val();
				  $.ajax({
					  type : 'get',
					  url  : targetUrl,
					  data : {
						     roleName    : roleName,
						     currentPage : dataPage
					  },
					  dataType: 'json',
					  success:function(rolePage){
						  <!--判断是否最后一页,按钮状态变化-->
						  if(rolePage.pages>dataPage){	
							  var page =parseInt(dataPage)+1;
							  $("#loadMoreRole").attr("data-loadPage",page);
							  $("#loadMoreRole").text("加载更多").removeAttr("disabled");
						  }else{
							  $("#loadMoreRole").text("已全部加载");
						  }
						  
						  <!--添加数据到页面-->
						  $.each(rolePage.list, function(key, role) {
	                  	  	  var addtag ='<tr id="'+role.id+'" class="tr">'+
	        					          '   <td>'+role.roleName+'</td> '+
	        					          '   <td>'+
	        					          '     <a href="javascript:viewEntity('+role.id+',&#39;${pageContext.request.contextPath}/admin/authority/roleAcl/viewAcl&#39;);" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-book"></i>&nbsp;<span>查看</span></a> '+
	        					          '     <a href="javascript:vieweditEntity('+role.id+',&#39;${pageContext.request.contextPath}/admin/authority/roleAcl/viewEditAcl&#39;);" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>编辑</span></a> '+
	        					          '     <a href="javascript:deleteByID('+role.id+',&#39;${pageContext.request.contextPath}/admin/authority/roleAcl/delete&#39;);" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span>去权</span></a>	'+		   
	        					          '   </td> '+
	        					          '  </tr>'
	                  	       $("tbody").append(addtag);     
	        				   $("tr:last").hide().fadeIn("slow");
	                  	  })		  
					  },
					  error:function(){
						  bootbox.alert("请求失败")
					  }
				  });	  
			  });	
			  
			  //搜索
			  $("#formSearch").click(function(){
				  $("#listForm").submit();
			  });
			  
		  })

	      //查看角色权限界面
		  function  viewEntity(id,viewUrl){
			  var targetRrl =viewUrl+"?roleId="+id;
			  $("#targetAcl").attr("src",targetRrl);
			  		  
		  }
		  
		  //编辑角色权限界面
		  function  vieweditEntity(id,viewUrl){
			  var targetRrl =viewUrl+"?roleId="+id;
			  $("#targetAcl").attr("src",targetRrl);
			  		  
		  }
	      
	     
		 
		 
		  
	      
	 
	  </script>
	  
   </head>
   <body>
     <div class="container-fluid">
	   <div class="row roleAcl-head"></div> 
	   <div class="row">
	      <div class="col-md-3 acl-left-bar" style="margin-left:5px;">
	      
	         <div class="row">
	           <div class="col-md-12 label label-info roleAcl-name ">
		         <strong >角色权限分配</strong>
		       </div>			 
	         </div> 
	          
	          <!--搜索栏-->
			 <form id="listForm" class="row common-search" action="${pageContext.request.contextPath}/admin/authority/roleAcl/main"  method = "GET">          
			     <div class="col-md-6 col-md-offset-1">
				   <div class="input-group">		 
					  <input id="roleName" type="text" class="form-control reset" placeholder="要授权的角色" name="roleName" value="${parames.roleName}">
				   </div>
				 </div> 
				 <div class="btn-group col-md-4" role="group" aria-label="...">
				  <button id="formSearch" type="button" class="btn btn-default">搜索</button>
				 </div>				
				 <!-- 隐藏 -->
				 <input type="hidden" id="currentPage" name="currentPage" value="${parames.currentPage}" /> 	 
			 </form> 
			 <!--分割线-->
	         <div class="row cut-line"></div>
	         <!--列表-->
			 <div class="row ">
			     <table class="table text-center  table-hover table-striped">	  
				  <tbody >
				   <c:forEach var="pageRole"   items="${pageInfo.getList()}" varStatus="statu" >
				     
				     <tr id="${pageRole.id}" class="tr">
					  <td>${pageRole.roleName}</td>
					  <td>
					   <a href="javascript:viewEntity(${pageRole.id},'${pageContext.request.contextPath}/admin/authority/roleAcl/viewAcl');" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-book"></i>&nbsp;<span>查看</span></a>
					   <a href="javascript:vieweditEntity(${pageRole.id},'${pageContext.request.contextPath}/admin/authority/roleAcl/viewEditAcl');" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>编辑</span></a>
					   <a href="javascript:deleteByID(${pageRole.id},'${pageContext.request.contextPath}/admin/authority/roleAcl/delete');" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span>去权</span></a>			   
					  </td>
					</tr>		   
				   </c:forEach> 		
				  </tbody>
				</table>
			  </div>
			  
			  <div class="row text-center">
	            <button id="loadMoreRole" type="button" class="btn btn-default  btn-block" data-loadPage="2" data-loadUrl="${pageContext.request.contextPath}/admin/authority/roleAcl/loadMore" >加载更多</button>
	          </div>
	          <div class="row">
			     <div class="col-md-12 text-right label label-info">
			       <small>共</small>							   
				   <span >${pageInfo.getTotal()}</span>
				   <small  >种角色</small> 
				 </div>
			  </div>	        
	      </div> 
	      <div class="col-md-1">
	        <i class="glyphicon glyphicon-arrow-right arrow-style"></i>
	      </div>
	      <div class="col-md-7  acl-right-bar">
	         <iframe id="targetAcl" name="targetAcl"   src="${pageContext.request.contextPath}/admin/authority/resource/main" ></iframe>
	      </div>   
	   </div>
	</div>
	<div id="test"></div>   
		
	
  
  
	 
  </body>
</html>