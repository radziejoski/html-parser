package pl.lalowicz.htmlparser.event;

/**
 * @author radziejoski
 **/
public class Event {
    private String eventName;
    private String eventDate;
    private String hour;

    public Event(String eventName, String eventDate, String hour) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.hour = hour;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
