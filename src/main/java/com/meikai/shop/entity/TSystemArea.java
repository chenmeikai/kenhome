package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class TSystemArea implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String treePath;

    /**
     * 
     */
    private Long parentId;

    /**
     * 
     */
    private Date createDate;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String fullName;

    /**
     * t_system_area
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return ID 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return TREE_PATH 
     */
    public String getTreePath() {
        return treePath;
    }

    /**
     * 
     * @param treePath 
     */
    public void setTreePath(String treePath) {
        this.treePath = treePath == null ? null : treePath.trim();
    }

    /**
     * 
     * @return PARENT_ID 
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 
     * @param parentId 
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 
     * @return CREATE_DATE 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 
     * @param createDate 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 
     * @return NAME 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * @return FULL_NAME 
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 
     * @param fullName 
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
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
        TSystemArea other = (TSystemArea) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTreePath() == null ? other.getTreePath() == null : this.getTreePath().equals(other.getTreePath()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTreePath() == null) ? 0 : getTreePath().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", treePath=").append(treePath);
        sb.append(", parentId=").append(parentId);
        sb.append(", createDate=").append(createDate);
        sb.append(", name=").append(name);
        sb.append(", fullName=").append(fullName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}