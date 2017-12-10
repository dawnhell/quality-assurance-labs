package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {
    private final Logger logger   = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.bahn.com/en/view/index.shtml";

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @FindBy(css = "a.font-xl")
    private WebElement largeFontSizeBtn;

    @FindBy(css = "ul#service-nav li a.first span")
    private WebElement serviceNavLink;

    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Home page opened");
    }

    public void increaseFontSize() {
        largeFontSizeBtn.click();
    }

    public int getLinkCurrentFontSize() {
        logger.info("Current font size: " + serviceNavLink.getSize().height);
        return serviceNavLink.getSize().height;
    }
}
