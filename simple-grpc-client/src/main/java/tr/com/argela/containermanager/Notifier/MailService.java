package tr.com.argela.containermanager.Notifier;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {
    private MailService(){}
    private static String host = "smtp.gmail.com";
    private static String protocol = "smtp";


    private static Properties getProps(String host,String from, String pass)
    {
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        return props;
    }

    private static MimeMessage generateMessage(Session session ,String from, String[] to, String subject, String body) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        // To get the array of addresses
        for( int i = 0; i < to.length; i++ ) {
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to[i]));
        }
        message.setSubject(subject);
        message.setText(body);
        return message;
    }

    public static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = getProps(host,from,pass);
        Session session = Session.getDefaultInstance(props);

        try {
            MimeMessage message = generateMessage(session,from,to,subject,body);
            Transport transport = session.getTransport(protocol);
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
