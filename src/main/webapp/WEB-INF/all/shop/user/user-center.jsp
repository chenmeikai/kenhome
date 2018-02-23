<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>凯之家用户中心(测试)
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      
      <!-- font样式 -->
      <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
      
      <!--时间控件-->
	  <link href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.css" rel="stylesheet">
	  
	  <!-- 验证样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/validate2/bootstrapValidator.min.css" rel="stylesheet">
	  
	  <!-- 上传样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/fileinput/bootstrap-fileinput.min.css" rel="stylesheet">
     	  
	  <link href="${pageContext.request.contextPath}/resources/css/shop/common.css" rel="stylesheet">
	  	  
	  <style type="text/css">	    
	    .cart-bar{background-color:#9f1212;margin-top:40px;margin-bottom:20px;}
	    .cart-a:hover .cart-car {color:#d9edf7;}
	    .cart-car{font-size:30px;color:white;}
	    .cart-logo{color:white;font-size:12px;font-weight:bold;}
		.cart-line{line-height:60px;}
		.center-leftbar>li a{padding:15px 0px;text-align:center;font-size:15px;}
		.avatar-img{width:100%;height:auto;}
		.order-account{color:white;font-size:15px;font-weight:600;}
		.order-commend-line{font-size:16px;color:#999;font-weight:600;margin-top:20px;padding-bottom:5px;border-bottom:1px solid rgba(0, 0, 0, 0.13);margin-bottom:20px;}
        .order-commend-line2{font-size:16px;color:#999;font-weight:600;margin-top:0px;padding-bottom:5px;border-bottom:1px solid rgba(0, 0, 0, 0.13);margin-bottom:20px;}	
        .order-commend-line3{font-size:16px;color:#999;font-weight:600;margin-top:40px;padding-bottom:5px;border-bottom:1px solid rgba(0, 0, 0, 0.13);margin-bottom:20px;}			
		.order-commend-line-left{padding-bottom:7px;}
		.input-box{padding:0px;margin-bottom:20px;}
	    .cart{min-height:800px;}		
		.cart-head{border-bottom:1px solid #9f1212;padding-bottom:5px;margin-top:50px;font-size:17px;font-weight:600;color:#b00303;}
		.cart-head-left{padding-bottom:3px;margin-top:14px;}
		.cart-text-style{color:#7b8588;font-size:12px;}
		.cart-text-style2{color:#7b8588;font-size:12px;}
		 #sex-man,#sex-woman{margin-left:20px;}
		.messages-box{min-height:600px;}
		.settings-box{min-height:600px;}
		.cart-head-title{height:40px;border:1px solid #f2f2f2;padding:0px 30px; line-height:40px;text-align:center;margin-bottom:20px;background-color:#f5f5f5;color:#7b8588;}		
		.cart-head-title2{margin-top:20px;height:40px;border:1px solid #f2f2f2;line-height:40px;text-align:center;margin-bottom:15px;background-color:#e5e5e5;color:#7b8588;}			  
		.main-search-input{margin-top:16px;}
		.main-search-span button{ margin-top:5px;}
		.is-select-hide{display:none;}
		.ship-address-list{text-align:center;}
		.panel:hover{background-color:#eaf3f7;}
		.cart-goods:hover .is-select-hide {display:block;}
	  </style>
	 	  	
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
	  
	  <!-- 上传控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/fileinput/bootstrap-fileinput.min.js"></script>
	  <!-- extend 中文 -->
	  <script src="${pageContext.request.contextPath}/resources/js/fileinput/fileinput-zh.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/shop/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			  
			     /**
			      * 时间插件
			      */
			     $('.datetimepicker').datetimepicker({
			    	    language:  'zh-CN',
			    	    format: 'yyyy-mm-dd',
			            weekStart: 1,
			            todayBtn:  1,
			            autoclose: 1,
			            todayHighlight: 1,
			            startView: 2, //这里就设置了默认视图
			            minView: 2, //设置最小视图
			            forceParse: 0,
			    	    
			      });
			  
			    //初始化文件上传控件
			    $("#center-file").fileinput({
					language: 'zh',
			        showUpload: false,
			        showPreview:true,
			        maxFileSize:500,  //单位为KB
			        showUpload: false,
			        fileActionSettings :{showZoom: true},
			        allowedFileExtensions: ['jpg', 'bmp', 'jpeg','png'],//接收的文件后缀
			    });
			    
			      //替换图片
				  $("#center-replace-image").click(function(){	
				      var targetUrl = $(this).attr("data-url");	
				      var data = new FormData();
					  data.append("replaceFile",$('#center-file')[0].files[0]);				
				      if (data == null) return false;
				      $(this).val("替换中").attr("disabled","disabled");			      
				      $.ajax({  	                      
		                     type:'post',        
		                     url:targetUrl,                        
		                     cache: false,
		                     data:data, 
		                     processData: false,
		                     contentType: false,
		                     dataType:'json',
		                     success: function(result) { 
		                       if(result.valid == "true"){
		                    	   $('#center-show-img').attr('src',result.valid);
		                    	   $("#center-replace-image").val("替换").removeAttr("disabled");	
		                    	   return
		                       }else
		                    	   if(result.valid == "noUser"){
		                    		   window.location.href=result.target;
		                    		   return
		                    	   }else
		                            bootbox.alert("替换失败")	
		                            $("#center-replace-image").val("替换").removeAttr("disabled");	
		                     },  
		                     error:function(){              				                    
		                    	 bootbox.alert("上传请求失败");  
		                    	 $("#center-replace-image").val("替换").removeAttr("disabled");	
		                     } 
		              });
					  
				   });
			      
			      //保存个人资料
			      $("#submit-center-base").on("click",function(){
			    	  $("#submit-center-base").text("保存中").addClass("disabled");
			    	   var data =$("#cneterForm").serialize();
			    	   var targetUrl =$("#cneterForm").attr("action");
			    	   $.ajax({
			    		   type:'post',
			    		   url :targetUrl,
			    		   data:data,
			    		   dataType:'json',
			    		   success:function(result){
			    			   if(result.valid =="noUser"){
			    				   $("#submit-center-base").text("重新保存").removeClass("disabled");
			    				   window.location.href=result.target;
			    				   return;
			    			   }
			    			   else if(result.valid ="true"){
			    				   $("#submit-center-base").text("重新保存").removeClass("disabled");
			    				   bootbox.alert("保存成功");
			    				   return;
			    			   }
			    			   $("#submit-center-base").text("重新保存").removeClass("disabled");
		    				   bootbox.alert("保存失败");
			    			   
			    		   },
			    		   error:function(){
			    			   bootbox.alert("请求失败");
			    			   $("#submit-center-base").text("重新保存").removeClass("disabled");
			    		   }
			    	   });
			      });
			      
			      
			      //新增收货地址
			      $("#submit-ship").on("click",function(){
			    	  $("#submit-ship").text("提交中").addClass("disabled");
			    	   var data =$("#shipForm").serialize();
			    	   var targetUrl =$("#shipForm").attr("action");
			    	   $.ajax({
			    		   type:'post',
			    		   url :targetUrl,
			    		   data:data,
			    		   dataType:'json',
			    		   success:function(result){
			    			   if(result.valid =="noUser"){
			    				   $("#submit-ship").text("确认新增").removeClass("disabled");
			    				   window.location.href=result.target;
			    				   return;
			    			   }
			    			   else if(result.valid ="true"){
			    				   $("#submit-ship").text("确认新增").removeClass("disabled");
			    				   bootbox.alert("新增成功");
			    				   return;
			    			   }
			    			   $("#submit-ship").text("确认新增").removeClass("disabled");
		    				   bootbox.alert("新增失败");
			    			   
			    		   },
			    		   error:function(){
			    			   bootbox.alert("请求失败");
			    			   $("#submit-ship").text("确认新增").removeClass("disabled");
			    		   }
			    	   });			    	  
			      });
			      
			      //编辑收货地址
			      $("#submitedit").on("click",function(){
			    	  $("#submitedit").text("提交中").addClass("disabled");
			    	   var data =$("#shipForm2").serialize();
			    	   var targetUrl =$("#shipForm2").attr("action");
			    	   $.ajax({
			    		   type:'post',
			    		   url :targetUrl,
			    		   data:data,
			    		   dataType:'json',
			    		   success:function(result){
			    			   if(result.valid =="noUser"){
			    				   $("#submitedit").text("确认").removeClass("disabled");			    				   		  		        		 			  		        	 
			    				   window.location.href=result.target;
			    				   $("#editEntity").modal("hide");	
			    				   return;
			    			   }
			    			   else if(result.valid ="true"){
			    				   var editShipAddress =result.editShipAddress;
			    				   $("#submitedit").text("确认").removeClass("disabled");
			    				   $("#editEntity").modal("hide");
			    				   $("#ship-address-"+editShipAddress.id).find("div").eq(0).text(editShipAddress.shipName);
			    				   $("#ship-address-"+editShipAddress.id).find("div").eq(1).find("span").eq(0).text(editShipAddress.province);
			    				   $("#ship-address-"+editShipAddress.id).find("div").eq(1).find("span").eq(1).text(editShipAddress.city);
			    				   $("#ship-address-"+editShipAddress.id).find("div").eq(1).find("span").eq(2).text(editShipAddress.county);
			    				   $("#ship-address-"+editShipAddress.id).find("div").eq(2).text(editShipAddress.address);
			    				   $("#ship-address-"+editShipAddress.id).find("div").eq(3).text(editShipAddress.zipCode);
			    				   $("#ship-address-"+editShipAddress.id).find("div").eq(4).text(editShipAddress.phone);
			    				   setTimeout(function(){bootbox.alert("修改成功")},500) ;
			    				   return;
			    			   }
			    			   $("#submitedit").text("确认").removeClass("disabled");
			    			   $("#editEntity").modal("hide");
			    			   setTimeout(function(){bootbox.alert("修改失败")},500) ;
		    				   		    			   
			    		   },
			    		   error:function(){
			    			   $("#editEntity").modal("hide");
			    			   setTimeout(function(){bootbox.alert("请求失败")},500) ;
			    			   $("#submitedit").text("确认").removeClass("disabled");
			    		   }
			    	   });			    	  
			      });
			      
			      					 
		    });
		         //获得下级地区
	            function getSonArea(object,next){
	       
		        	var dataUrl =$(object).find("option:selected").attr("data-url");
                    $.get(dataUrl,function(result){
                    	//清除旧的下级地区 
                    	if($(object).attr("id")=='center-address-first'){
                    		$("#center-address-second").empty();
                    		$("#center-address-third").empty();
                    	}
                    	if($(object).attr("id")=='ship-address-first'){
                    		$("#ship-address-second").empty();
                    		$("#ship-address-third").empty();
                    	}
                    	if($(object).attr("id")=='ship-address-first2'){
                    		$("#ship-address-second").empty();
                    		$("#ship-address-third").empty();
                    	}
                    	$("#"+next).empty();
                    	$("#"+next).append('<option value="">请选择</option>'); 
                    	$.each(result.sonAreas,function(i,sonArea){
                    	  var tag1 ='<option value="'+
                    	           sonArea.name+
                    	           '" data-url="'+
                    	           result.rootUrl+
                    	           '/shop/area/getNext/'+
                    	           sonArea.id+
                    	           '">'+
                    	           sonArea.name+
                    	           '</option>'     
                    	  var tag2 ='<option value="'+
                    	           sonArea.id+
                    	           '" data-url="'+
                    	           result.rootUrl+
                    	           '/shop/area/getNext/'+
                    	           sonArea.id+
                    	           '">'+
                    	           sonArea.name+
                    	           '</option>' 
                    	  //如果是个人资料的地址         
                    	  if(next=="center-address-second" ||next=="center-address-third"){
                    		  $("#"+next).append(tag1);
                    	  }
                    	  //如果是收货地址
                    	  if(next=="ship-address-second" ||next=="ship-address-third"){
                    		  $("#"+next).append(tag2);
                    	  }
                    	  //如果是编辑的收货地址
                    	  if(next=="ship-address-second2" ||next=="ship-address-third2"){
                    		  $("#"+next).append(tag2);
                    	  }  
                    	});
                    })
	            }
		         
		         //设置默认收货地址
		         function setIsSelect(targetUrl,object){
		        	 $.get(targetUrl,function(result){
		        		 //如果未登录
		        		 if(result.valid =="noUser"){
		        			 window.location.href=result.target;
		        			 return;
		        		 }else 
		        			 if(result.valid="true"){
		        				 $(".panel:first").find(".col-md-1").eq(2).addClass("is-select-hide").find("a").removeClass("disabled").text("设置默认");		        				 
		        				 $(object).addClass("disabled").text("默认地址");
		        				 $(object).parent().removeClass("is-select-hide");
		        				 $(object).parents(".panel").prependTo(".ship-address-list");
		        				 
		        				 return;
		        			 }
		        		 bootbox.alert("设置失败")
		        	 });
		         }
		         
		         //编辑收货地址
		         function edit(targetUrl){
		        	 
		        	 $(".modal-body").load(targetUrl);
		        	 $("#editEntity").modal({
		        		 backdrop: 'static'
		        	 })
		         }
		         
		        //删除收货地址
		        function deleteByID(targetUrl,object){
		        	var targetTag = $(object).parents(".panel");
		        	$.get(targetUrl,function(result){
		        		 //如果未登录
		        		 if(result.valid =="noUser"){
		        			 window.location.href=result.target;
		        			 return;
		        		 }else 
		        			 if(result.valid="true"){
		        				 //移除该tag
		        			     targetTag.fadeTo("slow", 0.01, function(){//fade
		                    			targetTag.slideUp(50, function() {//slide up
		                    				targetTag.remove();
		                    		    });
		                    	 });	 
		        				 
		        				 return;
		        		 }
		        		 bootbox.alert("设置失败")
		        	 });		        	
		        }
	 </script>	 	  
   </head>
   <body>
     <!--固定提示-->
     <div class="shop-warning">个人测试网站 不可购物</div>
     
     <!-- 头部导航栏 -->
     <%@ include file="/WEB-INF/all/include/shop-begin.jsp"%>
     
     
      <!-- 导航栏-->
	  <div class="cart-bar">
	    <div class="container cart-line ">
	      <div class="row">
		     <div class="col-md-3">
		      <a href="${pageContext.request.contextPath}/shop/user/center" class="cart-a">
				<i class="fa fa-address-card cart-car"></i>
				<span class="cart-logo">凯之家</span>
			  </a>
		     </div>
			 <div class="col-md-1">
			   <div class="text-margintop-30">
			     <a href="${pageContext.request.contextPath}/shop/user/center" class="order-account">
			            账号设置
			     </a>
			   </div>		      
		     </div>		  
			  <div class="col-md-6 col-md-offset-2">
				<div class="input-group">
				  <input type="text" class="form-control main-search-input" placeholder="商品...">
				  <span class="input-group-btn main-search-span ">
					<button class="btn btn-default " type="button"><i class="glyphicon glyphicon-search"></i></button>
				  </span>
				</div>				
			  </div>
		  </div>
		</div>	   
	   </div>
     
   <div class="container">
    <div class="row">
      <!-- 左边栏 -->      
      <div class="col-md-2">  
		   <ul class="nav nav-pills nav-stacked center-leftbar" role="tablist">
			  <li class=""><img class="avatar-img" src="${pageContext.request.contextPath}/resources/image/avatar/superManager.jpg"  /></li>
			  <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">个人资料</a></li>
              <li role="presentation"><a href="#address" aria-controls="profile" role="tab" data-toggle="tab">收货地址</a></li>
              <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">我的消息</a></li>
              <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">安全设置</a></li>			  
		   </ul>
	  </div>	 
     <!-- 右边栏 -->
     <div class="col-md-10 tab-content">
      <!-- 个人资料 -->
      <div role="tabpanel" class="tab-pane active" id="home">
        <div class="row">
           <div class="col-md-12 order-commend-line">
		     <span class="order-commend-line-left">个人资料</span>
		   </div>
        </div> 
        <div class="row" id="center-base-place" >	     
	       <div class="col-md-12">		     		     
		        <div class="input-box col-md-12">  		                         		            
	              <div class="form-group col-md-3" >
	                <label for="sku-skuName" class="control-label" >头像:</label>
	                <img id="center-show-img" class="avatar-img" src="${pros.fictitiousRoot}${user.avatar}"/>
	                <input type="file" class="form-control file-loading" id="center-file" name="avatar">
	              </div>
	              <div class="form-group col-md-2" >
	                <label for="sku-skuName" class="control-label" >&nbsp;</label>
	                <input type="button" class="form-control btn btn-default" id="center-replace-image" data-url="${pageContext.request.contextPath}/shop/user/replaceAvatar" value="替换">
	              </div>	              
	            </div>	
	            <form id="cneterForm" action="${pageContext.request.contextPath}/shop/user/update" method="post">  
	            <div class="input-box col-md-12"> 	            
	              <div class="form-group col-md-4">
	                <label for="center-userName" class="control-label">姓名:</label>
	                <input type="text" class="form-control" id="center-userName" name="userName" value="${user.userName}" placeholder="请输入姓名">
	              </div>
	            </div>	
	            <div class="input-box col-md-12">        
	              <div class="form-group col-md-4">
	                 <label for="center-nickname" class="control-label">昵称:</label>
	                 <input type="text" class="form-control" id="center-nickname" name="nickname" value="${user.nickname}" placeholder="请输入昵称">
	              </div>	
	            </div>
	            <div class="input-box col-md-12">             
	              <div class="form-group col-md-4">
	                <label for="spu-name" class="sku-originalPrice" >性别:</label>
	                <input type="radio"  id="sex-man" name="sex" value="1" ${user.sex ==1 ? 'checked="checked"' : null}>
	                <label for="sex-man" class="" >男</label>
	                <input type="radio" class="" id="sex-woman" name="sex" value="2" ${user.sex ==2 ? 'checked="checked"' : null}>	                
	                <label for="sex-woman" class="" >女</label>
	              </div>
	            </div> 
	            <div class="input-box col-md-12">  		                         		            
	              <div class="form-group col-md-3" >
	                <label for="center-year" class="control-label" >生日:</label>
	              
	                <input type="text" class="form-control datetimepicker reset" placeholder="生日" name="birthday" value="<fmt:formatDate type="date" value="${user.birthday}" dateStyle="default"/>" id="center-birthday" >
	              </div>	             
	            </div>
	            <div class="input-box col-md-12">  		                         		            
	              <div class="form-group col-md-2" >
	                <label for="center-address-first" class="control-label" >居住地:</label>
	                <select id="center-address-first" class="form-control" name="province" onchange="getSonArea(this,'center-address-second')">
	                   <option>请选择地区</option>
	                  <c:forEach items="${rootAreas}" var="rootArea" varStatus="statu">
	                    <option value="${rootArea.name}" data-url="${pageContext.request.contextPath}/shop/area/getNext/${rootArea.id}" ${user.province eq rootArea.name? 'selected="selected"' :null}>${rootArea.name}</option>
	                  </c:forEach>	                  	                  
	                </select>
	              </div>
	              <div class="form-group col-md-2" >
	              <label for="center-address-second" class="control-label" >&nbsp;</label>
	              <select id="center-address-second" class="form-control" name="city" onchange="getSonArea(this,'center-address-third')">	                                 
	                 <option value="">请选择</option>
	                <c:if test="${user.city != null}">
	                 <option value="${user.city}" selected="selected">${user.city}</option>
	                </c:if>
	                
	              </select>
	              </div>
	              <div class="form-group col-md-2" >
	                <label for="center-address-third" class="control-label" >&nbsp;</label>
	                <select id="center-address-third" class="form-control col-md-3" name="county"> 
	                   <option value="">请选择</option>
	                  <c:if test="${user.county != null}">
	                   <option value="${user.county}" selected="selected">${user.county}</option>
	                  </c:if>                  
	                </select>
	              </div>
	            </div>	 	          		        	                       
	          </form> 
	        </div>
	     </div>	 
	     <div class="row">
		   <div class="col-md-12 order-commend-line2">
		   </div>
		 </div> 
	     <div class="row">
	       <div class="form-group col-md-2">
	         <button type="button" class="btn btn-primary form-control" id="submit-center-base" style="box-shadow: #666 0px 0px 10px;">保存</button> 
	       </div>
	     </div>   
      </div>
	  <div id="address" class="cart tab-pane "  role="tabpanel">
	     <!-- 收货地址 -->
	   <div class="row">
		   <div class="col-md-12 order-commend-line">
		     <span class="order-commend-line-left">新增收货地址</span>
		   </div>
	   </div>
	   <div class="row" id="center-address-place" >	     
	       <div class="col-md-12">		     
		     <form id="shipForm" action="${pageContext.request.contextPath}/shop/ship/add" method="post">
		        <div class="input-box col-md-12">  		                         		            
	              <div class="form-group col-md-3" >
	                <label for="ship-address-first" class="control-label" >所在地区:</label>
	                <select id="ship-address-first" class="form-control" name="provinceId" onchange="getSonArea(this,'ship-address-second')">
	                    <option>请选择地区</option>
	                  <c:forEach items="${rootAreas}" var="rootArea" varStatus="statu">
	                    <option value="${rootArea.id}" data-url="${pageContext.request.contextPath}/shop/area/getNext/${rootArea.id}">${rootArea.name}</option>
	                  </c:forEach>	                  	                  
	                </select>
	              </div>
	              <div class="form-group col-md-3" >
	              <label for="ship-address-second" class="control-label" >&nbsp;</label>
	              <select id="ship-address-second" class="form-control" name="cityId" onchange="getSonArea(this,'ship-address-third')">
	                <option value="">请选择</option>
	              </select>
	              </div>
	              <div class="form-group col-md-3" >
	                <label for="ship-address-third" class="control-label" >&nbsp;</label>
	                <select id="ship-address-third" class="form-control" name="countyId">
	                 <option value="">请选择</option>
	                </select>
	              </div>	            
	            </div>	  
	            <div class="input-box col-md-12"> 	            
	              <div class="form-group col-md-6">
	                <label for="ship-address" class="control-label">详细地址:</label>
	                <textarea class="form-control" rows="4"  id="ship-address" name="address" placeholder="建议您如实填写详细收货地址，例如街道名称，门牌号码，楼层和房间号等信息，建议您如实填写详细收货地址，例如街道名称，门牌号码，楼层和房间号等信息"></textarea>
	              </div>
	            </div>	
	            <div class="input-box col-md-12">        
	              <div class="form-group col-md-3">
	                 <label for="ship-zipCode" class="control-label">邮政编码:</label>
	                 <input type="text" class="form-control" id="ship-zipCode" name="zipCode" placeholder="请输入邮政编码">
	              </div>	
	            </div>
	            <div class="input-box col-md-12">             
	              <div class="form-group col-md-3">
	                <label for="ship-shipName" class="sku-originalPrice" >收货人姓名:</label>
	                <input type="text" class="form-control" id="ship-shipName" name="shipName" placeholder="请输入姓名，不可超过25字">
	              </div>
	            </div>  
	            <div class="input-box col-md-12"> 
	              <div class="form-group col-md-3">
	                <label for="ship-phone" class="control-label" >电话/手机号码:</label>
	                <input type="text" class="form-control" id="ship-phone" name="phone" placeholder="请输入电话/手机号码">
	              </div>
	            </div>
	            <div class="input-box col-md-12">
	              <div class="form-group col-md-2">	              
	                <input  type="checkbox" class="" id="ship-isSelect" name="isSelect" value="2">
	                <label for="ship-isSelect" class="" >设置为默认收货地址</label>
	              </div>
	            </div>    			        	                       
	          </form> 
	        </div>
	     </div>	
	     <div class="row">
		   <div class="col-md-12 order-commend-line2">
		   </div>
		 </div> 
	     <div class="row">
	       <div class="form-group col-md-2">
	         <button type="button" class="btn btn-primary form-control" id="submit-ship" style="box-shadow: #666 0px 0px 10px;">确认新增</button> 
	       </div>
	     </div>  
	    
	    <!--收货地址-->
		<div class="row">
		   <div class="col-md-12 order-commend-line3">
		     <span class="order-commend-line-left">收货地址</span>
		   </div>
		</div>
		<div class="row cart-head-title">		 
		  <div class="col-md-1">收货人</div>
		  <div class="col-md-2">收货地区</div>
		  <div class="col-md-3">详细地址</div>
		  <div class="col-md-1">邮编</div>
		  <div class="col-md-2">电话/手机</div>
		  <div class="col-md-2">操作</div>
		  <div class="col-md-1">默认</div>
		</div>
		<div class="row ship-address-list">
		  <c:forEach items="${shipAddresses}" var="shipAddress" varStatus="statu">
		  <div  class="panel panel-default col-md-12">
		    <div id="ship-address-${shipAddress.id}" class="panel-body cart-goods">	
		      	<div class="col-md-1">${shipAddress.shipName}</div>
				<div class="col-md-2"><span>${shipAddress.province}</span><span>${shipAddress.city}</span><span>${shipAddress.county}</span></div>
				<div class="col-md-3">${shipAddress.address}</div>
				<div class="col-md-1">${shipAddress.zipCode}</div>
				<div class="col-md-2">${shipAddress.phone}</div>
				<div class="col-md-2">
				  <a href="javascript:;" onClick="edit('${pageContext.request.contextPath}/shop/ship/getEdit/${shipAddress.id} #center-address-place2')" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>编辑</span></a>
				  <a href="javascript:;" onClick="deleteByID('${pageContext.request.contextPath}/shop/ship/delete/${shipAddress.id}',this)" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span>删除</span></a>
				</div>
				<c:if test="${shipAddress.isSelect==2}">
				<div class="col-md-1">
				  <a href="javascript:;" onClick="setIsSelect('${pageContext.request.contextPath}/shop/ship/setIsSelect/${shipAddress.id}',this)"  class="btn btn-info btn-xs disabled">&nbsp;<span>默认地址</span></a>				  
				</div> 
				</c:if>
				<c:if test="${statu.count>=2}">
				<div class="col-md-1 is-select-hide ">
				  <a href="javascript:;" onClick="setIsSelect('${pageContext.request.contextPath}/shop/ship/setIsSelect/${shipAddress.id}',this)" class="btn btn-info btn-xs">&nbsp;<span>设置默认</span></a>				  
				</div> 
				</c:if>   
			</div>
		  </div>
		 </c:forEach>
	    </div>
	    <div class="row">
		   <div class="col-md-12 order-commend-line2">
		   </div>
		</div>          	
	  </div>
	  <!-- 个人消息 -->		 
      <div role="tabpanel" class="tab-pane" id="messages">
        <div class="row">
           <div class="col-md-12 order-commend-line">
		     <span class="order-commend-line-left">我的消息</span>
		   </div>
        </div>  
        <div class="messages-box">暂无消息</div>   
        
        
      </div>
      <!-- 安全设置 -->
      <div role="tabpanel" class="tab-pane" id="settings">
        <div class="row">
           <div class="col-md-12 order-commend-line">
		     <span class="order-commend-line-left">安全设置</span>
		   </div>
        </div>
        <div class="messages-box">
          <div class="row" id="center-message-place" >	     
	       <div class="col-md-12">		     
		     <form id="skuForm" action="${pageContext.request.contextPath}/admin/spu/spu/saveAddSku" method="post" enctype="multipart/form-data">		       
		        <div class="input-box col-md-12">  		                         		            
	              <div class="form-group col-md-3" >
	                <label for="sku-skuName" class="control-label" >手机号:</label>
	                <input type="text" class="form-control" id="sku-originalPrice" name="originalPrice" value="13570282684" readonly="readonly">
	              </div>
	              <div class="form-group col-md-2" >
	              <label for="sku-skuName" class="control-label" >&nbsp;</label>
	             <input type="button" class="form-control btn btn-default" onclick="window.location.href='#'" id="safe-phone" name="safe-phone" value="解绑">
	              </div>	           	             
	            </div>
	            <div class="input-box col-md-12">  		                         		            
	              <div class="form-group col-md-3" >
	                <label for="sku-skuName" class="control-label" >邮箱:</label>
	                <input type="text" class="form-control" id="sku-originalPrice" name="originalPrice" value="562899487@qq.com" readonly="readonly">
	              </div>
	              <div class="form-group col-md-2" >
	              <label for="sku-skuName" class="control-label" >&nbsp;</label>
	             <input type="button" class="form-control btn btn-default" id="safe-email" onclick="window.location.href='#'" name="safe-email" value="修改">
	              </div>	           	             
	            </div>	
	            <div class="input-box col-md-12">  		                         		            
	              <div class="form-group col-md-3" >
	                <label for="sku-skuName" class="control-label" >密码:</label>
	                <input type="text" class="form-control " id="sku-originalPrice" name="originalPrice" value="*******" readonly="readonly">
	              </div>
	              <div class="form-group col-md-2" >
	              <label for="sku-skuName" class="control-label" >&nbsp;</label>
	              <input type="button" class="form-control btn btn-default" id="safe-password" onclick="window.location.href='#'"  name="safe-password" value="修改">
	              </div>	           	             
	            </div>  	            	           		        	                       
	          </form> 
	        </div>
	     </div>
	     <div class="row">
		   <div class="col-md-12 order-commend-line2">
		   </div>
		</div> 
	    </div>     
      </div>  
	 </div>
	</div>
   </div> 
	   	
   
       <!-- 编辑收货地址 -->  
	  <div class="modal fade " id="editEntity" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
	    <div class="modal-dialog modal-lg" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="editModalLabel">编辑收货地址</h4>
	        </div>
	        <div class="modal-body">
	          
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	          <button type="button" class="btn btn-primary" id="submitedit">确认</button>
	        </div>
	      </div>
	    </div>
	  </div>	
  
      
 
      
      
      
      <!-- 结束导航栏 -->
     <%@ include file="/WEB-INF/all/include/shop-end.jsp"%>
     
  
   </body>
</html>