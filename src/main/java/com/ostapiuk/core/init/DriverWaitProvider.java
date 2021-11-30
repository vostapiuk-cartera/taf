package com.ostapiuk.core.init;

import com.ostapiuk.core.driver.DriverProvider;
import com.ostapiuk.core.utils.ConfigProperties;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWaitProvider {
    private static WebDriverWait webDriverWait;
    private static final int EXPLICIT_WAIT = ConfigProperties.getExplicitWait();

    private DriverWaitProvider() {
        webDriverWait = new WebDriverWait(DriverProvider.getDriver(), EXPLICIT_WAIT);
    }

    public static WebDriverWait getInstance() {
        if (webDriverWait == null) {
            new DriverWaitProvider();
        }
        return webDriverWait;
    }
}
