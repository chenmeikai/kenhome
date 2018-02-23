package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopAd implements Serializable {
    /**
     * 主键ID，广告表
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
     * 更新时间
     */
    private Date updateDate;

    /**
     * 更新者
     */
    private String updater;

    /**
     * 广告标题
     */
    private String adTitle;

    /**
     * 广告语
     */
    private String adContent;

    /**
     * 展示图片
     */
    private String showPicture;

    /**
     * 广告位置
     */
    private Integer adPossion;

    /**
     * 广告类型
     */
    private Integer adType;

    /**
     * 广告地址
     */
    private String adUrl;

    /**
     * 广告排序
     */
    private Integer sort;

    /**
     * t_shop_ad
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，广告表
     * @return ID 主键ID，广告表
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，广告表
     * @param id 主键ID，广告表
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
     * 更新者
     * @return updater 更新者
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * 更新者
     * @param updater 更新者
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * 广告标题
     * @return ad_title 广告标题
     */
    public String getAdTitle() {
        return adTitle;
    }

    /**
     * 广告标题
     * @param adTitle 广告标题
     */
    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle == null ? null : adTitle.trim();
    }

    /**
     * 广告语
     * @return ad_content 广告语
     */
    public String getAdContent() {
        return adContent;
    }

    /**
     * 广告语
     * @param adContent 广告语
     */
    public void setAdContent(String adContent) {
        this.adContent = adContent == null ? null : adContent.trim();
    }

    /**
     * 展示图片
     * @return show_picture 展示图片
     */
    public String getShowPicture() {
        return showPicture;
    }

    /**
     * 展示图片
     * @param showPicture 展示图片
     */
    public void setShowPicture(String showPicture) {
        this.showPicture = showPicture == null ? null : showPicture.trim();
    }

    /**
     * 广告位置
     * @return ad_possion 广告位置
     */
    public Integer getAdPossion() {
        return adPossion;
    }

    /**
     * 广告位置
     * @param adPossion 广告位置
     */
    public void setAdPossion(Integer adPossion) {
        this.adPossion = adPossion;
    }

    /**
     * 广告类型
     * @return ad_type 广告类型
     */
    public Integer getAdType() {
        return adType;
    }

    /**
     * 广告类型
     * @param adType 广告类型
     */
    public void setAdType(Integer adType) {
        this.adType = adType;
    }

    /**
     * 广告地址
     * @return ad_url 广告地址
     */
    public String getAdUrl() {
        return adUrl;
    }

    /**
     * 广告地址
     * @param adUrl 广告地址
     */
    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl == null ? null : adUrl.trim();
    }

    /**
     * 广告排序
     * @return sort 广告排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 广告排序
     * @param sort 广告排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
        TShopAd other = (TShopAd) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getAdTitle() == null ? other.getAdTitle() == null : this.getAdTitle().equals(other.getAdTitle()))
            && (this.getAdContent() == null ? other.getAdContent() == null : this.getAdContent().equals(other.getAdContent()))
            && (this.getShowPicture() == null ? other.getShowPicture() == null : this.getShowPicture().equals(other.getShowPicture()))
            && (this.getAdPossion() == null ? other.getAdPossion() == null : this.getAdPossion().equals(other.getAdPossion()))
            && (this.getAdType() == null ? other.getAdType() == null : this.getAdType().equals(other.getAdType()))
            && (this.getAdUrl() == null ? other.getAdUrl() == null : this.getAdUrl().equals(other.getAdUrl()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getAdTitle() == null) ? 0 : getAdTitle().hashCode());
        result = prime * result + ((getAdContent() == null) ? 0 : getAdContent().hashCode());
        result = prime * result + ((getShowPicture() == null) ? 0 : getShowPicture().hashCode());
        result = prime * result + ((getAdPossion() == null) ? 0 : getAdPossion().hashCode());
        result = prime * result + ((getAdType() == null) ? 0 : getAdType().hashCode());
        result = prime * result + ((getAdUrl() == null) ? 0 : getAdUrl().hashCode());
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
        sb.append(", creater=").append(creater);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updater=").append(updater);
        sb.append(", adTitle=").append(adTitle);
        sb.append(", adContent=").append(adContent);
        sb.append(", showPicture=").append(showPicture);
        sb.append(", adPossion=").append(adPossion);
        sb.append(", adType=").append(adType);
        sb.append(", adUrl=").append(adUrl);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}