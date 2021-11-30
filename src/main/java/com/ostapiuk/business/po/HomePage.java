package com.ostapiuk.business.po;

import com.ostapiuk.business.BasePage;
import com.ostapiuk.core.init.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".header .header__logo")
    private WebElement logo;

    @FindBy(css = ".layout .simple-slider")
    private WebElement slider;

    @FindBy(css = "div.premium-button")
    private WebElement premiumButton;

    public boolean isSliderDisplayed() {
        Wait.waitOnElementToBeVisible(slider);
        return slider.isDisplayed();
    }

    public boolean isLogoDisplayed() {
        Wait.waitOnElementToBeVisible(logo);
        return logo.isDisplayed();
    }

    public void clickLogoButton() {
        Wait.waitOnElementToBeClickable(logo);
        logo.click();
    }

    public String getLogoTitleAttribute() {
        Wait.waitOnElementToBeVisible(logo);
        return logo.getAttribute("title");
    }

    public void clickPremiumButton() {
        Wait.waitOnElementToBeClickable(premiumButton);
        premiumButton.click();
    }
}
