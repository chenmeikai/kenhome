<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>分类编辑
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- tree样式 --> 
      <link href="${pageContext.request.contextPath}/resources/css/tree/tree.css" rel="stylesheet">	  
	   <!-- 验证样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/validate/validate.css" rel="stylesheet">	
	  <!-- 下拉选择样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/select/bootstrap-select.min.css" rel="stylesheet">
	  <!-- 滚动条样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/scroll/scroll.css" rel="stylesheet">  
	 
	  <style type="text/css">
	    .categoryAttr-memo{margin-top:50px;}
	    .tab-content{margin-top:30px;}	    
	    .table-whenhover tr:hover{background-color:#c7d5f4;}
	  </style>

      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
      <!-- 选择框控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/select/bootstrap-select.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/select/defaults-zh_CN.min.js"></script>
	  <!-- 表单验证控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
	  <!-- extend validate-method -->
	  <script src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
     
	  
	  <script type="text/javascript">
		  $().ready(function(){
			  //验证更新表单
			  $("#baseForm").validate({			 
				    rules: {
				    	categoryName: {
				          required: true
				        }
				     },    
				     messages: {			        
				    	 categoryName: {
				          required: "不能为空"				     
				        }
				     }
			   });
			   
			  //验证新增子类表单
			  $("#sonForm").validate({			 
				    rules: {
				    	categoryName: {
				          required: true
				        }
				     },    
				     messages: {			        
				    	 categoryName: {
				          required: "不能为空"				     
				        }
				     }
			   });
			  
			
			  //更新分类
			  $("#updateCategory").click(function(){
				   
				    var targetUrl = $(this).attr("data-updateUrl");
				    var inputDate = $('#baseForm').serialize();
				    if($("#baseForm").valid()){	  		    	
		  			    $.ajax({    
		                    type:'post',        
		                    url:targetUrl,    
		                    data:inputDate,        
		                    dataType:'json',    
		                    success:function(data){
		                    	if (data==true){		                    				                    		   
		                    		bootbox.alert({
		                    		   message:"修改成功"		                    			                 			             
		                    		});		                    		        		
		                    	}else
		                    		bootbox.alert("修改失败");
		                    },
		                    error:function(){ 
		                    	bootbox.alert("请求失败")
		          			}
		  			    });	
				     }    
			    });
			  
			  //删除分类
			  $("#deleteCategory").click(function(){
				  
				  bootbox.confirm({
	                    title : "请确认",
	                    buttons: {
	                        confirm:{
	                            label:'确认',
	                            className:'btn-primary'
	                        },
	                        cancel:{
	                            label:'取消',
	                            className:'btn-default'
	                        }
	                    },
	                    message:'确定删除该分类？',
	                    callback:function(result){
	                    	if(result){        			
	                    		var targetUrl = $("#deleteCategory").attr("data-deleteUrl");
	        				    var deleteId = $("#categoryId").val();	  		    	
	        	  			    $.ajax({    
	        	                    type:'get',        
	        	                    url:targetUrl,    
	        	                    data:{id:deleteId},        
	        	                    dataType:'json',    
	        	                    success:function(data){
	        	                    	if (data==true){		                    				                    		   
	        	                    		bootbox.alert({
	        	                    		   message:"删除成功"		                    			                 			             
	        	                    		});		                    		        		
	        	                    	}else
	        	                    		bootbox.alert("删除失败");
	        	                    },
	        	                    error:function(){ 
	        	                    	bootbox.alert("请求失败")
	        	          			}
	        	  			    });	   
	                		}else{
	                			return ;
	                		}
	                    },
	                   className:"bootbox-sm"
	              });		  			  
			   });
			  
			  //新增子类
			  $("#addCategory").click(function(){
				  var targetUrl = $(this).attr("data-addUrl");
				  var inputDate = $('#sonForm').serialize();
				  if($("#sonForm").valid()){	  		    	
		  			    $.ajax({    
		                    type:'post',        
		                    url:targetUrl,    
		                    data:inputDate,        
		                    dataType:'json',    
		                    success:function(data){
		                    	if (data==true){		                    				                    		   
		                    		bootbox.alert({
		                    		   message:"新增成功，如需查看请刷新页面"		                    			                 			             
		                    		});		                    		        		
		                    	}else
		                    		bootbox.alert("新增失败");
		                    },
		                    error:function(){ 
		                    	bootbox.alert("请求失败")
		          			}
		  			    });	
				   }
			   });
			  
			  //添加属性窗口
			  $("#showAddWindow").click(function(){
				  $("#addEntity").modal();
			  });
			  //添加品牌窗口
			  $("#showAddWindow2").click(function(){
				  $("#addEntity2").modal();
			  });
			  //添加属性
			  $("#submitAdd").click(function(){	
				  $("#addEntity").modal("hide");
				  var targetUrl = $("#addForm").attr("action");
				  var inputDate = $('#addForm').serialize();				 	  		    	
		  			    $.ajax({    
		                    type:'post',        
		                    url:targetUrl,    
		                    data:inputDate,        
		                    dataType:'json',    
		                    success:function(data){
		                    	if (data==true){		                    				                    		   
		                    		bootbox.alert({
		                    		   message:"新增成功，如需查看请刷新页面"		                    			                 			             
		                    		});		                    		        		
		                    	}else
		                    		bootbox.alert("新增失败");
		                    },
		                    error:function(){ 
		                    	bootbox.alert("请求失败")
		          			}
		  			    });					        
			   });	
			   //添加品牌
			  $("#submitAdd2").click(function(){	
				  $("#addEntity2").modal("hide");
				  var targetUrl = $("#addForm2").attr("action");
				  var inputDate = $('#addForm2').serialize();				  	  		    	
		  			    $.ajax({    
		                    type:'post',        
		                    url:targetUrl,    
		                    data:inputDate,        
		                    dataType:'json',    
		                    success:function(data){
		                    	if (data==true){		                    				                    		   
		                    		bootbox.alert({
		                    		   message:"新增成功，如需查看请刷新页面"		                    			                 			             
		                    		});		                    		        		
		                    	}else
		                    		bootbox.alert("新增失败");
		                    },
		                    error:function(){ 
		                    	bootbox.alert("请求失败")
		          			}
		  			    });					   	      
			   });	
			  
		  });
		  
	     //异步提交表单更新属性选项，成功后返回结果(编辑的页面)
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
	     
          /**
           * 删除记录
           * @param id
           * @param deleteUrl
           * @returns
           */
          function deleteByID(id,deleteUrl){
          		
          	bootbox.confirm({
                      title : "请确认",
                      buttons: {
                          confirm:{
                              label:'确认',
                              className:'btn-primary'
                          },
                          cancel:{
                              label:'取消',
                              className:'btn-default'
                          }
                      },
                      message:'是否确定删除信息？',
                      callback:function(result){
                      	if(result){        			
                  			$.ajax({ 
  	                  			  type:'get', 
  	                  			  url:deleteUrl, 
  	                  			  data:{"id":id},
  	                  			  success:function(data){
  	                  				 switch (data) {                            
  	                                   case ("false"):
  	                                	     setTimeout(function () {bootbox.alert("删除失败")}, 500);
  	                                         break; 	                                   
  	                                   default:
  	                                	 $('#'+id).fadeTo("slow", 0.01, function(){//fade
  	                         				  $(this).slideUp(150, function() {//slide up
  	                         				    $(this).remove();//then remove from the DOM
  	                         				  });
  	                         			 });
  	                                 }                  			    	
  	                  			  },  
  	                  			  error:function(){ 
  	                  				setTimeout(function () {bootbox.alert("请求失败")}, 500);
  	                  			    
  	                  			  } 
                    			}); 
                  			
                  		}else{
                  			return ;
                  		}
                      },
                     className:"bootbox-sm"
               });		
            }
          
	     
		   
	  </script>
	  
   </head>
   <body>  
    <div class="container-fluid" id="loadContext">
      <div class="categoryAttr-memo"><span class="label label-danger">${btcCategorys.categoryName}</span></div>
      <div class="row">
        <div class="col-md-12">
           <div>
			  <ul class="nav nav-tabs" role="tablist">
			    <li role="presentation" class="active"><a href="#baseNode" aria-controls="baseNode" role="tab" data-toggle="tab">分类</a></li>
			    <li role="presentation"><a href="#attributeNode" aria-controls="nodeList" role="tab" data-toggle="tab">属性</a></li>
			    <li role="presentation"><a href="#brandNode" aria-controls="brandNode" role="tab" data-toggle="tab">品牌</a></li>
			    <li role="presentation"><a href="#sonNode" aria-controls="sonNode" role="tab" data-toggle="tab">子类</a></li>			    
			  </ul>	  
			  <div class="tab-content">
			    <div role="tabpanel" class="tab-pane active" id="baseNode">
                    <form id="baseForm">
                      <input id="categoryId" name="id" value="${btcCategorys.id}" readonly="readonly" hidden="true"/>
			          <div class="form-group">
			            <label for="categoryName" class="control-label">分类名称:</label>
			            <input type="text" class="form-control" id="categoryName" name="categoryName" value="${btcCategorys.categoryName}">
			          </div>
			          <div class="form-group">
			            <label for="categoryContext" class="control-label">描述:</label>
			            <textarea class="form-control" rows="10"  id="categoryContext" name="context">${btcCategorys.context}</textarea>
			          </div>
			          <div class="text-right">
			             <button id="updateCategory" data-updateUrl="${pageContext.request.contextPath}/admin/spu/category/saveUpdate" type="button" class="btn btn-primary">修改</button>
			             <button id="deleteCategory" data-deleteUrl="${pageContext.request.contextPath}/admin/spu/category/delete" type="button" class="btn btn-danger">删除</button>
			          </div>			         
			         </form>			        	                        
                  </div>
                  <div role="tabpanel" class="tab-pane" id="attributeNode">
                      <!-- 分类属性 -->			        				      			     				                      
				    <div class="pull-right text-right margin-top-20">
					   <a id="showAddWindow" href="javascript:;" class="btn btn-xs btn-info btn-outline-info">
					     <i class="glyphicon glyphicon-plus"></i>
						 <span>新增</span>
					   </a>
					</div>
					<table   class="table">
					  <thead class="">
						<tr >
						  <th class="text-center">属性</th>
						  <th class="text-center">用途</th>
						  <th class="text-center">操作</th>	              			  
						</tr>
					  </thead>
					 </table> 
				    <div class="scrollbar" id="style-1">
				      <table   class="table table-whenhover force-overflow" style="background-color:#f2f6ff;">				
					  <tbody >
					    <c:forEach var="editCategoryAttr"   items="${editCategoryAttrs}" varStatus="statu" >
					      <form id="categoryAttr-${editCategoryAttr.id}" action="${pageContext.request.contextPath}/admin/spu/category/saveUpdateCategoryAttr" method="post">
					        <input type="text" name="id" value="${editCategoryAttr.id}" hidden="true" readonly="readonly"/>
						      <tr id="${editCategoryAttr.id}" class="tr">
							   <td class="text-center text-info" width="35%">${editCategoryAttr.attributeName}</td>
							   <td width="35%" class="text-info text-center" >
							      <input id="baseType-${editCategoryAttr.id}" type="checkbox" name="baseType" value="2" ${editCategoryAttr.baseType ==2 ? 'checked="checked"' : ''}/>
							      <label for="baseType-${editCategoryAttr.id}">基本</label>
							      &nbsp;&nbsp;
							      <input id="priceType-${editCategoryAttr.id}" type="checkbox" name="priceType" value="2" ${editCategoryAttr.priceType ==2 ? 'checked="checked"' : ''}/>
							      <label for="priceType-${editCategoryAttr.id}">价格</label>
							      &nbsp;&nbsp;
							      <input id="guideType-${editCategoryAttr.id}" type="checkbox" name="guideType" value="2" ${editCategoryAttr.guideType ==2 ? 'checked="checked"' : ''}/>
							      <label for="guideType-${editCategoryAttr.id}">导购</label>
							   </td>
							   <td class="text-center" >
							    <a href="javascript:updateTargetEntity('categoryAttr-${editCategoryAttr.id}','${pageContext.request.contextPath}/admin/spu/category/saveUpdatecategoryAttr');" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>保存</span></a>
							    <a href="javascript:deleteByID(${editCategoryAttr.id},'${pageContext.request.contextPath}/admin/spu/attribute/deletecategoryAttr');" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span>删除</span></a>			   
							   </td>
							  </tr>
						  </form> 		   
					    </c:forEach>		   		
					   </tbody>
					 </table>
				    </div>				    	     				   
                  </div >
                  <!-- 品牌 -->
                   <div role="tabpanel" class="tab-pane" id="brandNode">
                      <!-- 关联品牌 -->			        				      			     				                      
				    <div class="pull-right text-right margin-top-20">
					   <a id="showAddWindow2" href="javascript:;" class="btn btn-xs btn-info btn-outline-info">
					     <i class="glyphicon glyphicon-plus"></i>
						 <span>新增</span>
					   </a>
					</div>
					<table   class="table">
					  <thead class="">
						<tr >
						  <th class="text-center">品牌</th>
						  <th class="text-center">排序</th>
						  <th class="text-center">操作</th>	              			  
						</tr>
					  </thead>
					 </table> 
				    <div class="scrollbar" id="style-1">
				      <table   class="table table-whenhover force-overflow" style="background-color:#f2f6ff;">				
					  <tbody >
					    <c:forEach var="categoryBrand"   items="${categoryBrands}" varStatus="statu" >
					      <form id="categoryBrand-${categoryBrand.id}" action="${pageContext.request.contextPath}/admin/spu/category/saveUpdateCategoryBrand" method="post">
					        <input type="text" name="id" value="${categoryBrand.id}" hidden="true" readonly="readonly"/>
						      <tr id="${categoryBrand.id}" class="tr">
							   <td class="text-center text-info" width="35%">${categoryBrand.brandName}</td>
							   <td width="35%" class="text-info text-center" >
							      <input id="sort-${categoryBrand.id}" type="text" name="sort" value="${categoryBrand.sort}" placeholder="请输入序号" class="form-control">
							   </td>
							   <td class="text-center" >
							    <a href="javascript:updateTargetEntity('categoryBrand-${categoryBrand.id}','${pageContext.request.contextPath}/admin/spu/category/saveUpdateCategoryBrand');" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>保存</span></a>
							    <a href="javascript:deleteByID(${categoryBrand.id},'${pageContext.request.contextPath}/admin/spu/category/deletecategoryBrand');" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span>删除</span></a>			   
							   </td>
							  </tr>
						  </form> 		   
					    </c:forEach>		   		
					   </tbody>
					 </table>
				    </div>				    	     				   
                  </div >
                  <!-- 子类 -->
			      <div role="tabpanel" class="tab-pane" id="sonNode">
			        <form id="sonForm">
                      <input id="parentcategoryId" name="parentId" value="${btcCategorys.id}" readonly="readonly" hidden="true"/>
			          <div class="form-group">
			            <label for="sonCategoryName" class="control-label">子类名称:</label>
			            <input type="text" class="form-control" id="sonCategoryName" name="categoryName" value="">
			          </div>
			          <div class="form-group">
			            <label for="sonContext" class="control-label">描述:</label>
			            <textarea class="form-control" rows="10" id="sonContext" name="context" ></textarea>
			          </div>
			          <div class="text-right">
			             <button id="addCategory" data-addUrl="${pageContext.request.contextPath}/admin/spu/category/saveAdd" type="button" class="btn btn-primary">新增</button>
			          </div>
			        </form>    
			     </div>
			   <div role="tabpanel" class="tab-pane" id="nodeList">...</div>
			 </div>			
		   </div>
		</div>	       	
      </div>
      
     
    </div>
    
     <!-- 新增属性关联界面弹窗 -->  
	  <div class="modal fade" id="addEntity" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	    <div class="modal-dialog" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="addModalLabel">添加属性</h4>
	        </div>
	        <div class="modal-body">
	          <form id="addForm" action="${pageContext.request.contextPath}/admin/spu/category/saveAddcategoryAttr" method="post">
	            <input id="validate-attributeId" type="text" name="id" value="${btcCategorys.id}" hidden="true" readonly="readonly"/>
	            <div class="form-group">
	              <label for="attribute-name" class="control-label">属性:</label>
	              <select  class="form-control selectpicker show-tick" multiple="multiple" data-size="6" data-live-search="true"  id="attribute-id"  name="attributeIds" title="请选择属性" >			            
			          <c:forEach var="attribute" items="${attributes}" varStatus="statu">
			            <option    value ="${attribute.id}"  >${attribute.attributeName}</option>
			          </c:forEach>
			      </select>
	            </div>
	          </form>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	          <button type="button" class="btn btn-primary" id="submitAdd">添加</button>
	        </div>
	      </div>
	    </div>
	  </div>
	  
	  <!-- 新增品牌关联界面弹窗 -->  
	  <div class="modal fade" id="addEntity2" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	    <div class="modal-dialog" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="addModalLabel">添加品牌</h4>
	        </div>
	        <div class="modal-body">
	          <form id="addForm2" action="${pageContext.request.contextPath}/admin/spu/category/saveAddcategoryBrand" method="post">
	            <input id="validate-brandId" type="text" name="id" value="${btcCategorys.id}" hidden="true" readonly="readonly"/>
	            <div class="form-group">
	              <label for="brand-name" class="control-label">品牌:</label>
	              <select  class="form-control selectpicker show-tick" multiple="multiple" data-size="6" data-live-search="true"  id="brand-id"  name="brandIds" title="请选择品牌" >			            
			          <c:forEach var="brand" items="${brands}" varStatus="statu">
			            <option    value ="${brand.id}"  >${brand.brandName}</option>
			          </c:forEach>
			      </select>
	            </div>
	          </form>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	          <button type="button" class="btn btn-primary" id="submitAdd2">添加</button>
	        </div>
	      </div>
	    </div>
	  </div>     
  </body>
</html>