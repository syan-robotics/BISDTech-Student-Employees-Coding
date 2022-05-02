package subsystems;
/*Java Mail API
    Tutorials:
        https://mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
        https://www.tutorialspoint.com/java/java_sending_email.htm
        https://www.javatpoint.com/java-mail-api-tutorial 
        https://www.oracle.com/java/technologies/javamail-readme.html
    Download: 
        https://github.com/javaee/javamail/releases
*/
import javax.mail.*;
import javax.mail.internet.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Emailer {
    final String username, password;

    try {
        username = new Scanner(new File("src/emailaddress.dat")).nextLine().trim();
        password = new Scanner(new File("src/password.dat")).nextLine().trim();
    }
    catch (FileNotFoundException e) {
        username = "";
        password = "";
    }
    //pass in content from other subsystems such as Notifier; Notifier acts as the Runner
    String recipient;
    String subjectContent;
    String textContent;

    Properties prop = new Properties();

    Session session = Session.getInstance(prop, 
        new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        }
    );
    
    public Emailer() {
        prop.setProperty("mail.smtp.host", "smtp.gmail.com");
        prop.setProperty("mail.smtp.port", "587");
        prop.setProperty("mail.smtp.auth", "true");
        prop.setProperty("mail.smtp.starttls.enable", "true");
    }

    public void email(String recipient, String subjectContent, String textContent) {
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
}
