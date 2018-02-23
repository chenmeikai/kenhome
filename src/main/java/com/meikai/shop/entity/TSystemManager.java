package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSystemManager implements Serializable {
    /**
     * 主键ID，管理员表
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
     * 管理员名
     */
    private String managerName;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 是否启用，默认1：不启用，2：启用；
     */
    private Integer isEnable;

    /**
     * 是否锁定，默认1：不锁定，2：锁定
     */
    private Integer isLocked;

    /**
     * 尝试登录次数，最高5次
     */
    private Integer tryNum;

    /**
     * 锁定时间
     */
    private Date lockedDate;

    /**
     * 是否永久保留，不可删除，默认1：不内置，2：内置；
     */
    private Integer isForver;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 激活码
     */
    private String activeCode;
    
    
    /**
     * 角色集合
     */
    private List<TSystemRole> roles = new ArrayList<TSystemRole>();
    

    /**
     * t_system_manager
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，管理员表
     * @return ID 主键ID，管理员表
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，管理员表
     * @param id 主键ID，管理员表
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
     * 管理员名
     * @return manager_name 管理员名
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * 管理员名
     * @param managerName 管理员名
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    /**
     * 昵称
     * @return nickname 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 头像
     * @return avatar 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 头像
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 是否启用，默认1：不启用，2：启用；
     * @return is_enable 是否启用，默认1：不启用，2：启用；
     */
    public Integer getIsEnable() {
        return isEnable;
    }

    /**
     * 是否启用，默认1：不启用，2：启用；
     * @param isEnable 是否启用，默认1：不启用，2：启用；
     */
    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 是否锁定，默认1：不锁定，2：锁定
     * @return is_locked 是否锁定，默认1：不锁定，2：锁定
     */
    public Integer getIsLocked() {
        return isLocked;
    }

    /**
     * 是否锁定，默认1：不锁定，2：锁定
     * @param isLocked 是否锁定，默认1：不锁定，2：锁定
     */
    public void setIsLocked(Integer isLocked) {
        this.isLocked = isLocked;
    }

    /**
     * 尝试登录次数，最高5次
     * @return try_num 尝试登录次数，最高5次
     */
    public Integer getTryNum() {
        return tryNum;
    }

    /**
     * 尝试登录次数，最高5次
     * @param tryNum 尝试登录次数，最高5次
     */
    public void setTryNum(Integer tryNum) {
        this.tryNum = tryNum;
    }

    /**
     * 锁定时间
     * @return locked_date 锁定时间
     */
    public Date getLockedDate() {
        return lockedDate;
    }

    /**
     * 锁定时间
     * @param lockedDate 锁定时间
     */
    public void setLockedDate(Date lockedDate) {
        this.lockedDate = lockedDate;
    }

    /**
     * 是否永久保留，不可删除，默认1：不内置，2：内置；
     * @return is_forver 是否永久保留，不可删除，默认1：不内置，2：内置；
     */
    public Integer getIsForver() {
        return isForver;
    }

    /**
     * 是否永久保留，不可删除，默认1：不内置，2：内置；
     * @param isForver 是否永久保留，不可删除，默认1：不内置，2：内置；
     */
    public void setIsForver(Integer isForver) {
        this.isForver = isForver;
    }

    /**
     * 登录时间
     * @return login_time 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 登录时间
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 登录IP
     * @return login_ip 登录IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 登录IP
     * @param loginIp 登录IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 激活码
     * @return active_code 激活码
     */
    public String getActiveCode() {
        return activeCode;
    }
   
    /**
     * 激活码
     * @param activeCode 激活码
     */
    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode == null ? null : activeCode.trim();
    }
    
    
    /**
     * 角色集合
     * @return
     */
    public List<TSystemRole> getRoles() {
		return roles;
	}
    
    
    /**
     * 角色集合
     * @return
     */
	public void setRoles(List<TSystemRole> roles) {
		this.roles = roles;
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
        TSystemManager other = (TSystemManager) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getManagerName() == null ? other.getManagerName() == null : this.getManagerName().equals(other.getManagerName()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable()))
            && (this.getIsLocked() == null ? other.getIsLocked() == null : this.getIsLocked().equals(other.getIsLocked()))
            && (this.getTryNum() == null ? other.getTryNum() == null : this.getTryNum().equals(other.getTryNum()))
            && (this.getLockedDate() == null ? other.getLockedDate() == null : this.getLockedDate().equals(other.getLockedDate()))
            && (this.getIsForver() == null ? other.getIsForver() == null : this.getIsForver().equals(other.getIsForver()))
            && (this.getLoginTime() == null ? other.getLoginTime() == null : this.getLoginTime().equals(other.getLoginTime()))
            && (this.getLoginIp() == null ? other.getLoginIp() == null : this.getLoginIp().equals(other.getLoginIp()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getActiveCode() == null ? other.getActiveCode() == null : this.getActiveCode().equals(other.getActiveCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getManagerName() == null) ? 0 : getManagerName().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getIsEnable() == null) ? 0 : getIsEnable().hashCode());
        result = prime * result + ((getIsLocked() == null) ? 0 : getIsLocked().hashCode());
        result = prime * result + ((getTryNum() == null) ? 0 : getTryNum().hashCode());
        result = prime * result + ((getLockedDate() == null) ? 0 : getLockedDate().hashCode());
        result = prime * result + ((getIsForver() == null) ? 0 : getIsForver().hashCode());
        result = prime * result + ((getLoginTime() == null) ? 0 : getLoginTime().hashCode());
        result = prime * result + ((getLoginIp() == null) ? 0 : getLoginIp().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getActiveCode() == null) ? 0 : getActiveCode().hashCode());
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
        sb.append(", managerName=").append(managerName);
        sb.append(", nickname=").append(nickname);
        sb.append(", password=").append(password);
        sb.append(", avatar=").append(avatar);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", isLocked=").append(isLocked);
        sb.append(", tryNum=").append(tryNum);
        sb.append(", lockedDate=").append(lockedDate);
        sb.append(", isForver=").append(isForver);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", email=").append(email);
        sb.append(", activeCode=").append(activeCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}