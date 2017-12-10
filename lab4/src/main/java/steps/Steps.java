package steps;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Steps {
    private WebDriver         driver;
    private final Logger      logger = LogManager.getRootLogger();
    private SignInSteps       signInSteps;
    private ScheduleSteps     scheduleSteps;
    private IncreaseFontSteps increaseFontSteps;

    public void initBrowser() {
        driver            = DriverSingleton.getDriver();
        signInSteps       = new SignInSteps();
        scheduleSteps     = new ScheduleSteps();
        increaseFontSteps = new IncreaseFontSteps();
    }

    public void closeDriver() {
        driver.quit();
    }

    public void signIn(String email, String password) {
        signInSteps.signIn(driver, logger, email, password);
    }

    public boolean isSignedIn(String username) {
        return signInSteps.isSignedIn(driver, logger, username);
    }

    public void signInWithError(String email, String password) {
        signInSteps.signInWithError(driver, logger, email, password);
    }

    public boolean isErrorInSignIn(String errorMsg) {
        return signInSteps.isErrorInSignIn(driver, logger, errorMsg);
    }

    public void searchPath(String from, String to) {
        scheduleSteps.searchPath(driver, logger, from, to);
    }

    public boolean isOnSchedulePage(String title) {
        return scheduleSteps.isOnSchedulePage(driver, logger, title);
    }

    public void increaseFontSize() {
        increaseFontSteps.increaseFont(driver, logger);
    }

    public boolean isCurrentFontSizeLarge(int largeFontSize) {
        return increaseFontSteps.isCurrentFontSizeLarge(driver, logger, largeFontSize);
    }
}
