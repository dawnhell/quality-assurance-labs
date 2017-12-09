import helpers.Constants;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.Steps;

public class TestRunner {
    private Steps steps;
    private Constants constants;

    @BeforeSuite()
    public void initialization() {
        steps = new Steps();
        constants = new Constants();
    }

    @BeforeTest(description = "Initialize browser")
    public void setUp() {
        steps.initBrowser();
    }

    @Test
    public void performSignIn() {
        steps.signIn(constants.getUSERNAME(), constants.getPASSWORD());
        Assert.assertTrue(steps.isSignedIn(constants.getNAME()));
    }

    @Test
    public void performSignInWithError() {
        steps.signInWithError(constants.getFAKE_USERNAME(), constants.getFAKE_PASSWORD());
        Assert.assertTrue(steps.isErrorInSignIn(constants.getWRONG_SIGH_IN_MSG()));
    }

    @Test
    public void performSearch() {
        steps.searchPath(constants.getFROM_CITY(), constants.getTO_CITY());
        Assert.assertTrue(steps.isOnSchedulePage(constants.getSCHEDULE_PAGE_TITLE()));
    }

    @AfterTest(description = "Stop browser")
    public void stopBrowser() {
        steps. closeDriver();
    }
}
