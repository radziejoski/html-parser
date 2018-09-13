package pl.lalowicz.htmlparser.event;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.lalowicz.htmlparser.EmailUtil;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author radziejoski
 **/
@RestController
public class EventController {

    private EventService eventService;
    private ArrayList<Event> events = new ArrayList<>();

    public EventController(EventService eventService)
    {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test()
    {
        int size = events.size();
        return String.valueOf(size);
    }

    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
    public String sendEmail() throws UnsupportedEncodingException, MessagingException {
        final String fromEmail = "notifier.radziejoski@gmail.com";
        final String password = "FCbarcelona123";
        String toEmail = "radoslaw.lalowicz@gmail.com";


        Properties prps = System.getProperties();
        prps.put("mail.smtp.host", "smtp.gmail.com");
        prps.put("mail.smtp.socketFactory.port", "465");
        prps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prps.put("mail.smtp.auth", "true");
        prps.put("mail.smtp.port", "465");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getInstance(prps, auth);

        EmailUtil.sendEmail(session, toEmail, "Test Subject", "Test Body");
        return "Message was sent";
    }

    @Scheduled(fixedRate = 2000)
    public void schedule() throws IOException
    {
        List<Event> allEventsByMonth = eventService.getAllEventsByMonth(10);
        int size = allEventsByMonth.size();
        events.addAll(allEventsByMonth);
    }
}
