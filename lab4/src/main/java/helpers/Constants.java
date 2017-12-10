package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Constants {
    private final String USERNAME            = "TomasMirson";
    private final String FAKE_USERNAME       = "asdfkdfj";
    private final String PASSWORD            = "superTest1";
    private final String FAKE_PASSWORD       = "dfljlsadjfk";
    private final String WRONG_SIGH_IN_MSG   = "The user name or password is not valid.";
    private final String NAME                = "Tomas Mirson";
    private final String FROM_CITY           = "FRANKFURT(MAIN)";
    private final String TO_CITY             = "München Hbf";
    private final String SCHEDULE_PAGE_TITLE = "Outward journey on " + new SimpleDateFormat("dd.MM.yy").format(Calendar.getInstance().getTime());
    private final int    LARGE_FONT_HEIGHT   = 19;

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getFAKE_USERNAME() {
        return FAKE_USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getFAKE_PASSWORD() {
        return FAKE_PASSWORD;
    }

    public String getWRONG_SIGH_IN_MSG() {
        return WRONG_SIGH_IN_MSG;
    }

    public String getNAME() {
        return NAME;
    }

    public String getFROM_CITY() {
        return FROM_CITY;
    }

    public String getTO_CITY() {
        return TO_CITY;
    }

    public String getSCHEDULE_PAGE_TITLE() {
        return SCHEDULE_PAGE_TITLE;
    }

    public int getLARGE_FONT_HEIGHT() {
        return LARGE_FONT_HEIGHT;
    }
}
