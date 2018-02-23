/**
 * 
 */
package com.meikai.controller.admin.good;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.entity.TShopBrand;
import com.meikai.shop.entity.TShopSpu;
import com.meikai.shop.service.AttributeService;
import com.meikai.shop.service.BrandService;
import com.meikai.shop.service.CategoryAttributeService;
import com.meikai.shop.service.CategoryService;
import com.meikai.shop.service.SpuService;
import com.meikai.util.FileTypeUtil;
import com.meikai.util.ParameterUtils;
import com.meikai.util.PropertiesUtil;



/**
 * 品牌管理
 * @author meikai
 * @version 2017年10月21日 上午11:22:27
 */
@Controller("brandController")
@RequestMapping("/admin/spu/brand/")
public class BrandController {
	
	@Resource
	private BrandService brandService;
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private CategoryAttributeService categoryAttributeService;
	
	@Resource
	private AttributeService attributeService;
	
	@Resource
	private SpuService spuService;
	
	
	/**
	 * 品牌管理
	 * @param request
	 * @return
	 */
	@RequestMapping(value="main",method =RequestMethod.GET)
	public String main(HttpServletRequest request,Integer currentPage) {
		
		int pageSize = 10;
		
		if(currentPage ==null || currentPage <=0) currentPage = 1 ;
		
		Map<String, Object> params = ParameterUtils.getParametersMap(request);
		
        EntityPage<TShopBrand> pageInfo =brandService.getByParamesAndPage(params, currentPage, pageSize);
		
        request.setAttribute("pageInfo", pageInfo);
        
        request.setAttribute("params", params);
        
		return "all/admin/spu/brand/brand-list";
		
	}
	
	
	/**
	 * 查看品牌
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="view",method= {RequestMethod.GET})
	public  String view(Long id,HttpServletRequest request){
		
		TShopBrand viewBrand =brandService.getByID(id);
		
		request.setAttribute("viewBrand", viewBrand);
		return "all/admin/spu/brand/brand-view";
		
	}
	
	
	
	/**
	 * 查看要编辑的品牌
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="viewEditBrand",method =RequestMethod.GET)
	public  String viewEditCatagory(HttpServletRequest request,Long id) {
		
        TShopBrand viewEditBrand =brandService.getByID(id);
		
		request.setAttribute("viewEditBrand", viewEditBrand);
		
		return "all/admin/spu/brand/brand-editview";
			
		
		
	}
	
	
	/**
	 * 判定品牌名是否已经存在(新增品牌)
	 */
	 @RequestMapping(value="validateName",method=RequestMethod.GET)
	 @ResponseBody
	 public boolean validateName(String brandName) {
		 
		 TShopBrand validateBrand = brandService.getByUniqueName(brandName);
		 
		 if(validateBrand != null) return false ;
		 
		 return true;
	 }
	

	/**
	 * 新增
	 * 
	 */
	@RequestMapping(value="saveAdd",method =RequestMethod.POST)
	public @ResponseBody  boolean saveAdd(HttpServletRequest request,String brandName,String enName,String aliasName,
			MultipartFile  logo,String description,Integer statu){
		
		
//	    /**
//	     * 判定图片是否符合要求,有点问题
//	     */	
//	    //判定是否为图片
//	    Boolean flag=  FileTypeUtil.isImageforMultipartFile(logo);
//
//	    if(!flag) return false ;
//	  
//	    //判定是否符合格式：jpg、jpeg、bmp、png
//	    String type = FileTypeUtil.getTypeForImageMultipartFile(logo);
//	    if(!type.equalsIgnoreCase("jpg") && !type.equalsIgnoreCase("jpeg") && !type.equalsIgnoreCase("bmp") && !type.equalsIgnoreCase("png")) return false;	  
//	    //图片大小要小于2mb
//	    if(logo.getSize()>2097152) return false ;
		
		
		/**
		 * new一个品牌对象
		 */
		TShopBrand newbrand = new TShopBrand();
		
		/**
		 * 设置品牌中文名字
		 */
		newbrand.setBrandName(brandName);		
		/**
		 * 设置品牌英文名字
		 */
		newbrand.setEnName(enName);
		
		/**
		 * 设置品牌别字
		 */
		newbrand.setAliasName(aliasName);
		/**
		 * 设置品牌介绍
		 */
		newbrand.setDescription(description);
		/**
		 * 设置品牌启用状态
		 */
		newbrand.setStatu(statu);
							 		 
		/**
		 * 设置创建时间
		 */
		 newbrand.setCreateDate( new Date());
		 
		 /**
		  * Logo上传路径（+时间文件夹）
		  */
		 //真实的上传根路径，读取存放在properties文件中的路径
		 String realUploadPath = PropertiesUtil.getProperty("realFilePath");
		 
		 //建立时间文件夹
         SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");  
         String datePath = sdf.format(new Date());
         //最终真实路径
		 String realuUploadBrandPath = realUploadPath+"/brand"+datePath;
		 //虚拟路径
		 String  fictitiousUploadBrandPath ="/brand"+datePath;
				 
		 					       
		 /**
		  * 上传logo图片
		  */
		 if (logo!=null && logo.getOriginalFilename()!=null && logo.getOriginalFilename().trim().length()>0) {  
	            			    	  
	            // 上传文件原始名称  
	            String originFileName = logo.getOriginalFilename();  
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
					logo.transferTo(newFile);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	              
	            // 文件上传成功，将文件的虚拟地址写入数据库  
	            newbrand.setLogo(fictitiousUploadBrandPath+newFileName);  
	            
	            Long reply = brandService.saveAddEntity(newbrand);
	   		    if(reply== 1) {
	   			 
	   			 return true;
	   		    }
	   		    
	   		 else
	   			 if(newFile.exists() && newFile.isFile()) newFile.delete();
	   			 return false;
	        }
		return false; 
		 		 
		 
		 
		 
	}
	
	
	
