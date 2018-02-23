package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TSystemRoleAcl implements Serializable {
    /**
     * 主键ID，角色-资源关系表
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
     * 角色ID
     */
    private Long roleId;

    /**
     * 资源ID
     */
    private Long aclId;

    /**
     * t_system_role_acl
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，角色-资源关系表
     * @return ID 主键ID，角色-资源关系表
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，角色-资源关系表
     * @param id 主键ID，角色-资源关系表
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
     * 创建者
     * @return creater 创建者
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
     * 角色ID
     * @return role_id 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 角色ID
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 资源ID
     * @return acl_id 资源ID
     */
    public Long getAclId() {
        return aclId;
    }

    /**
     * 资源ID
     * @param aclId 资源ID
     */
    public void setAclId(Long aclId) {
        this.aclId = aclId;
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
        TSystemRoleAcl other = (TSystemRoleAcl) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getAclId() == null ? other.getAclId() == null : this.getAclId().equals(other.getAclId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getAclId() == null) ? 0 : getAclId().hashCode());
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
        sb.append(", roleId=").append(roleId);
        sb.append(", aclId=").append(aclId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}