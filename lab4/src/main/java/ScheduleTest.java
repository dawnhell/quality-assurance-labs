import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScheduleTest {
    private Steps steps;

    private final String FROM_CITY           = "FRANKFURT(MAIN)";
    private final String TO_CITY             = "München Hbf";
    private final String SCHEDULE_PAGE_TITLE = "Outward journey on " + new SimpleDateFormat("dd.MM.yy").format(Calendar.getInstance().getTime());

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void performSearch() {
        steps.searchPath(FROM_CITY, TO_CITY);
        Assert.assertTrue(steps.isOnSchedulePage(SCHEDULE_PAGE_TITLE));
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
