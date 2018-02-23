package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSystemAcl implements Serializable {
    /**
     * 主键ID
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
     * 创建者，不用ID存储是因为创建者被删将不知道是谁，故采用不可修改的用户名
     */
    private String creater;

    /**
     * 修改者
     */
    private String updater;

    /**
     * 资源名
     */
    private String aclName;

    /**
     * 资源地址，注：地址不带上服务器部分，方便日后迁移服务器
     */
    private String aclUrl;

    /**
     * 资源等级，1:父菜单，2:子菜单，3：第三级；
     */
    private Integer aclGrade;

    /**
     * 资源类型
     */
    private Integer aclType;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 图标
     */
    private String icon;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer sort;
    
    
    /**
     * 子资源
     */
    private List<TSystemAcl> childrenAcls = new ArrayList<TSystemAcl>();

    /**
     * t_system_acl
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
     * 创建者，不用ID存储是因为创建者被删将不知道是谁，故采用不可修改的用户名
     * @return creater 创建者，不用ID存储是因为创建者被删将不知道是谁，故采用不可修改的用户名
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 创建者，不用ID存储是因为创建者被删将不知道是谁，故采用不可修改的用户名
     * @param creater 创建者，不用ID存储是因为创建者被删将不知道是谁，故采用不可修改的用户名
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * 创建者
     * @return updater 创建者
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * 创建者
     * @param updater 创建者
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * 修改者
     * @return acl_name 修改者
     */
    public String getAclName() {
        return aclName;
    }

    /**
     * 修改者
     * @param aclName 修改者
     */
    public void setAclName(String aclName) {
        this.aclName = aclName == null ? null : aclName.trim();
    }

    /**
     * 资源地址，注：地址不带上服务器部分，方便日后迁移服务器
     * @return acl_url 资源地址，注：地址不带上服务器部分，方便日后迁移服务器
     */
    public String getAclUrl() {
        return aclUrl;
    }

    /**
     * 资源地址，注：地址不带上服务器部分，方便日后迁移服务器
     * @param aclUrl 资源地址，注：地址不带上服务器部分，方便日后迁移服务器
     */
    public void setAclUrl(String aclUrl) {
        this.aclUrl = aclUrl == null ? null : aclUrl.trim();
    }

    /**
     * 资源等级，1:父菜单，2:子菜单，3：第三级；
     * @return acl_grade 资源等级，1:父菜单，2:子菜单，3：第三级；
     */
    public Integer getAclGrade() {
        return aclGrade;
    }

    /**
     * 资源等级，1:父菜单，2:子菜单，3：第三级；
     * @param aclGrade 资源等级，1:父菜单，2:子菜单，3：第三级；
     */
    public void setAclGrade(Integer aclGrade) {
        this.aclGrade = aclGrade;
    }

    /**
     * 资源类型
     * @return acl_type 资源类型
     */
    public Integer getAclType() {
        return aclType;
    }

    /**
     * 资源类型
     * @param aclType 资源类型
     */
    public void setAclType(Integer aclType) {
        this.aclType = aclType;
    }

    /**
     * 权限标识
     * @return permission 权限标识
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 权限标识
     * @param permission 权限标识
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * 图标
     * @return icon 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 图标
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 父级ID
     * @return parent_id 父级ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父级ID
     * @param parentId 父级ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * 子资源
     * @return
     */
    public List<TSystemAcl> getChildrenAcls() {
		return childrenAcls;
	}
    
    /**
     * 子资源
     * @return
     */
	public void setChildrenAcls(List<TSystemAcl> childrenAcls) {
		this.childrenAcls = childrenAcls;
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
        TSystemAcl other = (TSystemAcl) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getAclName() == null ? other.getAclName() == null : this.getAclName().equals(other.getAclName()))
            && (this.getAclUrl() == null ? other.getAclUrl() == null : this.getAclUrl().equals(other.getAclUrl()))
            && (this.getAclGrade() == null ? other.getAclGrade() == null : this.getAclGrade().equals(other.getAclGrade()))
            && (this.getAclType() == null ? other.getAclType() == null : this.getAclType().equals(other.getAclType()))
            && (this.getPermission() == null ? other.getPermission() == null : this.getPermission().equals(other.getPermission()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()));
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
        result = prime * result + ((getAclName() == null) ? 0 : getAclName().hashCode());
        result = prime * result + ((getAclUrl() == null) ? 0 : getAclUrl().hashCode());
        result = prime * result + ((getAclGrade() == null) ? 0 : getAclGrade().hashCode());
        result = prime * result + ((getAclType() == null) ? 0 : getAclType().hashCode());
        result = prime * result + ((getPermission() == null) ? 0 : getPermission().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
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
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", creater=").append(creater);
        sb.append(", updater=").append(updater);
        sb.append(", aclName=").append(aclName);
        sb.append(", aclUrl=").append(aclUrl);
        sb.append(", aclGrade=").append(aclGrade);
        sb.append(", aclType=").append(aclType);
        sb.append(", permission=").append(permission);
        sb.append(", icon=").append(icon);
        sb.append(", parentId=").append(parentId);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}