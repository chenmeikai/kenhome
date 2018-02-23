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
	    
	    .shop-index-search{height:80px;margin-top:30px;}
	    .shop-index-logo{width:50%;height:auto;}
	    .good-header-line{border-top:5px solid #9f1212;}
	    .good-category-hover{background-color:#9f1212;height:40px;}
	    .good-category-hover-a{display:block; line-height:40px; ;text-align:center;color:white; font-size:15px;font-weight:bold;}
	    .good-category-hover:hover .good-category-hover-a{color:#337ab7;}
	    .good-category-hover:hover #category-place{display:block;z-index:100;} 
	     #category-place{position:absolute;width:100%;left:0;display:none;margin-top:2px;} 
	    .shop-index-category{background-color:black;opacity:0.8;border-radius:5px;margin-right:0px;padding-right:0px;}
	    .index-category-li{border-bottom:1px solid white;}
	    .index-category-li :hover{background-color:white;} .index-category-li :hover .index-category-a{color:black;font-weight:bold;}
	    .index-category-div{color:white;padding-top:10px;padding-bottom:10px;}
	    .index-category-a{color:white;}     .index-category-a :hover{color:#337ab7;}	
	    .good-category-memo{margin-top:10px;}
	    .good-category-memo a{display:inline-block;margin-right:20px;}.good-category-memo span{display:inline-block;margin-right:20px;color:#9f1212;}    
	    #category-sku-name{color:#555;}
	    .good-show-place{margin-top:20px;}
	    .left-image-window{ border:1px solid #ddd;padding:10px;width:100%;}
	    .left-image-window-img{width:100%;height:auto;}
	    .left-image-memo{margin-top:10px;display:block;border:1px solid #dfdfdf;padding:0px;margin-right:5px;}
	    .left-image-memo:hover{border:3px solid #dfdfdf;}
	    .left-image-memo-img{width:100%;height:auto;}
	    .good-love{color:#9f1212;}
	    <!--图片自中心放大效果-->
	    .left-image-window {  
                display: block;   
                margin: 0 auto;  
                overflow: hidden;  
            }               
            .left-image-window img {  
                display: block;  
                border: 0;  
                width: 100%;  
                transform: scale(1);  
                transition: all 1s ease 0s;  
                -webkit-transform: scale(1);  
                -webkit-transform: all 1s ease 0s;  
            }                
            .left-image-window:hover img {  
                transform: scale(1.3);  
                transition: all 2s ease 0s;  
                -webkit-transform: scale(1.3);  
                -webkit-transform: all 2s ease 0s;  
            } 
            
         .good-show-name{font-size:15px;display:inline-block;margin-top:20px;font-weight:bold;} 
         .good-price{background-color:#f9f3f3;} 
         .good-sale-message{height:30px;border-top:1px dashed #d2d0d0;border-bottom:1px dashed #d2d0d0;line-height:20px;}
         .sale-message-line{display:block;float:left;width:33.3%;border-right:1px solid #d2d0d0;height:20px;margin-top:5px; }
         .sale-message-line2{display:block;float:left;width:33.3%;height:20px;margin-top:5px; }
         .sale-message-name{display:in-block;margin-left:10%;;float:left;width:30%;color:#666;}
         .sale-message-value{display:in-block;float:left;width:60%;color:#9f1212;}
         .sale-message-value2{display:in-block;float:left;width:60%;color:#2b7650;}
         .good-attributes{background-color:#f7f7f7;}
         .good-attribute{display:inline-block;width:60px; color:#666;font-weight:bold;} 
	     .good-salePrice{font-size:20px;color:#9f1212;font-weight:bold;}
	     .good-option{display:inline-block;position:relative; min-height:30px; border:1px solid #d2d0d0;color:black; min-width:80px;text-align:center;line-height:30px;font-size:12px;}
	     .good-option-active{position:absolute;color:#9f1212;bottom:0px;right:0px;}
	     .option-active{border:1px solid #9f1212}
	     .good-option:hover{border:1px solid #9f1212;}
	     #sku-num-minus{width:30px;height:30px;background-color:white;border:1px solid #d2d0d0;}#sku-num-value{width:50px;height:30px;border:1px solid #d2d0d0;text-align:center;}#sku-num-plus{width:30px;height:30px;background-color:white;border:1px solid #d2d0d0;}
	     .good-stocks{display:inline-block;margin-left:30px;color:#666;} .good-stocks-value{display:inline-block;margin-right:10px;color:#9f1212;}
	     .good-buy-cart{margin-top:35px;}
	     .good-buy-button{display:inline-block;width:30%;height:38px;text-align:center;line-height:38px; border:1px solid #FF0036;margin-left:17%;background-color:#ffeded;color:#FF0036;font-weight:bold;}
	     .good-buy-button:hover{color:#337ab7;}
	     .good-cart-button{display:inline-block;width:30%;height:38px;text-align:center;line-height:38px; border:1px solid #FF0036;margin-left:1%;margin-right:15%;background-color:#FF0036;color:white;font-weight:bold;}
	     .good-cart-button:hover{color:#ebe3e3;}
	     .button-disabled{background-color:#eee;border:1px solid #b3949b;color:#b1afaf;pointer-events: none; cursor:default;opacity: 0.8;}
	     .good-proom-list{display:block;;text-align:center;height:auto;border:1px solid #dfdfdf;padding-bottom:10px;}
	     .good-proom-list:hover{ box-shadow: #666 0px 0px 10px;border:1px solid #cbdceb;}
	     .good-proom-list>div{position:relative;margin-top:10px;}
	     .good-proom-list>img{position:relative; width:100%; height:auto; margin-top:20px;}
	     .good-content-show{text-align:center;}
	     .good-content{margin-top:50px;}
	     #sku-specification{background-color:#fbfafa;border:1px solid #eaeaea;padding:10px;margin-top:50px;min-height:600px;}
	     .spu-base-value{margin-top:20px;}
	     .spu-attribute-name{display:inline-block;width:30%;color:#726868;} .spu-option-value{display:inline-block;width:60%;color:#726868;}
	     #sku-warning{padding:10px;text-align:center;line-height:50px;font-size: 18px;font-weight:bold;color:#9f1212;}
	     .comment-gold-box{margin-top:60px;}
	     .comment-gold{height:100px;border:1px solid #d2d0d0;line-height:30px;box-shadow: #666 0px 0px 10px;text-align:center;}
	     .comment-gold-span1{display:block;color:#c2bfbf;font-size:12px;font-weight:100;}
	     .comment-gold-span2{display:block;color: #f60;font-family: arial;font-size: 32px;line-height: 32px;margin: 0 2px;}
	     .comment-select{height:35px;margin-top:10px;border:1px solid #d2d0d0;background-color:rgba(0,0,0,.075);line-height:35px;}
	      
	     .comment-select-content label{color:#337ab7;margin-right:10px;}
	     .comment-sort-content{width:80px;height:25px;margin-top:5px; padding:0px;border:1px solid #d2d0d0;background-color:white;}
	     .comment-table{padding:20px;} .comment-table tr{border-bottom:1px solid #e3e3e3;height:100px;}
	     .comment-attribute{display:block;padding:5px;}.comment-option{color:#666;}.comment-option-value{color:#999;}
	  </style>
	 	  	
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/shop/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			  //图片切换
			  $(document).on("mouseenter",".left-image-memo",function(){
				 var pictureUrl = $(this).find("img").attr("src");
				 
			     $(".left-image-window-img").attr("src",pictureUrl);
			  }); 
			  
			    			   
			    //获取导航高度;
			    var navTop=$("#good-nav").offset().top;			    		 
			    //监听事件;
			    $(window).scroll(function(){			    	
			    	//定义一个监听高度;
				    var scrollHeight=$(document).scrollTop();	
			        if(scrollHeight>navTop){
			        	$("#good-nav").css({position:"fixed",top:"0px"})
			        }else{
			        	$("#good-nav").css({position:"static",top:navTop})
			        }		         
			    });
			    
			    //滚动到指定位置
			    $("#good-nav>li").click(function (){  
	                $('html, body').stop(true).animate({  
	                    scrollTop: navTop  
	                }, 2000);  
	            });
			    
			    //购买数量控制         sku-num-value   
			    var stocks=Number($("#good-sticks-value").text());
			    $("#sku-num-minus").click(function(){
			    	var origalNum =Number($("#sku-num-value").val());
			    	if(origalNum>=2)$("#sku-num-value").val(origalNum-1);
			    })
			    $("#sku-num-plus").click(function(){
			    	var origalNum =Number($("#sku-num-value").val());
			    	if(stocks>origalNum)$("#sku-num-value").val(origalNum+1);
			    })
			    $("#sku-num-value").focusout(function(){
			    	var origalNum =Number($("#sku-num-value").val());
			    	if(origalNum>stocks)$("#sku-num-value").val(stocks);
			    	var reg =/^[0-9]*[1-9][0-9]*$/;
			    	if(!reg.test(origalNum))$("#sku-num-value").val(1);
			    })
			    
			    //属性点击状态改变,动态更换SKU
			    $(".good-option").click(function(){
			    	//目标地址
			    	var targetUrl= $(".good-attributes").attr("data-selectUrl");
			    	var spuId= $(".good-attributes").attr("data-spuId");
			    	//兄弟元素
			    	$(this).siblings(".good-option").find("i").remove();
			    	$(this).siblings(".good-option").removeClass("option-active");
			    	//该元素
			    	var tag ='<i class="fa fa-check good-option-active"></i>'
			    	$(this).append(tag);
			    	$(this).addClass("option-active");			    	
			    	//将被选择的属性放入数组当中
			    	var optionIds = new Array();
			    	$(".good-option.option-active").each(function(){
			    		optionIds.push($(this).attr("data-optionId"));		    		
			    	}) ;
			    	
			        
			    	$.ajax({
			    		type:  'post',
			    		url :   targetUrl,
			    		data:{
			    			"optionIds[]":optionIds,
			    			"spuId" :spuId
			    		},
			    		jsonType: 'json',
			    		success:function(data){
			    			//如果sku不唯一，则返回
			    			if(data.flag == false) return false;
			    			
			    			//如果sku不存在，清除对应的信息
			    			if(data.flag ==null){
			    				$(".good-show-name").text("");
			    				$(".good-original-price").text("");
			    				$(".good-salePrice").text('');
			    				$(".sale-message-value2").text('');
			    				$(".good-stocks-value").text('');
			    				$(".good-buy-cart").attr("data-skuId",'');
			    				$(".good-buy-cart>button").addClass("button-disabled");
			    				$(".sku-image").remove();
			    			}
			    			
			    			//如果sku唯一
			    			if(data.flag ==true){
				    			var targetSku =data.targetSku;
				    			$(".good-show-name").text(targetSku.skuName);
				    			$(".good-original-price").text(targetSku.originalPrice.toFixed(2));
				    			$(".good-salePrice").text(targetSku.salePrice.toFixed(2));
				    			$(".sale-message-value2").text(targetSku.integration);
				    			$(".good-stocks-value").text(targetSku.stocks);
				    			$(".good-buy-cart").attr("data-skuId",targetSku.id);
				    			$("#sku-num-value").val("1");
				    			$(".good-buy-cart>button").removeClass("button-disabled");
				    			//如果库存为0，购买和加购物车设置不可点击
				    			if(targetSku.stocks <=0){$(".good-buy-cart>button").addClass("button-disabled");}
				    			
				    			//关联图片
				    			var skuPictures =data.skuPictures;
				    			var rootUrl =$(".good-show-left").attr("data-rootUrl");
				    			$(".sku-image").remove();			    			
				    			$.each(skuPictures, function(i,skuPicture){
				    				var tag ='<a class="col-md-2 left-image-memo sku-image" href="javascript:;">'+
				    	                     '<img class="left-image-memo-img" src="'+
				    	                     rootUrl+
				    	                     skuPicture.pictureUrl+
				    	                     '" /> </a>'   
				    	                   
				    	            $(".left-image-window").after(tag);        
				    			})
			    			}			    			
			    		},
			    		error:function(){
			    			bootbox.alert("请求失败")
			    		}
			    	})			    	
			    });
			    
			    //现在购买
			    $("#buy-now").on("click",function(){
			    	var skuNums = $("#sku-num-value").val();
			    	var skuId=$(this).attr("data-skuId");
			    	var targetUrl =$(this).attr("data-url");
			    	window.location.href=targetUrl+"?skuId="+skuId+"&skuNums="+skuNums;
			    })
			    
			    //加入购物车
			    $("#add-cart").on("click",function(){
			    	addCart();
			    })			    			    
		  });
		  function addCart(){
		    	var targetSkuId = $(".good-buy-cart").attr("data-skuId");
		    	var stocks =$("#good-sticks-value").text();
		    	var nums =$("#sku-num-value").val();
		    	var targetUrl =$("#add-cart").attr("data-url");
		    	if(stocks>0 && nums<=stocks && targetSkuId>0){
		    		$.ajax({
		    			type:'get',
		    			url : targetUrl,
		    			data:{
		    				'skuId':targetSkuId,
		    				'nums' :nums
		    			},
		    		    dataType:'json',
		    		    success:function(result){
		    		    	switch(result.flag){
		    		    	case("noUser"):			    		    		
		    		    		$("#login-window").modal({
		    						  backdrop: 'static'
		    					});
		    		    		break;
		    		    	case("noStocks"):
		    		    		$("#good-stocks-value").text(stocks);
		    		    	    bootbox.alert("库存不足！");
		    		    		break;
		    		    	case("mistake"):
		    		    		bootbox.alert("非法参数！");
		    		    		break;
		    		    	case("noSale"):
		    		    		bootbox.alert("该商品已下架!");
		    		    		break;			    		    	
		    		    	case("systemWrong"):
		    		    		bootbox.alert("系统错误，请反馈!");
		    		    		break;	
		    		    	case("success"):
		    		    		var tag ='<i  style="position:absolute;margin-top:8px;" class="fa fa-plus cart-animate"></>'
		    		    		$("#add-cart").append(tag);
		    		    		$(".cart-animate").stop(true).animate({top:"-=40px",left:"+=40px",fontSize:"3em",opacity:"0"},1500,function(){$("#cart-animate").remove()});
		    		    		$(".em-num").text(result.cartSkusKinds);
		    		    		break;			    		    	
		    		    	}		    		    	
		    		    },
		    		    error:function(){
		    		    	bootbox.alert("请求失败！")
		    		    }
		    		})
		    	}
		    }
	 </script>	 	  
   </head>
   <body>
     <!--固定提示-->
     <div class="shop-warning">个人测试网站 不可购物</div>
     
     <!-- 头部导航栏 -->
     <%@ include file="/WEB-INF/all/include/shop-begin.jsp"%>
     
     <!-- 搜索栏 -->
     <div class="container">
        <div class="row shop-index-search" >
          <div class="col-md-3">
             <a href="${pageContext.request.contextPath}/shop/index"><img class="shop-index-logo" src="${pageContext.request.contextPath}/resources/image/logo/kenhome.png" class="img-responsive" alt="logo"></a> 
          </div>
          <div class="col-md-6">
            <div class="input-group ">
               <input id="shop-search" type="text" placeholder="请输入商品"  class="form-control"/>
               <span class="input-group-btn">
                   <button class="btn btn-default" type="button">搜索</button>
               </span>
            </div>
          <ul class="nav nav-pills">
	        <li role="presentation" class=""><a href="${pageContext.request.contextPath}/shop/good/listThird?categoryId=25">女卫衣</a></li>
	        <li role="presentation"><a href="${pageContext.request.contextPath}/shop/good/listThird?categoryId=204">手机</a></li>
	        <li role="presentation"><a href="${pageContext.request.contextPath}/shop/good/listThird?categoryId=32">女寸衫</a></li>
	      </ul>
          </div>
        </div>
     </div>   
     <!-- 横向导航栏 --> 
     <div class="container">
       <div class="row">
         <!-- 分类展示-滑动触发 -->
         <div class="col-md-2 good-category-hover">
           <a class="good-category-hover-a" href="javascript:;">全商品分类</a>
           <!-- 直立分类导航 -->
           <div id="category-place">
             <ul class=" shop-index-category nav nav-pills  nav-stacked">
               <c:forEach items="${rootCategorys}" var="category" varStatus="statu">
                <li id="root-category-${category.id}" role="presentation" class="index-category-li" data-url="${pageContext.request.contextPath}/shop/categoryView?rootCategoryId=${category.id}">                                  
                   <div class="index-category-div" >
                     <i class="i-style2  fa-lg ${category.imageUrl}" style="display:inline-block;min-width:12px; max-width:12px;margin-left:5px;"></i>                        
                       <a id="category-skip-${category.id}" class="index-category-a" href="${pageContext.request.contextPath}/shop/good/listThird?categoryId=${category.id}"><span class="mg-left-15">${category.categoryName}</span> </a>                                                        
                     </div>                  
                </li>
               </c:forEach>                                                        
              </ul>
           </div>              
         </div>
         <ul class="nav nav-tabs col-md-10">
           <li role="presentation" ><a href="${pageContext.request.contextPath}/shop/index">商城首页</a></li>         
           <li role="presentation"><a href="#">随机商品</a></li>
           <li role="presentation"><a href="#">热门商品</a></li> 
           <li role="presentation"><a href="#">特价商品</a></li> 
           <li role="presentation"><a href="#">促销商品</a></li> 
           <li role="presentation"><a href="#">客户服务</a></li> 
           <li role="presentation"><a href="#">关于本站</a></li>
           <li role="presentation"><a href="${pageContext.request.contextPath}/admin/common/main">后台管理</a></li>
           <li role="presentation"><a href="#">个人主页</a></li>      
         </ul>
       </div>
     </div>
     <!-- 分界线 -->
     <div class="good-header-line"></div>
     <!-- 商品分类信息 --> 
     <div class="good-category-memo">
       <div class="container">
         <div class="row">
           <div class="col-md-12">
             <a href="${pageContext.request.contextPath}/shop/good/listThird?categoryId=${viewSku.category.parentCategory.parentCategory.id}">${viewSku.category.parentCategory.parentCategory.categoryName}</a>
             <span>></span>
             <a href="${pageContext.request.contextPath}/shop/good/listThird?categoryId=${viewSku.category.parentCategory.id}">${viewSku.category.parentCategory.categoryName}</a>
             <span>></span>
             <a href="javascript:window.open('${pageContext.request.contextPath}/shop/good/listThird?categoryId=${viewSku.categoryId}');">${viewSku.category.categoryName}</a>
             <span>></span><span id="category-sku-name">${viewSpu.spuName}</span>
           </div>              
         </div>
       </div>          
     </div> 
     <!-- 商品信息 -->
      <div class="good-show-place">
       <div class="container">
         <div class="row">
           <!-- 左边栏图片信息 -->
           <div class="col-md-4 good-show-left" data-rootUrl="${pros.fictitiousRoot}">
             <div class="left-image-window">
               <img class="left-image-window-img" src="${pros.fictitiousRoot}${skuPictures.get(0).pictureUrl}" />
             </div> 
             <c:forEach items="${skuPictures}" var="skuPicture" varStatus="statu">           
               <a class="col-md-2 left-image-memo sku-image" href="javascript:;" >
                 <img class="left-image-memo-img" src="${pros.fictitiousRoot}${skuPicture.pictureUrl}" />              
               </a>
             </c:forEach>
             <c:forEach items="${spuPictures}" var="spuPicture" varStatus="statu">           
               <a class="col-md-2 left-image-memo" href="javascript:;">
                 <img class="left-image-memo-img" src="${pros.fictitiousRoot}${spuPicture.pictureUrl}" />              
               </a>
             </c:forEach>         
           </div>
           <!-- 中部栏商品信息 -->  
           <div class="col-md-7 good-show-middle">
             <span class="good-show-name">${viewSku.skuName}</span>                         
             <div class="alert mg-top-15 good-price">
               <div class="mg-bottom-15">
                 <span class="good-attribute">原价</span><em>￥</em>
                 <span class="good-original-price">
                   <fmt:formatNumber type="number" value="${viewSku.originalPrice}" pattern="0.00" maxFractionDigits="2"/>              
                 </span>
               </div>
               <div>
                 <span class="good-attribute">促销价</span><em>￥</em>
                 <span class="good-salePrice">
                   <fmt:formatNumber type="number" value="${viewSku.salePrice}" pattern="0.00" maxFractionDigits="2"/>
                 </span>
               </div>            
             </div>
             <div class="good-sale-message">
               <span class="sale-message-line"><span class="sale-message-name">销量</span><span class="sale-message-value">${viewSpu.saleAmount}</span></span>
               <span class="sale-message-line"><span class="sale-message-name">评价</span><span class="sale-message-value"></span></span>
               <span class="sale-message-line2"><span class="sale-message-name">积分</span><span class="sale-message-value2">${viewSku.integration}</span></span>  
             </div>
             <div class="alert mg-top-15 good-attributes" data-selectUrl="${pageContext.request.contextPath}/shop/good/select" data-spuId="${viewSku.spuId}">
               <c:forEach items="${viewSpu.attributes}" var="attribute" varStatus="statu">  
               <c:if test="${attribute.priceType ==2}">            
               <div class="mg-bottom-30">
                 <span class="good-attribute">${attribute.attributeName}</span>
                 <c:forEach items="${attribute.options}" var="option" varStatus="statu">
                 <a href="javascript:;" class="good-option ${skuOptionIds.contains(option.id) ? 'option-active' : null}" data-optionId="${option.id}">
                  ${option.optionName}
                  <c:if test="${skuOptionIds.contains(option.id)}">
                    <i class="fa fa-check good-option-active"></i>
                  </c:if>
                 </a>
                 </c:forEach>
               </div>
               </c:if>
               </c:forEach>
               <div class="mg-bottom-30">
                 <span class="good-attribute">数量</span>     
                 <span class="">                  
                     <button id="sku-num-minus" class="" type="button">-</button>                   
                     <input id="sku-num-value" type="text" class="" name="nums" value="1">                  
                     <button id="sku-num-plus" class="" type="button">+</button>                
                 </span>  
                 <span class="good-stocks">库存：</span><span id="good-sticks-value" class="good-stocks-value">${viewSku.stocks}</span>               
               </div>
             </div>
             <div class="good-buy-cart" data-skuId="${viewSku.id}">
               <button id="buy-now"  class="good-buy-button ${viewSku.stocks <=0 ? 'button-disabled' : null}" data-url="${pageContext.request.contextPath}/shop/good/buy" data-skuId="${viewSku.id}">立即购买</button>
               <button id="add-cart"  data-url="${pageContext.request.contextPath}/shop/cart/add" class="good-cart-button ${viewSku.stocks <=0 ? 'button-disabled' : null} ">加入购物车</button>
             </div>
             <div class="mg-top-15 mg-left-15">
                 <a href="javascript:;"><i class="good-love fa fa-heart-o fa-lg" ></i><span class="good-attribute">收藏</span></a>                                             
             </div>
             
             
           </div>            
         </div>
       </div> 
       <!-- 商品详情及评论 -->
       <div class="container mg-top-30">
         <div class="row">
           <!-- 推荐商品 -->
            <div class="col-md-2">
              <a class="col-md-12 good-proom-list" href="javascript:;">               
                <div><span><span>推荐商品</span></span></div>       
              </a>
              <c:forEach items="${proomSkus}" var="proomSku" varStatus="statu">
              <a class="col-md-12 good-proom-list" href="javascript:window.open('${pageContext.request.contextPath}/shop/good/view/${proomSku.id}');">
                <img src="${pros.fictitiousRoot}${proomSku.picture}" />
                <div><span><span>${proomSku.skuName}</span></span></div>
                <div><span>￥</span><em class="text-danger"><fmt:formatNumber type="number" value="${proomSku.salePrice}" pattern="0.00" maxFractionDigits="2"/> </em></div>
              </a>
              </c:forEach>
            </div>
            <!-- 详情-评论 -->
            <div id="good-bottom" class="col-md-10">
               <ul id="good-nav" class="nav nav-tabs  navbar-default col-md-12 " role="tablist">
			     <li role="presentation" class="active"><a href="#sku-introduce" aria-controls="sku-introduce" role="tab" data-toggle="tab">商品介绍</a></li>
			     <li role="presentation"><a href="#sku-specification" aria-controls="sku-specification" role="tab" data-toggle="tab">规格</a></li>
			     <li role="presentation"><a href="#spu-conmment" aria-controls="spu-conmment" role="tab" data-toggle="tab">商品评价<em class="text-danger">0</em></a></li>
			     <li role="presentation"><a href="#sku-warning" aria-controls="sku-warning" role="tab" data-toggle="tab">声明</a></li>
			   </ul>

			  <!-- Tab panes -->
			  <div class="tab-content">
			    <div role="tabpanel" class="tab-pane active good-content-show" id="sku-introduce">
			      <div class="good-content">
			        ${viewSpu.spuContent}
			      </div>
			    </div>
			    <div role="tabpanel" class="tab-pane" id="sku-specification">
			     <c:forEach items="${viewSpu.attributes}" var="attribute" varStatus="statu">
			       <div class="col-md-4 spu-base-value">
			       <span class="spu-attribute-name">${attribute.attributeName}：</span>			      
			         <span class="spu-option-value">
			          <c:forEach items="${attribute.options}" var="option" varStatus="statu">
			            ${option.optionName}
			         </c:forEach>
			         </span>			      			       
			      </div>
			     </c:forEach>		       			      
			    </div>
			    <div role="tabpanel" class="tab-pane comment-gold-box" id="spu-conmment">
			      <div>
			        <div class="col-md-2 comment-gold">
			          <span class="comment-gold-span1">与描述符合度</span>
			          <span class="comment-gold-span2">4.8</span>
			        </div>
			      </div>
			      <div class="comment-select col-md-12">
			        <span class="comment-select-content col-md-5">
			            <input class="" id="comment-all" type="radio" name="radiogrounp" checked="checked">
			            <label for="comment-all">全部</label>
			            <input class="rate-list-append rate-radio-group" id="comment-second" type="radio" name="radiogrounp">
			            <label for="comment-second">追评 (0)</label>
			            <input class="rate-list-picture rate-radio-group" id="comment-picture" type="radio" name="radiogrounp">
			            <label for="comment-picture">图片 (0)</label>
			        </span>
			        <select class="col-md-2 pull-right comment-sort-content">
			          <option>默认排序</option>
			          <option>时间排序</option>
			        </select>
			      </div>
			      <table class="table col-md-12 comment-table">
                    <tbody>                     
                       <tr>
                        <td width="60%">此处是商品的评论区</td>                       
                        <td width="20%">
                          <span class="comment-attribute"><span class="comment-option">颜色：</span><span class="comment-option-value">CS7312蓝色+CS7308</span></span>
                          <span class="comment-attribute"><span class="comment-option">黑色尺码：</span><span class="comment-option-value">L</span></span>
                        </td>
                        <td width="20%" class="text-info">
                          <span class="comment-attribute"><span class="comment-option">用户名</span></span>
                        </td>
                      </tr>
                    </tbody>
                  </table>
			    </div>
			    <div role="tabpanel" class="tab-pane" id="sku-warning">开发测试，不可购物</div>
			  </div>
            </div>
         </div>        
       </div>         
     </div> 

     <!-- 结束导航栏 -->
     <%@ include file="/WEB-INF/all/include/shop-end.jsp"%>
     <!-- 结束导航栏 -->
     <%@ include file="/WEB-INF/all/include/shop-login.jsp"%>
  
   </body>
</html>