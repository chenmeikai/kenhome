package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopCategoryAttribute implements Serializable {
    /**
     * 主键ID，分类-属性关联
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 属性ID
     */
    private Long attributeId;

    /**
     * 属性用途，基本属性：默认1、否；2、是；
     */
    private Integer baseType;

    /**
     * 属性用途，价格属性(决定价格)：默认1、否；2、是；
     */
    private Integer priceType;

    /**
     * 属性用途，导购属性(用于导购):默认1、否；2、是；
     */
    private Integer guideType;

    /**
     * 基本属性排序
     */
    private Integer baseSort;

    /**
     * 价格属性排序
     */
    private Integer priceSort;

    /**
     * 导购属性排序
     */
    private Integer guideSort;
    
    /**
     * 属性名
     */
    private String attributeName;
    

    /**
     * t_shop_category_attribute
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，分类-属性关联
     * @return id 主键ID，分类-属性关联
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，分类-属性关联
     * @param id 主键ID，分类-属性关联
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
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
     * 更新时间
     * @return update_date 更新时间
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
     * 分类ID
     * @return category_id 分类ID
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

    /**
     * 属性ID
     * @return attribute_id 属性ID
     */
    public Long getAttributeId() {
        return attributeId;
    }

    /**
     * 属性ID
     * @param attributeId 属性ID
     */
    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    /**
     * 属性用途，基本属性：默认1、否；2、是；
     * @return base_type 属性用途，基本属性：默认1、否；2、是；
     */
    public Integer getBaseType() {
        return baseType;
    }

    /**
     * 属性用途，基本属性：默认1、否；2、是；
     * @param baseType 属性用途，基本属性：默认1、否；2、是；
     */
    public void setBaseType(Integer baseType) {
        this.baseType = baseType;
    }

    /**
     * 属性用途，价格属性(决定价格)：默认1、否；2、是；
     * @return price_type 属性用途，价格属性(决定价格)：默认1、否；2、是；
     */
    public Integer getPriceType() {
        return priceType;
    }

    /**
     * 属性用途，价格属性(决定价格)：默认1、否；2、是；
     * @param priceType 属性用途，价格属性(决定价格)：默认1、否；2、是；
     */
    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    /**
     * 属性用途，导购属性(用于导购):默认1、否；2、是；
     * @return guide_type 属性用途，导购属性(用于导购):默认1、否；2、是；
     */
    public Integer getGuideType() {
        return guideType;
    }

    /**
     * 属性用途，导购属性(用于导购):默认1、否；2、是；
     * @param guideType 属性用途，导购属性(用于导购):默认1、否；2、是；
     */
    public void setGuideType(Integer guideType) {
        this.guideType = guideType;
    }

    /**
     * 基本属性排序
     * @return base_sort 基本属性排序
     */
    public Integer getBaseSort() {
        return baseSort;
    }

    /**
     * 基本属性排序
     * @param baseSort 基本属性排序
     */
    public void setBaseSort(Integer baseSort) {
        this.baseSort = baseSort;
    }

    /**
     * 价格属性排序
     * @return price_sort 价格属性排序
     */
    public Integer getPriceSort() {
        return priceSort;
    }

    /**
     * 价格属性排序
     * @param priceSort 价格属性排序
     */
    public void setPriceSort(Integer priceSort) {
        this.priceSort = priceSort;
    }

    /**
     * 导购属性排序
     * @return guide_Sort 导购属性排序
     */
    public Integer getGuideSort() {
        return guideSort;
    }

    /**
     * 导购属性排序
     * @param guideSort 导购属性排序
     */
    public void setGuideSort(Integer guideSort) {
        this.guideSort = guideSort;
    }
    
    /**
     * 获得属性名
     * @return
     */
    public String getAttributeName() {
		return attributeName;
	}
    
    /**
     * 设置属性名
     * @param attributeName
     */
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
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
        TShopCategoryAttribute other = (TShopCategoryAttribute) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getAttributeId() == null ? other.getAttributeId() == null : this.getAttributeId().equals(other.getAttributeId()))
            && (this.getBaseType() == null ? other.getBaseType() == null : this.getBaseType().equals(other.getBaseType()))
            && (this.getPriceType() == null ? other.getPriceType() == null : this.getPriceType().equals(other.getPriceType()))
            && (this.getGuideType() == null ? other.getGuideType() == null : this.getGuideType().equals(other.getGuideType()))
            && (this.getBaseSort() == null ? other.getBaseSort() == null : this.getBaseSort().equals(other.getBaseSort()))
            && (this.getPriceSort() == null ? other.getPriceSort() == null : this.getPriceSort().equals(other.getPriceSort()))
            && (this.getGuideSort() == null ? other.getGuideSort() == null : this.getGuideSort().equals(other.getGuideSort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getAttributeId() == null) ? 0 : getAttributeId().hashCode());
        result = prime * result + ((getBaseType() == null) ? 0 : getBaseType().hashCode());
        result = prime * result + ((getPriceType() == null) ? 0 : getPriceType().hashCode());
        result = prime * result + ((getGuideType() == null) ? 0 : getGuideType().hashCode());
        result = prime * result + ((getBaseSort() == null) ? 0 : getBaseSort().hashCode());
        result = prime * result + ((getPriceSort() == null) ? 0 : getPriceSort().hashCode());
        result = prime * result + ((getGuideSort() == null) ? 0 : getGuideSort().hashCode());
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
        sb.append(", updateDate=").append(updateDate);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", attributeId=").append(attributeId);
        sb.append(", baseType=").append(baseType);
        sb.append(", priceType=").append(priceType);
        sb.append(", guideType=").append(guideType);
        sb.append(", baseSort=").append(baseSort);
        sb.append(", priceSort=").append(priceSort);
        sb.append(", guideSort=").append(guideSort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}