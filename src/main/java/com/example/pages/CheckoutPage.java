package com.example.pages;

import com.example.utils.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {

    private WebDriverWait wait;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(css = ".btn_primary")
    private WebElement continueButton;

    @FindBy(css = ".btn_action")
    private WebElement finishButton;

    @FindBy(css = "span.title[data-test='title']")
    private WebElement checkoutCompleteMessage;

    public CheckoutPage() {
        PageFactory.initElements(HelperClass.getDriver(), this);
        wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
    }

    public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void completeCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

    public String isCheckoutComplete() {
        return wait.until(ExpectedConditions.visibilityOf(checkoutCompleteMessage)).getText();
    }
}
