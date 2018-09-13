package pl.lalowicz.htmlparser.parser;

import org.joda.time.LocalDate;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.lalowicz.htmlparser.event.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author radziejoski
 **/
public class BagatelaTheatreParser {
    public static final String BAGATELA_THEATRE_WEB_SITE = "https://www.bagatela.pl/repertuar/karmelicka/";

    private static Document doc;

    public static List<Event> getEventsByMonth(int month) throws IOException
    {
        LocalDate date = new LocalDate();
        int year = date.getYear();

        try
        {
            doc = Jsoup.connect(BAGATELA_THEATRE_WEB_SITE + year + "/" + month).get();
        }
        catch (HttpStatusException ex)
        {
            System.out.println(ex.getStatusCode());
        }

        Elements ul = doc.select("div.m-content > ul.m-list-spectacles__table");
        Elements li = ul.select("li.m-list-spectacles__row");

        ArrayList<Event> events = new ArrayList<>();

        for (Element element : li)
        {
            Elements row = element.select("div.m-list-spectacles__cell");
            Elements dateElement = row.select("div.m-list-spectacles__date");

            String dateText = row.select("div.m-list-spectacles__date").text().replaceAll("\\.[^.]*$", "");
            String hour = dateElement.select("span.visible-xs-inline").text();
            String title = row.select("div.m-list-spectacles__title").text();

            events.add(new Event(title, dateText, hour));
        }

        return events;
    }
}
