package com.meikai.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TShopSku implements Serializable {
    /**
     * 主键ID,商品
     */
    private Long id;

    /**
     * 创建者
     */
    private String creater;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后更新者
     */
    private String updater;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 商品编号
     */
    private String skuNo;

    /**
     * SPU ID
     */
    private Long spuId;
    
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
     * 分类对象
     */
    private TShopCategory category;

    /**
     * 品牌ID
     */
    private Long brandId;
    
    /**
     * 品牌名
     */
    private String brandName;

    /**
     * 商品名
     */
    private String skuName;

    /**
     * 点击量
     */
    private Long hits;

    /**
     * 备注
     */
    private String memo;

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
     * 折扣金额
     */
    private BigDecimal discountAmount;

    /**
     * 库存
     */
    private Long stocks;

    /**
     * 销量
     */
    private Long saleAmount;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 1：上架；2：下架；3：预售。
     */
    private Integer skuStatu;

    /**
     * 积分
     */
    private Integer integration;

    /**
     * 简介
     */
    private String shortIntroduce;

    /**
     * 详情
     */
    private String context;
    
    /**
     * 关键属性集合
     */
    private List<TShopAttribute> attributes;

    /**
     * t_shop_sku
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID,商品
     * @return ID 主键ID,商品
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID,商品
     * @param id 主键ID,商品
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 创建者
     * @return CREATER 创建者
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 创建者
     * @param creater 创建者
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * 创建时间
     * @return CREATE_DATE 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 最后更新者
     * @return UPDATER 最后更新者
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * 最后更新者
     * @param updater 最后更新者
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * 更新时间
     * @return UPDATE_DATE 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新时间
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 商品编号
     * @return SKU_NO 商品编号
     */
    public String getSkuNo() {
        return skuNo;
    }

    /**
     * 商品编号
     * @param skuNo 商品编号
     */
    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    /**
     * SPUID
     * @return SPU_ID 商品ID
     */
    public Long getSpuId() {
        return spuId;
    }

    /**
     * SPUID
     * @param spuId 商品ID
     */
    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }
    
    
    /**
     * 获得SPU 号
     * @return
     */
    public String getSpuNo() {
		return spuNo;
	}
    /**
     * 设置SPU 号
     * @param spuNo
     */
	public void setSpuNo(String spuNo) {
		this.spuNo = spuNo;
	}

	/**
     * 分类ID
     * @return CATEGORY_ID 分类ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 分类ID
     * @param categoryId 分类ID
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    
    

    public TShopCategory getCategory() {
		return category;
	}

	public void setCategory(TShopCategory category) {
		this.category = category;
	}

	/**
     * 品牌ID
     * @return BRAND_ID 品牌ID
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * 品牌ID
     * @param brandId 品牌ID
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * 商品名
     * @return SKU_NAME 商品名
     */
    public String getSkuName() {
        return skuName;
    }

    /**
     * 商品名
     * @param skuName 商品名
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    /**
     * 点击量
     * @return HITS 点击量
     */
    public Long getHits() {
        return hits;
    }

    /**
     * 点击量
     * @param hits 点击量
     */
    public void setHits(Long hits) {
        this.hits = hits;
    }

    /**
     * 备注
     * @return MEMO 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 备注
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 图片
     * @return PICTURE 图片
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 图片
     * @param picture 图片
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * 原价
     * @return ORIGINAL_price 原价
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 原价
     * @param originalPrice 原价
     */
    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 促销价
     * @return SALE_PRICE 促销价
     */
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    /**
     * 促销价
     * @param salePrice 促销价
     */
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * 折扣
     * @return DISCOUNT_RATE 折扣
     */
    public Double getDiscountRate() {
        return discountRate;
    }

    /**
     * 折扣
     * @param discountRate 折扣
     */
    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * 折扣金额
     * @return discount_amount 折扣金额
     */
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    /**
     * 折扣金额
     * @param discountAmount 折扣金额
     */
    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * 库存
     * @return STOCKS 库存
     */
    public Long getStocks() {
        return stocks;
    }

    /**
     * 库存
     * @param stocks 库存
     */
    public void setStocks(Long stocks) {
        this.stocks = stocks;
    }

    /**
     * 销量
     * @return SALE_AMOUNT 销量
     */
    public Long getSaleAmount() {
        return saleAmount;
    }

    /**
     * 销量
     * @param saleAmount 销量
     */
    public void setSaleAmount(Long saleAmount) {
        this.saleAmount = saleAmount;
    }

    /**
     * 关键词
     * @return KEYWORD 关键词
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 关键词
     * @param keyword 关键词
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * 1：上架；2：下架；3：预售。
     * @return STATU 1：上架；2：下架；3：预售。
     */
    public Integer getSkuStatu() {
        return skuStatu;
    }

    /**
     * 1：上架；2：下架；3：预售。
     * @param skuStatu 1：上架；2：下架；3：预售。
     */
    public void setSkuStatu(Integer skuStatu) {
        this.skuStatu = skuStatu;
    }

    /**
     * 积分
     * @return INTEGRATION 积分
     */
    public Integer getIntegration() {
        return integration;
    }

    /**
     * 积分
     * @param integration 积分
     */
    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    /**
     * 简介
     * @return SHORT_INTRODUCE 简介
     */
    public String getShortIntroduce() {
        return shortIntroduce;
    }

    /**
     * 简介
     * @param shortIntroduce 简介
     */
    public void setShortIntroduce(String shortIntroduce) {
        this.shortIntroduce = shortIntroduce == null ? null : shortIntroduce.trim();
    }

    /**
     * 详情
     * @return CONTEXT 详情
     */
    public String getContext() {
        return context;
    }

    /**
     * 详情
     * @param context 详情
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
    
    /**
     * 获得关键属性集合
     */
    public List<TShopAttribute> getAttributes() {
		return attributes;
	}
    
    /**
     * 设置关键属性集合
     * @param attributes
     */
	public void setAttributes(List<TShopAttribute> attributes) {
		this.attributes = attributes;
	}
    
	
	
    /**
     * 获得分类名
     * @return
     */
    public String getCategoryName() {
		return categoryName;
	}
    /**
     * 设置分类名
     * @param categoryName
     */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
    /**
     * 获得品牌名
     * @return
     */
	public String getBrandName() {
		return brandName;
	}
    /**
     * 设置品牌名
     * @param brandName
     */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TShopSku other = (TShopSku) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getSkuNo() == null ? other.getSkuNo() == null : this.getSkuNo().equals(other.getSkuNo()))
            && (this.getSpuId() == null ? other.getSpuId() == null : this.getSpuId().equals(other.getSpuId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getSkuName() == null ? other.getSkuName() == null : this.getSkuName().equals(other.getSkuName()))
            && (this.getHits() == null ? other.getHits() == null : this.getHits().equals(other.getHits()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getPicture() == null ? other.getPicture() == null : this.getPicture().equals(other.getPicture()))
            && (this.getOriginalPrice() == null ? other.getOriginalPrice() == null : this.getOriginalPrice().equals(other.getOriginalPrice()))
            && (this.getSalePrice() == null ? other.getSalePrice() == null : this.getSalePrice().equals(other.getSalePrice()))
            && (this.getDiscountRate() == null ? other.getDiscountRate() == null : this.getDiscountRate().equals(other.getDiscountRate()))
            && (this.getDiscountAmount() == null ? other.getDiscountAmount() == null : this.getDiscountAmount().equals(other.getDiscountAmount()))
            && (this.getStocks() == null ? other.getStocks() == null : this.getStocks().equals(other.getStocks()))
            && (this.getSaleAmount() == null ? other.getSaleAmount() == null : this.getSaleAmount().equals(other.getSaleAmount()))
            && (this.getKeyword() == null ? other.getKeyword() == null : this.getKeyword().equals(other.getKeyword()))
            && (this.getSkuStatu() == null ? other.getSkuStatu() == null : this.getSkuStatu().equals(other.getSkuStatu()))
            && (this.getIntegration() == null ? other.getIntegration() == null : this.getIntegration().equals(other.getIntegration()))
            && (this.getShortIntroduce() == null ? other.getShortIntroduce() == null : this.getShortIntroduce().equals(other.getShortIntroduce()))
            && (this.getContext() == null ? other.getContext() == null : this.getContext().equals(other.getContext()));
    }

    

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getSkuNo() == null) ? 0 : getSkuNo().hashCode());
        result = prime * result + ((getSpuId() == null) ? 0 : getSpuId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getSkuName() == null) ? 0 : getSkuName().hashCode());
        result = prime * result + ((getHits() == null) ? 0 : getHits().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getPicture() == null) ? 0 : getPicture().hashCode());
        result = prime * result + ((getOriginalPrice() == null) ? 0 : getOriginalPrice().hashCode());
        result = prime * result + ((getSalePrice() == null) ? 0 : getSalePrice().hashCode());
        result = prime * result + ((getDiscountRate() == null) ? 0 : getDiscountRate().hashCode());
        result = prime * result + ((getDiscountAmount() == null) ? 0 : getDiscountAmount().hashCode());
        result = prime * result + ((getStocks() == null) ? 0 : getStocks().hashCode());
        result = prime * result + ((getSaleAmount() == null) ? 0 : getSaleAmount().hashCode());
        result = prime * result + ((getKeyword() == null) ? 0 : getKeyword().hashCode());
        result = prime * result + ((getSkuStatu() == null) ? 0 : getSkuStatu().hashCode());
        result = prime * result + ((getIntegration() == null) ? 0 : getIntegration().hashCode());
        result = prime * result + ((getShortIntroduce() == null) ? 0 : getShortIntroduce().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", creater=").append(creater);
        sb.append(", createDate=").append(createDate);
        sb.append(", updater=").append(updater);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", skuNo=").append(skuNo);
        sb.append(", spuId=").append(spuId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", brandId=").append(brandId);
        sb.append(", skuName=").append(skuName);
        sb.append(", hits=").append(hits);
        sb.append(", memo=").append(memo);
        sb.append(", picture=").append(picture);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", salePrice=").append(salePrice);
        sb.append(", discountRate=").append(discountRate);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append(", stocks=").append(stocks);
        sb.append(", saleAmount=").append(saleAmount);
        sb.append(", keyword=").append(keyword);
        sb.append(", skuStatu=").append(skuStatu);
        sb.append(", integration=").append(integration);
        sb.append(", shortIntroduce=").append(shortIntroduce);
        sb.append(", context=").append(context);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}