package com.meikai.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TShopOrder implements Serializable {
    /**
     * 主键ID，订单表
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
     * 支付时间
     */
    private Date payTime;

    /**
     * 发货时间
     */
    private Date sendTime;

    /**
     * 结算时间
     */
    private Date settleTime;

    /**
     * 结算类型：1：线上支付；2:分期付款；3：货到付款。
     */
    private Integer settleType;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 订单备注
     */
    private String remark;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单状态：1：未付款,2：已付款:3：已发货:4：已签收:5：已评论，6：退货申请,7：退货中:8：已退货:9：取消交易。
     */
    private Integer orderStatu;

    /**
     * 单品种类统计
     */
    private Integer skuCount;

    /**
     * 运费
     */
    private BigDecimal logisticFee;

    /**
     * 商品总金额
     */
    private BigDecimal goodAmountTotal;

    /**
     * 订单实际总金额
     */
    private BigDecimal orderAmountTotal;

    /**
     * 有无发票，默认1：无发票，2：有发票
     */
    private Integer isInvoice;

    /**
     * 发票ID
     */
    private Long invoiceId;

    /**
     * 收货省份
     */
    private String shipProvince;

    /**
     * 收货城市
     */
    private String shipCity;

    /**
     * 收货县区
     */
    private String shipCounty;

    /**
     * 收货详细地址
     */
    private String shipAddress;

    /**
     * 物流号ID
     */
    private Long orderLogisticId;

    /**
     * 支付类型：1：微信支付；2：支付宝支付；3：网银支付；
     */
    private Integer payType;

    /**
     * 第三方支付流水号
     */
    private Long outTradeNo;
    
    private List<TShopOrderItem> orderItems;

    /**
     * t_shop_order
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，订单表
     * @return ID 主键ID，订单表
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，订单表
     * @param id 主键ID，订单表
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
     * 支付时间
     * @return PAY_TIME 支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 支付时间
     * @param payTime 支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 发货时间
     * @return SEND_TIME 发货时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 发货时间
     * @param sendTime 发货时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 结算时间
     * @return SETTLE_TIME 结算时间
     */
    public Date getSettleTime() {
        return settleTime;
    }

    /**
     * 结算时间
     * @param settleTime 结算时间
     */
    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    /**
     * 结算类型：1：线上支付；2:分期付款；3：货到付款。
     * @return SETTLE_TYPE 结算类型：1：线上支付；2:分期付款；3：货到付款。
     */
    public Integer getSettleType() {
        return settleType;
    }

    /**
     * 结算类型：1：线上支付；2:分期付款；3：货到付款。
     * @param settleType 结算类型：1：线上支付；2:分期付款；3：货到付款。
     */
    public void setSettleType(Integer settleType) {
        this.settleType = settleType;
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

    /**
     * 订单备注
     * @return REMARK 订单备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 订单备注
     * @param remark 订单备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 订单号
     * @return ORDER_NO 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单号
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 订单状态：1：未付款,2：已付款:3：已发货:4：已签收:5：已评论，6：退货申请,7：退货中:8：已退货:9：取消交易。
     * @return ORDER_STATU 订单状态：1：未付款,2：已付款:3：已发货:4：已签收:5：已评论，6：退货申请,7：退货中:8：已退货:9：取消交易。
     */
    public Integer getOrderStatu() {
        return orderStatu;
    }

    /**
     * 订单状态：1：未付款,2：已付款:3：已发货:4：已签收:5：已评论，6：退货申请,7：退货中:8：已退货:9：取消交易。
     * @param orderStatu 订单状态：1：未付款,2：已付款:3：已发货:4：已签收:5：已评论，6：退货申请,7：退货中:8：已退货:9：取消交易。
     */
    public void setOrderStatu(Integer orderStatu) {
        this.orderStatu = orderStatu;
    }

    /**
     * 单品种类统计
     * @return SKU_COUNT 单品种类统计
     */
    public Integer getSkuCount() {
        return skuCount;
    }

    /**
     * 单品种类统计
     * @param skuCount 单品种类统计
     */
    public void setSkuCount(Integer skuCount) {
        this.skuCount = skuCount;
    }

    /**
     * 运费
     * @return LOGISTIC_FEE 运费
     */
    public BigDecimal getLogisticFee() {
        return logisticFee;
    }

    /**
     * 运费
     * @param logisticFee 运费
     */
    public void setLogisticFee(BigDecimal logisticFee) {
        this.logisticFee = logisticFee;
    }

    /**
     * 商品总金额
     * @return GOOD_AMOUNT_TOTAL 商品总金额
     */
    public BigDecimal getGoodAmountTotal() {
        return goodAmountTotal;
    }

    /**
     * 商品总金额
     * @param goodAmountTotal 商品总金额
     */
    public void setGoodAmountTotal(BigDecimal goodAmountTotal) {
        this.goodAmountTotal = goodAmountTotal;
    }

    /**
     * 订单实际总金额
     * @return ORDER_AMOUNT_TOTAL 订单实际总金额
     */
    public BigDecimal getOrderAmountTotal() {
        return orderAmountTotal;
    }

    /**
     * 订单实际总金额
     * @param orderAmountTotal 订单实际总金额
     */
    public void setOrderAmountTotal(BigDecimal orderAmountTotal) {
        this.orderAmountTotal = orderAmountTotal;
    }

    /**
     * 有无发票，默认1：无发票，2：有发票
     * @return IS_INVOICE 有无发票，默认1：无发票，2：有发票
     */
    public Integer getIsInvoice() {
        return isInvoice;
    }

    /**
     * 有无发票，默认1：无发票，2：有发票
     * @param isInvoice 有无发票，默认1：无发票，2：有发票
     */
    public void setIsInvoice(Integer isInvoice) {
        this.isInvoice = isInvoice;
    }

    /**
     * 发票ID
     * @return INVOICE_ID 发票ID
     */
    public Long getInvoiceId() {
        return invoiceId;
    }

    /**
     * 发票ID
     * @param invoiceId 发票ID
     */
    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * 收货省份
     * @return SHIP_PROVINCE 收货省份
     */
    public String getShipProvince() {
        return shipProvince;
    }

    /**
     * 收货省份
     * @param shipProvince 收货省份
     */
    public void setShipProvince(String shipProvince) {
        this.shipProvince = shipProvince == null ? null : shipProvince.trim();
    }

    /**
     * 收货城市
     * @return SHIP_CITY 收货城市
     */
    public String getShipCity() {
        return shipCity;
    }

    /**
     * 收货城市
     * @param shipCity 收货城市
     */
    public void setShipCity(String shipCity) {
        this.shipCity = shipCity == null ? null : shipCity.trim();
    }

    /**
     * 收货县区
     * @return SHIP_COUNTY 收货县区
     */
    public String getShipCounty() {
        return shipCounty;
    }

    /**
     * 收货县区
     * @param shipCounty 收货县区
     */
    public void setShipCounty(String shipCounty) {
        this.shipCounty = shipCounty == null ? null : shipCounty.trim();
    }

    /**
     * 收货详细地址
     * @return SHIP_ADDRESS 收货详细地址
     */
    public String getShipAddress() {
        return shipAddress;
    }

    /**
     * 收货详细地址
     * @param shipAddress 收货详细地址
     */
    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress == null ? null : shipAddress.trim();
    }

    /**
     * 物流号ID
     * @return ORDER_LOGISTIC_ID 物流号ID
     */
    public Long getOrderLogisticId() {
        return orderLogisticId;
    }

    /**
     * 物流号ID
     * @param orderLogisticId 物流号ID
     */
    public void setOrderLogisticId(Long orderLogisticId) {
        this.orderLogisticId = orderLogisticId;
    }

    /**
     * 支付类型：1：微信支付；2：支付宝支付；3：网银支付；
     * @return PAY_TYPE 支付类型：1：微信支付；2：支付宝支付；3：网银支付；
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 支付类型：1：微信支付；2：支付宝支付；3：网银支付；
     * @param payType 支付类型：1：微信支付；2：支付宝支付；3：网银支付；
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 第三方支付流水号
     * @return OUT_TRADE_NO 第三方支付流水号
     */
    public Long getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * 第三方支付流水号
     * @param outTradeNo 第三方支付流水号
     */
    public void setOutTradeNo(Long outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
    
    
    /**
     * 获得品项集合
     * @return
     */
    public List<TShopOrderItem> getOrderItems() {
		return orderItems;
	}
    /**
     * 设置品项集合
     * @param orderItems
     */
	public void setOrderItems(List<TShopOrderItem> orderItems) {
		this.orderItems = orderItems;
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
        TShopOrder other = (TShopOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getSendTime() == null ? other.getSendTime() == null : this.getSendTime().equals(other.getSendTime()))
            && (this.getSettleTime() == null ? other.getSettleTime() == null : this.getSettleTime().equals(other.getSettleTime()))
            && (this.getSettleType() == null ? other.getSettleType() == null : this.getSettleType().equals(other.getSettleType()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getOrderStatu() == null ? other.getOrderStatu() == null : this.getOrderStatu().equals(other.getOrderStatu()))
            && (this.getSkuCount() == null ? other.getSkuCount() == null : this.getSkuCount().equals(other.getSkuCount()))
            && (this.getLogisticFee() == null ? other.getLogisticFee() == null : this.getLogisticFee().equals(other.getLogisticFee()))
            && (this.getGoodAmountTotal() == null ? other.getGoodAmountTotal() == null : this.getGoodAmountTotal().equals(other.getGoodAmountTotal()))
            && (this.getOrderAmountTotal() == null ? other.getOrderAmountTotal() == null : this.getOrderAmountTotal().equals(other.getOrderAmountTotal()))
            && (this.getIsInvoice() == null ? other.getIsInvoice() == null : this.getIsInvoice().equals(other.getIsInvoice()))
            && (this.getInvoiceId() == null ? other.getInvoiceId() == null : this.getInvoiceId().equals(other.getInvoiceId()))
            && (this.getShipProvince() == null ? other.getShipProvince() == null : this.getShipProvince().equals(other.getShipProvince()))
            && (this.getShipCity() == null ? other.getShipCity() == null : this.getShipCity().equals(other.getShipCity()))
            && (this.getShipCounty() == null ? other.getShipCounty() == null : this.getShipCounty().equals(other.getShipCounty()))
            && (this.getShipAddress() == null ? other.getShipAddress() == null : this.getShipAddress().equals(other.getShipAddress()))
            && (this.getOrderLogisticId() == null ? other.getOrderLogisticId() == null : this.getOrderLogisticId().equals(other.getOrderLogisticId()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getSendTime() == null) ? 0 : getSendTime().hashCode());
        result = prime * result + ((getSettleTime() == null) ? 0 : getSettleTime().hashCode());
        result = prime * result + ((getSettleType() == null) ? 0 : getSettleType().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getOrderStatu() == null) ? 0 : getOrderStatu().hashCode());
        result = prime * result + ((getSkuCount() == null) ? 0 : getSkuCount().hashCode());
        result = prime * result + ((getLogisticFee() == null) ? 0 : getLogisticFee().hashCode());
        result = prime * result + ((getGoodAmountTotal() == null) ? 0 : getGoodAmountTotal().hashCode());
        result = prime * result + ((getOrderAmountTotal() == null) ? 0 : getOrderAmountTotal().hashCode());
        result = prime * result + ((getIsInvoice() == null) ? 0 : getIsInvoice().hashCode());
        result = prime * result + ((getInvoiceId() == null) ? 0 : getInvoiceId().hashCode());
        result = prime * result + ((getShipProvince() == null) ? 0 : getShipProvince().hashCode());
        result = prime * result + ((getShipCity() == null) ? 0 : getShipCity().hashCode());
        result = prime * result + ((getShipCounty() == null) ? 0 : getShipCounty().hashCode());
        result = prime * result + ((getShipAddress() == null) ? 0 : getShipAddress().hashCode());
        result = prime * result + ((getOrderLogisticId() == null) ? 0 : getOrderLogisticId().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
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
        sb.append(", payTime=").append(payTime);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", settleTime=").append(settleTime);
        sb.append(", settleType=").append(settleType);
        sb.append(", memberId=").append(memberId);
        sb.append(", remark=").append(remark);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", orderStatu=").append(orderStatu);
        sb.append(", skuCount=").append(skuCount);
        sb.append(", logisticFee=").append(logisticFee);
        sb.append(", goodAmountTotal=").append(goodAmountTotal);
        sb.append(", orderAmountTotal=").append(orderAmountTotal);
        sb.append(", isInvoice=").append(isInvoice);
        sb.append(", invoiceId=").append(invoiceId);
        sb.append(", shipProvince=").append(shipProvince);
        sb.append(", shipCity=").append(shipCity);
        sb.append(", shipCounty=").append(shipCounty);
        sb.append(", shipAddress=").append(shipAddress);
        sb.append(", orderLogisticId=").append(orderLogisticId);
        sb.append(", payType=").append(payType);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}