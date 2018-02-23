/**
 * 
 */
package com.meikai.controller.shop;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meikai.shop.entity.TShopMember;
import com.meikai.shop.entity.TShopShipAddress;
import com.meikai.shop.entity.TSystemArea;
import com.meikai.shop.service.AreaService;
import com.meikai.shop.service.ShipAddressService;

/**
 * 收货地址
 * @author meikai
 * @version 2017年11月17日 下午1:18:29
 */
@Controller("shipAddressController")
@RequestMapping("/shop/ship/")
public class ShipAddressController {
	
	@Resource
	private ShipAddressService shipAddressService;
	
	@Resource
	private AreaService areaService;
	
	/**
	 * 新增收货地址
	 * @param request
	 * @param provinceId
	 * @param cityId
	 * @param countyId
	 * @param address
	 * @param zipCode
	 * @param shipName
	 * @param phone
	 * @param isSelect
	 * @return
	 */
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> add(HttpServletRequest request,Integer provinceId,Integer cityId,Integer countyId,String address,Integer zipCode,
			String shipName,String phone,Integer isSelect){
				
		
		Map<String,Object> result =new HashMap<String,Object>();
		
		TShopMember user =(TShopMember) request.getSession().getAttribute("user");
		
		TShopShipAddress newShipAddress =new  TShopShipAddress();
		
		newShipAddress.setMemberId(user.getId());
		newShipAddress.setProvinceId(provinceId);
		newShipAddress.setCityId(cityId);
		if(countyId !=null)
		newShipAddress.setCountyId(countyId);
		newShipAddress.setAddress(address);
		newShipAddress.setZipCode(zipCode);
		newShipAddress.setShipName(shipName);
		newShipAddress.setPhone(phone);
		newShipAddress.setCreateDate(new Date());
		/**
		 * 如果设置默认，则将其他默认的取消
		 */
		if(isSelect !=null && isSelect ==2) {
			//设置为默认，不为2，则无需设置，数据库默认为1
			newShipAddress.setIsSelect(isSelect);
			Map<String,Object> prames =new HashMap<String,Object> ();
			prames.put("isSelect", 2);
			prames.put("memberId", user.getId());
			List<TShopShipAddress> changeShipAddresses =shipAddressService.getByparamsList(prames);
			//如果用户已经有默认设置,取消其它默认设置
			if(!changeShipAddresses.isEmpty()) {
				for(TShopShipAddress changeShipAddress :changeShipAddresses) {
					changeShipAddress.setIsSelect(1);
					shipAddressService.updateEntity(changeShipAddress);
				}
			}			
		}		
		Long reply =shipAddressService.saveAddEntity(newShipAddress);
		if (reply==1) {
			result.put("valid", "true");
			result.put("newShipAddress", newShipAddress);
			return result;
		}
				
		result.put("valid", "flase");
		return result;
		
	}
	
	
	/**
	 * 设置默认收货地址
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="setIsSelect/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> setIsSelect(HttpServletRequest request,@PathVariable("id")Long id){
				
		Map<String,Object> result =new HashMap<String,Object>();
		
		TShopMember user =(TShopMember) request.getSession().getAttribute("user");
		
		TShopShipAddress updateShipAddress =shipAddressService.getByID(id);
		
		//判断该地址是不是该用户的，防止前端恶意更改id
		if(updateShipAddress.getMemberId() != user.getId()) {
			result.put("valid", "illegal");
			return result;
		}
		
		updateShipAddress.setIsSelect(2);
		updateShipAddress.setUpdateDate(new Date());
		/**
		 * 如果设置默认，则将其他默认的取消
		 */
		
		Map<String,Object> prames =new HashMap<String,Object> ();
		prames.put("isSelect", 2);
		prames.put("memberId", user.getId());
		List<TShopShipAddress> changeShipAddresses =shipAddressService.getByparamsList(prames);
		//如果用户已经有默认设置,取消其默认设置
		if(!changeShipAddresses.isEmpty()) {
			for(TShopShipAddress changeShipAddress :changeShipAddresses) {
				changeShipAddress.setIsSelect(1);
				shipAddressService.updateEntity(changeShipAddress);
			}
		}							
		Long reply =shipAddressService.updateEntity(updateShipAddress);
		if (reply==1) {
			result.put("valid", "true");
			return result;
		}				
		result.put("valid", "flase");
		return result;		
	}
	
	
	/**
	 * 获得编辑的地址
	 */
	@RequestMapping(value="getEdit/{id}",method=RequestMethod.GET)
	public String getEdit(HttpServletRequest request,@PathVariable("id")Long id){
				
		
		TShopMember user =(TShopMember) request.getSession().getAttribute("user");
		
		if(user ==null) return null;
		
		TShopShipAddress editShipAddress =shipAddressService.getWithNameById(id);
		
		//判断该地址是不是该用户的，防止前端恶意更改id
		if(editShipAddress.getMemberId() != user.getId()) {
			return null;
		}
		request.setAttribute("editShipAddress", editShipAddress);		
		
		/**
		 * 获取省份资料
		 */
		List<TSystemArea> rootAreas =areaService.getRoot();
		request.setAttribute("rootAreas", rootAreas);
	    
		return "/all/include/ship-edit";		
	}
	
	/**
	 * 编辑收货地址
	 * @param request
	 * @param id
	 * @param provinceId
	 * @param cityId
	 * @param countyId
	 * @param address
	 * @param zipCode
	 * @param shipName
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> edit(HttpServletRequest request,Long id,Integer provinceId,Integer cityId,Integer countyId,String address,Integer zipCode,
			String shipName,String phone){
		
		Map<String,Object> result =new HashMap<String,Object>();
		
		TShopMember user =(TShopMember) request.getSession().getAttribute("user");
		
		
		TShopShipAddress editShipAddress =shipAddressService.getWithNameById(id);
		
		//判断该地址是不是该用户的，防止前端恶意更改id
		if(editShipAddress.getMemberId() != user.getId()) {
			result.put("valid", "illegal");
			return result;
		}
		
		editShipAddress.setMemberId(user.getId());
		editShipAddress.setProvinceId(provinceId);
		editShipAddress.setCityId(cityId);
		if(countyId !=null)
		editShipAddress.setCountyId(countyId);
		editShipAddress.setAddress(address);
		editShipAddress.setZipCode(zipCode);
		editShipAddress.setShipName(shipName);
		editShipAddress.setPhone(phone);
		editShipAddress.setUpdateDate(new Date());
		
		Long reply =shipAddressService.updateEntity(editShipAddress);
		if(reply ==1) {
			result.put("valid", "true");
			result.put("editShipAddress", editShipAddress);
			return result;
		}
		result.put("valid", "false");
		return result;		
	}
	
	/**
	 * 删除收货地址
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request,@PathVariable("id")Long id){
		
		Map<String,Object> result =new HashMap<String,Object>();
		
		TShopMember user =(TShopMember) request.getSession().getAttribute("user");
		
		
		TShopShipAddress deleteShipAddress =shipAddressService.getWithNameById(id);
		
		//判断该地址是不是该用户的，防止前端恶意更改id
		if(deleteShipAddress.getMemberId() != user.getId()) {
			result.put("valid", "illegal");
			return result;
		}
		
		//判断该地址是不是该用户的，防止前端恶意更改id
		if(deleteShipAddress.getIsSelect()==2) {
				result.put("valid", "false");
				return result;
		}
		
		Long reply =shipAddressService.delete(id);
		if(reply ==1) {
			result.put("valid", "true");
			return result;
		}
		result.put("valid", "false");
		return result;		
	}
	

}
