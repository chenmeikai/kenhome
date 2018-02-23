<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>凯之家注册(测试)
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      
      <!-- font样式 -->
      <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
      
      <!-- 验证样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/validate2/bootstrapValidator.min.css" rel="stylesheet">
     	  
	  <link href="${pageContext.request.contextPath}/resources/css/shop/common.css" rel="stylesheet">
	  <link href="${pageContext.request.contextPath}/resources/css/shop//register.css" rel="stylesheet">
	  	  
	  <style type="text/css">
	    
	  </style>
	 	  	
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  
	  <!-- 表单验证控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/validate2/bootstrapValidator.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/validate2/validate-zh_CN.js"></script>
	  
       
	  <script type="text/javascript">
		  $().ready(function(){
			    //验证注册表单	   
			     var nameValidateUrl = $("#userName").attr("data-validate");
			     var phoneValidateUrl =$("#phone").attr("data-validate");
	             var imgValidateUrl = $("#validateCode").attr("data-validate");
	             var phoneCodeValidateUrl = $("#phoneCode").attr("data-validate");
	             $("#user-register").bootstrapValidator({
                  message: 'This value is not valid',
                  excluded : [':disabled'],//[':disabled', ':hidden', ':not(:visible)']//验证不包含无效的
                  feedbackIcons: {
                      valid: 'glyphicon glyphicon-ok',
                      invalid: 'glyphicon glyphicon-remove',
                      validating: 'glyphicon glyphicon-refresh',
                  },
			           fields: {
			        	   userName: {
			                    validators: {
			                        notEmpty: {         //非空验证
			                            message: '请输入用户名'
			                        },
			                        stringLength: {     //输入长度限制校验
			                            min: 2,
			                            max: 15,
			                            message: '用户名须在2到15个字符之间'
			                        },
			                        remote: {
			                            type: 'GET',
			                            url: nameValidateUrl,
			                            dataType:'json',
			                            message: '该用户名已经存在',
			                            delay: 500
			                        }
			                    }				      
			                },
			                phone:{
			                	validators:{
			                		notEmpty: {         //非空验证
			                            message: '请输入手机号'
			                        },
			                        regexp: {           //正则校验，手机号
			                            regexp: /^1[0-9]{10}$/,
			                            message: '请输入正确的手机号码'
			                        },
			                        remote: {
			                            type: 'GET',
			                            url: phoneValidateUrl,
			                            dataType:'json',
			                            message: '该手机号已被注册',
			                            delay: 500
			                        }
			                	}
			                },
			                password:{
			                	validators:{
			                		notEmpty: {         //非空验证
			                            message: '请输入密码'
			                        },
			                        regexp: {        //正则校验，密码
			                            regexp:/^[A-Za-z0-9]{6,16}$/, 
			                            message: '密码须由6-21字母和数字组成'
			                        },
			                        different: {         //非同验证
			                            field: 'userName',
			                            message: '密码不可与用户名相同'
			                        }
			                	}
			                },
			                password2:{
			                	validators:{
			                		identical: {         //相同验证
			                            field: 'password',
			                            message: '两次输入的密码不相同'
			                        },
			                        		                        
			                	}
			                },
			                validateCode: {
			                    validators: {
			                        notEmpty: {         //非空验证
			                            message: '请输入验证码'
			                        },                     
			                        remote: {
			                            type: 'GET',
			                            url: imgValidateUrl,
			                            dataType:'json',
			                            message: '验证码输入错误',
			                            delay: 500
			                        }
			                    }				      
			                },
			                phoneCode: {
			                    validators: {
			                        notEmpty: {         //非空验证
			                            message: '请输入手机验证码'
			                        },                     
			                        remote: {
			                            type: 'GET',
			                            url: phoneCodeValidateUrl,
			                            dataType:'json',
			                            message: '手机验证码输入错误',
			                            delay: 500
			                        }
			                    }				      
			                },
			                protocol: {
			                    validators: {
			                        notEmpty: {         //非空验证
			                            message: '须认可协议方可注册'
			                        }
			                    }				      
			                },
			            }
	              });  
	             
	             
	             //获取手机验证码
	              var countdown =60;
	             $("#getPhoneCode").on("click",function(){            	     
	              //先验证图片
               	  var validateCode =$("#validateCode").val();
               	  var targetUrl =imgValidateUrl+"?validateCode="+validateCode
               	  $.get(targetUrl,function(flag){
               		  if(flag.valid ==true){
               			 $("#warn-small").remove();
               			 $(".validateImg-input").removeClass("warn-border");   
               			 
               			 //验证手机号
               		     var phone=$("#phone").val();
               			 var regexp =/^1[0-9]{10}$/ ;
               			 if (!regexp.test(phone)){
               				$("#phone").addClass("warn-border");
               				return false;
               			 }
	 	            	 var targetPhoneUrl =$("#getPhoneCode").attr("data-getPhoneCode")+"?phone="+phone
	 	            	 $.get(targetPhoneUrl, function(result){	 	            		
	 	            		var obj =$("#getPhoneCode"); 
	 	            		reCode(obj) ;
	 	            	});	 	            	 
	 	            	 function reCode(obj){	            	 
	 		            	if (countdown == 0) {
	 		                     obj.removeClass("disabled");
	 		                     obj.find('a').text("获取验证码");
	 		                     countdown = 60;
	 		                     return;
	 		                 } else {
	 		                     obj.addClass("disabled");
	 		                     obj.find('a').text("(" + countdown + ") s 重新发送");
	 		                     countdown--;
	 		                 }
	 		            	 setTimeout(function() {
	 		            		 reCode(obj) }
	 		                 ,1000)
	 		             }              			  
               		  }else{
               			  var tag ='<small id="warn-small" class="phoneCode-small">请输入正确的验证码</small>'
               			  $("#warn-small").remove();
               			  $(".validate-img-code").after(tag); 
               			  $(".validateImg-input").addClass("warn-border");
               		  }
               	  })
	            	 	                	  	                        	 	 	            	 	            	 
	             })
	             
	             
	             
	             //注册
	             $("#register-submit").on("click",function(){

	            	  //表单验证
	            	  var bootstrapValidator = $("#user-register").data('bootstrapValidator');
	            	  bootstrapValidator.validate();                          
	                  if(bootstrapValidator.isValid()){	                	  
	                	  
	                	  $("#register-submit").addClass("disabled").text("提交中");
	                	  var registerUrl =$("#user-register").attr("action");
	                	  $.ajax({
	                		  type:'post',
	                		  url :registerUrl,
	                		  data:$("#user-register").serialize(),
	                		  dataType:'json',
	                		  success:function(result){
	                			  if(result.flag ==true){
	                				  $("#register-submit").removeClass("disabled").text("注册");  
	                				  bootbox.confirm({
	                	                    title : "请选择",
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
	                	                    message:'恭喜您注册成功，是否现在前往个人中心完善个人资料？',
	                	                    callback:function(flag){
	                	                    	if(flag){        			
	                	                    		window.location.href=result.center;             	                			
	                	                		}else{
	                	                			window.location.href=result.index;
	                	                		}
	                	                    },
	                	                   className:"bootbox-sm"
	                	             });	
		                			  
	                			  }else
	                			  bootbox.alert("注册失败");
	                			  $("#register-submit").removeClass("disabled").text("再次注册");
	                		  },
	                		  error:function(){
	                			  bootbox.alert("请求失败");
	                			  $("#register-submit").removeClass("disabled").text("注册");
	                		  }
	                	  }) 
	                	  
	                  }
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
			  &nbsp;&nbsp;
			  13570282684
		  </div>
		</div>
	  </header>
	  
    <div class="container">
	    <div class="row">
		  <div class="col-md-12 register-title">
		    <label>凯之家欢迎您</label>
		  </div>
		</div>	      
	</div>
    <div class="container">
	  <div class="row">
	    <div class="panel panel-default register col-md-6 col-md-offset-3">
	      <div class="panel-heading"><span>注册</span></div>
	       <form id="user-register" action="${pageContext.request.contextPath}/shop/user/register" method="Post">		
            <div class="panel-body register-body">
              <div class="form-group  input-text">
			      <input id="userName" type="text" name="userName" class="form-control" aria-label="user_name" placeholder="请输入名字..." data-validate="${pageContext.request.contextPath}/shop/user/validateName">
		      </div>
		      <div class="form-group input-text">			     
			      <input type="text" id="phone" name="phone" data-validate="${pageContext.request.contextPath}/shop/user/validatePhone" class="form-control" aria-label="mobile" placeholder="请输入手机号...">
		      </div>
		      <div class="form-group input-text">
		  	      <input type="password" id="password" name="password" class="form-control" aria-label="password" placeholder="请输入密码...">
		      </div>
		  	  
		      <div class="form-group input-text">
			      <input type="password" id="password2" name="password2" class="form-control" aria-label="password" placeholder="请再输入密码...">
		      </div>
		      
		      <div class="form-group input-text validate-img-code ">
			      <img class="validateImg" alt="" src="${pageContext.request.contextPath}/shop/user/getCodeImg" onclick="javascript:this.src='${pageContext.request.contextPath}/shop/user/getCodeImg?tm='+Math.random();"/>
		          <input class="validateImg-input" type="text" name="validateCode" id="validateCode" data-validate="${pageContext.request.contextPath}/shop/user/validateImg" aria-label="password" placeholder="请输入验证码...">
		      </div>
		        
		      <div class=" form-group input-text phone-validate form-inline">
			      <input type="text" name="phoneCode" id="phoneCode"  data-validate="${pageContext.request.contextPath}/shop/user/validatePhoneCode" class="form-control" aria-label="password" placeholder="请输入手机验证码...">
			      <span id="getPhoneCode"   data-getPhoneCode="${pageContext.request.contextPath}/shop/user/getPhoneCode" class="input-group-addon btn"><a href="#">点击获取</a></span>
		      </div>
		  
		      <div class="form-group  text-margintop">
		        <input type="checkbox" class=""  name="protocol" />
		        <a href="javascript:;" class="">注册即接受凯之家的协议</a>
		      </div>
		  
		      <button id="register-submit" type="button" class="btn btn-info input-button">注册</button>
		  
		      <div class="alert text-info other-register">
		        <span>其他注册方式:</span>
		        <a href="javascript:;"><i class="fa fa-weixin icon-weixin" ></i></a> 
		        <a class="" href="javascript:;"><i class="fa fa-qq icon-qq" ></i></a>
		        <a href="javascript:;"><i class="fa fa-weibo icon-weibo" ></i></a>
		      </div>
            </div>
		   </form>			
	      </div>
        </div>	      
     </div>  
  
  
   </body>
</html>