package com.meikai.shop.exportExcel;

import java.util.ArrayList;
import java.util.List;
import com.meikai.shop.entity.TSystemRole;
import com.meikai.util.DateUtil;

import lombok.Data;


@Data
public class ExcelRole {
 
    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String description;

   
    /**
     * 是否内置，不可删除，默认1：不内置，2：内置；
     */
    private String isSystem;

    /**
     * 创建者
     */
    private String creater;

    /**
     * 修改者
     */
    private String updater;
    
    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 修改时间
     */
    private String updateDate;
    
    
    
   
    public String getRoleName() {
		return roleName;
	}




	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getIsSystem() {
		return isSystem;
	}




	public void setIsSystem(String isSystem) {
		this.isSystem = isSystem;
	}




	public String getCreater() {
		return creater;
	}




	public void setCreater(String creater) {
		this.creater = creater;
	}




	public String getUpdater() {
		return updater;
	}




	public void setUpdater(String updater) {
		this.updater = updater;
	}




	public String getCreateDate() {
		return createDate;
	}




	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}




	public String getUpdateDate() {
		return updateDate;
	}




	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}




	/**
     * 构建需要展示的管理员信息
     * @param managers
     * @return
     */
    public List<ExcelRole> build(List<TSystemRole> roles){
    	
    	List<ExcelRole> excelRoles = new ArrayList<ExcelRole>();
    	
    	/**
    	 * 遍历集合，转存到excelManagers集合中
    	 */
    	for(TSystemRole role : roles) {
    		
    		ExcelRole excelRole = new ExcelRole();
    		
    		excelRole.setRoleName(role.getRoleName());
    		
    		excelRole.setDescription(role.getDescription());
    		
    		
    		excelRole.setIsSystem(role.getIsSystem()==1 ? "不内置":"内置");
    		
    		excelRole.setCreater(role.getCreater());
    		
    		excelRole.setUpdater(role.getUpdater());
    		
    		if(role.getCreateDate() != null) {
    			excelRole.setCreateDate(DateUtil.getDateTimeFormat(role.getCreateDate()));
    		}
    		
    		if(role.getUpdateDate() != null) {
    			excelRole.setUpdateDate(DateUtil.getDateTimeFormat(role.getUpdateDate()));
    		}
    		
    		
    		excelRoles.add(excelRole)	;
    	}
    	
    	return excelRoles;
    }
  
   
}