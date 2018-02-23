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
import com.meikai.shop.entity.TShopCategory;
import com.meikai.shop.entity.TShopSku;
import com.meikai.shop.entity.TShopSkuAttributeOption;
import com.meikai.shop.entity.TShopSkuPicture;
import com.meikai.shop.entity.TShopSpu;
import com.meikai.shop.entity.TShopSpuPicture;
import com.meikai.shop.exportExcel.ExcelSku;
import com.meikai.shop.service.CategoryService;
import com.meikai.shop.service.SkuAttributeOptionService;
import com.meikai.shop.service.SkuPictureService;
import com.meikai.shop.service.SkuService;
import com.meikai.shop.service.SpuPictureService;
import com.meikai.shop.service.SpuService;
import com.meikai.util.ExcelView;
import com.meikai.util.ParameterUtils;
import com.meikai.util.PropertiesUtil;

/**
 * 商品管理
 * @author meikai
 * @version 2017年11月1日 上午10:00:58
 */
@Controller
@RequestMapping("/admin/sku/sku")
public class SkuController {
	
	@Resource
	private SkuService skuService;
	
	@Resource
	private SkuPictureService skuPictureService;
	
	@Resource
	private SpuService spuService;

	@Resource
	private SpuPictureService spuPictureService;
	
	@Resource
	private SkuAttributeOptionService skuAttrOptionService;
	
	@Resource CategoryService categoryService;
	
	
	
	/**
	 * SKU中心
	 * @param request
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="main",method =RequestMethod.GET)
	public String main(HttpServletRequest request,Integer currentPage) {
		
		Integer pageSize = 10;

		if(currentPage==null ||currentPage <=0)currentPage =1;
				
		Map<String,Object> params =ParameterUtils.getParametersMap(request);
		
		EntityPage<TShopSku> pageInfo =skuService.getByParamesAndPage(params, currentPage, pageSize);
		
		
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
        
		return "all/admin/sku/sku-list";
		
	}
	
	
	/**
	 * SKU删除中心
	 * @param request
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value="deleteList",method =RequestMethod.GET)
	public String deleteList(HttpServletRequest request,Integer currentPage) {
		
		Integer pageSize = 10;

		if(currentPage==null ||currentPage <=0)currentPage =1;
				
		Map<String,Object> params =ParameterUtils.getParametersMap(request);
		
		EntityPage<TShopSku> pageInfo =skuService.getByParamesAndPage(params, currentPage, pageSize);
		
		
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
        
		return "all/admin/sku/sku-deleteList";
		
	}
	
	

	/**
	 * 查看sku详情
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("view")
	public String view(HttpServletRequest request,Long id) {
		
		/**
		 * 商品
		 */
		TShopSku viewSku = skuService.getPlusById(id);		
		request.setAttribute("viewSku", viewSku);
		
