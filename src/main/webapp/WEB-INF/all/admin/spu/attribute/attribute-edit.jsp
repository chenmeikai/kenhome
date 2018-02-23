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
	    .option-margin{margin-top:30px;}
	    #updateForm{padding:10px;box-shadow: #666 0px 0px 10px;}
	    .option-box{padding:10px;box-shadow: #666 0px 0px 10px;}
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
			    
			  //验证更新表单
			  var validateAttributeUrl =  $("#attribute-name").attr("data-validateUrl");
			  $("#updateForm").validate({			 
				    rules: {
				        attributeName: {
				          required: true,
				          remote: {
				        	    url: validateAttributeUrl,                        
				        	    type: "get",                           
				        	    dataType: "json",                     
				        	    data: {
				        	    	id: function(){return $("#enitAttribute-id").val()},
				        	    	attributeName: function(){return $("#attribute-name").val()}
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
			  
			  
			   //验证新增表单
			  var validateOptionUrl =  $("#option-name").attr("data-validateUrl");
			  $("#addForm").validate({			 
				    rules: {
				        optionName: {
				          required: true,
				          remote: {
				        	    url: validateOptionUrl,     //后台处理请求地址
				        	    type: "get",                //数据发送方式
				        	    dataType: "json",           //接受数据格式   
				        	    data: {                     //要传递的数据
				        	    	attributeId: function() {return $("#validate-attributeId").val();},
				        	        optionName: function() {return $("#option-name").val();}				        	           		        	        
				        	    }
				          }
				        }
				     },				      
				     messages: {			        
				    	 optionName: {
				          required: "属性值不能为空",
				          remote: "该属性值已存在"
				        }
				     }
			   });
			  
			  
			  
			  
			    //验证后，异步提交表单更新Entity，成功后关闭窗口返回结果(编辑的页面)
			    $("#updateEntity").click(function(){
				  addUpdateEntity();
			    });
			     
		  })
		  
		  
		      
		  
			  
			    //需验证，异步提交表单更新Entity，成功后返回结果(编辑的页面)
		        function addUpdateEntity(){	        	
		        	var targetUrl = $("#updateForm").attr("action");			 
		  		    if($("#updateForm").valid()){		    	
		  			    $.ajax({    
		                    type:'post',        
		                    url:targetUrl,    
		                    data:$("#updateForm").serialize(),    
		                    cache:false,    
		                    dataType:'json',    
		                    success:function(data){
		                    	if (data==true){	                    			                    		  
	                   			   bootbox.alert({ message:"添加成功"});                 			                		
		                    	}else
		                    		bootbox.alert("添加失败");	                    	
		                    },
		                    error:function(){ 
		                    	bootbox.alert("请求失败")
		          			}
		  			    })
		  		    }       	
		         }
		  
			    //无需验证，异步提交表单更新属性选项，成功后返回结果(编辑的页面)
		        function updateTargetEntity(targetForm,targetUrl){	
		  			    $.ajax({    
		                    type:'post',        
		                    url:targetUrl,    
		                    data:$("#"+targetForm).serialize(),    
		                    cache:false,    
		                    dataType:'json',    
		                    success:function(data){
		                    	if (data==true){	                    			                    		  
	                 			   bootbox.alert({ message:"修改成功"});                 			                		
		                    	}else
		                    		bootbox.alert("修改失败");	                    	
		                    },
		                    error:function(){ 
		                    	bootbox.alert("请求失败")
		          			}
		  			    })		  		          	
		         }
		 	      
	 
	  </script>
	  
   </head>
   <body>
     <div class="container">   
	   <!--列表-->
	   <div class="row margin-top-15px">
	    <div class="col-md-6 col-md-offset-3">
	      <form id="updateForm" action="${pageContext.request.contextPath}/admin/spu/attribute/saveUpdate" method="post">
            <div class="form-group">
              <input id="enitAttribute-id" name="id" value="${editAttribute.id}" hidden="true" readonly="readonly">
              <label for="attribute-name" class="control-label">名称:</label>
              <input type="text" class="form-control"  id="attribute-name" name="attributeName" value="${editAttribute.attributeName}" placeholder="请输入名称" data-validateUrl="${pageContext.request.contextPath}/admin/spu/attribute/validateAttributeName2">
            </div>
            <div class="form-group">
              <label for="attribute-description" class="control-label">描述:</label>
              <textarea  class="form-control" rows="6" id="attribute-description" name="attributeDescription" placeholder="关于属性的描述">${editAttribute.attributeDescription}</textarea>
            </div>
            <div class="form-group">
              <label for="recipient-name" class="control-label">序号:</label>
              <input type="text" class="form-control" id="attribute-sort" name="attributeSort" value="${editAttribute.attributeSort}" placeholder="请输入序号">
            </div>  
            <div class="text-right">
              <button id="updateEntity" data-updateUrl="${pageContext.request.contextPath}/admin/spu/attribute/saveUpdate" type="button" class="btn btn-primary">修改</button>
            </div>         
          </form>
          
          <div class="option-margin"></div>	      
          <div class="form-group option-box">
             <label  class="control-label">选项:</label>             
		     <div class="pull-right text-right">
			   <a id="showAddWindow" href="javascript:;" class="btn btn-xs btn-info btn-outline-info">
			     <i class="glyphicon glyphicon-plus"></i>
				 <span>新增</span>
			   </a>
			  </div>	
		    <table class="table table-hover table-striped">
			  <thead class="">
				<tr >
				  <th class="text-center">属性值</th>
				  <th class="text-center">序号</th>
				  <th class="text-center">操作</th>	              			  
				</tr>
			  </thead>
			  <tbody >
			    <c:forEach var="option"   items="${editAttribute.options}" varStatus="statu" >
			      <form id="option-${option.id}" action="${pageContext.request.contextPath}/admin/spu/attribute/saveUpdateOption" method="post">
			        <input type="text" name="id" value="${option.id}" hidden="true" readonly="readonly"/>
				      <tr id="${option.id}" class="tr">
					   <td width="35%"><input type="text" class="form-control"   name="optionName" value="${option.optionName}" placeholder="请输入属性名"></td>
					   <td width="35%"><input type="text" class="form-control"   name="optionSort" value="${option.optionSort}" placeholder="请输入序号"></td>
					   <td >
					    <a href="javascript:updateTargetEntity('option-${option.id}','${pageContext.request.contextPath}/admin/spu/attribute/saveUpdateOption');" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>保存</span></a>
					    <a href="javascript:deleteByID(${option.id},'${pageContext.request.contextPath}/admin/spu/attribute/deleteOption');" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span>删除</span></a>			   
					   </td>
					  </tr>
				  </form> 		   
			    </c:forEach>		   		
			   </tbody>
			 </table>
		  </div>
	    </div>
	  </div>   	
	</div>   
	
	<!-- 新增管理员界面弹窗 -->  
	  <div class="modal fade " id="addEntity" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	    <div class="modal-dialog" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="addModalLabel">新增属性值</h4>
	        </div>
	        <div class="modal-body">
	          <form id="addForm" action="${pageContext.request.contextPath}/admin/spu/attribute/saveAddOption" method="post">
	            <input id="validate-attributeId" type="text" name="attributeId" value="${editAttribute.id}" hidden="true" readonly="readonly"/>
	            <div class="form-group">
	              <label for="option-name" class="control-label">名称:</label>
	              <input type="text" class="form-control cleanInput" id="option-name" name="optionName" placeholder="请输入名称" data-validateUrl="${pageContext.request.contextPath}/admin/spu/attribute/validateOptionName">
	            </div>
	            <div class="form-group">
	              <label for="option-sort" class="control-label">序号:</label>
	              <input  class="form-control cleanInput" id="option-sort" name="optionSort" placeholder="属性值序号"/>
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