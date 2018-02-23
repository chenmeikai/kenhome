<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>凯之家订单中心(测试)
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      
      <!-- font样式 -->
      <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
     	  
	  <link href="${pageContext.request.contextPath}/resources/css/shop/common.css" rel="stylesheet">
	  	  
	  <style type="text/css">
	     
header{
	
	
	background-color:#f2f2f2;
}

a:hover{text-decoration:none;}


.index-welcome{
	padding-left:20px;
	margin-top:10px;
}

.text-strong{font-weight:600;}
.order-pay{margin-bottom:10px;}

.order-bar{
	height:80px;background-color:#b00303;margin-top:0px;
}

.order-bar ul a{
	color:white;font-size:16px; padding-top:18px;margin-right:30px;
}

.order-bar ul a:hover{color:black;}

.alert-red{
	background-color:rgba(169, 66, 66, 0.08);border:1px solid rgba(255, 0, 0, 0.15);
}
.alert-blue{
	background-color:rgba(51, 122, 183, 0.08);border:1px solid #d9edf7;
}
.logo-img{width:50%;height:auto;margin-top:25px;}
.text-margintop-40{margin-top:40px;}
.text-margintop-30{margin-top:30px;}
.text-margintop-25{margin-top:25px;}
.text-margintop-20{margin-top:20px;}
.text-margintop-10{margin-top:10px;}
.text-margintop--8{margin-top:-8px;}
.text-margintop--20{margin-top:-20px;}
.order-leftbar{margin-top:40px;padding:0px;}
.order-leftbar>li{padding:0px;text-align:center;}
.order-leftbar>li>a{padding:10px 0px;margin-top:25px;font-size:13px;}

