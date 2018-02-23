package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TShopSpu implements Serializable {
    /**
     * 主键ID，商品
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建者
     */
    private String creater;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 更新者
     */
    private String updater;

    /**
     * 商品名
     */
    private String spuName;

    /**
     * 商品标题
     */
    private String spuTitle;

    /**
     * 商品编号
     */
    private String spuNo;

    /**
     * 商品序号
     */
    private Integer spuSort;

    /**
     * 商品状态
     */
    private Integer spuStatu;

    /**
     * 商品图片
     */
    private String spuImage;

    /**
     * 分类Id
     */
    private Long categoryId;

    /**
     * 品牌Id
     */
    private Long brandId;
    
    /**
     * SPU介绍
     */
    private String spuContent;
    /**
     * 分类名
     */
    private String categoryName;
    /**
     * 品牌名
     */
    private String brandName;
    
    /**
     * 销量
     */
    private Long saleAmount ;
    
    /**
     * 库存
     */
    private Long stocks;
    
    /**
     * 属性集合
     */
    private List<TShopAttribute> attributes;

    /**
     * t_shop_spu
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，商品
     * @return ID 主键ID，商品
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，商品
     * @param id 主键ID，商品
     */
    public void setId(Long id) {
        this.id = id;
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
     * 更新时间
     * @return UPDATE_TIME 更新时间
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
     * 更新者
     * @return UPDATER 更新者
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * 更新者
     * @param updater 更新者
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * 商品名
     * @return SPU_NAME 商品名
     */
    public String getSpuName() {
        return spuName;
    }

    /**
     * 商品名
     * @param spuName 商品名
     */
    public void setSpuName(String spuName) {
        this.spuName = spuName == null ? null : spuName.trim();
    }

    /**
     * 商品标题
     * @return SPU_DESCRIPTION 商品标题
     */
    public String getSpuTitle() {
        return spuTitle;
    }

    /**
     * 商品标题
     * @param spuTitle 商品标题
     */
    public void setSpuTitle(String spuTitle) {
        this.spuTitle = spuTitle == null ? null : spuTitle.trim();
    }

    /**
     * 商品编号
     * @return SPU_NO 商品编号
     */
    public String getSpuNo() {
        return spuNo;
    }

    /**
     * 商品编号
     * @param spuNo 商品编号
     */
    public void setSpuNo(String spuNo) {
        this.spuNo = spuNo == null ? null : spuNo.trim();
    }

    /**
     * 商品序号
     * @return SPU_SORT 商品序号
     */
    public Integer getSpuSort() {
        return spuSort;
    }

    /**
     * 商品序号
     * @param spuSort 商品序号
     */
    public void setSpuSort(Integer spuSort) {
        this.spuSort = spuSort;
    }

    /**
     * 商品状态
     * @return SPU_STATU 商品状态
     */
    public Integer getSpuStatu() {
        return spuStatu;
    }

    /**
     * 商品状态
     * @param spuStatu 商品状态
     */
    public void setSpuStatu(Integer spuStatu) {
        this.spuStatu = spuStatu;
    }

    /**
     * 商品图片
     * @return SPU_IMAGE 商品图片
     */
    public String getSpuImage() {
        return spuImage;
    }

    /**
     * 商品图片
     * @param spuImage 商品图片
     */
    public void setSpuImage(String spuImage) {
        this.spuImage = spuImage == null ? null : spuImage.trim();
    }

    /**
     * 分类Id
     * @return CATEGORY_ID 分类Id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 分类Id
     * @param categoryId 分类Id
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 品牌Id
     * @return BRAND_ID 品牌Id
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * 品牌Id
     * @param brandId 品牌Id
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    
    
    /**
     * 获得SPU介绍
     * @return
     */
    public String getSpuContent() {
		return spuContent;
	}
    /**
     * 设置SPU介绍
     * @param spuContent
     */
	public void setSpuContent(String spuContent) {
		this.spuContent = spuContent;
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
	
	
    /**
     * 获得属性
     * @return
     */
	public List<TShopAttribute> getAttributes() {
		return attributes;
	}
    /**
     * 设置属性
     * @param attributes
     */
	public void setAttributes(List<TShopAttribute> attributes) {
		this.attributes = attributes;
	}
	
	
    /**
     * 获得销量
     * @return
     */
	public Long getSaleAmount() {
		return saleAmount;
	}
    /**
     * 设置销量
     * @param saleAmount
     */
	public void setSaleAmount(Long saleAmount) {
		this.saleAmount = saleAmount;
	}
    /**
     * 获得库存
     * @return
     */
	public Long getStocks() {
		return stocks;
	}
    /**
     * 设置库存
     * @param stocks
     */
	public void setStocks(Long stocks) {
		this.stocks = stocks;
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
        TShopSpu other = (TShopSpu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getSpuName() == null ? other.getSpuName() == null : this.getSpuName().equals(other.getSpuName()))
            && (this.getSpuTitle() == null ? other.getSpuTitle() == null : this.getSpuTitle().equals(other.getSpuTitle()))
            && (this.getSpuNo() == null ? other.getSpuNo() == null : this.getSpuNo().equals(other.getSpuNo()))
            && (this.getSpuSort() == null ? other.getSpuSort() == null : this.getSpuSort().equals(other.getSpuSort()))
            && (this.getSpuStatu() == null ? other.getSpuStatu() == null : this.getSpuStatu().equals(other.getSpuStatu()))
            && (this.getSpuImage() == null ? other.getSpuImage() == null : this.getSpuImage().equals(other.getSpuImage()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getSpuName() == null) ? 0 : getSpuName().hashCode());
        result = prime * result + ((getSpuTitle() == null) ? 0 : getSpuTitle().hashCode());
        result = prime * result + ((getSpuNo() == null) ? 0 : getSpuNo().hashCode());
        result = prime * result + ((getSpuSort() == null) ? 0 : getSpuSort().hashCode());
        result = prime * result + ((getSpuStatu() == null) ? 0 : getSpuStatu().hashCode());
        result = prime * result + ((getSpuImage() == null) ? 0 : getSpuImage().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", creater=").append(creater);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updater=").append(updater);
        sb.append(", spuName=").append(spuName);
        sb.append(", spuTitle=").append(spuTitle);
        sb.append(", spuNo=").append(spuNo);
        sb.append(", spuSort=").append(spuSort);
        sb.append(", spuStatu=").append(spuStatu);
        sb.append(", spuImage=").append(spuImage);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", brandId=").append(brandId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}