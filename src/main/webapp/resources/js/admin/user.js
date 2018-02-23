/**
 * 
 * 管理员js
 * 
 */

     $().ready(function(){
    	 
	     //时间插件
	     $('#registerDate').datetimepicker({
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
	     $('#registerDate2').datetimepicker({
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
	     
	     
	     //跳转页面
	     $("#slectPage").click(function(){
	    	 selectPage();
	    	 
	     })
         
	     
	     //导出excel
	     $("#excel-export").click(function(){
	    	 exportExcel();
	    	 
	     });
	     
	     
	     
		 //提交表格
	     $("#formSearch").click(function(){	    	 
		    	
	    	  getform();
		    	 
		     })
				  
     })	

      //跳转页码
		function  skipPage(skipToPage){   	 
			var pageNum = skipToPage;
			$("#currentPage").val(pageNum)
			$("#listForm").submit();
						
		} 
                  
        function selectPage(){       	
        	var targetPage = $("#jumpPage").val();
        	$("#currentPage").val(targetPage)
			$("#listForm").submit();
        
        }	
        	
       //提交表格数据
       function getform(){
	     var currentPage = 1 
	        
	       $("#listForm").submit();
    	   
       } 	
       
       
       //导出excel
        function exportExcel(){
        	
        	var dataForm = $("#listForm").serialize();
        	location.href = "/kenhome/admin/user/export?"+dataForm ;
        }
        
       
        
      //删除用户
        function deleteUser(id){
        	var user_id=id;
        	var message="确定删除该用户？"
        	bootbox.confirm(message,function(result){
        		
        		if(result){        			
        			$.ajax({ 
          			  type:'get', 
          			  url:'/kenhome/admin/user/delete', 
          			  data:{"user_id":user_id},
          			  success:function(data){ 
          			    $('#user'+user_id).slideUp(2000,function(){
          			    	$('#user'+user_id).remove();
          			    });           			    
          			  },  
          			  error:function(){ 
          			    alert("fall")
          			  } 
          			}); 
        			
        		}else{
        			return ;
        		}
        		
        	})
        	
        	
        		       	
            	
        		
        		
        		
        	
        	
        	
        	
        	
        }
        
 
              
