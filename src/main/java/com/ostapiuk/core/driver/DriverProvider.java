package com.ostapiuk.core.driver;

import com.ostapiuk.core.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class DriverProvider {
    private static WebDriver driver = null;

    private DriverProvider() {
        String type = ConfigProperties.getDriverProperty();
        switch (type) {
            case "chrome":
                driver = DriverProviderFactory.CHROME.create();
                break;
            case "firefox":
                driver = DriverProviderFactory.FIREFOX.create();
                break;
        }
        setTimeout();
    }

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            new DriverProvider();
        }
        return driver;
    }

    public static void quit() {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }

    private static void setTimeout() {
        driver.manage().timeouts().implicitlyWait(ConfigProperties.getImplicitWaitProperty(), TimeUnit.SECONDS)
                .pageLoadTimeout(ConfigProperties.getPageLoadWaitProperty(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
