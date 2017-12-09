package steps;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.SchedulePage;

public class ScheduleSteps {
    public void searchPath(WebDriver driver, Logger logger, String from, String to) {
        SchedulePage schedulePage = new SchedulePage(driver);
        schedulePage.open();
        schedulePage.search(from, to);
        logger.info("Searching path from: " + from + " to: " + to);
    }

    public boolean isOnSchedulePage(WebDriver driver, Logger logger, String title) {
        SchedulePage schedulePage = new SchedulePage(driver);
        logger.info("Title time: " + title);
        return schedulePage.getTitle().equals(title);
    }
}
