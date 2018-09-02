package pl.lalowicz.htmlparser;

import java.io.IOException;
import org.joda.time.LocalDate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Radziejoski
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	LocalDate date = new LocalDate();
    	int month = date.getMonthOfYear();

    	Document doc = Jsoup.connect("https://www.bagatela.pl/repertuar/karmelicka/2018/" + month).get();
        
		Elements ul = doc.select("div.m-content > ul.m-list-spectacles__table");
		Elements li = ul.select("li.m-list-spectacles__row");
		
		System.out.println("Day|Hour|\t\t\tTitle\t\t\t");
		
		for (Element element : li)
		{
			Elements row = element.select("div.m-list-spectacles__cell");
			Elements dateElement = row.select("div.m-list-spectacles__date");

			String dateText = row.select("div.m-list-spectacles__date").text().replaceAll("\\.[^.]*$", "");
			String hour = dateElement.select("span.visible-xs-inline").text();
			String title = row.select("div.m-list-spectacles__title").text();
			
			System.out.println(dateText + "\t\t " + hour + "\t" + title);
		}
		
        
    }
}
