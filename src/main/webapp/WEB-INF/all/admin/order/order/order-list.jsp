<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>订单中心
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
     
	  <!--时间控件-->
	  <link href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.css" rel="stylesheet">
	  
	  <!-- 验证样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/validate2/bootstrapValidator.min.css" rel="stylesheet">
	  
	  <!-- select样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/select/bootstrap-select.min.css" rel="stylesheet">
	  
	  <link href="${pageContext.request.contextPath}/resources/css/admin/common.css" rel="stylesheet">
	  
	  <!-- 上传样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/fileinput/bootstrap-fileinput.min.css" rel="stylesheet">
	
	  <!-- 文本编辑样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/summernote/summernote.css" rel="stylesheet">
	  
	  <!-- 图片放大样式 -->
      <link href="${pageContext.request.contextPath}/resources/css/zoomify/zoomify.css" rel="stylesheet">
	  

	  <style type="text/css">
	    .{margin-right:15px;}
	  </style>
	 	  
	  <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  
	  <!--时间控件-->
	  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.js"></script>
	  <!--时间控件汉化-->
	  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.zh-CN.js"></script>
	  
	  <!-- 表单验证控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/validate2/bootstrapValidator.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/validate2/validate-zh_CN.js"></script>
	  
	  <!-- select -->
	   <script src="${pageContext.request.contextPath}/resources/js/select/bootstrap-select.min.js"></script>
	   <script src="${pageContext.request.contextPath}/resources/js/select/defaults-zh_CN.min.js"></script>
	   
	  <!-- dateFormat -->
	  <script src="${pageContext.request.contextPath}/resources/js/dateFormat/dateFormat.js"></script>
	  
	  <!-- 上传控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/fileinput/bootstrap-fileinput.min.js"></script>
	  <!-- extend 中文 -->
	  <script src="${pageContext.request.contextPath}/resources/js/fileinput/fileinput-zh.js"></script>
	  
	  <!-- 文本编辑控件 -->
	  <script src="${pageContext.request.contextPath}/resources/js/summernote/summernote.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/summernote/summernote-zh-CN.js"></script>
	  
	  <!-- 图片放大 -->
	  <script src="${pageContext.request.contextPath}/resources/js/zoomify/zoomify.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/admin/common.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/layer/layer.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			  	
			  var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
			  
			  var getListUrl =$("#listForm").attr("action");
			  
			  $("#getLoad").load(getListUrl, function() {
				 layer.close(index)
			  });
			  
			  
		  });
			 
		      	 
	  </script>
	  
   </head>
   <body>
     <div class="container-fluid">
	   <div class="row common-head">
	     <div class="col-md-2">
		   <span class="common-name">订单中心</span>
		 </div>
		 <div class="col-md-2 pull-right text-right">
		   <a id="excel-export" href="javascript:;" data-href="${pageContext.request.contextPath}/admin/spu/spu/export?" class="btn btn-xs btn-warning btn-outline-warning ">
		    <i class="glyphicon glyphicon-export"></i>
			<span>导出excel</span>
		   </a>
		 </div>			 
	   </div>
	   
	   <!--搜索栏-->
	   <form id="listForm" class="row common-search " action="${pageContext.request.contextPath}/admin/order/order/getList"  method = "GET">          
	      <div class="row form-group "> 
	       <div class="col-md-2">	   		 
			  <input type="text" class="form-control reset" placeholder="订单号" name="orderNo" value="${params.orderNo}">		   
		   </div>
		   <div class="col-md-2">	   		 
			  <input type="text" class="form-control reset" placeholder="物流号" name="outTradeNo" value="${params.outTradeNo}">		   
		   </div>
		    <div class="col-md-2">	   		 
			  <input type="text" class="form-control reset" placeholder="会员id" name="memberId" value="${params.memberId}">		   
		   </div>
		   <div class=" col-md-2">		 
			  <select  class="form-control selectpicker show-tick reset" name="orderStatu" data-live-search="true"  data-size="6" title="请选择订单状态" >
			     <option    value = "1" >待付款</option>
		         <option    value = "2" >待发货</option>
		         <option    value = "3" >已发货</option>
		         <option    value = "4" >已签收</option>
		         <option    value = "5" >已评论</option>
		         <option    value = "6" >退货申请</option>
		         <option    value = "7" >退货中</option>
		         <option    value = "8" >已退货</option>
		         <option    value = "9" >取消交易</option>		         
			  </select>
		   </div>
		   <div class=" col-md-2">		 
			  <select  class="form-control selectpicker show-tick reset" name="payType" data-live-search="true"  data-size="6" title="请选择支付类型" >
			     <option    value = "1" >微信支付</option>
		         <option    value = "2" >支付宝支付</option>
		         <option    value = "3" >网银支付</option>
			  </select>
		   </div>	
		    
		 </div>	
		 <div class="row form-group form-inline "> 
		    <div class="input-group  col-md-3" style="margin-left:15px;">		   		 
			    <input type="text" class="form-control datetimepicker reset" placeholder="起始时间" name="startCreateDate" value="${params.startCreateDate}" id="oneDate" >
			    <span class="input-group-addon" >到</span>
			    <input type="text" class="form-control datetimepicker reset" placeholder="结束时间" name="endCreateDate" value="${params.endCreateDate}" id="twoDate" >		   
		   </div>	
		 </div>	 
		 <div class="form-group form-inline col-md-2 ">	 
			  <input id="formSearch" type="button" class="form-control" value="搜索" >
			  <input id="searchReset" type="button" class="form-control" value="重置">		
		 </div>	   
		 <!-- 隐藏 -->
		 <input type="hidden" id="currentPage" name="currentPage" value="1" />		 	 
	   </form>
	   
	   <!--分割线-->
	   <div class="row cut-line">
	     
	   </div>
	   
	   <!--列表-->
	   <div class="row margin-top-15px">
	     <table class="table table-bordered table-hover table-striped">
		  <thead class="imformation-thead">
			<tr>
			  <th>订单号</th>
			  <th>会员id</th>
			  <th>金额</th>
			  <th>发票</th>
			  <th>收货地址</th>
			  <th>物流号</th>
			  <th>支付方式</th>
			  <th>订单状态</th>
			  <th>备注</th>				  
			  <th>创建日期</th>	
			  <th>更新日期</th>	
			  <th>操作</th>	              			  
			</tr>
		  </thead>
		  <tbody id="getLoad" >
		  		   		
		  </tbody>
		</table>
	   </div>
	   
	   <!--页码-->
	  <%@ include file="/WEB-INF/all/include/pageHelper.jsp"%> 
	</div>   
		
	
  
  </body>
</html>