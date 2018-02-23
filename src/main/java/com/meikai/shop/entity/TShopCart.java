package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopCart implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * t_shop_cart
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
     * 会员ID
     * @return MEMBER_ID 会员ID
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * 会员ID
     * @param memberId 会员ID
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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
        TShopCart other = (TShopCart) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}