.order-body-content:hover{border:1px solid #bce8f1;}
.order-account{color:white;font-size:15px;font-weight:600;}
.order-account:hover{color:#bdbdbd;}

.order-body{margin-top:20px;}

.order-head{margin-top:20px;height:45px;}

.order-text{font-size:12px;color:}

.order-product-message {border-bottom:1px solid rgba(0, 0, 0, 0.13); border-right:1px solid rgba(0, 0, 0, 0.13);padding-bottom:10px;padding-top:5px;}
 
.order-smallImage{width:100px;height:auto;}

.order-commend-line{font-size:16px;color:#9f9797;font-weight:600;margin-top:50px;padding-bottom:5px;border-bottom:1px solid rgba(0, 0, 0, 0.13);}
.order-commend-line-left{padding-bottom:7px;border-bottom:1px solid #b00303;}
.order-skuName{letter-spacing:1px;line-height:15px;}
.order-text-style{letter-spacing:1px;line-height:15px;font-size:8px;text-align:center;padding:0px;}

.panel-middle {
  padding: 10px 15px;
  border-top: 1px solid #ddd;
  border-bottom-right-radius: 3px;
  border-bottom-left-radius: 3px;
  min-height:200px;
}

.school-comment{font-weight: bold;color:white;border-radius:5px;padding:5px;font-size:12px;margin-top:5px;}

.order-school{text-align:center;background-color:#d9edf7;}

.order-goods{padding:0px;}
.order-good{background-color:#eaeaea;text-align:center;}

.order-cutline{margin-top:60px;border-bottom:1px solid rgba(0, 0, 0, 0.13);}

.shop-page-row{margin-top:20px;}
.shop-page-nav{}
.shop-page-nav ul {margin-top:2px;}
.shop-page-turn{padding:0px;}  
.shop-page-jump{padding:0px;}
.button-disabled{background-color:#eee;color:#b1afaf;pointer-events: none; cursor:default;opacity: 0.8;}

.main-about{
	margin-top:50px;
}

.main-about a{margin-left:50px;text-align:center;color:black;
	
}

.main-end{
	margin-top:20px;text-align:center;
}

.main-end>h5{
	font-size:12px;
}
	    
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
			  
			 
			
	      });
		  
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
		
		//页面跳转
		function skipPage(currentPage){
			var rootUrl = $(".pagination").attr("data-url");
			var orderStatu =$(".pagination").attr("data-orderStatu");
			var targetUrl =rootUrl+"?orderStatu="+orderStatu+"&currentPage="+currentPage;
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
        	var rootUrl = $(".pagination").attr("data-url");
			var orderStatu =$(".pagination").attr("data-orderStatu");
			var targetUrl =rootUrl+"?orderStatu="+orderStatu+"&currentPage="+currentPage;
			window.location.href=targetUrl;       
        }	
		
		
        //取消订单			  
		function cancelOrder(targetUrl,object){
        	  
			bootbox.confirm({
                buttons: {
                    confirm:{
                        label:'确认',
                        className:'btn-primary'
                    },
                    cancel:{
                        label:'取消',
                        className:'btn-default'
                    }
                },
                message:'是否确定取消订单？',
                callback:function(result){
                	if(result){        			
            			$.get(targetUrl,function(result){
            				if(result.valid =="true1"){
            					setTimeout(function () {bootbox.alert("订单已成功取消",function(){
            						setTimeout(function () {location.reload()}, 500);
            					});}, 500);
            					
            					
            				}else if(result.valid =="true2"){
            					setTimeout(function () {bootbox.alert("订单已成功取消，金额将24小时内原路退还",function(){
            						setTimeout(function () {location.reload()}, 500);
            					});}, 500);
            					          					
            				}else if(result.valid=="illegle"){
            					setTimeout(function () {bootbox.alert("非法请求")}, 500);
            				}else if(result.valid =="noUser"){
            					window.location.href=result.target;
            				}else
            				setTimeout(function () {bootbox.alert("请求失败")}, 500);
            			})           			
            		}else{
            			return ;
            		}
                },
               className:"bootbox-sm"
           });		       	
        }
        
        //删除订单
        function deleteOrder(targetUrl,object){
        	
        	$.get(targetUrl,function(result){
				if(result.valid =="true"){
					var targetTag =$(object).parents(".each-order");
					targetTag.fadeTo("slow", 0.01, function(){//fade
            			targetTag.slideUp(50, function() {//slide up
            				targetTag.remove();
            		    });
            		});										
				}else if(result.valid =="false"){
					setTimeout(function () {bootbox.alert("删除失败")}, 500);				          					
				}else if(result.valid=="illegle"){
					setTimeout(function () {bootbox.alert("非法请求")}, 500);
				}else if(result.valid == "noUser"){
					window.location.href=result.target;
				}else
				 setTimeout(function () {bootbox.alert("请求失败")}, 500);
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
	  <div class="order-bar">
	    <div class="container">
	      <div class="row order-bar">
		     <div class="col-md-3">
		      <a href="${pageContext.request.contextPath}/shop/index" class="">
			    <img src="${pageContext.request.contextPath}/resources/image/logo/kenhome-white.png" class="img-responsive logo-img"/>
			  </a>
		     </div>
			 <div class="col-md-1">
			   <div class="text-margintop-30">
			     <a href="${pageContext.request.contextPath}/shop/user/center" class="order-account">
			               账号设置
			     </a>
			   </div>		      
		     </div>
		  
			  <div class="col-md-6 col-md-offset-2 main-search">
				<div class="input-group text-margintop-25">				 
				  <input type="text" class="form-control" placeholder="商品...">
				  <span class="input-group-btn">
					<button class="btn btn-default" type="button"><i class="glyphicon glyphicon-search"></i></button>
				  </span>
				</div>				
			   </div>
		  </div>
		</div>	   
	   </div>
	   
	   <!--订单-->
	   <div class="container order-body">
	     <div class="col-md-1">
		   <ul class="nav nav-pills nav-stacked text-left order-leftbar">
			  <li class=""><a href="#">已买商品</a></li>
			  <li><a href="${pageContext.request.contextPath}/shop/cart/center">我的购物车</a></li>
			  <li><a href="javascript:;">我的收藏</a></li>
			  <li><a href="javascript:;">我的消息</a></li>
		   </ul>
		 </div>
		 
		 <div class="col-md-11">
		   <div class="container">
		     <!--订单分类-->
		     <div class="col-md-11">
			   <ul class="nav nav-tabs">
				  <li ${orderStatu ==null ? 'class="active"' : null}><a href="${pageContext.request.contextPath}/shop/order/center">所有订单</a></li>
				  <li ${orderStatu ==1 ? 'class="active"' : null}><a href="${pageContext.request.contextPath}/shop/order/center?orderStatu=1">待付款</a></li>
				  <li ${orderStatu ==2 ? 'class="active"' : null}><a href="${pageContext.request.contextPath}/shop/order/center?orderStatu=2">待发货</a></li>
				  <li ${orderStatu ==3 ? 'class="active"' : null}><a href="${pageContext.request.contextPath}/shop/order/center?orderStatu=3">待收货</a></li>
				  <li ${orderStatu ==4 ? 'class="active"' : null}><a href="${pageContext.request.contextPath}/shop/order/center?orderStatu=4">待评价</a></li>
				  <li ${orderStatu ==5 ? 'class="active"' : null}><a href="${pageContext.request.contextPath}/shop/order/center?orderStatu=5">已完成</a></li>
			   </ul>
			 </div>
			 <!--订单筛选-->
			 <div class="col-md-4 col-md-offset-3">
			   <div class="input-group text-margintop-25">				  
				  <input type="text" class="form-control" placeholder="根据商品名查询订单">
				  <span class="input-group-btn">
					<button class="btn btn-default" type="button"><i class="glyphicon glyphicon-search"></i></button>
				  </span>
			   </div>
			 </div>
			 
			 <!--订单头部信息-->
               <div class="col-md-11">		 
				   <div class=" alert alert-info order-head text-center">
					 <span class="col-md-4">商品</span>
					 <span class="col-md-1">单价</span>
					 <span class="col-md-1">数量</span>
					  <span class="col-md-2">商品操作</span>
					 <span class="col-md-1">实付款</span>					 					
					 <span class="col-md-1">状态</span>
					 <span class="col-md-2">订单操作</span>
				   </div>
			   </div>	
			 <!--订单内容-->
			 <c:forEach items="${pageInfo.list}" var="order" varStatus="statu">  
			   <div class="col-md-11 each-order ">			    
			     <div class="panel panel-default order-text order-body-content">
				   <div class="panel-heading">
					 <span class="">下单时间：</span><span class=""><fmt:formatDate type="both" value="${order.createDate}"/></span>
					 <span class="mg-left-15">订单号：</span><span class="">${order.orderNo}</span>
					 <a href="javascript:;" class="mg-left-15 label label-info">与我联系</a>
				   </div>
				   <div class="panel-body ">
					 <div class="col-md-8">
					  <c:forEach items="${order.orderItems}" var="orderItem" varStatus="statu" >
					   <div class="row order-product-message">						 
						 <div  class="col-md-6">
						   <a href="${pageContext.request.contextPath}/shop/good/view/${orderItem.skuId}" class="col-md-6">
						     <img src="${pros.fictitiousRoot}${orderItem.skuPicture}" class="order-smallImage "/>
						   </a>
						   <a href="${pageContext.request.contextPath}/shop/good/view/${orderItem.skuId}" class="col-md-6 order-skuName">${orderItem.skuName}</a>
						 </div>
						 <div class="col-md-2 "><i>￥</i><span> <fmt:formatNumber type="number" pattern="0.00" maxFractionDigits="2"  value="${orderItem.skuSalePrice}"></fmt:formatNumber></span></div>
					     <div class="col-md-1">${orderItem.skuNum}</div>
					     <div class="col-md-3 order-text-style">
					       <c:choose>
					         <c:when test="${order.orderStatu eq 1}">
					           <div><a href="javascript:;">违规举报</a></div>
					         </c:when>
					         <c:when test="${order.orderStatu >= 2}">
					           <div><a href="javascript:;"href="javascript:;">退款/退货</a></div>
					           <div><a href="javascript:;">投诉商家</a></div>
					         </c:when>					         
					       </c:choose>
					     </div>
					   </div>
					  </c:forEach>   	  		
					 </div>
					 <div class="row col-md-4 order-text-style">
					   <div class="col-md-3"><i>￥</i><span ><fmt:formatNumber type="number" pattern="0.00" maxFractionDigits="2"  value="${order.orderAmountTotal}"></fmt:formatNumber></span></div>					 
					   <div class="col-md-4">
					     <c:choose>
					         <c:when test="${order.orderStatu eq 1}">
					           <div><span class="text-warning">未付款</span></div>
					         </c:when>
					         <c:when test="${order.orderStatu eq 2}">
					           <div><span class="text-success">已付款(等待发货)</span></div>
					           <div><a href="javascript:;">查看物流</a></div>
					           <div><a href="javascript:;">提醒发货</a></div>
					         </c:when>
					         <c:when test="${order.orderStatu eq 3}">
					           <div><span>已发货</span></div>
					           <div><a href="javascript:;">查看物流</a></div>
					         </c:when>
					         <c:when test="${order.orderStatu eq 4}">
					           <div><span>已签收</span></div>					     
					         </c:when>
					         <c:when test="${order.orderStatu eq 5}">
					           <div><span>已评论</span></div>					     
					         </c:when>
					         <c:when test="${order.orderStatu eq 6}">
					           <div><span>退货申请中</span></div>
					           <div><a href="javascript:;">查看进度</a></div>					     
					         </c:when>
					         <c:when test="${order.orderStatu eq 7}">
					           <div><span>退货中</span></div>					     
					         </c:when>	
					         <c:when test="${order.orderStatu eq 8}">
					           <div><span>已退货</span></div>						     
					         </c:when>
					         <c:when test="${order.orderStatu eq 9}">
					           <div><span>取消交易</span></div>				     
					         </c:when>						       		         
					       </c:choose>
					   </div>
					   <div class="col-md-5">
					     <c:choose>
					         <c:when test="${order.orderStatu eq 1}">
					           <div><a class="btn btn-danger btn-xs order-pay" href="${pageContext.request.contextPath}/shop/order/payPage?orderId=${order.id}">现在付款</a></div>
					           <div><a class="" href="javascript:;" onclick="cancelOrder('${pageContext.request.contextPath}/shop/order/cancel/${order.id}',this)">取消订单</a></div>
					         </c:when>
					         <c:when test="${order.orderStatu eq 2}">
					           <div><a class="btn btn-info btn-xs order-pay" href="javascript:;">提醒发货</a></div>
					           <div><a class="" href="javascript:;" onclick="cancelOrder('${pageContext.request.contextPath}/shop/order/cancel/${order.id}',this)">取消订单</a></div>
					         </c:when>
					         <c:when test="${order.orderStatu eq 3}">
					           <div><a class="btn btn-info btn-xs order-pay" href="javascript:;">我要投诉</a></div>
					           <div><a class="" href="javascript:;" onclick="backOrder('${pageContext.request.contextPath}/shop/order/back/${order.id}',this)">申请退货/退款</a></div>
					         </c:when>
					         <c:when test="${order.orderStatu eq 4}">
					           <div><a class="btn btn-info btn-xs order-pay" href="javascript:;">商品评论</a></div>
					           <div><a class="" href="javascript:;">申请退货/退款</a></div>				     
					         </c:when>
					         <c:when test="${order.orderStatu eq 5}">
					           <div><a class="btn btn-info btn-xs order-pay" href="javascript:;">追加评论</a></div>
					           <div><a class="" href="javascript:;">申请发票</a></div>				     
					         </c:when>
					         <c:when test="${order.orderStatu eq 6}">
					           <div><a href="javascript:;">查看进度</a></div>					     
					         </c:when>
					         <c:when test="${order.orderStatu eq 7}">
					           <div><a href="javascript:;">查看进度</a></div>					     
					         </c:when>	
					         <c:when test="${order.orderStatu eq 8}">					           						     
					         </c:when>
					         <c:when test="${order.orderStatu eq 9}">	
					           <div><a class="btn btn-danger btn-xs order-pay" href="javascript:;" onclick="deleteOrder('${pageContext.request.contextPath}/shop/order/delete/${order.id}',this)">删除订单</a></div>					     
					         </c:when>						       		         
					       </c:choose>
					   </div>
					 </div>
				   </div>
				 </div> 				 
			   </div>
			   </c:forEach> 	   	
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
		   
		   	
		 </div> 
	   </div>
		
	   
			
      <!-- 结束导航栏 -->
     <%@ include file="/WEB-INF/all/include/shop-end.jsp"%>
     
  
   </body>
</html>