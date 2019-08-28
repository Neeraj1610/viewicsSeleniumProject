package com.myproject.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

/**
 * Class to send mail.
 * 
 * @author nadhikari
 *
 */
public class SendMail {

	public enum EmailType{
		TEXT,HTML;
	}

	public void sendMailAsHtmlOrText(String hostName,String fromAddress,String toAddress,String emailSubject,EmailType emailType,String emailContent) throws Exception
	{

		Properties properties=System.getProperties();
		properties.setProperty("mail.smtp.host", hostName);

		Session session=Session.getDefaultInstance(properties);

		try{
			MimeMessage message=new MimeMessage(session);

			//Set recipients and subject
			message.setFrom(fromAddress);
			message.addRecipients(Message.RecipientType.TO, toAddress);
			message.setSubject(emailSubject);

			//Set email content
			MimeBodyPart body=new MimeBodyPart();

			if(emailType.equals(EmailType.TEXT))
			{
				body.setContent(emailContent,"text/plain");
			}
			else if(emailType.equals(EmailType.HTML))
			{
				body.setContent(emailContent,"text/html; charset=utf-8");
			}

			Transport.send(message);

		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			throw new Exception(ex);
		}
	}
}