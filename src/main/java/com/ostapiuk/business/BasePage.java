package com.ostapiuk.business;

import com.ostapiuk.core.driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver webDriver;

    public BasePage() {
        webDriver = DriverProvider.getDriver();
        PageFactory.initElements(webDriver, this);
    }
}
