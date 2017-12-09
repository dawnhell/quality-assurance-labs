package steps;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.SignInPage;

public class SignInSteps {
    public void signIn(WebDriver driver, Logger logger, String email, String password) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.open();
        signInPage.login(email, password);
        logger.info("Logging in with credentials: email: " + email + ", pass: " + password);
    }

    public void signInWithError(WebDriver driver, Logger logger, String email, String password) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.open();
        signInPage.login(email, password);
        logger.info("Error logging in.");
    }

    public boolean isSignedIn(WebDriver driver, Logger logger, String username) {
        SignInPage signInPage = new SignInPage(driver);
        logger.info(signInPage.getUsername() + " - USERNAME");
        return signInPage.getUsername().equals(username);
    }

    public boolean isErrorInSignIn(WebDriver driver, Logger logger, String errorMsg) {
        SignInPage signInPage = new SignInPage(driver);
        logger.info("Getting error message: " + signInPage.getErrorMsg());
        return signInPage.getErrorMsg().equals(errorMsg);
    }
}
