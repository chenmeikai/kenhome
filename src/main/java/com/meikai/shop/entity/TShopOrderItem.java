package com.meikai.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TShopOrderItem implements Serializable {
    /**
     * 主键ID，订单单品详情
     */
    private Long id;

    /**
     * 项目编号
     */
    private String itemNo;
    
    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderNo;
    
    private Long skuId;

    /**
     * 单品编号,单品可能删除,所以这里要记录，不能直接读商品表
     */
    private String skuNo;

    /**
     * 单品名
     */
    private String skuName;
    
    /**
     * 单品图片
     */
    private String skuPicture;

    /**
     * 单品原价
     */
    private BigDecimal skuOriginalPrice;

    /**
     * 单品促销价
     */
    private BigDecimal skuSalePrice;

    /**
     * 单品所属分类，json格式，记录所有分类
     */
    private String skuType;

    /**
     * 单品条形码
     */
    private String skuMarque;

    /**
     * 单品属性，记录所有属性，如颜色，款式等
     */
    private String skuAttribute;

    /**
     * 单品规格，记录所有
     */
    private String skuSpec;

    /**
     * 折率
     */
    private Double discountRate;

    /**
     * 折扣金额
     */
    private BigDecimal discountAmount;

    /**
     * 单品数量
     */
    private Integer skuNum;

    /**
     * 小计金额
     */
    private BigDecimal subtotalFee;

    /**
     * 是否无效，默认1：无效；2：有效。
     */
    private Integer isProductExists;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 是否已评，默认1：否；2：已评；3：不可评。
     */
    private Integer isReview;

    /**
     * 是否已追评，默认1：否；2：已追评；3：不可追评。
     */
    private Integer isLastReview;

    /**
     * 可评论时间，过期不可评价
     */
    private Date reviewLiveTime;

    /**
     * t_shop_order_item
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，订单单品详情
     * @return ID 主键ID，订单单品详情
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，订单单品详情
     * @param id 主键ID，订单单品详情
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 项目编号
     * @return item_no 项目编号
     */
    public String getItemNo() {
        return itemNo;
    }

    /**
     * 项目编号
     * @param itemNo 项目编号
     */
    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }
    
    
    /**
     * 订单ID
     * @return
     */
    public Long getOrderId() {
		return orderId;
	}
    /**
     * 订单ID
     * @return
     */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
        this.orderNo = orderNo;
    }
    
    
    /**
     * 获得商品ID
     * @return
     */
    public Long getSkuId() {
		return skuId;
	}
    /**
     * 设置商品ID
     * @param skuId
     */
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	/**
     * 单品编号,单品可能删除,所以这里要记录，不能直接读商品表
     * @return SKU_NO 单品编号,单品可能删除,所以这里要记录，不能直接读商品表
     */
    public String getSkuNo() {
        return skuNo;
    }

    /**
     * 单品编号,单品可能删除,所以这里要记录，不能直接读商品表
     * @param skuNo 单品编号,单品可能删除,所以这里要记录，不能直接读商品表
     */
    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    /**
     * 单品名
     * @return SKU_NAME 单品名
     */
    public String getSkuName() {
        return skuName;
    }

    /**
     * 单品名
     * @param skuName 单品名
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }
    
    
    /**
     * 获得单品图片
     * @return
     */
    public String getSkuPicture() {
		return skuPicture;
	}
    /**
     * 设置单品图片
     * @param skuPicture
     */
	public void setSkuPicture(String skuPicture) {
		this.skuPicture = skuPicture;
	}

	/**
     * 单品原价
     * @return SKU_ORIGINAL_PRICE 单品原价
     */
    public BigDecimal getSkuOriginalPrice() {
        return skuOriginalPrice;
    }

    /**
     * 单品原价
     * @param skuOriginalPrice 单品原价
     */
    public void setSkuOriginalPrice(BigDecimal skuOriginalPrice) {
        this.skuOriginalPrice = skuOriginalPrice;
    }

    /**
     * 单品促销价
     * @return SKU_SALE_PRICE 单品促销价
     */
    public BigDecimal getSkuSalePrice() {
        return skuSalePrice;
    }

    /**
     * 单品促销价
     * @param skuSalePrice 单品促销价
     */
    public void setSkuSalePrice(BigDecimal skuSalePrice) {
        this.skuSalePrice = skuSalePrice;
    }

    /**
     * 单品所属分类，json格式，记录所有分类
     * @return SKU_TYPE 单品所属分类，json格式，记录所有分类
     */
    public String getSkuType() {
        return skuType;
    }

    /**
     * 单品所属分类，json格式，记录所有分类
     * @param skuType 单品所属分类，json格式，记录所有分类
     */
    public void setSkuType(String skuType) {
        this.skuType = skuType == null ? null : skuType.trim();
    }

    /**
     * 单品条形码
     * @return SKU_MARQUE 单品条形码
     */
    public String getSkuMarque() {
        return skuMarque;
    }

    /**
     * 单品条形码
     * @param skuMarque 单品条形码
     */
    public void setSkuMarque(String skuMarque) {
        this.skuMarque = skuMarque == null ? null : skuMarque.trim();
    }

    /**
     * 单品属性，记录所有属性，如颜色，款式等
     * @return SKU_ATTRIBUTE 单品属性，记录所有属性，如颜色，款式等
     */
    public String getSkuAttribute() {
        return skuAttribute;
    }

    /**
     * 单品属性，记录所有属性，如颜色，款式等
     * @param skuAttribute 单品属性，记录所有属性，如颜色，款式等
     */
    public void setSkuAttribute(String skuAttribute) {
        this.skuAttribute = skuAttribute == null ? null : skuAttribute.trim();
    }

    /**
     * 单品规格，记录所有
     * @return SKU_SPEC 单品规格，记录所有
     */
    public String getSkuSpec() {
        return skuSpec;
    }

    /**
     * 单品规格，记录所有
     * @param skuSpec 单品规格，记录所有
     */
    public void setSkuSpec(String skuSpec) {
        this.skuSpec = skuSpec == null ? null : skuSpec.trim();
    }

    /**
     * 折率
     * @return DISCOUNT_RATE 折率
     */
    public Double getDiscountRate() {
        return discountRate;
    }

    /**
     * 折率
     * @param discountRate 折率
     */
    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * 折扣金额
     * @return discount_amount 折扣金额
     */
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    /**
     * 折扣金额
     * @param discountAmount 折扣金额
     */
    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * 单品数量
     * @return SKU_num 单品数量
     */
    public Integer getSkuNum() {
        return skuNum;
    }

    /**
     * 单品数量
     * @param skuNum 单品数量
     */
    public void setSkuNum(Integer skuNum) {
        this.skuNum = skuNum;
    }

    /**
     * 小计金额
     * @return subtotal_fee 小计金额
     */
    public BigDecimal getSubtotalFee() {
        return subtotalFee;
    }

    /**
     * 小计金额
     * @param subtotalFee 小计金额
     */
    public void setSubtotalFee(BigDecimal subtotalFee) {
        this.subtotalFee = subtotalFee;
    }

    /**
     * 是否无效，默认1：无效；2：有效。
     * @return is_product_exists 是否无效，默认1：无效；2：有效。
     */
    public Integer getIsProductExists() {
        return isProductExists;
    }

    /**
     * 是否无效，默认1：无效；2：有效。
     * @param isProductExists 是否无效，默认1：无效；2：有效。
     */
    public void setIsProductExists(Integer isProductExists) {
        this.isProductExists = isProductExists;
    }

    /**
     * 备注信息
     * @return remark 备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注信息
     * @param remark 备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 是否已评，默认1：否；2：已评；3：不可评。
     * @return is_review 是否已评，默认1：否；2：已评；3：不可评。
     */
    public Integer getIsReview() {
        return isReview;
    }

    /**
     * 是否已评，默认1：否；2：已评；3：不可评。
     * @param isReview 是否已评，默认1：否；2：已评；3：不可评。
     */
    public void setIsReview(Integer isReview) {
        this.isReview = isReview;
    }

    /**
     * 是否已追评，默认1：否；2：已追评；3：不可追评。
     * @return is_last_review 是否已追评，默认1：否；2：已追评；3：不可追评。
     */
    public Integer getIsLastReview() {
        return isLastReview;
    }

    /**
     * 是否已追评，默认1：否；2：已追评；3：不可追评。
     * @param isLastReview 是否已追评，默认1：否；2：已追评；3：不可追评。
     */
    public void setIsLastReview(Integer isLastReview) {
        this.isLastReview = isLastReview;
    }

    /**
     * 可评论时间，过期不可评价
     * @return review_live_time 可评论时间，过期不可评价
     */
    public Date getReviewLiveTime() {
        return reviewLiveTime;
    }

    /**
     * 可评论时间，过期不可评价
     * @param reviewLiveTime 可评论时间，过期不可评价
     */
    public void setReviewLiveTime(Date reviewLiveTime) {
        this.reviewLiveTime = reviewLiveTime;
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
        TShopOrderItem other = (TShopOrderItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getItemNo() == null ? other.getItemNo() == null : this.getItemNo().equals(other.getItemNo()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getSkuNo() == null ? other.getSkuNo() == null : this.getSkuNo().equals(other.getSkuNo()))
            && (this.getSkuName() == null ? other.getSkuName() == null : this.getSkuName().equals(other.getSkuName()))
            && (this.getSkuOriginalPrice() == null ? other.getSkuOriginalPrice() == null : this.getSkuOriginalPrice().equals(other.getSkuOriginalPrice()))
            && (this.getSkuSalePrice() == null ? other.getSkuSalePrice() == null : this.getSkuSalePrice().equals(other.getSkuSalePrice()))
            && (this.getSkuType() == null ? other.getSkuType() == null : this.getSkuType().equals(other.getSkuType()))
            && (this.getSkuMarque() == null ? other.getSkuMarque() == null : this.getSkuMarque().equals(other.getSkuMarque()))
            && (this.getSkuAttribute() == null ? other.getSkuAttribute() == null : this.getSkuAttribute().equals(other.getSkuAttribute()))
            && (this.getSkuSpec() == null ? other.getSkuSpec() == null : this.getSkuSpec().equals(other.getSkuSpec()))
            && (this.getDiscountRate() == null ? other.getDiscountRate() == null : this.getDiscountRate().equals(other.getDiscountRate()))
            && (this.getDiscountAmount() == null ? other.getDiscountAmount() == null : this.getDiscountAmount().equals(other.getDiscountAmount()))
            && (this.getSkuNum() == null ? other.getSkuNum() == null : this.getSkuNum().equals(other.getSkuNum()))
            && (this.getSubtotalFee() == null ? other.getSubtotalFee() == null : this.getSubtotalFee().equals(other.getSubtotalFee()))
            && (this.getIsProductExists() == null ? other.getIsProductExists() == null : this.getIsProductExists().equals(other.getIsProductExists()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getIsReview() == null ? other.getIsReview() == null : this.getIsReview().equals(other.getIsReview()))
            && (this.getIsLastReview() == null ? other.getIsLastReview() == null : this.getIsLastReview().equals(other.getIsLastReview()))
            && (this.getReviewLiveTime() == null ? other.getReviewLiveTime() == null : this.getReviewLiveTime().equals(other.getReviewLiveTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getItemNo() == null) ? 0 : getItemNo().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getSkuNo() == null) ? 0 : getSkuNo().hashCode());
        result = prime * result + ((getSkuName() == null) ? 0 : getSkuName().hashCode());
        result = prime * result + ((getSkuOriginalPrice() == null) ? 0 : getSkuOriginalPrice().hashCode());
        result = prime * result + ((getSkuSalePrice() == null) ? 0 : getSkuSalePrice().hashCode());
        result = prime * result + ((getSkuType() == null) ? 0 : getSkuType().hashCode());
        result = prime * result + ((getSkuMarque() == null) ? 0 : getSkuMarque().hashCode());
        result = prime * result + ((getSkuAttribute() == null) ? 0 : getSkuAttribute().hashCode());
        result = prime * result + ((getSkuSpec() == null) ? 0 : getSkuSpec().hashCode());
        result = prime * result + ((getDiscountRate() == null) ? 0 : getDiscountRate().hashCode());
        result = prime * result + ((getDiscountAmount() == null) ? 0 : getDiscountAmount().hashCode());
        result = prime * result + ((getSkuNum() == null) ? 0 : getSkuNum().hashCode());
        result = prime * result + ((getSubtotalFee() == null) ? 0 : getSubtotalFee().hashCode());
        result = prime * result + ((getIsProductExists() == null) ? 0 : getIsProductExists().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getIsReview() == null) ? 0 : getIsReview().hashCode());
        result = prime * result + ((getIsLastReview() == null) ? 0 : getIsLastReview().hashCode());
        result = prime * result + ((getReviewLiveTime() == null) ? 0 : getReviewLiveTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", itemNo=").append(itemNo);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", skuNo=").append(skuNo);
        sb.append(", skuName=").append(skuName);
        sb.append(", skuOriginalPrice=").append(skuOriginalPrice);
        sb.append(", skuSalePrice=").append(skuSalePrice);
        sb.append(", skuType=").append(skuType);
        sb.append(", skuMarque=").append(skuMarque);
        sb.append(", skuAttribute=").append(skuAttribute);
        sb.append(", skuSpec=").append(skuSpec);
        sb.append(", discountRate=").append(discountRate);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append(", skuNum=").append(skuNum);
        sb.append(", subtotalFee=").append(subtotalFee);
        sb.append(", isProductExists=").append(isProductExists);
        sb.append(", remark=").append(remark);
        sb.append(", isReview=").append(isReview);
        sb.append(", isLastReview=").append(isLastReview);
        sb.append(", reviewLiveTime=").append(reviewLiveTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}