package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSystemRole implements Serializable {
    /**
     * 主键ID，角色表
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
     * 创建者
     */
    private String creater;

    /**
     * 修改者
     */
    private String updater;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否内置，不可改，默认1：不内置，2：内置
     */
    private Integer isSystem;
    
    
    /**
     * 资源集合
     */
    private List<TSystemAcl> acls = new ArrayList<TSystemAcl>();

    
    /**
     * t_system_role
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，角色表
     * @return ID 主键ID，角色表
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，角色表
     * @param id 主键ID，角色表
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
     * 修改者
     * @return updater 修改者
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * 修改者
     * @param updater 修改者
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * 角色名
     * @return role_name 角色名
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名
     * @param roleName 角色名
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 描述
     * @return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 是否内置，不可改，默认1：不内置，2：内置
     * @return is_system 是否内置，不可改，默认1：不内置，2：内置
     */
    public Integer getIsSystem() {
        return isSystem;
    }

    /**
     * 是否内置，不可改，默认1：不内置，2：内置
     * @param isSystem 是否内置，不可改，默认1：不内置，2：内置
     */
    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }
    
    
    /**
     * 资源集合
     * @return
     */
    public List<TSystemAcl> getAcls() {
		return acls;
	}
    
    /**
     * 资源集合
     * @return
     */
	public void setAcls(List<TSystemAcl> acls) {
		this.acls = acls;
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
        TSystemRole other = (TSystemRole) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getIsSystem() == null ? other.getIsSystem() == null : this.getIsSystem().equals(other.getIsSystem()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getIsSystem() == null) ? 0 : getIsSystem().hashCode());
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
        sb.append(", creater=").append(creater);
        sb.append(", updater=").append(updater);
        sb.append(", roleName=").append(roleName);
        sb.append(", description=").append(description);
        sb.append(", isSystem=").append(isSystem);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}