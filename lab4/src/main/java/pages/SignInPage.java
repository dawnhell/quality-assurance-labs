package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Page {
    private final Logger logger   = LogManager.getRootLogger();
    private final String BASE_URL = "https://fahrkarten.bahn.de/cache/start/start.post?lang=en&scope=login#stay";

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @FindBy(id = "login-input-loginname")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "button.weiter")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//p[@class='nobottommargin']//span")
    private WebElement userName;

    @FindBy(className = "errormsg")
    private WebElement errorMsg;

    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Sign In page opened");
    }

    public void login(String username, String password) {
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        logger.info("Sign In performed");
    }

    public String getErrorMsg() {
        return errorMsg.getText();
    }

    public String getUsername() {
        return userName.getText();
    }
}
