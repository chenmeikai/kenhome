<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>凯之家登录(测试)
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
.login-body{
	background-color:#13326b;
}

.login-img{margin-top:0px;}
.index-toward>img{width:100%;height:auto;}
.login-password{margin-top:20px;}
.login-text{
	text-align:center;margin-top:20px;
}
.input-text{margin-top:25px;}
.validate-img-code{text-align:center;margin-top:25px;}
.validateImg-input{height:35px;border-radius:5px;border:1px solid #ccc;margin-left:15px;text-align:center;}

.small-warn{position:absolute;color:#a94442;margin-top:-13px;font-size:8px;}
.small-wrong{position:absolute;color:#a94442;margin-top:-13px;font-size:8px;}
.warn-border{border:1px solid #a94442; }

.login-input>.input-group{
	margin-top:30px;
}

.login-text button{
	width:200px;margin-top:30px;
}

.login-about{
	margin-top:50px;
}
.other-register{height:30px;line-height:30px;}
.other-register>span{display:inline-block;font-size:12px;}	    
.other-register>a{display:inline-block;margin-left:30px;}
.icon-weixin{color:green;font-size:15px;} .icon-weixin:hover{color:#091b4f;font-size:18px;}
.icon-qq{font-size:15px;}.icon-qq:hover{color:#091b4f;font-size:18px;}
.icon-weibo{color:red;font-size:15px;} .icon-weibo:hover{color:#091b4f;font-size:18px;}

.login-find{margin-top:25px;} .login-find>a{font-size:10px;}

.login-about a{margin-left:50px;text-align:center;color:black;
	
}

.login-end{
	margin-top:20px;text-align:center;
}

.login-end>h5{
	font-size:12px;
}
	  </style>
	 	  	
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	        
	  <script type="text/javascript">
		  $().ready(function(){
			  
			  //验证码输入框失去焦点时触发校验
		//	  $(document).on("blur","#validateCode",function(){
		//		  validateCode();
				  
		//	  })
			  
			  //点击登录按钮触发验证码校验和密码校验
			  $("#submit-login").on("click",function(){
				  
				 //验证码校验成功执行 
				 if(validateCode()){
					 $("#submit-login").addClass("disabled").text("登录中..."); 
					 var data =$("#user-login").serialize();
					 var targetUrl =$("#user-login").attr("action");
					 $.ajax({
						  type:'post',
						  url :targetUrl,
						  data:data,
						  dataType:'json',
						  success:function(flag){
							  if(flag.valid==true){
								  $("#login-phone").removeClass("warn-border");
								  $("#login-password").removeClass("warn-border");
								  $("#small-wrong").remove();
								  $("#submit-login").removeClass("disabled").text("登录");
								  window.location.href=flag.target;
								  return true;							  
							  }					      						 
							  var tag ='<small id="small-wrong" class="small-wrong"><i class="fa fa-close"></i>手机号或者密码错误</small>'
						      $("#login-phone").addClass("warn-border");
							  $("#login-password").addClass("warn-border");
							  $("#small-wrong").remove();
							  $(".submit-login").after(tag);
							  $("#submit-login").removeClass("disabled").text("重新登录");
							  return false ;
						  },
						  error:function(){
							  bootbox.alert("请求失败！")
						  }
					  });
				 }
				  
			  })
			  
			  
			  
			  //校验验证码
			  function  validateCode(){			
				  var result ;
				  var validateCode = $("#validateCode").val();
				  var validateCodeUrl =$("#validateCode").attr("data-validate");
				  $.ajax({
					  type:'get',
					  url :validateCodeUrl,
					  data:{'validateCode':validateCode},
					  dataType:'json',
					  async : false,
					  success:function(flag){
						  if(flag.valid==true){
							  $("#validateCode").removeClass("warn-border");
							  $("#small-warn").remove();
							  result =true;
							  return result ;
						  }	
						  
						  var tag ='<small id="small-warn" class="small-warn"><i class="fa fa-close"></i>请输入正确的验证码</small>'
					      $("#validateCode").addClass("warn-border");
						  $("#small-warn").remove();
						  $(".validate-img-code").after(tag);
						  result =false;
						  return result ;
					  },
					  error:function(){
						  bootbox.alert("请求失败！")
					  }
				  })
				  return result ;
			  }
			   
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
	    <div class="container" style="">
		  <div class="row">
			<div class="col-md-8 login-img">
			 <a class="index-toward">
			    <img src="${pageContext.request.contextPath}/resources/image/login/login2.jpg" alt="...">
			 </a>
			</div>
			<div class="col-md-4 login-text">
			  <div class="panel panel-default">
	             <div class="panel-heading"><span>凯之家</span>&nbsp;<span>登录</span></div>		
					<div class="panel-body login-input">
					 <form id="user-login" action="${pageContext.request.contextPath}/shop/user/login" method="POST">
					  <div class="input-group input-text">
						  <span class="input-group-addon">账&nbsp;&nbsp;&nbsp;号</span>
						  <input id="login-phone"  name="phone" type="text" class="form-control" aria-label="user_name" placeholder="手机号...">
					  </div>					  
					  <div class="input-group input-text login-password">
						  <span class="input-group-addon">密&nbsp;&nbsp;&nbsp;码</span>
						  <input id="login-password" name="password" type="password" class="form-control" aria-label="password" placeholder="密码...">
					  </div>								  
					  <div class="form-group input-text validate-img-code ">
			             <img class="validateImg" alt="" src="${pageContext.request.contextPath}/shop/user/getCodeImg" onclick="javascript:this.src='${pageContext.request.contextPath}/shop/user/getCodeImg?tm='+Math.random();"/>
		                 <input class="validateImg-input" type="text" name="validateCode" id="validateCode" data-validate="${pageContext.request.contextPath}/shop/user/validateImg" aria-label="password" placeholder="请输入验证码...">
		              </div>
		              <div class="form-group submit-login">
		                 <button type="button" id="submit-login" class="btn btn-info input-button">登录</button>	
		              </div>			  
					 				  
					  <div class="alert text-info other-register">
						<span>其他登录方式:</span>
						<a href="javascript:;"><i class="fa fa-weixin icon-weixin" ></i></a> 
		                <a class="" href="javascript:;"><i class="fa fa-qq icon-qq" ></i></a>
		                <a href="javascript:;"><i class="fa fa-weibo icon-weibo" ></i></a>
					  </div>
					  <div class="text-info text-right login-find">
					    <a href="#">忘记密码</a>
						<a href="${pageContext.request.contextPath}/shop/user/register">免费注册</a>
					  </div>
					 </form> 
					</div>
					
					<div class="panel-footer login-footer">
					  
					</div>
	          </div>
			</div>
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