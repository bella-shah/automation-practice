package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.*;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)

public class WomenCategoryPageTest extends TestBase {
        HomePage homePage;
        SignInPage signInPage;
        CreateAccountPage createAccountPage;
        WomenCategoryPage womenCategoryPage;
        ProductPage productPage;

        @BeforeMethod(groups = {"smoke","sanity","regression"})
        public void inIt() {

            homePage = new HomePage();
            signInPage = new SignInPage();
            createAccountPage = new CreateAccountPage();
            womenCategoryPage = new WomenCategoryPage();
            productPage = new ProductPage();
        }

        @Test(groups = {"smoke","regression"})
        public void verifyUserShouldNavigateToWomenCategoryPageSuccessfully(){
            womenCategoryPage.selectMenu("Women");
            womenCategoryPage.verifyWomenTxt("Women");
        }

        @Test(dataProvider = "productData",dataProviderClass = TestData.class,groups = {"sanity","regression"})
        public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String size, String colour){
            womenCategoryPage.selectMenu("Women");
            womenCategoryPage.selectProduct(product);
            productPage.changeQuantity(qty);
            productPage.selectSize(size);
            productPage.selectColour(colour);
            productPage.clickOnAddToCartBtn();
            productPage.verifyPopUpDisplayMsg("Product successfully added to your shopping cart");
            productPage.clickOnCloseBtn();
        }
    }

