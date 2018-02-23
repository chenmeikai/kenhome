/**
 * 
 */
package com.meikai.controller.admin.good;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.meikai.pageHleper.EntityPage;
import com.meikai.shop.entity.TShopAttribute;
import com.meikai.shop.entity.TShopAttributeOption;
import com.meikai.shop.entity.TShopBrand;
import com.meikai.shop.entity.TShopCategory;
import com.meikai.shop.entity.TShopCategoryAttribute;
import com.meikai.shop.entity.TShopCategoryBrand;
import com.meikai.shop.entity.TShopSku;
import com.meikai.shop.entity.TShopSkuAttributeOption;
import com.meikai.shop.entity.TShopSkuPicture;
import com.meikai.shop.entity.TShopSpu;
import com.meikai.shop.entity.TShopSpuAttributeOption;
import com.meikai.shop.entity.TShopSpuPicture;
import com.meikai.shop.entity.TSystemManager;
import com.meikai.shop.exportExcel.ExcelSpu;
import com.meikai.shop.service.AttributeService;
import com.meikai.shop.service.BrandService;
import com.meikai.shop.service.CategoryAttributeService;
import com.meikai.shop.service.CategoryBrandService;
import com.meikai.shop.service.CategoryService;
import com.meikai.shop.service.SkuAttributeOptionService;
import com.meikai.shop.service.SkuPictureService;
import com.meikai.shop.service.SkuService;
import com.meikai.shop.service.SpuAttributeOptionService;
import com.meikai.shop.service.SpuPictureService;
import com.meikai.shop.service.SpuService;
import com.meikai.util.CommonParams;
import com.meikai.util.DateUtil;
import com.meikai.util.ExcelView;
import com.meikai.util.ParameterUtils;
import com.meikai.util.PropertiesUtil;

/**
 * SPU管理
 * @author meikai
 * @version 2017年10月21日 上午11:22:27
 */
@Controller("spuController")
@RequestMapping("/admin/spu/spu/")
public class SpuController {
	
	@Resource
	private SpuService spuService ;
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private CategoryAttributeService categoryAttributeService;
	
	@Resource
	private CategoryBrandService categoryBrandService;
	
	@Resource
	private AttributeService attributeService;
	
	@Resource
	private BrandService brandService;
	
	@Resource
	private SpuAttributeOptionService spuAttrOptionService;
	
	@Resource
	private SpuPictureService spuPictureService;
	
	@Resource
	private SkuService skuService;
	
	@Resource
	private SkuAttributeOptionService skuAttrOptionService;
	
	@Resource
	private SkuPictureService skuPictureService;
	
	/**
	 * SPU中心
	 * @param request
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="main",method =RequestMethod.GET)
	public String main(HttpServletRequest request,Integer currentPage) {
		
		Integer pageSize = 10;
		
		if(currentPage==null ||currentPage <=0)currentPage =1;
				
		Map<String,Object> params =ParameterUtils.getParametersMap(request);
		
		EntityPage<TShopSpu> pageInfo =spuService.selectPlusByparamsAndPage(params,currentPage,pageSize);
		
		
	    // 获得根分类
		Long parentId=(long)0;
		List<TShopCategory> rootCategorys =categoryService.getByparamList("parentId",parentId);
		
		//根据一级select，获得二级select的选项
		 if(request.getParameter("firstValue") != null && request.getParameter("firstValue") !="") {
		 Long sonCategoryId =Long.valueOf(request.getParameter("firstValue"));
		
			 List<TShopCategory> secondCategorys =categoryService.getByparamList("parentId",sonCategoryId);
			 
			 request.setAttribute("secondCategorys", secondCategorys);
		 }
		//根据二级select，获得三级select的选项
		 if(request.getParameter("sonCategoryId") != null && request.getParameter("sonCategoryId") !="") {
		 Long categoryId =Long.valueOf(request.getParameter("sonCategoryId"));
		
			 List<TShopCategory> thirdCategorys =categoryService.getByparamList("parentId",categoryId);
			 
			 request.setAttribute("thirdCategorys", thirdCategorys);
		 }
		 
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("params", params);
        request.setAttribute("rootCategorys", rootCategorys);
        
		return "all/admin/spu/spu/spu-list";
		
	}
	
	/**
	 * 新增Spu页面
	 * @param request
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value="viewAddSpu",method =RequestMethod.GET)
	public String viewAddSpu(HttpServletRequest request,Long categoryId) {
		
		/**
		 * 分类-品牌关联集合，包括品牌名
		 */
	    List<TShopCategoryBrand>  categoryBrands = categoryBrandService.getWithNameByCategoryId(categoryId);       
	    request.setAttribute("categoryBrands", categoryBrands);
	    
	    
	    
