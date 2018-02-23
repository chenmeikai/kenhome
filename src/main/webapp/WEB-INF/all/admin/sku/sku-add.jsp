<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
 <html>
   <head>
      <title>商品编辑
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
     
	  <!-- 验证样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/validate2/bootstrapValidator.min.css" rel="stylesheet">
	  
	  <!--时间控件-->
	  <link href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.css" rel="stylesheet">
	  
	  <!-- select样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/select/bootstrap-select.min.css" rel="stylesheet">
	  
	  <link href="${pageContext.request.contextPath}/resources/css/admin/common.css" rel="stylesheet">
	  
	  <!-- 上传样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/fileinput/bootstrap-fileinput.min.css" rel="stylesheet">
	
	  <!-- 文本编辑样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/summernote/summernote.css" rel="stylesheet">
	  

	  <style type="text/css">
	    .{margin-right:15px;}
	    .sure-button{background-color:rgb(42, 104, 142);color:white;}
	    #sku-add-place{box-shadow: #666 0px 0px 10px;padding-top:30px;padding-bottom:30px;margin-bottom:20px;min-height:600px;margin-top:40px;}
	  </style>
	 	  
	  <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	 	  
	  <!-- 表单验证控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/validate2/bootstrapValidator.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/validate2/validate-zh_CN.js"></script>
	  
	  <!-- select -->
	   <script src="${pageContext.request.contextPath}/resources/js/select/bootstrap-select.min.js"></script>
	   <script src="${pageContext.request.contextPath}/resources/js/select/defaults-zh_CN.min.js"></script>
	   
	  <!--时间控件-->
	  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.js"></script>
	  <!--时间控件汉化-->
	  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.zh-CN.js"></script> 
	   
	  <!-- dateFormat -->
	  <script src="${pageContext.request.contextPath}/resources/js/dateFormat/dateFormat.js"></script>
	  
	  <!-- 上传控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/fileinput/bootstrap-fileinput.min.js"></script>
	  <!-- extend 中文 -->
	  <script src="${pageContext.request.contextPath}/resources/js/fileinput/fileinput-zh.js"></script>
	  
	  <!-- 文本编辑控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/summernote/summernote.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/summernote/summernote-zh-CN.js"></script>
	  
	 
	  
	  <script src="${pageContext.request.contextPath}/resources/js/admin/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			    //新增Sku表单验证
			    $('#skuForm').bootstrapValidator({
                       message: 'This value is not valid',
                       excluded : [':disabled'],//[':disabled', ':hidden', ':not(:visible)']//验证不包含无效的
                       feedbackIcons: {
                           valid: 'glyphicon glyphicon-ok',
                           invalid: 'glyphicon glyphicon-remove',
                           validating: 'glyphicon glyphicon-refresh'
                       },
			           fields: {
			        	   spuId  : {
			        		   validators: {
			                        notEmpty: {
			                            message: '没有商品号'
			                        }
			        		   }
			        	   },
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
			                optionId: {
			                    validators: {
			                        notEmpty: {
			                            message: '请选择属性值'
			                        }
			                    }			      
			                },
			                originalPrice: {
			                    validators: {
			                        notEmpty: {
			                            message: '请输入原价'
			                        },
			                        greaterThan:{
			                        	value : 0,
			                        	message :'不得少于0'			                        	
			                        }
			                    }			      
			                },
			                stocks: {
			                    validators: {
			                        notEmpty: {
			                            message: '请输入库存'
			                        },
			                        integer: {
			                            message: '请输入整数'
			                        },
			                        greaterThan:{
			                        	value : 0,
			                        	message :'不得少于0'			                        	
			                        }
			                    }			      
			                },
			                integration: {
			                    validators: {
			                        notEmpty: {
			                            message: '请输入积分'
			                        },
			                        integer: {
			                            message: '请输入整数'
			                        },
			                        greaterThan:{
			                        	value : 0,
			                        	message :'不得少于0'			                        	
			                        }
			                    }			      
			                },
			                discountRate: {
			                    validators: {
			                        notEmpty: {
			                            message: '请输入折扣'
			                        },
			                        between:{
			                        	min : 0,
			                        	max : 1,
			                        	message :'0到1之间'			                        	
			                        }
			                    }			      
			                },
			                salePrice: {
			                    validators: {
			                        notEmpty: {
			                            message: '请输入促销价'
			                        },
			                        greaterThan:{
			                        	value : 0,
			                        	message :'不得少于0'			                        	
			                        }
			                    }			      
			                },
			                scrollImages: {
			                    validators: {
			                        notEmpty: {
			                            message: '请上传商品图片'
			                        }
			                    }			      
			                },
			                picture: {
			                    validators: {
			                        notEmpty: {
			                            message: '请上传商品缩略图'
			                        }
			                    }			      
			                }
			            }
	             });  
			  
			  	//sku缩略图组件
			  	$("#sku-picture").fileinput({
					language: 'zh',
			        showUpload: false,
			        showPreview:true,//不显示预览区域，因为bootstrap的modal会导致bug
			        maxFileSize:200,  //单位为KB
			        showUpload: false,
			        fileActionSettings :{showZoom: false},//取消放大按钮，因为bootstrap的modal会导致bug
			        allowedFileExtensions: ['jpg', 'bmp', 'jpeg','png'],//接收的文件后缀
			    });
			  	
			  	//sku图片上传组件
			  	$("#sku-scroll-image").fileinput({
					language: 'zh',
			        showUpload: false,
			        showPreview:true,
			        maxFileSize:2024,  //单位为KB
			        showUpload: false,
			        fileActionSettings :{showZoom: true},
			        allowedFileExtensions: ['jpg', 'bmp', 'jpeg','png'],//接收的文件后缀
			    });
			  	
			  	
			  	//提交新增sku表单
			  	$("#submitSkuAdd").click(function(){
			  		
			  	      //验证表单
	            	  var bootstrapValidator = $("#skuForm").data('bootstrapValidator');
	            	  bootstrapValidator.validate();
	            	  if(bootstrapValidator.isValid()){
	            		  var targetUrl = $("#skuForm").attr("action");             
	                      var data = new FormData($( "#skuForm" )[0]);   
	                      $("#submitSkuAdd").val("提交中...").attr("disabled","disabled");
	                         $.ajax({    
	                                type:'post',        
	                                url:targetUrl,  
	                                cache: false,              //上传文件不需缓存
	                                processData: false,    //需设置为false。因为data值是FormData对象，不需要对数据做处理
	                                contentType: false,    //需设置为false。因为是FormData对象，且已经声明了属性enctype="multipart/form-data"
	                                data:data,        
	                                dataType:'text',    
	                                success:function(data){                        
	                                      switch(data){
	                                         
	                                      case("false"):
	                                    	  alert("新增失败");
	                                          $("#submitSkuAdd").val("确认新增").removeAttr("disabled");
	                                      break;
	                                      case("option"):
	                                    	  alert("请选择属性值");
	                                          $("#submitSkuAdd").val("确认新增").removeAttr("disabled");
	                                      break;
	                                      case("picture"):
	                                    	  alert("请上传缩略图图片");
	                                          $("#submitSkuAdd").val("确认新增").removeAttr("disabled");
	                                      break;
	                                      case("scrollImages"):
	                                    	  alert("请上传图片");
	                                          $("#submitSkuAdd").val("确认新增").removeAttr("disabled");
	                                      break;
	                                      case("true"):
	                                    	  $("#submitSkuAdd").val("确认新增").removeAttr("disabled");	                                    	 
		                                      bootbox.alert({
		                      			        message:"添加成功",
		                      			        callback: function () {		                             			   	                             			                              			      
		                             			    }           			             
		                      		          }); 
		                                      break;
		                                  default:
		                                	  $("#submitSkuAdd").val("确认新增").removeAttr("disabled");                                    	        
                                    	      bootbox.alert({
  		                      			        message:"请求失败",
  		                      			        callback: function () {		                             			   	                             			                              			      
  		                             			    }           			             
  		                      		          }); 
	                                      }
	                                },
	                                error:function(){ 
	                                    alert("请求失败");
	                                    $("#submitSkuAdd").val("确认新增").removeAttr("disabled");
	                               }
	                         })
	            	  }
			  	})
			  	
			
           })
                     
	  </script>
	  
   </head>
   <body>
     <!-- 新增sku --> 
    <div class="container">
        <!-- 新增sku -->
	   <div class="row" id="sku-add-place" >
	       <div class="col-md-12" style="margin-bottom:10px;" >
             <span class="label label-danger" style="">Spu编号：${spu.spuNo}</span>
           </div> 
	       <div class="col-md-12">
	         <div>
		      <ul class="nav nav-tabs">
		        <li role="presentation" class="active"><a href="#oneNode1" aria-controls="oneNode1" role="tab" data-toggle="tab">商品信息</a></li>				        				       
		        <li role="presentation"><a href="#twoNode" aria-controls="twoNode" role="tab" data-toggle="tab">商品图片</a></li>	        			    
		      </ul>
		     <form id="skuForm" action="${pageContext.request.contextPath}/admin/spu/spu/saveAddSku" method="post" enctype="multipart/form-data">
		     <input type="text" name="spuId" value="${spu.id}" hidden="" readonly="readonly">	  
		     <div class="tab-content">
		       <div role="tabpanel" class="tab-pane active" id="oneNode1"> 
		            <div class="form-group col-md-12" style="margin-top:20px;">
		              <label for="sku-picture" class="control-label">缩略图:</label>
		              <input type="file"  class="cleanInput file-loading" id="sku-picture" name="picture"/>
		            </div>	              		            
		            <div class="form-group col-md-12" >
		              <label for="sku-skuName" class="control-label" >商品名称:</label>
		              <input type="text" class="form-control" id="sku-skuName" name="skuName" placeholder="请输入商品名">
		            </div>
		            <div class="form-group col-md-12">
		              <label for="sku-memo" class="control-label">备注:</label>
		              <textarea class="form-control" rows="3"  id="sku-memo" name="memo" placeholder="备注信息"></textarea>
		            </div>
		            <!-- 关键属性 -->
		            <c:forEach items="${spu.attributes}" var="attribute" varStatus="statu">
		             <c:if test="${attribute.priceType ==2}">
		              <div class="form-group col-md-12">
		                <label for="sku-optionId" class="control-label">${attribute.attributeName}:</label>
		                <select id="sku-optionId"  class="form-control "   name="optionId"  >
		                   <option value="">请选择${attribute.attributeName}</option>
					        <c:forEach items="${attribute.options}" var="option" varStatus="statu">
					          <option value="${option.id}" >${option.optionName}</option>
					        </c:forEach>			     
					   </select>
		              </div>
		             </c:if>
		            </c:forEach>
		            <div class="form-group col-md-6">
		              <label for="spu-name" class="sku-originalPrice" >原价:</label>
		              <input type="text" class="form-control" id="sku-originalPrice" name="originalPrice" placeholder="请输入商品原价">
		            </div>
		            <div class="form-group col-md-6">
		              <label for="sku-stocks" class="control-label" >库存:</label>
		              <input type="text" class="form-control" id="sku-stocks" name="stocks" placeholder="请输入商品库存">
		            </div>
		            <div class="form-group col-md-6">
		              <label for="sku-discountRate" class="control-label" >折率:</label>
		              <input type="text" class="form-control" id="sku-discountRate" name="discountRate" placeholder="请输入商品折率">
		            </div>
		            <div class="form-group col-md-6">
		              <label for="sku-salePrice" class="control-label" >促销价:</label>
		              <input type="text" class="form-control" id="sku-salePrice" name="salePrice" placeholder="请输入商品促销价">
		            </div>
		            <div class="form-group col-md-6">
		              <label for="sku-integration" class="control-label" >可兑积分:</label>
		              <input type="text" class="form-control" id="sku-integration" name="integration" placeholder="请输入购买商品可获得积分">
		            </div>
		            <div class="form-group col-md-6">
		              <label for="sku-statu" class="control-label" >状态:</label>
		              <select id="sku-statu" class="form-control" name="skuStatu" >
				        <option    value = "1" selected="selected">下架</option>
			            <option    value = "2">上架</option>
			            <option    value = "3">预售</option>			            
				     </select>
				    </div>
				             	        			        	                        
	            </div>		    	     				  	            
	                <!-- SKU图片 -->
		         <div role="tabpanel" class="tab-pane" id="twoNode">	                
		           <div class="form-group" style="margin-top:20px;">
		             <label for="sku-scroll-image" class="control-label">商品图片:</label>
		             <input type="file" class="form-control" id="sku-scroll-image" name="scrollImages" multiple class="file-loading">
		           </div>
		         </div>	       
		     </div>			     		
	       </form> 
	      </div>
	    </div>	       	
	 </div>	
	 <div class="row">
	   <div class="form-group col-md-2 pull-right">
	     <button type="button" class="btn btn-primary form-control" id="submitSkuAdd" style="box-shadow: #666 0px 0px 10px;">确认新增</button> 
	   </div>
	 </div>      	
    </div>
   
 
 </body>
</html>





   
 