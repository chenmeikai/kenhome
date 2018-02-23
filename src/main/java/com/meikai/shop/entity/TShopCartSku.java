package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopCartSku implements Serializable {
    /**
     * 主键ID,购物车
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
     * 购物车ID
     */
    private Long cartId;
    
    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long skuId;
    
    /**
     * 商品对象
     */
    private TShopSku sku ;

    /**
     * 数量
     */
    private Integer nums;
    

    /**
     * t_shop_cart_sku
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID,购物车
     * @return ID 主键ID,购物车
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID,购物车
     * @param id 主键ID,购物车
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
     * 购物车ID
     * @return CART_ID 购物车ID
     */
    public Long getCartId() {
        return cartId;
    }

    /**
     * 购物车ID
     * @param cartId 购物车ID
     */
    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
    
    
    /**
     * 获得用户id
     * @return
     */
    public Long getUserId() {
		return userId;
	}
    /**
     * 设置用户Id
     * @param userId
     */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
     * 单品ID
     * @return SKU_ID 单品ID
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * 单品ID
     * @param skuId 单品ID
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
    
    
    /**
     * 获得商品对象
     * @return
     */
    public TShopSku getSku() {
		return sku;
	}
    
    /**
     * 设置商品对象
     * @param sku
     */
	public void setSku(TShopSku sku) {
		this.sku = sku;
	}

	/**
     * 数量
     * @return NUMS 数量
     */
    public Integer getNums() {
        return nums;
    }

    /**
     * 数量
     * @param nums 数量
     */
    public void setNums(Integer nums) {
        this.nums = nums;
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
        TShopCartSku other = (TShopCartSku) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCartId() == null ? other.getCartId() == null : this.getCartId().equals(other.getCartId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getNums() == null ? other.getNums() == null : this.getNums().equals(other.getNums()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getCartId() == null) ? 0 : getCartId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
        result = prime * result + ((getNums() == null) ? 0 : getNums().hashCode());
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
        sb.append(", cartId=").append(cartId);
        sb.append(", skuId=").append(skuId);
        sb.append(", nums=").append(nums);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}