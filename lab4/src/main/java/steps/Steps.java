package steps;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.SchedulePage;
import pages.SignInPage;

public class Steps {
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver() {
        driver.quit();
    }

    public void signIn(String email, String password) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.open();
        signInPage.login(email, password);
    }

    public boolean isSignedIn(String username) {
        SignInPage signInPage = new SignInPage(driver);
        logger.info(signInPage.getUsername() + " - USERNAME");
        return signInPage.getUsername().equals(username);
    }

    public void searchPath(String from, String to) {
        SchedulePage schedulePage = new SchedulePage(driver);
        schedulePage.open();
        schedulePage.search(from, to);
    }

    public boolean isOnSchedulePage(String title) {
        SchedulePage schedulePage = new SchedulePage(driver);
        logger.info("Title time: " + title);
        return schedulePage.getTitle().equals(title);
    }
}
