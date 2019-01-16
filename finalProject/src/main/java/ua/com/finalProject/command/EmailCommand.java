package ua.com.finalProject.command;

import org.apache.log4j.Logger;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

public class EmailCommand implements ActionCommand {
    private static final Logger log = Logger.getLogger(EmailCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        String username = "mynick))";
                        String password = "mypass))";
                        if ((username != null) && (username.length() > 0) && (password != null)
                                && (password.length   () > 0)) {

                            return new PasswordAuthentication(username, password);
                        }
                        return null;
                    }
                });
        session.setDebug(true);
        session.getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Message msg = new MimeMessage(session);


        try {

            msg.setFrom(new InternetAddress("ttottitto@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("ttottitto@gmail.com")});
            msg.setSubject("Subject Line");
            msg.setText("Text Body");
        Transport.send(msg);
        } catch (AddressException e) {
            log.error(e);
        } catch (MessagingException e) {
            log.error(e);
        }
        return null;
    }
}
