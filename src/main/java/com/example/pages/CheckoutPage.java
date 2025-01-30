package com.example.pages;

import com.example.utils.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {


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
    }

    public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
        continueButton.click();
    }

    public void completeCheckout() {
        finishButton.click();
    }

    public String isCheckoutComplete() {
        return checkoutCompleteMessage.getText();
    }
}
