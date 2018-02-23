/**
 * 
 */
package com.meikai.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meikai.util.weixin.CheckoutUtil;

/**微信第三方
 * @author Administrator
 * @version 2017年9月27日 下午4:13:50
 */

@Controller("weixin")
@RequestMapping("/weixinToken/")
public class WerxinLoginController {
	
	
	
	@RequestMapping("validate")
	public void hello(Model model, HttpServletRequest request,HttpServletResponse response) throws IOException {
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        PrintWriter print;
        if (isGet) {
            // 微信加密签名
            String signature = request.getParameter("signature");
            // 时间戳
            String timestamp = request.getParameter("timestamp");
            // 随机数
            String nonce = request.getParameter("nonce");
            // 随机字符串
            String echostr = request.getParameter("echostr");
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            if (signature != null && CheckoutUtil.checkSignature(signature, timestamp, nonce)) {
                try {
                    print = response.getWriter();
                    print.write(echostr);
                    print.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
      }
	}
	
	
	
	@RequestMapping("redirect")
	public String redirect(Model model, HttpServletRequest request,HttpServletResponse response) {
		
		//获得的code值
		String code = request.getParameter("code");
		
		String state = request.getParameter("state");
		
		request.setAttribute("code", code);
		
		return "/all/weixin/weixin_redirect";
		
	}
	
	
}
