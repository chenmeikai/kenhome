<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<style>
.login-body{height:380px;}
.login-text{text-align:center;}
.input-text{margin-top:25px;}
.input-text>input{min-height:45px;}
.validate-img-code{margin-top:25px;}
.validateImg{width:26%;height:auto;margin-right:20px;}
.validateImg-input{min-height:42px;text-align:center;}
.validateImg-input{padding-bottom:5px;}
.input-button{width:30%;margin-top:20px;}
.other-register{height:20px;line-height:20px;}
.other-register>span{display:inline-block;font-size:12px;}	    
.other-register>a{display:inline-block;margin-left:30px;}
.icon-weixin{color:green;font-size:15px;} .icon-weixin:hover{color:#091b4f;font-size:18px;}
.icon-qq{font-size:15px;}.icon-qq:hover{color:#091b4f;font-size:18px;}
.icon-weibo{color:red;font-size:15px;} .icon-weibo:hover{color:#091b4f;font-size:18px;}
.login-find{margin-top:25px;} .login-find>a{font-size:10px;}
.warn-border{border:1px solid #a94442; }
.validate-img-code{text-align:center;margin-top:25px;}
.small-warn{position:absolute;color:#a94442;margin-top:-13px;font-size:8px;}
.small-wrong{position:absolute;color:#a94442;margin-top:-13px;font-size:8px;}
</style>

<script type="text/javascript">
$().ready(function(){
	  
	  
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
						  //如果user不为空，则表示登录情形为点击购物车时的拦截登录
						  if(flag.user != null){
							  var user =flag.user;
							  $(".login-before").remove();
							  var tag = '<span class="mg-left-15 login-after"><a class=" mg-bottom-5" id="shop-login" href="javascript:window.location.href=\''+
							             flag.rootUrl+
							            '/shop/user/center\';">'+
							            user.userName+
							            '</a></span>'+
		                                '<span class="mg-left-15 login-after"><a class=" mg-bottom-5" id="shop-register" href="javascript:window.location.href=\''+
		                                flag.rootUrl+
		                                '/shop/user/notice\';">消息<span class="text-danger">'+
		                                '0</span></a></span>'+		                             
		                                '<span class="mg-left-15 login-after"><a class="btn btn-default btn-xs mg-bottom-5" id="shop-logout" href="javascript:window.location.href=\''+
		                                flag.rootUrl+
		                                '/shop/user/logout\';">退出</a></span>';
		                      $(".shop-welcome").after(tag);
		                      $("#login-window").modal("hide");
		                      //重新添加到购物车
		                      addCart();		                   		                      
		                      return true ;
						  }
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
<!-- 登录弹窗 -->
<div class="modal fade " id="login-window" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
	    <div class="modal-dialog" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title text-center" id="editModalLabel">登录</h4>
	        </div>
	        <div class="modal-body login-body"> 	          	           
				  <div class="col-md-12 login-text">
				     <form id="user-login" action="${pageContext.request.contextPath}/shop/user/login" method="POST">
						  <div class="form-group input-text">							  
							  <input id="login-phone"  name="phone" type="text" class="form-control" aria-label="user_name" placeholder="手机号...">
						  </div>					  
						  <div class="form-group input-text login-password">
							  <input id="login-password" name="password" type="password" class="form-control" aria-label="password" placeholder="密码...">
						  </div>								  
						  <div class="form-group  validate-img-code ">
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
							<a href="#">免费注册</a>
						  </div>
						</form> 
					  </div>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        </div>
	      </div>
	    </div>
	  </div>