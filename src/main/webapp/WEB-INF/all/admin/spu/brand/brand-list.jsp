<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>品牌管理
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	  
	  <!--时间控件-->
	  <link href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.css" rel="stylesheet">
	  
	  <!-- 验证样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/validate/validate.css" rel="stylesheet">
	  
	  <!-- 上传样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/fileinput/bootstrap-fileinput.min.css" rel="stylesheet">
	 
	  <!-- common -->
	   <link href="${pageContext.request.contextPath}/resources/css/admin/common.css" rel="stylesheet">
	  
	  <style type="text/css">
        .brand-style{border:1px solid #c7c9d4;border-radius:5px;background-color:#1b85ad;padding:5px;color:white;}
        #showEntityplace li{padding-top:50px;padding-bottom:5px;}
        .entity-each-param{height:65px;}
        .border-hide{border:0;}
        .entity-param-picture{width:100px;height:auto;}
	    .param-name{color:#0b0f30;}
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
	  
	  <!-- 上传控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/fileinput/bootstrap-fileinput.min.js"></script>
	  <!-- extend 中文 -->
	  <script src="${pageContext.request.contextPath}/resources/js/fileinput/fileinput-zh.js"></script>
	  
	  <!-- dateFormat -->
	  <script src="${pageContext.request.contextPath}/resources/js/dateFormat/dateFormat.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/admin/common.js"></script>
	  
	 
	  
       
	  <script type="text/javascript">
		  $().ready(function(){
			    
			  //验证新增表单
			  var validateUrl =  $("#brand-name").attr("data-validateUrl") 
			  $("#addForm").validate({			 
				    rules: {
				        brandName: {
				          required: true,		          
				          remote: {
				        	    url: validateUrl,           //后台处理请求地址
				        	    type: "get",                //数据发送方式
				        	    dataType: "json",           //接受数据格式   
				        	    data: {                     //要传递的数据
				        	        brandName: function() {
				        	            return $("#brand-name").val();
				        	        }
				        	    }
				          }
				        }
				     },    
				     messages: {			        
				        brandName: {
				          required: "请输入品牌名",
				          remote: "该品牌名已存在"
				        }				        
				     }				     
			   });
			  
			  
			 //验证修改表单
			  var validateEditUrl =  $("#brand-editName").attr("data-validateUrl") 
			  $("#editForm").validate({			 
				    rules: {
				        brandName: {
				          required: true,		          
				          remote: {
				        	    url: validateEditUrl,           //后台处理请求地址
				        	    type: "get",                //数据发送方式
				        	    dataType: "json",           //接受数据格式   
				        	    data: {                     //要传递的数据
				        	        brandName: function() {
				        	            return $("#brand-name").val();
				        	        },
				        	        id       :$("#brand-editId").val()
				        	    }
				          }
				        }
				     },    
				     messages: {			        
				        brandName: {
				          required: "请输入品牌名",
				          remote: "该品牌名已存在"
				        }				        
				     }				     
			   });
			  
			 
			  <!--logo上传组件初始化-->			  
			  $("#brand-logo").fileinput({
					language: 'zh',
			        showUpload: false,
			        maxFileCount: 10,
			        maxFileSize:2048,  //单位为KB
			        allowedFileExtensions: ['jpg', 'bmp', 'jpeg','png','webp'],//接收的文件后缀
			  });
			  		
			 
			     
		  })
		  
		  
		      //查看品牌详情
			  function  viewEntity(id,viewUrl){
				   
			       var targetUrl = viewUrl+"?id="+id;
			       $("#viewPlace").load(targetUrl+" #showEntityplace",function(){
			    	   
			    	   
			       })
		                  	  
		           $('#viewEntity').modal({
		    		   backdrop: 'static'     	  
		           });    	                  
			  }
		  
		     //查看编辑品牌
			  function  viewEditEntity(id,viewEditUrl){
				   
			       var targetUrl = viewEditUrl+"?id="+id;
			       $("#viewPlaceEdit").load(targetUrl+" #showEntityplaceEdit",function(){
			    	    //初始化上传控件
			    	    $("#brand-editlogo").fileinput({
							language: 'zh',
					        showUpload: false,
					        maxFileCount: 10,
					        maxFileSize:2048,  //单位为KB
					        allowedFileExtensions: ['jpg', 'bmp', 'jpeg','png'],//接收的文件后缀
					    });
			    	   
			       })
		                  	  
		           $('#editEntity').modal({
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
		   <span class="common-name">品牌管理</span>
		   <span>(</span>
		   <span class="text-success">${pageInfo.getTotal()}</span>
		   <span id="entityNums">个品牌</span>
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
	   <form id="listForm" class="row common-search" action="${pageContext.request.contextPath}/admin/spu/brand/main"  method = "GET">          
	     <div class="col-md-2">
		   <div class="input-group">		 
			  <input type="text" class="form-control reset" placeholder="品牌名" name="brandName" value="${params.brandName}">
		   </div>
		 </div>
		 <div class="col-md-2">
		   <div class="input-group">		 
			  <span class="input-group-addon" >启用</span>
			  <select  class="form-control reset" name="statu">
			     <option    value =""  >全部</option>
			     <option    value = "2"  ${params.statu==2 ? 'selected="selected"' :''} >启用</option>
		         <option    value = "1" ${params.statu==1 ? 'selected="selected"' :''} >不启用</option>
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
			  <th>Logo</th>
			  <th>品牌名</th>	
			  <th>介绍</th>			 	
			  <th>是否启用</th>				  
			  <th>排序</th>							 	
			  <th>操作</th>	              			  
			</tr>
		  </thead>
		  <tbody >
		   <c:forEach var="pageBrand"   items="${pageInfo.getList()}" varStatus="statu" >
		     
		     <tr id="${pageBrand.id}" class="tr">
			  <td class="">
			    <img src="${pros.fictitiousRoot}${pageBrand.logo}" class="img-rounded img-responsive image-head ">
			  </td>
			  <td class="text-center" ><div class="brand-style">${pageBrand.brandName}</div></td>
			  <td>${pageBrand.description}</td>			  		
			  <td>${pageBrand.statu==2 ? "启用":"不启用"}</td>
			  <td>${pageBrand.sort}</td>							  			 			  
			  <td>
			   <a href="javascript:viewEntity(${pageBrand.id},'${pageContext.request.contextPath}/admin/spu/brand/view');" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-book"></i>&nbsp;<span>查看</span></a>
			   <a href="javascript:viewEditEntity(${pageBrand.id},'${pageContext.request.contextPath}/admin/spu/brand/viewEditBrand');" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>编辑</span></a>
			   <a href="javascript:deleteByID(${pageBrand.id},'${pageContext.request.contextPath}/admin/spu/brand/delete');" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span>删除</span></a>			   
			  </td>
			</tr>		   
		   </c:forEach>
		   		
		  </tbody>
		</table>
	   </div>
	   
	   <!--页码-->
	  <%@ include file="/WEB-INF/all/include/pageHelper.jsp"%> 
	</div>   
		
	
  
  
	  <!-- 新增品牌界面弹窗 -->  
	  <div class="modal fade " id="addEntity" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	    <div class="modal-dialog" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="addModalLabel">新增品牌</h4>
	        </div>
	        <div class="modal-body">
	          <form id="addForm" action="${pageContext.request.contextPath}/admin/spu/brand/saveAdd" method="post" enctype="multipart/form-data">
	            <div class="form-group">
	              <label for="brand-name" class="control-label">品牌中文名:</label>
	              <input type="text" class="form-control cleanInput" id="brand-name" name="brandName" placeholder="请输入品牌名" data-validateUrl="${pageContext.request.contextPath}/admin/spu/brand/validateName">
	            </div>
	            <div class="form-group">
	              <label for="brand-enName" class="control-label">品牌英文名:</label>
	              <input type="text" class="form-control cleanInput" id="brand-enName" name="enName" placeholder="请输入品牌英文名"></input>
	            </div>
	            <div class="form-group">
	              <label for="brand-aliasName" class="control-label">品牌别名:</label>
	              <input type="text" class="form-control cleanInput" id="brand-aliasName" name="aliasName" placeholder="请输入品牌别名，以分号间隔"></input>
	            </div>
	            <div class="form-group">
	              <label for="brand-logo" class="control-label">品牌logo:</label>
	              <input type="file"  class="cleanInput file-loading" id="brand-logo" name="logo"/>
	            </div>
	            <div class="form-group">
	              <label for="brand-description" class="control-label">品牌介绍:</label>
	              <textarea class="form-control cleanInput" id="brand-description" name="description" placeholder="请简短介绍品牌"></textarea>
	            </div>
	            <div class="form-group" style="margin-top:30px;">
	               <div class="input-group">		 
					  <span class="input-group-addon" >启用</span>
					  <select  class="form-control reset" name="statu" title="请选择是否启用">	     
					     <option    value = "2"  ${params.statu==2 ? 'selected="selected"' :''} >启用</option>
				         <option    value = "1" ${params.statu==1 ? 'selected="selected"' :''} >不启用</option>
					  </select>
				   </div>
	            </div>  	                   
	          </form>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	          <button type="button" class="btn btn-primary" id="submitAddWithFile">确认</button>
	        </div>
	      </div>
	    </div>
	  </div>	 
  
      <!-- 查看某个品牌界面弹窗 -->
      <div class="modal fade" id="viewEntity" tabindex="-1" role="dialog" aria-labelledby="viewModalLabel">
	    <div class="modal-dialog" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title text-center text-info" id="viewModalLabel">品牌详情</h4>
	        </div>
	        <div id="viewPlace" class="modal-body">
	          
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        </div>
	      </div>
	    </div>
	  </div>
	  
	  
	  <!-- 编辑品牌界面弹窗 -->  
	  <div class="modal fade " id="editEntity" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
	    <div class="modal-dialog" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="editModalLabel">编辑品牌</h4>
	        </div>
	        <div class="modal-body">
	          <div id="viewPlaceEdit">
	          
	          </div>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	          <button type="button" class="btn btn-primary" id="submiteditWithFile">确认</button>
	        </div>
	      </div>
	    </div>
	  </div>
	  
  
  </body>
</html>