package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopNoticeReceiver implements Serializable {
    /**
     * 主键ID，通告获得者关联
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 通告ID
     */
    private Long noticeId;

    /**
     * 用户ID
     */
    private Long memberId;

    /**
     * 是否已阅，默认1：未阅，2：已阅
     */
    private Integer isReaded;

    /**
     * 已阅时间
     */
    private Date readedDate;

    /**
     * t_shop_notice_receiver
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，通告获得者关联
     * @return ID 主键ID，通告获得者关联
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，通告获得者关联
     * @param id 主键ID，通告获得者关联
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
     * 通告ID
     * @return notice_id 通告ID
     */
    public Long getNoticeId() {
        return noticeId;
    }

    /**
     * 通告ID
     * @param noticeId 通告ID
     */
    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    /**
     * 用户ID
     * @return member_id 用户ID
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
     * 是否已阅，默认1：未阅，2：已阅
     * @return is_readed 是否已阅，默认1：未阅，2：已阅
     */
    public Integer getIsReaded() {
        return isReaded;
    }

    /**
     * 是否已阅，默认1：未阅，2：已阅
     * @param isReaded 是否已阅，默认1：未阅，2：已阅
     */
    public void setIsReaded(Integer isReaded) {
        this.isReaded = isReaded;
    }

    /**
     * 已阅时间
     * @return readed_date 已阅时间
     */
    public Date getReadedDate() {
        return readedDate;
    }

    /**
     * 已阅时间
     * @param readedDate 已阅时间
     */
    public void setReadedDate(Date readedDate) {
        this.readedDate = readedDate;
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
        TShopNoticeReceiver other = (TShopNoticeReceiver) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getNoticeId() == null ? other.getNoticeId() == null : this.getNoticeId().equals(other.getNoticeId()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getIsReaded() == null ? other.getIsReaded() == null : this.getIsReaded().equals(other.getIsReaded()))
            && (this.getReadedDate() == null ? other.getReadedDate() == null : this.getReadedDate().equals(other.getReadedDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getNoticeId() == null) ? 0 : getNoticeId().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getIsReaded() == null) ? 0 : getIsReaded().hashCode());
        result = prime * result + ((getReadedDate() == null) ? 0 : getReadedDate().hashCode());
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
        sb.append(", noticeId=").append(noticeId);
        sb.append(", memberId=").append(memberId);
        sb.append(", isReaded=").append(isReaded);
        sb.append(", readedDate=").append(readedDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}