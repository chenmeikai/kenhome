package com.meikai.shop.entity;

import java.io.Serializable;

public class TShopSpuAttributeOption implements Serializable {
    /**
     * 主键Id,商品-属性值关联
     */
    private Long id;

    /**
     * 商品Id
     */
    private Long spuId;

    /**
     * 属性值Id
     */
    private Long attributeOptionId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * t_shop_spu_attribute_option
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键Id,商品-属性值关联
     * @return id 主键Id,商品-属性值关联
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键Id,商品-属性值关联
     * @param id 主键Id,商品-属性值关联
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 商品Id
     * @return spu_id 商品Id
     */
    public Long getSpuId() {
        return spuId;
    }

    /**
     * 商品Id
     * @param spuId 商品Id
     */
    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    /**
     * 属性值Id
     * @return attribute_option_id 属性值Id
     */
    public Long getAttributeOptionId() {
        return attributeOptionId;
    }

    /**
     * 属性值Id
     * @param attributeOptionId 属性值Id
     */
    public void setAttributeOptionId(Long attributeOptionId) {
        this.attributeOptionId = attributeOptionId;
    }

    /**
     * 排序
     * @return sort 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
        TShopSpuAttributeOption other = (TShopSpuAttributeOption) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpuId() == null ? other.getSpuId() == null : this.getSpuId().equals(other.getSpuId()))
            && (this.getAttributeOptionId() == null ? other.getAttributeOptionId() == null : this.getAttributeOptionId().equals(other.getAttributeOptionId()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpuId() == null) ? 0 : getSpuId().hashCode());
        result = prime * result + ((getAttributeOptionId() == null) ? 0 : getAttributeOptionId().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", spuId=").append(spuId);
        sb.append(", attributeOptionId=").append(attributeOptionId);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}