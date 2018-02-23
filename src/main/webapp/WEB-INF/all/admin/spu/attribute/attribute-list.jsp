<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>属性管理
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	  
	  <!--时间控件-->
	  <link href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.css" rel="stylesheet">
	  
	  <!-- 验证样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/validate/validate.css" rel="stylesheet">
	  
	  <link href="${pageContext.request.contextPath}/resources/css/admin/common.css" rel="stylesheet">
	  
	  <style type="text/css">
	    body{font: 12px/1 Tahoma,Helvetica,Arial,"\5b8b\4f53",sans-serif;}
	  </style>
	 	  
	  <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  
	  <!--时间控件-->
	  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.js"></script>
	  <!--时间控件汉化-->
	  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.zh-CN.js"></script>
	  
	  <!-- 表单验证控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
	  <!-- extend validate-method -->
	  <script src="${pageContext.request.contextPath}/resources/js/validate/validate-extend-method.js"></script>
	  
	  <!-- dateFormat -->
	  <script src="${pageContext.request.contextPath}/resources/js/dateFormat/dateFormat.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/admin/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			    
			  //验证表单
			  var validateUrl =  $("#recipient-name").attr("data-validateUrl");
			  $("#addForm").validate({			 
				    rules: {
				        attributeName: {
				          required: true,
				          remote: {
				        	    url: validateUrl,           //后台处理请求地址
				        	    type: "get",                //数据发送方式
				        	    dataType: "json",           //接受数据格式   
				        	    data: {                     //要传递的数据
				        	        attributeName: function() {
				        	            return $("#recipient-name").val();
				        	        }
				        	    }
				          }
				        }
				    },				      
				     messages: {			        
				    	 attributeName: {
				          required: "属性名不能为空",
				          remote: "该属性已存在"
				        }
				     }
			   });	
			  
			 
			  
			     
		  })
		  
		  
		     
		      
		  
			  //打开编辑页面
			  function  showEdit(id,editUrl){
				  var targetUrl= editUrl+"?id="+id;
				  window.location= targetUrl ;
				 			  
			  }
			  
		      
	 
	  </script>
	  
   </head>
   <body>
     <div class="container-fluid">
	   <div class="row common-head">
	     <div class="col-md-2">
		   <span class="common-name">属性管理</span>
		   <span>(</span>
		   <span class="text-success">${pageInfo.getTotal()}</span>
		   <span id="entityNums">种属性</span>
		   <span>)</span>
		 </div>
		 <div class="col-md-2 pull-right text-right">
		   <a id="showAddWindow" href="javascript:;" class="btn btn-xs btn-info btn-outline-info">
		    <i class="glyphicon glyphicon-plus"></i>
			<span>新增</span>
		   </a>	
		 </div>			 
	   </div>
	   
	   <!--搜索栏-->
	   <form id="listForm" class="row common-search" action="${pageContext.request.contextPath}/admin/spu/attribute/main"  method = "GET">          
	     <div class="col-md-2">
		   <div class="input-group">		 
			  <input type="text" class="form-control reset" placeholder="属性名" name="attributeName" value="${parames.attributeName}">
		   </div>
		 </div>			 	 		
		 <div class="col-md-2">
  	        <button id="formSearch" type="button" class="btn btn-default form-control">搜索</button>		 	  
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
			  <th>ID</th>
			  <th>编号</th>
			  <th>属性</th>
			  <th>选项</th>
			  <th>描述</th>
			  <th>序号</th>				  
			  <th>创建日期</th>	
			  <th>更新日期</th>	
			  <th>操作</th>	              			  
			</tr>
		  </thead>
		  <tbody >
		   <c:forEach var="pageAttribute"   items="${pageInfo.getList()}" varStatus="statu" >
		     
		     <tr id="${pageAttribute.id}" class="tr">
			  <td width="8%">${pageAttribute.id}</td>
			  <td width="8%">${pageAttribute.attributeCode}</td>
			  <td width="8%">${pageAttribute.attributeName}</td>
			  <td width="25%">
			    <c:forEach var="option" items="${pageAttribute.options}" varStatus="statu">
			      <span>${option.optionName}</span>&nbsp;&nbsp;
			    </c:forEach>
			  </td>
			  <td width="15%">${pageAttribute.attributeDescription}</td>	
			  <td width="6%">${pageAttribute.attributeSort}</td>			  			 
			  <td>
			  <fmt:formatDate type="both" value="${pageAttribute.createDate}" dateStyle="default"/> 
			  </td>
			  <td>
			  <fmt:formatDate type="both" value="${pageAttribute.updateDate}" dateStyle="default"/> 			  
			  </td>
			  <td>
			   <a href="javascript:showEdit(${pageAttribute.id},'${pageContext.request.contextPath}/admin/spu/attribute/editAttribute');" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>编辑</span></a>
			   <a href="javascript:deleteByID(${pageAttribute.id},'${pageContext.request.contextPath}/admin/spu/attribute/deleteAttribute');" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span>删除</span></a>			   
			  </td>
			</tr>		   
		   </c:forEach>
		   		
		  </tbody>
		</table>
	   </div>
	   
	   <!--页码-->
	  <%@ include file="/WEB-INF/all/include/pageHelper.jsp"%> 
	</div>   
		
	
  
  
	  <!-- 新增管理员界面弹窗 -->  
	  <div class="modal fade " id="addEntity" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	    <div class="modal-dialog" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="addModalLabel">新增属性</h4>
	        </div>
	        <div class="modal-body">
	          <form id="addForm" action="${pageContext.request.contextPath}/admin/spu/attribute/saveAdd" method="post">
	            <div class="form-group">
	              <label for="recipient-name" class="control-label">名称:</label>
	              <input type="text" class="form-control" id="recipient-name" name="attributeName" placeholder="请输入名称" data-validateUrl="${pageContext.request.contextPath}/admin/spu/attribute/validateAttributeName">
	            </div>
	            <div class="form-group">
	              <label for="attribute-description" class="control-label">描述:</label>
	              <textarea  class="form-control" id="attribute-description" name="attributeDescription" placeholder="关于属性的描述"></textarea>
	            </div>
	          </form>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	          <button type="button" class="btn btn-primary" id="submitAdd">确认</button>
	        </div>
	      </div>
	    </div>
	  </div>	   
	  
  
  </body>
</html>