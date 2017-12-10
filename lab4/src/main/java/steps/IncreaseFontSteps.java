package steps;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class IncreaseFontSteps {
    public void increaseFont(WebDriver driver, Logger logger) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.increaseFontSize();
    }

    public boolean isCurrentFontSizeLarge(WebDriver driver, Logger logger, int largeFontSize) {
        HomePage homePage = new HomePage(driver);
        return homePage.getLinkCurrentFontSize() == largeFontSize;
    }
}
