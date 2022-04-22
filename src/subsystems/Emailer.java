package subsystems;
/*Java Mail API
    Tutorials:
        https://mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
        https://www.tutorialspoint.com/java/java_sending_email.htm
        https://www.javatpoint.com/java-mail-api-tutorial 
    Download: https://github.com/javaee/javamail/releases
*/
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class Emailer {
    //email account information (we are not using a locally hosted email server); name WIP
    final String username = "BISDTechDepartment@gmail.com";
    final String password = "";
    //pass in content from other subsystems such as Notifier; Notifier acts as the Runner
    String recipient;
    String subjectContent;
    String textContent;

    Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

    Session session = Session.getInstance(prop, 
        new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        }
    );

    try {
        //creates default MimeMessage object 
        MimeMessage message = new MimeMessage(session);

        //sets the From: header field
        message.setFrom(new InternetAddress(username));

        //sets the To: header field
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        //sets the Subject: header field 
        message.setSubject(subjectContent);

        //sets text of the message
        message.setText(textContent);

        //sends message
        Transport.send(message);
    } 
    catch (MessagingException messageException) {
        messageException.printStackTrace();
    }
}
