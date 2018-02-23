<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>

<div id="showEntityplaceEdit" class="">
  
  <form id="editForm" action="${pageContext.request.contextPath}/admin/spu/brand/saveEdit" method="post" enctype="multipart/form-data">
         <input type="text" id="brand-editId" name="id" value="${viewEditBrand.id}" hidden="" readonly="readonly"/>
        <div class="form-group">
          <label for="brand-logo" class="control-label">品牌logo:</label>
          <img src="${pros.fictitiousRoot}${viewEditBrand.logo}" class="img-rounded img-responsive entity-param-picture ">
          <input type="file"  class="cleanInput file-loading" id="brand-editlogo" name="logo" value="替换"/>
        </div>
        <div class="form-group">
          <label for="brand-name" class="control-label">品牌中文名:</label>
          <input type="text" class="form-control cleanInput" id="brand-editName" name="brandName" value="${viewEditBrand.brandName}" placeholder="请输入品牌名" data-validateUrl="${pageContext.request.contextPath}/admin/spu/brand/validateEditName">
        </div>
        <div class="form-group">
          <label for="brand-enName" class="control-label">品牌英文名:</label>
          <input type="text" class="form-control cleanInput" id="brand-editEnName" name="enName" value="${viewEditBrand.enName}" placeholder="请输入品牌英文名"></input>
        </div>
        <div class="form-group">
          <label for="brand-aliasName" class="control-label">品牌别名:</label>
          <input type="text" class="form-control cleanInput" id="brand-editAliasName" name="aliasName" value="${viewEditBrand.aliasName}" placeholder="请输入品牌别名，以分号间隔"></input>
        </div>
        <div class="form-group">
          <label for="brand-description" class="control-label">品牌介绍:</label>
          <textarea class="form-control cleanInput" id="brand-editDescription" name="description"  placeholder="请简短介绍品牌">${viewEditBrand.description}</textarea>
        </div>
        <div class="form-group" style="margin-top:30px;">
           <div class="input-group">		 
             <span class="input-group-addon" >是否启用</span>
            <select  class="form-control reset" name="statu" title="请选择是否启用">	     
              <option    value = "2"  ${viewEditBrand.statu==2 ? 'selected="selected"' :''} >启用</option>
              <option    value = "1" ${viewEditBrand.statu==1 ? 'selected="selected"' :''} >不启用</option>
            </select>
           </div>
        </div>  	                   
   </form>
</div>
 
	         	                   
	       