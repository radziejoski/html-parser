package pl.lalowicz.htmlparser.scheduler;

import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.lalowicz.htmlparser.event.Event;
import pl.lalowicz.htmlparser.event.EventService;

import java.io.IOException;
import java.util.List;

/**
 * @author radziejoski
 **/
@Component
public class SchedulerTest {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerTest.class);
    private EventService eventService;

    public SchedulerTest(EventService eventService)
    {
        this.eventService = eventService;
    }

//    @Scheduled(fixedRate = 2000)
//    public void schedule() throws IOException
//    {
//        List<Event> allEventsByMonth = eventService.getAllEventsByMonth(10);
//        int size = allEventsByMonth.size();
//        logger.info("Execution time" + LocalDateTime.now() + "   " + size);
//    }
}
