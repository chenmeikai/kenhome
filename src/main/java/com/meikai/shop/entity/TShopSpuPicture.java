package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopSpuPicture implements Serializable {
    /**
     * 主键ID，商品图片
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
     * 图片地址
     */
    private String pictureUrl;

    /**
     * 图片名字
     */
    private String pictureName;

    /**
     * SPU ID
     */
    private Long spuId;

    /**
     * t_shop_spu_picture
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，商品图片
     * @return ID 主键ID，商品图片
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，商品图片
     * @param id 主键ID，商品图片
     */
    public void setId(Long id) {
        this.id = id;
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
     * 创建者
     * @return CREATER 创建者
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
     * 更新者
     * @return UPDATER 更新者
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
     * 图片地址
     * @return PICTURE_URL 图片地址
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * 图片地址
     * @param pictureUrl 图片地址
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    /**
     * 图片名字
     * @return PICTURE_NAME 图片名字
     */
    public String getPictureName() {
        return pictureName;
    }

    /**
     * 图片名字
     * @param pictureName 图片名字
     */
    public void setPictureName(String pictureName) {
        this.pictureName = pictureName == null ? null : pictureName.trim();
    }

    /**
     * SPU ID
     * @return SPU_ID SPU ID
     */
    public Long getSpuId() {
        return spuId;
    }

    /**
     * SPU ID
     * @param spuId SPU ID
     */
    public void setSpuId(Long spuId) {
        this.spuId = spuId;
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
        TShopSpuPicture other = (TShopSpuPicture) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getPictureUrl() == null ? other.getPictureUrl() == null : this.getPictureUrl().equals(other.getPictureUrl()))
            && (this.getPictureName() == null ? other.getPictureName() == null : this.getPictureName().equals(other.getPictureName()))
            && (this.getSpuId() == null ? other.getSpuId() == null : this.getSpuId().equals(other.getSpuId()));
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
        result = prime * result + ((getPictureUrl() == null) ? 0 : getPictureUrl().hashCode());
        result = prime * result + ((getPictureName() == null) ? 0 : getPictureName().hashCode());
        result = prime * result + ((getSpuId() == null) ? 0 : getSpuId().hashCode());
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
        sb.append(", pictureUrl=").append(pictureUrl);
        sb.append(", pictureName=").append(pictureName);
        sb.append(", spuId=").append(spuId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}