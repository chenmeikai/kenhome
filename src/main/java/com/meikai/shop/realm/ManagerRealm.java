/**
 * 
 */
package com.meikai.shop.realm;

import java.util.HashSet;
import javax.annotation.Resource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.meikai.shop.entity.TSystemAcl;
import com.meikai.shop.entity.TSystemManager;
import com.meikai.shop.entity.TSystemRole;
import com.meikai.shop.service.ManagerService;



/**
 * @author Administrator
 *  
 */
public  class ManagerRealm extends AuthorizingRealm {
	
	@Resource
	ManagerService managerService;

	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		TSystemManager testManager = (TSystemManager) principals.fromRealm(getName()).iterator().next(); 
		
		TSystemManager manager=managerService.getRolesAndAclsByName(testManager.getManagerName());
		System.out.println("昵称："+manager.getNickname());
		
		HashSet<String> permissions =new HashSet<String>();
		
		if(manager != null) {
			
			System.out.println("已获得管理员");										
			for(TSystemRole role : manager.getRoles()) {
				
				System.out.println("管理员角色是"+role.getRoleName());
				
				for(TSystemAcl acl:role.getAcls()) {
					System.out.println("权限是："+acl.getPermission());
					permissions.add(acl.getPermission());					
				}						
			}			
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); 
		info.addStringPermissions(permissions);	
		return info;
	}

	
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
         
		String managerName=(String) token.getPrincipal();
		

		System.out.println("获得管理员名是"+managerName);
		

		TSystemManager manager =managerService.getRolesAndAclsByName(managerName);

		
		if(manager!=null) {
			
			String password=manager.getPassword();
			
			AuthenticationInfo aInfo = new SimpleAuthenticationInfo(manager,password,getName());
			return aInfo;			
		}
				
		return null;
	}
	
    

}
