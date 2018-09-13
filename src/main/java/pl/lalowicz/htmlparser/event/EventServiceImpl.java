package pl.lalowicz.htmlparser.event;

import org.springframework.stereotype.Service;
import pl.lalowicz.htmlparser.parser.BagatelaTheatreParser;

import java.io.IOException;
import java.util.List;

/**
 * @author radziejoski
 **/
@Service
public class EventServiceImpl implements EventService{

    @Override
    public List<Event> getAllEventsByMonth(int month) throws IOException {
        return BagatelaTheatreParser.getEventsByMonth(month);
    }
}
