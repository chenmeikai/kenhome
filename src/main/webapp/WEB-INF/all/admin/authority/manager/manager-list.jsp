<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>管理员中心
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
	    .single-message-padding{padding-top:0;background-color:rgba(219, 225, 223, 0.15);}
	    .single-message-left{padding:0 0 ;margin-top:10px;margin-left:15px;}
	    .single-message-img{box-shadow: 0px 1px 5px #888888;}
	    .single-message-id{box-shadow: 0px 1px 5px #888888;background-color:white;margin-top:10px;padding-top:10px;padding-left:10px;}
	    .single-message-right{background-color:white;box-shadow: 0px 1px 5px #888888;margin-top:10px;margin-left:15px;}
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
			  var validateUrl =  $("#recipient-name").attr("data-validateUrl") 
			  $("#addForm").validate({			 
				    rules: {
				        managerName: {
				          required: true,
				          minlength:2,
				          remote: {
				        	    url: validateUrl,           //后台处理请求地址
				        	    type: "get",                //数据发送方式
				        	    dataType: "json",           //接受数据格式   
				        	    data: {                     //要传递的数据
				        	        managerName: function() {
				        	            return $("#recipient-name").val();
				        	        }
				        	    }
				          }
				        },
				        password: {
				          required: true,
				          minlength: 8,
				          isPwdOne:true
				        }
				     },    
				     messages: {			        
				        managerName: {
				          required: "请输入用户名",
				          minlength: "用户名不得小于2个字",
				          remote: "该管理员名已存在"
				        },
				        password: {
				          required: "请输入密码",
				          minlength: "密码长度不能小于 8 个字"
				        }
				     },			     
			   });
			  
			  
			 
			     
		  })
		  
		  
		      //查看Manager详情
			  function  viewEntity(id,viewUrl){
				  $.ajax({    
	                  type:'get',        
	                  url:viewUrl,    
	                  data:{
	                	  id:id
	                  },    
	                  cache:false,    
	                  dataType:'json',    
	                  success:function(viewManager){   
	                  	 
	                	  var roleNames ="";
	                	  //遍历获得角色名
	                  	  $.each(viewManager.roles, function(key, role) {
	                  	  	   var roleName = role.roleName+" ";
	                  	       roleNames = roleNames+roleName;                  		 
	                  	 })
	                  	$("#single-message [data-name|='avatar']").attr("src",viewManager.avatar);
	                  	$("#single-message [data-name|='id']").text(viewManager.id);
	                  	$("#single-message [data-name|='roleNames']").text(roleNames);
	                  	$("#single-message [data-name|='managerName']").text(viewManager.managerName);
	                  	$("#single-message [data-name|='nickname']").text(viewManager.nickname);
	                  	$("#single-message [data-name|='email']").text(viewManager.email);
	                  	$("#single-message [data-name|='isEnable']").text(viewManager.isEnable ==1 ? "不启用":"启用");
	                  	$("#single-message [data-name|='isLocked']").text(viewManager.isLocked ==1 ? "不锁定" : "锁定");
	                  	$("#single-message [data-name|='isForver']").text(viewManager.isForver ==1 ? "不内置" : "内置");           	
	                    $("#single-message [data-name|='loginTime']").text(viewManager.loginTime == null ? "": dateFormat(viewManager.loginTime,'yyyy-mm-dd HH:MM:ss'));
	                 	$("#single-message [data-name|='createDate']").text(viewManager.createDate == null ? "" : dateFormat(viewManager.createDate,'yyyy-mm-dd HH:MM:ss'));
	                  	$("#single-message [data-name|='updateDate']").text(viewManager.upateDate == null ? ""  :dateFormat(viewManager.upateDate,'yyyy-mm-dd HH:MM:ss'));               	 
	                  },
	                  error:function(){ 
	                  	bootbox.alert("请求失败")
	        			}
				   });
				  $('#viewEntity').modal({
					  backdrop: 'static'
				  });				  
			  }
		      
		  
			  //编辑manager
			  function  editEntity(id,viewUrl){
				  $.ajax({    
	                  type:'get',        
	                  url:viewUrl,    
	                  data:{
	                	  id:id
	                  },    
	                  cache:false,    
	                  dataType:'json',    
	                  success:function(viewManager){   
	                	  
	                  	$("#editForm [name|='id']").attr("value",viewManager.id);
	                  	$("#editForm [name|='managerName']").attr("value",viewManager.managerName);
	                  	$("#editForm [data-radio|='"+viewManager.isEnable+"']").attr("checked","true");

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
		   <span class="common-name">会员中心</span>
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
		   <a id="excel-export" href="javascript:;" data-href="${pageContext.request.contextPath}/admin/authority/manager/export?" class="btn btn-xs btn-warning btn-outline-warning ">
		    <i class="glyphicon glyphicon-export"></i>
			<span>导出excel</span>
		   </a>
		 </div>			 
	   </div>
	   
	   <!--搜索栏-->
	   <form id="listForm" class="row common-search form-inline" action="${pageContext.request.contextPath}/admin/authority/manager/main"  method = "GET">          	 
		  <div class=" col-md-2">		 
			  <input type="text" class="form-control reset" placeholder="管理员" name="managerName" value="${parames.managerName}">
		  </div>
		
		  <div class="input-group col-md-3">		 
			  <input type="text" class="form-control datetimepicker reset" placeholder="注册起始" name="startLoginTime" value="${parames.startLoginTime}" id="oneDate" >
			  <span class="input-group-addon" >到</span>
			  <input type="text" class="form-control datetimepicker reset" placeholder="结束时间" name="endLoginTime" value="${parames.endLoginTime}" id="twoDate" >
		  </div>
			
		  <div class="input-group col-md-2">		 
			  <span class="input-group-addon" >锁定</span>
			  <select  class="form-control reset" name="isLocked" >
			     <option    value =""  >全部</option>
			     <option    value = "2" ${parames.isLocked==2 ? 'selected="selected"' :''} >锁定</option>
		         <option    value = "1" ${parames.isLocked==1 ? 'selected="selected"' : ''} >不锁定</option>
			  </select>
		  </div>
				
		  <div class="input-group col-md-2">		 
			  <span class="input-group-addon" >启用</span>
			  <select  class="form-control reset" name="isEnable">
			     <option    value =""  >全部</option>
			     <option    value = "2"  ${parames.isEnable==2 ? 'selected="selected"' :''} >启用</option>
		         <option    value = "1" ${parames.isEnable==1 ? 'selected="selected"' :''} >不启用</option>
			  </select>
		  </div>
		
		  <div class="input-group col-md-2">		 
			  <span class="input-group-addon" >内置</span>
			  <select  class="form-control reset" name="isForver" >
			     <option    value ="" >全部</option>
			     <option    value = "2" ${parames.isForver eq 2 ? 'selected="selected"' :null}>内置</option>
		         <option    value = "1" ${parames.isForver eq 1 ? 'selected="selected"' :null}  >不内置</option>
			  </select>
		  </div>			 	 		
		  <div class="col-md-2 form-group form-search ">	 
			  <input id="formSearch" type="button" class="form-control" value="搜索" >
			  <input id="searchReset" type="button" class="form-control" value="重置">		
	      </div>
		  
		 <!-- 隐藏 -->
		 <input type="text" hidden="hidden" id="currentPage" name="currentPage" value="1" />
		 	 
	   </form>
	   
	   <!--分割线-->
	   <div class="row cut-line">
	     
	   </div>
	   
	   <!--列表-->
	   <div class="row margin-top-15px">
	     <table class="table table-bordered table-hover table-striped">
		  <thead class="imformation-thead">
			<tr>
			  <th>名称</th>
			  <th>邮箱</th>
			  <th>锁定</th>
			  <th>启用</th>
			  <th>内置</th>
			  <th>登录IP</th>	
			  <th>登录时间</th>				  
			  <th>创建日期</th>	
			  <th>更新日期</th>	
			  <th>操作</th>	              			  
			</tr>
		  </thead>
		  <tbody >
		   <c:forEach var="pageManager"   items="${pageInfo.getList()}" varStatus="statu" >
		     
		     <tr id="${pageManager.id}" class="tr">
			  <td>${pageManager.managerName}</td>
			  <td>${pageManager.email}</td>
			  <td>${pageManager.isLocked==2 ? "锁定":"不锁定"}</td>
			  <td>${pageManager.isEnable==2 ? "启用":"不启用"}</td>
			  <td>${pageManager.isForver==2 ? "内置":"不内置"}</td>	
			  <td>${pageManager.loginIp}</td>			  
			  <td>
			  <fmt:formatDate type="both" value="${pageManager.loginTime}" dateStyle="default"/>			  
			  </td>

			  <td>
			  <fmt:formatDate type="both" value="${pageManager.createDate}" dateStyle="default"/> 
			  </td>
			  <td>
			  <fmt:formatDate type="both" value="${pageManager.updateDate}" dateStyle="default"/> 			  
			  </td>
			  <td>
			   <a href="javascript:viewEntity(${pageManager.id},'${pageContext.request.contextPath}/admin/authority/manager/view');" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-book"></i>&nbsp;<span>查看</span></a>
			   <a href="javascript:editEntity(${pageManager.id},'${pageContext.request.contextPath}/admin/authority/manager/view');" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>编辑</span></a>
			   <a href="javascript:deleteByID(${pageManager.id},'${pageContext.request.contextPath}/admin/authority/manager/delete');" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span>删除</span></a>			   
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
	          <h4 class="modal-title" id="addModalLabel">新增管理员</h4>
	        </div>
	        <div class="modal-body">
	          <form id="addForm" action="${pageContext.request.contextPath}/admin/authority/manager/saveAdd" method="post">
	            <div class="form-group">
	              <label for="recipient-name" class="control-label">名字:</label>
	              <input type="text" class="form-control cleanInput" id="recipient-name" name="managerName" placeholder="请输入名字" data-validateUrl="${pageContext.request.contextPath}/admin/authority/manager/validateName">
	            </div>
	            <div class="form-group">
	              <label for="message-password" class="control-label">密码:</label>
	              <input type="text" class="form-control cleanInput" id="message-password" name="password" placeholder="密码不得为纯字母或纯数字，不得少于8位"></input>
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
  
      <!-- 查看某个管理员界面弹窗 -->
      <div class="modal fade" id="viewEntity" tabindex="-1" role="dialog" aria-labelledby="viewModalLabel">
	    <div class="modal-dialog" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title text-center text-info" id="viewModalLabel">管理员详情</h4>
	        </div>
	        <div class="modal-body single-message-padding">
	         <div id="single-message" class="row ">
	           <div class="col-md-4 single-message-left">
	             <img data-name="avatar" class="img-responsive single-message-img" alt="头像" src="${pageContext.request.contextPath}/resources/image/avatar/avatar.jpg">
	             <div class="single-message-id">
	                <h5 class="">
	                 <span class="text-info">ID</span>
	                 <span>：</span>
	                 <span class="text-success" data-name="id"></span>
	                </h5>
	                <hr>	 
	                <h5 class="">
	                 <span class="text-info">角色</span>
	                 <span>：</span>
	                <span class="text-success" data-name="roleNames"></span>
	               </h5>
	               <hr>	
	               <h5 class="">
	                 <span class="text-info">名字</span>
	                 <span>：</span>
	                 <span class="text-success" data-name="managerName"></span>
	               </h5>
	               <hr>	 
	               <h5 class="">
	                 <span class="text-info">昵称</span>
	                 <span>：</span>
	                 <span class="text-success" data-name="nickname"></span>
	               </h5>
	               <hr>	 
	               
	             </div>
	           </div>
	           <div class="col-md-7 single-message-right">
	              
	               <h5 class="">
	                 <span class="text-info">邮箱</span>
	                 <span>：</span>
	                 <span class="text-success" data-name="email"></span>
	               </h5>
	               <hr>	 
	               <h5 class="">
	                 <span class="text-info">启用</span>
	                 <span>：</span>
	                 <span class="text-success" data-name="isEnable">启用</span>
	               </h5>
	               <hr>	 
	               <h5 class="">
	                 <span class="text-info">锁定</span>
	                 <span>：</span>
	                 <span class="text-success" data-name="isLocked">不锁定</span>
	               </h5>
	               <hr>	
	               <h5 class="">
	                 <span class="text-info">内置</span>
	                 <span>：</span>
	                 <span class="text-success" data-name="isForver"></span>
	               </h5>
	               <hr>	
	               <h5 class="">
	                 <span class="text-info">登录</span>
	                 <span>：</span>
	                 <span class="text-success" data-name="loginTime"></span>
	               </h5>
	               <hr>	
	               <h5 class="">
	                 <span class="text-info">创建</span>
	                 <span>：</span>
	                 <span class="text-success" data-name="createDate"></span>
	               </h5>
	               <hr>	
	               <h5 class="">
	                 <span class="text-info">修改</span>
	                 <span>：</span>
	                 <span class="text-success" data-name="updateDate"></span>
	               </h5>
	               <hr>	         
	            </div>	            
	         </div>   
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        </div>
	      </div>
	    </div>
	  </div>
	  
	  
	  <!-- 编辑管理员界面弹窗 -->  
	  <div class="modal fade " id="editEntity" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
	    <div class="modal-dialog modal-sm" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="editModalLabel">编辑管理员</h4>
	        </div>
	        <div class="modal-body">
	          <form id="editForm" action="${pageContext.request.contextPath}/admin/authority/manager/saveEdit" method="post">
	            <input name="id" type="hidden" value=""  readonly="readonly"/>
	            <div class="form-group">
	              <label for="edit-entity-name" class="control-label">名字:</label>
	              <input type="text" class="form-control" id="edit-entity-name" name="managerName" value="" readonly="readonly"  placeholder="" data-validateUrl="">
	            </div>
	            <div class="form-group">
	              <input type="radio" data-radio="2" name="isEnable" value="2" /> 启用<br />
                  <input type="radio" data-radio="1" name="isEnable" value="1" /> 不启用<br />
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