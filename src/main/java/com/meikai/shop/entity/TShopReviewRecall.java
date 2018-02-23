package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopReviewRecall implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 评价ID
     */
    private Long reviewId;

    /**
     * 系统ID
     */
    private Long managerId;

    /**
     * 回复内容
     */
    private String content;

    /**
     * t_shop_review_recall
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
     * 评价ID
     * @return review_id 评价ID
     */
    public Long getReviewId() {
        return reviewId;
    }

    /**
     * 评价ID
     * @param reviewId 评价ID
     */
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    /**
     * 系统ID
     * @return manager_id 系统ID
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * 系统ID
     * @param managerId 系统ID
     */
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    /**
     * 回复内容
     * @return content 回复内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 回复内容
     * @param content 回复内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        TShopReviewRecall other = (TShopReviewRecall) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getReviewId() == null ? other.getReviewId() == null : this.getReviewId().equals(other.getReviewId()))
            && (this.getManagerId() == null ? other.getManagerId() == null : this.getManagerId().equals(other.getManagerId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getReviewId() == null) ? 0 : getReviewId().hashCode());
        result = prime * result + ((getManagerId() == null) ? 0 : getManagerId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
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
        sb.append(", reviewId=").append(reviewId);
        sb.append(", managerId=").append(managerId);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}