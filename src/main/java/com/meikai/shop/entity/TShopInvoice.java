package com.meikai.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TShopInvoice implements Serializable {
    /**
     * 主键ID，发票
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 1：普通发票；2：增值发票。
     */
    private Integer isVat;

    /**
     * 发票抬头
     */
    private String invoiceTitle;

    /**
     * 发票内容
     */
    private String invoiceContent;

    /**
     * 发票金额
     */
    private BigDecimal invoiceAmount;

    /**
     * 发票税号
     */
    private String invoiceTaxNo;

    /**
     * 开票税金
     */
    private BigDecimal invoiceTax;

    /**
     * 公司名称[增值税]
     */
    private String vatCompanyName;

    /**
     * 公司地址[增值税]
     */
    private String vatCompanyAddress;

    /**
     * 联系电话[增值税]
     */
    private String vatTelephone;

    /**
     * 开户银行[增值税]
     */
    private String vatBankName;

    /**
     * 银行帐号[增值税]
     */
    private String vatBankAccount;

    /**
     * t_shop_invoice
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，发票
     * @return ID 主键ID，发票
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，发票
     * @param id 主键ID，发票
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 创建时间
     * @return CREATE_TIME 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return UPDATE_TIME 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 订单编号
     * @return ORDER_NO 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单编号
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 1：普通发票；2：增值发票。
     * @return IS_VAT 1：普通发票；2：增值发票。
     */
    public Integer getIsVat() {
        return isVat;
    }

    /**
     * 1：普通发票；2：增值发票。
     * @param isVat 1：普通发票；2：增值发票。
     */
    public void setIsVat(Integer isVat) {
        this.isVat = isVat;
    }

    /**
     * 发票抬头
     * @return INVOICE_TITLE 发票抬头
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * 发票抬头
     * @param invoiceTitle 发票抬头
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    /**
     * 发票内容
     * @return INVOICE_CONTENT 发票内容
     */
    public String getInvoiceContent() {
        return invoiceContent;
    }

    /**
     * 发票内容
     * @param invoiceContent 发票内容
     */
    public void setInvoiceContent(String invoiceContent) {
        this.invoiceContent = invoiceContent == null ? null : invoiceContent.trim();
    }

    /**
     * 发票金额
     * @return INVOICE_AMOUNT 发票金额
     */
    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    /**
     * 发票金额
     * @param invoiceAmount 发票金额
     */
    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    /**
     * 发票税号
     * @return INVOICE_TAX_NO 发票税号
     */
    public String getInvoiceTaxNo() {
        return invoiceTaxNo;
    }

    /**
     * 发票税号
     * @param invoiceTaxNo 发票税号
     */
    public void setInvoiceTaxNo(String invoiceTaxNo) {
        this.invoiceTaxNo = invoiceTaxNo == null ? null : invoiceTaxNo.trim();
    }

    /**
     * 开票税金
     * @return INVOICE_TAX 开票税金
     */
    public BigDecimal getInvoiceTax() {
        return invoiceTax;
    }

    /**
     * 开票税金
     * @param invoiceTax 开票税金
     */
    public void setInvoiceTax(BigDecimal invoiceTax) {
        this.invoiceTax = invoiceTax;
    }

    /**
     * 公司名称[增值税]
     * @return VAT_COMPANY_NAME 公司名称[增值税]
     */
    public String getVatCompanyName() {
        return vatCompanyName;
    }

    /**
     * 公司名称[增值税]
     * @param vatCompanyName 公司名称[增值税]
     */
    public void setVatCompanyName(String vatCompanyName) {
        this.vatCompanyName = vatCompanyName == null ? null : vatCompanyName.trim();
    }

    /**
     * 公司地址[增值税]
     * @return VAT_COMPANY_ADDRESS 公司地址[增值税]
     */
    public String getVatCompanyAddress() {
        return vatCompanyAddress;
    }

    /**
     * 公司地址[增值税]
     * @param vatCompanyAddress 公司地址[增值税]
     */
    public void setVatCompanyAddress(String vatCompanyAddress) {
        this.vatCompanyAddress = vatCompanyAddress == null ? null : vatCompanyAddress.trim();
    }

    /**
     * 联系电话[增值税]
     * @return VAT_TELEPHONE 联系电话[增值税]
     */
    public String getVatTelephone() {
        return vatTelephone;
    }

    /**
     * 联系电话[增值税]
     * @param vatTelephone 联系电话[增值税]
     */
    public void setVatTelephone(String vatTelephone) {
        this.vatTelephone = vatTelephone == null ? null : vatTelephone.trim();
    }

    /**
     * 开户银行[增值税]
     * @return VAT_BANK_NAME 开户银行[增值税]
     */
    public String getVatBankName() {
        return vatBankName;
    }

    /**
     * 开户银行[增值税]
     * @param vatBankName 开户银行[增值税]
     */
    public void setVatBankName(String vatBankName) {
        this.vatBankName = vatBankName == null ? null : vatBankName.trim();
    }

    /**
     * 银行帐号[增值税]
     * @return VAT_BANK_ACCOUNT 银行帐号[增值税]
     */
    public String getVatBankAccount() {
        return vatBankAccount;
    }

    /**
     * 银行帐号[增值税]
     * @param vatBankAccount 银行帐号[增值税]
     */
    public void setVatBankAccount(String vatBankAccount) {
        this.vatBankAccount = vatBankAccount == null ? null : vatBankAccount.trim();
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
        TShopInvoice other = (TShopInvoice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getIsVat() == null ? other.getIsVat() == null : this.getIsVat().equals(other.getIsVat()))
            && (this.getInvoiceTitle() == null ? other.getInvoiceTitle() == null : this.getInvoiceTitle().equals(other.getInvoiceTitle()))
            && (this.getInvoiceContent() == null ? other.getInvoiceContent() == null : this.getInvoiceContent().equals(other.getInvoiceContent()))
            && (this.getInvoiceAmount() == null ? other.getInvoiceAmount() == null : this.getInvoiceAmount().equals(other.getInvoiceAmount()))
            && (this.getInvoiceTaxNo() == null ? other.getInvoiceTaxNo() == null : this.getInvoiceTaxNo().equals(other.getInvoiceTaxNo()))
            && (this.getInvoiceTax() == null ? other.getInvoiceTax() == null : this.getInvoiceTax().equals(other.getInvoiceTax()))
            && (this.getVatCompanyName() == null ? other.getVatCompanyName() == null : this.getVatCompanyName().equals(other.getVatCompanyName()))
            && (this.getVatCompanyAddress() == null ? other.getVatCompanyAddress() == null : this.getVatCompanyAddress().equals(other.getVatCompanyAddress()))
            && (this.getVatTelephone() == null ? other.getVatTelephone() == null : this.getVatTelephone().equals(other.getVatTelephone()))
            && (this.getVatBankName() == null ? other.getVatBankName() == null : this.getVatBankName().equals(other.getVatBankName()))
            && (this.getVatBankAccount() == null ? other.getVatBankAccount() == null : this.getVatBankAccount().equals(other.getVatBankAccount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getIsVat() == null) ? 0 : getIsVat().hashCode());
        result = prime * result + ((getInvoiceTitle() == null) ? 0 : getInvoiceTitle().hashCode());
        result = prime * result + ((getInvoiceContent() == null) ? 0 : getInvoiceContent().hashCode());
        result = prime * result + ((getInvoiceAmount() == null) ? 0 : getInvoiceAmount().hashCode());
        result = prime * result + ((getInvoiceTaxNo() == null) ? 0 : getInvoiceTaxNo().hashCode());
        result = prime * result + ((getInvoiceTax() == null) ? 0 : getInvoiceTax().hashCode());
        result = prime * result + ((getVatCompanyName() == null) ? 0 : getVatCompanyName().hashCode());
        result = prime * result + ((getVatCompanyAddress() == null) ? 0 : getVatCompanyAddress().hashCode());
        result = prime * result + ((getVatTelephone() == null) ? 0 : getVatTelephone().hashCode());
        result = prime * result + ((getVatBankName() == null) ? 0 : getVatBankName().hashCode());
        result = prime * result + ((getVatBankAccount() == null) ? 0 : getVatBankAccount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", isVat=").append(isVat);
        sb.append(", invoiceTitle=").append(invoiceTitle);
        sb.append(", invoiceContent=").append(invoiceContent);
        sb.append(", invoiceAmount=").append(invoiceAmount);
        sb.append(", invoiceTaxNo=").append(invoiceTaxNo);
        sb.append(", invoiceTax=").append(invoiceTax);
        sb.append(", vatCompanyName=").append(vatCompanyName);
        sb.append(", vatCompanyAddress=").append(vatCompanyAddress);
        sb.append(", vatTelephone=").append(vatTelephone);
        sb.append(", vatBankName=").append(vatBankName);
        sb.append(", vatBankAccount=").append(vatBankAccount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}