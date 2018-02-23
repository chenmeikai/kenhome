/**
 * 
 */
package com.meikai.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meikai.shop.entity.TSystemArea;
import com.meikai.shop.service.AreaService;

/**
 * 地理位置
 * @author meikai
 * @version 2017年11月17日 下午1:18:29
 */
@Controller("areaController")
@RequestMapping("/shop/area/")
public class AreaController {
	
	@Resource
	private AreaService areaServce;
	
	@RequestMapping(value="getNext/{parentId}")
	@ResponseBody
	public Map<String,Object> getNext(@PathVariable("parentId")Long parentId,HttpServletRequest request){
		
		Map<String,Object> result =new HashMap<String,Object>();
		
		List<TSystemArea> sonAreas  =areaServce.getSon(parentId);
		result.put("sonAreas", sonAreas);
		result.put("rootUrl", request.getContextPath());
		return result;
		
	}
	
	

}
