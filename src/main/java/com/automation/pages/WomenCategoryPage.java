package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WomenCategoryPage extends Utility {
    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[normalize-space()='Women']")
    WebElement womenTxt;

    @FindBy(xpath = "//a[@title='Tops'][normalize-space()='Tops']")
    WebElement topsLink;

    @FindBy(xpath = "//li[@class='sfHover']//a[@title='Dresses'][normalize-space()='Dresses']")
    WebElement dressesLink;

    @FindBy(xpath = "//select[@id='selectProductSort']")
    WebElement sortByDropDown;

    @FindBy(xpath = "//a[@class='product-name']")
    WebElement productList;


    public void verifyWomenTxt(String text) {
        verifyThatTextIsDisplayed(womenTxt, text);
        CustomListeners.test.log(Status.PASS, "Verify Message: " + text);

    }

    public void selectProduct(String text) {
        clickOnElement(productList);
        CustomListeners.test.log(Status.PASS, "Select product: " + text);

    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@id='block_top_menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS, "Select TopMenu: " + menu);

    }
}

