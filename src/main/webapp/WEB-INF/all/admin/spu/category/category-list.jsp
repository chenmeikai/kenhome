<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>分类管理
	  </title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
     
      <!-- 引入 Bootstrap -->
      <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <!-- tree样式 --> 
      <link href="${pageContext.request.contextPath}/resources/css/tree/tree.css" rel="stylesheet">
      <!-- 滚动条样式 -->
	  <link href="${pageContext.request.contextPath}/resources/css/scroll/scroll.css" rel="stylesheet">
	 	 
	  <style type="text/css">
	    .resource-title{margin:-15px;}
	    .tree {
	        background-color:#f2f6ff;
        }
        li>a{display:none;}
        li>a:hover{display:block;}
        #editPlace{border:0;min-height:800px;}
        
	  </style>
	 	  
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	       
	  <script type="text/javascript">
		  $().ready(function(){
			  
			  //树状显示
			  $('.tree li:has(ul)').addClass('parent_li').find(' > span');

			    $('.tree li.parent_li > .tree-icon').on('click', function (e) {

			        var children = $(this).parent('li.parent_li').find(' > ul > li');

			        if (children.is(":visible")) {

			            children.hide('fast');

			            $(this).find(' > i').addClass('glyphicon-plus-sign').removeClass('glyphicon-minus-sign');

			        } else {

			            children.show('fast');

			            $(this).find(' > i').addClass('glyphicon-minus-sign').removeClass('glyphicon-plus-sign');

			        }
			        e.stopPropagation();
			    });
			    
			    <!--加载编辑界面-->
			    var editUrl = $("#editUrl").attr("data-editUrl");
			    $("#editPlace").attr("src",editUrl);
			    
			    
			    //‘编辑’图标展示
			    $("li").hover(function(){
			    	
			    	$(this).children("a").css("display","inline");
			    	return false;
			    },
			    function(){
			    	$(this).children("a").css("display","none");		    	
			    })
		      
		  });
		  
		  
		  //展示编辑界面
		  function viewEditEntity(id,url){
			  var targetUrl = url+'?id='+id; 
			  $("#editPlace").attr("src",targetUrl);
		  }
		  
	  </script>
	  
   </head>
   <body>
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-4 scrollbar"  id="style-1" style="min-height:800px;">
          <div class="tree force-overflow" style="min-height:800px;">
	        <ul>
		      <li>
			     <span class="tree-icon">
			       <i class="glyphicon glyphicon-minus-sign"></i>
			       <span class="tree-resource">
			         <i class="glyphicon glyphicon-tree-deciduous"></i>
			         <a id="editUrl" href="javascript:;" data-editUrl="${pageContext.request.contextPath}/admin/spu/category/viewEditCatagory">分类树</a>  
			       </span>
			     </span>
			      <ul>
			     <!-- 开始迭代 -->
			     <c:forEach  var="category" items="${categorys}" varStatus="statu">    
		             <li>
			           <span class="tree-icon">
			             <i class="glyphicon glyphicon-plus-sign"></i>
			             <span class="tree-resource">
			               <i class="glyphicon glyphicon-leaf"></i>
			               <a href="javascript:;">${category.categoryName}</a>  
			             </span>
			           </span>
			            <a href="javascript:viewEditEntity(${category.id},'${pageContext.request.contextPath}/admin/spu/category/viewEditCatagory');" class=""><i class="glyphicon glyphicon-pencil text-warning"></i></a>
			           <c:if test="${!empty category.childrenCategorys}">
			            <ul>
			             <c:forEach var="childCategory"  items="${category.childrenCategorys}" varStatus="childStatu">    
					            <li style="display:none;">
						          <span class="tree-icon">
						            <i class="glyphicon glyphicon-plus-sign"></i>
						            <span class="tree-resource">
						              <i class="glyphicon glyphicon-leaf"></i>
						              <a href="javascript:;">${childCategory.categoryName}</a>  
						            </span > 
						          </span>
						            <a href="javascript:viewEditEntity(${childCategory.id},'${pageContext.request.contextPath}/admin/spu/category/viewEditCatagory');" class=""><i class="glyphicon glyphicon-pencil text-warning"></i></a>
						          <c:if test="${!empty  childCategory.childrenCategorys}">
						           <ul>
						            <c:forEach var="SecondchildCategory"  items="${childCategory.childrenCategorys}" varStatus="SecondchildStatu">   
						                  <li style="display:none;">
						                    <span class="tree-icon">
									          <i class="glyphicon glyphicon-minus-sign"></i>
									          <span class="tree-resource">
									            <i class="glyphicon glyphicon-leaf"></i>
									            <a href="javascript:;">${SecondchildCategory.categoryName}</a>  
									          </span>
									        </span>
									         <a href="javascript:viewEditEntity(${SecondchildCategory.id},'${pageContext.request.contextPath}/admin/spu/category/viewEditCatagory');" class=""><i class="glyphicon glyphicon-pencil text-warning"></i></a>
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
        </div>
        <iframe id="editPlace" src=""  class="col-md-8">
          
        </iframe>
      </div>
    </div>
    
      
  </body>
</html>