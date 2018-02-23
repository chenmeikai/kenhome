<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<!DOCTYPE html>
<html>
   <head>
      <title>会员中心
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- 引入 Bootstrap -->
      <link href="/kenhome/resources/css/bootstrap.min.css" rel="stylesheet">
	  
	   <!--时间控件-->
	   <link href="/kenhome/resources/css/bootstrap-datetimepicker.css" rel="stylesheet">
	  
	  <link href="/kenhome/resources/css/admin/manage.css" rel="stylesheet">
	  
	  
	   <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="/kenhome/resources/js/jquery-3.0.0.min.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="/kenhome/resources/js/bootstrap.min.js"></script>
	  
	  <script src="/kenhome/resources/js/bootbox.min.js"></script>
	  
	  <!--时间控件-->
	  <script src="/kenhome/resources/js/bootstrap-datetimepicker.js"></script>
	  
	  <script src="/kenhome/resources/js/admin/user.js"></script>
	  
   </head>
   <body>
     <div class="container-fluid">
	   <div class="row schoolmanage-head">
	     <div class="col-md-2">
		   <span class="schoolmanage-name">会员中心</span>
		   <span>(</span>
		   <span>${pageInfo.getTotal()}</span>
		   <span>位会员</span>
		   <span>)</span>
		 </div>
		 <div class="col-md-2 pull-right text-right">
		   <a href="" class="btn btn-xs btn-info btn-outline-info ">
		    <i class="glyphicon glyphicon-plus"></i>
			<span>新增</span>
		   </a>
		   <a href="" class="btn btn-xs btn-warning btn-outline-warning ">
		    <i class="glyphicon glyphicon-export"></i>
			<span>导出excel</span>
		   </a>
		 </div>			 
	   </div>
	   
	   <!--搜索栏-->
	   <div class="row schoolmanage-search">          
	     <div class="col-md-2">
		   <div class="input-group">		 
			  <span class="input-group-addon" >名称</span>
			  <input type="text" class="form-control" placeholder="" name="">
		   </div>
		 </div>
		 <div class="col-md-2">
		   <div class="input-group">		 
			  <span class="input-group-addon" >联系人</span>
			  <input type="text" class="form-control" placeholder="" name="">
		   </div>
		 </div>
		 <div class="col-md-3">
		   <div class="input-group">		 
			  <span class="input-group-addon" >注册期</span>
			  <input type="text" class="form-control" placeholder="" name="" id="registerDate">
			  <span class="input-group-addon" >到</span>
			  <input type="text" class="form-control" placeholder="" name="" id="registerDate2">
		   </div>
		 </div>
		 <div class="col-md-2">
		   <div class="input-group">		 
			  <span class="input-group-addon" >用户类型</span>
			  <select  class="form-control">
			     <option    value = "全部" >全部</option>
			     <option    value = "注册用户" >注册用户</option>
		         <option    value = "微信用户" >微信用户</option>
				 <option    value = "qq用户" >qq用户</option>
			  </select>
		   </div>
		 </div>
		 <div class="col-md-1">
		   <div class="input-group">		 
			  <span class="input-group-addon" >状态</span>
			  <select  class="form-control">
			     <option    value = "全部" >全部</option>
			     <option    value = "正常" >正常</option>
		         <option    value = "冻结" >冻结</option>
			  </select>
		   </div>
		 </div>
		 		 	 
	      
		
		 <div class="col-md-1 form-search">
           	<div class="input-group">	 
			  <input id="form-search" type="button" class="form-control" value="搜索">
			  <input id="search-reset" type="button" class="form-control" value="重置">
			</div>  
		 </div>		 
	   </div>
	   
	   <!--分割线-->
	   <div class="row cut-line">
	     
	   </div>
	   
	   <!--列表-->
	   <div class="row margin-top-15px">
	     <table class="table table-bordered table-hover table-striped">
		  <thead class="imformation-thead">
			<tr>
			  <th>头像</th>
			  <th>昵称</th>
			  <th>手机</th>
			  <th>性别</th>
			  <th>用户类型</th>
			  <th>状态</th>
			  <th>积分</th>	
			  <th>创建日期</th>	
			  <th>更新日期</th>	
			  <th>操作</th>	              			  
			</tr>
		  </thead>
		  <tbody >
		   <c:forEach var="pageUser"   items="${ pageInfo.getList()}" varStatus="statu" >
		     
		     <tr class="tr">
			  <td>
			    <img src="${pageUser.getAvatar() }" class="img-rounded img-responsive member-head">
			  </td>
			  <td>${pageUser.getUser_name()}</td>
			  <td>${pageUser.getCreate_date()}</td>
			  <td>男</td>
			  <td>微信用户</td>
			  <td>正常</td>
			  <td>250</td>
			  <td>2017-06-12</td>
			  <td>2017-06-18</td>
			  <td>
			   <a href="#" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-book"></i>&nbsp;<span>查看</span></a>
			   <a href="#" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>编辑</span></a>			   
			  </td>
			</tr>		   
		   </c:forEach>
						
		  </tbody>
		</table>
	   </div>
	</div>   
		
	<!--页码-->
	  <%@ include file="/WEB-INF/all/include/pageHelper.jsp"%> 
		 
   </body>
</html>