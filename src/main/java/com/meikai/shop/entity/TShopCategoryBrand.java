package com.meikai.shop.entity;

import java.io.Serializable;

public class TShopCategoryBrand implements Serializable {
    /**
     * 主键Id，分类-品牌关联
     */
    private Long id;

    /**
     * 分类Id
     */
    private Long categoryId;

    /**
     * 品牌Id
     */
    private Long brandId;

    /**
     * 排序
     */
    private Integer sort;
    
    /**
     * 分类名
     */
    private String categoryName;
     
    /**
     * 品牌名
     */
    private String brandName;
    /**
     * t_shop_category_brand
     */
    
    /**
     * 品牌logo
     */
    private String logo;
    
    private static final long serialVersionUID = 1L;

    /**
     * 主键Id，分类-品牌关联
     * @return id 主键Id，分类-品牌关联
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键Id，分类-品牌关联
     * @param id 主键Id，分类-品牌关联
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 分类Id
     * @return category_id 分类Id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 分类Id
     * @param categoryId 分类Id
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 品牌Id
     * @return brand_id 品牌Id
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * 品牌Id
     * @param brandId 品牌Id
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * 排序
     * @return sort 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    
    /**
     * 获得分类名
     * @return
     */
    public String getCategoryName() {
		return categoryName;
	}
    /**
     * 设置分类名
     * @param categoryName
     */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
    /**
     * 获得品牌名
     * @return
     */
	public String getBrandName() {
		return brandName;
	}
	
    /**
     * 设置品牌名
     * @param brandName
     */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
    /**
     * 获得品牌Logo
     * @return
     */
	public String getLogo() {
		return logo;
	}
    /**
     * 设置logo
     * @param logo
     */
	public void setLogo(String logo) {
		this.logo = logo;
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
        TShopCategoryBrand other = (TShopCategoryBrand) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", brandId=").append(brandId);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}