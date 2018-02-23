<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
 <html>
   <head>
      <title>spu查看
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      
      <link href="${pageContext.request.contextPath}/resources/css/admin/common.css" rel="stylesheet">

	  <style type="text/css">
	    .{margin-right:15px;}
	    .entity-each-param{height:65px;}
	    .sure-button{background-color:rgb(42, 104, 142);color:white;}
	  </style>
	 	  
	  <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
	  	  
	  <script src="${pageContext.request.contextPath}/resources/js/admin/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			  			  
           })
                     
	  </script>
	  
   </head>
   <body>
     <!-- 查看spu -->
     <div class="row" id="spu-view-place" >
       <div style="margin-left:30px;margin-bottom:20px;" >
        <span class="label label-danger">Spu编号：${viewSpu.spuNo}</span>
       </div>
       <div class="col-md-12">
         <div>
	      <ul class="nav nav-tabs" role="tablist">
	        <li role="presentation" class="active"><a href="#oneView" aria-controls="oneView" role="tab" data-toggle="tab">基本信息</a></li>
	        <li role="presentation"><a href="#twoView" aria-controls="twoView" role="tab" data-toggle="tab">SPU属性</a></li>	        
	        <li role="presentation"><a href="#threeView" aria-controls="threeView" role="tab" data-toggle="tab">SPU介绍</a></li>
	        <li role="presentation"><a href="#fourView" aria-controls="fourView" role="tab" data-toggle="tab">SPU图片</a></li>	        	      
	      </ul> 
	     <div class="tab-content">
	       <div role="tabpanel" class="tab-pane active" id="oneView">
	          <div id="showEntityplace" class="">
			  <img src="${pros.fictitiousRoot}${viewSpu.spuImage}" class="img-rounded img-responsive entity-param-picture ">
			  <table class="table">
			    <tbody>
			      <tr class="entity-each-param">
			        <td class="param-name">SPU名称：</td>
			        <td class="param-value ">${viewSpu.spuName}</td>
			      </tr>
			      <tr class="entity-each-param">
			        <td class="param-name">SPU标题：</td>
			        <td class="param-value">${viewSpu.spuTitle}</td>
			      </tr>
			      <tr class="entity-each-param">
			        <td class="param-name">品牌名：</td>
			        <td class="param-value">${viewSpu.brandName}</td>
			      </tr>
			      <tr class="entity-each-param">
			        <td class="param-name">SPU状态：</td>
			        <td class="param-value">
			          <c:choose>
			            <c:when test="${viewSpu.spuStatu ==1}">下架</c:when>
			            <c:when test="${viewSpu.spuStatu ==2}">上架</c:when>
			            <c:when test="${viewSpu.spuStatu ==3}">无货</c:when>
			            <c:when test="${viewSpu.spuStatu ==4}">非卖品</c:when>
			            <c:when test="${viewSpu.spuStatu ==5}">赠品</c:when>
			          </c:choose>
			        </td>
			      </tr>	
			      <tr class="entity-each-param">
			        <td class="param-name">销量：</td>
			        <td class="param-value">${viewSpu.saleAmount}</td>
			      </tr>	
			      <tr class="entity-each-param">
			        <td class="param-name">库存：</td>
			        <td class="param-value">${viewSpu.stocks}</td>
			      </tr>	      
			      <tr class="entity-each-param">
			        <td class="param-name">创建时间：</td>
			        <td class="param-value"><fmt:formatDate type="both" value="${viewSpu.createDate}" dateStyle="default"/></td>
			      </tr>
			      <tr class="entity-each-param">
			        <td class="param-name">修改时间：</td>
			        <td class="param-value"><fmt:formatDate type="both" value="${viewSpu.updateDate}" dateStyle="default"/></td>
			      </tr>
			    </tbody>
			  </table>
			 </div>	
			</div>             
             <div role="tabpanel" class="tab-pane" id="twoView" style="margin-top:20px;">
               <!-- 遍历Spu属性 -->      
                <ul class="list-group">                                
                 <c:forEach items="${viewSpu.attributes}" var="attribute" varStatus="statu">
                  <li class="list-group-item" style="height:60px;">
                    <label for="" class="text-info" style="margin-right:10px;">${attribute.attributeName}:</label>                   		         
		              <c:forEach items="${attribute.options}" var="option" varStatus="statu">		               
				        <label class="label label-primary" style="margin-right:20px;">${option.optionName}</label>
		              </c:forEach>				         		                
		          </li>       
                </c:forEach>                 
               </ul>                           	          			        				      			     				                      	
		     </div>				    	     				                        
             <!-- Spu介绍文 -->
             <div role="tabpanel" class="tab-pane" id="threeView">
              <div style="margin-top:20px;"></div>
              <!-- SPU介绍 -->             
              <div >${viewSpu.spuContent}</div>			    	     				                
             </div>
             
                <!-- SPU图片 -->
	         <div role="tabpanel" class="tab-pane" id="fourView">
	           <div>
	             <c:forEach items="${spuPictures}" var="spuPicture" varStatus="statu">	            	             
	              <div id="replace-picture-${spuPicture.id}" class="col-md-10 col-md-offset-1" style="box-shadow: #666 0px 0px 10px; margin-top:20px;">
	               <img src="${pros.fictitiousRoot}${spuPicture.pictureUrl}" class="img-rounded img-responsive  image-zoomify">
	              </div>	                     	             
	             </c:forEach>
	           </div>	                	           
	         </div>	              
	       </div>			       
        </div>
      </div>	       	
   </div>
  </body>
</html>





   
 