<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
 <html>
   <head>
      <title>spu编辑
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
     
	  <!-- 验证样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/validate2/bootstrapValidator.min.css" rel="stylesheet">
	  
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
			  			  
			  //初始化fileinput组件		
			  $(".spu-image").fileinput({
					language: 'zh',
			        showUpload: false,
			        maxFileSize:100,  //单位为KB
			        fileActionSettings :{showZoom: false},//取消放大按钮，因为bootstrap的modal会导致bug
			        allowedFileExtensions: ['jpg', 'bmp', 'jpeg','png'],//接收的文件后缀
			  });
			  			  			
			  $(".edit-spuPicture-input").fileinput({
					language: 'zh',
			        showUpload: false,
			        showPreview:false,//不显示预览区域，因为bootstrap的modal会导致bug
			        maxFileSize:1024,  //单位为KB
			        showUpload: false,
			        fileActionSettings :{showZoom: false},//取消放大按钮，因为bootstrap的modal会导致bug
			        allowedFileExtensions: ['jpg', 'bmp', 'jpeg','png'],//接收的文件后缀
			  });
			  
			  
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
	                     success: function(result) { 
	                       if(result.valid == "true"){	                    	   
	                    	   $('#replace-picture-'+pictureId+' img').attr('src', rootPath+result.target);
	                    	   $(".replace-picture").val("替换").removeAttr("disabled");	
	                    	   return
	                       }	                  	  
	                       alert("替换失败")	                       
	                     },  
	                     error:function(){              				                    
	                        alert("上传请求失败");             				                        
	                     } 
	              });
				  
			   });
			  
			  //新增图片 
			  $(".add-picture").click(function(){
				  var rootPath=$(this).attr("data-rootPath");
				  var spuId = $(this).attr("data-picture-id");	
			      var targetUrl = $(this).attr("data-upload-url");	
			      var data = new FormData();
				  data.append("spuId",spuId);
				  data.append("addFile",$('#spu-scroll-addimage')[0].files[0]);				
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
	                     success: function(result) { 
	                       if(result.valid == "false"){
	                    	   alert("上传失败");
	                    	   $(".add-picture").val("上传").removeAttr("disabled");	
	                    	   return false;
	                       }else if(result.valid == "enough"){
	                    	   alert("上传失败，图片数量不可超过6张");
	                    	   $(".add-picture").val("上传").removeAttr("disabled");	
	                    	   return false;
	                       }else if(result.valid =="true"){
	                    	   alert("上传成功");
	                           $(".add-picture").val("上传").removeAttr("disabled");	
	                           //插入图片
	                           var tag ='<div  class="col-md-8" style="box-shadow: #666 0px 0px 10px; margin-top:20px;">'
	                                    +'<img src="'+newPath+'" class="img-rounded img-responsive  image-zoomify">'
	                                    +'</div>'
	        	               $("#spuPictures").before(tag);
	                       }else
	                    	   alert("请求失败")
	                    	   
	        	              
	                     },  
	                     error:function(){              				                    
	                        alert("上传请求失败"); 
	                        $(".replace-picture").val("上传").removeAttr("disabled");	
	                     } 
	              });
				  
			   });
			  
					  
			//初始化文本编辑器控件
			  $("#spu-content-edit2").summernote({
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
			                var rootPath = $("#spu-content-edit2").attr("data-fileRoot");           			
			                //请求上传地址
			                var targetUrl =$("#spu-content-edit2").attr("data-fileUploadUrl");
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
			                       $('#spu-content-edit2').summernote('insertImage', rootPath+e); 
			                     },  
			                     error:function(){              				                    
			                        alert("上传失败");             				                        
			                     } 
			                });
			          }  
			      } 
			  });
			  
			  //修改Spu基本信息:
		      $("#updateSpu1").click(function(){		    	  
		    	  var formDate = new FormData($("#editbaseSpuForm")[0]);
		    	  var targetUrl =$("#editbaseSpuForm").attr("action");
		    	  $(this).val("提交中...").attr("disabled","disabled");
		    	  $.ajax({  	                      
	                     type:'post',        
	                     url:targetUrl,                        
	                     cache: false,
	                     data:formDate, 
	                     processData: false,
	                     contentType: false,
	                     dataType:'text',
	                     success: function(flag) {   
	                    	 if(flag =="false"){
	                    		 alert("修改失败")
	                    		 $("#updateSpu1").val("修改").removeAttr("disabled");
	                    		 return false;
	                    	 }else if(flag =="true"){
	                    		 $("#updateSpu1").val("修改").removeAttr("disabled");
	 	                    	 alert("修改成功");
	 	                    	 return true;
	                    	 }	                    	
	                    	$("#updateSpu1").val("修改").removeAttr("disabled");
	                    	alert("请求失败");
	                        
	                     },  
	                     error:function(){   
	                    	 alert("请求失败"); 
	                    	 $("#updateSpu1").val("修改").removeAttr("disabled");
	                    	             				                        
	                     } 
	              });
		       })
		       
		        //修改Spu属性值:
		      $("#updateSpu2").click(function(){		    	  
		    	  var formDate = new FormData($("#editSpuOptionForm")[0]);
		    	  var targetUrl =$("#editSpuOptionForm").attr("action");
		    	  $(this).val("修改中...").attr("disabled","disabled");
		    	  $.ajax({  	                      
	                     type:'post',        
	                     url:targetUrl,                        
	                     cache: false,
	                     data:formDate, 
	                     processData: false,
	                     contentType: false,
	                     dataType:'json',
	                     success: function(flag) {   
	                    	 if(flag ==false){
	                    		 alert("修改失败")
	                    		 $("#updateSpu2").val("修改").removeAttr("disabled");
	                    		 return false;
	                    	 }	  
	                    	 alert("修改成功");
	                    	$("#updateSpu2").val("修改").removeAttr("disabled");
	                    		                        
	                     },  
	                     error:function(){              				                    
	                    	 alert("请求失败"); 
	                    	 $("#updateSpu2").val("修改").removeAttr("disabled");
	                     } 
	              });
		       })
		       
		      
		       
		        //修改Spu介绍:
		      $("#updateSpu3").click(function(){		    	  
		    	  var targetUrl =$("#updateSpu3").attr("data-url");
		    	  var spuId =$("#updateSpu3").attr("data-spuId");
		    	  var spuContent= $("#spu-content-edit2").summernote('code');
		    	  $(this).val("修改中...").attr("disabled","disabled");
		    	  $.ajax({  	                      
	                     type:'post',        
	                     url:targetUrl,                        
	                     cache: false,
	                     data:{
	                    	 "spuId":spuId,
	                    	 "spuContent":spuContent
	                     }, 
	                     dataType:'json',
	                     success: function(flag) {   
	                    	 if(flag ==false){
	                    		 alert("修改失败")
	                    		 $("#updateSpu3").val("修改").removeAttr("disabled");
	                    		 return false;
	                    	 }	                    	
	                    	$("#spu-vartar").attr("src",flag);
	                    	$("#updateSpu3").val("修改").removeAttr("disabled");
	                    	alert("修改成功");	                        
	                     },  
	                     error:function(){              				                    
	                    	 alert("请求失败"); 
	                    	 $("#updateSpu3").val("修改").removeAttr("disabled");
	                     } 
	              });
		       })
		       
		    
			
           })
                     
	  </script>
	  
   </head>
   <body>
     <!-- 编辑spu -->
     <div class="row" id="spu-edit-place" >
       <div style="margin-left:30px;margin-bottom:20px;" >
        <span class="label label-danger">Spu编号：${editSpu.spuNo}</span>
       </div>
       <div class="col-md-12">
         <div>
	      <ul class="nav nav-tabs" role="tablist">
	        <li role="presentation" class="active"><a href="#oneNode" aria-controls="oneNode" role="tab" data-toggle="tab">基本信息</a></li>
	        <li role="presentation"><a href="#twoNode" aria-controls="twoNode" role="tab" data-toggle="tab">SPU属性</a></li>	        
	        <li role="presentation"><a href="#threeNode" aria-controls="threeNode" role="tab" data-toggle="tab">SPU介绍</a></li>
	        <li role="presentation"><a href="#fourNode" aria-controls="fourNode" role="tab" data-toggle="tab">SPU图片</a></li>	        	                 	        			    
	      </ul> 
	     <div class="tab-content">
	       <div role="tabpanel" class="tab-pane active" id="oneNode">
	          <form id="editbaseSpuForm" action="${pageContext.request.contextPath}/admin/spu/spu/saveUpdateSpu" method="post" >               		            
	            <input type="text" name="id" value="${editSpu.id}" hidden="" readonly="readonly"/>
	            <div class="form-group" style="margin-top:20px;">
	              <label for="spu-name" class="control-label" >SPU名称:</label>
	              <input type="text" class="form-control" id="spu-name" name="spuName" value="${editSpu.spuName}" placeholder="请输入SPU名">
	            </div>
	            <div class="form-group">
	              <label for="categoryContext" class="control-label">标题:</label>
	              <textarea class="form-control" rows="3"  id="spu-title" name="spuTitle" placeholder="用于搜索的关键词，长度不可多余25个字">${editSpu.spuTitle}</textarea>
	            </div>
	            <div class="form-group">
	              <label for="spu-brandId" class="control-label">品牌:</label>
	              <select id="spu-brandId"  class="form-control "   name="brandId"  >
				      <c:forEach items="${categoryBrands}" var="categoryBrand" varStatus="statu">
				        <option value="${categoryBrand.brandId}" ${editSpu.brandId==categoryBrand.brandId ? 'selected="selected"' : ''}    >${categoryBrand.brandName}</option>
				      </c:forEach>			     
				  </select>
	            </div>
	            <div class="form-group">
	              <label for="spu-statu" class="control-label" >状态:</label>
	              <select id="spu-statu" class="form-control" name="spuStatu" >
			        <option    value = "1" ${editSpu.spuStatu ==1 ? 'selected="selected"' : ''} >下架</option>
		            <option    value = "2" ${editSpu.spuStatu ==2 ? 'selected="selected"' : ''}>上架</option>
		            <option    value = "3" ${editSpu.spuStatu ==3 ? 'selected="selected"' : ''}>无货</option>
		            <option    value = "4" ${editSpu.spuStatu ==4 ? 'selected="selected"' : ''}>非卖品</option>
		            <option    value = "5" ${editSpu.spuStatu ==5 ? 'selected="selected"' : ''}>赠品</option>
			     </select>
			    </div>
			    <div class="form-group">
	              <label for="spu-image" class="control-label">缩略图:</label>
	              <img id="spu-vartar" src="${pros.fictitiousRoot}${editSpu.spuImage}" class="img-rounded img-responsive image-head image-zoomify">
	              <input type="file"  class="cleanInput file-loading spu-image" id="spu-image" name="spuImage"/>
	            </div>
	            <div class=" form-group form-inline " style="margin-top:25px;">	 
			       <input id="updateSpu1" type="button" class="form-control sure-button" value="确认修改">		
	            </div>
	          </form>         	        			        	                        
            </div>
             <div role="tabpanel" class="tab-pane" id="twoNode" style="margin-top:20px;">
               <!-- 遍历Spu属性 -->
               <form id="editSpuOptionForm" action="${pageContext.request.contextPath}/admin/spu/spu/saveUpdateSpuOption" method="post" >
                <input type="text" name="spuId" value="${editSpu.id}" hidden="" readonly="readonly"/>
                <ul class="list-group">                                
                 <c:forEach items="${category.attributes}" var="attribute" varStatus="statu">
                  <li class="list-group-item">
                    <label for="" class="" style="color:black;font-size:14px;">${attribute.attributeName}:</label>
                    <div class="form-group form-inline" style="font-size: 12px;color:#076e9f;">		         
		              <c:forEach items="${attribute.options}" var="option" varStatus="statu">
		                <input class="" id="option-${option.id}" type="checkbox" name="optionIds" value="${option.id}" ${optionIds.contains(option.id) ? 'checked="checked"' : ''}/>
				        <label for="option-${option.id}" style="margin-right:20px;">${option.optionName}</label>
		              </c:forEach>				         
		            </div>     
		          </li>       
                </c:forEach>                 
               </ul>              
               <div class=" form-group form-inline " style="margin-top:25px;">	 
			       <input id="updateSpu2" type="button" class="form-control sure-button" value="确认修改">		
	           </div>
	          </form> 			        				      			     				                      	
		     </div>				    	     				                        
             <!-- Spu介绍文 -->
             <div role="tabpanel" class="tab-pane" id="threeNode">
              <div style="margin-top:20px;"></div>
              <!-- SPU介绍 -->             
              <div id="spu-content-edit2"  data-fileRoot="${pros.fictitiousRoot}" data-fileUploadUrl="${pageContext.request.contextPath}/admin/common/file/contentFileUpload">${editSpu.spuContent}</div>			    	     				   
              <div class=" form-group form-inline " style="margin-top:25px;">	 
			      <input id="updateSpu3" data-spuId="${editSpu.id}" data-url="${pageContext.request.contextPath}/admin/spu/spu/saveUpdateSpuContent" type="button" class="form-control sure-button" value="确认修改">		
	          </div>
             </div>
             
                <!-- SPU图片 -->
	         <div role="tabpanel" class="tab-pane" id="fourNode">
	           <div>
	             <c:forEach items="${spuPictures}" var="spuPicture" varStatus="statu">	            	             
	              <div id="replace-picture-${spuPicture.id}" class="col-md-8" style="box-shadow: #666 0px 0px 10px; margin-top:20px;">
	               <img src="${pros.fictitiousRoot}${spuPicture.pictureUrl}" class="img-rounded img-responsive  image-zoomify">
	              </div>
	              <div class="form-group col-md-2 form-inline" style="margin-top:40px;">             
	               <label  class="control-label" style="margin-bottom:10px;">替换图片:</label>         
	               <input type="file" id="upload-new-${spuPicture.id}"  name="replaceFile" class="file-loading edit-spuPicture-input" >
	               <input class="form-control sure-button replace-picture" type="button" value="替换" style="margin-top:20px;"
	                data-rootPath="${pros.fictitiousRoot}" data-picture-id="${spuPicture.id}"  data-upload-url="${pageContext.request.contextPath}/admin/spu/spu/replacePicture" />
	              </div>	        	             
	             </c:forEach>
	             <c:if test="${spuPictures.size()<6}">
	               <div id="spuPictures" class="form-group col-md-8" style="margin-top:20px;"></div>
	               <div  class="form-group col-md-2 form-inline" style="margin-top:20px;">
	                <label for="sonCategoryName" class="control-label" style="margin-bottom:10px;">新增图片:</label>
	                <input type="file"  id="spu-scroll-addimage" name="addImage"  class=" file-loading edit-spuPicture-input">
	                <input class="form-control sure-button add-picture" type="button" value="上传" style="margin-top:20px;"
	                data-rootPath="${pros.fictitiousRoot}" data-picture-id="${editSpu.id}"  data-upload-url="${pageContext.request.contextPath}/admin/spu/spu/addPicture" />
	               </div>	     	 
	             </c:if>
	             
	           </div>	                	           
	         </div>
	       </div>			       
        </div>
      </div>	       	
   </div>  
 </body>
</html>





   
 