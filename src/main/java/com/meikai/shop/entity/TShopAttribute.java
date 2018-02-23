package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TShopAttribute implements Serializable {
    /**
     * 主键ID
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
     * 属性名
     */
    private String attributeName;

    /**
     * 属性标题
     */
    private String attributeTitle;

    /**
     * 属性代号
     */
    private String attributeCode;

    /**
     * 属性描述
     */
    private String attributeDescription;

    /**
     * 属性排序
     */
    private Integer attributeSort;

    /**
     * 属性状态
     */
    private Integer attributeStatu;
    
    /**
     * 属性选项集合
     */
    private List<TShopAttributeOption> options ;
    
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
     * t_shop_attribute
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     * @return ID 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
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
     * 属性名
     * @return ATTRIBUTE_NAME 属性名
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * 属性名
     * @param attributeName 属性名
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName == null ? null : attributeName.trim();
    }

    /**
     * 属性标题
     * @return ATTRIBUTE_TITLE 属性标题
     */
    public String getAttributeTitle() {
        return attributeTitle;
    }

    /**
     * 属性标题
     * @param attributeTitle 属性标题
     */
    public void setAttributeTitle(String attributeTitle) {
        this.attributeTitle = attributeTitle == null ? null : attributeTitle.trim();
    }

    /**
     * 属性代号
     * @return ATTRIBUTE_CODE 属性代号
     */
    public String getAttributeCode() {
        return attributeCode;
    }

    /**
     * 属性代号
     * @param attributeCode 属性代号
     */
    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode == null ? null : attributeCode.trim();
    }

    /**
     * 属性描述
     * @return ATTRIBUTE_DESCRIPTION 属性描述
     */
    public String getAttributeDescription() {
        return attributeDescription;
    }

    /**
     * 属性描述
     * @param attributeDescription 属性描述
     */
    public void setAttributeDescription(String attributeDescription) {
        this.attributeDescription = attributeDescription == null ? null : attributeDescription.trim();
    }

    /**
     * 属性排序
     * @return ATTRIBUTE_SORT 属性排序
     */
    public Integer getAttributeSort() {
        return attributeSort;
    }

    /**
     * 属性排序
     * @param attributeSort 属性排序
     */
    public void setAttributeSort(Integer attributeSort) {
        this.attributeSort = attributeSort;
    }

    /**
     * 属性状态
     * @return ATTRIBUTE_STATU 属性状态
     */
    public Integer getAttributeStatu() {
        return attributeStatu;
    }

    /**
     * 属性状态
     * @param attributeStatu 属性状态
     */
    public void setAttributeStatu(Integer attributeStatu) {
        this.attributeStatu = attributeStatu;
    }
    
    
    /**
     * 获得属性选项集合
     */
    public List<TShopAttributeOption> getOptions() {
		return options;
	}
    
    /**
     * 设置属性选项集合
     */
	public void setOptions(List<TShopAttributeOption> options) {
		this.options = options;
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
        TShopAttribute other = (TShopAttribute) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getAttributeName() == null ? other.getAttributeName() == null : this.getAttributeName().equals(other.getAttributeName()))
            && (this.getAttributeTitle() == null ? other.getAttributeTitle() == null : this.getAttributeTitle().equals(other.getAttributeTitle()))
            && (this.getAttributeCode() == null ? other.getAttributeCode() == null : this.getAttributeCode().equals(other.getAttributeCode()))
            && (this.getAttributeDescription() == null ? other.getAttributeDescription() == null : this.getAttributeDescription().equals(other.getAttributeDescription()))
            && (this.getAttributeSort() == null ? other.getAttributeSort() == null : this.getAttributeSort().equals(other.getAttributeSort()))
            && (this.getAttributeStatu() == null ? other.getAttributeStatu() == null : this.getAttributeStatu().equals(other.getAttributeStatu()));
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
        result = prime * result + ((getAttributeName() == null) ? 0 : getAttributeName().hashCode());
        result = prime * result + ((getAttributeTitle() == null) ? 0 : getAttributeTitle().hashCode());
        result = prime * result + ((getAttributeCode() == null) ? 0 : getAttributeCode().hashCode());
        result = prime * result + ((getAttributeDescription() == null) ? 0 : getAttributeDescription().hashCode());
        result = prime * result + ((getAttributeSort() == null) ? 0 : getAttributeSort().hashCode());
        result = prime * result + ((getAttributeStatu() == null) ? 0 : getAttributeStatu().hashCode());
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
        sb.append(", attributeName=").append(attributeName);
        sb.append(", attributeTitle=").append(attributeTitle);
        sb.append(", attributeCode=").append(attributeCode);
        sb.append(", attributeDescription=").append(attributeDescription);
        sb.append(", attributeSort=").append(attributeSort);
        sb.append(", attributeStatu=").append(attributeStatu);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}