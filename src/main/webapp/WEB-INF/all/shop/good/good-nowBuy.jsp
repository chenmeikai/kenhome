<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>凯之家下单页面(测试)
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      
      <!-- font样式 -->
      <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
     	  
	  <link href="${pageContext.request.contextPath}/resources/css/shop/common.css" rel="stylesheet">
	  	  
	  <style type="text/css">
	    
	    .cart-bar{height:60px;background-color:#9f1212;margin-top:40px;}
	    .cart-a:hover .cart-car {color:#d9edf7;}
	    .cart-car{font-size:30px;color:white;}
	    .cart-logo{color:white;font-size:12px;font-weight:bold;}
		.cart-line{line-height:80px;}
		.order-leftbar{margin-top:40px;}
		.order-account{color:white;font-size:15px;font-weight:600;}
		.order-commend-line{font-size:16px;color:#999;font-weight:600;margin-top:20px;padding-bottom:5px;border-bottom:1px solid rgba(0, 0, 0, 0.13);margin-bottom:20px;}
        .order-commend-line2{font-size:16px;color:#999;font-weight:600;margin-top:0px;padding-bottom:5px;border-bottom:1px solid rgba(0, 0, 0, 0.13);margin-bottom:20px;}				
		.order-commend-line-left{padding-bottom:7px;}
		#new-address{font-size:12px;}
		#manage-address{font-size:12px;}
		.cartSku-all-select{font-size:10px;}
		.order-account:hover{color:#d9edf7;}
	    .cart{min-height:800px;}		
		.cart-head{border-bottom:1px solid #9f1212;padding-bottom:5px;margin-top:50px;font-size:17px;font-weight:600;color:#b00303;}
		.cart-head-left{padding-bottom:3px;margin-top:14px;}
		.cart-text-style{color:#7b8588;font-size:12px;}
		.cart-text-style2{color:#7b8588;font-size:12px;}
		.cart-head-title{margin-top:20px;height:40px;border:1px solid #f2f2f2;line-height:40px;text-align:center;margin-bottom:20px;background-color:#f5f5f5;color:#7b8588;}
		.cart-goods{text-align:center;font-size:14px;color:black;min-height:120px;}		
		.cartSku-single-select{font-size:10px;color:#7b8588;}
		.cart-product{width:100px;height:auto;}
		.cart-sku-nums{margin:0px;}				
		.cart-image-message{padding:0px;text-align:left;}
		.cart-image-message span{font-size:12px;}
		.cart-head-title2{margin-top:20px;height:40px;border:1px solid #f2f2f2;line-height:40px;text-align:center;margin-bottom:15px;background-color:#e5e5e5;color:#7b8588;}
		.cart-cut-line{border-bottom:1px solid #9f1212;margin-top:10px;margin-bottom:20px;}
		.cart-cut-line2{border-bottom:1px solid #9f1212;margin-top:5px;margin-bottom:20px;}
		.order-sure-box{border:1px solid #c5dcf3;height:250px;box-shadow: #666 0px 0px 10px;}
		#order-submit{background-color:#ff0036;color:white;margin-top:15px;font-weight:bold;height:50px;}
		.order-price{margin-top:20px;text-align:right;}
		.order-logistic-address{margin-top:30px;text-align:right;margin-bottom:10px;}
		.order-logistic-user{margin-bottom:10px;text-align:right;}
	    .text-price-name{font-size:18px;font-weight:bold;}
	    .text-price-logo{font-size:15px;font-weight:bold;color:#7c6969;}
	    .text-price-value{font-size:25px;font-weight:bold; color:#ff0036;}
		.cart-all-sumPrice{font-size:15px;font-weight:bold;}
		.button-disabled{background-color:#eee;border:1px solid #b3949b;color:#b1afaf;pointer-events: none; cursor:default;opacity: 0.8;}
		.autu-add input{float:left;width:30px;height:32px;padding:5px;text-align:center;margin-left:12px;}
		.cart-address{text-align:left;}		
		.autu-add span{float:left;display:block;width:15px;text-align:center;border-radius:5px;color: #3c763d;font-size:5px;
		               background-color: #ffffff;
		               border-color: #3c763d;			   
		}
		.main-search-input{margin-top:16px;}
		.main-search-span button{ margin-top:-15px;}
		.buy-address-active{border:2px solid #9f1212;}
		.each-address:hover{border:2px dotted #9f1212;}
		.cart-address-style1{margin-bottom:15px;word-spacing:10px;letter-spacing:1px;font-size:15px;color:#675f5f;}
		.cart-address-style2{margin-bottom:15px;word-spacing:10px;letter-spacing:1px;font-size:14px;color:#675f5f;}
		.cart-address-style3{margin-bottom:10px;letter-spacing:1px;font-size:12px;color:#675f5f;}
		.cart-calculate{background-color:#e5e5e5;padding-top:15px;font-size:16px;}
		
		.cart-calculate>.btn>a{font-size:16px;color:white;}
		.good-option-active{position:absolute;color:#9f1212;bottom:2px;right:2px;}
		
		.good-proom-list{display:block;;text-align:center;height:auto;padding-bottom:10px;}
		.good-proom-list>img{position:relative; width:100%; height:auto;}
	    .cart-goods-box{min-height:400px;max-height:400px;}
	    .cart-goods-box:hover{border:2px solid #bce8f1;}
	    .cart-goods-body{min-height:350px;max-height:350px;}
	    .cart-goods-foot{min-height:47px;max-height:47px;text-align:center;background-color:#f5f5f5;}
	  </style>
	 	  	
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/shop/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			  
			  //新收获地址窗口
			  $("#new-address").on("click",function(){
				  $("#addEntity").modal({backdrop: 'static'});	        		 		        	 
			  });
			 
			  //使用新增收货地址
			  $("#submitadd").on("click",function(){
		    	  $("#submitadd").text("提交中").addClass("disabled");
		    	   var data =$("#shipForm").serialize();
		    	   var targetUrl =$("#shipForm").attr("action");
		    	   $.ajax({
		    		   type:'post',
		    		   url :targetUrl,
		    		   data:data,
		    		   dataType:'json',
		    		   success:function(result){
		    			   if(result.valid =="noUser"){
		    				   $("#submit-ship").text("确认").removeClass("disabled");
		    				   window.location.href=result.target;
		    				   $("#addEntity").modal("hide");
		    				   return;
		    			   }
		    			   else if(result.valid ="true"){
		    				   $("#submitadd").text("确认").removeClass("disabled");
		    				   $("#addEntity").modal("hide");
		    				   var newShipAddress=result.newShipAddress;
		    				   var tag ='<div id="" class="each-address panel panel-default col-md-3 buy-address-active" data-id="'+newShipAddress.id+'">'+
		    				               '<div class="panel-body cart-address">'+
		    				                 '<div class="cart-address-style1">'+
		    				                 '<span>'+newShipAddress.shipName+'</span>'+
		    				                    '<span>'+newShipAddress.phone+'</span>'+
		    				                 '</div>'+
		    				                 '<div class="cart-address-style2">'+
		    				                 '<span>'+newShipAddress.province+'</span>'+
		    				                    '<span>'+newShipAddress.city+'</span>'+
		    				                    '<span>'+newShipAddress.county+'</span>'+		        
		    				                  '</div>'+
		    				                  '<div class="cart-address-style3">'+
		    				                     '<span>'+newShipAddress.address+'</span>'+
		    				                  '</div>'+		  
		    					            '</div>'+
		    					            '<i class="fa fa-check fa-lg good-option-active"></i>'+
		    				              '</div>'
		    				     $(".each-address").removeClass("good-option-active");         
		    				     $(".each-address").eq(0).removeClass("buy-address-active");   
		    				     $(".each-address").eq(3).remove();         
		    				     $(".cart-ship-box").prepend(tag);
		    				     
		    					  //下单框收货地址改变
		    					  $(".order-ship-address1").text("").text(newShipAddress.province);
		    					  $(".order-ship-address2").text("").text(newShipAddress.city);
		    					  $(".order-ship-address3").text("").text(newShipAddress.county);
		    					  $(".order-ship-address4").text("").text(newShipAddress.address);
		    					  $(".order-ship-address5").text("").text(newShipAddress.shipName);
		    					  $(".order-ship-address6").text("").text(newShipAddress.phone);
		    					  $("#order-shipAdressId").val(newShipAddress.id);

		    				   
		    				   return;
		    			   }
		    			   $("#submitadd").text("确认").removeClass("disabled");
		    			   $("#addEntity").modal("hide");
	    				   setTimeout(function(){ bootbox.alert("新增失败")},500) ;
	    				   
		    			   
		    		   },
		    		   error:function(){
		    			   $("#submitadd").text("确认").removeClass("disabled");
		    			   $("#addEntity").modal("hide");
	    				   setTimeout(function(){ bootbox.alert("请求失败")},500) ;    			   
		    		   }
		    	   });			    	  
		      }); 
			  
			  
			  //切换收货地址
			  $(".each-address").on("click",function(){
				  //状态改变
				  var tag ='<i class="fa fa-check fa-lg good-option-active"></i>';
				  $(".good-option-active").remove();
				  $(this).siblings().removeClass("buy-address-active");
				  $(this).addClass("buy-address-active").append(tag);
				  
				  //下单框收货地址改变
				  $(".order-ship-address1").text("").text($(this).find(".cart-address-style2 span").eq(0).text());
				  $(".order-ship-address2").text("").text($(this).find(".cart-address-style2 span").eq(1).text());
				  $(".order-ship-address3").text("").text($(this).find(".cart-address-style2 span").eq(2).text());
				  $(".order-ship-address4").text("").text($(this).find(".cart-address-style3 span").eq(0).text());
				  $(".order-ship-address5").text("").text($(this).find(".cart-address-style1 span").eq(0).text());
				  $(".order-ship-address6").text("").text($(this).find(".cart-address-style1 span").eq(1).text());
				  $("#order-shipAdressId").val($(this).attr("data-id"));
			  });
			  
			  //确定订单
			  $("#order-submit").on("click",function(){
				  $("#submitadd").text("提交中").addClass("disabled");
				  $("#now-to-buy").submit();
		    	   
			  })
			  
		    })
		    
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
		      <a href="${pageContext.request.contextPath}/shop/cart/center" class="cart-a">
				<i class="fa fa-calendar-check-o cart-car"></i>
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
     
 
      <!--购物车--> 
	  <div class="container cart">
	    <!--收货地址-->
		<div class="row">
		   <div class="col-md-12 order-commend-line">
		     <span class="order-commend-line-left">收货地址</span>
		   </div>
		</div>
		<div class="row cart-ship-box">
		 <c:forEach items="${shipAddresses}" var="shipAddress" varStatus="statu">
		  <c:if test="${statu.count<=4}">
		  <div id="" class="each-address panel panel-default col-md-3 ${shipAddress.isSelect ==2 ?  'buy-address-active' :null}" data-id="${shipAddress.id}">
		    <div class="panel-body cart-address">
		      <div class="cart-address-style1">
		        <span>${shipAddress.shipName}</span>
		        <span>${shipAddress.phone}</span>
		      </div>
		      <div class="cart-address-style2">
		        <span>${shipAddress.province}</span>
		        <span>${shipAddress.city}</span>
		        <span>${shipAddress.county}</span>		        
		      </div>
		      <div class="cart-address-style3">
		        <span>${shipAddress.address}</span>
		      </div>		  
			</div>
			<c:if test="${statu.count ==1}">
			<i class="fa fa-check fa-lg good-option-active"></i>
			</c:if>
		  </div>
		  </c:if>
		 </c:forEach>
	    </div>
	    <div class="row">
		   <div class="col-md-12 order-commend-line2">
		   </div>
		</div>
	    <div class="row">
	      <div class="col-md-2 form-group">
	        <button id="new-address" class="form-control">使用新地址</button>
	      </div>
	      <div class="col-md-2 pull-right form-group">
	        <button id="manage-address" onclick="window.open('${pageContext.request.contextPath}/shop/user/center#address')" class="form-control">管理地址</button>
	      </div>
	    </div>	
	    
	    
	  	<div class="row cart-head">
		  <div class="col-md-2 cart-head-left">
		    <span>确认订单信息</span>
		  </div>
		</div> 		
		<div class="row cart-head-title">		 
		  <div class="col-md-5">商品信息</div>
		  <div class="col-md-1">单价</div>
		  <div class="col-md-2">数量</div>
		  <div class="col-md-3">优惠方式</div>
		  <div class="col-md-1">小计</div>
		</div>
		<!--购物车商品-->
		<div class="row">
		 <form id="now-to-buy" action="${pageContext.request.contextPath}/shop/order/nowAdd" method="POST">
		  <div id="" class="panel panel-default">
		    <div class="panel-body cart-goods">	
		      <input id="order-sku-${sku.id}" hidden="" name="skuId" value="${sku.id}" />	
		      <input id="order-skuNums-${sku.id}" hidden="" name="skuNums" value="${skuNums}" />	
			  <div class="col-md-5 cart-image-message">
			    <div class="col-md-3">
				  <img src="${pros.fictitiousRoot}${sku.picture}" class="img-rounded cart-product"/>
				</div>
				<div class="col-md-6">
                  <a href="javascript:window.open('${pageContext.request.contextPath}/shop/good/view/${sku.id}');" class="">${sku.skuName}</a>
				</div>
				<div class="col-md-3">
				 <c:forEach items="${sku.attributes}" var="attribute" varStatus="statu">
				     <c:forEach items="${attribute.options}" var="option" varStatus="statu">
                       <span class="cart-text-style">${option.optionName}</span>                                                                     
                     </c:forEach>				 
				 </c:forEach>				  
				</div>
			  </div>
			  <div class="col-md-1"><i>￥</i><span id="sku-singlePrice-${sku.id}" class="text-danger"><fmt:formatNumber type="number" value="${sku.salePrice}" pattern="0.00" maxFractionDigits="2"/></span></div>
			  <div class="col-md-2">
                 <span class="cart-sku-nums">                                     
                     ${skuNums}                           
                 </span>
			  </div>			  
			  <div class="col-md-3">
			    <a class="cart-text-style2" href="javascript:;">无</a>				
			  </div>  
			  <div class="col-md-1"><i>￥</i><span id="sku-sumPrice-${cartSku.id}" class="sku-sumPrice text-danger"><fmt:formatNumber type="number" value="${cartSku.sku.salePrice * cartSku.nums}" pattern="0.00" maxFractionDigits="2"/></span></div>			 			 
			</div>
		  </div>
		 <input id="order-shipAdressId" hidden="" name="shipAddressId" value="${shipAddresses.get(0).id}" /> 
	  </form>
		</div>				
		<!-- 分界线 -->		
		<div class="row cart-cut-line2"></div>
		<!-- 订单框 -->
		<div class="row">
		  <div class="col-md-4 pull-right order-sure-box">
		    <div class="col-md-12 order-price">
		      <span class="">
		        <span class="text-price-name">合计：</span>
		        <span class="">
		          <i class="text-price-logo" >￥</i>
		          <span class="text-price-value"><fmt:formatNumber type="number" value="${allSum}" pattern="0.00" maxFractionDigits="2"/></span>
		        </span>
		      </span>		      		      
		    </div>
		    <div class="col-md-12 order-price">
		      <span class="">
		        <span class="text-price-name">运费：</span>
		        <span class="">
		          <i class="text-price-logo" >￥</i>
		          <span class="text-price-value"><fmt:formatNumber type="number" value="${logisticPrice2}" pattern="0.00" maxFractionDigits="2"/></span>
		        </span>
		      </span>		      		      
		    </div>
		    <div class="col-md-12 order-price">
		      <span class="">
		        <span class="text-price-name">实付：</span>
		        <span class="">
		          <i class="text-price-logo" >￥</i>
		          <span class="text-price-value"><fmt:formatNumber type="number" value="${realyPrice}" pattern="0.00" maxFractionDigits="2"/></span>
		        </span>
		      </span>		      		      
		    </div>
		    <div class="col-md-12 order-logistic-address">
		      <span class="">
		        <span class="text-price-name">寄送至：</span>
		        <span class="">		          
		          <span class="order-ship-address1">${shipAddresses.get(0).province}</span>
		          <span class="order-ship-address2">${shipAddresses.get(0).city}</span>
		          <span class="order-ship-address3">${shipAddresses.get(0).county}</span>
		          <span class="order-ship-address4">${shipAddresses.get(0).address}</span>
		        </span>
		      </span>		      		      
		    </div>
		    <div class="col-md-12 order-logistic-user">
		      <span class="">
		        <span class="text-price-name">收货人：</span>
		        <span class="">
		          <span class="order-ship-address5">${shipAddresses.get(0).shipName}</span>
		          <span class="order-ship-address6">${shipAddresses.get(0).phone}</span>
		        </span>
		      </span>		      		      
		    </div>
		  </div>
		</div>
		<div class="row">
		  <div class="col-md-2 pull-right form-group">
	        <button id="order-submit" class="form-control">提交订单</button>
	      </div>
		</div>
		

		 <!--分界线-->
		 <div class="row">
		    <div class="order-cutline col-md-12"></div>
		 </div>	
	  </div>
  
      
      <!-- 新增收货地址 -->  
	  <div class="modal fade " id="addEntity" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
	    <div class="modal-dialog modal-lg" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="editModalLabel">新增收货地址</h4>
	        </div>
	        <div class="modal-body">
	                  <div class="row" id="center-address-place" >	     
	       <div class="col-md-12">		     
		     <form id="shipForm" action="${pageContext.request.contextPath}/shop/ship/add" method="post">
		        <div class="input-box col-md-12">  		                         		            
	              <div class="form-group col-md-3" >
	                <label for="ship-address-first" class="control-label" >所在地区:</label>
	                <select id="ship-address-first" class="form-control" name="provinceId" onchange="getSonArea(this,'ship-address-second')">
	                    <option>请选择地区</option>
	                  <c:forEach items="${rootAreas}" var="rootArea" varStatus="statu">
	                    <option value="${rootArea.id}" data-url="${pageContext.request.contextPath}/shop/area/getNext/${rootArea.id}" ${editShipAddress.provinceId ==rootArea.id ? 'selected="selected"' : null}>${rootArea.name}</option>
	                  </c:forEach>	                  	                  
	                </select>
	              </div>
	              <div class="form-group col-md-3" >
	              <label for="ship-address-second" class="control-label" >&nbsp;</label>
	              <select id="ship-address-second" class="form-control" name="cityId" onchange="getSonArea(this,'ship-address-third')">
	                <option value="">请选择</option>
	                <c:if test="${editShipAddress.cityId != null}">
	                <option value="${editShipAddress.cityId}" selected="selected">${editShipAddress.city}</option>
	                </c:if>
	              </select>
	              </div>
	              <div class="form-group col-md-3" >
	                <label for="ship-address-third" class="control-label" >&nbsp;</label>
	                <select id="ship-address-third" class="form-control" name="countyId">
	                 <option value="">请选择</option>
	                 <c:if test="${editShipAddress.countyId != null}">
	                 <option value="${editShipAddress.countyId}" selected="selected">${editShipAddress.county}</option>
	                 </c:if>
	                </select>
	              </div>	            
	            </div>	  
	            <div class="input-box col-md-12"> 	            
	              <div class="form-group col-md-6">
	                <label for="ship-address" class="control-label">详细地址:</label>
	                <textarea class="form-control" rows="4"  id="ship-address" name="address" placeholder="建议您如实填写详细收货地址，例如街道名称，门牌号码，楼层和房间号等信息，建议您如实填写详细收货地址，例如街道名称，门牌号码，楼层和房间号等信息">${editShipAddress.address}</textarea>
	              </div>
	            </div>	
	            <div class="input-box col-md-12">        
	              <div class="form-group col-md-4">
	                 <label for="ship-zipCode" class="control-label">邮政编码:</label>
	                 <input type="text" class="form-control" id="ship-zipCode" name="zipCode" value="${editShipAddress.zipCode}" placeholder="请输入邮政编码">
	              </div>	
	            </div>
	            <div class="input-box col-md-12">             
	              <div class="form-group col-md-4">
	                <label for="ship-shipName" class="sku-originalPrice" >收货人姓名:</label>
	                <input type="text" class="form-control" id="ship-shipName" name="shipName" value="${editShipAddress.shipName}" placeholder="请输入姓名，不可超过25字">
	              </div>
	            </div>  
	            <div class="input-box col-md-12"> 
	              <div class="form-group col-md-4">
	                <label for="ship-phone" class="control-label" >电话/手机号码:</label>
	                <input type="text" class="form-control" id="ship-phone" name="phone" value="${editShipAddress.phone}" placeholder="请输入电话/手机号码">
	              </div>
	            </div>    			        	                       
	          </form> 
	        </div>
	     </div>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	          <button type="button" class="btn btn-primary" id="submitadd">确认</button>
	        </div>
	      </div>
	    </div>
	  </div>	
      
      
      <!-- 结束导航栏 -->
     <%@ include file="/WEB-INF/all/include/shop-end.jsp"%>
     
  
   </body>
</html>