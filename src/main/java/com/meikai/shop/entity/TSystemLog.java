package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TSystemLog implements Serializable {
    /**
     * 主键ID，系统日志表
     */
    private Long id;

    /**
     * 操作时间
     */
    private Date createDate;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 操作ip
     */
    private String operateIp;

    /**
     * 操作功能
     */
    private String operation;

    /**
     * 操作内容
     */
    private String content;

    /**
     * 具体参数
     */
    private String parameter;

    /**
     * t_system_log
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，系统日志表
     * @return ID 主键ID，系统日志表
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，系统日志表
     * @param id 主键ID，系统日志表
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 操作时间
     * @return create_date 操作时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 操作时间
     * @param createDate 操作时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 操作员
     * @return operator 操作员
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 操作员
     * @param operator 操作员
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 操作ip
     * @return operate_ip 操作ip
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * 操作ip
     * @param operateIp 操作ip
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }

    /**
     * 操作功能
     * @return operation 操作功能
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 操作功能
     * @param operation 操作功能
     */
    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    /**
     * 操作内容
     * @return content 操作内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 操作内容
     * @param content 操作内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 具体参数
     * @return parameter 具体参数
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * 具体参数
     * @param parameter 具体参数
     */
    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
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
        TSystemLog other = (TSystemLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
            && (this.getOperateIp() == null ? other.getOperateIp() == null : this.getOperateIp().equals(other.getOperateIp()))
            && (this.getOperation() == null ? other.getOperation() == null : this.getOperation().equals(other.getOperation()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getParameter() == null ? other.getParameter() == null : this.getParameter().equals(other.getParameter()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getOperateIp() == null) ? 0 : getOperateIp().hashCode());
        result = prime * result + ((getOperation() == null) ? 0 : getOperation().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getParameter() == null) ? 0 : getParameter().hashCode());
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
        sb.append(", operator=").append(operator);
        sb.append(", operateIp=").append(operateIp);
        sb.append(", operation=").append(operation);
        sb.append(", content=").append(content);
        sb.append(", parameter=").append(parameter);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}