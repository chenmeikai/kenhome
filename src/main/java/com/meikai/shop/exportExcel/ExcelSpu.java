package com.meikai.shop.exportExcel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meikai.shop.entity.TShopAttribute;
import com.meikai.shop.entity.TShopAttributeOption;
import com.meikai.shop.entity.TShopSpu;
import com.meikai.shop.entity.TSystemManager;
import com.meikai.util.DateUtil;

import lombok.Data;

@Data
public class ExcelSpu {
	
	/**
     * 主键ID，SPU
     */
    private Long id;
    
    /**
     * 商品编号
     */
    private String spuNo;
    
    /**
     * SPU名
     */
    private String spuName;
    
    /**
     * SPU标题
     */
    private String spuTitle;

    

    /**
     * 商品状态
     */
    private String spuStatu;

    /**
     * 商品图片
     */
    private String spuImage;

    /**
     * 分类Id
     */
    private Long categoryId;
    
    /**
     * 分类名
     */
    private String categoryName;

    /**
     * 品牌Id
     */
    private Long brandId;
    
    /**
     * 品牌名
     */
    private String brandName;
    
    /**
     * SPU介绍
     */
    private String spuContent;
    
       
    /**
     * 创建时间
     */
    private String createDate;
    
    /**
     * 更新时间
     */
    private String updateDate;
    
    
    
    
    public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getSpuNo() {
		return spuNo;
	}




	public void setSpuNo(String spuNo) {
		this.spuNo = spuNo;
	}




	public String getSpuName() {
		return spuName;
	}




	public void setSpuName(String spuName) {
		this.spuName = spuName;
	}




	public String getSpuTitle() {
		return spuTitle;
	}




	public void setSpuTitle(String spuTitle) {
		this.spuTitle = spuTitle;
	}




	public String getSpuStatu() {
		return spuStatu;
	}




	public void setSpuStatu(String spuStatu) {
		this.spuStatu = spuStatu;
	}




	public String getSpuImage() {
		return spuImage;
	}




	public void setSpuImage(String spuImage) {
		this.spuImage = spuImage;
	}




	public Long getCategoryId() {
		return categoryId;
	}




	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}




	public String getCategoryName() {
		return categoryName;
	}




	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}




	public Long getBrandId() {
		return brandId;
	}




	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}




	public String getBrandName() {
		return brandName;
	}




	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}




	public String getSpuContent() {
		return spuContent;
	}




	public void setSpuContent(String spuContent) {
		this.spuContent = spuContent;
	}




	public String getCreateDate() {
		return createDate;
	}




	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}




	public String getUpdateDate() {
		return updateDate;
	}




	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}




	/**
     * 构建需要展示的SPU信息
     * @param managers
     * @return
     */
    public List<ExcelSpu> build(List<TShopSpu> spus){
    	
    	List<ExcelSpu> excelspus = new ArrayList<ExcelSpu>();
    	    	
    	
    	/**
    	 * 遍历集合，转存到excelManagers集合中
    	 */
    	for(TShopSpu spu : spus) {
    		
    		ExcelSpu excelSpu = new ExcelSpu();
    		
    		excelSpu.setId(spu.getId());
    		excelSpu.setSpuNo(spu.getSpuNo());
    		excelSpu.setSpuName(spu.getSpuName());
    		excelSpu.setSpuTitle(spu.getSpuTitle());
    	
    	    switch(spu.getSpuStatu()) {
    		    case(1):
    		    	excelSpu.setSpuStatu("下架");	
    		    break;
    		    case(2):
    		    	excelSpu.setSpuStatu("上架");
    		    break;
    		    case(3):
    		    	excelSpu.setSpuStatu("预售");
    		    break;    		       		    	
    		};
    		excelSpu.setSpuImage(spu.getSpuImage());
    		excelSpu.setCategoryId(spu.getCategoryId());
    		excelSpu.setCategoryName(spu.getCategoryName());
    		excelSpu.setBrandId(spu.getBrandId());
    		excelSpu.setBrandName(spu.getBrandName());
    		excelSpu.setSpuContent(spu.getSpuContent());
    		  		   		
    		if(spu.getCreateDate() != null) {
    			excelSpu.setCreateDate(DateUtil.getDateTimeFormat(spu.getCreateDate()));
    		}
    		
    		if(spu.getUpdateDate() != null) {
    			excelSpu.setUpdateDate(DateUtil.getDateTimeFormat(spu.getUpdateDate()));
    		}
    		  		
    		
    		excelspus.add(excelSpu)	;
    	}
    	
    	return excelspus;
    }

}
