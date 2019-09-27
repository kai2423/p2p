package util;

import java.io.File;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
  *  发送邮件
 * @author Administrator
 *
 */
public class EmailUtil {
	
	
	/**
	  *  发送简单的文本邮件
	 *  	通过gklg_rd@163.com的邮箱账号发送邮件
	 * @param to  	    :   收件人    必须存在
	 * @param subject ： 邮件主题
	 * @param text    ： 邮件正文
	 */
	public static void sendTextEmail(String to, String subject, String text)
	{
		//发送者
		JavaMailSenderImpl send = getSend();
		
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setFrom("gklg_rd@163.com");
		mailMessage.setSubject(subject);
		mailMessage.setText(text);

		//发送邮件
		send.send(mailMessage);

		System.out.println("邮件发送成功..");
	}
	
	/**
	  *  发送简单的文本邮件
	 *  	自定义发送者
	 * @param sendHost ：所使用邮箱的服务器IP
	 * @param username ：所使用邮箱的用户账号
	 * @param password ：所使用邮箱开启POP3/SMTP服务时的授权码
	 * @param to  	     ：收件人    必须存在
	 * @param subject  ：邮件主题
	 * @param text     ：邮件正文
	 */
	public static void sendTextEmail(String sendHost, String username, String password, String to, String subject, String text)
	{
		JavaMailSenderImpl send = getSend(sendHost, username, password);
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setFrom(username);
		mailMessage.setSubject(subject);
		mailMessage.setText(text);

		//发送邮件
		send.send(mailMessage);

		System.out.println("邮件发送成功..");
	}
	
	/**
	 * 
	 * @param sendHost ：所使用邮箱的服务器IP
	 * @param username ：所使用邮箱的用户账号
	 * @param password ：所使用邮箱开启POP3/SMTP服务时的授权码
	 * @param prop     : 对服务器的相关设置
	 * @param to  	     ：收件人    必须存在
	 * @param subject  ：邮件主题
	 * @param text     ：邮件正文
	 */
	public static void sendTextEmail(String sendHost, String username, String password, Properties prop, String to, String subject, String text)
	{
		JavaMailSenderImpl send = getSend(sendHost, username, password);
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setFrom(username);
		mailMessage.setSubject(subject);
		mailMessage.setText(text);

		//发送邮件
		send.send(mailMessage);

		System.out.println("邮件发送成功..");
	}
	
	
	
	public static void sendHtmlEmail(String to, String subject, String textHtml) throws MessagingException
	{
		JavaMailSenderImpl send = getSend();
		MimeMessage mMessage=send.createMimeMessage();//创建邮件对象
		MimeMessageHelper mMessageHelper = new MimeMessageHelper(mMessage,true);
		mMessageHelper.setFrom("gklg_rd@163.com");//发件人邮箱
		mMessageHelper.setTo(to);//收件人邮箱
		mMessageHelper.setSubject(subject);//邮件的主题
		mMessageHelper.setText(textHtml,true);//邮件的文本内容，true表示文本以html格式打开
		File file=new File("E:\\Jellyfish.jpg");//在邮件中添加一张图片
		FileSystemResource resource=new FileSystemResource(file);
		mMessageHelper.addInline("fengye", resource);//这里指定一个id,在上面引用
		mMessageHelper.addAttachment("沙漠.jpg", resource);//在邮件中添加一个附件
		mMessageHelper.addAttachment("沙漠.jpg", resource);//在邮件中添加一个附件
		mMessageHelper.addAttachment("沙漠.jpg", resource);//在邮件中添加一个附件
		send.send(mMessage);//发送邮件
		
	}
	
	public static void sendHtmlEmail(String sendHost, String username, String password,String to, String subject, String textHtml,String filepath) throws MessagingException
	{
		JavaMailSenderImpl send = getSend(sendHost,username,password);
		MimeMessage mMessage=send.createMimeMessage();//创建邮件对象
		MimeMessageHelper mMessageHelper = new MimeMessageHelper(mMessage,true);
		mMessageHelper.setFrom(username);//发件人邮箱
		mMessageHelper.setTo(to);//收件人邮箱
		mMessageHelper.setSubject(subject);//邮件的主题
		mMessageHelper.setText(textHtml,true);//邮件的文本内容，true表示文本以html格式打开
		File file=new File(filepath);//在邮件中添加一张图片
		FileSystemResource resource=new FileSystemResource(file);
		mMessageHelper.addInline("fengye", resource);//这里指定一个id,在上面引用
		mMessageHelper.addAttachment("沙漠.jpg", resource);//在邮件中添加一个附件
		mMessageHelper.addAttachment("沙漠.jpg", resource);//在邮件中添加一个附件
		mMessageHelper.addAttachment("沙漠.jpg", resource);//在邮件中添加一个附件
		send.send(mMessage);//发送邮件
		
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 创建一个简单的发送者，并返回
	 * 	发送者固定
	 * 		from ： gklg_rd@163.com
	 * @return
	 */
	private static JavaMailSenderImpl getSend()
	{
		JavaMailSenderImpl send  = new JavaMailSenderImpl();
		send.setHost("smtp.163.com");
		Properties prop=new Properties();
		//将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.auth","true");
		//设置发送超时，当超过设置值时则取消发送
		prop.put("mail.smtp.timeout", "25000");
		send.setJavaMailProperties(prop);
		 //设置username
		send.setUsername("gklg_rd@163.com");
		//设置password 授权码
		send.setPassword("6853869kai"); 
		send.setDefaultEncoding("Utf-8");
		
		
		return send;
	}
	
	/**
	 * 	创建一个简单的发送者，并返回
	 * 		对发送者进行简单设置（可以更改发送者的服务器）
	 * @param sendHost
	 * @param username
	 * @param password
	 * @return
	 */
	private static JavaMailSenderImpl getSend(String sendHost, String username, String password)
	{
		JavaMailSenderImpl send  = new JavaMailSenderImpl();
		send.setHost(sendHost);
		Properties prop=new Properties();
		//将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.auth","true");
		//设置发送超时，当超过设置值时则取消发送
		prop.put("mail.smtp.timeout", "25000");
		send.setJavaMailProperties(prop);
		 //设置username
		send.setUsername(username);
		//设置password 授权码
		send.setPassword(password); 
		send.setDefaultEncoding("Utf-8");
		return send;
	}
	
	/**
	 * 创建一个简单的发送者，并返回
	 * 		对发送者进行简单设置（可以更改发送者的服务器，以及服务器的相关参数设置 如："mail.smtp.timeout", "25000"）
	 * @param sendHost
	 * @param username
	 * @param password
	 * @param prop
	 * @return
	 */
	private static JavaMailSenderImpl getSend(String sendHost, String username, String password, Properties prop)
	{
		JavaMailSenderImpl send  = new JavaMailSenderImpl();
		send.setHost(sendHost);	
		send.setJavaMailProperties(prop);
		 //设置username
		send.setUsername(username);
		//设置password 授权码
		send.setPassword(password); 
		send.setDefaultEncoding("Utf-8");
		return send;
	}


}
