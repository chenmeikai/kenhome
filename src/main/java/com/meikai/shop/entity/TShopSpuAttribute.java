package com.meikai.shop.entity;

import java.io.Serializable;

public class TShopSpuAttribute implements Serializable {
    /**
     * 主键Id，spu-属性关联
     */
    private Long id;

    /**
     * Spu Id
     */
    private Long spuId;

    /**
     * 属性Id
     */
    private Long attributeId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 类型
     */
    private Integer type;

    /**
     * t_shop_spu_attribute
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键Id，spu-属性关联
     * @return id 主键Id，spu-属性关联
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键Id，spu-属性关联
     * @param id 主键Id，spu-属性关联
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Spu Id
     * @return spu_id Spu Id
     */
    public Long getSpuId() {
        return spuId;
    }

    /**
     * Spu Id
     * @param spuId Spu Id
     */
    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    /**
     * 属性Id
     * @return attribute_id 属性Id
     */
    public Long getAttributeId() {
        return attributeId;
    }

    /**
     * 属性Id
     * @param attributeId 属性Id
     */
    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
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

    /**
     * 类型
     * @return type 类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型
     * @param type 类型
     */
    public void setType(Integer type) {
        this.type = type;
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
        TShopSpuAttribute other = (TShopSpuAttribute) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpuId() == null ? other.getSpuId() == null : this.getSpuId().equals(other.getSpuId()))
            && (this.getAttributeId() == null ? other.getAttributeId() == null : this.getAttributeId().equals(other.getAttributeId()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpuId() == null) ? 0 : getSpuId().hashCode());
        result = prime * result + ((getAttributeId() == null) ? 0 : getAttributeId().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
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
        sb.append(", attributeId=").append(attributeId);
        sb.append(", sort=").append(sort);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}