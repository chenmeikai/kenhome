package com.meikai.shop.exportExcel;

import java.util.ArrayList;
import java.util.List;
import com.meikai.shop.entity.TSystemManager;
import com.meikai.util.DateUtil;

import lombok.Data;

/**
 * 要导出excel数据
 * @author meikai
 * @version 2017年10月13日 下午3:50:33
 */
public class ExcelManager {
   
    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 修改时间
     */
    private String updateDate;

    /**
     * 管理员名
     */
    private String managerName;

    /**
     * 昵称
     */
    private String nickname;


   
    /**
     * 是否启用，默认1：不启用，2：启用；
     */
    private String isEnable;

    /**
     * 是否锁定，默认1：不锁定，2：锁定
     */
    private String isLocked;

   
   
    /**
     * 是否永久保留，不可删除，默认1：不内置，2：内置；
     */
    private String isForver;

    /**
     * 登录时间
     */
    private String loginTime;

    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 邮箱
     */
    private String email;
    
    
    
    
    
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





	public String getManagerName() {
		return managerName;
	}





	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}





	public String getNickname() {
		return nickname;
	}





	public void setNickname(String nickname) {
		this.nickname = nickname;
	}





	public String getIsEnable() {
		return isEnable;
	}





	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}





	public String getIsLocked() {
		return isLocked;
	}





	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked;
	}





	public String getIsForver() {
		return isForver;
	}





	public void setIsForver(String isForver) {
		this.isForver = isForver;
	}





	public String getLoginTime() {
		return loginTime;
	}





	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}





	public String getLoginIp() {
		return loginIp;
	}





	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	/**
     * 构建需要展示的管理员信息
     * @param managers
     * @return
     */
    public List<ExcelManager> build(List<TSystemManager> managers){
    	
    	List<ExcelManager> excelManagers = new ArrayList<ExcelManager>();
    	
    	/**
    	 * 遍历集合，转存到excelManagers集合中
    	 */
    	for(TSystemManager manager : managers) {
    		
    		ExcelManager excelManager = new ExcelManager();
    		
    		excelManager.setManagerName(manager.getManagerName());
    		
    		excelManager.setNickname(manager.getNickname());
    		
    		excelManager.setEmail(manager.getEmail());
    		
    		excelManager.setLoginIp(manager.getLoginIp());
    		
    		excelManager.setIsEnable(manager.getIsEnable()==1 ? "不启用":"启用");
    		
    		excelManager.setIsLocked(manager.getIsLocked()==1 ? "不锁定":"锁定");
    		
    		excelManager.setIsForver(manager.getIsForver()==1 ? "不内置":"内置");
    		
    		if(manager.getCreateDate() != null) {
    			excelManager.setCreateDate(DateUtil.getDateTimeFormat(manager.getCreateDate()));
    		}
    		
    		if(manager.getUpdateDate() != null) {
    			excelManager.setUpdateDate(DateUtil.getDateTimeFormat(manager.getUpdateDate()));
    		}
    		
    		if(manager.getLoginTime() != null) {
    			excelManager.setLoginTime(DateUtil.getDateTimeFormat(manager.getLoginTime()));
    		}
    		
    		excelManagers.add(excelManager)	;
    	}
    	
    	return excelManagers;
    }
  
   
}