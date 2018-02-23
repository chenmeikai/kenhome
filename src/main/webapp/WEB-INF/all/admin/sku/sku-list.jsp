<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
   <head>
      <title>商品中心
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
	  	  
	  <!-- 图片放大样式 -->
      <link href="${pageContext.request.contextPath}/resources/css/zoomify/zoomify.css" rel="stylesheet">
	  

	  <style type="text/css">
	    .{margin-right:15px;}
	    .image-vatar{width:50px;height:auto;}
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
	   	  
	  <!-- 图片放大 -->
	  <script src="${pageContext.request.contextPath}/resources/js/zoomify/zoomify.js"></script>
	  
	  <script src="${pageContext.request.contextPath}/resources/js/admin/common.js"></script>
       
	  <script type="text/javascript">
		  $().ready(function(){
			  
		     	//图片放大
			    $('.image-vatar').zoomify();
		     	
			    //键入字符触发事件:动态获得后台传入select选项数据         
	            //请求的url
	            var selectBrandUrl = $("#spu-getBrand").attr("data-selectBrandUrl");
	              
	             //选择得到搜索栏input，松开按键后触发事件
	            $("#spu-getBrand").prev().find('.bs-searchbox').find('input').keyup(function () {                   
	                  //键入的值
	                  var inputBrandName =$('#spu-select-brand .open input').val();
	                  //判定键入的值不为空，才调用ajax
	                  if(inputBrandName != ''){
	                      $.ajax({
	                            type: 'Get',
	                            url: selectBrandUrl,
	                            data: {                     //传递到后台的值
	                                brandName: inputBrandName
	                            },
	                            dataType: "Json",
	                            success: function (Selectbrands) {
	                                //清除select标签下旧的option签，根据新获得的数据重新添加option标签
	                                $("#spu-getBrand").empty();
	                                if (Selectbrands != null) {               
	                                    $.each(Selectbrands, function (i,Selectbrand) {
	                                        $("#spu-getBrand").append(" <option value=\"" + Selectbrand.id + "\">" + Selectbrand.brandName + "</option>");
	                                    })
	                                    //必不可少的刷新
	                                    $("#spu-getBrand").selectpicker('refresh');
	                                   
	                                }
	                            }
	                      })
	                  }else 
	                      //如果输入的字符为空，清除之前option标签
	                      $("#spu-getBrand").empty();
	                      $("#spu-getBrand").selectpicker('refresh');  
	              });     
				  
			  	  
	            //级联select:首级select的值发生改变，触发二级的选项改变
	              $("#select-first").change(function(){
	            	  //清空二级和三级select的旧选项
	            	  $("#select-second").empty();
	            	  $("#select-third").empty();
	            	  //请求二级select选项数据地址
	            	  var targetUrl = $(this).attr("data-getDataUrl");
	   
	            	  //一级select的值
	            	  var firstValue = $(this).val();  
	                  
	            	  //如果一级select的值为null，隐藏二、三级select,并返回
	            	  if(firstValue == ''){
	            		  $("#select-second").fadeOut("slow");
	            		  $("#select-third").fadeOut("slow");
	            		  return;
	            	  }      	  
	            	 
	            	 //根据一级的值改变，异步获取数据更新二级的选项             
	            	  $.ajax({    
		                  type:'get',        
		                  url:targetUrl,    
		                  data:{
		                	  parentId:firstValue
		                  },    
		                  cache:false,    
		                  dataType:'json',    
		                  success:function(secondDatas){   	                  	 
		                	  
		                	  //遍历回传的数据添加到二级select
		                  	  $.each(secondDatas, function(key, secondData) {
		                  		 
		                  	  	   var option = '<option value="'+secondData.id+'">'+secondData.categoryName+'</option>'	  
		                  	  	   $("#select-second").append(option)
		                  	  	   
		                  	  })
		                  	   //bootstap-select控件:需刷新对应select               	  	  
	                 	  	   $("#select-second").selectpicker('refresh');
		                  	  
		                  	  //二级select展示
		                       $("#box-select-second").fadeIn("slow");
		                  	  //三级select隐藏
	                 	  	   $("#box-select-third").fadeOut("slow");                 	  	          	  	  
		                  },
		                  error:function(){ 
		                  	bootbox.alert("请求失败")
		        			}
					   });				  
	              });
	              
	              //级联select:二级select值改变，触发三级select变化
	              $("#select-second").change(function(){
	            	  //清空三级slect的旧选项          	  
	            	  $("#select-third").empty();
	            	  //请求二级select选项数据地址
	            	  var targetUrl = $(this).attr("data-getDataUrl");
	            	  //二级select的值
	            	  var secondValue = $(this).val();
	            	  //如果一级select的值为null，隐藏三级select,并返回
	            	  if(secondValue == ''){           		 
	            		  $("#select-third").fadeOut("slow");
	            		  return;
	            	  } 
	            	  //根据二级的值改变，异步获取数据更新三级的选项    
	            	  $.ajax({    
		                  type:'get',        
		                  url:targetUrl,    
		                  data:{
		                	  parentId:secondValue
		                  },    
		                  cache:false,    
		                  dataType:'json',    
		                  success:function(thirdDatas){   	                  	 
		                	  
		                	  //遍历回传的数据添加到三级select
		                  	  $.each(thirdDatas, function(key, thirdData) {
		                  		 
		                  	  	   var option = '<option value="'+thirdData.id+'">'+thirdData.categoryName+'</option>'	  
		                  	  	   $("#select-third").append(option)
		                  	  	   
		                  	  })
		                  	  //bootstap-select控件:需刷新对应select               	  	  
	                 	  	   $("#select-third").selectpicker('refresh');
		                  	  
		                  	   //三级select显示出来
	                 	  	   $("#box-select-third").fadeIn("slow");                 	  	          	  	  
		                  },
		                  error:function(){ 
		                  	bootbox.alert("请求失败")
		        			}
					   });				  
	              });
	             
	             //验证SPU号表单	             
	             var validateUrl = $("#sku-spuNo").attr("data-validateUrl");
	             $("#select-spuNo").bootstrapValidator({
                     message: 'This value is not valid',
                     excluded : [':disabled'],//[':disabled', ':hidden', ':not(:visible)']//验证不包含无效的
                     feedbackIcons: {
                         valid: 'glyphicon glyphicon-ok',
                         invalid: 'glyphicon glyphicon-remove',
                         validating: 'glyphicon glyphicon-refresh'
                     },
			           fields: {
			        	   spuNo: {
			                    validators: {
			                        notEmpty: {
			                            message: '请输入商品号'
			                        },
			                        remote: {
			                            type: 'GET',
			                            url: validateUrl,
			                            spuNo: function(){return $("#sku-spuNo").val();},
			                            dataType:'json',
			                            message: '该SPU编号不存在',
			                            delay: 500
			                        }
			                    }				      
			                }
			            }
	              });  
	             
	             $("#submitAddSpuNo").click(function(){
	            	  //表单验证
	            	  var bootstrapValidator = $("#select-spuNo").data('bootstrapValidator');
	            	  bootstrapValidator.validate();                          
	                  if(bootstrapValidator.isValid()){
	                	  $("#addEntity").modal("hide");
	                	  var addUrl = $("#select-spuNo").attr("action") +"?spuNo="+$("#sku-spuNo").val();
	                	  window.open(addUrl);
	                  }
	             })
				
		  });
	  </script>
	  
   </head>
   <body>
     <div class="container-fluid">
	   <div class="row common-head">
	     <div class="col-md-2">
		   <span class="common-name">商品中心</span>
		   <span>(</span>
		   <span class="text-success">${pageInfo.getTotal()}</span>
		   <span id="entityNums">种商品</span>
		   <span>)</span>
		 </div>
		 <div class="col-md-2 pull-right text-right">
		   <a id="showAddWindow" href="javascript:;" class="btn btn-xs btn-info btn-outline-info">
		    <i class="glyphicon glyphicon-plus"></i>
			<span>新增</span>
		   </a>
		   <a id="excel-export" href="javascript:;" data-href="${pageContext.request.contextPath}/admin/sku/sku/export?" class="btn btn-xs btn-warning btn-outline-warning ">
		    <i class="glyphicon glyphicon-export"></i>
			<span>导出excel</span>
		   </a>
		 </div>			 
	   </div>
	   
	   <!--搜索栏-->
	   <form id="listForm" class="row common-search " action="${pageContext.request.contextPath}/admin/sku/sku/main"  method = "GET">          
	      <div class="row form-group "> 
	       <div class="col-md-2">	   		 
			  <input type="text" class="form-control reset" placeholder="商品号" name="skuNo" value="${params.skuNo}">		   
		   </div>
		   <div class="col-md-2">	   		 
			  <input type="text" class="form-control reset" placeholder="SPU号" name="spuNo" value="${params.spuNo}">		   
		   </div>
		   <div class="col-md-2">		  		 
			  <input type="text" class="form-control reset" placeholder="商品名" name="skuName" value="${params.skuName}">		   
		   </div>
		   <div class=" col-md-2" id="spu-select-brand">		 
			  <select  class="form-control selectpicker show-tick reset" id="spu-getBrand" title="请输入品牌" name="brandId"  data-selectBrandUrl="${pageContext.request.contextPath}/admin/spu/spu/getBrand" data-live-search="true"  data-size="6">
			     <option value="${params.brandId}" ${params.brandId >0  ? 'selected="selected"' :''}>已选Id：${params.brandId}</option>
			  </select>
		   </div>
		   <div class=" col-md-2">		 
			  <select  class="form-control reset" name="skuStatu" >
			     <option    value = "" >全部状态</option>
			     <option    value = "1" ${params.skuStatu eq 1 ? 'selected="selected"' :null}>下架</option>
		         <option    value = "2" ${params.skuStatu eq 2 ? 'selected="selected"' :null}  >上架</option>
		         <option    value = "3" ${params.skuStatu eq 3 ? 'selected="selected"' :null}  >预售</option>		         
			  </select>
		   </div>	
		   	   			 		   
		 </div>	
		 <div class="row form-group form-inline "> 	       
		   <div class="input-group col-md-2" style="margin-left:15px;" >		   		 
			    <input type="text" class="form-control  reset" placeholder="原价" name="startOriginalPrice" value="${params.startOriginalPrice}" id="oneOriginal" >
			    <span class="input-group-addon" >到</span>
			    <input type="text" class="form-control  reset" placeholder="原价" name="endOriginalPrice" value="${params.endOriginalPrice}" id="twoOriginal" >		   
		   </div>
		   <div class="input-group col-md-2" style="margin-left:15px;" >		   		 
			    <input type="text" class="form-control  reset" placeholder="销售价" name="startSalePrice" value="${params.startSalePrice}" id="oneSale" >
			    <span class="input-group-addon" >到</span>
			    <input type="text" class="form-control  reset" placeholder="销售价" name="endSalePrice" value="${params.endSalePrice}" id="twoSale" >		   
		   </div>
		   <div class="input-group col-md-2" style="margin-left:15px;" >		   		 
			    <input type="text" class="form-control  reset" placeholder="销量" name="startSaleAmount" value="${params.startSaleAmount}" id="oneSaleAmount" >
			    <span class="input-group-addon" >到</span>
			    <input type="text" class="form-control  reset" placeholder="销量" name="endSaleAmount" value="${params.endSaleAmount}" id="twoSaleAmount" >		   
		   </div>	
		    <div class="input-group col-md-2" style="margin-left:15px;" >		   		 
			    <input type="text" class="form-control  reset" placeholder="库存" name="startStocks" value="${params.startStocks}" id="oneStocks" >
			    <span class="input-group-addon" >到</span>
			    <input type="text" class="form-control  reset" placeholder="库存" name="endStocks" value="${params.endStocks}" id="twoStocks" >		   
		   </div>
		   <div class="input-group  col-md-2" style="margin-left:15px;margin-top:-2px;">		   		 
			    <input type="text" class="form-control datetimepicker reset" placeholder="创建起始" name="startCreateDate" value="${params.startCreateDate}" id="oneDate" >
			    <span class="input-group-addon" >到</span>
			    <input type="text" class="form-control datetimepicker reset" placeholder="结束时间" name="endCreateDate" value="${params.endCreateDate}" id="twoDate" >		   
		   </div>		   			 		   
		 </div>	   
		 <div class="row ">			    
		   <div class="form-group col-md-2 " id="spu-select-firstCategory">		 
			  <select  class="form-control selectpicker show-tick reset" id="select-first" title="请选择分类" name="firstValue"  data-getDataUrl="${pageContext.request.contextPath}/admin/spu/spu/getsonCategory" data-live-search="true"  data-size="6">
			      <c:forEach items="${rootCategorys}" var="rootCategory" varStatus="statu">
			        <option value="${rootCategory.id}" ${params.firstValue ==rootCategory.id  ? 'selected="selected"' :''}  >${rootCategory.categoryName}</option>
			      </c:forEach>			     
			  </select>
		   </div>
		   <div class="form-group col-md-2  " id="box-select-second" ${secondCategorys ==null  ? 'style="display:none;"' :''}   >		 
			  <select   class="form-control selectpicker show-tick reset" id="select-second" title="二级分类" name="sonCategoryId"  data-getDataUrl="${pageContext.request.contextPath}/admin/spu/spu/getsonCategory" data-live-search="true"  data-size="6">
			    <c:forEach items="${secondCategorys}" var="secondCategory" varStatus="statu"> 
			     <option value="${secondCategory.id}" ${params.sonCategoryId ==secondCategory.id  ? 'selected="selected"' :''}  >${secondCategory.categoryName}</option>  	      		     
			    </c:forEach>	
			  </select>
		   </div>
		   <div class="form-group col-md-2 " id="box-select-third" ${thirdCategorys ==null  ? 'style="display:none;"' :''} >		 
			  <select   class="form-control selectpicker show-tick reset" id="select-third" title="三级分类" name="categoryId"  data-getDataUrl="${pageContext.request.contextPath}/admin/spu/spu/getsonCategory" data-live-search="true"  data-size="6">  
			     <c:forEach items="${thirdCategorys}" var="thirdCategory" varStatus="statu"> 
			       <option value="${thirdCategory.id}" ${params.categoryId ==thirdCategory.id  ? 'selected="selected"' :''}  >${thirdCategory.categoryName}</option>  	      		     
			     </c:forEach>		     
			  </select>
		   </div>
		   <div class=" col-md-2">		 
			  <select  class="form-control reset" name="skuSort">
			     <option    value = "create_date" ${params.skuSort.equals('create_date') ? 'selected="selected"' :null}>默认排序</option>
			     <option    value = "original_price" ${params.skuSort.equals('original_price') ? 'selected="selected"' :null}  >按原价</option>
		         <option    value = "sale_price" ${params.skuSort.equals('sale_price') ? 'selected="selected"' :null}  >按销售价</option>
		         <option    value = "sale_amount" ${params.skuSort.equals('sale_amount') ? 'selected="selected"' :null}  >按销量</option>
		         <option    value = "stocks" ${params.skuSort.equals('stocks') ? 'selected="selected"' :null}  >按库存</option>		         
			  </select>
		   </div>
		   <div class=" col-md-1">		 
			  <select  class="form-control reset" name="direction">
			     <option    value = "DESC" ${params.direction.equals('DESC') ? 'selected="selected"' :null}>倒序</option>
			     <option    value = "ASC" ${params.direction.equals('ASC') ? 'selected="selected"' :null}  >正序</option>      
			  </select>
		   </div> 	 				
           	<div class="form-group form-inline col-md-2 ">	 
			  <input id="formSearch" type="button" class="form-control" value="搜索" >
			  <input id="searchReset" type="button" class="form-control" value="重置">		
			</div>
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
			  <th>商品图</th>
			  <th>商品号</th>
			  <th>SPU号</th>
			  <th>商品名</th>
			  <th>原价</th>
			  <th>销售价</th>
			  <th>销量</th>
			  <th>库存</th>
			  <th>所属类</th>
			  <th>品牌名</th>
			  <th>状态</th>
			  <th>积分</th>				  
			  <th>创建日期</th>	
			  <th>更新日期</th>	
			  <th>操作</th>	              			  
			</tr>
		  </thead>
		  <tbody >
		   <c:forEach var="pageSku"   items="${pageInfo.getList()}" varStatus="statu" >
		     
		     <tr id="${pageSpu.id}" class="tr">
		      <td>
		        <img src="${pros.fictitiousRoot}${pageSku.picture}" class="img-rounded img-responsive image-vatar zoomify">
		      </td>
			  <td>${pageSku.skuNo}</td>
			  <td>${pageSku.spuNo}</td>
			  <td>${pageSku.skuName}</td>
			  <td>${pageSku.originalPrice}</td>
			  <td>${pageSku.salePrice}</td>
			  <td>${pageSku.saleAmount}</td>
			  <td>${pageSku.stocks}</td>
			  <td>${pageSku.categoryName}</td>
			  <td>${pageSku.brandName}</td>
			  <td>
			    <c:choose>  
				    <c:when test="${pageSku.skuStatu=='1'}">  
				             下架  
				    </c:when>  
				    <c:when test="${pageSku.skuStatu=='2'}">  
				             上架  
				    </c:when>  
				    <c:when test="${pageSku.skuStatu=='3'}">  
				             预售  
				    </c:when>  				    
				</c:choose>
			  </td>
			  <td>${pageSku.integration}</td>			  	  			  
			  <td>
			  <fmt:formatDate type="both" value="${pageSku.createDate}" dateStyle="default"/> 
			  </td>
			  <td>
			  <fmt:formatDate type="both" value="${pageSku.updateDate}" dateStyle="default"/> 			  
			  </td>
			  <td>
			   <a href="javascript:;" onClick="window.open('${pageContext.request.contextPath}/admin/sku/sku/view?id=${pageSku.id}')" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-book"></i>&nbsp;<span>查看</span></a>			   
			   <a href='${pageContext.request.contextPath}/admin/sku/sku/linkSpu?id=${pageSku.spuId}' class="btn btn-info btn-xs"><i class="glyphicon glyphicon-link"></i>&nbsp;<span>SPU</span></a>			 
			   <a href="javascript:;" onClick="window.open('${pageContext.request.contextPath}/admin/sku/sku/edit?id=${pageSku.id}')" class="btn btn-warning btn-xs"><i class="glyphicon glyphicon-pencil"></i>&nbsp;<span>编辑</span></a>
			  </td>
			</tr>		   
		   </c:forEach>
		   		
		  </tbody>
		</table>
	   </div>
	   
	   <!--页码-->
	  <%@ include file="/WEB-INF/all/include/pageHelper.jsp"%> 
	</div>   
		
	
  
  
	  <!-- 新增sku：SPU输入弹窗 -->  
	  <div class="modal fade " id="addEntity" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
	    <div class="modal-dialog  " role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title" id="addModalLabel">请先输入要新增商品的SPU号</h4>
	        </div>
	        <div class="modal-body" >	          
	           <form id="select-spuNo"  action="${pageContext.request.contextPath}/admin/sku/sku/viewAdd"  method="get">	  
			     <div class="form-group " id="spu-select-firstCategory2">
			       <label for="sku-spuNo" class="control-label">SPU号：</label>		 
				   <input id="sku-spuNo" data-validateUrl="${pageContext.request.contextPath}/admin/sku/sku/validateSpuNo" type="text" name="spuNo" placeholder="请输入SPU编号" class="form-control" />
			     </div>
			   </form>   				           			 	        
		   </div>		    
	       <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	          <button type="button" class="btn btn-primary" id="submitAddSpuNo">确认</button>
	       </div>
		 </div>
	    </div>
	  </div>	
	
  
  </body>
</html>