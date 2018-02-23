package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopMember implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 注册时间
     */
    private Date createDate;

    /**
     * 注册IP
     */
    private String createIp;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 更新IP
     */
    private String updateIp;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码，需加密
     */
    private String password;

    /**
     * 开放ID
     */
    private String openId;

    /**
     * 注册类型:1、邮箱用户；2、手机用户；3、新浪用户；4、微信用户；5、qq用户；
     */
    private Integer openType;

    /**
     * 第三方登录时间
     */
    private Date openLoginTime;

    /**
     * 第三方登录次数
     */
    private Long openLoginNums;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别：1、男；2、女；3：未知；
     */
    private Integer sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证，需加密
     */
    private String idcard;

    /**
     * 手机
     */
    private String phone;

    /**
     * 状态：1、正常；2、冻结；
     */
    private Integer statu;

    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 尝试登录最高5次
     */
    private Integer tryNums;

    /**
     * 是否锁定，默认1：不锁定,2:锁定
     */
    private Integer isLocked;

    /**
     * 锁定时间
     */
    private Date lockedDate;

    /**
     * 登录次数
     */
    private Long loginNums;

    /**
     * 积分
     */
    private Long integrate;

    /**
     * 等级
     */
    private Integer leval;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 县区
     */
    private String county;

    /**
     * 详细地址
     */
    private String adress;

    /**
     * 激活码
     */
    private String activeCode;

    /**
     * t_shop_member
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
     * 注册时间
     * @return CREATE_DATE 注册时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 注册时间
     * @param createDate 注册时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 注册IP
     * @return CREATE_IP 注册IP
     */
    public String getCreateIp() {
        return createIp;
    }

    /**
     * 注册IP
     * @param createIp 注册IP
     */
    public void setCreateIp(String createIp) {
        this.createIp = createIp == null ? null : createIp.trim();
    }

    /**
     * 更新时间
     * @return UPDATE_DATE 更新时间
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
     * 更新IP
     * @return UPDATE_IP 更新IP
     */
    public String getUpdateIp() {
        return updateIp;
    }

    /**
     * 更新IP
     * @param updateIp 更新IP
     */
    public void setUpdateIp(String updateIp) {
        this.updateIp = updateIp == null ? null : updateIp.trim();
    }

    /**
     * 用户名
     * @return USER_NAME 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 昵称
     * @return NICKNAME 昵称
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
     * 密码，需加密
     * @return PASSWORD 密码，需加密
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码，需加密
     * @param password 密码，需加密
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 开放ID
     * @return OPEN_ID 开放ID
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 开放ID
     * @param openId 开放ID
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 注册类型:1、邮箱用户；2、手机用户；3、新浪用户；4、微信用户；5、qq用户；
     * @return OPEN_TYPE 注册类型:1、邮箱用户；2、手机用户；3、新浪用户；4、微信用户；5、qq用户；
     */
    public Integer getOpenType() {
        return openType;
    }

    /**
     * 注册类型:1、邮箱用户；2、手机用户；3、新浪用户；4、微信用户；5、qq用户；
     * @param openType 注册类型:1、邮箱用户；2、手机用户；3、新浪用户；4、微信用户；5、qq用户；
     */
    public void setOpenType(Integer openType) {
        this.openType = openType;
    }

    /**
     * 第三方登录时间
     * @return OPEN_LOGIN_TIME 第三方登录时间
     */
    public Date getOpenLoginTime() {
        return openLoginTime;
    }

    /**
     * 第三方登录时间
     * @param openLoginTime 第三方登录时间
     */
    public void setOpenLoginTime(Date openLoginTime) {
        this.openLoginTime = openLoginTime;
    }

    /**
     * 第三方登录次数
     * @return OPEN_LOGIN_NUMS 第三方登录次数
     */
    public Long getOpenLoginNums() {
        return openLoginNums;
    }

    /**
     * 第三方登录次数
     * @param openLoginNums 第三方登录次数
     */
    public void setOpenLoginNums(Long openLoginNums) {
        this.openLoginNums = openLoginNums;
    }

    /**
     * 头像
     * @return AVATAR 头像
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
     * 性别：1、男；2、女；3：未知；
     * @return SEX 性别：1、男；2、女；3：未知；
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别：1、男；2、女；3：未知；
     * @param sex 性别：1、男；2、女；3：未知；
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 生日
     * @return BIRTHDAY 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 邮箱
     * @return EMAIL 邮箱
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
     * 身份证，需加密
     * @return IDCARD 身份证，需加密
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 身份证，需加密
     * @param idcard 身份证，需加密
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * 手机
     * @return PHONE 手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机
     * @param phone 手机
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 状态：1、正常；2、冻结；
     * @return STATU 状态：1、正常；2、冻结；
     */
    public Integer getStatu() {
        return statu;
    }

    /**
     * 状态：1、正常；2、冻结；
     * @param statu 状态：1、正常；2、冻结；
     */
    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    /**
     * 登录IP
     * @return LOGIN_IP 登录IP
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
     * 登录时间
     * @return LOGIN_TIME 登录时间
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
     * 尝试登录最高5次
     * @return TRY_NUMS 尝试登录最高5次
     */
    public Integer getTryNums() {
        return tryNums;
    }

    /**
     * 尝试登录最高5次
     * @param tryNums 尝试登录最高5次
     */
    public void setTryNums(Integer tryNums) {
        this.tryNums = tryNums;
    }

    /**
     * 是否锁定，默认1：不锁定,2:锁定
     * @return IS_LOCKED 是否锁定，默认1：不锁定,2:锁定
     */
    public Integer getIsLocked() {
        return isLocked;
    }

    /**
     * 是否锁定，默认1：不锁定,2:锁定
     * @param isLocked 是否锁定，默认1：不锁定,2:锁定
     */
    public void setIsLocked(Integer isLocked) {
        this.isLocked = isLocked;
    }

    /**
     * 锁定时间
     * @return LOCKED_DATE 锁定时间
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
     * 登录次数
     * @return LOGIN_NUMS 登录次数
     */
    public Long getLoginNums() {
        return loginNums;
    }

    /**
     * 登录次数
     * @param loginNums 登录次数
     */
    public void setLoginNums(Long loginNums) {
        this.loginNums = loginNums;
    }

    /**
     * 积分
     * @return INTEGRATE 积分
     */
    public Long getIntegrate() {
        return integrate;
    }

    /**
     * 积分
     * @param integrate 积分
     */
    public void setIntegrate(Long integrate) {
        this.integrate = integrate;
    }

    /**
     * 等级
     * @return LEVAL 等级
     */
    public Integer getLeval() {
        return leval;
    }

    /**
     * 等级
     * @param leval 等级
     */
    public void setLeval(Integer leval) {
        this.leval = leval;
    }

    /**
     * 省份
     * @return province 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省份
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 城市
     * @return CITY 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 城市
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 县区
     * @return COUNTY 县区
     */
    public String getCounty() {
        return county;
    }

    /**
     * 县区
     * @param county 县区
     */
    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    /**
     * 详细地址
     * @return ADRESS 详细地址
     */
    public String getAdress() {
        return adress;
    }

    /**
     * 详细地址
     * @param adress 详细地址
     */
    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
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
        TShopMember other = (TShopMember) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateIp() == null ? other.getCreateIp() == null : this.getCreateIp().equals(other.getCreateIp()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateIp() == null ? other.getUpdateIp() == null : this.getUpdateIp().equals(other.getUpdateIp()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getOpenType() == null ? other.getOpenType() == null : this.getOpenType().equals(other.getOpenType()))
            && (this.getOpenLoginTime() == null ? other.getOpenLoginTime() == null : this.getOpenLoginTime().equals(other.getOpenLoginTime()))
            && (this.getOpenLoginNums() == null ? other.getOpenLoginNums() == null : this.getOpenLoginNums().equals(other.getOpenLoginNums()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getIdcard() == null ? other.getIdcard() == null : this.getIdcard().equals(other.getIdcard()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getStatu() == null ? other.getStatu() == null : this.getStatu().equals(other.getStatu()))
            && (this.getLoginIp() == null ? other.getLoginIp() == null : this.getLoginIp().equals(other.getLoginIp()))
            && (this.getLoginTime() == null ? other.getLoginTime() == null : this.getLoginTime().equals(other.getLoginTime()))
            && (this.getTryNums() == null ? other.getTryNums() == null : this.getTryNums().equals(other.getTryNums()))
            && (this.getIsLocked() == null ? other.getIsLocked() == null : this.getIsLocked().equals(other.getIsLocked()))
            && (this.getLockedDate() == null ? other.getLockedDate() == null : this.getLockedDate().equals(other.getLockedDate()))
            && (this.getLoginNums() == null ? other.getLoginNums() == null : this.getLoginNums().equals(other.getLoginNums()))
            && (this.getIntegrate() == null ? other.getIntegrate() == null : this.getIntegrate().equals(other.getIntegrate()))
            && (this.getLeval() == null ? other.getLeval() == null : this.getLeval().equals(other.getLeval()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
            && (this.getAdress() == null ? other.getAdress() == null : this.getAdress().equals(other.getAdress()))
            && (this.getActiveCode() == null ? other.getActiveCode() == null : this.getActiveCode().equals(other.getActiveCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateIp() == null) ? 0 : getCreateIp().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateIp() == null) ? 0 : getUpdateIp().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getOpenType() == null) ? 0 : getOpenType().hashCode());
        result = prime * result + ((getOpenLoginTime() == null) ? 0 : getOpenLoginTime().hashCode());
        result = prime * result + ((getOpenLoginNums() == null) ? 0 : getOpenLoginNums().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getIdcard() == null) ? 0 : getIdcard().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getStatu() == null) ? 0 : getStatu().hashCode());
        result = prime * result + ((getLoginIp() == null) ? 0 : getLoginIp().hashCode());
        result = prime * result + ((getLoginTime() == null) ? 0 : getLoginTime().hashCode());
        result = prime * result + ((getTryNums() == null) ? 0 : getTryNums().hashCode());
        result = prime * result + ((getIsLocked() == null) ? 0 : getIsLocked().hashCode());
        result = prime * result + ((getLockedDate() == null) ? 0 : getLockedDate().hashCode());
        result = prime * result + ((getLoginNums() == null) ? 0 : getLoginNums().hashCode());
        result = prime * result + ((getIntegrate() == null) ? 0 : getIntegrate().hashCode());
        result = prime * result + ((getLeval() == null) ? 0 : getLeval().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
        result = prime * result + ((getAdress() == null) ? 0 : getAdress().hashCode());
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
        sb.append(", createIp=").append(createIp);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateIp=").append(updateIp);
        sb.append(", userName=").append(userName);
        sb.append(", nickname=").append(nickname);
        sb.append(", password=").append(password);
        sb.append(", openId=").append(openId);
        sb.append(", openType=").append(openType);
        sb.append(", openLoginTime=").append(openLoginTime);
        sb.append(", openLoginNums=").append(openLoginNums);
        sb.append(", avatar=").append(avatar);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", email=").append(email);
        sb.append(", idcard=").append(idcard);
        sb.append(", phone=").append(phone);
        sb.append(", statu=").append(statu);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", tryNums=").append(tryNums);
        sb.append(", isLocked=").append(isLocked);
        sb.append(", lockedDate=").append(lockedDate);
        sb.append(", loginNums=").append(loginNums);
        sb.append(", integrate=").append(integrate);
        sb.append(", leval=").append(leval);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", adress=").append(adress);
        sb.append(", activeCode=").append(activeCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}