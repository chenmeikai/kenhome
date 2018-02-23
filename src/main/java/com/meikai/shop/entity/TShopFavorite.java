package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopFavorite implements Serializable {
    /**
     * 主键ID，单品收藏
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 用户ID
     */
    private Long memberId;

    /**
     * 单品ID
     */
    private Long skuId;

    /**
     * t_shop_favorite
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，单品收藏
     * @return ID 主键ID，单品收藏
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，单品收藏
     * @param id 主键ID，单品收藏
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
     * 用户ID
     * @return MEMBER_ID 用户ID
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * 用户ID
     * @param memberId 用户ID
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * 单品ID
     * @return SKU_ID 单品ID
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * 单品ID
     * @param skuId 单品ID
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
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
        TShopFavorite other = (TShopFavorite) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
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
        sb.append(", memberId=").append(memberId);
        sb.append(", skuId=").append(skuId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}