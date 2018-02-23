package com.meikai.shop.exportExcel;


import java.util.ArrayList;
import java.util.List;
import com.meikai.shop.entity.TSystemManagerRole;
import com.meikai.util.DateUtil;
import lombok.Data;

/**
 * 要导出excel数据
 * @author meikai
 * @version 2017年10月13日 下午3:51:05
 */
@Data
public class ExcelManagerRole {
   
    
    /**
     * 是否内置
     */
    private String isSystem;
    
    /**
     * 管理员名字
     */
    private String managerName;
    
    
    /**
     * 角色名称
     */
    private String roleName;
    
    
    /**
     * 创建时间
     */
    private String createDate;
    
    
    
    
    public String getIsSystem() {
		return isSystem;
	}




	public void setIsSystem(String isSystem) {
		this.isSystem = isSystem;
	}




	public String getManagerName() {
		return managerName;
	}




	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}




	public String getRoleName() {
		return roleName;
	}




	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}




	public String getCreateDate() {
		return createDate;
	}




	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}




	public List<ExcelManagerRole> build(List<TSystemManagerRole> managerRoles){
    	
    	List<ExcelManagerRole> excelManagerRoles = new ArrayList<ExcelManagerRole>();
    	
    	/**
    	 * 遍历集合，转存到excelManagerRoles集合中
    	 */
    	for(TSystemManagerRole managerRole : managerRoles) {
    		
    		ExcelManagerRole excelManagerRole = new ExcelManagerRole();
    		
    		excelManagerRole.setManagerName(managerRole.getManagerName());
    		
    		excelManagerRole.setRoleName(managerRole.getRoleName());;
    		
    		
    		excelManagerRole.setIsSystem(managerRole.getIsSystem()==1 ? "不内置":"内置");
    		
    		if(managerRole.getCreateDate() != null) {
    			excelManagerRole.setCreateDate(DateUtil.getDateTimeFormat(managerRole.getCreateDate()));
    		}
    		
    		
    		
    		excelManagerRoles.add(excelManagerRole)	;
    	}
    	
    	return excelManagerRoles;
    }

    
}
	    