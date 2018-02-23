<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
   <!-- 新增spu -->
   <div class="row" id="spu-add-place" >
       <div class="col-md-12">
         <div>
	      <ul class="nav nav-tabs" role="tablist">
	        <li role="presentation" class="active"><a href="#oneNode" aria-controls="oneNode" role="tab" data-toggle="tab">基本信息</a></li>
	        <li role="presentation"><a href="#twoNode" aria-controls="twoNode" role="tab" data-toggle="tab">SPU属性</a></li>
	        <!-- 
	        <li role="presentation"><a href="#threeNode" aria-controls="threeNode" role="tab" data-toggle="tab">关键属性</a></li>
	         -->
	        <li role="presentation"><a href="#fourNode" aria-controls="fourNode" role="tab" data-toggle="tab">SPU介绍</a></li>
	        <li role="presentation"><a href="#fiveNode" aria-controls="fiveNode" role="tab" data-toggle="tab">SPU图片</a></li>	        			    
	      </ul>
	     <form id="spuForm" action="${pageContext.request.contextPath}/admin/spu/spu/saveAdd" method="post" >
	     <input type="text" name="categoryId" value="${category.id}" hidden="" readonly="readonly">	  
	     <div class="tab-content">
	       <div role="tabpanel" class="tab-pane active" id="oneNode">               		            
	            <div class="form-group" style="margin-top:20px;">
	              <label for="spu-name" class="control-label" >SPU名称:</label>
	              <input type="text" class="form-control" id="spu-name" name="spuName" placeholder="请输入SPU名">
	            </div>
	            <div class="form-group">
	              <label for="categoryContext" class="control-label">标题:</label>
	              <textarea class="form-control" rows="3"  id="spu-title" name="spuTitle" placeholder="用于搜索的关键词，长度不可多余25个字"></textarea>
	            </div>
	            <div class="form-group">
	              <label for="spu-brandId" class="control-label">品牌:</label>
	              <select id="spu-brandId"  class="form-control "   name="brandId"  >
	                  <option value="">请选择品牌</option>
				      <c:forEach items="${categoryBrands}" var="categoryBrand" varStatus="statu">
				        <option value="${categoryBrand.brandId}" >${categoryBrand.brandName}</option>
				      </c:forEach>			     
				  </select>
	            </div>
	            <div class="form-group">
	              <label for="spu-statu" class="control-label" >状态:</label>
	              <select id="spu-statu" class="form-control" name="spuStatu" >
			        <option    value = "1" selected="selected">下架</option>
		            <option    value = "2">上架</option>
		            <option    value = "3">无货</option>
		            <option    value = "4">非卖品</option>
		            <option    value = "5">赠品</option>
			     </select>
			    </div>
			    <div class="form-group">
	              <label for="spu-image" class="control-label">缩略图:</label>
	              <input type="file"  class="cleanInput file-loading" id="spu-image" name="spuImage"/>
	            </div>	         	        			        	                        
            </div>
             <div role="tabpanel" class="tab-pane" id="twoNode" style="margin-top:20px;">
               <!-- 遍历Spu属性 -->
               <c:forEach items="${category.attributes}" var="attribute" varStatus="statu">
               <div class="form-group">
		         <label for="spu-attribute-${attribute.id}" class="control-lable">${attribute.attributeName}</label>
		         <select id="spu-attribute-${attribute.id}"  class="form-control selectpicker show-tick spu-attribute-select " data-size="6" data-live-search="true" multiple="multiple"  id="attribute-id"  title="请选择属性值"   name="optionIds"  >	                  
				      <c:forEach items="${attribute.options}" var="option" varStatus="statu">
				        <option value="${option.id}" >${option.optionName}</option>
				      </c:forEach>			     
				  </select>
		       </div>               
               </c:forEach>     			        				      			     				                      	
		     </div>				    	     				   
             <!-- 影响价格属性 
             <div role="tabpanel" class="tab-pane" id="threeNode">
	            <div class="form-group" style="margin-top:20px;">
		          <label for="spu-price-attribute" class="control-lable">关键属性:</label>
		          <select id=""  class="form-control selectpicker show-tick spu-attribute-select " data-size="6" data-live-search="true" multiple="multiple"  id="spu-price-attribute"  title="请确定关键属性，如影响价格的属性"   name="spu-price-attribute"  >	                  
				      <c:forEach items="${categoryAttrs}" var="categoryAttr" varStatus="statu">
				        <c:if test="${categoryAttr.priceType == 2}">
				          <option value="${categoryAttr.attributeId}" >${categoryAttr.attributeName}</option>
				        </c:if>
				      </c:forEach>			     
				  </select>
		        </div> 
	         </div>
             -->
             <!-- Spu介绍文 -->
             <div role="tabpanel" class="tab-pane" id="fourNode">
              <div style="margin-top:20px;"></div>
              <!-- SPU介绍 -->             
              <div id="spu-content-edit"  data-fileRoot="${pros.fictitiousRoot}" data-fileUploadUrl="${pageContext.request.contextPath}/admin/common/file/contentFileUpload"> </div>			    	     				   
             </div>
                <!-- SPU图片 -->
	         <div role="tabpanel" class="tab-pane" id="fiveNode">	                
	           <div class="form-group" style="margin-top:20px;">
	             <label for="sonCategoryName" class="control-label">轮播图:</label>
	             <input type="file" class="form-control" id="spu-scroll-image" name="scrollImages" multiple class="file-loading">
	           </div>
	         </div>	       
	     </div>			
       </form> 
      </div>
    </div>	       	
 </div>  