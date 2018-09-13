package pl.lalowicz.htmlparser.event;

import java.io.IOException;
import java.util.List;

public interface EventService {
    List<Event> getAllEventsByMonth(int month) throws IOException;
}
