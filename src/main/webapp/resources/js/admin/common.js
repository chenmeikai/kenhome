/**
 * 
 * 管理员js
 * 
 */

     $().ready(function(){	 
    	 
	     /**
	      * 时间插件
	      */
	     $('.datetimepicker').datetimepicker({
	    	    language:  'zh-CN',
	    	    format: 'yyyy-mm-dd',
	            weekStart: 1,
	            todayBtn:  1,
	            autoclose: 1,
	            todayHighlight: 1,
	            startView: 2, //这里就设置了默认视图
	            minView: 2, //设置最小视图
	            forceParse: 0,
	    	    
	      });
	     
	     
	     /**
	      * 跳转页面
	      */
	     $("#slectPage").click(function(){
	    	 selectPage();
	    	 
	     })
         
	     
	     /**
	      * 展示新增entity窗口
	      */
	     $("#showAddWindow").click(function(){
	    	  showAddWindow();
	     })
	     
	     
	     /**
	      * 导出excel
	      */
	     $("#excel-export").click(function(){
	    	 exportExcel();
	    	 
	     });
	     
	     
	     
		 /**
		  * 提交搜索表格
		  */
	     $("#formSearch").click(function(){	    	 
		    	
	    	  getform();
		    	 
	     })
	     
	     
	     /**
	      * 重置搜索条件
	      */
	     $("#searchReset").click(function(){
	    	 reset();
	    	 
	     })
	     
	     
	     
	     /**
	      * 新增entity，不带文件
	      */
		 $("#submitAdd").click(function(){
			 
			 addSaveEntity();
			  
		  }) 
		  
		  
		  /**
		   * 新增entity，带文件
		   */
		  $("#submitAddWithFile").click(function(){
			 
			 addSaveEntityWithFile();
			  
		  }); 
		  
		  
		  /**
		   * 更新entity,不带文件
		   */
		  $("#submitedit").click(function(){
			  editSaveEntity();
				
		  }) 
		 
		 /**
		  * 更新entity，带文件
		  */
		  $("#submiteditWithFile").click(function(){
			  editSaveEntityWithFile();
		  })
	     
				  
     })	

        /**
         * 跳转页码
         * @param skipToPage
         * @returns
         */
		 function  skipPage(skipToPage){ 
		    	 
	    	    var pageNum = $(".pagination>.active").text();	
	    		
	    		var pages   = $("#End").attr("data-pages");
	    	    
	    		/**
	    		 * 判断当前页，是否可以跳转
	    		 */
	    		if(pageNum == 0){
	    			return false ;
	    			
	    		}
	    		else if(skipToPage>pages||skipToPage<=0){
	    			return false;
	    		}
		 
				var targetNum = skipToPage;
				$("#currentPage").val(targetNum)
				$("#listForm").submit();
							
		} 
     
     
        /**
         * 选择页码
         */          
        function selectPage(){
        	var targetPage = $("#jumpPage").val();
        	var pages   = $("#End").attr("data-pages");
        	if(targetPage<=0 || targetPage>pages){
        		return false;
        	}
        	$("#currentPage").val(targetPage)
			$("#listForm").submit();
        
        }	
        	
        
        /**
	      * 展示新增entity窗口
	      */
        function showAddWindow(){
        	 /**
        	  * 清空值
        	  */
        	 $("#addEntity .cleanInput").val("");
        	 
        	 /**
        	  * 展示添加窗口
        	  */
        	 $("#addEntity").modal({
				  backdrop: 'static'
			 });
        }
        
        
       /**
        * 提交表格数据
        * @returns
        */
       function getform(){
	     var currentPage = 1 
	        
	       $("#listForm").submit();
    	   
       } 	
       
       
       /**
        * 导出excel
        * @returns
        */
        function exportExcel(){
        	var href = $("#excel-export").attr("data-href");
        	var dataForm = $("#listForm").serialize();
        	location.href = href + dataForm ;
        }
        
       
        
        /**
         * 删除记录
         * @param id
         * @param deleteUrl
         * @returns
         */
        function deleteByID(id,deleteUrl){
        		
        	bootbox.confirm({
                    title : "请确认",
                    buttons: {
                        confirm:{
                            label:'确认',
                            className:'btn-primary'
                        },
                        cancel:{
                            label:'取消',
                            className:'btn-default'
                        }
                    },
                    message:'是否确定删除信息？',
                    callback:function(result){
                    	if(result){        			
                			$.ajax({ 
	                  			  type:'get', 
	                  			  url:deleteUrl, 
	                  			  data:{"id":id},
	                  			  success:function(data){
	                  				 switch (data) {
	                                   case ("attributeOption"):
	                                	     setTimeout(function () { bootbox.alert("属性值已被关联到单品，不可删除")}, 500);
	                                         break;
	                                   case ("system"):
	                                	     setTimeout(function () { bootbox.alert("系统内置，不可删除")}, 500);
	                                         break;
	                                   case ("systemRoleAcl"):
	                                	     setTimeout(function () { bootbox.alert("系统内置，不可取消权限")}, 500);	                                            
	                                         break;
	                                   case ("false"):
	                                	     setTimeout(function () {bootbox.alert("删除失败")}, 500);
	                                         break;
	                                   case ("options"):
		                                     setTimeout(function () {bootbox.alert("有关联的属性值，不可删除")}, 500);
		                                     break;  
	                                   case ("childCategory"):
			                                 setTimeout(function () {bootbox.alert("有子分类，不可删除")}, 500);
			                                 break;
	                                   case ("haveAttributes"):
				                             setTimeout(function () {bootbox.alert("有属性存在，不可删除")}, 500);
				                             break;
	                                   case ("brand-spu"):
				                             setTimeout(function () {bootbox.alert("有关联Spu，不可删除")}, 500);
				                             break; 
	                                   case ("haveSku"):
				                             setTimeout(function () {bootbox.alert("有关联系列商品，不可删除")}, 500);
				                             break;
	                                   case ("onSale"):
				                             setTimeout(function () {bootbox.alert("上架商品，不可删除")}, 500);
				                             break;				                             				            			                               
	                                   case("true"):
	                                	 $('#'+id).fadeTo("slow", 0.01, function(){//fade
	                         				  $(this).slideUp(150, function() {//slide up
	                         				    $(this).remove();//then remove from the DOM
	                         				  });
	                         			 });
	                                     break;
	                                    default:
	                                    setTimeout(function () {bootbox.alert("请求失败")}, 500);	
	                                 }                  			    	
	                  			  },  
	                  			  error:function(){ 
	                  				setTimeout(function () {bootbox.alert("请求失败")}, 500);
	                  			    
	                  			  } 
                  			}); 
                			
                		}else{
                			return ;
                		}
                    },
                   className:"bootbox-sm"
             });		
          }
        
        
        /**
         * 重置搜索条件
         * @returns
         */
        function reset(){
        	$(".reset").val("");
        }
        
        
        /**
         * 需验证，异步提交表单新增entity，成功后关闭窗口返回结果
         * @returns
         */
         function addSaveEntity(){       	
        	var targetUrl = $("#addForm").attr("action");			 
  		    if($("#addForm").valid()){		    	
  			    $.ajax({    
                    type:'post',        
                    url:targetUrl,  
                    cache: false,
                    data:$("#addForm").serialize(),        
                    dataType:'json',    
                    success:function(data){
                    	if (data==true){
                    		$("#addEntity").modal('hide');
                    		   setTimeout(function () {
                    			   bootbox.alert({
                    			        message:"添加成功",
                    			        callback: function () {
                           			    //刷新页面  
                           			    setTimeout(function () {window.location.reload()}, 500);                          			      
                           			    }           			             
                    		       });
                    		   },500       
                            );          		
                    		
                    	}else
                    		bootbox.alert("添加失败");
                    	
                    },
                    error:function(){ 
                    	bootbox.alert("请求失败")
          			}
  			   })
  		    }       	
          }
         
         
         /**
          * 需验证，带文件异步提交表单新增entity，成功后关闭窗口返回结果,
          * @returns
          */
          function addSaveEntityWithFile(){
        	var formData = new FormData($( "#addForm" )[0]);
         	var targetUrl = $("#addForm").attr("action");	
   		    if($("#addForm").valid()){		    	
   			    $.ajax({    
                     type:'post',        
                     url:targetUrl,                        
                     cache: false,
                     data:formData, 
                     processData: false,
                     contentType: false,
                     dataType:'json',    
                     success:function(data){
                     	if (data==true){
                     		$("#addEntity").modal('hide');
                     		   setTimeout(function () {
                     			   bootbox.alert({
                     			        message:"添加成功",
                     			        callback: function () {
                            			    //刷新页面  
                            			    setTimeout(function () {window.location.reload()}, 500);                          			      
                            			    }           			             
                     		       });
                     		   },500       
                             );          		
                     		
                     	}else
                     		bootbox.alert("添加失败");
                     	
                     },
                     error:function(){ 
                     	bootbox.alert("请求失败")
           			}
   			   })
   		     }       	
           }
          
         
         
         
         
         
         
        
        
        /**
         * 异步提交表单修改entity，成功后刷新页面（弹窗的界面）
         * @returns
         */
        function editSaveEntity(){       	
        	var targetUrl = $("#editForm").attr("action");
        	$.ajax({    
                type:'post',        
                url:targetUrl,    
                data:$("#editForm").serialize(),    
                cache:false,    
                dataType:'json',    
                success:function(data){
                	if(data == true){
                		$('#editEntity').modal('hide');              		
                		setTimeout(function () { 
                			bootbox.alert({
                				 // buttons: {ok:{
                                //     label:'确认',
                               //    className:'btn-primary'
                              //  }},
                			    message: "修改成功",
                			    callback: function () {
                			      //刷新页面  
                			      setTimeout(function () {window.location.reload()}, 500);
                			      
                			    }
                			});
                		}, 500);
                	}else
                		bootbox.alert("修改失败");	
                	
                },
                error:function(){ 
                	bootbox.alert("请求失败")
      			}
		    })
        }
        
        
        
        /**
         * 带文件异步提交表单修改entity，成功后刷新页面（弹窗的界面）
         */
        function editSaveEntityWithFile(){
        	var formData = new FormData($( "#editForm" )[0]);
         	var targetUrl = $("#editForm").attr("action");	
   		    if($("#editForm").valid()){		    	
   			    $.ajax({    
                     type:'post',        
                     url:targetUrl,                        
                     cache: false,
                     data:formData, 
                     processData: false,
                     contentType: false,
                     dataType:'json',    
                     success:function(data){
                     	if (data==true){
                     		$("#editEntity").modal('hide');
                     		   setTimeout(function () {
                     			   bootbox.alert({
                     			        message:"修改成功",
                     			        callback: function () {
                            			    //刷新页面  
                            			    setTimeout(function () {window.location.reload()}, 400);                          			      
                            			    }           			             
                     		       });
                     		   },400       
                             );          		
                     		
                     	}else
                     		bootbox.alert("修改失败");
                     	
                     },
                     error:function(){ 
                     	bootbox.alert("请求失败")
           			}
   			   })
   		     }       	
        }
        
		
        
        /**
         * 需验证，异步提交表单更新Entity，成功后返回结果(编辑的页面)
         * @returns
         */
        function addUpdateEntity(){	        	
        	var targetUrl = $("#updateForm").attr("action");			 
  		    if($("#updateForm").valid()){		    	
  			    $.ajax({    
                    type:'post',        
                    url:targetUrl,    
                    data:$("#updateForm").serialize(),    
                    cache:false,    
                    dataType:'json',    
                    success:function(data){
                    	if (data==true){	                    			                    		  
               			   bootbox.alert({ message:"修改成功"});                 			                		
                    	}else
                    		bootbox.alert("修改失败");	                    	
                    },
                    error:function(){ 
                    	bootbox.alert("请求失败")
          			}
  			    })
  		    }       	
         }
        
        
        /**
         * 无需验证，异步提交表单更新属性选项，成功后返回结果(编辑的页面)
         * @param targetForm,form表单的id
         * @param targetUrl
         * @returns
         */
        function updateTargetEntity(targetForm,targetUrl){	
  			    $.ajax({    
                    type:'post',        
                    url:targetUrl,    
                    data:$("#"+targetForm).serialize(),    
                    cache:false,    
                    dataType:'json',    
                    success:function(data){
                    	if (data==true){	                    			                    		  
             			   bootbox.alert({ message:"修改成功"});                 			                		
                    	}else
                    		bootbox.alert("修改失败");	                    	
                    },
                    error:function(){ 
                    	bootbox.alert("请求失败")
          			}
  			    })		  		          	
         }
        
              
