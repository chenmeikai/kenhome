package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TShopCategory implements Serializable {
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
     * 更新时间
     */
    private Date updateDate;

    /**
     * 最后更新者
     */
    private String updater;

    /**
     * 分类名
     */
    private String categoryName;

    /**
     * 分类编号
     */
    private Long categoryCode;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 点击量
     */
    private Long hits;

    /**
     * 树路径
     */
    private String path;

    /**
     * 父分类ID
     */
    private Long parentId;
    
    /**
     * 父分类
     */
    private TShopCategory parentCategory;

    /**
     * 分类序号
     */
    private Integer categorySort;

    /**
     * 关键字
     */
    private String meta;

    /**
     * 详情介绍
     */
    private String context;
    
    /**
     * 子分类集合
     */
    private List<TShopCategory> childrenCategorys;
    
    /**
     * 属性集合
     */
    private List<TShopAttribute> attributes;

    /**
     * t_shop_category
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
     * 最后更新者
     * @return UPDATER 最后更新者
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * 最后更新者
     * @param updater 最后更新者
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * 分类名
     * @return CATEGORY_NAME 分类名
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 分类名
     * @param categoryName 分类名
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 分类编号
     * @return CATEGORY_CODE 分类编号
     */
    public Long getCategoryCode() {
        return categoryCode;
    }

    /**
     * 分类编号
     * @param categoryCode 分类编号
     */
    public void setCategoryCode(Long categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * 图片地址
     * @return IMAGE_URL 图片地址
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 图片地址
     * @param imageUrl 图片地址
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * 点击量
     * @return HITS 点击量
     */
    public Long getHits() {
        return hits;
    }

    /**
     * 点击量
     * @param hits 点击量
     */
    public void setHits(Long hits) {
        this.hits = hits;
    }

    /**
     * 树路径
     * @return PATH 树路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 树路径
     * @param path 树路径
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 父分类ID
     * @return PARENT_ID 父分类ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父分类ID
     * @param parentId 父分类ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    

    public TShopCategory getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(TShopCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	/**
     * 分类序号
     * @return CATEGORY_SORT 分类序号
     */
    public Integer getCategorySort() {
        return categorySort;
    }

    /**
     * 分类序号
     * @param categorySort 分类序号
     */
    public void setCategorySort(Integer categorySort) {
        this.categorySort = categorySort;
    }

    /**
     * 关键字
     * @return META 关键字
     */
    public String getMeta() {
        return meta;
    }

    /**
     * 关键字
     * @param meta 关键字
     */
    public void setMeta(String meta) {
        this.meta = meta == null ? null : meta.trim();
    }

    /**
     * 详情介绍
     * @return CONTEXT 详情介绍
     */
    public String getContext() {
        return context;
    }

    /**
     * 详情介绍
     * @param context 详情介绍
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
    
    
    /**
     * 获得子分类集合
     */
    public List<TShopCategory> getChildrenCategorys() {
		return childrenCategorys;
	}
    
    /**
     * 设置子分类集合
     */
	public void setChildrenCategorys(List<TShopCategory> childrenCategorys) {
		this.childrenCategorys = childrenCategorys;
	}
    
	
	/**
	 * 获得属性集合
	 * @return
	 */
	public List<TShopAttribute> getAttributes() {
		return attributes;
	}
    /**
     * 设置属性集合
     * @param attributes
     */
	public void setAttributes(List<TShopAttribute> attributes) {
		this.attributes = attributes;
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
        TShopCategory other = (TShopCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
            && (this.getCategoryCode() == null ? other.getCategoryCode() == null : this.getCategoryCode().equals(other.getCategoryCode()))
            && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()))
            && (this.getHits() == null ? other.getHits() == null : this.getHits().equals(other.getHits()))
            && (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getCategorySort() == null ? other.getCategorySort() == null : this.getCategorySort().equals(other.getCategorySort()))
            && (this.getMeta() == null ? other.getMeta() == null : this.getMeta().equals(other.getMeta()))
            && (this.getContext() == null ? other.getContext() == null : this.getContext().equals(other.getContext()));
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
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getCategoryCode() == null) ? 0 : getCategoryCode().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        result = prime * result + ((getHits() == null) ? 0 : getHits().hashCode());
        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getCategorySort() == null) ? 0 : getCategorySort().hashCode());
        result = prime * result + ((getMeta() == null) ? 0 : getMeta().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
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
        sb.append(", categoryName=").append(categoryName);
        sb.append(", categoryCode=").append(categoryCode);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", hits=").append(hits);
        sb.append(", path=").append(path);
        sb.append(", parentId=").append(parentId);
        sb.append(", categorySort=").append(categorySort);
        sb.append(", meta=").append(meta);
        sb.append(", context=").append(context);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}