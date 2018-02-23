<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>凯之家支付(测试)
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      
      <!-- font样式 -->
      <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
         	  
	  <link href="${pageContext.request.contextPath}/resources/css/shop/common.css" rel="stylesheet">
	  <link href="${pageContext.request.contextPath}/resources/css/shop//.css" rel="stylesheet">
	  	  
	  <style type="text/css">
	   body{background-color:#f1f4f5;}
	   header{
	    margin-top:10px;
	   text-align:right;
       }
       .shop-index-logo{width:50%;height:auto;}
       .login-header{
           margin-top:20px;
	       height:50px;
       }
       .login-main{min-height:600px;}
       .text-style-1{margin-bottom:30px;margin-top:30px;}
       .text-style-1 >span{font-size: 16px;font-weight:bolder;color:#635f5f;}
       .text-style-2 {margin-bottom:15px}
       .text-style-2 >span{font-size: 14px;font-weight:bold;color:#635f5f;}
       .pay-head-line{border-bottom:1px solid #cec0c0;padding-bottom:10px;margin-top:20px;}
       .pay-head-line>span{font-size: 14px;font-weight:bolder;color:#994646;}
       .text-style-3 {margin-top:20px}
       .text-style-3>span{font-size: 14px;color:#534f4f;}
       .pay-price{font-size:20px;font-weight:bolder;color:#ff5d5b;}
       .pay-style{padding:0px;}
       #pay-form{margin-top:40px;}
       #submit-pay{margin-top:20px;}

	  </style>
	 	  	
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	        
	  <script type="text/javascript">
		  $().ready(function(){
			  $("#submit-pay").on("click",function(){
				  var targetUrl =$("#pay-form").attr("action");
				  $("#submit-pay").addClass("disabled").val("提交中");
				  $.ajax({
					  type:'post',
					  url :targetUrl,
					  data:$("#pay-form").serialize(),
				      dataType:'json',
				      success:function(result){
				    	  if(result.valid =="noUser"){
				    		  window.location.href=result.target;
				    		  $("#submit-pay").removeClass("disabled").val("重新支付");
				    		  return;
				    	  } else if(result.valid =="true"){
				    		  bootbox.alert("支付成功",function(){
				    			  setTimeout(function(){window.location.href=result.redirect},500)
				    		  })
				    		 return;
				    	  }else if(result.valid =="password"){
				    		  bootbox.alert("密令错误");
				    	      $("#submit-pay").removeClass("disabled").val("重新支付");	
				    	      return;
				    	  }else 
				    		  $("#submit-pay").removeClass("disabled").val("重新支付");
				    		  bootbox.alert("支付失败");
				    		  
				      },
				      error:function(){
				    	  bootbox.alert("请求失败，请稍后重试");
				    	  $("#submit-pay").removeClass("disabled").val("重新支付");
				      }
				  })
			  })
		  
		  });
	 </script>	 	  
   </head>
   <body>
     <!--固定提示-->
     <div class="shop-warning">个人测试网站 不可购物</div>
     
     <header>
	    <div  class="container">
		  <div class="col-md-6 pull-right">
		   <i class="glyphicon glyphicon-envelope"></i> <strong>Email:</strong>
			  562899487@qq.com
			 &nbsp;&nbsp;<i class="glyphicon glyphicon-phone"></i><strong>Call-Number :</strong>
			  13570282684
		  </div>
		</div>
	 </header>
	 
	 <!-- logo -->
	 <div class="container login-header">
	     <div class="row">
		   <div class="col-md-3">
		     <a href="${pageContext.request.contextPath}/shop/index"><img class="shop-index-logo" src="${pageContext.request.contextPath}/resources/image/logo/kenhome.png" class="img-responsive" alt="logo"></a> 
		   </div>
		 </div> 
	 </div> 
	 <div class="login-main">
	  <div class="login-body">
	    <div class="container">
		  <div class="row">
			<div class="col-md-12 text-style-1">
			  <span class="">订单已经提交成功，请您尽快下单！</span>
			</div>
			<div class="col-md-12 text-style-2">
			  <span class="">请您在提交订单后24小时内完成支付，否则订单会自动取消</span>
			</div>			
		  </div>
		  <!-- 支付信息 -->
		  <div class="row pay-head-line">
		    <span>支付信息</span>
		  </div>
		  <div class="row">
		    <div class="col-md-12 text-style-3">
		      <span>收款方</span>
		      <span>：凯之家</span>
		    </div>
		    <div class="col-md-12 text-style-3">
		      <span>商户订单号： </span>
		      <span>${payOrder.orderNo}</span>
		    </div>
		    <div class="col-md-12 text-style-3">
		      <span>创建时间： </span>
		      <span>
		        <fmt:formatDate type="both" value="${payOrder.createDate}"/>
		      </span>
		    </div>
            <div class="col-md-12 text-style-3">
		      <span>交易金额： </span>
		      <span><i>￥</i><span class="pay-price">${payOrder.orderAmountTotal}</span></span>
		    </div>		    
		  </div>
		  <div class="row pay-head-line"></div>
		  <div class="row">
		    <form id="pay-form" action="${pageContext.request.contextPath}/shop/order/pay" method="post">
		      <input readonly="readonly" hidden="" name="orderId" value="${payOrder.id}"  />
		      <div class="col-md-12 pay-style">
		        <div class="form-group col-md-3">
		          <label class="form-label">支付密令</label>
		          <input class="form-control" type="password" name="password" placeholder="请输入支付密令"/>
		        </div>
		      </div>
		      <div class="col-md-12 pay-style">
		        <div class="form-group col-md-2">		          
		          <input id="submit-pay" class="form-control btn btn-danger" type="button" value="确认支付"/>
		        </div>
		      </div>
		    </form>
		  </div>
		</div>
	  </div>
	 </div>
	  <!-- 终止线 -->
      <div class="container-fluid">
        <div class="row endLine"></div>
        <div class="container main-footer">
		    <div class="row">
			  <div class="col-md-12">
			    <ul class="nav nav-tabs">
				  <li><a href="javascript:;">关于我</a></li>
				  <li><a href="javascript:;">个人动态</a></li>
				  <li><a href="javascript:;">联系我</a></li>
				  <li><a href="javascript:;">邀请我</a></li>
				  <li><a href="javascript:window.open('${pageContext.request.contextPath}/admin/common/main');">后台管理</a></li>
				</ul>
			  </div>
			  
			  <div class="col-md-12  end-memo">
			    <div>联系方式：562899487@qq.com</div>
				<div>COPYRIGHT  ©  2017 凯之家 ALL RIGHTSRERVED<a href="javascript:window.open('http://www.miitbeian.gov.cn/publish/query/indexFirst.action')">粤ICP备17122200号-1</a></div>
			  </div>
			</div>
	  </div>
      </div>
	 
    
   </body>
</html>