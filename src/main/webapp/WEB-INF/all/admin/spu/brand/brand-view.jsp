<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>

<div id="showEntityplace" class="">
  <img src="${pros.fictitiousRoot}${viewBrand.logo}" class="img-rounded img-responsive entity-param-picture ">
  <table class="table">
    <tbody>
      <tr class="entity-each-param">
        <td class="param-name">中&nbsp;文&nbsp;名：</td>
        <td class="param-value">${viewBrand.brandName}</td>
      </tr>
      <tr class="entity-each-param">
        <td class="param-name">英&nbsp;文&nbsp;名：</td>
        <td class="param-value">${viewBrand.enName}</td>
      </tr>
      <tr class="entity-each-param">
        <td class="param-name">别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
        <td class="param-value">${viewBrand.aliasName}</td>
      </tr>
      <tr class="entity-each-param">
        <td class="param-name">介&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;绍：</td>
        <td class="param-value">${viewBrand.description}</td>
      </tr>
      <tr class="entity-each-param">
        <td class="param-name">启用状态：</td>
        <td class="param-value">${viewBrand.statu==2 ? "启用": "不启用" }</td>
      </tr>
      <tr class="entity-each-param">
        <td class="param-name">创建时间：</td>
        <td class="param-value"><fmt:formatDate type="both" value="${viewBrand.createDate}" dateStyle="default"/></td>
      </tr>
      <tr class="entity-each-param">
        <td class="param-name">修改时间：</td>
        <td class="param-value"><fmt:formatDate type="both" value="${viewBrand.updateDate}" dateStyle="default"/></td>
      </tr>
    </tbody>
  </table>
</div>
 
	         	                   
	       