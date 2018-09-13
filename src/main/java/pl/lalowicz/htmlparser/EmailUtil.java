package pl.lalowicz.htmlparser;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author radziejoski
 **/
public class EmailUtil {

    public static void sendEmail(Session session, String recipient, String subject, String body) throws MessagingException, UnsupportedEncodingException {
        MimeMessage msg = new MimeMessage(session);
        msg.addHeader("Content-type", "text/HTML;charset=UTF8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress("no_replay@example.com", "NoReplay-JD"));

        msg.setReplyTo(InternetAddress.parse("no_replay@example.com", false));

        msg.setSubject(subject, "UTF-8");
        msg.setText(body, "UTF-8");
        msg.setSentDate(new Date());
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient, false));

        Transport.send(msg);

    }
}
