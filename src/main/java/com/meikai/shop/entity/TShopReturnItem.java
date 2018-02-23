package com.meikai.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TShopReturnItem implements Serializable {
    /**
     * 主键ID，退货单品
     */
    private Long id;

    /**
     * 退货申请ID
     */
    private Long orderReturnId;

    /**
     * 退货单品ID
     */
    private Long skuId;

    /**
     * 退货单品数量
     */
    private Integer skuNum;

    /**
     * 退货金额
     */
    private BigDecimal returnAmount;

    /**
     * t_shop_return_item
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，退货单品
     * @return ID 主键ID，退货单品
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，退货单品
     * @param id 主键ID，退货单品
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 退货申请ID
     * @return ORDER_RETURN_ID 退货申请ID
     */
    public Long getOrderReturnId() {
        return orderReturnId;
    }

    /**
     * 退货申请ID
     * @param orderReturnId 退货申请ID
     */
    public void setOrderReturnId(Long orderReturnId) {
        this.orderReturnId = orderReturnId;
    }

    /**
     * 退货单品ID
     * @return SKU_ID 退货单品ID
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * 退货单品ID
     * @param skuId 退货单品ID
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * 退货单品数量
     * @return SKU_NUM 退货单品数量
     */
    public Integer getSkuNum() {
        return skuNum;
    }

    /**
     * 退货单品数量
     * @param skuNum 退货单品数量
     */
    public void setSkuNum(Integer skuNum) {
        this.skuNum = skuNum;
    }

    /**
     * 退货金额
     * @return RETURN_AMOUNT 退货金额
     */
    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    /**
     * 退货金额
     * @param returnAmount 退货金额
     */
    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
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
        TShopReturnItem other = (TShopReturnItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderReturnId() == null ? other.getOrderReturnId() == null : this.getOrderReturnId().equals(other.getOrderReturnId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getSkuNum() == null ? other.getSkuNum() == null : this.getSkuNum().equals(other.getSkuNum()))
            && (this.getReturnAmount() == null ? other.getReturnAmount() == null : this.getReturnAmount().equals(other.getReturnAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderReturnId() == null) ? 0 : getOrderReturnId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
        result = prime * result + ((getSkuNum() == null) ? 0 : getSkuNum().hashCode());
        result = prime * result + ((getReturnAmount() == null) ? 0 : getReturnAmount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderReturnId=").append(orderReturnId);
        sb.append(", skuId=").append(skuId);
        sb.append(", skuNum=").append(skuNum);
        sb.append(", returnAmount=").append(returnAmount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}