<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 收货地址编辑 -->
         <div class="row" id="center-address-place2" >	     
	       <div class="col-md-12">		     
		     <form id="shipForm2" action="${pageContext.request.contextPath}/shop/ship/edit" method="post">
		        <input name="id" value="${editShipAddress.id}" readonly="readonly" hidden="" />
		        <div class="input-box col-md-12">  		                         		            
	              <div class="form-group col-md-3" >
	                <label for="ship-address-first2" class="control-label" >所在地区:</label>
	                <select id="ship-address-first2" class="form-control" name="provinceId" onchange="getSonArea(this,'ship-address-second2')">
	                    <option>请选择地区</option>
	                  <c:forEach items="${rootAreas}" var="rootArea" varStatus="statu">
	                    <option value="${rootArea.id}" data-url="${pageContext.request.contextPath}/shop/area/getNext/${rootArea.id}" ${editShipAddress.provinceId ==rootArea.id ? 'selected="selected"' : null}>${rootArea.name}</option>
	                  </c:forEach>	                  	                  
	                </select>
	              </div>
	              <div class="form-group col-md-3" >
	              <label for="ship-address-second2" class="control-label" >&nbsp;</label>
	              <select id="ship-address-second2" class="form-control" name="cityId" onchange="getSonArea(this,'ship-address-third2')">
	                <option value="">请选择</option>
	                <c:if test="${editShipAddress.cityId != null}">
	                <option value="${editShipAddress.cityId}" selected="selected">${editShipAddress.city}</option>
	                </c:if>
	              </select>
	              </div>
	              <div class="form-group col-md-3" >
	                <label for="ship-address-third2" class="control-label" >&nbsp;</label>
	                <select id="ship-address-third2" class="form-control" name="countyId">
	                 <option value="">请选择</option>
	                 <c:if test="${editShipAddress.countyId != null}">
	                 <option value="${editShipAddress.countyId}" selected="selected">${editShipAddress.county}</option>
	                 </c:if>
	                </select>
	              </div>	            
	            </div>	  
	            <div class="input-box col-md-12"> 	            
	              <div class="form-group col-md-6">
	                <label for="ship-address2" class="control-label">详细地址:</label>
	                <textarea class="form-control" rows="4"  id="ship-address2" name="address" placeholder="建议您如实填写详细收货地址，例如街道名称，门牌号码，楼层和房间号等信息，建议您如实填写详细收货地址，例如街道名称，门牌号码，楼层和房间号等信息">${editShipAddress.address}</textarea>
	              </div>
	            </div>	
	            <div class="input-box col-md-12">        
	              <div class="form-group col-md-4">
	                 <label for="ship-zipCode2" class="control-label">邮政编码:</label>
	                 <input type="text" class="form-control" id="ship-zipCode2" name="zipCode" value="${editShipAddress.zipCode}" placeholder="请输入邮政编码">
	              </div>	
	            </div>
	            <div class="input-box col-md-12">             
	              <div class="form-group col-md-4">
	                <label for="ship-shipName2" class="sku-originalPrice" >收货人姓名:</label>
	                <input type="text" class="form-control" id="ship-shipName2" name="shipName" value="${editShipAddress.shipName}" placeholder="请输入姓名，不可超过25字">
	              </div>
	            </div>  
	            <div class="input-box col-md-12"> 
	              <div class="form-group col-md-4">
	                <label for="ship-phone2" class="control-label" >电话/手机号码:</label>
	                <input type="text" class="form-control" id="ship-phone2" name="phone" value="${editShipAddress.phone}" placeholder="请输入电话/手机号码">
	              </div>
	            </div>    			        	                       
	          </form> 
	        </div>
	     </div>