	    /**
	     * 分类-包含属性集合，包含属性值集合
	     */
	     TShopCategory category =categoryService.getBaseWithAttrsWithOptions(categoryId);
	     request.setAttribute("category", category);
	     
	     
	     /**
	      * 分类-属性关联集合,用于获取用于价格关联的属性
	      */
	     List<TShopCategoryAttribute> categoryAttrs =categoryAttributeService.getByCategoryId(categoryId);
	     request.setAttribute("categoryAttrs", categoryAttrs);
	     
	  
		return "all/admin/spu/spu/spu-add";
		
	}
	
	
	/**
	 * 新增商品及设置属性值、添加图片
	 * @param request
	 * @param optionIds
	 * @param spuImage
	 * @param scrollImages
	 * @return
	 */
	 @RequestMapping(value="saveAdd",method=RequestMethod.POST)
	 @ResponseBody
	 public String saveAdd(HttpServletRequest request, @RequestParam("optionIds")Long[] optionIds,@RequestParam("spuImage")MultipartFile spuImage,
			@RequestParam("scrollImages")MultipartFile[] scrollImages ) {
		 
		 /**
		  * 新增Spu
		  */
		 TShopSpu addSpu =new TShopSpu();
		 addSpu.setSpuName(request.getParameter("spuName"));
		 addSpu.setSpuTitle(request.getParameter("spuTitle"));
		 addSpu.setSpuStatu(Integer.valueOf(request.getParameter("spuStatu")));
		 addSpu.setBrandId(Long.valueOf(request.getParameter("brandId")));
		 addSpu.setCategoryId(Long.valueOf(request.getParameter("categoryId")));
		 Date newDate = new Date();
		 addSpu.setCreateDate(newDate);
		 String spuNo =DateUtil.getDateFormat(newDate, "yyyyMMddHHmmss");;
		 addSpu.setSpuNo(spuNo);
		 TSystemManager manager =(TSystemManager) request.getSession().getAttribute("manager");
		 if(manager != null) addSpu.setCreater(manager.getManagerName());
		 //设置图片缩略图
		 if (spuImage!=null && spuImage.getOriginalFilename()!=null && spuImage.getOriginalFilename().trim().length()>0) {  
	   	     
				/**
				 * picture上传路径（+时间文件夹）
				 */
				//真实的上传根路径，读取存放在properties文件中的路径
			    String realUploadPath = PropertiesUtil.getProperty("realFilePath");
				 
			    //建立时间文件夹
		        SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");  
		        String datePath = sdf.format(new Date());
		        //最终真实路径
				String realuUploadBrandPath = realUploadPath+"/spu"+datePath;
				//虚拟路径
			    String  fictitiousUploadPicturePath ="/spu"+datePath;
	           			    	  
	           // 上传文件原始名称  
	           String originFileName = spuImage.getOriginalFilename();  
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
	        	   spuImage.transferTo(newFile);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	             
	           // 文件虚拟地址  
	           String fictitiousFilePath =  fictitiousUploadPicturePath+newFileName;
	           //设置访问地址
	           addSpu.setSpuImage(fictitiousFilePath);                    
	       }
		 addSpu.setSpuContent(request.getParameter("spuContent"));
		 
		 Long reply = spuService.saveAddEntity(addSpu);
		 if(reply !=1) return "false";
		 
		 /**
		  * 添加属性值
		  */
		 TShopSpu spu = spuService.getByparamList("spuNo", spuNo).get(0);
		 Long spuId = spu.getId();
		 for(Long optionId : optionIds) {
			 TShopSpuAttributeOption spuAttrOption = new TShopSpuAttributeOption();
			 spuAttrOption.setSpuId(spuId);
			 spuAttrOption.setAttributeOptionId(optionId);
			 spuAttrOptionService.saveAddEntity(spuAttrOption);
		 }
		 
		 /**
		  * 添加Spu图片
		  */
		 for(MultipartFile file : scrollImages) {
			 
			 if (file!=null && file.getOriginalFilename()!=null && file.getOriginalFilename().trim().length()>0) {  
		   	     
					/**
					 * picture上传路径（+时间文件夹）
					 */
					//真实的上传根路径，读取存放在properties文件中的路径
				    String realUploadPath = PropertiesUtil.getProperty("realFilePath");
					 
				    //建立时间文件夹
			        SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");  
			        String datePath = sdf.format(new Date());
			        //最终真实路径
					String realuUploadBrandPath = realUploadPath+"/spu"+datePath;
					//虚拟路径
				    String  fictitiousUploadPicturePath ="/spu"+datePath;
		           			    	  
		           // 上传文件原始名称  
		           String originFileName = file.getOriginalFilename();  
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
		        	   file.transferTo(newFile);
					} catch (IllegalStateException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
		             
		           // 文件虚拟地址  
		           String fictitiousFilePath =  fictitiousUploadPicturePath+newFileName;
		           
		           //新建图片对象
		           TShopSpuPicture  spuPicture = new TShopSpuPicture();
		           spuPicture.setCreateDate(newDate);
		           spuPicture.setPictureUrl(fictitiousFilePath);
		           spuPicture.setSpuId(spuId);
		           //存储到数据库
		           spuPictureService.saveAddEntity(spuPicture);		           
			 }					 
		 }		 
		 return "true";
	 }
	
	
	/**
	 * 模糊查询品牌
	 * @param brandName
	 * @return
	 */
	@RequestMapping(value="getBrand",method =RequestMethod.GET)
	@ResponseBody
	public List<TShopBrand> getBrand(String brandName) {
		
		List<TShopBrand> selectBrands =brandService.getByFuzzybrandName(brandName);
        
		return selectBrands;		
	}
	
	/**
	 * 获得子分类
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="getsonCategory",method =RequestMethod.GET)
	@ResponseBody
	public List<TShopCategory> getsonCategory(Long parentId) {
		
		List<TShopCategory> sonCategorys =categoryService.getChildrenCategorys(parentId);
        
		return sonCategorys;		
	}
	
	/**
	 * 查看spu
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="view",method =RequestMethod.GET)
	public  String view(HttpServletRequest request,Long id) {
		/**
		 * spu，包含属性，属性类型，属性值集合
		 */
		TShopSpu viewSpu =spuService.getSpuAttrOptionsById(id);
		request.setAttribute("viewSpu", viewSpu);		
		
		
	    /**
	     * 关联的图片
	     */
		List<TShopSpuPicture> spuPictures =spuPictureService.getBySpuId(id);
		request.setAttribute("spuPictures", spuPictures);
		
		
	     
		return "all/admin/spu/spu/spu-view";
		
	}
	
	
	
	/**
	 * 查看要编辑的spu
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="viewedit",method =RequestMethod.GET)
	public  String viewedit(HttpServletRequest request,Long id) {
		/**
		 * spu，包含属性，属性类型，属性值集合
		 */
		TShopSpu editSpu =spuService.getSpuAttrOptionsById(id);
		request.setAttribute("editSpu", editSpu);		
		
		/**
		 * spu拥有的属性值Id集合，用于选择出属性值
		 */
		List<Long>optionIds =new ArrayList<Long>();

			for(TShopAttribute attr :editSpu.getAttributes()) {
				
				for(TShopAttributeOption option :attr.getOptions()) {
					
					optionIds.add(option.getId());
				}			
			}
			request.setAttribute("optionIds", optionIds);		
		
	    /**
	     * 关联的图片
	     */
		List<TShopSpuPicture> spuPictures =spuPictureService.getByparamList("spuId", editSpu.getId());
		request.setAttribute("spuPictures", spuPictures);
			
		/**
		 * 分类-品牌关联集合，包括品牌名
		 */
	    List<TShopCategoryBrand>  categoryBrands = categoryBrandService.getWithNameByCategoryId(editSpu.getCategoryId());       
	    request.setAttribute("categoryBrands", categoryBrands);
			
		
		 /**
	     * 分类-包含属性集合，包含属性值集合
	     */
	     TShopCategory category =categoryService.getBaseWithAttrsWithOptions(editSpu.getCategoryId());
	     request.setAttribute("category", category);
	     
		return "all/admin/spu/spu/spu-edit";
		
	}
	
	
	
	/**
	 *  替换图片
	 * @param pictureId
	 * @param replaceFile
	 * @return
	 */
	@RequestMapping(value="replacePicture",method =RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> replacePicture(Long pictureId,MultipartFile replaceFile) {
		
		Map<String,Object> result =new  HashMap<String,Object>();
		
		 TShopSpuPicture replacespuPicture = spuPictureService.getByID(pictureId);
		
		 /**
		  * 原文件地址
		  */
	     String originalPath =PropertiesUtil.getProperty("realFilePath")+ replacespuPicture.getPictureUrl();
		
		
		if (replaceFile!=null && replaceFile.getOriginalFilename()!=null && replaceFile.getOriginalFilename().trim().length()>0) {  	   	     
			/**
			 * picture上传路径（+时间文件夹）
			 */
			//真实的上传根路径，读取存放在properties文件中的路径
		    String realUploadPath = PropertiesUtil.getProperty("realFilePath");
			 
		    //建立时间文件夹
	        SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");  
	        String datePath = sdf.format(new Date());
	        //最终真实路径
			String realuUploadBrandPath = realUploadPath+"/spu"+datePath;
			//虚拟路径
		    String  fictitiousUploadPicturePath ="/spu"+datePath;
           			    	  
           // 上传文件原始名称  
           String originFileName = replaceFile.getOriginalFilename();  
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
        	   replaceFile.transferTo(newFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
             
           // 文件虚拟地址  
           String fictitiousFilePath =  fictitiousUploadPicturePath+newFileName;
           
           //设置图片地址
           replacespuPicture.setPictureUrl(fictitiousFilePath);
           
           //存储到数据库
           Long reply = spuPictureService.updateEntity(replacespuPicture);		
           
           if(reply== 1) {    	    
  		        //删除旧文件
  		         File oldFile = new File(originalPath);
  		         if(oldFile.exists()&&oldFile.isFile()) oldFile.delete();
  		        result.put("valid", "true");
  		        result.put("target", fictitiousFilePath);
  			    return result;
  		    }
  		    else
  		      //删除新传文件	 
  			  if(newFile.exists()&&newFile.isFile()) newFile.delete();
              result.put("valid", "false");
  		      return result;
	   }		        
		result.put("valid", "false");
	    return result;	
	}
	
	
		
	/**
	 * 新增图片
	 * @param request
	 * @param spuId
	 * @param addFile
	 * @return
	 */
	@RequestMapping(value="addPicture",method =RequestMethod.POST)
	public @ResponseBody  Map<String,Object> addPicture(HttpServletRequest request,Long spuId,MultipartFile addFile){
		
		Map<String,Object> result =new  HashMap<String,Object>();
		
		/**
		 * 判断关联图片数量是否大于等于6
		 */
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("spuId", spuId);
		Long nums =spuPictureService.countByparames(params);
		if(nums >=6) {
			result.put("valid", "enough");
			return result;
		}
		
		
		/**
		 * new一个分类对象
		 */
		TShopSpuPicture newspuPicture = new TShopSpuPicture();
		
		/**
		 * 创建时间
		 */
		Date createDate = new Date();
		newspuPicture.setCreateDate(createDate);
		

		/**
		 * 设置Spu id
		 */
		newspuPicture.setSpuId(spuId);
			
		
		 /**
		  * 设置创建人
		  */
		 TSystemManager creator = (TSystemManager) request.getAttribute("manager");
		 if (creator != null) newspuPicture.setCreater(creator.getManagerName());
			 
		 
		 if (addFile!=null && addFile.getOriginalFilename()!=null && addFile.getOriginalFilename().trim().length()>0) {  	   	     
				/**
				 * picture上传路径（+时间文件夹）
				 */
				//真实的上传根路径，读取存放在properties文件中的路径
			    String realUploadPath = PropertiesUtil.getProperty("realFilePath");
				 
			    //建立时间文件夹
		        SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");  
		        String datePath = sdf.format(new Date());
		        //最终真实路径
				String realuUploadBrandPath = realUploadPath+"/spu"+datePath;
				//虚拟路径
			    String  fictitiousUploadPicturePath ="/spu"+datePath;
	           			    	  
	           // 上传文件原始名称  
	           String originFileName = addFile.getOriginalFilename();  
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
	        	   addFile.transferTo(newFile);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	             
	           // 文件虚拟地址  
	           String fictitiousFilePath =  fictitiousUploadPicturePath+newFileName;
	           
	           //设置图片地址
	           newspuPicture.setPictureUrl(fictitiousFilePath);
	           
	           //存储到数据库
	           Long reply = spuPictureService.saveAddEntity(newspuPicture);		
	           
	           if(reply== 1) {    
	        	   result.put("valid", "true");
	        	   result.put("target", PropertiesUtil.getProperty("fictitiousRoot")+fictitiousFilePath);
	  			     return result ;
	  		    }
	  		    else
	  		      //删除新传文件	 
	  			  if(newFile.exists()&&newFile.isFile()) newFile.delete();	
	              result.put("valid", "false");
	  		      return result;
		   }		        
		 
		 result.put("valid", "false");
		 return result;
	}
	
	
	/**
	 * 修改Spu基本信息
	 * @param request
	 * @param id
	 * @param spuName
	 * @param spuTitle
	 * @param brandId
	 * @param spuStatu
	 * @param spuImage
	 * @return
	 */
	@RequestMapping(value="saveUpdateSpu",method =RequestMethod.POST)
	public @ResponseBody  String saveEdit(HttpServletRequest request,Long id,String spuName,String spuTitle,
		  Long brandId,Integer spuStatu,MultipartFile spuImage){
		
		System.out.println("获得ID："+id);
		
		/**
		 * 要修改的Spu对象
		 */
		TShopSpu editSpu = spuService.getByID(id);
		
		/**
		 * 日志留存原商品内容
		 */
		String logContent ="更新了的商品编号："+editSpu.getSpuNo()+"\n"+"原商品内容："+editSpu.toString();
		

		/**
		 * 更新时间
		 */
		 Date updateDate = new Date();		
		/**
		 * 设置更新时间
		 */
		 editSpu.setUpdateDate(updateDate);
					
		/**
		 * 设置更新人
		 */
		 TSystemManager updater = (TSystemManager) request.getAttribute("manager");
		 if (updater != null) editSpu.setUpdater(updater.getManagerName());
		 
		 
		 /**
		  * 设置名称
		  */		
		 if(spuName !=null && spuName != "")editSpu.setSpuName(spuName);;
		 
		 /**
		  * 设置标题
		  */
		 if(spuTitle !=null && spuTitle != "")editSpu.setSpuTitle(spuTitle);
		 
		 /**
		  * 设置品牌
		  */
		 		
		 editSpu.setBrandId(brandId);
		 
		 /**
		  * 设置状态
		  */
		 editSpu.setSpuStatu(spuStatu);
		 
		 /**
		  * 缩略图原文件路径
		  */
		 String originalPath =PropertiesUtil.getProperty("realFilePath")+ editSpu.getSpuImage();
		 
		 /**
		  * 更新缩略图
		  */
		 if (spuImage!=null && spuImage.getOriginalFilename()!=null && spuImage.getOriginalFilename().trim().length()>0) {  
	   	     
				/**
				 * picture上传路径（+时间文件夹）
				 */
				//真实的上传根路径，读取存放在properties文件中的路径
			    String realUploadPath = PropertiesUtil.getProperty("realFilePath");
				 
			    //建立时间文件夹
		        SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");  
		        String datePath = sdf.format(new Date());
		        //最终真实路径
				String realuUploadBrandPath = realUploadPath+"/spu"+datePath;
				//虚拟路径
			    String  fictitiousUploadPicturePath ="/spu"+datePath;
	           			    	  
	           // 上传文件原始名称  
	           String originFileName = spuImage.getOriginalFilename();  
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
	        	   spuImage.transferTo(newFile);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	             
	           // 文件虚拟地址  
	           String fictitiousFilePath =  fictitiousUploadPicturePath+newFileName;
	           //设置访问地址
	           editSpu.setSpuImage(fictitiousFilePath);  
	           
	           Long reply = spuService.updateEntity(editSpu);
	           if(reply == 1) {
	        	   //删除旧文件
	  		         File oldFile = new File(originalPath);
	  		         if(oldFile.exists()&&oldFile.isFile()) oldFile.delete();		   		       		    	
	  			     return  PropertiesUtil.getProperty("fictitiousRoot")+fictitiousFilePath;
	  		    }
	  		    else
	  		      //删除新传文件	 
	  			  if(newFile.exists()&&newFile.isFile()) newFile.delete();	 
	  		      return "false";
	     }
		 		 
		 /**
		  * 更新Spu
		  */
		 Long reply = spuService.updateEntity(editSpu);
		 
		 if(reply == 1) {
			 //存入日志内容
			 request.setAttribute(CommonParams.LOG_ATTRIBUTE, logContent);
			 return "true";
		 }
		 else return "false";		 
	}
	
	
	/**
	 * 修改spu属性
	 * @param spuId
	 * @param optionIds
	 * @return
	 */
	@RequestMapping(value="saveUpdateSpuOption",method =RequestMethod.POST)
	public @ResponseBody  boolean saveUpdateSpuOption(Long spuId,Long[] optionIds){
		
		/**
		 * 如果属性值为零，则返回false
		 */
		if(optionIds ==null || optionIds.length == 0) return false;
		
		/**
		 * 原有的属性值关联Id集合，和属性值集合Id
		 */
		List<TShopSpuAttributeOption> spuOptions = spuAttrOptionService.getByparamList("spuId", spuId);
		//原有spu属性关联Id集合
		List<Long> oldSpuOptionIds = new ArrayList<Long>();
		List<Long> oldOptionIds = new ArrayList<Long>();
		for(TShopSpuAttributeOption spuOption :spuOptions) {
			oldSpuOptionIds.add(spuOption.getId());
			oldOptionIds.add(spuOption.getAttributeOptionId());
		}
		
		
		/**
		 * 删除原有的属性值关联
		 */
		spuAttrOptionService.deleteSome(oldSpuOptionIds);
		
		/**
		 * 重新关联
		 */
		for(Long newOptionId :optionIds ) {
			
			TShopSpuAttributeOption newSpuOption = new TShopSpuAttributeOption();			
			newSpuOption.setSpuId(spuId);
            newSpuOption.setAttributeOptionId(newOptionId);			
			spuAttrOptionService.saveAddEntity(newSpuOption);			
		}
	    		
		return true;
	}
	
	
	/**
	 * 修改介绍
	 * @param request
	 * @param spuId
	 * @param spuContent
	 * @return
	 */
	@RequestMapping(value="saveUpdateSpuContent",method =RequestMethod.POST)
	public @ResponseBody  boolean saveUpdateSpuContent(HttpServletRequest request,Long spuId,String spuContent){
		
		/**
		 * 如果介绍为零，则返回false
		 */
		System.out.println("获得的id是："+spuId);
		System.out.println("获得的content是："+spuContent);
		if(spuContent == null) return false;
		
		TShopSpu spu = spuService.getByID(spuId);
		
		/**
		 * 设置介绍
		 */
		spu.setSpuContent(spuContent);
		
		/**
		 * 更新时间
		 */
		 Date updateDate = new Date();		
		/**
		 * 设置更新时间
		 */
		 spu.setUpdateDate(updateDate);
					
		/**
		 * 设置更新人
		 */
		 TSystemManager updater = (TSystemManager) request.getAttribute("manager");
		 if (updater != null) spu.setUpdater(updater.getManagerName());
		
		Long reply = spuService.updateEntity(spu);
		
		if(reply ==1)return true;
		
		return false;
	}
	
	
	/**
	 * 查看关联sku	
	 * @param request
	 * @param spuId
	 * @return
	 */
	@RequestMapping(value="linkSku",method =RequestMethod.GET)
	public String linkSku(HttpServletRequest request,Long spuId){
		
		TShopSpu spu =spuService.getSpuAttrOptionsById(spuId);
		
		request.setAttribute("spu", spu);
		if(spuId != null && spuId !=0) {
			List<TShopSku> linkSkus =skuService.getplusBySpuId(spuId);
			request.setAttribute("linkSkus", linkSkus);
		}
		
		
		return "all/admin/spu/spu/spu-sku";
	}
	
	
	/**
	 * 新增sku
	 */
	@RequestMapping(value="saveAddSku",method =RequestMethod.POST)
	@ResponseBody
	public String saveAddSku(HttpServletRequest request,Long spuId,String skuName,String memo,Long[] optionId,BigDecimal originalPrice,
			Long stocks,double discountRate,BigDecimal salePrice,Integer integration,Integer skuStatu,
			MultipartFile[] scrollImages,MultipartFile picture){
		
		/**
		 * 判断关键属性值、缩略图、关联图片是否为空，空则返回
		 */
		if(optionId == null) return "option";
		if(scrollImages == null) return "scrollImages";
		if(picture == null) return "picture";
		
		TShopSpu spu =spuService.getSpuAttrOptionsById(spuId);
		
		TShopSku newSku = new TShopSku();
			
		//创建时间
		Date createDate = new Date();
		newSku.setCreateDate(createDate);
		//创建人
		TSystemManager creator = (TSystemManager) request.getAttribute("manager");
		if (creator != null) newSku.setCreater(creator.getManagerName());
		//Spu id
		newSku.setSpuId(spuId);
		//商品编号
		String skuNo =DateUtil.getDateFormat(createDate, "yyyyMMddHHmmss");
		newSku.setSkuNo(skuNo);
		//商品名
		newSku.setSkuName(skuName);
		//分类Id
		newSku.setCategoryId(spu.getCategoryId());
		//品牌Id
		newSku.setBrandId(spu.getBrandId());
		//备注
		newSku.setMemo(memo);
		//原价
		newSku.setOriginalPrice(originalPrice);
		//库存
		newSku.setStocks(stocks);
		//折扣
		newSku.setDiscountRate(discountRate);
		//促销价
		newSku.setSalePrice(salePrice);
		//积分
		newSku.setIntegration(integration);
		//状态
		newSku.setSkuStatu(skuStatu);
		/**
		 * 缩略图
		 */
		 if (picture!=null && picture.getOriginalFilename()!=null && picture.getOriginalFilename().trim().length()>0) {  
	   	     
				/**
				 * picture上传路径（+时间文件夹）
				 */
				//真实的上传根路径，读取存放在properties文件中的路径
			    String realUploadPath = PropertiesUtil.getProperty("realFilePath");
				 
			    //建立时间文件夹
		        SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");  
		        String datePath = sdf.format(createDate);
		        //最终真实路径
				String realuUploadBrandPath = realUploadPath+"/sku"+datePath;
				//虚拟路径
			    String  fictitiousUploadPicturePath ="/sku"+datePath;
	           			    	  
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
	           String fictitiousFilePath =  fictitiousUploadPicturePath+newFileName;
	           //设置访问地址
	           newSku.setPicture(fictitiousFilePath);  
	           
	           Long reply =skuService.saveAddEntity(newSku);
	           if(reply == 1) {	
	        	   
	        	   /**
	        	    * 更改SPU库存
	        	    */
	        	    if(newSku.getStocks() > 0) {
	        	    	TShopSpu updateSpu =spuService.getByID(newSku.getSpuId());
	        	    	Long resultStocks = updateSpu.getStocks()+newSku.getStocks();
	        	    	updateSpu.setStocks(resultStocks);
	        	    	spuService.updateEntity(updateSpu);
	        	    }
	        	          	   
	        	   /**
	        	    * 新增sku成功后，则添加关键属性值关联
	        	    */
	        	   TShopSku linkSku = skuService.getByUniqueCode(skuNo);	
	        	   
	        	   for(Long optionID :optionId) {
	        		   TShopSkuAttributeOption skuAttrOption = new TShopSkuAttributeOption();
	        		   skuAttrOption.setSkuId(linkSku.getId());
	        		   skuAttrOption.setOptionId(optionID);
	        		   skuAttrOptionService.saveAddEntity(skuAttrOption);
	        	   }
	        	   
	        	   /**
	        	    * 图片关联
	        	    */
	        	   System.out.println("关联图片数量："+scrollImages.length);
	        	   for(MultipartFile scrollImage :scrollImages) {
	        		   
	        		     //新建关联对象
	        		     TShopSkuPicture skuPicture = new TShopSkuPicture();
	        		     
	        		     /**
	     				 * picture上传路径（+时间文件夹）
	     				 */
	     				//真实的上传根路径，读取存放在properties文件中的路径
	     			    String realUploadPath2 = PropertiesUtil.getProperty("realFilePath");
	     				 
	     			    //建立时间文件夹
	     		        SimpleDateFormat sdf2=new SimpleDateFormat("/yyyy/MM/dd/");  
	     		        String datePath2 = sdf2.format(createDate);
	     		        //最终真实路径
	     				String realuUploadBrandPath2 = realUploadPath2+"/sku"+datePath2;
	     				//虚拟路径
	     			    String  fictitiousUploadPicturePath2 ="/sku"+datePath2;
	     	           			    	  
	     	           // 上传文件原始名称  
	     	           String originFileName2 = scrollImage.getOriginalFilename();  
	     	           // 新的文件名称  
	     	           String newFileName2 = UUID.randomUUID()+originFileName2.substring(originFileName2.lastIndexOf(".")); 
	     	           
	     	             
	     	           //如果路径文件夹不存在就创建  
	     	           File dir2=new File(realuUploadBrandPath2);  
	     	           if(!dir2.exists()){  
	     	               dir2.mkdirs();  
	     	           } 
	     	                       
	     	           // 新文件  
	     	           File newFile2 = new File(realuUploadBrandPath2+File.separator+newFileName2);  
	     	             
	     	           // 将内存中的文件写入磁盘  
	     	           try {
	     	        	  scrollImage.transferTo(newFile2);
	     				} catch (IllegalStateException | IOException e) {
	     					// TODO Auto-generated catch block
	     					e.printStackTrace();
	     				}  
	     	             
	     	           // 文件虚拟地址  
	     	           String fictitiousFilePath2 =  fictitiousUploadPicturePath2+newFileName2;
	     	           //设置访问地址
	     	           skuPicture.setPictureUrl(fictitiousFilePath2);
	     	          //设置关联SkuId
	     	           skuPicture.setSkuId(linkSku.getId());
	     	           skuPictureService.saveAddEntity(skuPicture);	        		     	        		   
	        	   }
	  			   return "true";
	  		    }
	  		    else
	  		      //删除新传文件	 
	  			  if(newFile.exists()&&newFile.isFile()) newFile.delete();	 
	  		      return "false";
	     }
		
		return "picture";
	}
	
	
	
	/**
	 * 删除，若有关联商品则不可删除，则不可删除；若无，则可以删除。
	 * @param spuId
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public @ResponseBody String deleteByID(@RequestParam("id")Long spuId){
		
		/**
		 * 判定有无系列商品，有则不删除
		 */
		List<TShopSku> skus = skuService.getBySpuId(spuId);
		
		if(skus !=null && !skus.isEmpty()) return "haveSku";
		
		
		/**
		 * 删除关联的图片
		 */
		List<TShopSpuPicture> spuPictures =spuPictureService.getBySpuId(spuId);
		if(spuPictures != null) {			
			for(TShopSpuPicture spuPicture :spuPictures) {
				String filePath =PropertiesUtil.getProperty("realFilePath") + spuPicture.getPictureUrl();
				File file =new File(filePath);
				if(file.exists()&&file.isFile()) file.delete();
				spuPictureService.delete(spuPicture.getId());
			}			
		}
		
		/**
		 * 删除关联的关键属性
		 */
		spuAttrOptionService.deleteBySpuId(spuId);
		
		
		/**
		 * 删除缩略图以及SPU
		 */
		 TShopSpu deleteSpu = spuService.getByID(spuId);
		 String  imagePath =PropertiesUtil.getProperty("realFilePath") + deleteSpu.getSpuImage();
		 File deleteImage =new File(imagePath);
		 if(deleteImage.exists()&&deleteImage.isFile()) deleteImage.delete();
		 Long reply = spuService.delete(spuId);
		 if(reply == 1)  return "true";
		 return "false";
		
	}
	
	
	
	/**
	 * 导出excel表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="export",method = RequestMethod.GET)
	public ExcelView export(HttpServletRequest request) {
		
			
		Map<String, Object> params = ParameterUtils.getParametersMap(request);
		
		List<TShopSpu> spus= spuService.selectPlusByparams(params);
		
		ExcelSpu excelspu = new ExcelSpu();
		
		List<ExcelSpu> excelspus = excelspu.build(spus);
				
		
		return new ExcelView("Spu.xls", "Spu", new String[]{"id","spuNo","spuName","spuStatu","spuImage","categoryId","categoryName","brandId","brandName","spuContent","createDate","updateDate"},
				new String[]{"ID","编号","名称","状态","图片","分类Id","分类名","品牌Id","品牌名","介绍","创建时间","更新时间"},   new Integer[]{5000,5000,15000,5000,15000,5000,5000,5000,5000,10000,8000,8000}, null, excelspus, null);
		
		
	}
	

}