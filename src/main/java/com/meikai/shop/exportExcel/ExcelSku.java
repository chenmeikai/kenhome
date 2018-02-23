package com.meikai.shop.exportExcel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.meikai.shop.entity.TShopSku;
import com.meikai.util.DateUtil;
import lombok.Data;

@Data
public class ExcelSku {
	
	/**
     * 主键ID,商品
     */
    private Long id;

    
    /**
     * 商品编号
     */
    private String skuNo;
    
    /**
     * 商品名
     */
    private String skuName;

    
    /**
     * 备注
     */
    private String memo;

        
    /**
     * SPU号
     */
    private String spuNo; 
    
    /**
     * 分类ID
     */
    private Long categoryId;
    
    /**
     * 分类名
     */
    private String categoryName;

    /**
     * 品牌ID
     */
    private Long brandId;
    
    /**
     * 品牌名
     */
    private String brandName;

    
    /**
     * 图片
     */
    private String picture;

    /**
     * 原价
     */
    private BigDecimal originalPrice;

    /**
     * 促销价
     */
    private BigDecimal salePrice;

    /**
     * 折扣
     */
    private Double discountRate;

   
    /**
     * 库存
     */
    private Long stocks;

    /**
     * 销量
     */
    private Long saleAmount;

    

    /**
     * 1：上架；2：下架；3：预售。
     */
    private String skuStatu;

    /**
     * 积分
     */
    private Integer integration;

    
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



	public String getSkuNo() {
		return skuNo;
	}



	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}



	public String getSkuName() {
		return skuName;
	}



	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}



	public String getMemo() {
		return memo;
	}



	public void setMemo(String memo) {
		this.memo = memo;
	}



	public String getSpuNo() {
		return spuNo;
	}



	public void setSpuNo(String spuNo) {
		this.spuNo = spuNo;
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



	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}



	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}



	public BigDecimal getSalePrice() {
		return salePrice;
	}



	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}



	public Double getDiscountRate() {
		return discountRate;
	}



	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}



	public Long getStocks() {
		return stocks;
	}



	public void setStocks(Long stocks) {
		this.stocks = stocks;
	}



	public Long getSaleAmount() {
		return saleAmount;
	}



	public void setSaleAmount(Long saleAmount) {
		this.saleAmount = saleAmount;
	}



	public String getSkuStatu() {
		return skuStatu;
	}



	public void setSkuStatu(String skuStatu) {
		this.skuStatu = skuStatu;
	}



	public Integer getIntegration() {
		return integration;
	}



	public void setIntegration(Integer integration) {
		this.integration = integration;
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
     * 构建需要展示的SKU信息
     * @param managers
     * @return
     */
    public List<ExcelSku> build(List<TShopSku> skus){
    	
    	List<ExcelSku> excelskus = new ArrayList<ExcelSku>();
    	    	
    	
    	/**
    	 * 遍历集合，转存到excelskus集合中
    	 */
    	for(TShopSku sku : skus) {
    		
    		ExcelSku excelSku = new ExcelSku();   		
    		excelSku.setId(sku.getId());
    		excelSku.setSkuNo(sku.getSkuNo());
    		excelSku.setSkuName(sku.getSkuName());
    		excelSku.setMemo(sku.getMemo());
    		excelSku.setSpuNo(sku.getSpuNo());    		
    		excelSku.setCategoryId(sku.getCategoryId());
    		excelSku.setCategoryName(sku.getCategoryName());
    		excelSku.setBrandId(sku.getBrandId());
    		excelSku.setBrandName(sku.getBrandName());
    		excelSku.setPicture(sku.getPicture());
    		excelSku.setOriginalPrice(sku.getOriginalPrice());
    		excelSku.setSalePrice(sku.getSalePrice());
    		excelSku.setDiscountRate(sku.getDiscountRate());
    		excelSku.setSaleAmount(sku.getSaleAmount());
    		excelSku.setStocks(sku.getStocks());
    		excelSku.setIntegration(sku.getIntegration());  		
    		switch(sku.getSkuStatu()) {
		    case(1):
		    	excelSku.setSkuStatu("下架");	
		    break;
		    case(2):
		    	excelSku.setSkuStatu("上架");
		    break;
		    case(3):
		    	excelSku.setSkuStatu("预售");
		    break;    		       		    	
		};
    		  		   		
    		if(sku.getCreateDate() != null) {
    			excelSku.setCreateDate(DateUtil.getDateTimeFormat(sku.getCreateDate()));
    		}
    		
    		if(sku.getUpdateDate() != null) {
    			excelSku.setUpdateDate(DateUtil.getDateTimeFormat(sku.getUpdateDate()));
    		}
    		  		
    		
    		excelskus.add(excelSku)	;
    	}
    	
    	return excelskus;
    }

}
