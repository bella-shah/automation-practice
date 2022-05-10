package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utility {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "quantity_wanted")
    WebElement quantity;

    @FindBy(id = "group_1")
    WebElement size;

    @FindBy(className = "attribute_list")
    WebElement colour;

    @FindBy(xpath = "//button[@name='Submit']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement popUpDisplay;

    @FindBy(xpath = "//span[@title='Close window']")
    WebElement closeBtn;

    public void clickOnCloseBtn() {
        clickOnElement(closeBtn);
        CustomListeners.test.log(Status.PASS, "Click on closeBtn");

    }

    public void verifyPopUpDisplayMsg(String text) {
        verifyThatTextIsDisplayed(popUpDisplay, text);
        CustomListeners.test.log(Status.PASS, "Verify Message: " + text);

    }

    public void clickOnAddToCartBtn() {
        clickOnElement(addToCartBtn);
        CustomListeners.test.log(Status.PASS, "Click on addToCartBtn");

    }

    public void selectColour(String color) {
        clickOnElement(colour);
    }

    public void selectSize(String text) {
        selectByVisibleTextFromDropDown(size, text);
        CustomListeners.test.log(Status.PASS, "Select size " + text);

    }

    public void changeQuantity(String num) {
        sendKeysToElement(quantity, Keys.BACK_SPACE + num);
        CustomListeners.test.log(Status.PASS, "Change Quantity " + num);

    }

}

