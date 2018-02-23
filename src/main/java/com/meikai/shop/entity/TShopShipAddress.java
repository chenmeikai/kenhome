package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopShipAddress implements Serializable {
    /**
     * 主键ID,收货信息
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
     * 用户ID
     */
    private Long memberId;

    /**
     * 收货人
     */
    private String shipName;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮编
     */
    private Integer zipCode;

    /**
     * 省ID
     */
    private Integer provinceId;
    
    /**
     * 省份名/直辖市
     */
    private String province;

    /**
     * 市ID
     */
    private Integer cityId;
    
    /**
     * 市名
     */
    private String city;
    

    /**
     * 县区ID
     */
    private Integer countyId;
    
    /**
     * 县名
     */
    private String county;
    

    /**
     * 详细地址
     */
    private String address;

    /**
     * 是否选中，默认1：否；2：是；只能有一个选中，其余为否
     */
    private Integer isSelect;

    /**
     * t_shop_ship_address
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID,收货信息
     * @return ID 主键ID,收货信息
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID,收货信息
     * @param id 主键ID,收货信息
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
     * 用户ID
     * @return MEMBER_ID 用户ID
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * 用户ID
     * @param memberId 用户ID
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * 收货人
     * @return SHIP_NAME 收货人
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * 收货人
     * @param shipName 收货人
     */
    public void setShipName(String shipName) {
        this.shipName = shipName == null ? null : shipName.trim();
    }

    /**
     * 电话
     * @return PHONE 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 邮编
     * @return ZIP_CODE 邮编
     */
    public Integer getZipCode() {
        return zipCode;
    }

    /**
     * 邮编
     * @param zipCode 邮编
     */
    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 省ID
     * @return PROVINCE_ID 省ID
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * 省ID
     * @param provinceId 省ID
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 市ID
     * @return CITY_ID 市ID
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 市ID
     * @param cityId 市ID
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 县区ID
     * @return COUNTY_ID 县区ID
     */
    public Integer getCountyId() {
        return countyId;
    }

    /**
     * 县区ID
     * @param countyId 县区ID
     */
    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }
    
    

    public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	/**
     * 详细地址
     * @return ADDRESS 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 详细地址
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 是否选中，默认1：否；2：是；只能有一个选中，其余为否
     * @return IS_SLECT 是否选中，默认1：否；2：是；只能有一个选中，其余为否
     */
    public Integer getIsSelect() {
        return isSelect;
    }

    /**
     * 是否选中，默认1：否；2：是；只能有一个选中，其余为否
     * @param isSlect 是否选中，默认1：否；2：是；只能有一个选中，其余为否
     */
    public void setIsSelect(Integer isSelect) {
        this.isSelect = isSelect;
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
        TShopShipAddress other = (TShopShipAddress) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getShipName() == null ? other.getShipName() == null : this.getShipName().equals(other.getShipName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getZipCode() == null ? other.getZipCode() == null : this.getZipCode().equals(other.getZipCode()))
            && (this.getProvinceId() == null ? other.getProvinceId() == null : this.getProvinceId().equals(other.getProvinceId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getCountyId() == null ? other.getCountyId() == null : this.getCountyId().equals(other.getCountyId()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getIsSelect() == null ? other.getIsSelect() == null : this.getIsSelect().equals(other.getIsSelect()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getShipName() == null) ? 0 : getShipName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getZipCode() == null) ? 0 : getZipCode().hashCode());
        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getCountyId() == null) ? 0 : getCountyId().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getIsSelect() == null) ? 0 : getIsSelect().hashCode());
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
        sb.append(", memberId=").append(memberId);
        sb.append(", shipName=").append(shipName);
        sb.append(", phone=").append(phone);
        sb.append(", zipCode=").append(zipCode);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", cityId=").append(cityId);
        sb.append(", countyId=").append(countyId);
        sb.append(", address=").append(address);
        sb.append(", isSlect=").append(isSelect);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}