<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>分类：(测试)
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
	    .good-filter{margin-top:15px;}  
	    .good-filter-tbody tr{border:1px solid #dfdfdf;height:35px;}
	    .filter-td-left{text-align:center;background-color:#f2f2f2;color:#666;}
	    .filter-td-brand{background-color:#fbfbfb;padding-left:5%;}
	    .td-brand-a{float:left; display:block; width:10%;height:60px;margin:5px 0px;border:1px solid #ccd6df}
	    .td-brand-a:hover{border:2px solid #337ab7;}
	    .brand-span-img{display:block;width:100%;padding:5px;}	    
	    .brand-span-img>img{width:100%;height:auto;}
	    .brand-span-hide{position:absolute;display:block;z-index:-100; background-color:white;width:8%;text-align:center;height:55px;line-height:55px;margin-left:2px;margin-top:1px;}
	    .brand-span-active{z-index:1;background-color:black;opacity:0.8;}
	    .brand-span-active>span{color:white;}
	    .brand-hide-close{position:absolute;right:2px;top:2px; color:white;display:none;}
	    .brand-active:hover .brand-hide-close{display:block;}
	    .brand-span-name{color:black;font-weight:bold;font-size:1em;}	    
	    .filter-td-right{display:inline-block;min-height:45px;}
	    .filter-td-right>a{display:inline-block;text-align:center;min-width:80px;letter-spacing:1px;margin-top:5px;position:relative; padding:2px 5px;}
	    .filter-category{height:80px;background-color:#fbfbfb;padding:5px 10px;line-height:25px;}
	    .filter-category-a{padding:2px 5px;font-size:12px;letter-spacing:1px;}
	    .good-list-place{margin-top:30px;}
	     .good-sort-box{background-color:#faf9f9;height:35px;padding-top:5px;}
	    .list-sort-a{float:left;display:inline-block;border:1px solid #ccd6df;width:10%;height:25px;text-align:center;line-height:25px;}
	    .list-sort-a:hover{border:1px solid #337ab7;}
	    .list-price-input{float:left;display:inline-block;border:1px solid #ccd6df;width:30%;height:25px;text-align:center;line-height:25px;}
	    .list-price-span{float:left;display:inline-block;height:25px;text-align:center;line-height:25px;}
	    .list-price-button{float:left;display:inline-block;border:1px solid #ccd6df;width:15%;background-color:white;;height:25px;text-align:center;line-height:25px;}
	    .list-page-a{float:right;margin-right:5px;;display:inline-block;border:1px solid #ccd6df;width:15%;height:25px;text-align:center;line-height:25px;}	  
	    .good-list-box{margin-top:20px;}
	    .good-list-div{position:relative;float:left;width:20%;margin-bottom:10px;;min-height:400px;max-height:400px;border:1px solid #ccd6df;}
	    .good-list-div:hover{border:1px solid #337ab7;}
	    .good-list-img{display:block; width:100%;padding:10px;}
	    .good-list-img>img{width:100%;height:auto;}  
	    .good-name{display:block; padding:10px;text-align:center;}
	    .good-skuName{line-height:17px;}
	    .good-price{text-align:center;}
	    .price-style{font-size:15px;font-weight:bold;color:#9f1212;}
	    .good-sale-message{position:absolute;width:100%;bottom:0px;padding:0px;}
	    .good-sale-message>span{display:inline-block;width:49%;;height:25px;;border:1px solid #ccd6df;text-align:center;line-height:25px; }
	    .sale-message-span{color:#999;} .sale-message-span2{color:#9f1212;}
	    .hide-span{text-align:center;position:relative;}
	    .hide-input{width:80px;text-align:center;}
	    .hide-close{position:absolute;right:0px;top:0px;display:none;color:white;}
	    .option-active{background-color:black; color:white;border:1px solid black;opacity:0.7;}
	    .option-active:hover i {display:block;}
	    .option2-active{background-color:black; color:white;border:1px solid black;opacity:0.7;}
	    .option2-active:hover i {display:block;}
	    .sort-active{border:1px solid #9f1212; background-color:#fbfbfb;}
	    .shop-page-row{margin-top:20px;}
		.shop-page-nav{}
		.shop-page-nav ul {margin-top:2px;}
		.shop-page-turn{padding:0px;}  
		.shop-page-jump{padding:0px;}
		.button-disabled{background-color:#eee;color:#b1afaf;pointer-events: none; cursor:default;opacity: 0.8;}
	  </style>
	 	  	
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/shop/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			  
			//阻止无效页数跳转
			  pagePrevent();
			  
			  /**
			   * 跳转页面
			   */
			  $("#slectPage").click(function(){
			    selectPage();
			    	 
			  })
			//价格输入框非法则为零
			$("#startSalePrice").on("blur",function(){
				 var startSalePrice =$(this).val();
				 var reg =/^[1-9]\d*$/;
				 if(!reg.test(startSalePrice)){
					$(this).val("0")
				 }				
			});
			$("#endSalePrice").on("blur",function(){
				 var endSalePrice =$(this).val();
				 var reg =/^[1-9]\d*$/;
				 if(!reg.test(endSalePrice)){
					$(this).val("0")
				 }				
			});
			 

		  });
		  
		  //选择导购属性
		 function optionSelect(optionId,object){
			   var target = $(object);
			   target.siblings().removeClass("option-active");
			   if(target.hasClass("option-active")){
				   target.removeClass("option-active");
			   }else{
				   target.addClass("option-active");  
			   }
			     //获得相关参数并跳转目标地址
				  var  targetUrl =selectedToUrl();				  
				  window.location.href=targetUrl;
		  }
		  
		 //选择价格属性值
		 function optionSelect2(optionId,object){
			   var target = $(object);
			   target.siblings().removeClass("option2-active");
			   if(target.hasClass("option2-active")){
				   target.removeClass("option2-active");
			   }else{
				   target.addClass("option2-active");  
			   }
			   
			   //获得相关参数并跳转目标地址
			  var  targetUrl =selectedToUrl();				  
			  window.location.href=targetUrl;
			   
		  }
		 
		  
		  //选择品牌 
		  function brandSelect(object){
			  var target = $(object);
			  target.siblings().removeClass("brand-active");
			 
			  target.siblings().find(".brand-span-active").removeClass("brand-span-active");
			  if(target.hasClass("brand-active")){
				   target.removeClass("brand-active");
				   target.find(".brand-span-active").removeClass("brand-span-active");
			   }else{
				   target.addClass("brand-active");  
				   target.find(".brand-span-hide").addClass(".brand-span-active");
			   }
			  
			  //获得相关参数并跳转目标地址
			  var  targetUrl =selectedToUrl();				  
			  window.location.href=targetUrl;
		  }
		  
		  
		   //选中排序
		    function sortSelect(a,object){
			  var target =$(object);
			  target.siblings().removeClass("sort-active");
			  target.addClass("sort-active");
			  var sort =a;
			 //获得相关参数并跳转目标地址
             var  subUrl =selectedToUrl();	
			 
			 //价格区间
			 var startSalePrice =  $("#startSalePrice").val();
			 var endSalePrice =  $("#endSalePrice").val();
			 
			 var targetUrl =subUrl+"&startSalePrice="+startSalePrice+"&endSalePrice="+endSalePrice+"&sort="+sort
			 window.location.href=targetUrl;
			  
		   }
		   
		   //选择价格
		   function priceSelect(){			   
			 var startSalePrice =  $("#startSalePrice").val();
			 var endSalePrice =  $("#endSalePrice").val();			
			 			 
						 
			 //排序方式
			 var sort ='';
			 if($(".list-sort-a").hasClass("sort-active")){
				 sort =$(".sort-active").attr("data-sort"); 
			 }
			 
			 //价格区间
			 var startSalePrice =  $("#startSalePrice").val();
			 var endSalePrice =  $("#endSalePrice").val();
			 //属性链接
             var  subUrl =selectedToUrl();				  
			 var targetUrl =subUrl+"&startSalePrice="+startSalePrice+"&endSalePrice="+endSalePrice+"&sort="+sort
			 window.location.href=targetUrl;
			   
		   }
		  
		  
		  
		    //页面跳转
			function skipPage(currentPage){
		    	
				   //排序方式
				   var sort ='';
				   if($(".list-sort-a").hasClass("sort-active")){
					 sort =$(".sort-active").attr("data-sort"); 
				   }				 
				   //价格区间
				   var startSalePrice =  $("#startSalePrice").val();
				   var endSalePrice =  $("#endSalePrice").val();
				   //属性链接
	               var  subUrl =selectedToUrl();				  
				   var targetUrl =subUrl+"&startSalePrice="+startSalePrice+"&endSalePrice="+endSalePrice+"&sort="+sort+"&currentPage="+currentPage
				   window.location.href=targetUrl;
				   
				  
			}
			
			/**
	         * 选择页码
	         */          
	        function selectPage(){
				
	        	var currentPage = $("#jumpPage").val();
	        	var pages   = $("#End").attr("data-pages");
	        	if(currentPage<=0 || currentPage>pages){
	        		return false;
	        	}
	        	
	        	//排序方式
				 var sort ='';
				 if($(".list-sort-a").hasClass("sort-active")){
					 sort =$(".sort-active").attr("data-sort"); 
				   }				 
				   //价格区间
				   var startSalePrice =  $("#startSalePrice").val();
				   var endSalePrice =  $("#endSalePrice").val();
				   //属性链接
	               var  subUrl =selectedToUrl();				  
				   var targetUrl =subUrl+"&startSalePrice="+startSalePrice+"&endSalePrice="+endSalePrice+"&sort="+sort+"&currentPage="+currentPage
				   window.location.href=targetUrl;
	        }	
		  
		  
		  //获得相关参数并跳转目标地址
		  function selectedToUrl(){
			   //获得三级分类Id
			   var categoryId =$(".good-filter").attr("data-categoryId");
			   
			   //获得所有被选择了的导购属性值
			     var optionIds = new Array();
			     $(".option-active").each(function(i){
			    	 optionIds.push($(this).attr("data-optionId")) 
			     })
			     
			  //获得所有被选择了的价格属性值
			    var option2Ids = new Array();
			    $(".option2-active").each(function(i){
			    	 option2Ids.push($(this).attr("data-optionId")) 
			     })
			     
			   //获得被选择了的品牌	
			   var brandId ='';
			   if($(".td-brand-a").hasClass("brand-active")){
				   brandId =$(".brand-active").attr("data-brandId");
			   }
			   			   
			   //目标地址
			   var url =$(".good-filter").attr("data-url");
			   var targetUrl =url+"?categoryId="+categoryId+"&brandId="+brandId+"&optionIds="+optionIds+"&option2Ids="+option2Ids
			   return targetUrl ;
		  }
		  
		  //页数尽头添加禁止图标
		  function pagePrevent(){
			
			var pageNum = $(".pagination>.active").text();	
			
			var pages   = $("#End").attr("data-pages");
			
			if(pageNum==1){
				$("#Previous").addClass("button-disabled");
				$("#First").addClass("button-disabled");
			}else{
				$("#Previous").removeClass("button-disabled");
				$("#First").removeClass("button-disabled");
			}
			
			if(pageNum==pages){
				$("#Next").addClass("button-disabled");
				$("#End").addClass("button-disabled");
			}else{
				$("#Next").removeClass("button-disabled");
				$("#End").removeClass("button-disabled");
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
            <c:if test="${targetCategory.parentCategory.parentCategory != null}">
             <a href="${pageContext.request.contextPath}/shop/good/listThird?categoryId=${targetCategory.parentCategory.parentCategory.id}">${targetCategory.parentCategory.parentCategory.categoryName}</a>
             <span>></span>
            </c:if> 
            <c:if test="${targetCategory.parentCategory != null}">
             <a href="${pageContext.request.contextPath}/shop/good/listThird?categoryId=${targetCategory.parentCategory.id}">${targetCategory.parentCategory.categoryName}</a>
             <span>></span>
            </c:if> 
             <a href="${pageContext.request.contextPath}/shop/good/listThird?categoryId=${targetCategory.id}">${targetCategory.categoryName}</a>
             <span>></span>            
           </div>              
         </div>
       </div>          
     </div> 
     <!-- 商品筛选 -->
     <div class="good-filter" data-url="${pageContext.request.contextPath}/shop/good/listThird" data-categoryId="${targetCategory.id}">
       <div class="container">
         <div class="row">
           <table class="col-md-12">
             <tbody class="good-filter-tbody">
              <c:if test="${!targetCategory.childrenCategorys.isEmpty()}">
               <!-- 下级分类 -->
               <tr>
                 <td class="filter-td-left" width="10%">分类</td>
                 <td class="filter-category" width="90%">
                  <c:forEach items="${targetCategory.childrenCategorys}" var="sonCategory" varStatus="statu">
                    <a class="filter-category-a" href="${pageContext.request.contextPath}/shop/good/listThird?categoryId=${sonCategory.id}" >                     
                      <span class="">${sonCategory.categoryName}</span>                                                                                   
                    </a>
                  </c:forEach>                   
                 </td>
               </tr>
              </c:if>
              <c:if test="${!viewCategoryBrands.isEmpty()}">
               <!-- 品牌 -->
               <tr>
                 <td class="filter-td-left" width="10%">品牌</td>
                 <td class="filter-td-brand" width="90%">
                  <c:forEach items="${viewCategoryBrands}" var="viewCategoryBrand" varStatus="statu">
                    <a class="td-brand-a ${params.brandId !=null && params.brandId ==viewCategoryBrand.brandId ? 'brand-active' :null }" href="javascript:;"   onclick="brandSelect(this)" data-brandId="${viewCategoryBrand.brandId}">                     
                      <span class="brand-span-hide ${params.brandId !=null && params.brandId ==viewCategoryBrand.brandId ? 'brand-span-active' :null }""><span class="brand-span-name">${viewCategoryBrand.brandName}</span><i class="brand-hide-close fa fa-close"></i></span>                     
                      <span class="brand-span-img"><img src="${pros.fictitiousRoot}${viewCategoryBrand.logo}" /></span>                                                               
                    </a>
                  </c:forEach>                   
                 </td>
               </tr>
              </c:if> 
               <!-- 分为导购属性和价格属性 -->
               <c:forEach items="${viewCategory.attributes}" var="attribute" varStatus="statu">
               <c:if test="${attribute.guideType ==2 ||attribute.priceType ==2}">
                 <tr>               
                   <td class="filter-td-left"  width="10%">${attribute.attributeName}</td>              
                   <td class="filter-td-right" width="90%">
                   <c:forEach items="${attribute.options}" var="option" varStatus="statu">
                   <c:choose>                    
                     <c:when test="${attribute.priceType ==2}">
                       <a href="javascript:;" onclick="optionSelect2(${option.id},this)" ${params.option2Ids.contains(option.id) ? 'class="option2-active"':null }    data-optionId="${option.id}" ><span>${option.optionName}</span><i class="hide-close fa fa-close"></i></a>
                     </c:when>                   
                     <c:otherwise>
                       <a href="javascript:;" onclick="optionSelect(${option.id},this)" ${params.optionIds.contains(option.id) ? 'class="option-active"':null }    data-optionId="${option.id}" ><span>${option.optionName}</span><i class="hide-close fa fa-close"></i></a>
                     </c:otherwise>
                   </c:choose>
                   
                   </c:forEach>    
                   </td>              
                 </tr>
               </c:if>
               </c:forEach>
             </tbody>
           </table>              
         </div>
       </div> 
     </div>
     <!-- 商品展 -->
     <div class="good-list-place">
       <div class="container">
         <div class="row good-sort-box">
           <!-- 排序方式 -->
           <div class="col-md-6">
             <a class="list-sort-a  ${params.sort ==1 ||params.sort ==null ? 'sort-active' : null}" href="javascript:;" onclick="sortSelect(1,this)" data-sort="1" >默认<i class="fa fa-sort-desc"></i></a>
             <a class="list-sort-a ${params.sort ==2 ? 'sort-active' : null}" href="javascript:;" onclick="sortSelect(2,this)" data-sort="2">人气<i class="fa fa-sort-desc"></i></a>
             <a class="list-sort-a ${params.sort ==3 ? 'sort-active' : null}" href="javascript:;" onclick="sortSelect(3,this)" data-sort="3">销量<i class="fa fa-sort-desc"></i></a>
             <a class="list-sort-a ${params.sort ==4 ? 'sort-active' : null}" href="javascript:;" onclick="sortSelect(4,this)" data-sort="4">新品<i class="fa fa-sort-desc"></i></a>
             <a class="list-sort-a ${params.sort ==5 ? 'sort-active' : null}" href="javascript:;" onclick="sortSelect(5,this)" data-sort="5">价格<i class="fa fa-sort-desc"></i></a>
             <a class="list-sort-a ${params.sort ==6 ? 'sort-active' : null}" href="javascript:;" onclick="sortSelect(6,this)" data-sort="6">价格<i class="fa fa-sort-asc"></i></a>
           </div>
           <div class="col-md-3">
             <input id="startSalePrice" class="list-price-input" type="text" name="startSalePrice" value="${params.startSalePrice}" placeholder="价格" />
             <span class="list-price-span">-</span>
             <input id="endSalePrice" class="list-price-input" type="text" name="endSalePrice"   value="${params.endSalePrice}" placeholder="价格" />
             <input  class="list-price-button" type="button" onclick="priceSelect()" name="submit" value="确定" placeholder="价格" />
           </div>
           <div class="col-md-3">
             <a class="list-page-a" href="javascript:skipPage(${pageInfo.nextPage});">下页</a> 
             <a class="list-page-a" href="javascript:skipPage(${pageInfo.prePage});">上页</a>
           </div>               
         </div>
         <!-- 商品列表 -->
         <div class="row">
           <div class="col-md-12 good-list-box">
            <c:forEach items="${pageInfo.list}" var="viewSku" varStatus="statu">
             <div class="good-list-div">
               <a href="javascript:window.open('${pageContext.request.contextPath}/shop/good/view/${viewSku.id}')" class="good-list-img"><img src="${pros.fictitiousRoot}${viewSku.picture}"/></a>
               <a href="javascript:window.open('${pageContext.request.contextPath}/shop/good/view/${viewSku.id}')" class="good-name"><span><span class="good-skuName">${viewSku.skuName}</span></span></a>
               <div class="good-price"><span>￥</span><em class="price-style"><fmt:formatNumber type="number" value="${viewSku.salePrice}" pattern="0.00" maxFractionDigits="2"/></em></div>
               <div class="good-sale-message">
                 <span  ><span class="sale-message-span">月成交</span><span class="sale-message-span2">0</span></span>
                 <span><span class="sale-message-span">评论</span><span class="sale-message-span2">0</span></span>
               </div>
             </div>
            </c:forEach> 
           </div>              
         </div>
       </div>                
     </div> 
       
        <!-- 分页 -->
		  <div class="container">
		   <div class="row shop-page-row">
		     <div class="col-md-3 text-info">
			   <span>共有记录：</span>
			   <span>${pageInfo.getTotal()}</span>
			   <span>条</span>
			   <span>,</span>
			   <span>当前显示第</span>
			   <span>${pageInfo.getPageNum()}</span>
			   <span>/</span>
			   <span>${pageInfo.getPages()}</span>
			   <span>页</span>	   
			 </div>
			 	 
		     <div class="col-md-5 col-md-offset-2 shop-page-turn">
			   <nav aria-label="Page navigation" class="pull-right shop-page-nav">
				  <ul class="pagination" data-url="${pageContext.request.contextPath}/shop/order/center" data-orderStatu="${orderStatu}">
				    <li id="First">
					  <a href="javascript:skipPage(${pageInfo.navigateFirstPage});" aria-label="First">
						<span aria-hidden="true">|&laquo;</span>
					  </a>
					</li>
					<li id="Previous">
					  <a href="javascript:skipPage(${pageInfo.prePage});" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					  </a>
					</li>
					
					<c:if test="${pageInfo.pageNum>2}">
					  <li><a href="javascript:skipPage(${pageInfo.pageNum-2});">${pageInfo.pageNum-2}</a></li>
					</c:if>
					
								
					<c:if test="${pageInfo.pageNum>1}">
					  <li><a href="javascript:skipPage(${pageInfo.pageNum-1});">${pageInfo.pageNum-1}</a></li>	
					</c:if>
					
									
					<li class="active"><a href="javascript:skipPage(${pageInfo.pageNum});">${pageInfo.pageNum}</a></li>
					
					<c:if test="${pageInfo.pageNum<pageInfo.pages}">
					  <li><a href="javascript:skipPage(${pageInfo.pageNum+1});">${pageInfo.pageNum+1}</a></li>
					</c:if>
									
					<c:if test="${pageInfo.pageNum<pageInfo.pages-1}">
					  <li><a href="javascript:skipPage(${pageInfo.pageNum+2});">${pageInfo.pageNum+2}</a></li>
					</c:if>
					
					<li id="Next">
					  <a href="javascript:skipPage(${pageInfo.nextPage});" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
					<li id="End" data-pages="${pageInfo.pages}">
					  <a href="javascript:skipPage(${pageInfo.navigateLastPage});" aria-label="End">
						<span aria-hidden="true">&raquo;|</span>
					  </a>
					</li>
				  </ul>
		         </nav>
			 </div>
			 <div class="col-md-2  shop-page-jump">
			   <div class="input-group">
				  <input id="jumpPage" type="text" class="form-control" placeholder="请选择页数">
				  <span class="input-group-btn">
					<button id="slectPage" class="btn btn-default" type="button">选择</button>
				  </span>
			   </div>
			 </div>
		   </div>
		  </div> 
       
       
       <!-- 结束导航栏 -->
      <%@ include file="/WEB-INF/all/include/shop-end.jsp"%>
   </body>
</html>