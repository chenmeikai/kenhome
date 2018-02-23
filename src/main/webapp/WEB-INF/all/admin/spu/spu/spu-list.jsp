<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>spu中心
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
     
	  <!--时间控件-->
	  <link href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.css" rel="stylesheet">
	  
	  <!-- 验证样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/validate2/bootstrapValidator.min.css" rel="stylesheet">
	  
	  <!-- select样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/select/bootstrap-select.min.css" rel="stylesheet">
	  
	  <link href="${pageContext.request.contextPath}/resources/css/admin/common.css" rel="stylesheet">
	  
	  <!-- 上传样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/fileinput/bootstrap-fileinput.min.css" rel="stylesheet">
	
	  <!-- 文本编辑样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/summernote/summernote.css" rel="stylesheet">
	  
	  <!-- 图片放大样式 -->
      <link href="${pageContext.request.contextPath}/resources/css/zoomify/zoomify.css" rel="stylesheet">
	  

	  <style type="text/css">
	    .{margin-right:15px;}
	  </style>
	 	  
	  <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  
	  <!--时间控件-->
	  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.js"></script>
	  <!--时间控件汉化-->
	  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.zh-CN.js"></script>
	  
	  <!-- 表单验证控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/validate2/bootstrapValidator.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/validate2/validate-zh_CN.js"></script>
	  
	  <!-- select -->
	   <script src="${pageContext.request.contextPath}/resources/js/select/bootstrap-select.min.js"></script>
	   <script src="${pageContext.request.contextPath}/resources/js/select/defaults-zh_CN.min.js"></script>
	   
	  <!-- dateFormat -->
	  <script src="${pageContext.request.contextPath}/resources/js/dateFormat/dateFormat.js"></script>
	  
	  <!-- 上传控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/fileinput/bootstrap-fileinput.min.js"></script>
	  <!-- extend 中文 -->
	  <script src="${pageContext.request.contextPath}/resources/js/fileinput/fileinput-zh.js"></script>
	  
	  <!-- 文本编辑控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/summernote/summernote.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/summernote/summernote-zh-CN.js"></script>
	  
	  <!-- 图片放大 -->
	  <script src="${pageContext.request.contextPath}/resources/js/zoomify/zoomify.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/admin/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			  
	      //图片放大
	      $(".zoomify").zoomify();-
			  			  
			  //验证类目表单
		  $('#select-category').bootstrapValidator({
                       message: 'This value is not valid',
                       excluded : [':disabled'],//[':disabled', ':hidden', ':not(:visible)']//验证包含隐藏的
                       feedbackIcons: {
                           valid: 'glyphicon glyphicon-ok',
                           invalid: 'glyphicon glyphicon-remove',
                           validating: 'glyphicon glyphicon-refresh'
                       },
			           fields: {
			        	   categoryId: {
			                    validators: {
			                        notEmpty: {
			                            message: '请选择类目'
			                        }
			                    }			      
			                }			                
			            }
	       });  
			 
			  
			  
               //键入字符触发事件:动态获得后台传入select选项数据         
              //请求的url
              var selectBrandUrl = $("#spu-getBrand").attr("data-selectBrandUrl");
              
              //选择得到搜索栏input，松开按键后触发事件
              $("#spu-getBrand").prev().find('.bs-searchbox').find('input').keyup(function () {                   
                  //键入的值
                  var inputBrandName =$('#spu-select-brand .open input').val();
                  //判定键入的值不为空，才调用ajax
                  if(inputBrandName != ''){
                      $.ajax({
                            type: 'Get',
                            url: selectBrandUrl,
                            data: {                     //传递到后台的值
                                brandName: inputBrandName
                            },
                            dataType: "Json",
                            success: function (Selectbrands) {
                                //清除select标签下旧的option签，根据新获得的数据重新添加option标签
                                $("#spu-getBrand").empty();
                                if (Selectbrands != null) {               
                                    $.each(Selectbrands, function (i,Selectbrand) {
                                        $("#spu-getBrand").append(" <option value=\"" + Selectbrand.id + "\">" + Selectbrand.brandName + "</option>");
                                    })
                                    //必不可少的刷新
                                    $("#spu-getBrand").selectpicker('refresh');
                                   
                                }
                            }
                      })
                  }else 
                      //如果输入的字符为空，清除之前option标签
                      $("#spu-getBrand").empty();
                      $("#spu-getBrand").selectpicker('refresh');  
              });     
			  
			 
              
              //级联select:首级select的值发生改变，触发二级的选项改变
              $("#select-first").change(function(){
            	  //清空二级和三级select的旧选项
            	  $("#select-second").empty();
            	  $("#select-third").empty();
            	  //请求二级select选项数据地址
            	  var targetUrl = $(this).attr("data-getDataUrl");
   
            	  //一级select的值
            	  var firstValue = $(this).val();  
                  
            	  //如果一级select的值为null，隐藏二、三级select,并返回
            	  if(firstValue == ''){
            		  $("#select-second").fadeOut("slow");
            		  $("#select-third").fadeOut("slow");
            		  return;
            	  }      	  
            	 
            	 //根据一级的值改变，异步获取数据更新二级的选项             
            	  $.ajax({    
	                  type:'get',        
	                  url:targetUrl,    
	                  data:{
	                	  parentId:firstValue
	                  },    
	                  cache:false,    
	                  dataType:'json',    
	                  success:function(secondDatas){   	                  	 
	                	  
	                	  //遍历回传的数据添加到二级select
	                  	  $.each(secondDatas, function(key, secondData) {
	                  		 
	                  	  	   var option = '<option value="'+secondData.id+'">'+secondData.categoryName+'</option>'	  
	                  	  	   $("#select-second").append(option)
	                  	  	   
	                  	  })
	                  	   //bootstap-select控件:需刷新对应select               	  	  
                 	  	   $("#select-second").selectpicker('refresh');
	                  	  
	                  	  //二级select展示
	                       $("#box-select-second").fadeIn("slow");
	                  	  //三级select隐藏
                 	  	   $("#box-select-third").fadeOut("slow");                 	  	          	  	  
	                  },
	                  error:function(){ 
	                  	bootbox.alert("请求失败")
	        			}
				   });				  
              });
              
              //级联select:二级select值改变，触发三级select变化
              $("#select-second").change(function(){
            	  //清空三级slect的旧选项          	  
            	  $("#select-third").empty();
            	  //请求二级select选项数据地址
            	  var targetUrl = $(this).attr("data-getDataUrl");
            	  //二级select的值
            	  var secondValue = $(this).val();
            	  //如果一级select的值为null，隐藏三级select,并返回
            	  if(secondValue == ''){           		 
            		  $("#select-third").fadeOut("slow");
            		  return;
            	  } 
            	  //根据二级的值改变，异步获取数据更新三级的选项    
            	  $.ajax({    
	                  type:'get',        
	                  url:targetUrl,    
	                  data:{
	                	  parentId:secondValue
	                  },    
	                  cache:false,    
	                  dataType:'json',    
	                  success:function(thirdDatas){   	                  	 
	                	  
	                	  //遍历回传的数据添加到三级select
	                  	  $.each(thirdDatas, function(key, thirdData) {
	                  		 
	                  	  	   var option = '<option value="'+thirdData.id+'">'+thirdData.categoryName+'</option>'	  
	                  	  	   $("#select-third").append(option)
	                  	  	   
	                  	  })
	                  	  //bootstap-select控件:需刷新对应select               	  	  
                 	  	   $("#select-third").selectpicker('refresh');
	                  	  
	                  	   //三级select显示出来
                 	  	   $("#box-select-third").fadeIn("slow");                 	  	          	  	  
	                  },
	                  error:function(){ 
	                  	bootbox.alert("请求失败")
	        			}
				   });				  
              });
              
              <!--新增Spu：选择类目-->
            //级联select:首级select的值发生改变，触发二级的选项改变
              $("#select-first2").change(function(){
            	  //清空二级和三级select的旧选项
            	  $("#select-second2").empty();
            	  $("#select-third2").empty();
            	  //请求二级select选项数据地址
            	  var targetUrl = $(this).attr("data-getDataUrl");
   
            	  //一级select的值
            	  var firstValue = $(this).val();  
                  
            	  //如果一级select的值为null，隐藏二、三级select,并返回
            	  if(firstValue == ''){
            		  $("#select-second2").fadeOut("slow");
            		  $("#select-third2").fadeOut("slow");
            		  return;
            	  }      	            	 
            	 //根据一级的值改变，异步获取数据更新二级的选项             
            	  $.ajax({    
	                  type:'get',        
	                  url:targetUrl,    
	                  data:{
	                	  parentId:firstValue
	                  },    
	                  cache:false,    
	                  dataType:'json',    
	                  success:function(secondDatas){   	                  	 
	                	  
	                	  //遍历回传的数据添加到二级select
	                  	  $.each(secondDatas, function(key, secondData) {
	                  		 
	                  	  	   var option = '<option value="'+secondData.id+'">'+secondData.categoryName+'</option>'	  
	                  	  	   $("#select-second2").append(option)
	                  	  	   
	                  	  })
	                  	   //bootstap-select控件:需刷新对应select               	  	  
                 	  	   $("#select-second2").selectpicker('refresh');
	                  	  
	                  	  //二级select展示
	                       $("#box-select-second2").fadeIn("slow");
	                  	  //三级select隐藏
                 	  	   $("#box-select-third2").fadeOut("slow");                 	  	          	  	  
	                  },
	                  error:function(){ 
	                  	bootbox.alert("请求失败")
	        			}
				   });				  
              });             
              //级联select:二级select值改变，触发三级select变化
              $("#select-second2").change(function(){
            	  //清空三级slect的旧选项          	  
            	  $("#select-third2").empty();
            	  //请求二级select选项数据地址
            	  var targetUrl = $(this).attr("data-getDataUrl");
            	  //二级select的值
            	  var secondValue = $(this).val();
            	  //如果一级select的值为null，隐藏三级select,并返回
            	  if(secondValue == ''){           		 
            		  $("#select-third2").fadeOut("slow");
            		  return;
            	  } 
            	  //根据二级的值改变，异步获取数据更新三级的选项    
            	  $.ajax({    
	                  type:'get',        
	                  url:targetUrl,    
	                  data:{
	                	  parentId:secondValue
	                  },    
	                  cache:false,    
	                  dataType:'json',    
	                  success:function(thirdDatas){   	                  	 
	                	  
	                	  //遍历回传的数据添加到三级select
	                  	  $.each(thirdDatas, function(key, thirdData) {
	                  		 
	                  	  	   var option = '<option value="'+thirdData.id+'">'+thirdData.categoryName+'</option>'	  
	                  	  	   $("#select-third2").append(option)
	                  	  	   
	                  	  })
	                  	  //bootstap-select控件:需刷新对应select               	  	  
                 	  	   $("#select-third2").selectpicker('refresh');
	                  	  
	                  	   //三级select显示出来
                 	  	   $("#box-select-third2").fadeIn("slow");                 	  	          	  	  
	                  },
	                  error:function(){ 
	                  	bootbox.alert("请求失败")
	        			}
				   });				  
              });
              //提交选择的类目,展示对应的新增Spu界面
              $("#submitCategory").click(function(){
            	  //验证表单
            	  var bootstrapValidator = $("#select-category").data('bootstrapValidator');
            	  bootstrapValidator.validate();
            	  if(bootstrapValidator.isValid()){
            		  var categoryId = $("#select-third2").val();
            		  if(categoryId== null || categoryId== '' )return; 
            		  $("#addEntity").modal("hide");            		  
            			  var url = $("#select-category").attr("action");            			 
            			  var targetUrl = url+"?categoryId="+categoryId+" "+"#spu-add-place";
            			  $("#spu-add").load(targetUrl,function(){
            				   
            				  //初始化验证新增表单
            				  $('#spuForm').bootstrapValidator({
			                       message: 'This value is not valid',
			                       excluded : [':disabled'],//[':disabled', ':hidden', ':not(:visible)']//验证包含隐藏的
			                       feedbackIcons: {
			                           valid: 'glyphicon glyphicon-ok',
			                           invalid: 'glyphicon glyphicon-remove',
			                           validating: 'glyphicon glyphicon-refresh'
			                       },
						           fields: {
						        	   spuName: {
						                    validators: {
						                        notEmpty: {
						                            message: '请输入Spu名称'
						                        }
						                    }			      
						               },
						               spuTitle: {
						                    validators: {
						                        notEmpty: {
						                            message: '请输入Spu标题'
						                        }
						                    }			      
						               },
						               brandId: {
						                    validators: {
						                        notEmpty: {
						                            message: '请选择品牌'
						                        }
						                    }			      
						               },
						               spuImage: {
						                    validators: {
						                        notEmpty: {
						                            message: '请上传图片'
						                        }
						                    }			      
						               },
						               optionIds: {
						                    validators: {
						                        notEmpty: {
						                            message: '请选择属性值'
						                        }
						                    }			      
						               },
						               scrollImages: {
						                    validators: {
						                        notEmpty: {
						                            message: '请上传图片'
						                        }
						                    }			      
						               },						               						               
						            }
						      });  
            				          				  
            				  //初始化上传控件
            				  $("#spu-image").fileinput({
      							language: 'zh',
    					        showUpload: false,
    					        maxFileSize:100,  //单位为KB
    					        fileActionSettings :{showZoom: false},//取消放大按钮，因为bootstrap的modal会导致bug
    					        allowedFileExtensions: ['jpg', 'bmp', 'jpeg','png'],//接收的文件后缀
    					      }); 
            				  $("#spu-scroll-image").fileinput({
        						language: 'zh',
      					        showUpload: false,
      					        showPreview:false,//不显示预览区域，因为bootstrap的modal会导致bug
      					        maxFileSize:1024,  //单位为KB
      					        maxFileCount:6,
      					        fileActionSettings :{showZoom: false},//取消放大按钮，因为bootstrap的modal会导致bug
      					        allowedFileExtensions: ['jpg', 'bmp', 'jpeg','png'],//接收的文件后缀
      					      }); 
            				          				  
            				  //刷新selec控件
            				  $('.spu-attribute-select').selectpicker('refresh');
            				  
            				  //初始化文本编辑器控件
            				  $("#spu-content-edit").summernote({
            					  lang:'zh-CN',
            					  placeholder: '请介绍Spu',
            					  dialogsInBody: true,    //对话框置于body下，如果文本编辑器在modal模态中，此参数需要设置为true，否则对话框取消的话，会导致模态也被取消
            					  dialogsFade: true,      //对话框效果
            					  height:450,
            					  maxHeight:450,
            					  focus:true,
            				      callbacks: {  
            				          onImageUpload: function(file) {  //图片默认以二进制的形式存储到数据库，调用此方法将请求后台将图片存储到服务器，返回图片请求地址到前端
            				                //图片存放根路径
            				                var rootPath = $("#spu-content-edit").attr("data-fileRoot");           			
            				                //请求上传地址
            				                var targetUrl =$("#spu-content-edit").attr("data-fileUploadUrl");
            				                var formData = new FormData();  
            				                formData.append("picture", file[0]); 
            				                $.ajax({  	                      
            				                     type:'post',        
            				                     url:targetUrl,                        
            				                     cache: false,
            				                     data:formData, 
            				                     processData: false,
            				                     contentType: false,
            				                     dataType:'text',
            				                     success: function(e) {           				                 
            				                       $('#spu-content-edit').summernote('insertImage', rootPath+e); 
            				                     },  
            				                     error:function(){              				                    
            				                        alert("上传失败");             				                        
            				                     } 
            				                });
            				          }  
            				      } 
            					 
            				  });
            				  setTimeout(function () {
            					  $("#addSpuEntity").modal({backdrop: 'static'});                          			      
            				  }, 600);  
            				  
            			  });           		  
            	  }
              })
              
              <!--提交新增Spu数据-->
              $("#submitSpuAdd").click(function(){
            	  //表单验证
            	  var bootstrapValidator = $("#spuForm").data('bootstrapValidator');
            	  bootstrapValidator.validate();                          
                  if(bootstrapValidator.isValid()){
                                                	  
            	    var targetUrl =$("#spuForm").attr("action");
	                var formData = new FormData($('#spuForm')[0]);  
	                //添加文本框内容
	                var content = $("#spu-content-edit").summernote('code');
	                formData.append('spuContent',content);	     	               
	                	$.ajax({  	                      
		                     type:'post',        
		                     url:targetUrl,                        
		                     cache: false,
		                     data:formData, 
		                     processData: false,
		                     contentType: false,
		                     dataType:'text',
		                     success: function(flag) { 
		                    	 if(flag =="true"){
		                    		 $("#addSpuEntity").modal('hide');
			                          setTimeout(function () {bootbox.alert("新增成功")}, 500);
			                          return;
		                    	 }else if(flag =="false"){
		                    		 $("#addSpuEntity").modal('hide');
			                          setTimeout(function () {bootbox.alert("新增失败")}, 500);
			                          return;
		                    	 }
		                    	  $("#addSpuEntity").modal('hide');
			                      setTimeout(function () {bootbox.alert("请求失败")}, 500);
		                    	 		                       		                      		                     
		                     },  
		                     error:function(){              				                    
		                        alert("请求失败");             				                        
		                     } 
	                	});                          
                  }   	
              });
              
             
			     
		  })
		  
		  
		      //查看Spu界面弹窗
			  function  viewEntity(id,viewEditUrl){

				  	 var targetUrl = viewEditUrl+"?id="+id;
				  	 $("#spu-view").load(targetUrl)
				     $("#viewEntity").modal({backdrop: 'static'});	 				  		 
				  	 
			  }
		      
		  
			  //编辑spu界面弹窗
			  function  editEntity(id,viewEditUrl){
				    

				  	 var targetUrl = viewEditUrl+"?id="+id;
				  	 $("#spu-edit").load(targetUrl);
				     $("#editEntity").modal({backdrop: 'static'});	 				  		 
				  	
			  }
			 
		      	 
	  </script>
	  
   </head>
   <body>
     <div class="container-fluid">
	   <div class="row common-head">
	     <div class="col-md-2">
		   <span class="common-name">SPU中心</span>
		   <span>(</span>
		   <span class="text-success">${pageInfo.getTotal()}</span>
		   <span id="entityNums">种SPU</span>
		   <span>)</span>
		 </div>
		 <div class="col-md-2 pull-right text-right">
		   <a id="showAddWindow" href="javascript:;" class="btn btn-xs btn-info btn-outline-info">
		    <i class="glyphicon glyphicon-plus"></i>
			<span>新增</span>
		   </a>
		   <a id="excel-export" href="javascript:;" data-href="${pageContext.request.contextPath}/admin/spu/spu/export?" class="btn btn-xs btn-warning btn-outline-warning ">
		    <i class="glyphicon glyphicon-export"></i>
			<span>导出excel</span>
		   </a>
		 </div>			 
	   </div>
	   
	   <!--搜索栏-->
	   <form id="listForm" class="row common-search " action="${pageContext.request.contextPath}/admin/spu/spu/main"  method = "GET">          
	      <div class="row form-group "> 
	       <div class="col-md-2">	   		 
			  <input type="text" class="form-control reset" placeholder="SPU号" name="spuNo" value="${params.spuNo}">		   
		   </div>
		   <div class="col-md-2">		  		 
			  <input type="text" class="form-control reset" placeholder="SPU名" name="spuName" value="${params.spuName}">		   
		   </div>
		   <div class=" col-md-2" id="spu-select-brand">		 
			  <select  class="form-control selectpicker show-tick reset" id="spu-getBrand" title="请输入品牌" name="brandId"  data-selectBrandUrl="${pageContext.request.contextPath}/admin/spu/spu/getBrand" data-live-search="true"  data-size="6">
			     <option value="${params.brandId}" ${params.brandId >0  ? 'selected="selected"' :''}>已选Id：${params.brandId}</option>
			  </select>
		   </div>
		   <div class=" col-md-2">		 
			  <select  class="form-control selectpicker show-tick reset" name="spuStatu" data-live-search="true"  data-size="6" title="请选择状态" >
			     <option    value = "1" ${params.spuStatu eq 1 ? 'selected="selected"' :null}>下架</option>
		         <option    value = "2" ${params.spuStatu eq 2 ? 'selected="selected"' :null}  >上架</option>
		         <option    value = "3" ${params.spuStatu eq 3 ? 'selected="selected"' :null}  >预售</option>		         
			  </select>
		   </div>	
		   		   			 		   
		 </div>	
		 <div class="row form-group form-inline "> 	       		  
		   <div class="input-group col-md-3" style="margin-left:15px;" >		   		 
			    <input type="text" class="form-control  reset" placeholder="销量" name="startSaleAmount" value="${params.startSaleAmount}" id="oneSaleAmount" >
			    <span class="input-group-addon" >到</span>
			    <input type="text" class="form-control  reset" placeholder="销量" name="endSaleAmount" value="${params.endSaleAmount}" id="twoSaleAmount" >		   
		   </div>	
		    <div class="input-group col-md-3" style="margin-left:15px;" >		   		 
			    <input type="text" class="form-control  reset" placeholder="库存" name="startStocks" value="${params.startStocks}" id="oneStocks" >
			    <span class="input-group-addon" >到</span>
			    <input type="text" class="form-control  reset" placeholder="库存" name="endStocks" value="${params.endStocks}" id="twoStocks" >		   
		   </div>
		   <div class="input-group  col-md-3" style="margin-left:15px;">		   		 
			    <input type="text" class="form-control datetimepicker reset" placeholder="创建起始" name="startCreateDate" value="${params.startCreateDate}" id="oneDate" >
			    <span class="input-group-addon" >到</span>
			    <input type="text" class="form-control datetimepicker reset" placeholder="结束时间" name="endCreateDate" value="${params.endCreateDate}" id="twoDate" >		   
		   </div>	   			 		   
		 </div>	 	   
		 <div class="row ">	  
		   <div class="form-group col-md-2 " id="spu-select-firstCategory">		 
			  <select  class="form-control selectpicker show-tick reset" id="select-first" title="请选择分类" name="firstValue"  data-getDataUrl="${pageContext.request.contextPath}/admin/spu/spu/getsonCategory" data-live-search="true"  data-size="6">
			      <c:forEach items="${rootCategorys}" var="rootCategory" varStatus="statu">
			        <option value="${rootCategory.id}" ${params.firstValue ==rootCategory.id  ? 'selected="selected"' :''}  >${rootCategory.categoryName}</option>
			      </c:forEach>			     
			  </select>
		   </div>
		   <div class="form-group col-md-2  " id="box-select-second" ${secondCategorys ==null  ? 'style="display:none;"' :''}   >		 
			  <select   class="form-control selectpicker show-tick reset" id="select-second" title="二级分类" name="sonCategoryId"  data-getDataUrl="${pageContext.request.contextPath}/admin/spu/spu/getsonCategory" data-live-search="true"  data-size="6">
			    <c:forEach items="${secondCategorys}" var="secondCategory" varStatus="statu"> 
			     <option value="${secondCategory.id}" ${params.sonCategoryId ==secondCategory.id  ? 'selected="selected"' :''}  >${secondCategory.categoryName}</option>  	      		     
			    </c:forEach>	
			  </select>
		   </div>
		   <div class="form-group col-md-2 " id="box-select-third" ${thirdCategorys ==null  ? 'style="display:none;"' :''} >		 
			  <select   class="form-control selectpicker show-tick reset" id="select-third" title="三级分类" name="categoryId"  data-getDataUrl="${pageContext.request.contextPath}/admin/spu/spu/getsonCategory" data-live-search="true"  data-size="6">  
			     <c:forEach items="${thirdCategorys}" var="thirdCategory" varStatus="statu"> 
			       <option value="${thirdCategory.id}" ${params.categoryId ==thirdCategory.id  ? 'selected="selected"' :''}  >${thirdCategory.categoryName}</option>  	      		     
			     </c:forEach>		     
			  </select>
		   </div>
		   <div class=" col-md-2">		 
			  <select  class="form-control reset" name="skuSort">
			     <option    value = "create_date" ${params.skuSort.equals('create_date') ? 'selected="selected"' :null}>默认排序</option>
		         <option    value = "sale_amount" ${params.skuSort.equals('sale_amount') ? 'selected="selected"' :null}  >按销量</option>
		         <option    value = "stocks" ${params.skuSort.equals('stocks') ? 'selected="selected"' :null}  >按库存</option>		         
			  </select>
		   </div>
		   <div class=" col-md-1">		 
			  <select  class="form-control reset" name="direction">
			     <option    value = "DESC" ${params.direction.equals('DESC') ? 'selected="selected"' :null}>倒序</option>
			     <option    value = "ASC" ${params.direction.equals('ASC') ? 'selected="selected"' :null}  >正序</option>      
			  </select>
		   </div>				
           	<div class="form-group form-inline col-md-2 ">	 
			  <input id="formSearch" type="button" class="form-control" value="搜索" >
			  <input id="searchReset" type="button" class="form-control" value="重置">		
			</div>
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
			  <th>SPU图</th>
			  <th>SPU号</th>
			  <th>SPU名</th>
			  <th>所属类</th>
			  <th>品牌名</th>
			  <th>销量</th>
			  <th>库存</th>
			  <th>状态</th>				  
			  <th>创建日期</th>	
			  <th>更新日期</th>	
			  <th>操作</th>	              			  
			</tr>
		  </thead>
		  <tbody >
		   <c:forEach var="pageSpu"   items="${pageInfo.getList()}" varStatus="statu" >
		     
		     <tr id="${pageSpu.id}" class="tr">
		      <td>
		        <img src="${pros.fictitiousRoot}${pageSpu.spuImage}" class="img-rounded img-responsive image-vatar zoomify" style="width:50px;height:auto;'">
		      </td>
			  <td>${pageSpu.spuNo}</td>
			  <td>${pageSpu.spuName}</td>
			  <td>${pageSpu.categoryName}</td>
			  <td>${pageSpu.brandName}</td>
			  <td>${pageSpu.saleAmount}</td>
			  <td>${pageSpu.stocks}</td>
			  <td>
			    <c:choose>  
				    <c:when test="${pageSpu.spuStatu=='1'}">  
				             下架  
				    </c:when>  
				    <c:when test="${pageSpu.spuStatu=='2'}">  
				             上架  
				    </c:when>  
				    <c:when test="${pageSpu.spuStatu=='3'}">  
				             无货  
				    </c:when>  
				    <c:when test="${pageSpu.spuStatu=='4'}">  
				             非卖品  
				    </c:when> 
				    <c:when test="${pageSpu.spuStatu=='5'}">
				              赠品
				    </c:when> 				    
				</c:choose>
			  </td>	  			  
			  <td>
			  <fmt:formatDate type="both" value="${pageSpu.createDate}" dateStyle="default"/> 
			  </td>
			  <td>
			  <fmt:formatDate type="both" value="${pageSpu.updateDate}" dateStyle="default"/> 			  
			  </td>
			  <td>
			   <a href="javascript:viewEntity(${pageSpu.id},'${pageContext.request.contextPath}/admin/spu/spu/view');" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-book"></i>&nbsp;<span>查看</span></a>
			   <a href="javascript:editEntity(${pageSpu.id},'${pageContext.request.contextPath}/admin/spu/spu/viewedit');" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>编辑</span></a>
			   <a href='${pageContext.request.contextPath}/admin/spu/spu/linkSku?spuId=${pageSpu.id}' class="btn btn-info btn-xs"><i class="glyphicon glyphicon-link"></i>&nbsp;<span>系列</span></a>
			   <a href="javascript:deleteByID(${pageSpu.id},'${pageContext.request.contextPath}/admin/spu/spu/delete');" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span>删除</span></a>			   
			  </td>
			</tr>		   
		   </c:forEach>
		   		
		  </tbody>
		</table>
	   </div>
	   
	   <!--页码-->
	  <%@ include file="/WEB-INF/all/include/pageHelper.jsp"%> 
	</div>   
		
	
  
  
	  <!-- 新增spu：类目选择弹窗 -->  
	  <div class="modal fade " id="addEntity" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	    <div class="modal-dialog  " role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="addModalLabel">请先选择类目</h4>
	        </div>
	        <div class="modal-body" >	          
	           <form   action="${pageContext.request.contextPath}/admin/spu/spu/viewAddSpu" id="select-category" method="get">	  
			     <div class="form-group " id="spu-select-firstCategory2">		 
				  <select  class="form-control selectpicker show-tick reset" id="select-first2" title="请选择分类" name="firstValue"  data-getDataUrl="${pageContext.request.contextPath}/admin/spu/spu/getsonCategory" data-live-search="true"  data-size="6">
				      <c:forEach items="${rootCategorys}" var="rootCategory" varStatus="statu">
				        <option value="${rootCategory.id}"  >${rootCategory.categoryName}</option>
				      </c:forEach>			     
				  </select>
			     </div>
			     <div class="form-group  " id="box-select-second2" style="display:none;"   >		 
				  <select   class="form-control selectpicker show-tick reset" id="select-second2" title="二级分类" name="sonCategoryId"  data-getDataUrl="${pageContext.request.contextPath}/admin/spu/spu/getsonCategory" data-live-search="true"  data-size="6">				    	
				  </select>
			     </div>
			     <div class="form-group " id="box-select-third2" style="display:none;" >		 
				  <select   class="form-control selectpicker show-tick reset" id="select-third2" title="三级分类" name="categoryId"  data-getDataUrl="${pageContext.request.contextPath}/admin/spu/spu/getsonCategory" data-live-search="true"  data-size="6">  				    	     
				  </select>
			     </div>
			   </form>   					           	
			 	        
		   </div>		    
	       <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	          <button type="button" class="btn btn-primary" id="submitCategory">确认</button>
	       </div>
		 </div>
	    </div>
	  </div>	
	   <!-- 新增spu：新增SPU弹窗 -->  
	  <div class="modal fade"  id="addSpuEntity" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	    <div class="modal-dialog modal-lg " role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="addModalLabel">新增Spu</h4>
	        </div>
	        <div class="modal-body" id="spu-add" style='min-height:600px;'>
	          	        
		    </div>		    
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	          <button type="button" class="btn btn-primary" id="submitSpuAdd">确认</button>
	        </div>
		 </div>
	    </div>
	  </div> 
  
      <!-- 查看Spu界面弹窗 -->
      <div class="modal fade" id="viewEntity" tabindex="-1" role="dialog" aria-labelledby="viewModalLabel">
	    <div class="modal-dialog modal-lg" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title text-center text-info" id="viewModalLabel">Spu详情</h4>
	        </div>
	        <div id="spu-view" class="modal-body single-message-padding">
	            
	        </div>   
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        </div>
	      </div>
	    </div>
	  </div>
	  
	  
	  <!-- 编辑spu界面弹窗 -->  
	  <div class="modal fade " id="editEntity" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
	    <div class="modal-dialog modal-lg" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="editModalLabel">编辑Spu</h4>
	        </div>
	        <div class="modal-body"  style='min-height:600px;'>
	          <div id="spu-edit">
	          
	          </div>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        </div>
	      </div>
	    </div>
	  </div>
	  
  
  </body>
</html>