/**
 * 
 */
package com.meikai.kenhome.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meikai.shop.service.LogConfigService;
import com.meikai.util.CommonParams;
import com.meikai.util.xml.LogConfig;
import com.meikai.util.xml.Setting;
import com.meikai.util.xml.XmlEntityUtils;


/**
 * @author Administrator
 * mvc测试
 */

@Controller("test")
@RequestMapping("test")
public class Test3Controller {
	
	@Resource
	private LogConfigService logConfigSerivce;
	

	@RequestMapping("test")
	public String test(HttpServletRequest request){
		Setting object =new Setting();
		Setting setting = (Setting) XmlEntityUtils.get(CommonParams.SETTING_XML_PATH ,"/framework/setting","name","value",object);
		
		System.out.println("获得的网站名是："+setting.getSiteName());
		
		System.out.println("获得的精确方式是："+setting.getPriceRoundType());
		
		//url对应操作集合
		List<LogConfig> logConfigs =logConfigSerivce.getAll();
		for(LogConfig logConfig :logConfigs) {
			System.out.print("操作:"+logConfig.getOperation());
			System.out.print(" ");
			System.out.println("映射:"+logConfig.getUrlPattern());
		}
		

	//	setting.setSiteName("莫名奇妙的");
	//	XmlEntityUtils.set(CommonParams.SETTING_XML_PATH ,"/framework/setting","name","value",setting);
		  
		return "test/test";
	}
	
	
		  
		

}
