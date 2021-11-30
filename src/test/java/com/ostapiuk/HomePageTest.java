package com.ostapiuk;

import com.ostapiuk.business.bo.HomePageBOImpl;
import com.ostapiuk.business.bo.HomePageBo;
import com.ostapiuk.core.driver.DriverProvider;
import com.ostapiuk.core.listener.TestListener;
import com.ostapiuk.core.utils.ConfigProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class HomePageTest extends BaseTest {

    private HomePageBo homePageBo;

    @BeforeMethod
    public void initializeFields() {
        DriverProvider.getDriver().get(ConfigProperties.getBaseUrlProperty());
        homePageBo = new HomePageBOImpl();
    }

    @Test(timeOut = 300000)
    public void verifyPageOpening() {
        homePageBo.verifyPageOpening();
    }

    @Test(timeOut = 300000, priority = 1)
    public void verifyHomePageButton() {
        homePageBo.verifyHomePageButton();
    }
}
