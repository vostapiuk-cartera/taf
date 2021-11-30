package com.ostapiuk.business.bo;

import com.google.inject.Guice;
import com.ostapiuk.business.po.HomePage;
import com.ostapiuk.business.po.PremiumPage;
import com.ostapiuk.core.driver.DriverProvider;
import com.ostapiuk.core.utils.ConfigProperties;
import com.ostapiuk.core.logger.Log;
import org.testng.Assert;

import javax.inject.Inject;

public class HomePageBOImpl implements HomePageBo {
    @Inject
    private HomePage homePage;

    @Inject
    private PremiumPage premiumPage;

    public void setUp() {
        Guice.createInjector().injectMembers(this);
    }

    @Override
    public void verifyPageOpening() {
        setUp();
        Log.log("Verify slider is displayed on Home page");
        Assert.assertTrue(homePage.isSliderDisplayed(), "Slider is not displayed");
        Log.log("Verify title on Home page");
        String expectedTitle = ConfigProperties.getExpectedTitleProperty();
        Assert.assertTrue(homePage.getLogoTitleAttribute().contains(expectedTitle), "Title is not correct, expected is " + expectedTitle);
    }

    @Override
    public void verifyHomePageButton() {
        setUp();
        Log.log("Navigate to Premium page");
        homePage.clickPremiumButton();
        Log.log("Verify navigation to Premium page was done correctly");
        String expectedPremiumUrl = ConfigProperties.getExpectedPremiumUrlProperty();
        Assert.assertTrue(premiumPage.isPremiumCTAButtonDisplayed(), "Button is not displayed");
        Assert.assertTrue(DriverProvider.getDriver().getCurrentUrl().contains(expectedPremiumUrl), "Premium url is not correct, expected is " + expectedPremiumUrl);
        Log.log("Navigate to Home page by clicking logo");
        premiumPage.clickLogoButton();
        Log.log("Verify click on logo navigates to Home page");
        String expectedBaseUrl = ConfigProperties.getBaseUrlProperty();
        Assert.assertTrue(homePage.isSliderDisplayed(), "Slider is not displayed");
        Assert.assertEquals(expectedBaseUrl, DriverProvider.getDriver().getCurrentUrl(), "Url is not correct, expected is " + expectedBaseUrl);
    }
}
