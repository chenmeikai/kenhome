<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
 <html>
   <head>
      <title>sku查看
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      
      <!-- 验证样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/validate2/bootstrapValidator.min.css" rel="stylesheet">
      
      <link href="${pageContext.request.contextPath}/resources/css/admin/common.css" rel="stylesheet">
      
      <!-- 图片放大样式 -->
      <link href="${pageContext.request.contextPath}/resources/css/zoomify/zoomify.css" rel="stylesheet">
      
      <!-- 上传样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/fileinput/bootstrap-fileinput.min.css" rel="stylesheet">
      

	  <style type="text/css">
	    .{margin-right:15px;}
	    .entity-each-param{height:65px;}
	    .sure-button{background-color:rgb(42, 104, 142);color:white;}
	  </style>
	 	  
	  <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  
	  <!-- 图片放大 -->
	  <script src="${pageContext.request.contextPath}/resources/js/zoomify/zoomify.js"></script>
	  
	  <!-- 表单验证控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/validate2/bootstrapValidator.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/validate2/validate-zh_CN.js"></script>
	  
	  <!-- 上传控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/fileinput/bootstrap-fileinput.min.js"></script>
	  <!-- extend 中文 -->
	  <script src="${pageContext.request.contextPath}/resources/js/fileinput/fileinput-zh.js"></script>
	  	  
	  <script src="${pageContext.request.contextPath}/resources/js/admin/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			   //图片放大
			    $('#sku-vartar').zoomify();
			  
			    //编辑Sku表单验证
			    $('#skuForm').bootstrapValidator({
                     message: 'This value is not valid',
                     excluded : [':disabled'],//[':disabled', ':hidden', ':not(:visible)']//验证不包含无效的
                     feedbackIcons: {
                         valid: 'glyphicon glyphicon-ok',
                         invalid: 'glyphicon glyphicon-remove',
                         validating: 'glyphicon glyphicon-refresh'
                     },
			           fields: {
			        	   skuName: {
			                    validators: {
			                        notEmpty: {
			                            message: '请输入商品名'
			                        },
			                        stringLength: {
			                            max: 50,
			                            message: '请不得输入多于50个字'
			                        }
			                    }			      
			                },			                
			                originalPrice: {
			                    validators: {
			                        notEmpty: {
			                            message: '请输入原价'
			                        }
			                    }			      
			                },
			                stocks: {
			                    validators: {
			                        notEmpty: {
			                            message: '请输入库存'
			                        }
			                    }			      
			                },
			                integration: {
			                    validators: {
			                        notEmpty: {
			                            message: '请输入积分'
			                        }
			                    }			      
			                },
			                discountRate: {
			                    validators: {
			                        notEmpty: {
			                            message: '请输入折扣'
			                        }
			                    }			      
			                },
			                salePrice: {
			                    validators: {
			                        notEmpty: {
			                            message: '请输入促销价'
			                        }
			                    }			      
			                }
			            }
	             });  
			    
			    
			    
			    //初始化文件上传控件
			    $("#sku-picture").fileinput({
					language: 'zh',
			        showUpload: false,
			        showPreview:true,
			        maxFileSize:500,  //单位为KB
			        showUpload: false,
			        fileActionSettings :{showZoom: true},
			        allowedFileExtensions: ['jpg', 'bmp', 'jpeg','png'],//接收的文件后缀
			    });
			    			    
			    $(".edit-spuPicture-input").fileinput({
					language: 'zh',
			        showUpload: false,
			        showPreview:false,
			        maxFileSize:2024,  //单位为KB
			        showUpload: false,
			        fileActionSettings :{showZoom: false},
			        allowedFileExtensions: ['jpg', 'bmp', 'jpeg','png'],//接收的文件后缀
			    });
			    
			    
			    
			    //提交修改商品信息表单
			    $("#editSku").click(function(){
			    	  
			    	 var bootstrapValidator = $("#skuForm").data('bootstrapValidator');
	            	 bootstrapValidator.validate();
	            	 if(bootstrapValidator.isValid()){
	            		 $("#editSku").val("提交中...").attr("disabled","disabled");
	            		 var targetUrl = $("#skuForm").attr("action");             
	                     var data = new FormData($( "#skuForm" )[0]);
	                     $.ajax({    
                             type:'post',        
                             url:targetUrl,  
                             cache: false,              //上传文件不需缓存
                             processData: false,    //需设置为false。因为data值是FormData对象，不需要对数据做处理
                             contentType: false,    //需设置为false。因为是FormData对象，且已经声明了属性enctype="multipart/form-data"
                             data:data,        
                             dataType:'text',    
                             success:function(data){                        
                                  if(data == "true"){
                                	  bootbox.alert("修改成功");
                                	  $("#editSku").val("确认修改").removeAttr("disabled");
                                	  
                                  }else
                                	  bootbox.alert("修改失败");
                            	      $("#editSku").val("确认修改").removeAttr("disabled");  
                                   
                             },
                             error:function(){ 
                                 bootbox.alert("请求失败");
                                 $("#editSku").val("确认修改").removeAttr("disabled");
                            }
                         })
	            	 }
			    })
			    
			    //提交修改商品属性表单
			    $("#editSkuOption").click(function(){
			    	  	            	
	            		 $("#editSkuOption").val("提交中...").attr("disabled","disabled");
	            		 var targetUrl = $("#skuOptionForm").attr("action");             
	                     var data = new FormData($( "#skuOptionForm" )[0]);
	                     $.ajax({    
                             type:'post',        
                             url:targetUrl,  
                             cache: false,              //上传文件不需缓存
                             processData: false,    //需设置为false。因为data值是FormData对象，不需要对数据做处理
                             contentType: false,    //需设置为false。因为是FormData对象，且已经声明了属性enctype="multipart/form-data"
                             data:data,        
                             dataType:'text',    
                             success:function(data){                        
                                  if(data == "true"){
                                	  bootbox.alert("修改成功");
                                	  $("#editSkuOption").val("确认修改").removeAttr("disabled");
                                	  
                                  }else
                                	  bootbox.alert("修改失败");
                            	      $("#editSkuOption").val("确认修改").removeAttr("disabled");  
                                   
                             },
                             error:function(){ 
                                 bootbox.alert("请求失败");
                                 $("#editSkuOption").val("确认修改").removeAttr("disabled");
                            }
                         })	            	
			    })
			    
			    
		      //替换图片
			  $(".replace-picture").click(function(){
				  var rootPath=$(this).attr("data-rootPath");
				  var pictureId = $(this).attr("data-picture-id");	
			      var targetUrl = $(this).attr("data-upload-url");	
			      var data = new FormData();
				  data.append("pictureId",pictureId);
				  data.append("replaceFile",$('#upload-new-'+pictureId)[0].files[0]);				
			      if (data == null) return false;
			      $(this).val("替换中").attr("disabled","disabled");			      
			      $.ajax({  	                      
	                     type:'post',        
	                     url:targetUrl,                        
	                     cache: false,
	                     data:data, 
	                     processData: false,
	                     contentType: false,
	                     dataType:'text',
	                     success: function(newPath) { 
	                       if(newPath != "false"){
	                    	   $('#replace-picture-'+pictureId+' img').attr('src', rootPath+newPath);
	                    	   $(".replace-picture").val("替换").removeAttr("disabled");	
	                    	   return
	                       }	                  	  
	                       bootbox.alert("替换失败")	
	                       $(".replace-picture").val("替换").removeAttr("disabled");	
	                     },  
	                     error:function(){              				                    
	                    	 bootbox.alert("上传请求失败");  
	                    	 $(".replace-picture").val("替换").removeAttr("disabled");	
	                     } 
	              });
				  
			   });
			    
			  //新增图片 
			  $(".add-picture").click(function(){
				  var rootPath=$(this).attr("data-rootPath");
				  var skuId = $(this).attr("data-picture-id");	
			      var targetUrl = $(this).attr("data-upload-url");	
			      var data = new FormData();
				  data.append("skuId",skuId);
				  data.append("addFile",$('#sku-scroll-addimage')[0].files[0]);				
			      if (data == null) return false;
			      $(this).val("上传中").attr("disabled","disabled");			      
			      $.ajax({  	                      
	                     type:'post',        
	                     url:targetUrl,                        
	                     cache: false,
	                     data:data, 
	                     processData: false,
	                     contentType: false,
	                     dataType:'text',
	                     success: function(newPath) { 
	                       if(newPath == "false"){
	                    	   bootbox.alert("上传失败");
	                    	   $(".add-picture").val("上传").removeAttr("disabled");	
	                    	   return false;
	                       }else if(newPath == "enough"){
	                    	   bootbox.alert("上传失败，图片数量不可超过3张");
	                    	   $(".add-picture").val("上传").removeAttr("disabled");	
	                    	   return false;
	                       }else
	                    	   bootbox.alert("上传成功");
	                           $(".add-picture").val("上传").removeAttr("disabled");	
	                           //插入图片
	                           var tag ='<div  class="col-md-8" style="box-shadow: #666 0px 0px 10px; margin-top:20px;">'
	                                    +'<img src="'+newPath+'" class="img-rounded img-responsive  image-zoomify">'
	                                    +'</div>'
	        	               $("#spuPictures").before(tag);
	        	              
	                     },  
	                     error:function(){              				                    
	                    	 bootbox.alert("上传请求失败"); 
	                        $(".replace-picture").val("上传").removeAttr("disabled");	
	                     } 
	              });
				  
			   });  
			   
			  			  
           })
                     
	  </script>
	  
   </head>
   <body>
     <!--编辑sku -->
    <div class="container">
       <div class="row">
           <div style="margin-left:20px;margin-top:20px;margin-bottom:5px;" >
             <span class="label label-danger">Sku编号：${editSku.skuNo}</span>
           </div>
	       <div class="col-md-12">
	         <div>
		      <ul class="nav nav-tabs">
		        <li role="presentation" class="active"><a href="#oneNode1" aria-controls="oneNode1" role="tab" data-toggle="tab">商品信息</a></li>				        				       
		        <li role="presentation"><a href="#twoNode" aria-controls="twoNode" role="tab" data-toggle="tab">关键属性</a></li>	
		        <li role="presentation"><a href="#threeNode" aria-controls="threeNode" role="tab" data-toggle="tab">商品图片</a></li>	        			    
		      </ul>
		       
		     <div class="tab-content">
		       <div role="tabpanel" class="tab-pane active" id="oneNode1"> 
		         <form id="skuForm" action="${pageContext.request.contextPath}/admin/sku/sku/saveEditSku" method="post" enctype="multipart/form-data">
		            <input type="text" name="id" value="${editSku.id}" readonly="readonly" hidden="" />
		            <div class="form-group col-md-6" style="margin-top:20px;">
		              <label  class="control-label">缩略图:</label>
		              <img id="sku-vartar" src="${pros.fictitiousRoot}${editSku.picture}" class="img-rounded img-responsive image-head zoomify">
		              <input type="file"  class="cleanInput file-loading" id="sku-picture" name="picture"/>
		            </div>	              		            
		            <div class="form-group col-md-12" >
		              <label for="sku-skuName" class="control-label" >商品名称:</label>
		              <input type="text" class="form-control" id="sku-skuName" name="skuName" value="${editSku.skuName}" placeholder="请输入商品名">
		            </div>
		            <div class="form-group col-md-12">
		              <label for="sku-memo" class="control-label">备注:</label>
		              <textarea class="form-control" rows="3"  id="sku-memo" name="memo"  placeholder="备注信息">${editSku.memo}</textarea>
		            </div>
		            
		            <div class="form-group col-md-6">
		              <label for="spu-name" class="sku-originalPrice" >原价:</label>
		              <input type="text" class="form-control" id="sku-originalPrice" name="originalPrice" value="${editSku.originalPrice}" placeholder="请输入商品原价">
		            </div>
		            <div class="form-group col-md-6">
		              <label for="sku-stocks" class="control-label" >库存:</label>
		              <input type="text" class="form-control" id="sku-stocks" name="stocks" value="${editSku.stocks}" placeholder="请输入商品库存">
		            </div>
		            <div class="form-group col-md-6">
		              <label for="sku-discountRate" class="control-label" >折率:</label>
		              <input type="text" class="form-control" id="sku-discountRate" name="discountRate" value="${editSku.discountRate}" placeholder="请输入商品折率">
		            </div>
		            <div class="form-group col-md-6">
		              <label for="sku-salePrice" class="control-label" >促销价:</label>
		              <input type="text" class="form-control" id="sku-salePrice" name="salePrice" value="${editSku.salePrice}" placeholder="请输入商品促销价">
		            </div>
		            <div class="form-group col-md-6">
		              <label for="sku-integration" class="control-label" >可兑积分:</label>
		              <input type="text" class="form-control" id="sku-integration" name="integration" value="${editSku.integration}" placeholder="请输入购买商品可获得积分">
		            </div>
		            <div class="form-group col-md-6">
		              <label for="sku-statu" class="control-label" >状态:</label>
		              <select id="sku-statu" class="form-control" name="statu" >
				        <option    value = "1" ${editSku.skuStatu ==1 ? 'selected="selected"' : ''}>下架</option>
			            <option    value = "2" ${editSku.skuStatu ==2 ? 'selected="selected"' : ''}>上架</option>
			            <option    value = "3" ${editSku.skuStatu ==3 ? 'selected="selected"' : ''}>预售</option>
				     </select>
				    </div>
				    <div class="form-group col-md-2 pull-right" style="margin-top:20px;margin-bottom:50px;">
				      <input id="editSku" class="form-control  sure-button" type="button" value="确认修改">
				    </div>
				 </form>             	        			        	                        
	            </div>		
	               <!-- 关键属性 -->
		         <div role="tabpanel" class="tab-pane" id="twoNode">
		          <form id="skuOptionForm" action="${pageContext.request.contextPath}/admin/sku/sku/saveEditSkuOption" method="post"  enctype="multipart/form-data">	                
		           <input type="text" name="skuId" value="${editSku.id}" readonly="readonly" hidden="" />
		           <div class="form-group" style="margin-top:20px;">
		              <!-- 关键属性 -->
		            <c:forEach items="${editSpu.attributes}" var="attribute" varStatus="statu">
		             <c:if test="${attribute.priceType ==2}">
		              <div class="form-group col-md-12">
		                <label for="sku-optionId" class="control-label">${attribute.attributeName}:</label>
		                <select id="sku-optionId"  class="form-control "   name="optionIds"  >		                   
					        <c:forEach items="${attribute.options}" var="option" varStatus="statu">
					          <option value="${option.id}" ${optionIds.contains(option.id) ? 'selected="selected"' : '' } >${option.optionName}</option>
					        </c:forEach>			     
					   </select>
		              </div>
		             </c:if>
		            </c:forEach> 
		           </div>
		           <div class="form-group col-md-2 pull-right" style="margin-top:20px;margin-bottom:50px;">
				      <input id="editSkuOption" class="form-control  sure-button" type="button" value="确认修改">
				   </div>
		          </form> 
		         </div>	       	     				  	            
	                <!-- SKU图片 -->
		         <div role="tabpanel" class="tab-pane" id="threeNode">	                
		            <div >
		             <c:forEach items="${skuPictures}" var="skuPicture" varStatus="statu">	            	             
		              <div id="replace-picture-${skuPicture.id}" class="col-md-8" style="box-shadow: #666 0px 0px 10px; margin-top:20px;">
		               <img src="${pros.fictitiousRoot}${skuPicture.pictureUrl}" class="img-rounded img-responsive  image-zoomify">
		              </div>
		              <div class="form-group col-md-2 form-inline" style="margin-top:40px;">             
		               <label  class="control-label" style="margin-bottom:10px;">替换图片:</label>         
		               <input type="file" id="upload-new-${skuPicture.id}"  name="replaceFile" class="file-loading edit-spuPicture-input" >
		               <input class="form-control sure-button replace-picture" type="button" value="替换" style="margin-top:20px;"
		                data-rootPath="${pros.fictitiousRoot}" data-picture-id="${skuPicture.id}"  data-upload-url="${pageContext.request.contextPath}/admin/sku/sku/replacePicture" />
		              </div>	        	             
		             </c:forEach>
		             <c:if test="${skuPictures.size()<3}">
		               <div id="spuPictures" class="form-group col-md-8" style="margin-top:20px;"></div>
		               <div  class="form-group col-md-2 form-inline" style="margin-top:20px;">
		                <label for="sonCategoryName" class="control-label" style="margin-bottom:10px;">新增图片:</label>
		                <input type="file"  id="sku-scroll-addimage" name="addImage"  class=" file-loading edit-spuPicture-input">
		                <input class="form-control sure-button add-picture" type="button" value="上传" style="margin-top:20px;"
		                data-rootPath="${pros.fictitiousRoot}" data-picture-id="${editSku.id}"  data-upload-url="${pageContext.request.contextPath}/admin/sku/sku/addPicture" />
		               </div>	     	 
		             </c:if>
		             <div class="col-md-12" style="margin-top:25px;"></div>
		           </div>
		         </div>	       
		     </div>			
	       
	      </div>
	    </div>	       	
	  </div>
    </div>
   </body>
</html>





   
 