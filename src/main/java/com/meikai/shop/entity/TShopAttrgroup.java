package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopAttrgroup implements Serializable {
    /**
     * 主键ID，属性组
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
     * 属性组名
     */
    private String groupName;

    /**
     * t_shop_attrgroup
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，属性组
     * @return id 主键ID，属性组
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，属性组
     * @param id 主键ID，属性组
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
     * 属性组名
     * @return group_name 属性组名
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 属性组名
     * @param groupName 属性组名
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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
        TShopAttrgroup other = (TShopAttrgroup) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
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
        sb.append(", groupName=").append(groupName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}