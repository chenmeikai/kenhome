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
	 
        .role-span{margin:0px;background-color:#3d758a;}
        .role-button{margin:0px;}
        .acl-button{position:absolute; margin-top:5%;}
        
        .tree li::before {		   
		    top:-5px;;
		}
        
        .tree  li:last-child:before {
          height:27px
        }
       
	  
	  </style>
	 	  
	
      <script src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	  <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>

       
	  <script type="text/javascript">
		  $().ready(function(){
			  
			  //提交授权资源数据
			  $("#addRoleAcl").click(function(){
				  
				  //提交按钮状态改变
				  $(this).text("提交中").attr("disabled","disabled");
				  
				  //异步处理
				   var targetUrl = $(this).attr("data-authorizeUrl");
				   var inputData = $("#addResource").serialize();
				   $.ajax({
					   type : 'post',
					   url  : targetUrl,
					   data : inputData,
					   dataType:'json',
					   success: function(flag){
						   if(flag == true){
							   bootbox.alert("授权成功");
							   $("#addRoleAcl").text("重新授权").removeAttr("disabled");
						   }  
						   else bootbox.alert("授权失败");
						   $("#addRoleAcl").text("重新授权").removeAttr("disabled");
					   },
					   error : function(){
						   bootbox.alert("请求失败");
						   $("#addRoleAcl").text("重新授权").removeAttr("disabled");
					   }
				   });
			  });
			  
			  
			  //资源选择
			  //全选
			  $("#selectAllAcl").click(function(){
				  $("input[type='checkbox']").prop("checked",true);
			  });
			  //全不选
			  $("#selectNoAcl").click(function(){
				  $("input[type='checkbox']").prop("checked",false);
			  });
			  
			  //点击选择框，子选择框与其保持一致状态,如果选择框被选中，其父选择框也被选中
			  $("input[type='checkbox']").click(function(){				  
				  var flag=$(this).prop("checked");
				  $(this).parent().parent().parent().find("ul").find("label").find("input[type='checkbox']").prop("checked",flag);
				  
				  if(flag==true){
					  $(this).parent().parent().parent().parent().parent().find("input[type='checkbox']").eq(0).prop("checked",flag);
				  }
			  })
			  
		  });
	  </script>
	  
   </head>
   <body>
    <span   class="label label-default label-lg role-span">${authorizeRole.roleName}</span>
    <button id="addRoleAcl"  type="button"  class="btn btn-default navbar-btn role-button" data-authorizeUrl="${pageContext.request.contextPath}/admin/authority/roleAcl/saveAuthorize">确定授权</button>
    <div class="acl-button">
      <div>
         <button id="selectAllAcl"  type="button"  class="btn btn-default navbar-btn btn-sm" >全选</button>
      </div>
      <div>
         <button id="selectNoAcl"  type="button"  class="btn btn-default navbar-btn btn-sm" >不选</button>
      </div>
      
    </div>    
    <div class="tree">
       <ul>
	      <li>
		     <span class="tree-icon">
		       <label>
			     <input class=""  type="checkbox"  />
		         <span class="tree-resource">
		           <i class="glyphicon glyphicon-tree-deciduous"></i>
		                              资源树  
		         </span>
		        </label>  
		     </span>
		     <form id="addResource" action="saveAuthorize" method="POST">
		         <input id="authorizeRoleId" name="roleId" value="${authorizeRole.id}" type="text" readonly="readonly" hidden="true"/>
			     <ul>
			     <!-- 开始迭代 -->
			     <c:forEach  var="acl" items="${acls}" varStatus="statu">      
		             <li>	              
			           <span class="tree-icon">
			           <label>
			           <input class=""  type="checkbox" name="aclId" value="${acl.id}"  ${aclIds.contains(acl.id) ? 'checked="checked"' :''} />
			           <span class="tree-resource">
			             <i class="${acl.icon}"></i>
			             ${acl.aclName}  
			           </span>
			           </label>
			           </span>
			           
			           <c:if test="${!empty acl.childrenAcls}">
			            <ul>
			             <c:forEach var="childAcl"  items="${acl.childrenAcls}" varStatus="childStatu">    
					            <li>
						          <span class="tree-icon">
						          <label>
			                        <input class=""  type="checkbox" name="aclId" value="${childAcl.id}" ${aclIds.contains(childAcl.id) ? 'checked="checked"' :''}/>
						            <span class="tree-resource">
						              <i class="${childAcl.icon}"></i>
						              ${childAcl.aclName} 
						            </span >
						          </label>  
						            </span>
						          <c:if test="${!empty  childAcl.childrenAcls}">
						           <ul>
						            <c:forEach var="SecondchildAcl"  items="${childAcl.childrenAcls}" varStatus="SecondchildStatu">   
						                  <li>
						                    <span class="tree-icon">
									          <label>
			                                    <input class=""  type="checkbox" name="aclId" value="${SecondchildAcl.id}" ${aclIds.contains(SecondchildAcl.id) ? 'checked="checked"' :''} />
									            <span class="tree-resource">
									              <i class="${SecondchildAcl.icon}"></i>
									             ${SecondchildAcl.aclName} 
									            </span>
									          </label>
									        </span>
									        <c:if test="${!empty  SecondchildAcl.childrenAcls}">
									           <ul>
									            <c:forEach var="ThirdchildAcl"  items="${SecondchildAcl.childrenAcls}" varStatus="ThirdchildStatu">   
									                  <li>
									                    <span class="tree-icon">
												          <label>
						                                    <input class=""  type="checkbox" name="aclId" value="${ThirdchildAcl.id}" ${aclIds.contains(ThirdchildAcl.id) ? 'checked="checked"' :''} />
												            <span class="tree-resource">
												              <i class="${ThirdchildAcl.icon}"></i>
												             ${ThirdchildAcl.aclName} 
												            </span>
												          </label>
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
		     </form>
		   </li>
         </ul>
      </div>
      
      
  </body>
</html>