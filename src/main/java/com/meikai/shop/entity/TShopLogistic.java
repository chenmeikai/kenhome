package com.meikai.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TShopLogistic implements Serializable {
    /**
     * 主键ID，物流
     */
    private Long id;

    /**
     * 发货时间
     */
    private Date createDate;

    /**
     * 物流更新时间
     */
    private Date updateDate;

    /**
     * 结算时间
     */
    private Date settleDate;

    /**
     * 更新者
     */
    private String updater;

    /**
     * 物流号
     */
    private String expressNo;

    /**
     * 物流公司
     */
    private String logisticCompany;

    /**
     * 物流费用，收取收货人的运费
     */
    private BigDecimal logisticFee;

    /**
     * 实际物流费，给物流公司的运费
     */
    private BigDecimal deliveryAmount;

    /**
     * 物流类型
     */
    private Integer logisticType;

    /**
     * 物流状态：1.快件揽收，2.揽件扫描，3.快件分拨，4.装车扫描，5.快件扫描，6.快件分拨，7.安排投递，8.正在投递，9.快件签收
     */
    private Integer logisticStatu;

    /**
     * 结算状态：1.未结算；2.部分结算；3.已结算。
     */
    private Integer settlementStatu;

    /**
     * 快递公司代收货款费率，如货值的2%-5%，一般月结
     */
    private Double agencyFeeRate;

    /**
     * 最后物流信息
     */
    private String logisticLastMemo;

    /**
     * 全部物流信息
     */
    private String logisticAllMemo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 收货人姓名
     */
    private String consigneeName;

    /**
     * 收货人电话
     */
    private String consigneeTelphone;

    /**
     * 收货省份
     */
    private String consigneeProvince;

    /**
     * 收货城市
     */
    private String consigneeCity;

    /**
     * 收货县区
     */
    private String consigneeCounty;

    /**
     * 收货详细地址
     */
    private String consigneeAdress;

    /**
     * 收货详细邮政编码
     */
    private String consigneeZip;

    /**
     * 支付给物流公司方法
     */
    private Integer payLogisticMethod;

    /**
     * 支付给物流公司单号
     */
    private String payLogisticNo;

    /**
     * 对账状态：1.未对账；2.已对账。
     */
    private Integer reconciliationStatu;

    /**
     * 对账时间
     */
    private Date reconciliationDate;

    /**
     * t_shop_logistic
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，物流
     * @return ID 主键ID，物流
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，物流
     * @param id 主键ID，物流
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 发货时间
     * @return CREATE_DATE 发货时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 发货时间
     * @param createDate 发货时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 物流更新时间
     * @return UPDATE_DATE 物流更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 物流更新时间
     * @param updateDate 物流更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 结算时间
     * @return SETTLE_DATE 结算时间
     */
    public Date getSettleDate() {
        return settleDate;
    }

    /**
     * 结算时间
     * @param settleDate 结算时间
     */
    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    /**
     * 更新者
     * @return UPDATER 更新者
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * 更新者
     * @param updater 更新者
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * 物流号
     * @return EXPRESS_NO 物流号
     */
    public String getExpressNo() {
        return expressNo;
    }

    /**
     * 物流号
     * @param expressNo 物流号
     */
    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo == null ? null : expressNo.trim();
    }

    /**
     * 物流公司
     * @return LOGISTIC_COMPANY 物流公司
     */
    public String getLogisticCompany() {
        return logisticCompany;
    }

    /**
     * 物流公司
     * @param logisticCompany 物流公司
     */
    public void setLogisticCompany(String logisticCompany) {
        this.logisticCompany = logisticCompany == null ? null : logisticCompany.trim();
    }

    /**
     * 物流费用，收取收货人的运费
     * @return LOGISTIC_FEE 物流费用，收取收货人的运费
     */
    public BigDecimal getLogisticFee() {
        return logisticFee;
    }

    /**
     * 物流费用，收取收货人的运费
     * @param logisticFee 物流费用，收取收货人的运费
     */
    public void setLogisticFee(BigDecimal logisticFee) {
        this.logisticFee = logisticFee;
    }

    /**
     * 实际物流费，给物流公司的运费
     * @return DELIVERY_AMOUNT 实际物流费，给物流公司的运费
     */
    public BigDecimal getDeliveryAmount() {
        return deliveryAmount;
    }

    /**
     * 实际物流费，给物流公司的运费
     * @param deliveryAmount 实际物流费，给物流公司的运费
     */
    public void setDeliveryAmount(BigDecimal deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    /**
     * 物流类型
     * @return LOGISTIC_TYPE 物流类型
     */
    public Integer getLogisticType() {
        return logisticType;
    }

    /**
     * 物流类型
     * @param logisticType 物流类型
     */
    public void setLogisticType(Integer logisticType) {
        this.logisticType = logisticType;
    }

    /**
     * 物流状态：1.快件揽收，2.揽件扫描，3.快件分拨，4.装车扫描，5.快件扫描，6.快件分拨，7.安排投递，8.正在投递，9.快件签收
     * @return LOGISTIC_STATU 物流状态：1.快件揽收，2.揽件扫描，3.快件分拨，4.装车扫描，5.快件扫描，6.快件分拨，7.安排投递，8.正在投递，9.快件签收
     */
    public Integer getLogisticStatu() {
        return logisticStatu;
    }

    /**
     * 物流状态：1.快件揽收，2.揽件扫描，3.快件分拨，4.装车扫描，5.快件扫描，6.快件分拨，7.安排投递，8.正在投递，9.快件签收
     * @param logisticStatu 物流状态：1.快件揽收，2.揽件扫描，3.快件分拨，4.装车扫描，5.快件扫描，6.快件分拨，7.安排投递，8.正在投递，9.快件签收
     */
    public void setLogisticStatu(Integer logisticStatu) {
        this.logisticStatu = logisticStatu;
    }

    /**
     * 结算状态：1.未结算；2.部分结算；3.已结算。
     * @return SETTLEMENT_STATU 结算状态：1.未结算；2.部分结算；3.已结算。
     */
    public Integer getSettlementStatu() {
        return settlementStatu;
    }

    /**
     * 结算状态：1.未结算；2.部分结算；3.已结算。
     * @param settlementStatu 结算状态：1.未结算；2.部分结算；3.已结算。
     */
    public void setSettlementStatu(Integer settlementStatu) {
        this.settlementStatu = settlementStatu;
    }

    /**
     * 快递公司代收货款费率，如货值的2%-5%，一般月结
     * @return AGENCY_FEE_RATE 快递公司代收货款费率，如货值的2%-5%，一般月结
     */
    public Double getAgencyFeeRate() {
        return agencyFeeRate;
    }

    /**
     * 快递公司代收货款费率，如货值的2%-5%，一般月结
     * @param agencyFeeRate 快递公司代收货款费率，如货值的2%-5%，一般月结
     */
    public void setAgencyFeeRate(Double agencyFeeRate) {
        this.agencyFeeRate = agencyFeeRate;
    }

    /**
     * 最后物流信息
     * @return LOGISTIC_LAST_MEMO 最后物流信息
     */
    public String getLogisticLastMemo() {
        return logisticLastMemo;
    }

    /**
     * 最后物流信息
     * @param logisticLastMemo 最后物流信息
     */
    public void setLogisticLastMemo(String logisticLastMemo) {
        this.logisticLastMemo = logisticLastMemo == null ? null : logisticLastMemo.trim();
    }

    /**
     * 全部物流信息
     * @return LOGISTIC_ALL_MEMO 全部物流信息
     */
    public String getLogisticAllMemo() {
        return logisticAllMemo;
    }

    /**
     * 全部物流信息
     * @param logisticAllMemo 全部物流信息
     */
    public void setLogisticAllMemo(String logisticAllMemo) {
        this.logisticAllMemo = logisticAllMemo == null ? null : logisticAllMemo.trim();
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
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 收货人姓名
     * @return CONSIGNEE_NAME 收货人姓名
     */
    public String getConsigneeName() {
        return consigneeName;
    }

    /**
     * 收货人姓名
     * @param consigneeName 收货人姓名
     */
    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName == null ? null : consigneeName.trim();
    }

    /**
     * 收货人电话
     * @return CONSIGNEE_TELPHONE 收货人电话
     */
    public String getConsigneeTelphone() {
        return consigneeTelphone;
    }

    /**
     * 收货人电话
     * @param consigneeTelphone 收货人电话
     */
    public void setConsigneeTelphone(String consigneeTelphone) {
        this.consigneeTelphone = consigneeTelphone == null ? null : consigneeTelphone.trim();
    }

    /**
     * 收货省份
     * @return CONSIGNEE_PROVINCE 收货省份
     */
    public String getConsigneeProvince() {
        return consigneeProvince;
    }

    /**
     * 收货省份
     * @param consigneeProvince 收货省份
     */
    public void setConsigneeProvince(String consigneeProvince) {
        this.consigneeProvince = consigneeProvince == null ? null : consigneeProvince.trim();
    }

    /**
     * 收货城市
     * @return CONSIGNEE_CITY 收货城市
     */
    public String getConsigneeCity() {
        return consigneeCity;
    }

    /**
     * 收货城市
     * @param consigneeCity 收货城市
     */
    public void setConsigneeCity(String consigneeCity) {
        this.consigneeCity = consigneeCity == null ? null : consigneeCity.trim();
    }

    /**
     * 收货县区
     * @return CONSIGNEE_COUNTY 收货县区
     */
    public String getConsigneeCounty() {
        return consigneeCounty;
    }

    /**
     * 收货县区
     * @param consigneeCounty 收货县区
     */
    public void setConsigneeCounty(String consigneeCounty) {
        this.consigneeCounty = consigneeCounty == null ? null : consigneeCounty.trim();
    }

    /**
     * 收货详细地址
     * @return CONSIGNEE_ADRESS 收货详细地址
     */
    public String getConsigneeAdress() {
        return consigneeAdress;
    }

    /**
     * 收货详细地址
     * @param consigneeAdress 收货详细地址
     */
    public void setConsigneeAdress(String consigneeAdress) {
        this.consigneeAdress = consigneeAdress == null ? null : consigneeAdress.trim();
    }

    /**
     * 收货详细邮政编码
     * @return CONSIGNEE_ZIP 收货详细邮政编码
     */
    public String getConsigneeZip() {
        return consigneeZip;
    }

    /**
     * 收货详细邮政编码
     * @param consigneeZip 收货详细邮政编码
     */
    public void setConsigneeZip(String consigneeZip) {
        this.consigneeZip = consigneeZip == null ? null : consigneeZip.trim();
    }

    /**
     * 支付给物流公司方法
     * @return PAY_LOGISTIC_method 支付给物流公司方法
     */
    public Integer getPayLogisticMethod() {
        return payLogisticMethod;
    }

    /**
     * 支付给物流公司方法
     * @param payLogisticMethod 支付给物流公司方法
     */
    public void setPayLogisticMethod(Integer payLogisticMethod) {
        this.payLogisticMethod = payLogisticMethod;
    }

    /**
     * 支付给物流公司单号
     * @return PAY_LOGISTIC_NO 支付给物流公司单号
     */
    public String getPayLogisticNo() {
        return payLogisticNo;
    }

    /**
     * 支付给物流公司单号
     * @param payLogisticNo 支付给物流公司单号
     */
    public void setPayLogisticNo(String payLogisticNo) {
        this.payLogisticNo = payLogisticNo == null ? null : payLogisticNo.trim();
    }

    /**
     * 对账状态：1.未对账；2.已对账。
     * @return reconciliation_statu 对账状态：1.未对账；2.已对账。
     */
    public Integer getReconciliationStatu() {
        return reconciliationStatu;
    }

    /**
     * 对账状态：1.未对账；2.已对账。
     * @param reconciliationStatu 对账状态：1.未对账；2.已对账。
     */
    public void setReconciliationStatu(Integer reconciliationStatu) {
        this.reconciliationStatu = reconciliationStatu;
    }

    /**
     * 对账时间
     * @return reconciliation_date 对账时间
     */
    public Date getReconciliationDate() {
        return reconciliationDate;
    }

    /**
     * 对账时间
     * @param reconciliationDate 对账时间
     */
    public void setReconciliationDate(Date reconciliationDate) {
        this.reconciliationDate = reconciliationDate;
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
        TShopLogistic other = (TShopLogistic) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getSettleDate() == null ? other.getSettleDate() == null : this.getSettleDate().equals(other.getSettleDate()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getExpressNo() == null ? other.getExpressNo() == null : this.getExpressNo().equals(other.getExpressNo()))
            && (this.getLogisticCompany() == null ? other.getLogisticCompany() == null : this.getLogisticCompany().equals(other.getLogisticCompany()))
            && (this.getLogisticFee() == null ? other.getLogisticFee() == null : this.getLogisticFee().equals(other.getLogisticFee()))
            && (this.getDeliveryAmount() == null ? other.getDeliveryAmount() == null : this.getDeliveryAmount().equals(other.getDeliveryAmount()))
            && (this.getLogisticType() == null ? other.getLogisticType() == null : this.getLogisticType().equals(other.getLogisticType()))
            && (this.getLogisticStatu() == null ? other.getLogisticStatu() == null : this.getLogisticStatu().equals(other.getLogisticStatu()))
            && (this.getSettlementStatu() == null ? other.getSettlementStatu() == null : this.getSettlementStatu().equals(other.getSettlementStatu()))
            && (this.getAgencyFeeRate() == null ? other.getAgencyFeeRate() == null : this.getAgencyFeeRate().equals(other.getAgencyFeeRate()))
            && (this.getLogisticLastMemo() == null ? other.getLogisticLastMemo() == null : this.getLogisticLastMemo().equals(other.getLogisticLastMemo()))
            && (this.getLogisticAllMemo() == null ? other.getLogisticAllMemo() == null : this.getLogisticAllMemo().equals(other.getLogisticAllMemo()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getConsigneeName() == null ? other.getConsigneeName() == null : this.getConsigneeName().equals(other.getConsigneeName()))
            && (this.getConsigneeTelphone() == null ? other.getConsigneeTelphone() == null : this.getConsigneeTelphone().equals(other.getConsigneeTelphone()))
            && (this.getConsigneeProvince() == null ? other.getConsigneeProvince() == null : this.getConsigneeProvince().equals(other.getConsigneeProvince()))
            && (this.getConsigneeCity() == null ? other.getConsigneeCity() == null : this.getConsigneeCity().equals(other.getConsigneeCity()))
            && (this.getConsigneeCounty() == null ? other.getConsigneeCounty() == null : this.getConsigneeCounty().equals(other.getConsigneeCounty()))
            && (this.getConsigneeAdress() == null ? other.getConsigneeAdress() == null : this.getConsigneeAdress().equals(other.getConsigneeAdress()))
            && (this.getConsigneeZip() == null ? other.getConsigneeZip() == null : this.getConsigneeZip().equals(other.getConsigneeZip()))
            && (this.getPayLogisticMethod() == null ? other.getPayLogisticMethod() == null : this.getPayLogisticMethod().equals(other.getPayLogisticMethod()))
            && (this.getPayLogisticNo() == null ? other.getPayLogisticNo() == null : this.getPayLogisticNo().equals(other.getPayLogisticNo()))
            && (this.getReconciliationStatu() == null ? other.getReconciliationStatu() == null : this.getReconciliationStatu().equals(other.getReconciliationStatu()))
            && (this.getReconciliationDate() == null ? other.getReconciliationDate() == null : this.getReconciliationDate().equals(other.getReconciliationDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getSettleDate() == null) ? 0 : getSettleDate().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getExpressNo() == null) ? 0 : getExpressNo().hashCode());
        result = prime * result + ((getLogisticCompany() == null) ? 0 : getLogisticCompany().hashCode());
        result = prime * result + ((getLogisticFee() == null) ? 0 : getLogisticFee().hashCode());
        result = prime * result + ((getDeliveryAmount() == null) ? 0 : getDeliveryAmount().hashCode());
        result = prime * result + ((getLogisticType() == null) ? 0 : getLogisticType().hashCode());
        result = prime * result + ((getLogisticStatu() == null) ? 0 : getLogisticStatu().hashCode());
        result = prime * result + ((getSettlementStatu() == null) ? 0 : getSettlementStatu().hashCode());
        result = prime * result + ((getAgencyFeeRate() == null) ? 0 : getAgencyFeeRate().hashCode());
        result = prime * result + ((getLogisticLastMemo() == null) ? 0 : getLogisticLastMemo().hashCode());
        result = prime * result + ((getLogisticAllMemo() == null) ? 0 : getLogisticAllMemo().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getConsigneeName() == null) ? 0 : getConsigneeName().hashCode());
        result = prime * result + ((getConsigneeTelphone() == null) ? 0 : getConsigneeTelphone().hashCode());
        result = prime * result + ((getConsigneeProvince() == null) ? 0 : getConsigneeProvince().hashCode());
        result = prime * result + ((getConsigneeCity() == null) ? 0 : getConsigneeCity().hashCode());
        result = prime * result + ((getConsigneeCounty() == null) ? 0 : getConsigneeCounty().hashCode());
        result = prime * result + ((getConsigneeAdress() == null) ? 0 : getConsigneeAdress().hashCode());
        result = prime * result + ((getConsigneeZip() == null) ? 0 : getConsigneeZip().hashCode());
        result = prime * result + ((getPayLogisticMethod() == null) ? 0 : getPayLogisticMethod().hashCode());
        result = prime * result + ((getPayLogisticNo() == null) ? 0 : getPayLogisticNo().hashCode());
        result = prime * result + ((getReconciliationStatu() == null) ? 0 : getReconciliationStatu().hashCode());
        result = prime * result + ((getReconciliationDate() == null) ? 0 : getReconciliationDate().hashCode());
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
        sb.append(", settleDate=").append(settleDate);
        sb.append(", updater=").append(updater);
        sb.append(", expressNo=").append(expressNo);
        sb.append(", logisticCompany=").append(logisticCompany);
        sb.append(", logisticFee=").append(logisticFee);
        sb.append(", deliveryAmount=").append(deliveryAmount);
        sb.append(", logisticType=").append(logisticType);
        sb.append(", logisticStatu=").append(logisticStatu);
        sb.append(", settlementStatu=").append(settlementStatu);
        sb.append(", agencyFeeRate=").append(agencyFeeRate);
        sb.append(", logisticLastMemo=").append(logisticLastMemo);
        sb.append(", logisticAllMemo=").append(logisticAllMemo);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", consigneeName=").append(consigneeName);
        sb.append(", consigneeTelphone=").append(consigneeTelphone);
        sb.append(", consigneeProvince=").append(consigneeProvince);
        sb.append(", consigneeCity=").append(consigneeCity);
        sb.append(", consigneeCounty=").append(consigneeCounty);
        sb.append(", consigneeAdress=").append(consigneeAdress);
        sb.append(", consigneeZip=").append(consigneeZip);
        sb.append(", payLogisticMethod=").append(payLogisticMethod);
        sb.append(", payLogisticNo=").append(payLogisticNo);
        sb.append(", reconciliationStatu=").append(reconciliationStatu);
        sb.append(", reconciliationDate=").append(reconciliationDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}