package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopNotice implements Serializable {
    /**
     * 主键ID，通告
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 标题
     */
    private String title;

    /**
     * 是否撤销，默认1、不撤销；2、撤销；
     */
    private Integer isCancel;

    /**
     * 撤销时间
     */
    private Date cancelDate;

    /**
     * 是否删除，默认1、不删除；2、删除；
     */
    private Integer isDelete;

    /**
     * 删除时间
     */
    private Date deleteDate;

    /**
     * 优先级,1:紧急，2:高，3:普通
     */
    private Integer grade;

    /**
     * 通告类型
     */
    private Integer noticeType;

    /**
     * 用户类型,1:个人；2：某类型用户；3：全体。
     */
    private Integer receiverType;

    /**
     * 角色ID，要发送的某个角色
     */
    private Long roleId;

    /**
     * 已阅次数
     */
    private Long readedNum;

    /**
     * 内容
     */
    private String content;

    /**
     * t_shop_notice
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，通告
     * @return ID 主键ID，通告
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，通告
     * @param id 主键ID，通告
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 创建时间
     * @return create_Date 创建时间
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
     * 标题
     * @return title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 是否撤销，默认1、不撤销；2、撤销；
     * @return is_cancel 是否撤销，默认1、不撤销；2、撤销；
     */
    public Integer getIsCancel() {
        return isCancel;
    }

    /**
     * 是否撤销，默认1、不撤销；2、撤销；
     * @param isCancel 是否撤销，默认1、不撤销；2、撤销；
     */
    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    /**
     * 撤销时间
     * @return cancel_Date 撤销时间
     */
    public Date getCancelDate() {
        return cancelDate;
    }

    /**
     * 撤销时间
     * @param cancelDate 撤销时间
     */
    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    /**
     * 是否删除，默认1、不删除；2、删除；
     * @return is_delete 是否删除，默认1、不删除；2、删除；
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除，默认1、不删除；2、删除；
     * @param isDelete 是否删除，默认1、不删除；2、删除；
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 删除时间
     * @return delete_date 删除时间
     */
    public Date getDeleteDate() {
        return deleteDate;
    }

    /**
     * 删除时间
     * @param deleteDate 删除时间
     */
    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    /**
     * 优先级,1:紧急，2:高，3:普通
     * @return grade 优先级,1:紧急，2:高，3:普通
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 优先级,1:紧急，2:高，3:普通
     * @param grade 优先级,1:紧急，2:高，3:普通
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 通告类型
     * @return notice_type 通告类型
     */
    public Integer getNoticeType() {
        return noticeType;
    }

    /**
     * 通告类型
     * @param noticeType 通告类型
     */
    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    /**
     * 用户类型,1:个人；2：某类型用户；3：全体。
     * @return receiver_type 用户类型,1:个人；2：某类型用户；3：全体。
     */
    public Integer getReceiverType() {
        return receiverType;
    }

    /**
     * 用户类型,1:个人；2：某类型用户；3：全体。
     * @param receiverType 用户类型,1:个人；2：某类型用户；3：全体。
     */
    public void setReceiverType(Integer receiverType) {
        this.receiverType = receiverType;
    }

    /**
     * 角色ID，要发送的某个角色
     * @return role_id 角色ID，要发送的某个角色
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 角色ID，要发送的某个角色
     * @param roleId 角色ID，要发送的某个角色
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 已阅次数
     * @return readed_num 已阅次数
     */
    public Long getReadedNum() {
        return readedNum;
    }

    /**
     * 已阅次数
     * @param readedNum 已阅次数
     */
    public void setReadedNum(Long readedNum) {
        this.readedNum = readedNum;
    }

    /**
     * 内容
     * @return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
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
        TShopNotice other = (TShopNotice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getIsCancel() == null ? other.getIsCancel() == null : this.getIsCancel().equals(other.getIsCancel()))
            && (this.getCancelDate() == null ? other.getCancelDate() == null : this.getCancelDate().equals(other.getCancelDate()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getDeleteDate() == null ? other.getDeleteDate() == null : this.getDeleteDate().equals(other.getDeleteDate()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getNoticeType() == null ? other.getNoticeType() == null : this.getNoticeType().equals(other.getNoticeType()))
            && (this.getReceiverType() == null ? other.getReceiverType() == null : this.getReceiverType().equals(other.getReceiverType()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getReadedNum() == null ? other.getReadedNum() == null : this.getReadedNum().equals(other.getReadedNum()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getIsCancel() == null) ? 0 : getIsCancel().hashCode());
        result = prime * result + ((getCancelDate() == null) ? 0 : getCancelDate().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getDeleteDate() == null) ? 0 : getDeleteDate().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getNoticeType() == null) ? 0 : getNoticeType().hashCode());
        result = prime * result + ((getReceiverType() == null) ? 0 : getReceiverType().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getReadedNum() == null) ? 0 : getReadedNum().hashCode());
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
        sb.append(", title=").append(title);
        sb.append(", isCancel=").append(isCancel);
        sb.append(", cancelDate=").append(cancelDate);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", deleteDate=").append(deleteDate);
        sb.append(", grade=").append(grade);
        sb.append(", noticeType=").append(noticeType);
        sb.append(", receiverType=").append(receiverType);
        sb.append(", roleId=").append(roleId);
        sb.append(", readedNum=").append(readedNum);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}