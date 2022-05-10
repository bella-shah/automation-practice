package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignInPage extends Utility {
    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Authentication']")
    WebElement authenticationMsg;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "email_create")
    WebElement newEmail;

    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement createAccountBtn;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    WebElement signInbtn;
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOutLink;

    @FindBy(xpath = "//body/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[1]")
    WebElement verifyMsg;

    public void clickOnCreateAccountBtn(){
        clickOnElement(createAccountBtn);
        CustomListeners.test.log(Status.PASS, "Click on createAccountBtn");

    }
    public void verifySignOutLink(){
        verifyThatElementIsDisplayed(signOutLink);
        CustomListeners.test.log(Status.PASS, "Verify Message: signOutLink");

    }

    public void enterEmailCreate(String email){
        sendTextToElement(newEmail,email);
        CustomListeners.test.log(Status.PASS, "Enter email " + email);

    }


    public void verifySignInLink(){
        verifyThatElementIsDisplayed(signInbtn);
        CustomListeners.test.log(Status.PASS, "Verify sign in link " );

    }

    public void clickOnSignOut(){
        clickOnElement(signOutLink);
        CustomListeners.test.log(Status.PASS, "Click on signOutLink");

    }

    public void verifyErrorMessage(String errorMsg) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//body/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[1]"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(errorMsg)) {
                break;
            }
        }
        CustomListeners.test.log(Status.PASS, "Verify error message: " + errorMsg);

    }
    public void enterEmail(String text){
        sendTextToElement(emailField,text);
        CustomListeners.test.log(Status.PASS, "Enter Email " + text);

    }

    public void enterPassword(String text){
        sendTextToElement(passwordField,text);
        CustomListeners.test.log(Status.PASS, "Enter password " + text);

    }
    public void clickOnSignInBtn(){
        clickOnElement(signInbtn);
        CustomListeners.test.log(Status.PASS, "Click on signInbtn");

    }

    public void verifyAuthenticationMsg(String text){
        verifyThatTextIsDisplayed(authenticationMsg,text);
        CustomListeners.test.log(Status.PASS, "Verify Authentication Message: " + text);

    }
}
