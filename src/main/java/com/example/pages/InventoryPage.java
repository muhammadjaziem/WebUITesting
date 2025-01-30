package com.example.pages;

import com.example.utils.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {


    @FindBy(css = ".btn_inventory")
    private WebElement addToCartButton;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(css = ".btn_action")
    private WebElement checkoutButton;

    public InventoryPage() {
        PageFactory.initElements(HelperClass.getDriver(), this);
    }

    public void addItemToCart() {
        addToCartButton.click();
    }

    public void goToCart() {
        cartIcon.click();
    }

    public CheckoutPage checkout() {
        checkoutButton.click();
        return new CheckoutPage();
    }
}
