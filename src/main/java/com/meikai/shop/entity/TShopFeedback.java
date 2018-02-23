package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopFeedback implements Serializable {
    /**
     * 主键ID，反馈
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 用户ID
     */
    private Long memberId;

    /**
     * 反馈内容
     */
    private String content;

    /**
     * 反馈状态，默认，1：未受理，2：受理中；3、已受理；
     */
    private Integer state;

    /**
     * 备注信息
     */
    private String memo;

    /**
     * t_shop_feedback
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，反馈
     * @return ID 主键ID，反馈
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，反馈
     * @param id 主键ID，反馈
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
     * 反馈内容
     * @return CONTENT 反馈内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 反馈内容
     * @param content 反馈内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 反馈状态，默认，1：未受理，2：受理中；3、已受理；
     * @return STATE 反馈状态，默认，1：未受理，2：受理中；3、已受理；
     */
    public Integer getState() {
        return state;
    }

    /**
     * 反馈状态，默认，1：未受理，2：受理中；3、已受理；
     * @param state 反馈状态，默认，1：未受理，2：受理中；3、已受理；
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 备注信息
     * @return MEMO 备注信息
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 备注信息
     * @param memo 备注信息
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
        TShopFeedback other = (TShopFeedback) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
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
        sb.append(", memberId=").append(memberId);
        sb.append(", content=").append(content);
        sb.append(", state=").append(state);
        sb.append(", memo=").append(memo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}