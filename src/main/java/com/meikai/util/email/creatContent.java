/**
 * 
 */
package com.meikai.util.email;


import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;


/**
 * @author meikai
 * @version 2017年8月31日 下午10:23:28
 * 创建发送邮件内容
 */



public class creatContent{
	
	
	//创建激活账号邮件内容
	public static String createActiveContent(String username,String activeUrl) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<div>尊敬的");
		sb.append("<span style='color:red;'>");
		sb.append(username);
		sb.append("</span>");
		sb.append("用户,您好!</div>");
		sb.append("<div>由衷感谢您注册了我们的账号！</div>");
		sb.append("<div>离真正加入我们的大家庭只差一步了，现需要您于24小时内点击下面的链接激活账号，请点击下面的链接：</div>");
		sb.append("<div><a href='");
		sb.append(activeUrl);
		sb.append("'>请点击我吧，点击我就能激活账号了</a></div>");
		
		return sb.toString();
	}
	
	//创建找回密码邮件内容
	public static String createFindpasswordContent(String username,String FindpasswordUrl) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<div>尊敬的");
		sb.append("<span style='color:red;'>");
		sb.append(username);
		sb.append("</span>");
		sb.append("用户,您好!</div>");
		sb.append("<div>希望您尽早回归到我们的大家庭</div>");
		sb.append("<div>请您于2小时内点击下面链接以重设密码，请点击下面的链接：</div>");
		sb.append("<div><a href='");
		sb.append(FindpasswordUrl);
		sb.append("'>请点击我吧，点击我就能重设密码了</a></div>");
		
		return sb.toString();
	}

	
}