	/**
	 * 判定品牌名是否已经存在(修改品牌)
	 */
	 @RequestMapping(value="validateEditName",method=RequestMethod.GET)
	 @ResponseBody
	 public boolean validateEditName(Long id,String brandName) {
		 
		 TShopBrand validateBrand = brandService.getByUniqueName(brandName);
		 
		 if(validateBrand != null) {
			 if(validateBrand.getId()==id)return true;
			 
			 return false ;
		 }
		 
		 return true;
	 }
	
	
	
	/**
	 * 修改品牌
	 * 
	 */
	@RequestMapping(value="saveEdit",method =RequestMethod.POST)
	public @ResponseBody  boolean saveEdit(HttpServletRequest request,Long id,String brandName,String enName,String aliasName,
			MultipartFile  logo,String description,Integer statu){
		
		/**
		 * 要修改的品牌对象
		 */
		TShopBrand editBrand = brandService.getByID(id);
		
					
		/**
		 * 设置更新时间
		 */
		 Date updateDate = new Date();
		 editBrand.setUpdateDate(updateDate);
									 
		 
		 /**
		  * 设置名称
		  */
		 editBrand.setBrandName(brandName);
		 /**
		  * 设值英文名
		  */
		 editBrand.setEnName(enName);
		 /**
		  * 设值别名
		  */
		 editBrand.setAliasName(aliasName);
		 /**
		  * 设置描述
		  */
		 editBrand.setDescription(description);
		 /**
		  * 设置启用状态
		  */
		 editBrand.setStatu(statu);
		 
		 
		
		
		 /**
		  * 设置logo
		  */
		 
		 if (logo!=null && logo.getOriginalFilename()!=null && logo.getOriginalFilename().trim().length()>0) {  
			    
				 /**
				  * 原文件地址
				  */
			     String originalPath =PropertiesUtil.getProperty("realFilePath")+ editBrand.getLogo();
			     
				/**
				 * Logo上传路径（+时间文件夹）
				 */
				//真实的上传根路径，读取存放在properties文件中的路径
			    String realUploadPath = PropertiesUtil.getProperty("realFilePath");
				 
			    //建立时间文件夹
		        SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");  
		        String datePath = sdf.format(new Date());
		        //最终真实路径
				String realuUploadBrandPath = realUploadPath+"/brand"+datePath;
				//虚拟路径
			    String  fictitiousUploadBrandPath ="/brand"+datePath;
	            			    	  
	            // 上传文件原始名称  
	            String originFileName = logo.getOriginalFilename();  
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
					logo.transferTo(newFile);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	              
	            // 文件上传成功，设置文件虚拟地址  
	            editBrand.setLogo(fictitiousUploadBrandPath+newFileName);  	
	            
	            
	            /**
	             * 已更新文件，须删除原文件
	             */
	            Long reply = brandService.updateEntity(editBrand);
	   		    if(reply== 1) {
	   		        //删除旧文件
	   		         File oldFile = new File(originalPath);
	   		         if(oldFile.exists()&&oldFile.isFile()) oldFile.delete();		   		       		    	
	   			     return true;
	   		    }
	   		    else
	   		      //删除新传文件	 
	   			  if(newFile.exists()&&newFile.isFile()) newFile.delete();	 
	   		      return false;
	            
	        }
		 
		 /**
		  * 未更新文件，不可删除原文件
		  */
		 Long reply = brandService.updateEntity(editBrand);
		 if(reply== 1) {	   		       		    	
			     return true;
		 }
		 else
		    return false;
		
		 
	}
	
		
	
	/**
	 * 删除品牌，删除时，需校验该品牌是否有关联商品，若有，则不可删除；若无，则可以删除。
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public @ResponseBody String deleteByID(Long id){
		
		/**
		 * 判定有无关联商品，有则不删除
		 */
		List<TShopSpu> spus = spuService.getByBrandId(id);
		 if(!spus.isEmpty())
			return "brand-spu";
		
		/**
		 * 删除品牌
		 */
		Long reply =categoryService.delete(id);
		if(reply ==1) {
			return "true";
		}
		else return "false";
		
	}
		

}