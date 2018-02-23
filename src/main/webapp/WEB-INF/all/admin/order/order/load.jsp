<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>

   <c:forEach var="pageOrder"   items="${pageInfo.getList()}" varStatus="statu" >
     
     <tr id="${pageOrder.id}" class="tr">
      <td>
       ${pageOrder.orderNo} 
      </td>
	  
	  <td>${pageOrder.memberId}</td>
	  <td>
	    <span>商品金额：</span><span>${pageOrder.goodAmountTotal}</span><em>,</em>
	    <span>运费：</span><span>${pageOrder.logisticFee}</span><em>,</em>
	    <span>总金额：</span><span>${pageOrder.orderAmountTotal}</span>
	  </td>
	  <td>
	    <c:choose>  
		    <c:when test="${pageOrder.isInvoice=='1'}">  
		             无
		    </c:when>  
		    <c:when test="${pageOrder.isInvoice=='2'}">  
		             有  
		    </c:when>  
		</c:choose>
	  </td>
	  <td>
	    <span>${pageOrder.shipProvince}</span><span>${pageOrder.shipCity}</span><span>${pageOrder.shipCounty}</span>
	    <br>
	    <span>${pageOrder.shipAddress}</span>
	  </td>
	  <td>${pageOrder.orderLogisticId}</td>
	  <td>
	    <c:choose>  
		    <c:when test="${pageOrder.orderStatu=='1'}">  
		             微信支付
		    </c:when>  
		    <c:when test="${pageOrder.orderStatu=='2'}">  
		             支付宝支付  
		    </c:when>  
		    <c:when test="${pageOrder.orderStatu=='3'}">  
		             网银支付 
		    </c:when>  
		</c:choose>
	  </td> 
	  <td>
	    <c:choose>  
		    <c:when test="${pageOrder.orderStatu=='1'}">  
		             待付款  
		    </c:when>  
		    <c:when test="${pageOrder.orderStatu=='2'}">  
		             待发货  
		    </c:when>  
		    <c:when test="${pageOrder.orderStatu=='3'}">  
		             已发货 
		    </c:when>  
		    <c:when test="${pageOrder.orderStatu=='4'}">  
		             已签收  
		    </c:when> 
		    <c:when test="${pageOrder.orderStatu=='5'}">
		              已评论
		    </c:when> 	
		    <c:when test="${pageOrder.orderStatu=='6'}">
		              退货申请
		    </c:when> 				  
		    <c:when test="${pageOrder.orderStatu=='7'}">
		             退货中
		    </c:when> 				  
		    <c:when test="${pageOrder.orderStatu=='8'}">
		              已退货
		    </c:when> 				  
		    <c:when test="${pageOrder.orderStatu=='9'}">
		              取消交易
		    </c:when> 				  
		</c:choose>
	  </td>	
	  <td> ${pageOrder.remark}</td>
	  <td>
	  <fmt:formatDate type="both" value="${pageOrder.createDate}" dateStyle="default"/> 
	  </td>
	  <td>
	  <fmt:formatDate type="both" value="${pageOrder.updateDate}" dateStyle="default"/> 			  
	  </td>
	  <td>
	   <a href="javascript:viewEntity(${pageOrder.id},'${pageContext.request.contextPath}/admin/order/order/view');" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-book"></i>&nbsp;<span>查看</span></a>
	   <a href="javascript:editEntity(${pageOrder.id},'${pageContext.request.contextPath}/admin/order/order/viewedit');" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>编辑</span></a>
	  </td>
	</tr>		   
   </c:forEach>
		 
	
  
  
