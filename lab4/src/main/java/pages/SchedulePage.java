package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchedulePage extends Page {
    private final Logger logger   = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.bahn.com/en/view/offers/index.shtml";

    public SchedulePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @FindBy(id = "js-auskunft-autocomplete-from")
    private WebElement fromInput;

    @FindBy(id = "js-auskunft-autocomplete-to")
    private WebElement toInput;

    @FindBy(className = "js-submit-btn")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//form[@name='formularsort']//div//h2")
    private WebElement title;

    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Schedule page opened");
    }

    public void search(String from, String to) {
        fromInput.sendKeys(from);
        toInput.sendKeys(to);
        buttonSubmit.click();
        logger.info("Search performed");
    }

    public String getTitle() {
        return title.getText().toString();
    }
}
