package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class SignInPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void inIt() {

        homePage = new HomePage();
        signInPage = new SignInPage();
    }
    @Test(groups = {"smoke","regression"})
    public void userShouldNavigateToSignInPageSuccessFully(){
        homePage.clickOnSignInLink();
        signInPage.verifyAuthenticationMsg("Authentication");
    }

    @Test(dataProvider = "invalidCredentials",dataProviderClass = TestData.class,groups = {"sanity","regression"})
    public void verifyTheErrorMessageWithInValidCredentials(String username,String password,String errorMsg){
        homePage.clickOnSignInLink();
        signInPage.enterEmail(username);
        signInPage.enterPassword(password);
        signInPage.clickOnSignInBtn();
        signInPage.verifyErrorMessage(errorMsg);
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        homePage.clickOnSignInLink();
        signInPage.enterEmail("prime256@gmail.com");
        signInPage.enterPassword("Prime456");
        signInPage.clickOnSignInBtn();
        signInPage.verifySignOutLink();
    }

    @Test(groups = {"regression"})
    public void VerifyThatUserShouldLogOutSuccessFully(){
        homePage.clickOnSignInLink();
        signInPage.enterEmail("prime256@gmail.com");
        signInPage.enterPassword("Prime456");
        signInPage.clickOnSignInBtn();
        signInPage.clickOnSignOut();
        signInPage.verifySignInLink();
    }
}
