package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class TSystemManagerRole implements Serializable {
    /**
     * 主键ID，管理员-角色关系表
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 管理员ID
     */
    private Long managerId;

    /**
     * 角色ID
     */
    private Long roleId;
    
    /**
     * 是否内置
     */
    private Integer isSystem;
    
    /**
     * 管理员名字
     */
    private String managerName;
    
    
    /**
     * 角色名称
     */
    private String roleName;
    

    /**
     * t_system_manager_role
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，管理员-角色关系表
     * @return ID 主键ID，管理员-角色关系表
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，管理员-角色关系表
     * @param id 主键ID，管理员-角色关系表
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
     * 管理员ID
     * @return manager_id 管理员ID
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * 管理员ID
     * @param managerId 管理员ID
     */
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
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
     * 获得是否内置
     * @return
     */
    public Integer getIsSystem() {
		return isSystem;
	}
    /**
     * 设置是否内置
     * @param isSystem
     */
	public void setIsSystem(Integer isSystem) {
		this.isSystem = isSystem;
	}
    
	/**
	 * 获得管理员名字
	 * @return
	 */
	public String getManagerName() {
		return managerName;
	}
    /**
     * 设置管理员名字
     * @param managerName
     */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
    
	/**
	 * 获得角色名
	 * @return
	 */
	public String getRoleName() {
		return roleName;
	}
    /**
     * 设置角色名
     * @param roleName
     */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	        TSystemManagerRole other = (TSystemManagerRole) that;
	        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
	            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
	            && (this.getManagerId() == null ? other.getManagerId() == null : this.getManagerId().equals(other.getManagerId()))
	            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
	            && (this.getIsSystem() == null ? other.getIsSystem() == null : this.getIsSystem().equals(other.getIsSystem()));
	    }

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
	        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
	        result = prime * result + ((getManagerId() == null) ? 0 : getManagerId().hashCode());
	        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
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
	        sb.append(", managerId=").append(managerId);
	        sb.append(", roleId=").append(roleId);
	        sb.append(", isSystem=").append(isSystem);
	        sb.append(", serialVersionUID=").append(serialVersionUID);
	        sb.append("]");
	        return sb.toString();
	    }
}
	    