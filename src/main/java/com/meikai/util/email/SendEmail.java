/**
 * 
 */
package com.meikai.util.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * @author meikai
 * @version 2017年9月1日 下午8:21:54
 * 验证邮件
 */
public class SendEmail {
	
	/*
     * qq邮件
     */
    // 发件人电子邮箱
    static String accountEmail = "562899487@qq.com";		         
    //发件人邮箱权限码
    static String accountCode = "gmepxwqvhqqbbbhc";		
    // 收件人电子邮箱
//	 String targetEmail = "meikai.chen@live.com";
    // 指定发送邮件的主机为 smtp.qq.com
    static String host = "smtp.qq.com";  //QQ 邮件服务器
	
			
    /*
     * 注册验证
     */
    //targetEmail参数是传入的目标邮件地址，activeUrl参数是绑定了用户参数的激活链接，该链接绑定了账号ID、激活码和有效时间
	public static void sendActiveEmail(String targetEmail,String activeUrl) throws Exception {
		
		// 获取系统属性
		Properties properties = System.getProperties();

		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);

		properties.put("mail.smtp.auth", "true");
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.socketFactory", sf);
		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties,new Authenticator(){
			public PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(accountEmail,accountCode ); //发件人邮件用户名、密码
			}
		});

			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);

			// Set From: 头部头字段
			message.setFrom(new InternetAddress(accountEmail));

			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(targetEmail));

			// Set Subject: 头部头字段
			message.setSubject("注册认证测试");
			
			//邮件内容，将激活链接传入
			String context = "<div>由衷的感谢您的注册！</did><div>现需要您在24小时内点击激活账号，请点击以下链接：</div> <br>"
					         + "<a href='"+activeUrl+"'>点击我你就激活成功啦，快点击我吧。</a>";

			// 设置消息体
			message.setContent(context,"text/html;charset=UTF-8");

			// 发送消息
			Transport.send(message);
			System.out.println("Sent message successfully....");
		
	}
	
	
	/*
     * 找回密码
     */
    //targetEmail参数是传入的目标邮件地址，targetUrl参数是绑定了用户参数的激活链接，该链接绑定了账号ID、验证码和有效时间
	public static void sendFindPasswordEmail(String targetEmail,String findPasswordUrl) throws Exception {
		
		// 获取系统属性
		Properties properties = System.getProperties();

		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);

		properties.put("mail.smtp.auth", "true");
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.socketFactory", sf);
		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties,new Authenticator(){
			public PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(accountEmail,accountCode ); //发件人邮件用户名、密码
			}
		});

			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);

			// Set From: 头部头字段
			message.setFrom(new InternetAddress(accountEmail));

			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(targetEmail));

			// Set Subject: 头部头字段
			message.setSubject("找回密码测试");
			
			//邮件内容，将激活链接传入
			String context = "<div>希望您回归我们的大家庭！</did><div>现需要您在24小时内通过点击以下链接以修改密码，请点击以下链接：</div> <br>"
					         + "<a href='"+findPasswordUrl+"'>点击我你就可以修改密码了，快点击我吧。</a>";

			// 设置消息体
			message.setContent(context,"text/html;charset=UTF-8");

			// 发送消息
			Transport.send(message);
			System.out.println("Sent message successfully....");
		
	}
	
	
	
	
	/*
     * 发送邮件
     */
    //targetEmail参数是传入的目标邮件地址，emailContent参数是邮件发送的内容
	public static void sendEmail(String targetEmail,String emailContent) throws Exception {
		
		// 获取系统属性
		Properties properties = System.getProperties();

		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.socketFactory", sf);
		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties,new Authenticator(){
			public PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(accountEmail,accountCode ); //发件人邮件用户名、密码
			}
		});

			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);

			// Set From: 头部头字段
			message.setFrom(new InternetAddress(accountEmail));

			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(targetEmail));

			// Set Subject: 头部头字段，
			message.setSubject("请输入邮件内容标题");
			

			// 设置消息体，即发送的邮件正文内容
			message.setContent(emailContent,"text/html;charset=UTF-8");

			// 发送消息
			Transport.send(message);
			System.out.println("Sent message successfully....");
		
	}
		
	


}