		/**
		 * 商品关联图片
		 */
		List<TShopSkuPicture> skuPictures = skuPictureService.getBySkuId(id);
		request.setAttribute("skuPictures", skuPictures);
		
		
		/**
		 * spu，包含属性，属性类型，属性值集合
		 */
		TShopSpu viewSpu =spuService.getSpuAttrOptionsById(viewSku.getSpuId());
		request.setAttribute("viewSpu", viewSpu);		
		
		
	    /**
	     * spu关联的图片
	     */
		List<TShopSpuPicture> spuPictures =spuPictureService.getBySpuId(viewSku.getSpuId());
		request.setAttribute("spuPictures", spuPictures);
		
		
		return "all/admin/sku/sku-view";
	}
	
	/**
	 * 查看编辑sku
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("edit")
	public String edit(HttpServletRequest request,Long id) {
		
	
		/**
		 * 商品
		 */
		TShopSku editSku = skuService.getPlusById(id);		
		request.setAttribute("editSku", editSku);
		
		/**
		 * 包含的属性值Id集合
		 */
		List<Long> optionIds = new ArrayList<Long>();
		for(TShopAttribute attribute :editSku.getAttributes()) {
			for(TShopAttributeOption option :attribute.getOptions()) {
				optionIds.add(option.getId());
			}
		}		
		request.setAttribute("optionIds", optionIds);
		
		/**
		 * 商品关联图片
		 */
		List<TShopSkuPicture> skuPictures = skuPictureService.getBySkuId(id);
		request.setAttribute("skuPictures", skuPictures);
		
		
		/**
		 * spu，包含属性，属性类型，属性值集合
		 */
		TShopSpu editSpu =spuService.getSpuAttrOptionsById(editSku.getSpuId());
		request.setAttribute("editSpu", editSpu);		
		
		return "all/admin/sku/sku-edit";

	}
	
	
	/**
	 * 更新sku
	 * @param request
	 * @param id
	 * @param skuName
	 * @param memo
	 * @param originalPrice
	 * @param stocks
	 * @param discountRate
	 * @param salePrice
	 * @param integration
	 * @param statu
	 * @param picture
	 * @return
	 */
	@RequestMapping(value="saveEditSku",method=RequestMethod.POST)
	@ResponseBody
	public String saveEditSku(HttpServletRequest request,Long id,String skuName,String memo,
			BigDecimal originalPrice,Long stocks,Double discountRate,BigDecimal salePrice,Integer integration,
			Integer statu,MultipartFile picture) {
		 
	
		/**
		 * 商品
		 */
		TShopSku editSku = skuService.getByID(id);
		
		/**
		 * 修改的库存与原SKU库存差，用于改变SPU的库存
		 */		
	    Long  diffrenceStocks  = stocks - editSku.getStocks();
			 	
		editSku.setSkuName(skuName);
		editSku.setUpdateDate(new Date());
		editSku.setMemo(memo);
		editSku.setOriginalPrice(originalPrice);
		editSku.setStocks(stocks);
		editSku.setDiscountRate(discountRate);
		editSku.setSalePrice(salePrice);
		editSku.setIntegration(integration);
		editSku.setSkuStatu(statu);
		
		
		
		
		
		//原缩略图地址 
	    String originalPath =PropertiesUtil.getProperty("realFilePath")+ editSku.getPicture();
		
	    /**
		 * 设置图片,并更新sku
		 */
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
			String realuUploadBrandPath = realUploadPath+"/spu"+datePath;
			//虚拟路径
		    String  fictitiousUploadPicturePath ="/spu"+datePath;
          			    	  
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
          
          //设置图片地址
          editSku.setPicture(fictitiousFilePath);
          
          //存储到数据库
          Long reply = skuService.updateEntity(editSku);		
          
          if(reply== 1) {    	    
 		        //删除旧文件
 		         File oldFile = new File(originalPath);
 		         if(oldFile.exists()&&oldFile.isFile()) oldFile.delete();
 		         //修改SPU库存
 		         if(diffrenceStocks != 0) {
 	        		TShopSpu updateSpu =spuService.getByID(editSku.getSpuId());
 	        		Long  resultStocks = updateSpu.getStocks()+diffrenceStocks; 
 	            	updateSpu.setStocks(resultStocks);
 	              	spuService.updateEntity(updateSpu);
 	        	 }
 			     return "true";
 		    }
 		    else
 		      //删除新传文件	 
 			  if(newFile.exists()&&newFile.isFile()) newFile.delete();	 
 		      return "false";
	   }
		
		//缩略图未改变，将SKU存储到数据库
        Long reply = skuService.updateEntity(editSku);
        if(reply== 1) {
        	/**
        	 * 改变SPU库存
        	 */
        	if(diffrenceStocks != 0) {
        		    TShopSpu updateSpu =spuService.getByID(editSku.getSpuId());
	        		Long  resultStocks = updateSpu.getStocks()+diffrenceStocks; 
	            	updateSpu.setStocks(resultStocks);
	              	spuService.updateEntity(updateSpu);
        	}
        	
        	return "true";
        }
        	      
		return "false";
	}
	
	/**
	 * 修改sku关键属性值
	 * @param skuId
	 * @param optionIds
	 * @return
	 */
	@RequestMapping(value="saveEditSkuOption",method=RequestMethod.POST)
	@ResponseBody
	public String skuOptionForm(Long skuId,Long[] optionIds) {
		
		if(optionIds !=null && optionIds.length != 0) {
			skuAttrOptionService.deleteBySkuId(skuId);
			for(Long optionId :optionIds) {
				TShopSkuAttributeOption skuAttrOption =new TShopSkuAttributeOption();
				skuAttrOption.setOptionId(optionId);
				skuAttrOption.setSkuId(skuId);
				skuAttrOptionService.saveAddEntity(skuAttrOption);
			}
			return "true";
		}
		
		return "false";
		
	}
	
	
	/**
	 *  替换图片
	 * @param pictureId
	 * @param replaceFile
	 * @return
	 */
	@RequestMapping(value="replacePicture",method =RequestMethod.POST)
	@ResponseBody
	public String replacePicture(Long pictureId,MultipartFile replaceFile) {
		
		
		 TShopSkuPicture replacespuPicture = skuPictureService.getByID(pictureId);
		
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
			String realuUploadBrandPath = realUploadPath+"/sku"+datePath;
			//虚拟路径
		    String  fictitiousUploadPicturePath ="/sku"+datePath;
           			    	  
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
           Long reply = skuPictureService.updateEntity(replacespuPicture);		
           
           if(reply== 1) {    	    
  		        //删除旧文件
  		         File oldFile = new File(originalPath);
  		         if(oldFile.exists()&&oldFile.isFile()) oldFile.delete();		   		       		    	
  			     return fictitiousFilePath;
  		    }
  		    else
  		      //删除新传文件	 
  			  if(newFile.exists()&&newFile.isFile()) newFile.delete();	 
  		      return "false";
	   }		        
		return "false";		
	}
	
	
	/**
	 * 新增图片
	 * @param request
	 * @param skuId
	 * @param addFile
	 * @return
	 */
	@RequestMapping(value="addPicture",method =RequestMethod.POST)
	public @ResponseBody  String addPicture(HttpServletRequest request,Long skuId,MultipartFile addFile){
		
		/**
		 * 判断关联图片数量是否大于等于3
		 */
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("skuId", skuId);
		Long nums =skuPictureService.countByparames(params);
		if(nums >=3) return "enough";
		
		
		/**
		 * new一个分类对象
		 */
		TShopSkuPicture newskuPicture = new TShopSkuPicture();
		

		/**
		 * 设置Sku id
		 */
		newskuPicture.setSkuId(skuId);
			
		
		 
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
				String realuUploadBrandPath = realUploadPath+"/sku"+datePath;
				//虚拟路径
			    String  fictitiousUploadPicturePath ="/sku"+datePath;
	           			    	  
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
	           newskuPicture.setPictureUrl(fictitiousFilePath);
	           
	           //存储到数据库
	           Long reply = skuPictureService.saveAddEntity(newskuPicture);		
	           
	           if(reply== 1) {    	       		       		    	
	  			     return PropertiesUtil.getProperty("fictitiousRoot")+fictitiousFilePath;
	  		    }
	  		    else
	  		      //删除新传文件	 
	  			  if(newFile.exists()&&newFile.isFile()) newFile.delete();	 
	  		      return "false";
		   }		        
		 
		 return "false";
	}
	
	
	/**
	 * 删除。
	 * @param skuId
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public @ResponseBody String deleteByID(@RequestParam("id")Long skuId){
		
		if(skuService.getByID(skuId).getSkuStatu() != 1) return "onSale";
				
		/**
		 * 删除关联的图片
		 */
		List<TShopSkuPicture> skuPictures =skuPictureService.getBySkuId(skuId);
		if(skuPictures != null) {			
			for(TShopSkuPicture skuPicture :skuPictures) {
				String filePath =PropertiesUtil.getProperty("realFilePath") + skuPicture.getPictureUrl();
				File file =new File(filePath);
				if(file.exists()&&file.isFile()) file.delete();
				skuPictureService.delete(skuPicture.getId());
			}			
		}
		
		/**
		 * 删除关联的关键属性
		 */
		skuAttrOptionService.deleteBySkuId(skuId);
		
		
		/**
		 * 删除缩略图以及SKU
		 */
		 TShopSku deleteSku = skuService.getByID(skuId);
		 String  imagePath =PropertiesUtil.getProperty("realFilePath") + deleteSku.getPicture();
		 File deleteImage =new File(imagePath);
		 if(deleteImage.exists()&&deleteImage.isFile()) deleteImage.delete();
		 Long reply = skuService.delete(skuId);
		 if(reply == 1) {
			 /**
			  * 更改SPU库存
			  */
			 TShopSpu updateSpu = spuService.getByID(deleteSku.getSpuId());
			 Long endStocks =updateSpu.getStocks()-deleteSku.getStocks();
			 updateSpu.setStocks(endStocks);
			 spuService.updateEntity(updateSpu);
			 return "true";
		 }
		 return "false";
		
	}
	
	
	/**
	 * 查看linkSpu
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="linkSpu",method =RequestMethod.GET)
	public  String linkSpu(HttpServletRequest request,Long id) {
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
		
		     
		return "all/admin/sku/sku-spu";
		
	}
	
	/**
	 * 验证SPU号
	 */
    @RequestMapping("validateSpuNo")
    @ResponseBody
    public Map<String,Object> validateSpuNo(String spuNo) {
    	TShopSpu validateSpu = spuService.getByUniqueCode(spuNo);
    	Map<String,Object> result =new HashMap<String,Object>();
    	if(validateSpu != null) {
    		result.put("valid", true);
    		return result;
    	}
    	result.put("valid", false);
		return result;
    	
    }
    
    /**
	 * 新增SKU界面
	 */
    @RequestMapping("viewAdd")
    public String viewAdd(HttpServletRequest request,String spuNo) {
    	TShopSpu linkSpu = spuService.getByUniqueCode(spuNo);
    	TShopSpu spu = spuService.getSpuAttrOptionsById(linkSpu.getId());
    	request.setAttribute("spu", spu);
    	return "all/admin/sku/sku-add";
    }
    
    
    /**
	 * 导出excel表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="export",method = RequestMethod.GET)
	public ExcelView export(HttpServletRequest request) {
		
			
		Map<String, Object> params = ParameterUtils.getParametersMap(request);
		
		List<TShopSku> skus= skuService.getByparamsList(params);
		
		ExcelSku excelsku = new ExcelSku();
		
		List<ExcelSku> excelskus = excelsku.build(skus);
				
		
		return new ExcelView("商品.xls", "商品", new String[]{"id","skuNo","skuName","memo","spuNo","categoryId","categoryName","brandId","brandName","picture","originalPrice","salePrice","discountRate","saleAmount","stocks","skuStatu","integration","createDate","updateDate"},
				new String[]{"ID号","商品号","商品名","备注","SPU号","分类ID","分类名","品牌ID","品牌名","图片","原价","售价","折率","销量","库存","状态","积分","创建时间","修改时间"},   new Integer[]{5000,5000,12000,5000,5000,5000,5000,5000,5000,15000,5000,5000,5000,5000,5000,5000,5000,10000,10000}, null, excelskus, null);
		
		
	}
    
}
