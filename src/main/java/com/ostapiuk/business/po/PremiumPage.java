package com.ostapiuk.business.po;

import com.ostapiuk.business.BasePage;
import com.ostapiuk.core.init.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PremiumPage extends BasePage {

    @FindBy(css = "button.premium-cta__purchase")
    private WebElement premiumCTAButton;

    @FindBy(css = ".header .header__logo")
    private WebElement logo;

    public boolean isPremiumCTAButtonDisplayed() {
        Wait.waitOnElementToBeVisible(premiumCTAButton);
        return premiumCTAButton.isDisplayed();
    }

    public void clickLogoButton() {
        Wait.waitOnElementToBeClickable(logo);
        logo.click();
    }
}
