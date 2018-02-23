<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>角色中心
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
	  <script src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/validate/validate-extend-method.js"></script>
	  
	  <!-- dateFormat -->
	  <script src="${pageContext.request.contextPath}/resources/js/dateFormat/dateFormat.js"></script>
	  <!-- common  -->
	  <script src="${pageContext.request.contextPath}/resources/js/admin/common.js"></script>
      
	  <script type="text/javascript">
		  $().ready(function(){
			    
			  //验证表单
			  var validateUrl =  $("#recipient-name").attr("data-validateUrl") 
			  $("#addForm").validate({			 
				    rules: {
				        roleName: {
				          required: true,
				          remote: {
				        	    url: validateUrl,           //后台处理请求地址
				        	    type: "get",                //数据发送方式
				        	    dataType: "json",           //接受数据格式   
				        	    data: {                     //要传递的数据
				        	        roleName: function() {
				        	            return $("#recipient-name").val();
				        	        }
				        	    }
				          }
				        },
				        description: {
				          required: true,
				        }
				     },    
				     messages: {			        
				        roleName: {
				          required: "请输入角色名",				  
				          remote: "该角色已存在"
				        },
				        description: {
				          required: "尚未描述该角色",				        
				        }
				     },			     
			   }); 
			     
		  })
		  
		  
			  //编辑role
			  function  editEntity(id,viewUrl){
				  $.ajax({    
	                  type:'get',        
	                  url:viewUrl,    
	                  data:{
	                	  id:id
	                  },    
	                  cache:false,    
	                  dataType:'json',    
	                  success:function(viewRole){   
	                  	 
	                  	$("#editForm [name|='id']").attr("value",viewRole.id);
	                  	$("#editForm [name|='roleName']").attr("value",viewRole.roleName);
	                  	$("#editForm textarea").text(viewRole.description);
	                  	$('#editEntity').modal({
	  					  backdrop: 'static'
	  				    });	
	                  	
	                  },
	                  error:function(){ 
	                  	bootbox.alert("请求失败")
	        		  }
				   });				  			  
			  }
		  
		  
		 
	     

	  </script>
	  
   </head>
   <body>
     <div class="container-fluid">
	   <div class="row common-head">
	     <div class="col-md-2">
		   <span class="common-name">角色中心</span>
		   <span>(</span>
		   <span class="text-success">${pageInfo.getTotal()}</span>
		   <span id="entityNums">位角色</span>
		   <span>)</span>
		 </div>
		 <div class="col-md-2 pull-right text-right">
		   <a id="showAddWindow" href="javascript:;" class="btn btn-xs btn-info btn-outline-info" >
		    <i class="glyphicon glyphicon-plus"></i>
			<span>新增</span>
		   </a>
		   <a id="excel-export" href="javascript:;" data-href="${pageContext.request.contextPath}/admin/authority/role/export?" class="btn btn-xs btn-warning btn-outline-warning ">
		    <i class="glyphicon glyphicon-export"></i>
			<span>导出excel</span>
		   </a>
		 </div>			 
	   </div>
	   
	   <!--搜索栏-->
	   <form id="listForm" class="row common-search form-inline" action="${pageContext.request.contextPath}/admin/authority/role/main"  method = "GET">          
	     <div class="col-md-2">
		   <div class="input-group">		 
			  <input type="text" class="form-control reset" placeholder="输入角色名" name="roleName" value="${parames.roleName}">
		   </div>
		 </div>
		 <div class="col-md-3">
		   <div class="input-group">		 
			  <input type="text" class="form-control datetimepicker reset" placeholder="创建起始" name="startcreateDate" value="${parames.startcreateDate}" id="oneDate" >
			  <span class="input-group-addon" >到</span>
			  <input type="text" class="form-control datetimepicker reset" placeholder="结束时间" name="endcreateDate" value="${parames.endcreateDate}" id="twoDate" >
		   </div>
		 </div>
		
		 <div class="col-md-2">
		   <div class="input-group">		 
			  <span class="input-group-addon" >内置</span>
			  <select  class="form-control reset" name="isSystem" >
			     <option    value =""  >全部</option>
			     <option    value = "2" ${parames.isSystem==2 ? 'selected="selected"' :''} >内置</option>
		         <option    value = "1" ${parames.isSystem==1 ? 'selected="selected"' : ''} >不内置</option>
			  </select>
		   </div>
		 </div>
		 		 			 	 		
		 <div class="col-md-2 form-group  ">	 
			  <input id="formSearch" type="button" class="form-control" value="搜索" >
			  <input id="searchReset" type="button" class="form-control" value="重置">		
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
			  <th>角色</th>
			  <th>角色描述</th>
			  <th>是否内置</th>
			  <th>创建人</th>
			  <th>修改人</th>
			  <th>创建时间</th>
			  <th>修改时间</th>	
			  <th>操作</th>	              			  
			</tr>
		  </thead>
		  <tbody >
		   <c:forEach var="pageRole"   items="${pageInfo.getList()}" varStatus="statu" >
		     
		     <tr id="${pageRole.id}" class="tr">
			  <td>${pageRole.roleName}</td>
			  <td>${pageRole.description}</td>
			  <td>${pageRole.isSystem==2 ? "内置":"不内置"}</td>
			  <td>${pageRole.creater}</td>	
			  <td>${pageRole.updater}</td>			  
			  <td>
			  <fmt:formatDate type="both" value="${pageRole.createDate}" dateStyle="default"/>			  
			  </td>
			  <td>
			  <fmt:formatDate type="both" value="${pageRole.updateDate}" dateStyle="default"/> 
			  </td>			  
			  <td>
			   <a href="javascript:editEntity(${pageRole.id},'${pageContext.request.contextPath}/admin/authority/role/view');" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>编辑</span></a>
			   <a href="javascript:deleteByID(${pageRole.id},'${pageContext.request.contextPath}/admin/authority/role/delete');" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span>删除</span></a>			   
			  </td>
			</tr>		   
		   </c:forEach>
		   		
		  </tbody>
		</table>
	   </div>
	   
	   <!--页码-->
	  <%@ include file="/WEB-INF/all/include/pageHelper.jsp"%> 
	</div>   
		
	
  
  
	  <!-- 新增角色界面弹窗 -->  
	  <div class="modal fade " id="addEntity" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	    <div class="modal-dialog" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="addModalLabel">新增角色</h4>
	        </div>
	        <div class="modal-body">
	          <form id="addForm" action="${pageContext.request.contextPath}/admin/authority/role/saveAdd" method="post">
	            <div class="form-group">
	              <label for="recipient-name" class="control-label">角色名:</label>
	              <input type="text" class="form-control cleanInput" id="recipient-name" name="roleName" placeholder="请输入名字" data-validateUrl="${pageContext.request.contextPath}/admin/authority/role/validateName">
	            </div>
	            <div class="form-group">
	              <label for="message-description" class="control-label">角色描述:</label>
	              <textarea   class="form-control cleanInput" id="message-description" name="description" placeholder="描述角色"></textarea >
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
    
	  
	  <!-- 编辑管理员界面弹窗 -->  
	  <div class="modal fade " id="editEntity" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
	    <div class="modal-dialog" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="editModalLabel">编辑管理员</h4>
	        </div>
	        <div class="modal-body">
	          <form id="editForm" action="${pageContext.request.contextPath}/admin/authority/role/saveEdit" method="post">
	            <input name="id" type="hidden" value=""  readonly="readonly"/>
	            <div class="form-group">
	              <label for="edit-entity-name" class="control-label">角色:</label>
	              <input type="text" class="form-control" id="edit-entity-name" name="roleName" value=""   placeholder="" data-validateUrl="">
	            </div>
	            <div class="form-group">
                  <label for="edit-entity-description" class="control-label">角色描述:</label>
	              <textarea   class="form-control" id="edit-entity-description" name="description"  placeholder=""></textarea >
	            </div>
	          </form>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	          <button type="button" class="btn btn-primary" id="submitedit">确认</button>
	        </div>
	      </div>
	    </div>
	  </div>
	  
  
  </body>
</html>