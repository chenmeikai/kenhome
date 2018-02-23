/**
 * 
 */
package com.meikai.controller.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.meikai.util.PropertiesUtil;

/**
 * 文件控制器
 * @author meikai
 * @version 2017年10月26日 下午5:16:09
 */
@Controller
@RequestMapping("/admin/common/file")
public class FileController {
	
	/**
	 * 文本上传图片
	 * @param picture
	 * @return
	 */
	@RequestMapping(value="contentFileUpload",method=RequestMethod.POST)
	@ResponseBody
	public String contentFileUpload(MultipartFile picture) {
	
		if (picture!=null && picture.getOriginalFilename()!=null && picture.getOriginalFilename().trim().length()>0) {  
		   	     
			/**
			 * picture上传路径（+时间文件夹）
			 */
			//真实的上传根路径，读取存放在properties文件中的路径
		    String realUploadPath = PropertiesUtil.getProperty("realFilePath");
			 
		    //建立时间文件夹
	        SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");  
	        String datePath = sdf.format(new Date());
	        //最终真实路径
			String realuUploadBrandPath = realUploadPath+"/content"+datePath;
			//虚拟路径
		    String  fictitiousUploadBrandPath ="/content"+datePath;
           			    	  
           // 上传文件原始名称  
           String originFileName = picture.getOriginalFilename();  
           // 新的文件名称  
           String newFileName = UUID.randomUUID()+originFileName.substring(originFileName.lastIndexOf(".")); 
           
             
           //如果路径文件夹不存在就创建  
           File dir=new File(realuUploadBrandPath);  
           if(!dir.exists()){  
               dir.mkdirs();  
           } 
                       
           // 新文件  
           File newFile = new File(realuUploadBrandPath+File.separator+newFileName);  
             
           // 将内存中的文件写入磁盘  
           try {
				picture.transferTo(newFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
             
           // 文件虚拟地址  
           String fictitiousFilePath =  fictitiousUploadBrandPath+newFileName;  	
           return fictitiousFilePath;                    
       }
		
	  return "false";	
		
	}
	

}
