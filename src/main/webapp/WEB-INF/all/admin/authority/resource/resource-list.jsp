<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>资源中心
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
       <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- tree样式 --> 
      <link href="${pageContext.request.contextPath}/resources/css/tree/tree.css" rel="stylesheet">
	 	 
	  <style type="text/css">
	    .resource-title{margin:-15px;}
	    .tree {
	        background-color:#f2f6ff;
        }
        
	  </style>
	 	  
	  <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  

       
	  <script type="text/javascript">
		  $().ready(function(){
			  
			  //树状显示
			  $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');

			    $('.tree li.parent_li > .tree-icon').on('click', function (e) {

			        var children = $(this).parent('li.parent_li').find(' > ul > li');

			        if (children.is(":visible")) {

			            children.hide('fast');

			            $(this).attr('title', 'Expand this branch').find(' > i').addClass('glyphicon-plus-sign').removeClass('glyphicon-minus-sign');

			        } else {

			            children.show('fast');

			            $(this).attr('title', 'Collapse this branch').find(' > i').addClass('glyphicon-minus-sign').removeClass('glyphicon-plus-sign');

			        }

			        e.stopPropagation();

			    });
			   
			      
		  });
	  </script>
	  
   </head>
   <body>
    <div class="tree">
       <ul>
	      <li>
		     <span class="tree-icon">
		       <i class="glyphicon glyphicon-minus-sign"></i>
		       <span class="tree-resource">
		         <i class="glyphicon glyphicon-tree-deciduous"></i>
		         <a href="javascript:;">资源树</a>  
		       </span>
		     </span>
		      <ul>
		     <!-- 开始迭代 -->
		     <c:forEach  var="acl" items="${acls}" varStatus="statu">
   
		       
	             <li>
		           <span class="tree-icon">
		           <i class="glyphicon glyphicon-minus-sign"></i>
		           <span class="tree-resource">
		             <i class="${acl.icon}"></i>
		             <a href="javascript:;">${acl.aclName}</a>  
		           </span>
		           </span>
		           <c:if test="${!empty acl.childrenAcls}">
		            <ul>
		             <c:forEach var="childAcl"  items="${acl.childrenAcls}" varStatus="childStatu">    
				            <li>
					          <span class="tree-icon">
					          <i class="glyphicon glyphicon-minus-sign"></i>
					          <span class="tree-resource">
					            <i class="${childAcl.icon}"></i>
					            <a href="javascript:;">${childAcl.aclName}</a>  
					          </span >
					          </span>
					          <c:if test="${!empty  childAcl.childrenAcls}">
					           <ul>
					            <c:forEach var="SecondchildAcl"  items="${childAcl.childrenAcls}" varStatus="SecondchildStatu">   
					                  <li>
					                    <span class="tree-icon">
								          <i class="glyphicon glyphicon-minus-sign"></i>
								          <span class="tree-resource">
								            <i class="${SecondchildAcl.icon}"></i>
								            <a href="javascript:;">${SecondchildAcl.aclName}</a>  
								          </span>
								        </span>
								          <c:if test="${!empty  SecondchildAcl.childrenAcls}">
									           <ul>
									            <c:forEach var="ThirdchildAcl"  items="${SecondchildAcl.childrenAcls}" varStatus="ThirdchildStatu">   
									                  <li>
									                    <span class="tree-icon">
												          <i class="glyphicon glyphicon-minus-sign"></i>
												          <span class="tree-resource">
												            <i class="${ThirdchildAcl.icon}"></i>
												            <a href="javascript:;">${ThirdchildAcl.aclName}</a>  
												          </span>
												        </span>
									                  </li>           
									            </c:forEach>   
									           </ul>          
									       </c:if>
					                  </li>           
					            </c:forEach>   
					           </ul>          
					          </c:if>
					        </li>        
		             </c:forEach>  
		            </ul>  
		           </c:if>
		         </li>
	          
		     </c:forEach>
		      </ul>
		   </li>
         </ul>
      </div>
      
  </body>
</html>