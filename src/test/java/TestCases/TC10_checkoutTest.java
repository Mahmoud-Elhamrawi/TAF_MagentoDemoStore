package TestCases;

import Pages.P06_CartPage;
import Pages.P10_checkoutPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TC10_checkoutTest extends TestBase{

    P06_CartPage cartPage ;
    P10_checkoutPage checkoutPage ;
    SoftAssert softAssert = new SoftAssert();



    @Test
    public void checkoutProcess() throws InterruptedException {
        //selProd & add to cart
        cartPage = new P06_CartPage(driver);
        cartPage.goToMobilePage();

        softAssert.assertTrue(driver.getCurrentUrl().contains("mobile.html"));
        softAssert.assertEquals(cartPage.titleAssert().getText() ,"MOBILE");

        //add to cart
        cartPage.prdoSele();
        softAssert.assertEquals(cartPage.assertNameOfProd().getText() , "SONY XPERIA");
        cartPage.cartBtn();
        softAssert.assertEquals(cartPage.assertTit().getText() , "Sony Xperia was added to your shopping cart.");

       //checkout
        checkoutPage = new P10_checkoutPage(driver);
        checkoutPage.goToCheck();

        softAssert.assertTrue(driver.getCurrentUrl().contains("checkout/onepage/"));

        checkoutPage.login("moaaz16@gmail.com","1234567");

        //billing info
        softAssert.assertEquals(checkoutPage.aseertBillInf().getText(),"BILLING INFORMATION");

        checkoutPage.fillBillingInfo("bston","losangulas","egypt","252525","01278385814");

        Thread.sleep(3000);
        //shipMth
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.assertShipBox()));
        checkoutPage.shipMethodCont();
        Thread.sleep(3000);
        //payInfo
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.assertPayBox()));
        checkoutPage.paymentMeth();
        checkoutPage.paymentMethCont();
        Thread.sleep(3000);

        //placeOrder

        wait.until(ExpectedConditions.visibilityOf(checkoutPage.assertPlaceBox()));
        checkoutPage.placeOrd();
        Thread.sleep(3000);
        //assertOrder
        softAssert.assertEquals(checkoutPage.assert1().getText(), "YOUR ORDER HAS BEEN RECEIVED.");
        softAssert.assertEquals(checkoutPage.assert2().getText(), "THANK YOU FOR YOUR PURCHASE!");

















        softAssert.assertAll();
    }

}
