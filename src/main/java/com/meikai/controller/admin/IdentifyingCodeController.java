/**
 * 
 */
package com.meikai.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meikai.identifyingCode.CreateImageCode;

/**
 * @author Administrator
 *
 */
@Controller("identifyingCodeController")
@RequestMapping("/admin/manager")
public class IdentifyingCodeController {
	
	@RequestMapping("identifyingCode")
	public void getCode(HttpServletRequest req, HttpServletResponse response,HttpSession session) throws IOException{
            // 设置响应的类型格式为图片格式
            response.setContentType("image/jpeg");
            //禁止图像缓存。
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            
            
            CreateImageCode vCode = new CreateImageCode(100,30,5,10);
            session.setAttribute("code", vCode.getCode());
            vCode.write(response.getOutputStream());
     }

}
