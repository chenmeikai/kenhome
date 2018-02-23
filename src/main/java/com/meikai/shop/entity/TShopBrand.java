package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopBrand implements Serializable {
    /**
     * 主键ID，品牌
     */
    private Long id;

    /**
     * 品牌名
     */
    private String brandName;

    /**
     * 英文名
     */
    private String enName;

    /**
     * 别名
     */
    private String aliasName;

    /**
     * 凭证，图片地址
     */
    private String token;

    /**
     * 介绍
     */
    private String description;

    /**
     * logo图片地址
     */
    private String logo;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态
     */
    private Integer statu;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * t_shop_brand
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，品牌
     * @return ID 主键ID，品牌
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，品牌
     * @param id 主键ID，品牌
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 品牌名
     * @return BRAND_NAME 品牌名
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 品牌名
     * @param brandName 品牌名
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 英文名
     * @return EN_NAME 英文名
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 英文名
     * @param enName 英文名
     */
    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    /**
     * 别名
     * @return ALIAS_NAME 别名
     */
    public String getAliasName() {
        return aliasName;
    }

    /**
     * 别名
     * @param aliasName 别名
     */
    public void setAliasName(String aliasName) {
        this.aliasName = aliasName == null ? null : aliasName.trim();
    }

    /**
     * 凭证，图片地址
     * @return TOKEN 凭证，图片地址
     */
    public String getToken() {
        return token;
    }

    /**
     * 凭证，图片地址
     * @param token 凭证，图片地址
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * 介绍
     * @return DESCRIPTION 介绍
     */
    public String getDescription() {
        return description;
    }

    /**
     * 介绍
     * @param description 介绍
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * logo图片地址
     * @return LOGO logo图片地址
     */
    public String getLogo() {
        return logo;
    }

    /**
     * logo图片地址
     * @param logo logo图片地址
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * 排序
     * @return SORT 排序
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
     * 状态
     * @return STATU 状态
     */
    public Integer getStatu() {
        return statu;
    }

    /**
     * 状态
     * @param statu 状态
     */
    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    /**
     * 创建时间
     * @return CREATE_DATE 创建时间
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
     * @return UPDATE_DATE 修改时间
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
        TShopBrand other = (TShopBrand) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBrandName() == null ? other.getBrandName() == null : this.getBrandName().equals(other.getBrandName()))
            && (this.getEnName() == null ? other.getEnName() == null : this.getEnName().equals(other.getEnName()))
            && (this.getAliasName() == null ? other.getAliasName() == null : this.getAliasName().equals(other.getAliasName()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getStatu() == null ? other.getStatu() == null : this.getStatu().equals(other.getStatu()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBrandName() == null) ? 0 : getBrandName().hashCode());
        result = prime * result + ((getEnName() == null) ? 0 : getEnName().hashCode());
        result = prime * result + ((getAliasName() == null) ? 0 : getAliasName().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getStatu() == null) ? 0 : getStatu().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandName=").append(brandName);
        sb.append(", enName=").append(enName);
        sb.append(", aliasName=").append(aliasName);
        sb.append(", token=").append(token);
        sb.append(", description=").append(description);
        sb.append(", logo=").append(logo);
        sb.append(", sort=").append(sort);
        sb.append(", statu=").append(statu);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}