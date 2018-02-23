/**
 * 
 */
package com.meikai.util.email;




import com.meikai.util.email.SendEmail;


/**
 * @author meikai
 * @version 2017年8月31日 下午9:51:45
 * 发送邮件
 */
public class EmailTest  {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception  {
	         
		String targetEmail = "meikai.chen@live.com";
		String activeUrl   = "待输入的激活链接，该链接需要带有该用户ID，激活码和激活时间";
		String findPasswordUrl   = "待输入的验证修改密码链接，该链接需要带有该用户ID，验证码和验证时间";
		String targetUrl   = "目标链接";
		String targetUser_name ="目标用户名";
		
		//发送激活账号邮件
//		SendEmail.sendActiveEmail(targetEmail,activeUrl);
		
		//发送找回密码邮件
//		SendEmail.sendFindPasswordEmail(targetEmail, findPasswordUrl);
		
		//创建激活邮件内容
		String activeContent =creatContent.createActiveContent(targetUser_name, targetUrl);
		
		//发送邮件
		SendEmail.sendEmail(targetEmail, activeContent);
		
	}

}
