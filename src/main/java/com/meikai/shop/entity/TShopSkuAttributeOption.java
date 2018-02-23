package com.meikai.shop.entity;

import java.io.Serializable;

public class TShopSkuAttributeOption implements Serializable {
    /**
     * 主键ID,单品-属性关联
     */
    private Long id;

    /**
     * 单品ID
     */
    private Long skuId;

    /**
     * 单品属性选项ID
     */
    private Long optionId;

    /**
     * t_shop_sku_attribute_option
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID,单品-属性关联
     * @return ID 主键ID,单品-属性关联
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID,单品-属性关联
     * @param id 主键ID,单品-属性关联
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 单品ID
     * @return SKU_ID 单品ID
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * 单品ID
     * @param skuId 单品ID
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * 单品属性选项ID
     * @return OPTION_ID 单品属性选项ID
     */
    public Long getOptionId() {
        return optionId;
    }

    /**
     * 单品属性选项ID
     * @param optionId 单品属性选项ID
     */
    public void setOptionId(Long optionId) {
        this.optionId = optionId;
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
        TShopSkuAttributeOption other = (TShopSkuAttributeOption) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getOptionId() == null ? other.getOptionId() == null : this.getOptionId().equals(other.getOptionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
        result = prime * result + ((getOptionId() == null) ? 0 : getOptionId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", skuId=").append(skuId);
        sb.append(", optionId=").append(optionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}