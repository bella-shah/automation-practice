package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class CreateAccountPageTest extends TestBase {

    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;

    @BeforeMethod(groups = {"smoke", "sanity", "regression"})
    public void inIt() {

        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        homePage.clickOnSignInLink();
        signInPage.enterEmailCreate(getRandomEmail());
        signInPage.clickOnCreateAccountBtn();
        createAccountPage.enterFirstName("Bella");
        createAccountPage.enterLastName("Shah");
        createAccountPage.enterPassword("Bella123");
        createAccountPage.enterFirstNameField("Bella");
        createAccountPage.enterLastNameField("Shah");
        createAccountPage.enterAddress("54 Stocklake");
        createAccountPage.enterCity("london");
        createAccountPage.selectState("Buckinghamshire");
        createAccountPage.enterZipCode("90936");
        createAccountPage.enterPhoneNumber("12345678976");
        createAccountPage.enterReference("House");
        createAccountPage.clickOnRegisterBtn();
    }
}

