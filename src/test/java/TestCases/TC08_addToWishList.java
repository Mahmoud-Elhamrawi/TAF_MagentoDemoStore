package TestCases;

import Pages.P00_HomePage;
import Pages.P03_LoginPage;
import Pages.P06_CartPage;
import Pages.P08_addToWishList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TC08_addToWishList extends TestBase{

    P08_addToWishList addToWishList ;
    SoftAssert softAssert =new SoftAssert() ;
    P00_HomePage homePage ;
    P03_LoginPage loginPage ;
    P06_CartPage cartPage ;


    @Test
    public void addToWishList(){

        //navigate to login
        homePage = new P00_HomePage(driver);
        homePage.clickOnAccount();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.headerAccountVisiable()));
        homePage.clickONLoginLink();
        softAssert.assertTrue(driver.getCurrentUrl().contains("customer/account/login/"));


        //in login
        loginPage = new P03_LoginPage(driver);
        loginPage.loginSteps("mosha1@gmail.com","1234567");
        softAssert.assertEquals("MY DASHBOARD",loginPage.assertTit().getText());
        softAssert.assertEquals("Hello, mosha mosha mosha!" ,loginPage.assertOnWelMsg().getText());

        //go to mobie page
        cartPage = new P06_CartPage(driver);
        cartPage.goToMobilePage();

        softAssert.assertTrue(driver.getCurrentUrl().contains("mobile.html"));
        softAssert.assertEquals(cartPage.titleAssert().getText() ,"MOBILE");

        //select prod
        cartPage.prdoSele();
        softAssert.assertEquals(cartPage.assertNameOfProd().getText() , "SONY XPERIA");

        //add to wish list

        addToWishList = new P08_addToWishList(driver);
        addToWishList.goToWishList();
        softAssert.assertTrue(addToWishList.assertMsgWishList().getText().contains("Sony Xperia has been added to your wishlist"));



        //edit wishlist
        addToWishList.clickOnEditWishList();
        wait.until(ExpectedConditions.visibilityOf(addToWishList.waitProdShop()));
        addToWishList.editQuenty();

        softAssert.assertTrue(addToWishList.assertUpdateMsg().getText().contains("Sony Xperia has been updated in your wishlist"));



        //delete wishlist
        addToWishList.delWishList();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
         //Alert alert = driver.switchTo().alert();
          alert.accept();

           softAssert.assertTrue(addToWishList.assertEmptyWish().getText().contains("You have no items in your wishlist"));


    }




}
