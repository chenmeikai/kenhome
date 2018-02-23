package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopAttrgroupAttribute implements Serializable {
    /**
     * 主键，属性组-属性关联
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 属性组Id
     */
    private Long groupId;

    /**
     * 属性Id
     */
    private Long attributeId;

    /**
     * t_shop_attrgroup_attribute
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键，属性组-属性关联
     * @return id 主键，属性组-属性关联
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键，属性组-属性关联
     * @param id 主键，属性组-属性关联
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
     * 修改时间
     * @return update_date 修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 修改时间
     * @param updateDate 修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 属性组Id
     * @return group_id 属性组Id
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 属性组Id
     * @param groupId 属性组Id
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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
        TShopAttrgroupAttribute other = (TShopAttrgroupAttribute) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getAttributeId() == null ? other.getAttributeId() == null : this.getAttributeId().equals(other.getAttributeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getAttributeId() == null) ? 0 : getAttributeId().hashCode());
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
        sb.append(", groupId=").append(groupId);
        sb.append(", attributeId=").append(attributeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}