package pl.lalowicz.htmlparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Radziejoski
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan("pl.lalowicz.htmlparser")
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
