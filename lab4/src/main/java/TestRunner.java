import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;
import steps.Steps;

public class TestRunner {
    private Steps steps;
    private final String USERNAME = "TomasMirson";
    private final String PASSWORD = "superTest1";
    private final String NAME     = "Tomas Mirson";

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void performSignIn() {
        steps.signIn(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isSignedIn(NAME));
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
