package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopSpuSpecification implements Serializable {
    /**
     * 主键ID,商品-规格关联
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建者
     */
    private String creater;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 更新者
     */
    private String updater;

    /**
     * 商品ID
     */
    private Long spuId;

    /**
     * 规格ID
     */
    private Long specificationId;

    /**
     * t_shop_spu_specification
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID,商品-规格关联
     * @return ID 主键ID,商品-规格关联
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID,商品-规格关联
     * @param id 主键ID,商品-规格关联
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
     * 创建者
     * @return CREATER 创建者
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 创建者
     * @param creater 创建者
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
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
     * 商品ID
     * @return SPU_ID 商品ID
     */
    public Long getSpuId() {
        return spuId;
    }

    /**
     * 商品ID
     * @param spuId 商品ID
     */
    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    /**
     * 规格ID
     * @return SPECIFICATION_ID 规格ID
     */
    public Long getSpecificationId() {
        return specificationId;
    }

    /**
     * 规格ID
     * @param specificationId 规格ID
     */
    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
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
        TShopSpuSpecification other = (TShopSpuSpecification) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getSpuId() == null ? other.getSpuId() == null : this.getSpuId().equals(other.getSpuId()))
            && (this.getSpecificationId() == null ? other.getSpecificationId() == null : this.getSpecificationId().equals(other.getSpecificationId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getSpuId() == null) ? 0 : getSpuId().hashCode());
        result = prime * result + ((getSpecificationId() == null) ? 0 : getSpecificationId().hashCode());
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
        sb.append(", creater=").append(creater);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updater=").append(updater);
        sb.append(", spuId=").append(spuId);
        sb.append(", specificationId=").append(specificationId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}