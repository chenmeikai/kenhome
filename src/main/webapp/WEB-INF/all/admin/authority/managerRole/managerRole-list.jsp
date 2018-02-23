<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>角色分配
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	  
	  <link href="${pageContext.request.contextPath}/resources/css/admin/common.css" rel="stylesheet">
	  
	  <!-- 下拉选择样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/select/bootstrap-select.min.css" rel="stylesheet">
	  
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
	  
	  <!-- 选择框控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/select/bootstrap-select.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/select/defaults-zh_CN.min.js"></script>
	  
	  <!-- dateFormat -->
	  <script src="${pageContext.request.contextPath}/resources/js/dateFormat/dateFormat.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/admin/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			    
			  //验证表单
			  var validateUrl =  $("#recipient-name").attr("data-validateUrl") 
			  $("#addForm").validate({			 
				    rules: {
				        managerId: {
				          required: true		          
				        },
				        roleId: {
				          required: true	
				        }
				     },    
				     messages: {			        
				        managerName: {
				          required: "请输入管理员"
				        },
				        roleName: {
				          required: "请选择角色"			          
				        }
				     },			     
			  });
			 
			  
			 
		       //新增角色分配窗口。动态获得管理员名字
			  //键入字符触发事件:动态获得后台传入select选项数据 
			  
			  //请求的url
			  var selectNameUrl = $("#select-manager").attr("data-selectNameUrl");
			  
			  //选择得到搜索栏的input，松开按键后触发事件
			  $("#select-manager").prev().find('.bs-searchbox').find('input').keyup(function () { 
				  
				  //键入的值
				  var inputManagerName =$('#addForm .open input').val();
				  //判定键入的值不为空，才调用ajax
				  if(inputManagerName != ''){
					  $.ajax({
					        type: 'Get',
					        url: selectNameUrl,
					        data: {                     //要传递的数据
					        	managerName: inputManagerName
			        	    },
					        dataType: "Json",
					        success: function (Selectmanagers) {
					        	//清除select标签下旧的option子标签，根据新获得的数据重新添加option子标签
					        	$("#select-manager").empty();
					            if (Selectmanagers != null) {               
					                $.each(Selectmanagers, function (i,Selectmanager) {
					                    $("#select-manager").append(" <option value=\"" + Selectmanager.id + "\">" + Selectmanager.managerName + "</option>");
					                })
					                //必不可少的刷新
					                $("#select-manager").selectpicker('refresh');
					               
					            }
					        }
					  })
				  }else 
					  //如果输入的字符为空，清除之前option标签
					  $("#select-manager").empty();
				      $("#select-manager").selectpicker('refresh');
				  
			  });	 
			     
		  });
		  
		  
	  </script>
	  
   </head>
   <body>
     <div class="container-fluid">
	   <div class="row common-head">
	     <div class="col-md-2">
		   <span class="common-name">角色分配</span>
		   <span>(</span>
		   <span class="text-success">${pageInfo.getTotal()}</span>
		   <span id="entityNums">位管理员</span>
		   <span>)</span>
		 </div>
		 <div class="col-md-2 pull-right text-right">
		   <a id="showAddWindow" href="javascript:;" class="btn btn-xs btn-info btn-outline-info">
		    <i class="glyphicon glyphicon-plus"></i>
			<span>新增</span>
		   </a>
		   <a id="excel-export" href="javascript:;" data-href="${pageContext.request.contextPath}/admin/authority/managerRole/export?" class="btn btn-xs btn-warning btn-outline-warning ">
		    <i class="glyphicon glyphicon-export"></i>
			<span>导出excel</span>
		   </a>
		 </div>			 
	   </div>
	   
	   <!--搜索栏-->
	   <form id="listForm" class="row common-search" action="${pageContext.request.contextPath}/admin/authority/managerRole/main"  method = "GET">          
	     <div class="col-md-2">
		   <div class="input-group">		 
			  <input type="text" class="form-control reset" placeholder="输入管理员" name="managerName" value="${parames.managerName}">
		   </div>
		 </div>
		 <div class="col-md-2"> 
		   <select class="form-control selectpicker show-tick reset" data-size="6" data-live-search="true"  id="select-role"  name="roleName" title="请选择角色" >       
			   <c:forEach var="selectRole" items="${selectRoles}" varStatus="statu">
			      <option    value ="${selectRole.roleName}" ${parames.roleName==selectRole.roleName ? 'selected="selected"' :''}  >${selectRole.roleName}</option>
			   </c:forEach>
		   </select>
		 </div>
		 <div class="col-md-3">
		   <div class="input-group">		 
			  <input type="text" class="form-control datetimepicker reset" placeholder="创建起始" name="startCreateDate" value="${parames.startCreateDate}" id="oneDate" >
			  <span class="input-group-addon" >到</span>
			  <input type="text" class="form-control datetimepicker reset" placeholder="结束时间" name="endCreateDate" value="${parames.endCreateDate}" id="twoDate" >
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
		 			 	 		
		 <div class="col-md-2 form-group form-inline">	 
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
			  <th>管理员</th>
			  <th>角色</th>
			  <th>是否内置</th>
			  <th>创建时间</th>			  	
			  <th>操作</th>	              			  
			</tr>
		  </thead>
		  <tbody >
		   <c:forEach var="pageManagerRole"   items="${pageInfo.getList()}" varStatus="statu" >
		     
		     <tr id="${pageManagerRole.id}" class="tr">
			  <td>${pageManagerRole.managerName}</td>
			  <td>${pageManagerRole.roleName}</td>
			  <td>${pageManagerRole.isSystem ==1 ? "不内置" : "内置" }</td>
			  <td>
			  <fmt:formatDate type="both" value="${pageManagerRole.createDate}" dateStyle="default"/> 
			  </td>			 
			  <td>
			   <a href="javascript:deleteByID(${pageManagerRole.id},'${pageContext.request.contextPath}/admin/authority/managerRole/delete');" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span>删除</span></a>			   
			  </td>
			</tr>		   
		   </c:forEach>
		   		
		  </tbody>
		</table>
	   </div>
	   
	   <!--页码-->
	  <%@ include file="/WEB-INF/all/include/pageHelper.jsp"%> 
	</div>   
		
	
  
  
	  <!-- 新增角色分配界面弹窗 -->  
	  <div class="modal fade " id="addEntity" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	    <div class="modal-dialog modal-sm" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="addModalLabel">新增角色分配</h4>
	        </div>
	        <div class="modal-body">
	          <form id="addForm" action="${pageContext.request.contextPath}/admin/authority/managerRole/saveAdd" method="post">
	           <div class="form-group">	
	             <div class="input-group">	 
			       <span class="input-group-addon" >管理员</span>
			       <!--触发bootstrap-select需添加class="selectpicker" 搜索功能需添加data-live-search="true" -->
			       <select data-size="6" class="form-control selectpicker show-tick" data-live-search="true" title="请输入管理员"  id="select-manager" name="managerId"  data-selectNameUrl="${pageContext.request.contextPath}/admin/authority/managerRole/getManagerByName" >    
			       </select>
			     </div>
		       </div>
		       <div class="form-group">	
		         <div class="input-group">		 
			       <span class="input-group-addon" >角&nbsp;&nbsp;&nbsp;&nbsp;色</span>
			       <select  class="form-control selectpicker show-tick" data-size="6" data-live-search="true"  id="select-role"  name="roleId" title="请选择角色" >
			            
			          <c:forEach var="selectRole" items="${selectRoles}" varStatus="statu">
			            <option    value ="${selectRole.id}"  >${selectRole.roleName}</option>
			          </c:forEach>
			       </select>
		         </div>
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