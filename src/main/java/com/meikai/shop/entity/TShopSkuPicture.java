package com.meikai.shop.entity;

import java.io.Serializable;

public class TShopSkuPicture implements Serializable {
    /**
     * 主键Id，sku-图片关联
     */
    private Long id;

    /**
     * sku ID
     */
    private Long skuId;

    /**
     * 图片名字
     */
    private String pictureName;

    /**
     * 图片地址
     */
    private String pictureUrl;

    /**
     * t_shop_sku_picture
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键Id，sku-图片关联
     * @return id 主键Id，sku-图片关联
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键Id，sku-图片关联
     * @param id 主键Id，sku-图片关联
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * sku ID
     * @return sku_id sku ID
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * sku ID
     * @param skuId sku ID
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * 图片名字
     * @return picture_name 图片名字
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
     * 图片地址
     * @return picture_url 图片地址
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
        TShopSkuPicture other = (TShopSkuPicture) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getPictureName() == null ? other.getPictureName() == null : this.getPictureName().equals(other.getPictureName()))
            && (this.getPictureUrl() == null ? other.getPictureUrl() == null : this.getPictureUrl().equals(other.getPictureUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
        result = prime * result + ((getPictureName() == null) ? 0 : getPictureName().hashCode());
        result = prime * result + ((getPictureUrl() == null) ? 0 : getPictureUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", skuId=").append(skuId);
        sb.append(", pictureName=").append(pictureName);
        sb.append(", pictureUrl=").append(pictureUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}