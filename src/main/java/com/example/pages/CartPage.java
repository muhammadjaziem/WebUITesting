package com.example.pages;

import com.example.utils.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {


    @FindBy(css = ".btn_action")
    private WebElement checkoutButton;

    public CartPage() {
        PageFactory.initElements(HelperClass.getDriver(), this);
    }

}
