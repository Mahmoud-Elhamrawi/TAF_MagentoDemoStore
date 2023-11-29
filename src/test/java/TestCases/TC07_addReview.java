package TestCases;

import Pages.P06_CartPage;
import Pages.P07_addReview;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC07_addReview extends TestBase{
    P06_CartPage cartPage ;
    P07_addReview addReview ;
    SoftAssert softAssert = new SoftAssert();
   @Test
    public void addReview()
    {
        //go to mobie page
        cartPage = new P06_CartPage(driver);
        cartPage.goToMobilePage();

        softAssert.assertTrue(driver.getCurrentUrl().contains("mobile.html"));
        softAssert.assertEquals(cartPage.titleAssert().getText() ,"MOBILE");

        //select prod
        cartPage.prdoSele();
        softAssert.assertEquals(cartPage.assertNameOfProd().getText() , "SONY XPERIA");


         //add review
        addReview = new P07_addReview(driver);
        addReview.goToAddReviewPage();
        softAssert.assertTrue(driver.getCurrentUrl().contains("#review-form"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,90)");

        addReview.radioBtn().get(2).click();
        addReview.fillingReviewForm("bad item" ,"doesn't work","to be smooth");

        softAssert.assertEquals(addReview.assertOnAddReview().getText() , "Your review has been accepted for moderation.");








    }





}
