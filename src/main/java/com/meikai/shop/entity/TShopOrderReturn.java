package com.meikai.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TShopOrderReturn implements Serializable {
    /**
     * 主键ID，退货
     */
    private Long id;

    /**
     * 退货编号
     */
    private Integer returnNo;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 物流ID
     */
    private Long logisticId;

    /**
     * 退货类型：1.部分退货；2.全部退货。
     */
    private Integer returnType;

    /**
     * 处理方式：1.PUPAWAY:退货入库;2.REDELIVERY:重新发货;3.RECLAIM-REDELIVERY:不要求归还并重新发货; 4.REFUND:退款; 5.COMPENSATION:不退货并赔偿
     */
    private Integer handingWay;

    /**
     * 退款金额
     */
    private BigDecimal returnAmount;

    /**
     * 退货申请日期
     */
    private Date returnSubmitDate;

    /**
     * 退货处理时间
     */
    private Date returnHandingDate;

    /**
     * 已处理时间
     */
    private Date returnEndDate;

    /**
     * 退货理由
     */
    private String returnReason;

    /**
     * t_shop_order_return
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，退货
     * @return ID 主键ID，退货
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，退货
     * @param id 主键ID，退货
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 退货编号
     * @return RETURN_NO 退货编号
     */
    public Integer getReturnNo() {
        return returnNo;
    }

    /**
     * 退货编号
     * @param returnNo 退货编号
     */
    public void setReturnNo(Integer returnNo) {
        this.returnNo = returnNo;
    }

    /**
     * 订单ID
     * @return ORDER_ID 订单ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 订单ID
     * @param orderId 订单ID
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 物流ID
     * @return LOGISTIC_ID 物流ID
     */
    public Long getLogisticId() {
        return logisticId;
    }

    /**
     * 物流ID
     * @param logisticId 物流ID
     */
    public void setLogisticId(Long logisticId) {
        this.logisticId = logisticId;
    }

    /**
     * 退货类型：1.部分退货；2.全部退货。
     * @return RETURN_TYPE 退货类型：1.部分退货；2.全部退货。
     */
    public Integer getReturnType() {
        return returnType;
    }

    /**
     * 退货类型：1.部分退货；2.全部退货。
     * @param returnType 退货类型：1.部分退货；2.全部退货。
     */
    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }

    /**
     * 处理方式：1.PUPAWAY:退货入库;2.REDELIVERY:重新发货;3.RECLAIM-REDELIVERY:不要求归还并重新发货; 4.REFUND:退款; 5.COMPENSATION:不退货并赔偿
     * @return HANDING_WAY 处理方式：1.PUPAWAY:退货入库;2.REDELIVERY:重新发货;3.RECLAIM-REDELIVERY:不要求归还并重新发货; 4.REFUND:退款; 5.COMPENSATION:不退货并赔偿
     */
    public Integer getHandingWay() {
        return handingWay;
    }

    /**
     * 处理方式：1.PUPAWAY:退货入库;2.REDELIVERY:重新发货;3.RECLAIM-REDELIVERY:不要求归还并重新发货; 4.REFUND:退款; 5.COMPENSATION:不退货并赔偿
     * @param handingWay 处理方式：1.PUPAWAY:退货入库;2.REDELIVERY:重新发货;3.RECLAIM-REDELIVERY:不要求归还并重新发货; 4.REFUND:退款; 5.COMPENSATION:不退货并赔偿
     */
    public void setHandingWay(Integer handingWay) {
        this.handingWay = handingWay;
    }

    /**
     * 退款金额
     * @return RETURN_AMOUNT 退款金额
     */
    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    /**
     * 退款金额
     * @param returnAmount 退款金额
     */
    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    /**
     * 退货申请日期
     * @return RETURN_SUBMIT_DATE 退货申请日期
     */
    public Date getReturnSubmitDate() {
        return returnSubmitDate;
    }

    /**
     * 退货申请日期
     * @param returnSubmitDate 退货申请日期
     */
    public void setReturnSubmitDate(Date returnSubmitDate) {
        this.returnSubmitDate = returnSubmitDate;
    }

    /**
     * 退货处理时间
     * @return RETURN_HANDING_DATE 退货处理时间
     */
    public Date getReturnHandingDate() {
        return returnHandingDate;
    }

    /**
     * 退货处理时间
     * @param returnHandingDate 退货处理时间
     */
    public void setReturnHandingDate(Date returnHandingDate) {
        this.returnHandingDate = returnHandingDate;
    }

    /**
     * 已处理时间
     * @return RETURN_END_DATE 已处理时间
     */
    public Date getReturnEndDate() {
        return returnEndDate;
    }

    /**
     * 已处理时间
     * @param returnEndDate 已处理时间
     */
    public void setReturnEndDate(Date returnEndDate) {
        this.returnEndDate = returnEndDate;
    }

    /**
     * 退货理由
     * @return RETURN_REASON 退货理由
     */
    public String getReturnReason() {
        return returnReason;
    }

    /**
     * 退货理由
     * @param returnReason 退货理由
     */
    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason == null ? null : returnReason.trim();
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
        TShopOrderReturn other = (TShopOrderReturn) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReturnNo() == null ? other.getReturnNo() == null : this.getReturnNo().equals(other.getReturnNo()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getLogisticId() == null ? other.getLogisticId() == null : this.getLogisticId().equals(other.getLogisticId()))
            && (this.getReturnType() == null ? other.getReturnType() == null : this.getReturnType().equals(other.getReturnType()))
            && (this.getHandingWay() == null ? other.getHandingWay() == null : this.getHandingWay().equals(other.getHandingWay()))
            && (this.getReturnAmount() == null ? other.getReturnAmount() == null : this.getReturnAmount().equals(other.getReturnAmount()))
            && (this.getReturnSubmitDate() == null ? other.getReturnSubmitDate() == null : this.getReturnSubmitDate().equals(other.getReturnSubmitDate()))
            && (this.getReturnHandingDate() == null ? other.getReturnHandingDate() == null : this.getReturnHandingDate().equals(other.getReturnHandingDate()))
            && (this.getReturnEndDate() == null ? other.getReturnEndDate() == null : this.getReturnEndDate().equals(other.getReturnEndDate()))
            && (this.getReturnReason() == null ? other.getReturnReason() == null : this.getReturnReason().equals(other.getReturnReason()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getReturnNo() == null) ? 0 : getReturnNo().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getLogisticId() == null) ? 0 : getLogisticId().hashCode());
        result = prime * result + ((getReturnType() == null) ? 0 : getReturnType().hashCode());
        result = prime * result + ((getHandingWay() == null) ? 0 : getHandingWay().hashCode());
        result = prime * result + ((getReturnAmount() == null) ? 0 : getReturnAmount().hashCode());
        result = prime * result + ((getReturnSubmitDate() == null) ? 0 : getReturnSubmitDate().hashCode());
        result = prime * result + ((getReturnHandingDate() == null) ? 0 : getReturnHandingDate().hashCode());
        result = prime * result + ((getReturnEndDate() == null) ? 0 : getReturnEndDate().hashCode());
        result = prime * result + ((getReturnReason() == null) ? 0 : getReturnReason().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", returnNo=").append(returnNo);
        sb.append(", orderId=").append(orderId);
        sb.append(", logisticId=").append(logisticId);
        sb.append(", returnType=").append(returnType);
        sb.append(", handingWay=").append(handingWay);
        sb.append(", returnAmount=").append(returnAmount);
        sb.append(", returnSubmitDate=").append(returnSubmitDate);
        sb.append(", returnHandingDate=").append(returnHandingDate);
        sb.append(", returnEndDate=").append(returnEndDate);
        sb.append(", returnReason=").append(returnReason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}