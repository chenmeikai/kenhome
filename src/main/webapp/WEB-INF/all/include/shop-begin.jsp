<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 头部栏 -->
     <nav  class="container-fluid">
       <div class="row">
         <!-- 广告横幅 -->
         <div class="col-md-12 shop-header-ad">
         
         </div>
         
         <!-- 头部栏 -->
         
         <div class="col-md-12 shop-header">
           <!-- 导航条 -->
           <div class="container">
             <div class="row shop-header-memo" >
               <div class="col-md-4">
                 <a href="${pageContext.request.contextPath}/shop/index" class="shop-welcome">欢迎来到凯之家商城</a>
                 <c:choose>
                   <c:when test="${user == null}">
                      <span class="mg-left-15 login-before"><a class="btn btn-default btn-xs mg-bottom-5" id="shop-login" href="${pageContext.request.contextPath}/shop/user/login">请登录</a></span>
                      <span class="mg-left-15 login-before"><a class="btn btn-default btn-xs mg-bottom-5" id="shop-register" href="javascript:window.open('${pageContext.request.contextPath}/shop/user/register');">免费注册</a></span>
                   </c:when>
                   <c:when test="${user != null}">
                      <span class="mg-left-15 login-after"><a class=" mg-bottom-5" id="shop-login" href="javascript:window.location.href='${pageContext.request.contextPath}/shop/user/center';">${user.userName}</a></span>
                      <span class="mg-left-15 login-after"><a class=" mg-bottom-5" id="shop-register" href="javascript:window.location.href='${pageContext.request.contextPath}/shop/user/notice';">消息<span class="text-danger">0</span></a></span>
                      <span class="mg-left-15 login-after"><a class="btn btn-default btn-xs mg-bottom-5" id="shop-logout" href="javascript:window.location.href='${pageContext.request.contextPath}/shop/user/logout';">退出</a></span>
                   </c:when>                 
                 </c:choose>
                 
               </div>
               <div class="col-md-6 col-md-offset-2">
                 <span class="mg-left-30"><a href="${pageContext.request.contextPath}/shop/order/center"><i class="fa fa-camera-retro i-style1"></i><span>我的订单</span></a></span>
                 <span class="mg-left-30"><a href="${pageContext.request.contextPath}/shop/cart/center"><i class="fa fa-shopping-cart i-style1"></i><span>购物车</span><em class="em-num">${cartSkusKinds}</em><span class="mg-left-5">件</span></a></span>
                 <span class="mg-left-30"><a href="${pageContext.request.contextPath}/shop/favourite/center"><i class="fa fa-heart i-style1"></i><span>我的收藏</span></a></span>
                 <span class="mg-left-30"><a href="${pageContext.request.contextPath}/shop/help/center"><i class="fa fa-handshake-o i-style1"></i><span>客户服务</span></a></span>
               </div>
             </div>
           </div>                
         </div>
       </div>
     </nav>