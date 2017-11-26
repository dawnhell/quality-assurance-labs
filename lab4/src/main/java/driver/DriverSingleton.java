package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getRootLogger();

    private DriverSingleton() {};

    public static WebDriver getDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            logger.info("Initialized WebDriver. Started Google Chrome Browser.");
        }

        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
