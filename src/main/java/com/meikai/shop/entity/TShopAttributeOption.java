package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopAttributeOption implements Serializable {
    /**
     * 主键ID
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
     * 属性选项名
     */
    private String optionName;

    /**
     * 属性状态
     */
    private Integer optionStatu;

    /**
     * 属性序号
     */
    private Integer optionSort;

    /**
     * 属性ID
     */
    private Long attributeId;

    /**
     * t_shop_attribute_option
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     * @return ID 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
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
     * 属性选项名
     * @return OPTION_NAME 属性选项名
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * 属性选项名
     * @param optionName 属性选项名
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName == null ? null : optionName.trim();
    }

    /**
     * 属性状态
     * @return OPTION_STATU 属性状态
     */
    public Integer getOptionStatu() {
        return optionStatu;
    }

    /**
     * 属性状态
     * @param optionStatu 属性状态
     */
    public void setOptionStatu(Integer optionStatu) {
        this.optionStatu = optionStatu;
    }

    /**
     * 属性序号
     * @return OPTION_SORT 属性序号
     */
    public Integer getOptionSort() {
        return optionSort;
    }

    /**
     * 属性序号
     * @param optionSort 属性序号
     */
    public void setOptionSort(Integer optionSort) {
        this.optionSort = optionSort;
    }

    /**
     * 属性ID
     * @return ATTRIBUTE_ID 属性ID
     */
    public Long getAttributeId() {
        return attributeId;
    }

    /**
     * 属性ID
     * @param attributeId 属性ID
     */
    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
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
        TShopAttributeOption other = (TShopAttributeOption) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getOptionName() == null ? other.getOptionName() == null : this.getOptionName().equals(other.getOptionName()))
            && (this.getOptionStatu() == null ? other.getOptionStatu() == null : this.getOptionStatu().equals(other.getOptionStatu()))
            && (this.getOptionSort() == null ? other.getOptionSort() == null : this.getOptionSort().equals(other.getOptionSort()))
            && (this.getAttributeId() == null ? other.getAttributeId() == null : this.getAttributeId().equals(other.getAttributeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getOptionName() == null) ? 0 : getOptionName().hashCode());
        result = prime * result + ((getOptionStatu() == null) ? 0 : getOptionStatu().hashCode());
        result = prime * result + ((getOptionSort() == null) ? 0 : getOptionSort().hashCode());
        result = prime * result + ((getAttributeId() == null) ? 0 : getAttributeId().hashCode());
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
        sb.append(", optionName=").append(optionName);
        sb.append(", optionStatu=").append(optionStatu);
        sb.append(", optionSort=").append(optionSort);
        sb.append(", attributeId=").append(attributeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}