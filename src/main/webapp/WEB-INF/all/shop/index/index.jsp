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
	    body{background-color:#fbfbfb;}	    
	    .shop-index-search{height:100px;margin-top:30px;}
	    .shop-index-logo{width:50%;height:auto;}
	    .shop-index-categoryAndAd{background-image:url(../resources/image/background/four2.jpg);}
	    
	    .shop-index-category{background-color:black;opacity:0.8;border-radius:5px;margin-right:0px;padding-right:0px;}
	    .index-category-li{border-bottom:1px solid white;}
	    .index-category-li :hover{background-color:white;} .index-category-li :hover .index-category-a{color:black;font-weight:bold;}
	    .index-category-div{color:white;padding-top:10px;padding-bottom:9.5px;}
	    .index-category-a{color:white;}     .index-category-a :hover{color:#337ab7;}
	    .shop-index-ad{padding:0px;height:425px;}
	    #category-view{position:absolute;opacity:0.97; left:29.5%; min-width:52.1%;max-width:52.1%;z-index:-100; min-height:425px;background-color:#f9f9f9;}
	    .index-groom-place{background-image:url(../resources/image/background/four2.jpg);}
	    .groom-place{max-height:100px;margin-top:50px;}
	    .groom-img-left-bg {box-shadow: #666 0px 0px 10px;width:100%;height:auto;margin-top:15px;}
	    .groom-img-right-bg {box-shadow: #666 0px 0px 10px;width:100%;height:auto;margin-top:15px;}
	    .groom-img-middle-bg {box-shadow: #666 0px 0px 10px;margin-bottom:20px;width:100%;height:auto;}
	    .groom-img-left-name1{position:absolute;top:60px;left:25px;  font-size:24px;font-weight:bolder;color:#872b92;}
	    .groom-img-left-name2{position:absolute;top:90px;left:80px;  font-size:18px;font-weight:bolder;color:#872b92;}
	    .groom-img-left-good{position:absolute;top:135px;left:20px;height:auto;width:50%;height:auto;}
	    .groom-img-middle-name1{position:absolute;top:20px;left:25px;  font-size:18px;font-weight:bolder;color:#872b92;}
	    .groom-img-middle-name2{position:absolute;top:45px;left:70px;  font-size:14px;font-weight:bolder;color:#872b92;}
	    .groom-img-middle-good{position:absolute;top:50px;left:90px;width:50%;height:auto;}
	    .groom-img-middle-name3{position:absolute;top:20px;left:165px;  font-size:18px;font-weight:bolder;color:#872b92;}
	    .groom-img-middle-name4{position:absolute;top:45px;left:140px;  font-size:14px;font-weight:bolder;color:#872b92;}
	    .groom-img-middle-good2{position:absolute;top:50px;left:20px;width:50%;height:auto;}
	    .groom-img-right-name1{position:absolute;top:60px;left:25px;  font-size:24px;font-weight:bolder;color:#2a8897;}
	    .groom-img-right-name2{position:absolute;top:90px;left:80px;  font-size:18px;font-weight:bolder;color:#2a8897;}
	    .groom-img-right-good{position:absolute;top:155px;left:80px;width:30%;height:auto;}
	    .index-brand-place{box-shadow: #666 0px 0px 10px;}
	    .index-brand-ul{margin-top:20px; list-style:none;margin-left:20px;}
	    .index-brand-li{width:110px;height:110px;border:1px solid #dfdfdf;padding:0px;line-height:100px;}	    
	    .index-brand-li>a{position:absolute;display:none;;width:110px;height:110px;}
	    .index-brand-li>a>em{position:absolute;display:block; text-align:center; width:110px;height:110px; font-size:15px;font-weight:bold;color:white;}
	    .index-brand-li>a>input{display:block;margin-top:85px;margin-left:70px;}
	    .index-brand-li:hover a{opacity:0.8;background-color:black;display:block;} 
	    .index-brand-li>img{width:100%;height:auto;}
	    .index-good-place{margin-top:50px;}
	    .index-good-head{background-color:#be2070;height:12px;}
	    .index-good-category{margin-top:10px;}
	    .good-category-memo{margin-bottom:10px;} 
	    .skuName-text{line-height:17px;font-size:10px;}
	    .good-head-text{font-size:15px;font-weight:bold;color:#8e2f2f;}
	    .good-title-span{display:inline-block; text-align:center;line-height:20px; width:15px;height:15px;border-radius:5px;color:white;background-color:#8e2f2f; }
	    .good-title-span2{display:inline-block;font-size:20px;font-weight:bolder;color:#867c80;}
	    .index-good-list{display:block;;text-align:center;height:350px;border:1px solid #dfdfdf;}
	    .index-good-list:hover{ box-shadow: #666 0px 0px 10px;border:1px solid #cbdceb;}
	    .index-good-list>div{position:relative;margin-top:15px;}
	    .index-good-list>img{position:relative; width:100%; height:auto; margin-top:20px;}  
	    .endLine{border-bottom:1px solid #d0cbcb;margin-top:50px;margin-bottom:20px; height:10px;}
	  </style>
	 	  	
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/shop/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			  //动态获取分类详情，动态展示
			 // var load ="<div id='category-loading' style='text-align:center;margin-top:150px;;'><i class='fa fa-spinner fa-pulse fa-3x'></i></div>";
			  $("#category-place").on({				 
				 mouseenter :function(){	
					  //加载效果
					  $("#category-view").css("z-index","999").load(targetUrl);		  
				 },
				 mouseleave :function(event){ 					  				    
					$("#category-view").css("z-index","-1").empty();					   			  					 
					 				  
				 }				  
			  });			  
			  $(".index-category-li").on({					 
					 mouseenter :function(){
						  var targetUrl = $(this).attr("data-url")+" "+"#category-content";	 										  
						  $("#category-view").load(targetUrl);				  
					 }
			  });
			  
			  // 滑动效果 
			  $('.index-good-list').mouseenter(function(){ 				   
				  $(this).find("img").animate({bottom:("-"+(0.05 * $(this).height())/2)}, 1000).animate({bottom:"0px"}, 1000 ); 
				  $(this).find("div").animate({bottom:("-"+(0.05 * $(this).height())/2)}, 1100).animate({bottom:"0px"}, 1100 );				  
		      })  
				  
		    
			 
		  });
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
         <ul class="nav nav-tabs col-md-10 col-md-offset-2">
           <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/shop/index">商城首页</a></li>         
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
     <!-- 分类栏+广告栏 --> 
     <div class="shop-index-categoryAndAd">
       <div class="container">
         <div class="row">
             <!-- 直立分类导航 -->
             <div id="category-place">
              <ul class="col-md-2 shop-index-category nav nav-pills  nav-stacked">
                <c:forEach items="${rootCategorys}" var="category" varStatus="statu">
                  <li id="root-category-${category.id}" role="presentation" class="index-category-li" data-url="${pageContext.request.contextPath}/shop/categoryView?rootCategoryId=${category.id}">                                  
                      <div class="index-category-div" >
                         <i class="i-style2  fa-lg ${category.imageUrl}" style="display:inline-block;min-width:12px; max-width:12px;margin-left:5px;"></i>                        
                           <a id="category-skip-${category.id}" class="index-category-a" href="javascript:;"><span class="mg-left-15">${category.categoryName}</span> </a>                                                        
                      </div>                  
                  </li>
                </c:forEach>                                                        
              </ul>
              <!-- 详情分类 -->
              <div id="category-view" class="category-view" >               
              </div>
             </div> 
              <!-- 广告栏 -->
              <div id="carousel-example-generic" class="col-md-10 shop-index-ad carousel slide" data-ride="carousel">
				  <!-- Indicators -->
				  <ol class="carousel-indicators">
				    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
				  </ol>
				
				  <!-- Wrapper for slides -->
				  <div class="carousel-inner" role="listbox" >
				    <div class="item active" onclick="window.open('${pageContext.request.contextPath}/shop/good/view/10031')">
				      <img style="height:425px;" src="${pageContext.request.contextPath}/resources/image/background/oppo.jpg" alt="...">
				      <div class="carousel-caption">
				       
				      </div>
				    </div>
				    <div class="item" onclick="window.open('${pageContext.request.contextPath}/shop/good/view/10035')">
				      <img style="height:425px;" src="${pageContext.request.contextPath}/resources/image/background/xiaomi.jpg" alt="...">
				      <div class="carousel-caption">
				       
				      </div>
				    </div>
				    <div class="item">
				      <img style="height:425px;" src="${pageContext.request.contextPath}/resources/image/background/jianguo.jpg" alt="...">
				      <div class="carousel-caption">
				       
				      </div>
				    </div>
				   
				  </div>
				
				  <!-- Controls -->
				  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
				    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				    <span class="sr-only">Previous</span>
				  </a>
				  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				    <span class="sr-only">Next</span>
				  </a>
                </div>
            </div>
         </div>          
     </div> 
       <!-- 推荐会场 -->
     <div class="index-groom-place">      
      <div class="container">        
        <div class="row  groom-place">
          <div class="sol-md-12">
            <div class="col-md-3 groom-img">
              <em class="groom-img-left-name1">精品男装</em>
              <em class="groom-img-left-name2">穿出你的范</em>
              <img class="groom-img-left-good"  src="${pageContext.request.contextPath}/resources/image/png/man.png" alt="...">
              <img class="groom-img-left-bg"  src="${pageContext.request.contextPath}/resources/image/background/category-room1.png" alt="...">
            </div>
            <div class="col-md-6">
              
              <div class="col-md-6 groom-middle-img">
                <em class="groom-img-middle-name1">运动健身</em>
                <em class="groom-img-middle-name2">玩转低价</em>
                <img class="groom-img-middle-good" style="width:50%;"  src="${pageContext.request.contextPath}/resources/image/png/shone.png" alt="...">
                <img class="groom-img-middle-bg"  src="${pageContext.request.contextPath}/resources/image/background/category-room2.png" alt="...">
              </div>
              <div class="col-md-6 groom-middle-img" >
                <em class="groom-img-middle-name3">护肤美妆</em>
                <em class="groom-img-middle-name4">帅气靓丽</em>
                <img class="groom-img-middle-good2" style="width:20%;"  src="${pageContext.request.contextPath}/resources/image/png/beaut.png" alt="...">
                <img class="groom-img-middle-bg"  src="${pageContext.request.contextPath}/resources/image/background/category-room3.png" alt="...">
              </div>
              <div class="col-md-6 groom-middle-img" >
                <em class="groom-img-middle-name1">手机数码</em>
                <em class="groom-img-middle-name2">爆款特价</em>
                <img class="groom-img-middle-good" style="width:20%;"  src="${pageContext.request.contextPath}/resources/image/png/phone.png" alt="...">
                <img class="groom-img-middle-bg"  src="${pageContext.request.contextPath}/resources/image/background/category-room2.png" alt="...">
              </div>
              <div class="col-md-6 groom-middle-img" >
                <em class="groom-img-middle-name3">图书杂志</em>
                <em class="groom-img-middle-name4">瀚海如书</em>
                <img class="groom-img-middle-good2" style="width:45%;"  src="${pageContext.request.contextPath}/resources/image/png/book.png" alt="...">
                <img class="groom-img-middle-bg"  src="${pageContext.request.contextPath}/resources/image/background/category-room3.png" alt="...">
              </div>
              <div class="col-md-6 groom-middle-img" >
                <em class="groom-img-middle-name1">大家电</em>
                <em class="groom-img-middle-name2">不敢小觑</em>
                <img class="groom-img-middle-good" style="width:35%;"  src="${pageContext.request.contextPath}/resources/image/png/tv.png" alt="...">
                <img class="groom-img-middle-bg"  src="${pageContext.request.contextPath}/resources/image/background/category-room2.png" alt="...">
              </div>
              <div class="col-md-6 groom-middle-img" >
                 <em class="groom-img-middle-name3">零食饮料</em>
                <em class="groom-img-middle-name4">好吃好喝</em>
                <img class="groom-img-middle-good2" style="width:15%;"  src="${pageContext.request.contextPath}/resources/image/png/drink.png" alt="...">
                <img class="groom-img-middle-bg"  src="${pageContext.request.contextPath}/resources/image/background/category-room3.png" alt="...">
              </div>
            </div>
            <div class="col-md-3 groom-img">
               <em class="groom-img-right-name1">精品女装</em>
               <em class="groom-img-right-name2">我有我的型</em>
               <img class="groom-img-right-good"  src="${pageContext.request.contextPath}/resources/image/png/woman.png" alt="...">
               <img class="groom-img-right-bg"  src="${pageContext.request.contextPath}/resources/image/background/category-room4.png" alt="...">
            </div>
          </div>
         </div>
      </div>    
     </div>
      <!-- 品牌推荐 -->
      <div class="container index-brand-place">
        <div class="row">
           <ul class="col-md-12 index-brand-ul"> 
            <c:forEach items="${brands}" var="brand" varStatus="statu">         
             <li id="brand-li-${brand.id}" class="index-brand-li col-md-1"> 
               <a href="javascript:window.open();"> 
                 <em>
                   <span>${brand.brandName}</span>                                     
                 </em>   
                 <input class="btn btn-danger btn-xs" type="button" value="进入">                          
               </a>
               <img src="${pros.fictitiousRoot}${brand.logo}" class=""/>
             </li>
           </c:forEach>  
           </ul>
        </div>
      </div>  
      <!-- 商品展览 --> 
      <div class="container index-good-place">
        <!-- 横条 -->
        <div class="row">
          <div class="col-md-5 index-good-head"></div>
          <div class="col-md-2 text-center">
            <span class="good-head-text" >懂你想要</span>
          </div>
          <div class="col-md-5 index-good-head"></div>
        </div>
        <!-- 男装-->
        <div class="row index-good-category">
          <div class="col-md-12 good-category-memo"><span class="good-title-span">*</span><span class="good-title-span2">服饰</span><span class="good-title-span">*</span></div> 
          <!-- 主体 -->
           <c:forEach items="${clothsSkus}" var="clothsSku" varStatus="statu"> 
            <a class="col-md-2 index-good-list" href="javascript:window.open('${pageContext.request.contextPath}/shop/good/view/${clothsSku.id}');">
              <img src="${pros.fictitiousRoot}${clothsSku.picture}" />
              <div><span><span class="skuName-text">${clothsSku.skuName}</span></span></div>
              <div><span>￥</span><em class="text-danger"><fmt:formatNumber type="number" value="${clothsSku.salePrice}" pattern="0.00" maxFractionDigits="2"/></em></div>
            </a>
           </c:forEach>        
        </div>
        <!-- 横条 -->
        <div class="row" style="margin-top:35px;">
          <div class="col-md-5 index-good-head"></div>
          <div class="col-md-2 text-center">
            <span class="good-head-text" >知你想买</span>
          </div>
          <div class="col-md-5 index-good-head"></div>
        </div>
        <!-- 手机-->
        <div class="row index-good-category">
          <div class="col-md-12 good-category-memo"><span class="good-title-span">*</span><span class="good-title-span2">手机-家电</span><span class="good-title-span">*</span></div> 
          <!-- 主体 -->
           <c:forEach items="${phoneSkus}" var="phoneSku" varStatus="statu"> 
            <a class="col-md-2 index-good-list" href="javascript:window.open('${pageContext.request.contextPath}/shop/good/view/${phoneSku.id}');">
              <img src="${pros.fictitiousRoot}${phoneSku.picture}" />
              <div><span><span class="skuName-text">${phoneSku.skuName}</span></span></div>
              <div><span>￥</span><em class="text-danger"><fmt:formatNumber type="number" value="${phoneSku.salePrice}" pattern="0.00" maxFractionDigits="2"/></em></div>
            </a>
           </c:forEach>        
        </div>       
      </div>
      
      
      <!-- 结束导航栏 -->
      <%@ include file="/WEB-INF/all/include/shop-end.jsp"%>
       
   </body>
</html>