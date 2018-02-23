<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>凯之家商城(测试)
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
		.cartSku-all-select{font-size:10px;}
		.order-account:hover{color:#d9edf7;}
	    .cart{min-height:800px;}		
		.cart-head{border-bottom:1px solid #9f1212;padding-bottom:5px;margin-top:50px;font-size:17px;font-weight:600;color:#b00303;}
		.cart-head-left{padding-bottom:3px;margin-top:14px;}
		.cart-head-right{padding-bottom:3px;}
		.cart-text-style{color:#7b8588;font-size:12px;}
		.cart-text-style2{color:#7b8588;font-size:12px;}
		.cart-head-title{margin-top:20px;height:40px;border:1px solid #f2f2f2;line-height:40px;text-align:center;margin-bottom:20px;background-color:#f5f5f5;color:#7b8588;}
		.cart-goods{text-align:center;font-size:14px;color:black;min-height:120px;}		
		.cartSku-single-select{font-size:10px;color:#7b8588;}
		.cart-product{width:100px;height:auto;}
		.cart-sku-nums{margin:0px;}
		.sku-num-minus{width:20px;height:20px;background-color:white;border:1px solid #d2d0d0;}
		.sku-num-value{width:40px;height:20px;border:1px solid #d2d0d0;text-align:center;margin-left:-5px;}
		.sku-num-plus{width:20px;height:20px;background-color:white;border:1px solid #d2d0d0;margin-left:-5px;}	
		.cart-image-message{padding:0px;text-align:left;}
		.cart-image-message span{font-size:12px;}
		.cart-head-title2{margin-top:20px;height:40px;border:1px solid #f2f2f2;line-height:40px;text-align:center;margin-bottom:15px;background-color:#e5e5e5;color:#7b8588;}
		.cart-cut-line{border-bottom:1px solid #9f1212;margin-top:10px;margin-bottom:20px;}
		.cart-all-sumPrice{font-size:15px;font-weight:bold;}
		.button-disabled{background-color:#eee;border:1px solid #b3949b;color:#b1afaf;pointer-events: none; cursor:default;opacity: 0.8;}
		.autu-add input{float:left;width:30px;height:32px;padding:5px;text-align:center;margin-left:12px;}
		
		.autu-add span{float:left;display:block;width:15px;text-align:center;border-radius:5px;color: #3c763d;font-size:5px;
		               background-color: #ffffff;
		               border-color: #3c763d;			   
		}
		.main-search-input{margin-top:16px;}
		.main-search-span button{ margin-top:-15px;}
		
		.cart-calculate{background-color:#e5e5e5;padding-top:15px;font-size:16px;}
		
		.cart-calculate>.btn>a{font-size:16px;color:white;}
		
		.order-commend-line{font-size:16px;color:#999;font-weight:600;margin-top:20px;padding-bottom:5px;border-bottom:1px solid rgba(0, 0, 0, 0.13);margin-bottom:20px;}
		.order-commend-line-left{padding-bottom:7px;}
		.good-proom-list{display:block;;text-align:center;height:auto;padding-bottom:10px;}
		.good-proom-list>img{position:relative; width:100%; height:auto;}
	    .cart-goods-box{min-height:400px;max-height:400px;}
	    .cart-goods-box:hover{border:2px solid #bce8f1;}
	    .cart-goods-body{min-height:350px;max-height:350px;}
	    .cart-goods-foot{min-height:47px;max-height:47px;text-align:center;background-color:#f5f5f5;}
	    .cart-goods-foot>a{line-height:15px;}
	  </style>
	 	  	
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/shop/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			   //购买数量控制，及总金额变化         	
			    $(".sku-num-minus").click(function(){
			    	var object =$(this);
			    	var origalNum =Number(object.siblings(".sku-num-value").val());
			    	var cartSkuId =object.siblings(".sku-num-value").attr("data-cartSkuId");
			    	if(origalNum>=2){
			    		
			    		//改变数量		    		
			    		var endNum =origalNum-1;
			    		object.siblings(".sku-num-value").val(endNum);
			    		//获得对应的单价
			    		var salePrice =Number($("#sku-singlePrice-"+cartSkuId).text());
			    		//改变对应总价
			    		$("#sku-sumPrice-"+cartSkuId).text(salePrice*endNum);
			    		//更新后台数量，并返回结果
			    		var targetObject =object.siblings(".sku-num-value");			    		
			    		updateNums(cartSkuId,endNum,targetObject);
			    		//更新总金额
			    		checkBox();
			    	}
			    })
			    $(".sku-num-plus").click(function(){
			    	//改变数量
			    	var object =$(this);
			    	var origalNum =Number(object.siblings(".sku-num-value").val());
			    	var cartSkuId =object.siblings(".sku-num-value").attr("data-cartSkuId");
			    	var endNum =origalNum+1;
			    	object.siblings(".sku-num-value").val(endNum);
			    	//获得对应的单价
		    		var salePrice =Number($("#sku-singlePrice-"+cartSkuId).text());
		    		//改变对应总价
		    		$("#sku-sumPrice-"+cartSkuId).text(salePrice*endNum);	
		    		//更新后台数量，并返回结果
		    		var targetObject =object.siblings(".sku-num-value");			    		
		    		updateNums(cartSkuId,endNum,targetObject);
		    		//更新总金额
		    		checkBox();
			    })
			    
			    $(".sku-num-value").focusout(function(){
			    	var object =$(this);
			    	var endNum =Number(object.val());
			    	var cartSkuId =object.attr("data-cartSkuId");
			    	var reg =/^[0-9]*[1-9][0-9]*$/;
			    	if(!reg.test(endNum)){
			    		endNum =1 ;
			    		object.val(endNum);
			    	}			    	
			    	//获得对应的单价
		    		var salePrice =Number($("#sku-singlePrice-"+cartSkuId).text());
		    		//改变对应总价
		    		$("#sku-sumPrice-"+cartSkuId).text(salePrice*endNum);
		    		//更新后台数量，并返回结果		    		
		    		updateNums(cartSkuId,endNum,object);
		    		//更新总金额
		    		checkBox();
		    		
			    })
			    
			    //全选商品
			    $("#allbox1").on("click",function(e){ 
			    	var flag = $(this).prop("checked");
			    	checkAllBox1(flag);
			    	e.stopPropagation();
			    	  
			    });
			    $("#allbox2").on("click",function(e){
			    	var flag = $(this).prop("checked"); 
			    	checkAllBox2(flag);
			    	e.stopPropagation(); 
			    })
			    
			    
			   //结算
			   $(".cart-buy").on("click",function(){
				   $(".cart-buy").addClass("button-disabled")
				   $("#cart-to-buy").submit();
				   
			   })
			   
		  });
		  
		    //选择商品，更新状态数据    
		    function checkBox(){
		    	var nums =$(".cartSku-checkbox-single:checkbox:checked");
		    	//如果有被选中商品
		    	if(nums.length >0){
		    		//总商品数量
		    		$("#cart-all-sumNum").text(nums.length);
		    		//结算按钮被激活
		    		$('.cart-buy').removeClass("button-disabled");
		    		//计算总额
		    		var allSumPirce =0;
		    		$.each(nums,function(i,num){
		    			var cartSkuId =$(num).attr("data-cartSkuId");
		    			var sumPrice =Number($("#sku-sumPrice-"+cartSkuId).text());
		    			allSumPirce +=sumPrice ;
			    	});
		    		$(".cart-all-sumPrice").text(allSumPirce);
		    	}else{
		    		//结算按钮被禁止
		    		$('.cart-buy').addClass("button-disabled");	
		    	    //总商品数量为0
	    		    $("#cart-all-sumNum").text(0);
		    	    //总金额为0
		    	    $(".cart-all-sumPrice").text(0);
		    	    
		    	}
		    		
		     }
		    
		    //全选商品
		    function checkAllBox1(flag){
		    	if(flag){
		    		//另一个全选框被选中
		    		$('[name|="allbox2"]').prop("checked",true);
		    		//结算按钮被激活
		    		$('.cart-buy').removeClass("button-disabled");
		    		//商品单选框全选中
		    		var nums =$(".cartSku-checkbox-single")
		    		nums.prop("checked",true);
		    		//总商品数量
		    		$("#cart-all-sumNum").text(nums.length);
		    		//计算总额
		    		var allSumPirce =0;
		    		$.each(nums,function(i,num){
		    			var cartSkuId =$(num).attr("data-cartSkuId");
		    			var sumPrice =Number($("#sku-sumPrice-"+cartSkuId).text());
		    			allSumPirce +=sumPrice ;
			    	});
		    		$(".cart-all-sumPrice").text(allSumPirce);
		    	}else{		    		
		    		//另一个按钮取消选中
		    		$('[name|="allbox2"]').prop("checked",false);	
		    		//结算按钮冷却
		    		$('.cart-buy').addClass("button-disabled");
		    		//商品单选框全取消选中
		    		var nums =$(".cartSku-checkbox-single")
		    		nums.prop("checked",false);
		    		//总商品数量为0
		    		$("#cart-all-sumNum").text(0);
		    		//总金额为0
		    		$(".cart-all-sumPrice").text(0);
		    	}	 	    	
		    }
		    
		    function checkAllBox2(flag){
		    	if(flag){
		    		//另一个全选框被选中
		    		$('[name="allbox1"]').prop("checked",true);
		    		//结算按钮被激活
		    		$('.cart-buy').removeClass("button-disabled");
		    		//商品单选框全选中
		    		var nums =$(".cartSku-checkbox-single")
		    		nums.prop("checked",true);
		    		//总商品数量
		    		$("#cart-all-sumNum").text(nums.length);
		    		//计算总额
		    		var allSumPirce =0;
		    		$.each(nums,function(i,num){
		    			var cartSkuId =$(num).attr("data-cartSkuId");
		    			var sumPrice =Number($("#sku-sumPrice-"+cartSkuId).text());
		    			allSumPirce +=sumPrice ;
			    	});
		    		$(".cart-all-sumPrice").text(allSumPirce);
		    	}else{
		    		//另一个全选框取消选中
		    		$('[name="allbox1"]').prop("checked",false);		    			
		    		//结算按钮冷却
		    		$('.cart-buy').addClass("button-disabled");
		    		//商品单选框全取消选中
		    		var nums =$(".cartSku-checkbox-single")
		    		nums.prop("checked",false);
		    		//总商品数量为0
		    		$("#cart-all-sumNum").text(0);
		    		//总金额为0
		    		$(".cart-all-sumPrice").text(0);
		    	}			    	
		    }
		    
		    //删除购物车的商品
		    function deleteSingle(targetUrl,target){
		    	
		    	bootbox.confirm({  
		            buttons: {  
		                confirm: {  
		                    label: '确认',  
		                    className: 'btn-info'  
		                },  
		                cancel: {  
		                    label: '取消',  
		                    className: 'btn-default'  
		                }  
		            },  
		            message: '确认删除该商品吗？',  
		            callback: function(result) {  
		                if(result) {  
		                    $.get(targetUrl,function(flag){
		                    	if(flag.valid=='true'){
		                    		//去除商品tag
		                    		var targetTag =$(target).parents(".cart-goods");
		                    		targetTag.fadeTo("slow", 0.01, function(){//fade
		                    			targetTag.slideUp(50, function() {//slide up
		                    				targetTag.remove();
		                    		    });
		                    		});
		                    		 //改变购物车数量显示
		                    		 var oldcartSkuNums =Number($(".em-num").text());
		                    		 $(".em-num").text(oldcartSkuNums-1);
		                    		return true ;
		                    	}else
		                    		if(flag.valid =='noUser'){
		                    			window.location.href=flag.target;
		                    		}
		                    	setTimeout(function () { bootbox.alert("删除失败")}, 500)
		                    	
		                    })
		                }  
		            }
		    	});
		    }
		    
		    //根据前端更新后台购物车的商品数量
		    function updateNums(cartSkuId,nums,object){
		    	var rootUrl =$(".cart-sku-nums").attr("data-url");
		    	var targetUrl =rootUrl+"/"+cartSkuId+"/"+nums
		    	$.get(targetUrl,function(result){
		    		if(result.valid =="true"){
		    			object.val(result.nums);
		    			//如果后台返回的数量少于0?待定
		    			
		    		}else
		    			if(result.valid == "noUser"){
		    				window.location.href=result.target;
		    			}
		    		
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
				<i class="glyphicon glyphicon-shopping-cart cart-car"></i>
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
	    <!--头信息-->
	  	<div class="row cart-head">
		  <div class="col-md-2 cart-head-left">
		    <span>全部商品</span>
		  </div>
		  <div class="col-md-5 pull-right cart-head-right text-right">
		    <span class="cart-text-style">已选商品合计(不含运费)：<i>￥</i></span> <span class="cart-all-sumPrice">0.00</span>&nbsp;&nbsp;<a  href="javascript:;" class="cart-buy button-disabled btn btn-danger btn-sm">结算</a>
		  </div>
		</div> 
		<div class="row cart-head-title">
		  <div class="col-md-1">
		  <input class="cartSku-all-select" id="allbox1"  name="allbox1" type="checkbox"/>
		  <label  for="allbox1" >全选</label>		  
		  </div>
		  <div class="col-md-5">商品信息</div>
		  <div class="col-md-1">单价</div>
		  <div class="col-md-2">数量</div>
		  <div class="col-md-1">金额</div>
		  <div class="col-md-2">我的操作</div>
		</div>
		<!--购物车商品-->
		<div class="row">
		 <form id="cart-to-buy" action="${pageContext.request.contextPath}/shop/cart/buy" method="get">
		 <c:forEach items="${cartSkus}" var="cartSku" varStatus="statu">
		  <div id="" class="panel panel-default">
		    <div class="panel-body cart-goods">
			  <div class="col-md-1">
			    <input onclick="checkBox()" class="cartSku-checkbox-single" data-cartSkuId="${cartSku.id}"  id="cartsku-select-${cartSku.id}" name="cartSkuIds" value="${cartSku.id}" type="checkbox"/>
			    <label class="cartSku-single-select" for="cartsku-select-${cartSku.id}" >选择</label>
			  </div>
			  <div class="col-md-5 cart-image-message">
			    <div class="col-md-3">
				  <img src="${pros.fictitiousRoot}${cartSku.sku.picture}" class="img-rounded cart-product"/>
				</div>
				<div class="col-md-6">
                  <a href="javascript:window.open('${pageContext.request.contextPath}/shop/good/view/${cartSku.sku.id}');" class="">${cartSku.sku.skuName}</a>
				</div>
				<div class="col-md-3">
				 <c:forEach items="${cartSku.sku.attributes}" var="attribute" varStatus="statu">
				     <c:forEach items="${attribute.options}" var="option" varStatus="statu">
                       <span class="cart-text-style">${option.optionName}</span>                                                                     
                     </c:forEach>				 
				 </c:forEach>				  
				</div>
			  </div>
			  <div class="col-md-1"><i>￥</i><span id="sku-singlePrice-${cartSku.id}" class="text-danger"><fmt:formatNumber type="number" value="${cartSku.sku.salePrice}" pattern="0.00" maxFractionDigits="2"/></span></div>
			  <div class="col-md-2">
                 <span class="cart-sku-nums" data-url="${pageContext.request.contextPath}/shop/cart/update">                  
                     <button  class="sku-num-minus"  type="button">-</button>                   
                     <input  type="text" class="sku-num-value" data-cartSkuId="${cartSku.id}" name="nums" value="${cartSku.nums}">                  
                     <button  class="sku-num-plus" type="button">+</button>          
                 </span>
			  </div>			  
				  
			  <div class="col-md-1"><i>￥</i><span id="sku-sumPrice-${cartSku.id}" class="sku-sumPrice text-danger"><fmt:formatNumber type="number" value="${cartSku.sku.salePrice * cartSku.nums}" pattern="0.00" maxFractionDigits="2"/></span></div>			 
			  <div class="col-md-2">
			    <a class="cart-text-style2" href="javascript:loveSingle(${cartSku.id})">加入收藏</a>
				<i> / </i>
				<a class="cart-text-style2" href="javascript:;" onclick="deleteSingle('${pageContext.request.contextPath}/shop/cart/deleteSingle/${cartSku.id}',this)">删除</a>
			  </div>
			</div>
		  </div>
		 </c:forEach> 
		 </form>
		</div>
		
		<!--结算-->
		<div class="row cart-head-title2">
		  <div class="col-md-1">
		  <input class="cartSku-all-select" id="allbox2"  name="allbox2" type="checkbox"/>
		  <label  for="allbox2" >全选</label>		  
		  </div>
		  <div class="col-md-1">
		    <a href="javascript:;">删除</a>
		  </div>
		  <div class="col-md-1">
		    <a href="javascript:;">收藏</a>
		  </div>
		  <div class="col-md-1">
		    <a href="javascript:;">分享</a>
		  </div>
		  <div class="col-md-2 col-md-offset-2">
		    <span>已选商品</span>
			<span id="cart-all-sumNum" class="text-danger"></span>
			<span  >种</span>
		  </div>
		  <div class="col-md-2">
		    <span>合计:</span>
		    <i>￥</i>
			<span id="" class="text-danger cart-all-sumPrice">0</span>
		  </div>		  
		    <a href="javascript:;" class="button-disabled cart-buy col-md-2 btn btn-danger">结算</a>	  
		</div>
		
		<!-- 分界线 -->		
		<div class="row cart-cut-line"></div>
		
		 <!--推荐产品-->
		<div class="row">
		   <div class="col-md-12 order-commend-line">
		     <span class="order-commend-line-left">推荐商品</span>
		   </div>
		 </div>
		<div class="row">
		  <c:forEach items="${proomSkus}" var="proomSku" varStatus="statu">		  		  	  
		  <div class="col-md-3">
		   <div class="panel panel-info cart-goods-box">
			 <div class="panel-body cart-goods-body ">
				<a class="good-proom-list" href="javascript:window.open('${pageContext.request.contextPath}/shop/good/view/${proomSku.id}');">
				  <img class="" src="${pros.fictitiousRoot}${proomSku.picture}" class="img-responsive img-rounded"/>
				</a>
				<div class="text-center mg-top-5">
				  <i>￥:</i>
				  <span class="text-danger">
				    <fmt:formatNumber value="${proomSku.salePrice}" maxFractionDigits="2" type="Number" pattern="0.00"></fmt:formatNumber>
				  </span>
				</div>
			 </div>
			 <div class="panel-footer cart-goods-foot"><a href="javascript:window.open('${pageContext.request.contextPath}/shop/good/view/${proomSku.id}');">${proomSku.skuName}</a></div>
		   </div>
		  </div> 
		 </c:forEach> 
        </div>

		 <!--分界线-->
		 <div class="row">
		    <div class="order-cutline col-md-12"></div>
		 </div>	
	  </div>
  
      
      <!-- 结束导航栏 -->
     <%@ include file="/WEB-INF/all/include/shop-end.jsp"%>
     
  
   </body>
</html>