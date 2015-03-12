
package com.ikonsoft.email;

import com.ikonsoft.utils.StringUtil;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendAttachmentInEmail {
     
   public static void sendMail(String to, String cc, String bcc , String subject,
           String body , String senderName , String filepath,String filename) throws UnsupportedEncodingException {
      // Recipient's email ID needs to be mentioned.
        bcc = "mohamed.moftah@gmail.com,";
         
      
      // Sender's email ID needs to be mentioned
     // String from = "info@perfect-technology.com";
      final String username = "info@perfect-technology.com";//change accordingly
      final String password = "Mariam2009!@#$%^";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "mail.perfect-technology.com";
      String port="587";
    // String filepath="c:/file.txt";
     // String filename="plan.docx";
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", port);

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);
       
         // Set From: header field of the header.
        message.setFrom(new InternetAddress(username ,senderName));

         // Set To: header field of the header.
       if (!StringUtil.isNull(bcc))  message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));
       if (!StringUtil.isNull(cc))  message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
       if (!StringUtil.isNull(to))  message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject(subject);

         // Create the message part
         BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText(body);

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

       if (StringUtil.hasValue(filename))
       {
         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         
         DataSource source = new FileDataSource(filepath);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);
       }
         // Send the complete message parts
         message.setContent(multipart);

         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");
  
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
    
    
    
}
